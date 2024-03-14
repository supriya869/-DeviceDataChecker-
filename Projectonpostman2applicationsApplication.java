package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


import com.example.service.DataModelService;

import java.util.Scanner;

@SpringBootApplication
public class Projectonpostman2applicationsApplication implements CommandLineRunner {

    @Autowired
    private DataModelService dataModelService;

    public static void main(String[] args) {
        SpringApplication.run(Projectonpostman2applicationsApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        // Prompt user for input
        System.out.println("Enter Device ID:");
        int deviceId;
        while (!scanner.hasNextInt()) {
            System.out.println("Invalid input. Please enter a valid integer for Device ID:");
            scanner.next(); // Consume invalid input
        }
        deviceId = scanner.nextInt();
        scanner.nextLine(); // Consume newline character
        
        // Prompt user for input
        System.out.println("Enter Name:");
        String name = scanner.nextLine();
        
        // Prompt user for input
        System.out.println("Enter Password:");
        String password = scanner.nextLine();

        boolean exists = dataModelService.checkExistence(deviceId, name, password);
        if (exists) {
            System.out.println("Data exists for Device ID: " + deviceId + ", Name: " + name + ", Password: " + password);
        } else {
            System.out.println("Data does not exist for Device ID: " + deviceId + ", Name: " + name + ", Password: " + password);
        }
        
        scanner.close();
    }
}
