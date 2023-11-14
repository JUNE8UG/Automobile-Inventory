// choice class asks user what they want to do and in the beginning menu
// and gets user input to retun to automobile inventory 
import java.util.Scanner;

// choice class
public class Choice {
    // initilize user input varaible
    int userChoice = 0;
    Scanner sc = new Scanner(System.in);

    // choice method
    public int choice() {
        // ask user what they want to do
        System.out.print("\nWhat would you like to do?: ");
        // user input
        userChoice = sc.nextInt();
        // return user input
        return userChoice;
    }
}