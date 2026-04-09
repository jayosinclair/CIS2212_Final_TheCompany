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


public class Hourly extends Employee{
 
    private double hoursWorked;


    public Hourly(String nameVal, String addressVal, String phoneNumberVal, String ssnVal, double payRateVal, double hoursWorkedVal){

        super(nameVal, addressVal, phoneNumberVal, ssnVal, payRateVal);
        this.hoursWorked = hoursWorkedVal;

    }



    public void addHours(double numHours){

        hoursWorked += numHours;

    }


    public double pay(){

        //TODO: Return to this to make sure it works/makes sense.
        return (super.getPayRate() * hoursWorked);

    }


    // @Override
    // public String toString(){

    //     /*
        
    //     instance data in this class that looks like this:
    //     Name: Bob
    //     Address: 123 Some Lane
    //     Phone: 513-555-1212
    //     Social Security Number: 100-11-1234
    //     Current Hours: 10.5
        
    //     */

    // }


}
