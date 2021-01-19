import  java.util.*;
import  java.util.Scanner; // Scanner Package

/**
 *This is a simple Menu Ordering System
 *This allows user to compute restaurant bills
 *auther Joever-EF
 */

public class OrderingSystem {
    public Scanner input = new Scanner(System.in); // Recieves user inputs
    public double total; 
    public ArrayList<String> menu = new ArrayList<>(Arrays.asList("Special", "Super", "Extra", "Supreme", "Soda", "Bread")); // list of menu
    public ArrayList<Double> menuPrice = new ArrayList<>(Arrays.asList(40.0, 45.0, 50.0, 70.0, 15.0, 7.0)); // list of prices

    public OrderingSystem() {

    }
    /**
     * this methods shows all the details in the menu.
     */

    public static void stringMenu() { 
        System.out.println("\t\t\t\t+===============***===================+");
            System.out.println("\t\t\t\t+           --WELCOME--               +");
            System.out.println("\t\t\t\t+===============***===================+");
            System.out.println("\t\t\t\t           Batchoyan menu         ");
            System.out.println("\t\t\t\t    1. Special          Php: 40.00");
            System.out.println("\t\t\t\t    2. Super            Php: 45.00");
            System.out.println("\t\t\t\t    3. Extra            Php: 50.00");
            System.out.println("\t\t\t\t    4. Supreme          Php: 70.00");
            System.out.println("\t\t\t\t    5. Soda             Php: 15.00");
            System.out.println("\t\t\t\t    6. Bread            Php: 07.00");
            System.out.println("\t\t\t\t    7. CANCEL                     ");
            System.out.println("\t\t\t\t+===============***===================+");
    }
    /**
     * methods is for representation of the order by size and prices
     */

    public void stringChooseOrder() {
        for(int i = 1; i <= menu.size(); i++) {
            System.out.printf("Press %d for %s, \n", i, menu.get(i - 1));
        }

        System.out.println("Press 7 to Cancel");
        System.out.println("Press what you want to buy?");
    }
    /**
     * method gets the input to choose the order.
     */

    public String getOrderName(int choose) {
        return menu.get(choose);
    }
    /**
     * gets the price
     */

    public Double getPrice(int choose) {
        return menuPrice.get(choose);
    }

    /**
     * sums up the total amount
     */

    public void order(int choose, int quantity) {
        total = total + (quantity * menuPrice.get(choose));
    }
    /**
     * method deducts the total to the amount given to get the change
     */

    public Double getChange(double pay) {
        return pay - total;
    }

    /**
     * methods shows all the steps during progressing inputs.
     */

    public void startOrder() {
		stringChooseOrder(); //call the method to see the item's menu
		int choose = input.nextInt(); //inputs the chosen order
        
        if (choose > 0 && choose < 7) {
            System.out.printf("You choose %s \n", menu.get(choose - 1));
            System.out.printf("The price for 1 order of %s is Php %.2f \n", menu.get(choose - 1), menuPrice.get(choose - 1));
            System.out.println("How many do you want to buy?");
            
            int quantity = input.nextInt(); 
            order(choose - 1, quantity); // gets the quantity of the order

            System.out.println("Do you want to add another order?");
			System.out.println("Press Y for yes, N for no");
            String add = input.next(); 
            
            if (add.equalsIgnoreCase("Y")){ 
				startOrder(); // call the method to create another order
				// proceeds if yes, no goes down to else
			} else {
				System.out.println("Enter your Money: "); // inputs the money of the user
				Double pay = input.nextDouble();
                 
                if(pay < total){ // checker if the money is less than the total cost and prompts the error
					System.out.println("Money insufficient!");
				} else{
                    System.out.println("Total price is: " + total); 
                    System.out.println("Amount change is: " + getChange(pay)); // calls getChange to settle the amount
                }
            }
        } else if (choose == 7) {
            System.out.print("Thank you for coming! :D");
			System.exit(0); // use to close the program
        } else{
			System.out.println("Choose only from 1 to 5!");
        }
	}


    public static void main(String[] args){
        OrderingSystem orderingSystem = new OrderingSystem();
        orderingSystem.stringMenu();
        orderingSystem.startOrder();
    }
 }
  