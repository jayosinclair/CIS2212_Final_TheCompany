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


public abstract class StaffMember {
    
    private String name;
    private String address;
    private String phoneNumber;

    public StaffMember(String nameVal, String addressVal, String phoneNumberVal){
        
        this.name = nameVal;
        this.address = addressVal;
        this.phoneNumber = phoneNumberVal;
    
    }

    public abstract double pay();


    @Override
    public String toString(){

        String value;

        /*
        
        toString - returns a string object built from the instance data that looks like
        this:
        Name: Bob
        Address: 123 Some Lane
        Phone: 513-555-1212
        
        */

        return value;

    }


}
