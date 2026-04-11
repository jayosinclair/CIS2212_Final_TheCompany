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


public class Employee extends StaffMember{
    
    private String ssn;
    private double payRate;

    public Employee(String nameVal, String addressVal, String phoneNumberVal, String ssnVal, double payRateVal){

        super(nameVal, addressVal, phoneNumberVal);
        this.ssn = ssnVal;
        this.payRate = payRateVal;

    }


    public double getPayRate(){

        return this.payRate;

    }

    @Override
    public double pay(){

        return this.getPayRate();

    }



    @Override
    public String toString(){

        String baseline = super.toString();
        String instant = "Social Security Number: " + this.ssn;

        return baseline + instant;


        /*
        
        instance data in this class that looks like this:
        Name: Bob
        Address: 123 Some Lane
        Phone: 513-555-1212
        Social Security Number: 100-11-1234
        
        */

    }



}
