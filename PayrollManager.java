//Author: Jay Olson
//Section: CIS 2212-801
//Assignment: Final Assignment: The Company
//Due Date: May 5, 2026
//Submitted: April 13, 2026

/*
This program is intended to demonstrate mastery of CIS 2212 course concepts as the final project.
*/

//Github repo for this project is at: https://github.com/jayosinclair/CIS2212_Final_TheCompany.git

//**********************************************************************************************************************

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class PayrollManager {
    
    private String fileName;
    private ArrayList <StaffMember> staffList = new ArrayList <StaffMember>(); //Note that I did not use diamond notation just for backwards compatibility.


    /**
     * The PayrollManager constructor receives a file name and assigns it to an instance variable.
     * @param fileNm The file name. Must be in the same location as the rest of the package.
     */
    public PayrollManager(String fileNm){

        this.fileName = fileNm;
        System.out.println("\nPayroll Manager\n");

    }


    /**
     * The loadData method reads a file and maps contents to objects and associated attributes within an ArrayList called staffList.
     * @return true if execution is successful
     */
    public boolean loadData(){

        boolean fileFound = false; //Variable for the while loop
        Scanner keyboardScnr = new Scanner(System.in);
        Scanner fScan; //Scanner to read the file. This is not the same instance as the keyboardScnr, which is to read from the console.
        
        //The following temp values are used just to make it clear what values are read into before they 
        //are fed to constructors in building files:
        String tempRecordType;
        String tempName;
        String tempAddress;
        String tempPhoneNumber;
        String tempSSN;
        double tempNumHours;
        double tempPayRt;
        double tempBonus;

        Hourly tempHourly; //Made to build and modify an Hourly object before adding it to an ArrayList.
        Executive tempExecutive; //Made to build and modify an Executive object before adding it to an ArrayList.


        //Open file, handle exception
        do { //Execute at least once
            
            try {
                
                FileInputStream fileStream = new FileInputStream(fileName);
                fScan = new Scanner(fileStream);

                System.out.println("\nLoading data...");
                fileFound = true;

            } 
            
            catch (FileNotFoundException fnfe) {

                System.out.println("File not found!");
                return false;

            }


        } while (!fileFound);


        //Read the file until the end of the file
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
                    
                    //I originally had a single statement to add the new Hourly object in one line, but I
                    //ultimately decided to split things up so I could use addHours without making a counter variable
                    //with a get() method to traverse the ArrayList since tempNumHours is a parameter with the constructor.
                    //Either way should work, but this walks through it a bit more pedantically. Note I did the same thing with Executive.

                    System.out.print("Enter the number of hours for " + tempName + ": ");
                    tempNumHours = getDoubleResponse(keyboardScnr);

                    tempHourly = new Hourly(tempName, tempAddress, tempPhoneNumber, tempSSN, tempPayRt);
                    tempHourly.addHours(tempNumHours);

                    staffList.add(tempHourly);

                    //tempHourly = null;
                    tempNumHours = 0.0; //Reset

                    break;


                case "executive":

                    tempName = fScan.nextLine();
                    tempAddress = fScan.nextLine();
                    tempPhoneNumber = fScan.nextLine();
                    tempSSN = fScan.nextLine();
                    tempPayRt = fScan.nextDouble();


                    System.out.print("Enter the bonus for " + tempName + ": ");
                    tempBonus = getDoubleResponse(keyboardScnr);

                    tempExecutive = new Executive(tempName, tempAddress, tempPhoneNumber, tempSSN, tempPayRt);
                    tempExecutive.awardBonus(tempBonus);

                    staffList.add(tempExecutive);
                    //tempExecutive = null;
                    tempBonus = 0.0; //Reset

                    break;

                default:

                    break;

            }

            tempRecordType = ""; //Reset

        }

        //Close file

        if (fileFound){
            fScan.close();
        }

        keyboardScnr.close();

        return true;

    }


    /**
     * The runPayroll method traverses the ArrayList and provides console output with polymorphic toString methods and a pay amount.
     * The for loop in this implementation is not an enhanced for loop, but an example of one can be found in a previous commit on GitHub.
     */
    public void runPayroll(){

        for (int i = 0; i < staffList.size(); i++){

            Double payAmt = staffList.get(i).pay(); //Use wrapper class Double to use non-primitive with equals method later.

            System.out.println("\n-------------------");

            System.out.print(staffList.get(i).toString() + "\n");

            if (payAmt.equals(0.0)){
                System.out.println("Thanks!");
            }

            else {
                System.out.printf("Paid: $" + "%.2f", payAmt); //Formatted to two decimal places.
                System.out.print("\n");
            }

        }

    }


    /**
	 * Method getDoubleResponse is a helper method that seeks/validates double input > 0.0. 
     * NOTE: I Wrote this same method for assignment 5 and reused it here, except I changed int to double.
	 * @param input is a Scanner object that can be used to get input from the keyboard, a file, etc. 
	 * It is only used as keyboard input in this program, but reuse is simple.
	 * @return response value is validated, double > 0.0 output
	 */
	private static double getDoubleResponse(Scanner input){

		double response = -1.0; //Cannot have a negative number of passphrases, word size, etc., so using this as sentinel

		while (response < 0.0){

			try{

				response = input.nextDouble();

				if (response < 0.0){
					System.out.print("Make sure you enter a value greater than 0. Try again: ");
				}

			}

			catch(InputMismatchException e){
                
				System.out.print("Make sure you enter a double greater than 0. Try again: ");
				input.next(); //Clear the buffer
                
			}

		}

		return response;

	}

}
