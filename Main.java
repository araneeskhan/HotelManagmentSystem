package com.company;
import java.io.*;
import java.util.InputMismatchException;
import java.util.*;

public class Main{

    /*          Created static variables including the array and scanner,
                so it can be used in all the static methods without being declared again          */

    static final String TEXT_RESET = "\u001B[0m";
    static final String TEXT_RED = "\u001B[31m";
    static final String TEXT_CYAN = "\u001B[36m";

    static int quantity = 0;
    static int food_price;
    static String choice;
    static String answer;
    static String customerName;
    static int roomNumber = 0;
    static int rent = 0;

    static String[] hotel = new String[30];

    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {


        System.out.println(TEXT_RESET + TEXT_CYAN);

        initialize(hotel);
        welcome();

    }

//                                      *   Welcome  *

    public static void welcome(){


        do {

            System.out.println();

            System.out.println( "         *****||   WELCOME TO HOTEL   ||*****     ");

            System.out.println();

            System.out.println("            *   1.     Admin Login            *");
            System.out.println("            *   2.     Customer Login         *");

            System.out.println();

            System.out.println("        Choose one of the options from above : ");
            String select = input.next();


            switch (select) {

                case "1":
                    admin();
                    break;

                case "2":
                    customer();
                    break;

                default:
                    System.out.println();
                    System.out.println( TEXT_RED + "       Invalid input! Please Enter a Value From Below : " + TEXT_RESET + TEXT_CYAN);
            }


        } while (true);

    }

//                                *   Password Check  *

    public static void passCheck() {

        do {

            String pass = "cuii";

            System.out.println();

            System.out.println("Enter Password: ");
            String password = input.next();
            System.out.println();

            if (password.equalsIgnoreCase(pass)){

                menu();
            }

            else if (!password.equalsIgnoreCase(pass)) {
                System.out.println();
                System.out.println( TEXT_RED + "INCORRECT PASSWORD ! " );
                System.out.println();
                System.out.println("Please Enter a valid password: " + TEXT_RESET + TEXT_CYAN);

            }
        }
        while (true);
    }

    public static void initialize(String hotelRef[]) {

/*
          Hotel array will only have Null characters at the beginning.
          Assigning a String value of "e" to all of it's elements.

 */

        for (int x = 0; x < 30; x++) {
            hotelRef[x] = "e";
        }
    }


    public static void admin() {
        passCheck();

    }

//                               *    CUSTOMER LOGIN    *

    public static void customer() {

        System.out.println();
        System.out.println(" *  1.      View Rooms        *");
        System.out.println(" *  2.      Order Food        *");
        System.out.println();

        do {

            System.out.println("Choose one of the options from above : ");
            choice = input.next();
            String selection = choice;

            switch (selection) {

                case "1":
                    viewRooms();
                    break;

                case "2":
                    foodMenu();
                    break;

                default:
                    System.out.println();
                    System.out.println("Invalid input! Please Enter a Value: ");
            }

        } while (true);
    }


//                                        *   MENU   *

    public static void menu() {

        System.out.println();

        System.out.println("                                  =====================================================");
        System.out.println("                                  *             Hotel Management System               *");
        System.out.println("                                  =====================================================");
        System.out.println("                                  *    1.   View all the rooms                        *");
        System.out.println("                                  *    2.   Add customer to room                      *");
        System.out.println("                                  *    3.   Display Empty rooms                       *");
        System.out.println("                                  *    4.   Delete customer from room                 *");
        System.out.println("                                  *    5.   Find room from customer name              *");
        System.out.println("                                  *    6.   Store program array data into a text file *");
        System.out.println("                                  *    7.   Quit Program                              *");
        System.out.println("                                  =====================================================");

        System.out.println();

        System.out.println("Choose one of the options from above : ");

        do {

            System.out.println();
            System.out.print("Choice : ");
            choice = input.next();
            String selection = choice;

            switch (selection) {

                case "1":

                    viewRooms();
                    break;

                case "2":

                    addCustomer();
                    break;

                case "3":

                    displayEmptyRooms();
                    break;

                case "4":

                    deleteCustomer();
                    break;

                case "5":

                    findRoom();
                    break;

                case "6":

                    storeData();
                    break;

                case "7":

                    System.out.println();
                    System.out.println("Thanks");
                    System.exit(0);

                default:

                    System.out.println();
                    System.out.println(TEXT_RED + "Invalid input! Please Enter one Value: " + TEXT_RESET + TEXT_CYAN);
            }

        }

        while (true);

    }

//                                        *    VIEW ROOMS   *

    private static void viewRooms() {

        while (roomNumber < 30) {
            for (int x = 0; x < 30; x++) {

//              This will display the room number and the current owner's name

                if (!(hotel[x].equals("e"))) {
                    System.out.println("Room No. " + x + " is occupied by Mr. " + hotel[x]);

                }

//              This will display the rooms which are currently Empty

                else {

                    System.out.println("Room No. " + x + " is empty");

                }
            }

            break;
        }

        System.out.println();

        welcome();

    }

//                                      *    ADD CUSTOMER    *

    public static void addCustomer() {

        System.out.println("We have the following rooms for you : \n \n Room (1-10) Class A \n Room (10-20) Class B \n Room (20-30) Class C");

//          declaring a boolean value so it is easier to break or catch data from a loop

        boolean invalidRoomNumber;
        int roomRent = 0;

        String path = "Rent.txt";

        do {

            invalidRoomNumber = false;

            try {

                System.out.println();
                System.out.println("Enter room number (0-30) ");
                roomNumber = input.nextInt();

                if (roomNumber <= 10) {

                    System.out.println();
                    System.out.println("You have Chosen Class A");
                    rent = 10000;
                }
                else if (roomNumber > 10 && roomNumber <= 20) {

                    System.out.println();
                    System.out.println("You have chosen Class B");
                    rent = 5000;
                }
                else if (roomNumber > 20 && roomNumber <= 30) {

                    System.out.println();
                    System.out.println("You have chosen Class C");
                    rent = 2000;
                }

//          if the room is already occupied this message will get printed

                if (!(hotel[roomNumber].equals("e"))) {

                    invalidRoomNumber = true;
                    System.out.println("This room is occupied by: Mr. " + hotel[roomNumber]);
                    System.out.println();

                }

//              if the room is empty and the input value is within the range it accepts the input

                else if (roomNumber >= 0 && roomNumber < 30) {
                    invalidRoomNumber = false;

                }

//              if the input exceeds the range then this error message will be displayed

                else {

                    invalidRoomNumber = true;
                    System.out.println();
                    System.out.println(TEXT_RED + "Invalid input! Please Enter a value between 0-30" + TEXT_RESET + TEXT_CYAN);
                    System.out.println();
                }

                System.out.println();
                System.out.println("For How many nights you want to stay: ");
                int n = input.nextInt();

                roomRent = rent * n;

                System.out.println();
                System.out.println("Your Choosen room rent is: " + roomRent);
                System.out.println();

            }

//          If the input is not an integer value then this will catch it

            catch (InputMismatchException e) {

                invalidRoomNumber = true;
                System.out.println();
                System.out.println(TEXT_RED + "Invalid input! Please Enter a value between 0-30" + TEXT_RESET + TEXT_CYAN);
                System.out.println();

                input.next();

            }

//          If the input is out of the range of the hotel array this will catch it

            catch (Exception e) {

                invalidRoomNumber = true;
                System.out.println();
                System.out.println(TEXT_RED + "Invalid input! Please Enter a value between 0-30" + TEXT_RESET + TEXT_CYAN);
                System.out.println();

                input.next();

            }

        }

//          These steps will follow if all of the above is valid

        while (invalidRoomNumber);

        System.out.println("Enter the name of the customer :");
        customerName = input.next();
        hotel[roomNumber] = customerName;

        try {

            FileWriter myObj = new FileWriter(path, true);
            myObj.write(roomNumber + "       :       " + customerName + "        :         Rs." + roomRent + "\n");
            myObj.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }

//          this will let you choose whether to add more data or not

        do {

            System.out.println();
            System.out.println("Do you want to Continue Adding Records? (YES / NO) ");
            System.out.println();

            answer = input.next();
            String selection = answer.toLowerCase();

            switch (selection) {

                case "y":
                    addCustomer();

                case "yes":
                    addCustomer();

                case "n":
                    System.out.println("");

                    menu();

                case "no":
                    System.out.println("");

                    menu();
            }

        }

        while (!(answer.equalsIgnoreCase("y") || answer.equalsIgnoreCase("n")));

    }


//                                 *   DISPLAY EMPTY ROOMS   *

    public static void displayEmptyRooms() {

//          This method will display all the empty rooms

        for (int x = 0; x < 30; x++) {
            if (hotel[x].equals("e")) {
                System.out.println("room " + x + " is empty");
            }
        }

        System.out.println();

        menu();

    }

//                                  *    DELETE CUSTOMER    *

    public static void deleteCustomer() {

        boolean invalidInput;

        do {

            invalidInput = false;
            try {

                System.out.println();
                System.out.println(" Please Enter the Room's number which you want to vacate");
                roomNumber = input.nextInt();

//          if the hotel room is not empty then this will delete the customer from that room

                if (!(hotel[roomNumber].equals("e"))) {

                    invalidInput = false;
                    hotel[roomNumber] = "e";

                }

//          if the room is already empty this message will be displayed

                else {

                    invalidInput = true;
                    System.out.println("Room " + roomNumber + " is already Empty");
                    System.out.println();

                }
            }

//          If the input is not an integer value then this will catch it

            catch (InputMismatchException e){

                    invalidInput = true;
                    System.out.println();
                    System.out.println(TEXT_RED + "Invalid input! Please Enter a value between 0-30" + TEXT_RESET + TEXT_CYAN);
                    System.out.println();

                    input.next();
                }

//          If the input is out of the range of the hotel array this will catch it

            catch (IndexOutOfBoundsException e){

                    invalidInput = true;
                    System.out.println();
                    System.out.println(TEXT_RED + "Invalid input! Please Enter a value between 0-30" + TEXT_RESET + TEXT_CYAN);

                    input.next();
                }

            }

//          This will print the room's number which has been successfully vacated

            while (invalidInput) ;

            System.out.println("Room " + roomNumber + " has Successfully been Vacated");

            System.out.println();

            menu();

    }


//                                      *   FIND ROOM   *

        public static void findRoom () {

            System.out.println();
            System.out.println("Please Enter the Name of the Customer");

            boolean found = false;

            String find = input.next();


            for (int x = 0; x < 30; x++) {

/*          Used equalsIgnoreCase to avoid case sensitive issues while searching for a customer
            This method will find the room's number which is currently being occupied by the mentioned customer
*/

                if (hotel[x].equalsIgnoreCase(find)) {

                    found = true;
                    System.out.println("Mr. " + find + " is staying in room No. " + x);
                    System.out.println();

                    menu();

                }
            }

//          This will let you know if the customer is not there in the database

            if (found == false) {

                System.out.println();
                System.out.println(find + TEXT_RED +" doesn't exist on our database" + TEXT_RESET + TEXT_CYAN);
                System.out.println();

                menu();

            }

        }

//                                       *   STORE DATA   *

        public static void storeData() {

            try {

//              Saving Data and overwriting

                FileWriter fileWriter = new FileWriter("Data.txt" , false);
                BufferedWriter bw = new BufferedWriter(fileWriter);

                for (int x = 0; x < hotel.length; x++) {
                    String file;
                    file = hotel[x];


//              Writes Empty room if it find "e" on the array

                    if (file.equals("e")) {
                        bw.write("Empty Room " + x);
                    }


//              Writes the name of the customer from the array

                    else {
                        bw.write(file);
                    }

//              Line Seperator
                    bw.newLine();

//              Flushes the stream
                    bw.flush();

                }

//              will catch this exception if the Text file is not found

            } catch (IOException e) {

                System.out.println();
                System.err.println(TEXT_RED + " File not found ! " + TEXT_RESET + TEXT_CYAN);
            }

//          message to show the user that the array data has been saved to a Text file successfully

            System.out.println();
            System.out.println(" Data successfully saved ! ");
            System.out.println();

            menu();

        }


//                                          *   F O O D   *

        public static int numberOfPeople() {
            System.out.print(" Total number of people? ");
            Scanner input = new Scanner(System.in);

            try {
                int numberOfPeople = input.nextInt();
            }
            catch (InputMismatchException e) {
                System.out.println();
                System.out.println(TEXT_RED + "Invalid input! Please Enter a value " + TEXT_RESET + TEXT_CYAN);
            }

            return quantity;

        }


//                  Food Menu

        public static void foodMenu() {

            do {

                System.out.println();
                System.out.println("        ******** M E N U ********");
                System.out.println();

                System.out.println( " *  1.      BreakFast       *" );
                System.out.println( " *  2.      Lunch           *" );
                System.out.println( " *  3.      Dinner          *" );
                System.out.println( " *  4.      Exit            *" );

                System.out.println();


//          Prompt the user to enter his/her choice

                System.out.print("Enter number of your choice: ");
                int number_of_people = 0;

                Scanner input = new Scanner(System.in);
                String choice = input.next();
                System.out.println();

                try {

                    System.out.println("Enter number of People: ");
                    quantity = input.nextInt();
                }
                catch (Exception e){

                    System.out.println();
                    System.out.println(TEXT_RED + "Invalid input! Please Enter a value " + TEXT_RESET + TEXT_CYAN);
                }


                switch (choice) {

                    case "1":
                        System.out.println("    ----+ B R E A K F A S T +----");
                        breakfast();
                        OrderConfirmation(foodPrice(quantity, choice));
                        break;

                    case "2":
                        System.out.println("    ----+ L U N C H +----");
                        lunch();
                        OrderConfirmation(foodPrice(quantity, choice));
                        break;

                    case "3":
                        System.out.println("    ----+ D I N N E R +----");
                        dinner();
                        OrderConfirmation(foodPrice(quantity, choice));
                        break;

                    default:
                        System.out.println("");
                        System.out.println(TEXT_RED + "Invalid input! Please Enter a value " + TEXT_RESET + TEXT_CYAN);


                }

            }

            while (true);

        }


//             Break Fast

        public static void breakfast() {

            System.out.println();
            System.out.println(" Your Order contains: ");
            System.out.println();

            System.out.println(" *  Traditional Favourites");
            System.out.println(" *  Juices ");
            System.out.println(" *  Milk");
            System.out.println(" *  Pancakes");
            System.out.println(" *  Cereal");

        }

//              Lunch

        public static void lunch() {

            System.out.println();
            System.out.println(" Your Order contains: ");
            System.out.println();

            System.out.println(" *  Fried Rice");
            System.out.println(" *  Potato Wedges");
            System.out.println(" *  Salad ");
            System.out.println(" *  Beef Steak ");

        }

//               Dinner

        public static void dinner() {

            System.out.println("");
            System.out.println("Your Order contains: ");
            System.out.println();

            System.out.println(" *  Bread basket");
            System.out.println(" *  Soup ");
            System.out.println(" *  Fried Chicken ");
            System.out.println(" *  Hot Choclate ");

        }


//              Food Price

        public static int foodPrice(int quantity, String choice) {

            do {

                switch (choice) {

                    case "1":
                        food_price = quantity * 500;
                        break;

                    case "2":
                        food_price = quantity * 600;
                        break;

                    case "3":
                        food_price = quantity * 800;
                        break;


                }

                return food_price;

            }

            while (true);
        }


//              Order Confirmation

        public static void OrderConfirmation(int food_price) {

            System.out.println();
            System.out.println(" * 1.  Confirm Order  *");
            System.out.println(" * 2.  Exit           *");


            do {

                Scanner input = new Scanner(System.in);
                String order = input.next();


//              confirming order

                switch (order) {

                    case "1":
                        System.out.println();
                        System.out.println("..... ORDER CONFIRMED ! .....");
                        System.out.println();

                        System.out.println("Total Food Cost = Rs. " + food_price);

                        int order_no = (int) (Math.random() * 100);
                        System.out.println("Your Order Number = " + order_no);
                        System.out.println();

                        System.out.println("    Please Wait for your turn :)");
                        break;

                    case "2":
                        System.exit(0);
                        break;

                    default:
                        System.out.println();
                        System.out.println(TEXT_RED + "Invalid input! Please Enter a Value" + TEXT_RESET + TEXT_CYAN);

                }

                welcome();

            }

            while (true);
    }

}


