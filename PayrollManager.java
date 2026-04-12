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
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class PayrollManager {
    
    private String fileName;
    private ArrayList <StaffMember> staffList = new ArrayList <StaffMember>();


    public PayrollManager(String fileNm){

        this.fileName = fileNm;
        System.out.println("\nPayroll Manager\n");

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
                    
                   
                    //staffList.add(new Hourly(tempName, tempAddress, tempPhoneNumber, tempSSN, tempPayRt));

                    System.out.print("Enter the number of hours for " + tempName + ": ");
                    tempNumHours = getDoubleResponse(keyboardScnr);

                    tempHourly = new Hourly(tempName, tempAddress, tempPhoneNumber, tempSSN, tempPayRt);
                    tempHourly.addHours(tempNumHours);

                    staffList.add(tempHourly);

                    //tempHourly = null;
                    tempNumHours = 0; //Reset

                    //staffList.get(counter).addHours(tempNumHours);

                    break;


                case "executive":

                    tempName = fScan.nextLine();
                    tempAddress = fScan.nextLine();
                    tempPhoneNumber = fScan.nextLine();
                    tempSSN = fScan.nextLine();
                    tempPayRt = fScan.nextDouble();

                    //staffList.add(new Executive(tempName, tempAddress, tempPhoneNumber, tempSSN, tempPayRt));

                    System.out.print("Enter the bonus for " + tempName + ": ");
                    tempBonus = getDoubleResponse(keyboardScnr);

                    tempExecutive = new Executive(tempName, tempAddress, tempPhoneNumber, tempSSN, tempPayRt);
                    tempExecutive.awardBonus(tempBonus);

                    staffList.add(tempExecutive);
                    //tempExecutive = null;
                    tempBonus = 0; //Reset


                    /*
                    From 10.7.1 of the ZyBooks text:

                    Note that a method operating on a collection of Object elements may only invoke the methods defined by the base class (e.g., the Object class). 
                    Thus, a statement that calls the toString() method on an element of an ArrayList of Objects called objList, such as objList.get(i).toString(), 
                    is valid because the Object class defines the toString() method. However, a statement that calls, for example, the Integer class's intValue() 
                    method on the same element (i.e., objList.get(i).intValue()) results in a compiler error even if that particular element is an Integer object.

                    */



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

    // public void runPayroll(){

    //     for (StaffMember entry: staffList){

    //         System.out.println("-------------------");

    //         System.out.print(entry.toString() + "\n");

    //         if (entry.pay() == 0){
    //             System.out.println("Thanks!");
    //         }

    //         else {
    //             System.out.println("Paid: $" + entry.pay()); //TODO: Need to format to two decimal places.
    //         }

    //     }

    // }


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
