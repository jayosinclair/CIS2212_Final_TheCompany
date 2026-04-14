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
 * The StaffMember class is an abstract class from which other classes are derived. 
 */
public abstract class StaffMember {
    
    private String name;
    private String address;
    private String phoneNumber;

    /**
     * The StaffMember constructor takes in three parameters and assigns them to corresponding instance variables.
     * @param nameVal The staff member's name
     * @param addressVal The staff member's street address
     * @param phoneNumberVal The staff member's phone number
     */
    public StaffMember(String nameVal, String addressVal, String phoneNumberVal){
        
        this.name = nameVal; //Having "this" is not necessary here, but I used it as a matter of style.
        this.address = addressVal;
        this.phoneNumber = phoneNumberVal;
    
    }


    /**
     * The pay abstract method is implemented/overridden in derived classes to get a pay amount
     * for a given person of a derived class type.
     * @return Pay amount as a double
     */
    public abstract double pay();

    /**
     * The default toString method is overridden.
     * @return a string representing the contents of the object
     */
    @Override
    public String toString(){

        String baseline = //Is this variable declaration unnecessary? I think so... but I tried to make this readable.
        //This baseline text is built upon by other classes.

        "Name: " + this.name + "\n" +
        "Address: " + this.address + "\n" +
        "Phone: " + this.phoneNumber + "\n";

        return baseline;

    }


}
