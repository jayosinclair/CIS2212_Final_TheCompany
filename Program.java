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
 * The Program class is the container for the main method.
 */
public class Program
    {
        public static void main(String[] args)
        {
            PayrollManager pm = new PayrollManager("data.txt");
            if (pm.loadData()) {
               pm.runPayroll();
            }
        }
    }
