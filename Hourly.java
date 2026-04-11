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


    public Hourly(String nameVal, String addressVal, String phoneNumberVal, String ssnVal, double payRateVal){

        super(nameVal, addressVal, phoneNumberVal, ssnVal, payRateVal);
        hoursWorked = 0;

    }



    public void addHours(double numHours){

        hoursWorked += numHours;

    }

    @Override
    public double pay(){

        double payAmt = (super.getPayRate() * hoursWorked);
        this.hoursWorked = 0;

        return payAmt;
        
    }


    @Override
    public String toString(){

        String baseline = super.toString();
        String instant = "Current Hours: " + this.hoursWorked + "\n";

        return baseline + instant;




        /*
        
        instance data in this class that looks like this:
        Name: Bob
        Address: 123 Some Lane
        Phone: 513-555-1212
        Social Security Number: 100-11-1234
        Current Hours: 10.5
        
        */

    }


}
