/*
Portfolio Project 2 Option 1
Programmer: Olmedo, Johnny
CSC 320
Submission date: 03/13/2022 
This is the auto mile class that adds, deletes, and updates attribute of automobile inventory
*/

import java.util.Scanner;
import java.util.ArrayList;
import java.io.PrintWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Automobile {
 
    // declare the variables that will be used for the program
    private String make; // car make
    private String model; // car model
    private String color; // car color
    private int year; // car year
    private String mileage; // car mileage
    // use an array to store objects
    ArrayList<Automobile> AutomobileList = new ArrayList<Automobile>(); // inventory
    Scanner sc = new Scanner(System.in); // Scanner
    
    // default constructor
    public Automobile() {
        make = "";
        model = "";
        color = "";
        year = 0;
        mileage = "";
    }
   
    //  parameterized constructor, this gives you a new object every time a call is made that meets the parameter
    public Automobile(String vehicleMake, String vehicleModel, String vehicleColor, int vehicleYear, String vehicleMileage) {
        make = vehicleMake;
        model = vehicleModel;
        color = vehicleColor;
        year = vehicleYear;
        mileage = vehicleMileage;
    }

    // add a new vehicle method
    public void add_vehicle() {
        // make 
        System.out.print("Enter vehicle make: ");
        make = sc.nextLine();
        // model
        System.out.print("Enter vehicle model : ");
        model = sc.nextLine();
        // color
        System.out.print("Enter vehicle color: ");
        color = sc.nextLine();
        // year
        System.out.print("Enter vehicle year: ");
        year = Integer.parseInt(sc.nextLine());
        // mileage
        System.out.print("Enter vehicle mileage: ");
        mileage = sc.nextLine(); 
        // make newinstance of this vehicle
        Automobile vehicle = new Automobile(make, model, color, year, mileage);
        // add to list/inventory
        AutomobileList.add(vehicle);
        // print out the current inventory
        print();
        // let user know that the function completed successfully
        System.out.println("\nVehicle Succesfully added");
    }

    // remove a vehicle
    public void remove_vehicle() {
        // show what the current inventory looks like
        print(); 
        // if the inventory is empty let the user know
        if (AutomobileList.size() == 0) {
            System.out.print("Vehicle inventory is empty");
            return; // return so they user can choose another option
        }
        // ask the user which vehicle they would like to remove
        System.out.print("Which vehicle would you like to remove?: ");
        // user input
        int delete = Integer.parseInt(sc.nextLine()); // change string nextLine to into
        // while user input is less than or equal to zero, or bigger than number of 
        // vehicles actually in the inventory
        while(delete <= 0 || delete > AutomobileList.size()) {
            // let them know they input the wrong info
            System.out.println("\nInvalid input");
            System.out.print("please pick a vehicle that's currently in the inventory: ");
            // get input 
            delete = Integer.parseInt(sc.nextLine());
        }
        // remove vehicle if user input is smaller than the size of the list1
        if ((delete - 1) < AutomobileList.size()) {
            AutomobileList.remove(delete - 1);
        }

        print(); // show current inventory
        System.out.println("\nVehicle succesfully removed");

    }

    // update vehicle
    public void updates_vehicle() {
        print(); // show the inventory
        // if the inventory is empty let the user know
        if (AutomobileList.size() == 0) {
            System.out.print("Vehicle inventory is empty");
            return; // return so they user can choose another option
        }
        // ask the user which vehicle they want to update
        System.out.print("\nWhich vehicle would you like to update?: ");
        // user input  
        int update = Integer.parseInt(sc.nextLine());
        // verify user input is not less than or equal to zero, and that it's 
        // not bigger than the number of vehicles in the inventory
        while(update <= 0 || update > AutomobileList.size()) {
            // prompt usr for correct input
            System.out.println("\nInvalid input");
            System.out.print("please pick a vehicle that's currently in the inventory: ");
            update = Integer.parseInt(sc.nextLine());
        }
        // if user input is less than size of inventory
        if ((update - 1) < AutomobileList.size()) {
            // go through and grab needed info
            // make 
            System.out.print("Enter vehicle make: ");
            make = sc.nextLine();
            // model
            System.out.print("Enter vehicle model : ");
            model = sc.nextLine();
            // color
            System.out.print("Enter vehicle color: ");
            color = sc.nextLine();
            // year
            System.out.print("Enter vehicle year: ");
            year = Integer.parseInt(sc.nextLine());
            // mileage
            System.out.print("Enter vehicle mileage: ");
            mileage = sc.nextLine(); 
            // make instance of this vehicle
            Automobile vehicle = new Automobile(make, model, color, year, mileage);
            // replace old vehicle with new vehicle
            AutomobileList.set((update - 1), vehicle);
            // show new inventory
            print();
            // let user know vehicle was successfully updated
            System.out.print("\nVehicle sucessfully updated!");
        }

    }

    // print method
    public void print() {
        // Display inventory banner
        System.out.println("\n----------------");
        System.out.println("   INVENTORY");
        System.out.println("----------------");
    
        // Print out each vehicle to the screen
        for (Automobile auto : AutomobileList) {
            printVehicleDetails(auto);
        }
    }
    
    // Separate method to print vehicle details
    private void printVehicleDetails(Automobile auto) {
        int vehicleNumber = AutomobileList.indexOf(auto) + 1;
        System.out.println("\nVehicle #" + vehicleNumber); // vehicle number
        // Make, model, color, year, mileage
        System.out.println("Make: " + auto.make);
        System.out.println("Model: " + auto.model);
        System.out.println("Color: " + auto.color);
        System.out.println("Year: " + auto.year);
        System.out.println("Mileage: " + auto.mileage);
    }
    
    // print to file method
    public void print_file() {

        try (FileOutputStream fileStream = new FileOutputStream("./AutomobileInventory.txt");
        PrintWriter outFS = new PrintWriter(fileStream)) {

            // Write banner
            outFS.println("\n----------------");
            outFS.println("   INVENTORY");
            outFS.println("----------------");

            // Iterate through the list and print information
            for (Automobile auto : AutomobileList) {
                // Make, model, color, year, mileage
                outFS.println("Make: " + auto.make);
                outFS.println("Model: " + auto.model);
                outFS.println("Color: " + auto.color);
                outFS.println("Year: " + auto.year);
                outFS.println("Mileage: " + auto.mileage);  
            }

            outFS.close();
        } catch (FileNotFoundException e) {
        System.out.print("File path not found");
        } catch (IOException e) {
            // Handle exceptions here
            e.printStackTrace();
        }
    }

}    