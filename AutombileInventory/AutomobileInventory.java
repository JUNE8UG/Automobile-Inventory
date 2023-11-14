// Main for autombile class
import java.util.Scanner;
import java.util.ArrayList;

public class AutomobileInventory {
    ArrayList<Automobile> AutomobileList = new ArrayList<Automobile>();

    public static void main(String[] args) {
        // create instance of a new vehicle
        Automobile vehicle = new Automobile();
        // create instance of a menue
        Menu callMenu = new Menu();
        // create instance of choice 
        Choice userChoice = new Choice();

        // program start and call menu function
        callMenu.menu();
        // retrieve user choice
        int select = userChoice.choice();
        // while the user choice is between 1 and 4
        while (select < 4) {
            // decide what to do with user choice
            // if they choose 1 then add a vehicle to the inventory
            if (select == 1) {
                vehicle.add_vehicle();
            }
            // if they choose 2 remove the vehicle
            else if (select == 2) {
                vehicle.remove_vehicle();
            }
            // if they choose 3 update the vehicle 
            else if (select == 3) {
                vehicle.updates_vehicle();
            }
            // show the menu again
            callMenu.menu();
            // get user choice
            select = userChoice.choice();
 
        }

        // if the user chooses 4 ask if they want to print to the file
        if (select == 4 ) {
            System.out.print("\nWould you like to print the inventory to a file before you go? [Y/N] ");
            try (Scanner sc = new Scanner(System.in)) {        
                char answer = sc.next().charAt(0);
                // if yes print to file
                if (answer == 'Y' || answer == 'y') {
                    vehicle.print_file();
                } 
                // else let the user know it will not be printed 
                else {
                    System.out.println("\nYou choose not to print to a file!");
                }
            }
        }

        // End program gracefully
        System.out.println("\nThank you and goodbye!"); 
    }
}