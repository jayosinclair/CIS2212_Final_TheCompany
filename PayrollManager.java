//Author: Jay Olson
//Section: CIS 2212-801
//Assignment: Final Assignment: The Company
//Due Date: May 5, 2026
//Submitted: 

/*
This program is intended to demonstrate mastery of CIS 2212 course concepts as the final project.
*/

//Github repo for this project is at: https://github.com/jayosinclair/CIS2212_Final_TheCompany.git

//**********************************************************************************************************************


import java.io.FileInputStream;
import java.util.Scanner;
import java.util.ArrayList;
import java.io.FileNotFoundException;

public class PayrollManager {
    
    private String fileName;
    private ArrayList <StaffMember> staffList = new ArrayList <StaffMember>(); //TODO: This may or may not be the right container type. Keep reading spec...


    public PayrollManager(String fileNm){

        this.fileName = fileNm;

    }


    public boolean loadData(){

        boolean fileFound = false;
        Scanner keyboardScnr = new Scanner(System.in);


        //Open file, handle exception


        while (!fileFound){
            
            try {
                
                FileInputStream fileStream = new FileInputStream(fileName);
                Scanner fScan = new Scanner(fileStream);

                System.out.println("Loading data...");
                fileFound = true;

            } 
            
            catch (FileNotFoundException fnfe) {

                System.out.println("File not found!");
                return false;

            }


        }


        //This entire implementation is flawed (need to create new objects to insert into arraylist), but to get started...
        while (fScan.nextLine()){

            if (fScan.nextLine().equals("Volunteer")){

                staffList.add(Volunteer(fScan.nextLine(), fScan.nextLine(), fScan.nextLine()));
                
            }

            else if (fScan.nextLine().equals("Hourly")){

                staffList.add(Hourly(fScan.nextLine(), fScan.nextLine(), fScan.nextLine(), fScan.nextDouble()));
                
            }

            //else if (fScan.nextLine().equals("Executive")){

            else{

                staffList.add(Hourly(fScan.nextLine(), fScan.nextLine(), fScan.nextLine(), fScan.nextLine(), fScan.nextDouble()));
                
            }


        }

        //Read file
        //Close file


    }

}
