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
 * The Volunteer class extends Staff Member. It simply assigns the pay amount to always be $0.00.
 */
public class Volunteer extends StaffMember{
    
    /**
     * The Volunteer constructor takes in three parameters and assigns them to corresponding instance variables from StaffMember.
     * @param nameVal The volunteer's name
     * @param addressVal The volunteer's street address
     * @param phoneNumberVal The volunteer's phone number
     */
    public Volunteer(String nameVal, String addressVal, String phoneNumberVal){

        super(nameVal, addressVal, phoneNumberVal);

    }

    /**
     * The pay method is overridden to return a value of $0.00 since the volunteer makes no money.
     * @return the pay value of $0.00 for a volunteer
     */
    @Override
    public double pay(){

        return 0.00;

    }

}
