package com.vrevankar.java.sample.exercise_01;

import java.io.*;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * Created by Vinay on 6/8/17.
 */
public class ExternalSort implements Comparator<StringBuilder> {

    final int FILE_SIZE = 2000000;
    final int MAX_ITEMS = 100000;
    final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSSZ");

    public void sort(String fileName, String outputFile) throws IOException {
        String tmpFile = "temp-file-";
        StringBuilder[] buffer = new StringBuilder[MAX_ITEMS < FILE_SIZE ? MAX_ITEMS : FILE_SIZE];

            FileReader fileReader = new FileReader(fileName);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            int slices = (int) Math.ceil((double) FILE_SIZE / MAX_ITEMS);

            for (int i = 0, j = 0; i < slices; ++i) {
                for (j = 0; j < (MAX_ITEMS < FILE_SIZE ? MAX_ITEMS : FILE_SIZE); ++j) {
                    String builder;
                    if ((builder = bufferedReader.readLine()) != null) {
                        buffer[j] = new StringBuilder(builder.toString()
                            .replaceAll("[ERROR]", "[0]")
                            .replaceAll("[WARN]",  "[1]")
                            .replaceAll("[INFO]",  "[2]")
                        );
                    }
                    else break;
                }
                Arrays.sort(buffer);
                FileWriter fileWriter = new FileWriter(tmpFile + Integer.toString(i) + ".txt");
                PrintWriter printWriter = new PrintWriter(fileWriter);
                for (int k = 0; k < j; ++k)
                    printWriter.println(
                        buffer[k].toString()
                            .replaceAll("[0]", "[ERROR]")
                            .replaceAll("[1]", "[WARN]")
                            .replaceAll("[2]", "[INFO]")
                    );
                printWriter.close();
                fileWriter.close();
            }

            bufferedReader.close();
            fileReader.close();

            int[] topNums = new int[slices];
            BufferedReader[] bufferedReaders = new BufferedReader[slices];

            for (int i = 0; i < slices; ++i) {
                bufferedReaders[i] = new BufferedReader(new FileReader(tmpFile + Integer.toString(i) + ".txt"));
                StringBuilder builder;
                if ((builder = new StringBuilder(bufferedReaders[i].readLine())) != null) topNums[i] = Integer.parseInt(builder.toString());
                else topNums[i] = Integer.MAX_VALUE;
            }
            FileWriter fileWriter = new FileWriter(outputFile);
            PrintWriter printWriter = new PrintWriter(fileWriter);

            for (int i = 0; i < FILE_SIZE; ++i) {
                int min = topNums[0];
                int minFile = 0;
                for (int j = 0; j < slices; ++j) {
                    if (min > topNums[j]) {
                        min = topNums[j];
                        minFile = j;
                    }
                }

                printWriter.println(min);
                String builder;
                if ((builder = bufferedReaders[minFile].readLine()) != null) topNums[minFile] = Integer.parseInt(builder);
                else topNums[minFile] = Integer.MAX_VALUE;
            }
            for (int i = 0; i < slices; i++) bufferedReaders[i].close();
            printWriter.close();
            fileWriter.close();

    }

    public static void main(String[] args) throws IOException {

        System.out.print("Input File Path: ");
        String inputFilePath = new Scanner(System.in).nextLine();
        if(!new File(inputFilePath).exists()){
            System.err.println("Input File not found, " + inputFilePath);
            return;
        }

        System.out.print("Output Directory Path: ");
        String outputPath = new Scanner(System.in).nextLine();
        if(!new File(outputPath).exists()){
            System.err.println("Output Directory doesn't exist, " + outputPath);
            return;
        }

        new ExternalSort().sort(inputFilePath, outputPath);

    }

    @Override
    public int compare(StringBuilder builder1, StringBuilder builder2) {
        return builder1.toString().compareTo(builder2.toString());
    }

}

