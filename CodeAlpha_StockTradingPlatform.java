import java.util.ArrayList;
import java.util.Scanner ;
public class StockTradingPlatform {
    static class Stock {
        String name; 
        double price; 
        int quantity ;
        Stock ( String name , double price ){
            this.name = name ;
            this.price = price;
            this.quantity = 0;


        }
    }
    static ArrayList<Stock> stocks = new ArrayList<>();
   static Scanner sc = new Scanner( System.in);
   public static void main ( String [] args ){
    stocks.add ( new Stock( " TCS",3500));
    stocks.add ( new Stock ( " Infosys",1600) );
    stocks.add ( new Stock( " Reliance", 2900));
    stocks.add ( new Stock( " HDFC",1700));
    int choice ;
     do{
         System.out.println( "==== Stock Tranding Platform ====");
         System.out.println( " 1. view market ");
         System.out.println( "2. Buy stock");
         System.out.println( "3. Sell stock");
         System.out.println( "4. View Portfolio");
         System.out.println( " 5. Exit");
         System.out.println( "Enter your choice :");
         choice= sc.nextInt();
        switch( choice){
            case 1:
                showMarket();
                    break;
                     case 2:
                        buyStock();
                        break;
                        case 3:
                            sellStock();
                            break;
                            case 4 :
                                 showPortfolio();
                            break;
                            case 5:
                              System.out.println( "Thank you for using the platform .");  
                break;
                default:
                    System.out.println( " Please enter a valid choice ");

        }
     } while (choice !=5); 
        sc.close();
        
     }
    
    static void showMarket(){
        System.out.println( "\n----- Market data -----");
        for(
            int i = 0 ;  i<stocks.size(); i++

        ){
            Stock s = stocks.get(i);
            System.out.println( ( i+1)+". " + s.name + " -Rs." + s.price);

        }
    }
    static void buyStock(){
        showMarket();
        System.out.print( "\n Enter stock number:");
        int number = sc.nextInt();
        if( number <1 || number > stocks.size()){
            System.out.println( " inavlid stock number .");
            return;
        }
        Stock s= stocks.get( number - 1);
        System.err.println( " Enter quantity:");
        int quantity = sc.nextInt();
        if( quantity <= 0){ 
            System.out.println( "invlid quantity ");
            return;
        }
        s.quantity = s.quantity + quantity ;
        double amount = s.price + quantity ;
        System.out.println( "\n Stock bought successfully.");
        System.out.println( " Stock:"+ s.name);
        System.out.println( " Quantity :"+ quantity );
        System.out.println( " Amount: Rs." + amount);

    }
    static void sellStock(){
        showPortfolio();
        System.out.println( " \n Enter stock number:");
        int number = sc.nextInt();
        if(number<1||number>stocks.size()){
            System.out.println( " invalid stock number .");
            return;
        }
        Stock s = stocks.get( number -1 );
        if( s.quantity==0){
            System.out.println("you do not have this stock.");
            return;

        }
        System.out.println( " Enter quantity of sell.");
        int quantity = sc.nextInt();
        if ( quantity<=0 || quantity>s.quantity ){
System.out.println( " Invalid quantity .");
return;

        }
        s.quantity= s.quantity-quantity;
        double amount = s.price* quantity;
        System.out.println( "\n Stock sold sucessfully ");
        System.out.println( " stock: " + s.name);
System.out.println( "Quantity:" + quantity);
System.err.println( " Amount received:Rs." + amount);

    }
    static void showPortfolio(){
        System.out.println("\n----My Portfolio----");
        boolean found = false ;
        for( int i= 0; i<stocks.size(); i++){
        Stock s = stocks.get(i);
        if (s.quantity>0){
            found = true ;
            double value =  s.price*s.quantity;
            System.out.print( (i+1)+ "." + s.name + " - Quantity: " + s.quantity + " - Value: Rs." + value
            );
        }

        }

       if( ! found){
        System.out.println( " No stocks in portfolio.");

       }

    }

   }

