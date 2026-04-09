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
        Scanner fScan;

        //Open file, handle exception


        do { //Execute at least once
            
            try {
                
                FileInputStream fileStream = new FileInputStream(fileName);
                fScan = new Scanner(fileStream);

                System.out.println("Loading data...");
                fileFound = true;

            } 
            
            catch (FileNotFoundException fnfe) {

                System.out.println("File not found!");
                return false;

            }


        } while (!fileFound);


        while(fScan.hasNextLine()){
        
            if (fScan.nextLine().equals("Volunteer")){

                staffList.add(new Volunteer(fScan.nextLine(), fScan.nextLine(), fScan.nextLine()));

            }

            // if (fScan.nextLine().equals("Hourly")){
            //     staffList.add(new Hourly(fScan.nextLine(), fScan.nextLine(), fScan.nextLine(), fScan.nextLine(), fScan.nextDouble(), fScan.nextDouble()));
            // }
            
            // if (fScan.nextLine().equals("Executive")){
            //     staffList.add(new Executive(fScan.nextLine(), fScan.nextLine(), fScan.nextLine(), fScan.nextLine(), fScan.nextDouble()));
            // }

        }

        //Close file

        if (fileFound){
            fScan.close();
        }

        keyboardScnr.close();

        return true;

    }

    public void runPayroll(){


    }

}
