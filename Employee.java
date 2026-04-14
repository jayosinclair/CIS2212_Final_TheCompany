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

/**
 * The Employee class extends StaffMember. It contains social security number and a pay rate in addition to super class variables.
 */
public class Employee extends StaffMember{
    
    private String ssn;
    private double payRate;

    /**
     * The Employee constructor receives 5 arguments, including those from StaffMember, ssnVal, and payRateVal.
     * @param nameVal The employee's name
     * @param addressVal The employee's street address
     * @param phoneNumberVal The employee's phone number
     * @param ssnVal The employee's social security number
     * @param payRateVal The employee's pay rate
     */
    public Employee(String nameVal, String addressVal, String phoneNumberVal, String ssnVal, double payRateVal){

        super(nameVal, addressVal, phoneNumberVal);
        this.ssn = ssnVal;
        this.payRate = payRateVal;

    }


    /**
     * Method getPayRate calculates the pay rate. In this case, it is the same as what is
     * passed in (anticipating being overridden by derived classes with more information).
     * @return the pay rate as a double
     */
    public double getPayRate(){

        return this.payRate;

    }


    /**
     * The pay method overrides the StaffMember method since the StaffMember version is abstract.
     * The returned value is the pay rate for the Employee object.
     * @return the pay rate
     */
    @Override
    public double pay(){

        return this.getPayRate();

    }


    /**
     * The toString is overridden to include the SSN on top of the baseline toString content from StaffMember.
     * @return the entire string representation of Employee
     */
    @Override
    public String toString(){

        String baseline = super.toString();
        String instant = "Social Security Number: " + this.ssn + "\n";

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
