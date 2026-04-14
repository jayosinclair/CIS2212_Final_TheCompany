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

/**
 * The Hourly class extends the Employee class to provide the pay and other data about an hourly employee.
 */
public class Hourly extends Employee{
 
    private double hoursWorked;


    /**
     * The Hourly constructor receives arguments for all the parameters at Employee/those inherited from StaffMember.
     * @param nameVal The employee's name
     * @param addressVal The employee's street address
     * @param phoneNumberVal The employee's phone number
     * @param ssnVal The employee's social security number
     * @param payRateVal The employee's pay rate
     */
    public Hourly(String nameVal, String addressVal, String phoneNumberVal, String ssnVal, double payRateVal){

        super(nameVal, addressVal, phoneNumberVal, ssnVal, payRateVal);
        this.hoursWorked = 0;

    }


    /**
     * The addHours method adds the parameter value to the hoursWorked instance variable.
     * @param numHours The number of hours worked
     */
    public void addHours(double numHours){

        this.hoursWorked += numHours;

    }


    /**
     * The pay method is overridden in this class to calculate a pay amount based on the pay rate and hours worked variables.
     * @return The product of pay rate and hours worked as a pay amount (expressed as double)
     */
    @Override
    public double pay(){

        double payAmt = (super.getPayRate() * this.hoursWorked);

        return payAmt;
        
    }


    /**
     * The toString adds hours worked to the Employee version of toString
     * @return the entire string representation of Hourly
     */
    @Override
    public String toString(){

        String baseline = super.toString();
        String instant = "Current Hours: " + this.hoursWorked + "\n";

        return baseline + instant;

    }


}
