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


public class Executive extends Employee{
 
    private double bonus;


    public Executive(String nameVal, String addressVal, String phoneNumberVal, String ssnVal, double payRateVal){

        super(nameVal, addressVal, phoneNumberVal, ssnVal, payRateVal);
        this.bonus = 0;

    }



    public void awardBonus(double bonusAmt){

        this.bonus += bonusAmt;

    }


    @Override
    public double pay(){

        double payAmt = super.getPayRate() + this.bonus;
        this.bonus = 0;

        return payAmt;

    }


}
