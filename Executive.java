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


    public Employee(String nameVal, String addressVal, String phoneNumberVal, String ssnVal, double payRateVal){

        super(nameVal, addressVal, phoneNumberVal, ssnVal, payRateVal);
        this.bonus = 0;

    }



    public void awardBonus(double bonusAmt){

        bonus += bonusAmt;

    }


    public double pay(){

        //TODO: Override the inherited method and return the pay from the base class
        //plus the bonus for this Employee. The bonus should be set back to zero.

    }


    @Override
    public String toString(){

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
