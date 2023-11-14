// menu class to print menu
import java.util.Hashtable;

public class Menu {
    // initilize a dictionary for menu
    Hashtable<String, String> menu = new Hashtable<String, String>();
    
    // menu method
    public void menu() {
        // print menu banner
        System.out.println("\n----------------");
        System.out.println("     MENU");
        System.out.println("----------------");
        
        // set key and value
        menu.put("1", "Add Vehicle");
        menu.put("2", "Delete Vehicle");
        menu.put("3", "Update Vehicle");
        menu.put("4", "Exit");
        
        // format the menue
        //print the first key, with it's respective value 
        System.out.println("1. " + menu.get("1")); 
        System.out.println("2. " + menu.get("2"));
        System.out.println("3. " + menu.get("3"));
        System.out.println("4. " + menu.get("4"));
    }    
}