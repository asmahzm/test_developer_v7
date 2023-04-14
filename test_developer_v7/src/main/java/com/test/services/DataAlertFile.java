package com.test.services;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.springframework.stereotype.Service;

@Service
public class DataAlertFile {
	
	public static void main(String[] args) {
		
//        String filePath = "/input/Data Alert.txt";		// server test
        String filePath = "D:\\input\\Data Alert.txt";	// local test
		
        String inst_param1 = "BNI";				// parameterized for output message
        String output1 = generateOutputMessage(filePath, inst_param1);
		System.out.println(output1);
		
		String inst_param2 = "MDR";
		String output2 = generateOutputMessage(filePath, inst_param2);
        System.out.println(output2);
    }

    public static String generateOutputMessage(String filePath, String institution) {
	
		// generate output message parameterized by institution
        StringBuilder message = new StringBuilder();
        message.append("Selamat Siang Rekan Bank ").append(institution).append("\n\n");
        message.append("Mohon bantuan untuk Sign on pada envi berikut :\n\n");

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] fields = line.split(";");
                if (fields[0].equals(institution) && fields[4].equals("Offline")) {
                    message.append("- Envi MP Port ").append(fields[2]).append(" terpantau Offline\n");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }

        message.append("\nTerima Kasih");
		
		// send output message to its institution as file
//		String outputFilePath = "/output/" + institution + ".txt";	// server test
		String outputFilePath = "D:\\output\\" + institution + ".txt";	// local test
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFilePath))) {
			writer.write(message.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
	
        return message.toString();
    }
}
