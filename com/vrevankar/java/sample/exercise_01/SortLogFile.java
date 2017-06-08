package com.vrevankar.java.sample.exercise_01;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Vinay on 6/7/17.
 */
public class SortLogFile {

    public static void main(String ... args) throws IOException {

        System.out.print("Input file Path: ");
        String inputFile = new Scanner(System.in).nextLine();
        if(!new File(inputFile).exists()){
            System.err.println("Input file not found, " + inputFile);
            return;
        }

        System.out.print("Output file Location: ");
        String outputFile = new Scanner(System.in).nextLine();
        if(!new File(outputFile).exists()){
            System.err.println("Output file directory doesn't exist, " + outputFile);
            return;
        }

        SortLogFile sort = new SortLogFile();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSSZ");
        LocalDateTime time1;

        BufferedReader dataReader, dataReader2;
        String inputLine, inputLine2;
        dataReader = new BufferedReader(new FileReader(inputFile));

        BufferedWriter offsetWriter;
        offsetWriter = new BufferedWriter(new FileWriter(outputFile + "/log.txt"));

        String[] words, words1, words2;
        int rowcount = 0;
        while((inputLine = dataReader.readLine()) != null) {
            ++rowcount;
            words1 = inputLine.split("] \\[");
            int index1 = sort.getIndex(words1[2]);
            time1 = LocalDateTime.parse(words1[0].substring(1), formatter);

            LocalDateTime time = time1;
            words = words1;

            dataReader2 = new BufferedReader(new FileReader(inputFile));
            for(int count=0; count++<rowcount; ) inputLine2 = dataReader2.readLine();
            while ((inputLine2 = dataReader2.readLine()) != null) {

                words2 = inputLine2.split("] \\[");
                int index2 = sort.getIndex(words2[2]);
                LocalDateTime time2 = LocalDateTime.parse(words2[0].substring(1), formatter);
                if (time.isAfter(time2) || time1.equals(time2) && index1 > index2) {
                    words = words2;
                    time = time2;
                }
            }
//            System.out.println(" >>>> " + Arrays.toString(words));
            offsetWriter.write(Arrays.toString(words));
            offsetWriter.newLine();

            

            dataReader2.close();

        }

        dataReader.close();
        offsetWriter.close();

    }

    private int getIndex(String severity){
        switch(severity){
            case "ERROR": return 1;
            case "WARN":  return 2;
            case "INFO":  return 3;
            default:      return 99;
        }
    }

}
