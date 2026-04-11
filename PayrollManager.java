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
import java.util.InputMismatchException;
import java.io.FileNotFoundException;

public class PayrollManager {
    
    private String fileName;
    private ArrayList <StaffMember> staffList = new ArrayList <StaffMember>();


    public PayrollManager(String fileNm){

        this.fileName = fileNm;

    }


    public boolean loadData(){

        boolean fileFound = false;
        Scanner keyboardScnr = new Scanner(System.in);
        Scanner fScan;
        int counter = 0;

        String tempRecordType;
        String tempName;
        String tempAddress;
        String tempPhoneNumber;
        String tempSSN;
        double tempNumHours;
        double tempPayRt;
        double tempBonus;



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

            tempRecordType = fScan.nextLine();

            switch (tempRecordType){

                case "volunteer":

                    

                break;





            }

        
            if (tempRecordType.equals("volunteer")){

                tempName = fScan.nextLine();
                tempAddress = fScan.nextLine();
                tempPhoneNumber = fScan.nextLine();

                staffList.add(new Volunteer(tempName, tempAddress, tempPhoneNumber));

                tempName = ""; //Reset so temp values aren't accidentally reused
                tempAddress = "";
                tempPhoneNumber = "";

            }

            if (tempRecordType.equals("hourly")){

                tempName = fScan.nextLine();
                tempAddress = fScan.nextLine();
                tempPhoneNumber = fScan.nextLine();
                tempSSN = fScan.nextLine();
                tempPayRt = fScan.nextDouble();

                staffList.add(new Hourly(tempName, tempAddress, tempPhoneNumber, tempSSN, tempPayRt));

                System.out.println("Enter the number of hours for " + tempName + ": ");
                tempNumHours = getIntResponse(keyboardScnr);


                // tempName = ""; //Null string variables so they aren't interpreted incorrectly elsewhere.
                // tempAddress = "";
                // tempPhoneNumber = "";
                // tempSSN = "";
                // tempPayRt = "";
                // tempNumHours = "";

                

            }
            
            if (tempRecordType.equals("executive")){
                
                tempName = fScan.nextLine();
                tempAddress = fScan.nextLine();
                tempPhoneNumber = fScan.nextLine();
                tempSSN = fScan.nextLine();
                tempPayRt = fScan.nextDouble();

                staffList.add(new Executive(tempName, tempAddress, tempPhoneNumber, tempSSN, tempPayRt));

                System.out.println("Enter the bonus for " + tempName + ": ");
                tempBonus = getIntResponse(keyboardScnr);


                // tempName = ""; //Null string variables so they aren't interpreted incorrectly elsewhere.
                // tempAddress = "";
                // tempPhoneNumber = "";
                // tempSSN = "";
                // tempPayRt = "";
                // tempBonus = "";

            }

            tempRecordType = "";
            counter++;

        }

        //Close file

        if (fileFound){
            fScan.close();
        }

        keyboardScnr.close();

        return true;

    }

    public void runPayroll(){

        System.out.println("Hello!");

    }


    /**
	 * Method getIntResponse is a helper method that seeks integer input > 0 and validates it is, in fact, an integer > 0. Input is
	 * sought until an integer > 0 is successfully retrieved. NOTE: I Wrote this same method for assignment 5 and reused it here.
	 * @param input is a Scanner object that can be used to get input from the keyboard, a file, etc. 
	 * It is only used as keyboard input in this program, but reuse is simple.
	 * @return response value is validated, integer > 0 output
	 */
	private static int getIntResponse(Scanner input){

		int response = -1; //Cannot have a negative number of passphrases, word size, etc., so using this as sentinel

		while (response < 0){

			try{
				response = input.nextInt();

				if (response < 0){
					System.out.print("Make sure you enter a integer greater than 0. Try again: ");
				}

			}

			catch(InputMismatchException e){
				System.out.print("Make sure you enter a integer greater than 0. Try again: ");
				input.next(); //Clear the buffer
			}

		}

		return response;

	}

}
