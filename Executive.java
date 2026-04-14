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
 * The Executive class extends Employee, providing information for a bonus for the Executive staff member type.
 */
public class Executive extends Employee{
 
    private double bonus;

    /**
     * The Executive constructor receives all the same values as Employee, and it initializes the bonus to $0.00
     * @param nameVal The employee's name
     * @param addressVal The employee's street address
     * @param phoneNumberVal The employee's phone number
     * @param ssnVal The employee's social security number
     * @param payRateVal The employee's pay rate
     */
    public Executive(String nameVal, String addressVal, String phoneNumberVal, String ssnVal, double payRateVal){

        super(nameVal, addressVal, phoneNumberVal, ssnVal, payRateVal);
        this.bonus = 0.00;

    }


    /**
     * The awardBonus method adds the parameter variable bonusAmount's argument to the bonus instance variable.
     * @param bonusAmt The bonus amount for an executive
     */
    public void awardBonus(double bonusAmt){

        this.bonus += bonusAmt;

    }


    /**
     * The pay method is overridden in this class to calculate a pay amount considering the executive bonus.
     * @return The pay amount adding the bonus in
     */
    @Override
    public double pay(){

        double payAmt = super.getPayRate() + this.bonus;

        return payAmt;

    }


}
