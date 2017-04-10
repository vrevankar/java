package com.vrevankar.java.sample.file;

import java.io.*;
import java.util.Queue;
import java.util.Scanner;
import java.util.concurrent.*;
import java.nio.file.Files;
import java.nio.file.FileSystems;

/**
 * Created by vrevankar on 4/10/17.
 */
public class FileIO {

    public static void main(String[] args) throws IOException, ExecutionException, InterruptedException, ClassNotFoundException {
        FileIO fileIO = new FileIO();
        if(!fileIO.validateArgs(args)) return;
        String inputFile = args[0];
        int batchSize = Integer.parseInt(args[1]);
        BufferedReader dataReader;
        Queue<String> dataQ = new ArrayBlockingQueue<>(batchSize);
        String offsetFile = fileIO.generateFileName(inputFile, "offset");
        BufferedWriter offsetWriter;
        String inputLine;
        dataReader = new BufferedReader(new FileReader(inputFile));

        // Check for offset
        int offset = fileIO.getOffset(offsetFile);

        String outputFile = fileIO.generateFileName(inputFile, "output");

        // Delete output.txt if exists and offset.txt doesn't exist
        if(offset == 0 && new File(outputFile).exists()) new File(outputFile).delete();

        offsetWriter = new BufferedWriter(new FileWriter(offsetFile));

        // Set the pointer to the offset
        for(int k=0; k<offset; ++k, dataReader.readLine());

        while((inputLine = dataReader.readLine()) != null) {

            // Copy data into Queue
            dataQ.add(inputLine);
            for (int k = 0; k < batchSize-1 && (inputLine = dataReader.readLine()) != null; ++k) dataQ.add(inputLine);

            // Move data from Queue to Output file
            Callable<Void> writerTask = () -> {
                BufferedWriter dataWriter = null;
                try {
                    dataWriter = new BufferedWriter(new FileWriter(fileIO.generateFileName(inputFile, "output"), true));
                    while (!dataQ.isEmpty()) dataWriter.write(dataQ.remove() + "\n");
                } catch (IOException ioExc) {
                    System.err.println("IO Exception while writing to output.txt");
                } finally {
                    try {
                        assert dataWriter != null;
                        dataWriter.close();
                    } catch (IOException ioe) {
                        System.err.println("IO Exception while closing output.txt");
                    }
                }
                return null;
            };
            ExecutorService executor = Executors.newFixedThreadPool(1);
            Future<Void> future = executor.submit(writerTask);
            future.get();
            executor.shutdown();

            // Save offset into offset.txt
            offset += batchSize;
            offsetWriter = new BufferedWriter(new FileWriter(offsetFile));
            offsetWriter.write(String.valueOf(offset));
            offsetWriter.close();

        }
        dataReader.close();
        offsetWriter.close();
        Files.delete(FileSystems.getDefault().getPath(offsetFile));
        System.out.println("Output file successfully generated.");

    }

    // Validate input arguments
    private boolean validateArgs(String[] args) throws ClassNotFoundException {
        if (args.length < 2){
            System.err.println("Error, invalid execution");
            System.out.println("Usage: " + Class.forName(FileIO.class.getName()).toString().replaceAll("class ", "java ") + " <input_file> <batch_size>\n");
            return false;
        }
        if(!new File(args[0]).exists()){
            System.err.println("Error, invalid execution. First argument should be a valid file path.");
            return false;
        }
        if(!args[1].chars().allMatch(Character::isDigit)){
            System.err.println("Error, invalid execution. Second argument should be a whole number.");
            return false;
        }
        return true;
    }

    // Generate Output/Offset filepath
    private String generateFileName(String filename, String type){
        return String.format("%s%s%s.txt", FileSystems.getDefault().getPath(filename).getParent(), File.separator, type);
    }

    // Return offset from offset.txt if file exists
    private int getOffset(String offsetFile) throws IOException{
        if(new File(offsetFile).exists()){
            String offsetStr = new Scanner(new File(offsetFile)).next();
            if(offsetStr.chars().allMatch(Character::isDigit)) return Integer.parseInt(offsetStr);
        }
        return 0;
    }

}

