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
        Scanner keyboardScnr = new Scanner(System.in); //TODO: Convert this to try with resources so it just closes the scanner when done.
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

                    tempName = fScan.nextLine();
                    tempAddress = fScan.nextLine();
                    tempPhoneNumber = fScan.nextLine();

                    staffList.add(new Volunteer(tempName, tempAddress, tempPhoneNumber));

                    break;

                case "hourly":

                    tempName = fScan.nextLine();
                    tempAddress = fScan.nextLine();
                    tempPhoneNumber = fScan.nextLine();
                    tempSSN = fScan.nextLine();
                    tempPayRt = fScan.nextDouble();

                    staffList.add(new Hourly(tempName, tempAddress, tempPhoneNumber, tempSSN, tempPayRt));

                    System.out.println("Enter the number of hours for " + tempName + ": ");
                    tempNumHours = getDoubleResponse(keyboardScnr);

                    //TODO: Send to addHours method. Go read the inheritance/polymorphism content again b/c the commented line below doesn't work:

                    //staffList.get(counter).addHours(tempNumHours);

                    break;


                case "executive":

                    tempName = fScan.nextLine();
                    tempAddress = fScan.nextLine();
                    tempPhoneNumber = fScan.nextLine();
                    tempSSN = fScan.nextLine();
                    tempPayRt = fScan.nextDouble();

                    staffList.add(new Executive(tempName, tempAddress, tempPhoneNumber, tempSSN, tempPayRt));

                    System.out.println("Enter the bonus for " + tempName + ": ");
                    tempBonus = getDoubleResponse(keyboardScnr);

                    //TODO: Send bonus to awardBonus method. Go read the inheritance/polymorphism content again b/c the commented line below doesn't work:
                    //staffList.get(counter).awardBonus(tempBonus);

                    break;

                default:

                    break;

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

        for (StaffMember entry: staffList){

            System.out.println("-------------------");

            System.out.print(entry.toString() + "\n");

            if (entry.pay() == 0){
                System.out.println("Thanks!");
            }

            else {
                System.out.println("Paid: $" + entry.pay());
            }

        }

    }


    /**
	 * Method getDOubleResponse is a helper method that seeks/validates double input > 0.0. 
     * NOTE: I Wrote this same method for assignment 5 and reused it here, except I changed int to double.
	 * @param input is a Scanner object that can be used to get input from the keyboard, a file, etc. 
	 * It is only used as keyboard input in this program, but reuse is simple.
	 * @return response value is validated, double > 0.0 output
	 */
	private static double getDoubleResponse(Scanner input){

		double response = -1.0; //Cannot have a negative number of passphrases, word size, etc., so using this as sentinel

		while (response < 0){

			try{
				response = input.nextDouble();

				if (response < 0.0){
					System.out.print("Make sure you enter a vale greater than 0.0. Try again: ");
				}

			}

			catch(InputMismatchException e){
				System.out.print("Make sure you enter a double greater than 0.0. Try again: ");
				input.next(); //Clear the buffer
			}

		}

		return response;

	}

}
