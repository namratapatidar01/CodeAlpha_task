
import java.util.*;

class Room {
    int roomNo;
    String type;
    double price;
    boolean available;

    Room(int roomNo, String type, double price) {
        this.roomNo = roomNo;
        this.type = type;
        this.price = price;
        available = true;
    }
}

class Booking {
    String name; 
    int roomNo;
    int days;
    double amount;


    Booking(String name, int roomNo,  int days , double amount) {
        this.name = name ;
         this.roomNo = roomNo;
         this.days = days;
          this.amount = amount;

    }
}

public class HotelReservationSystem {

    static Scanner sc = new Scanner(System.in);
    static ArrayList<Room> rooms = new ArrayList<>();
    static ArrayList<Booking> bookings = new ArrayList<>();

    public static void main(String[] args) {
        rooms.add( new Room(101,"Standard",1500));
      rooms.add( new Room(102,"Standard",1500));
      rooms.add( new Room( 201,"Deluxe",2500));
      rooms.add( new Room(202,"Deluxe",2500));
      rooms.add( new Room(301,"Suite",4000));

        int choice;

        do {
            System.out.println("\n===== HOTEL RESERVATION SYSTEM =====");
            System.out.println("1. Show Rooms");
            System.out.println("2. Search Room ");
            System.out.println("3. Book Booking");
            System.out.println("4. View Booking");
            System.out.println("5. Cancel booking");
            System.out.println( "6. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    showRooms();
                    break;

                case 2:
                    searchRoom();
                    break;

                case 3:
                    bookRoom();
                    break;

                case 4:
                    viewBookings();
                    break;

                case 5:
                    cancelBooking();
                    break;
                    case 6:

                    System.out.println("Thank you!");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }

        } while (choice != 6);
    }

    static void showRooms() {

        System.out.println("\n--- Available Rooms ---");

        for (Room r : rooms) {
            if (r.available) {
                System.out.println("Room: " + r.roomNo +
                        "  Type: " + r.type +
                        "  Price: Rs." + r.price);
            }
        }
    }
    static  void searchRoom(){ 
        sc.nextLine();
        System.out.println( " Enter room catergory :");
    String type = sc.nextLine();
    boolean found = false;
    System.out.println("\n Search Result"
    );
    for( Room room : rooms){
        if  ( room.type.equalsIgnoreCase(type) && room.available){
            System.out.println( " Room" + room.roomNo + " |Rs." + room.price);
            found = true;
        }
    }if (! found){
        System.out.println( " No room available in this category");
    }
    }

    static void bookRoom() {

        sc.nextLine();
        System.out.println( " Enter your name :");

         String name = sc.nextLine();

        System.out.print("\nEnter room number: ");
        int roomNo = sc.nextInt();

        Room selectedRoom = null;

        for (Room room : rooms) {
            if (room.roomNo == roomNo ) {
                selectedRoom = room;
                break;
            }
        }

        if (selectedRoom == null) {
            System.out.println("Room is not available.");
            return;
        }

     if ( ! selectedRoom.available){
        System.out.println( " Room is already booked .");
        return;
     }

        System.out.println("Enter number of days: ");
        int days = sc.nextInt();
        double total = selectedRoom.price*days;

        System.out.print(" Total amount:Rs. " + total);
        

        System.out.print("confirm booking?( 1= yes, 2= No): ");
        int confirm = sc.nextInt();

        if ( confirm== 1) {
selectedRoom.available = false;
bookings.add( new Booking( name,roomNo,days,total));

            System.out.println(" Booking succesful ...");
            System.out.println("customer:" + name);
            System.out.println( " Room No:" + roomNo);
            System.out.println( " Total: Rs." + total);
        } else{
            System.out.println( "Booking cancelled.");
        }
    }




    static void viewBookings() {
    if ( bookings.isEmpty()){
System.out.println( "\n No bookings found ");
return;
    }
System.out.println( "\n----Booking Details----");
        for (Booking booking : bookings) {
                System.out.println("Customer:" + booking.name);
                System.out.println("Room Number: " + booking.roomNo);
                System.out.println("Days: " + booking.days);
                System.out.println(" Amount: Rs." + booking.amount);
                System.out.println( "-------------");
                return;
            }
    }
    




        static void cancelBooking() {

        System.out.print("Enter room no.: ");
        int roomNo = sc.nextInt();
         Booking foundbooking = null;


        for (Booking booking : bookings) {

            if (booking.roomNo == roomNo) {

                foundbooking = booking;
                break;
            }
        }
        if ( foundbooking == null){
        
        System.out.println("Booking not found.");
        return;
    }
    bookings.remove( foundbooking);
    for( Room room : rooms ){
        if ( room.roomNo == roomNo){
       room.available = true ;
       break;

        }
    }
System.out.println( " Booking cancelled successfully");
        }
    }