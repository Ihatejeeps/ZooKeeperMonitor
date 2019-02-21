/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zoo.monitoring.system;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

        
/**
 * @author Paul Hale
 */
public class ZooMonitoringSystem {
     /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        int userInput = 0;
        Scanner scnr = new Scanner(System.in);
        Scanner animalInfo = null;
        int infoInput = 0;
        FileInputStream zooFile = null;
        String animalString = " ";
        Scanner habitatInfo = null;
        String habitatString = " ";
        Scanner animalDetails = null;
        Scanner habitatDetails = null;
        int i = 0;
        boolean infoFound = false;
        
        
        //Prompts the user to enter animal, habitat, or to exit the program
        while (userInput != 3){
            System.out.println("Do you want to monitor an animal, habitat, or exit the program?");
            System.out.println("1. Animals ");
            System.out.println("2. Habitat ");
            System.out.println("3. Exit the Program");
            userInput = scnr.nextInt();
            System.out.println();
            
            // start of animal selection
            if (userInput == 1){
                zooFile = new FileInputStream("animals.txt");
                animalInfo = new Scanner(zooFile);
                System.out.println("Which animal are you monitoring?");
                i = 0;
                while(animalInfo.hasNextLine()) {
                    String animalLine = animalInfo.nextLine();
                    if (animalLine.contains("Details")) {
                        i++;
                        System.out.println(i + ". " + animalLine);
                    }
                }
                zooFile.close();
                
                //Getting the infomation for the selected animal
                
                infoInput = scnr.nextInt();
                System.out.println();
                zooFile = new FileInputStream("animals.txt");
                animalDetails = new Scanner(zooFile);
                i = 0;
                while (animalDetails.hasNextLine()) {
                    animalString = animalDetails.nextLine();
                    if(animalString.contains("Animal")){
                        i++;
                    }
                    if (i == infoInput) {
                        infoFound = true;
                        // looking for an alert and notifying user if there is an alert
                        if (animalString.contains("*****")){
                            String alert = animalString.substring(5, animalString.length());
                            int len = alert.length()+12;
                            for (int j = 0; j < len; j++){
                                System.out.print("!");
                            }
                            System.out.println();
                            System.out.println("! Caution " + alert + " !");
                            for (int j = 0; j < len; j++){
                                System.out.print("!");
                            }
                            System.out.println();
                        }
                        else if (!animalString.isEmpty()){
                            System.out.println(animalString);
                        }
                    }
                }
                // if no info is found for the animal selected
                if (infoFound == false){
                    System.out.println("INVALID, PLEASE TRY AGAIN.");
                }
                zooFile.close();
                System.out.println();
            }
            // Start of habitat selection
            else if (userInput == 2){
                zooFile = new FileInputStream("habitats.txt");
                habitatInfo = new Scanner(zooFile);
                System.out.println("Which Habitat are you monitoring?");
                i = 0;
                while(habitatInfo.hasNextLine()){
                    habitatString = habitatDetails.nextLine();
                    if (habitatString.contains("Details")){
                        i++;
                        System.out.println(i + ". " +habitatString);
                    }
                }
                zooFile.close();
                infoInput = scnr.nextInt();
                System.out.println();
                zooFile = new FileInputStream('habitats.txt');
                habitatDetails = new Scanner(zooFile);
                i = 0;
                while(habitatDetails.hasNextLine()) {
                    habitatString = habitatDetails.nextLine();
                    if (habitatString.contains("Habitat")){
                        i++;
                    }
                    if (i == infoInput){
                        infoFound = true;
                        //checking for alert and displaying alert for habitat section
                        if (habitatString.contains("*****")){
                            String alert = habitatString.substring(5, habitatString.length());
                            int len = alert.length()+12;
                            for (int j = 0; j < len; j++){
                                System.out.print("!");
                            }
                            System.out.println();
                            System.out.println("! Caution " + alert + " !");
                            for (int j = 0; j < len; j++){
                                System.out.print("!");
                            }
                            System.out.println();
                        }
                        else if (!habitatString.isEmpty()){
                            System.out.println(habitatString);
                        }
                    }
                }
                if (infoFound != true){
                    System.out.println("INVALID, PLEASE TRY AGAIN.");
                }
                zooFile.close();
                System.out.println();
            }
            else if (userInput == 3){
                break;
            }
            else{
                System.out.println("ENTRY INVALID, PLEASE TRY AGAIN.");
                System.out.println();
            }
        }
        return;
    }
}
                            
                    
                    
                    
                                