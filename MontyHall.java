import java.util.Scanner;

public class MontyHall{

  public static void main(String[] args){
    /**
    * Main method that java runs
    * @param args This is the command line
    * @return This method does not return anything
    */

    init();
    game();
  }
  public static void init(){
    /**
    * This method displays the first messages upon running the program
    * @param No parameters
    * @return No return type
    */
    System.out.println("Welcome to the Monty Hall Game!");
    System.out.print("The rules are simple: There is a car hidden in one of 3 doors.");
    System.out.println("You must correctly guess which door it is in");
  }

  public static void game(){
    /**
    * This method contains the text and procedure of the game
    * Starts by generating car position and asking user for their guess
    * Then reveals the door that was neither guessed nor has the car in it
    * Asks user if they want to switch
    * @param No parameters
    * @return Method does not return anything
    */
    Scanner s = new Scanner(System.in);

    // random generate car position
    int car = (int)(Math.random() * 3 + 1);

    // user guess
    System.out.println("Please pick a door (1, 2, or 3): ");
    int guess = s.nextInt();
    // clear new line from buffer
    s.nextLine();

    // Reveal door
    System.out.println("I will now reveal a door.");
    int reveal = doorReveal(car, guess);
    System.out.println("Door " + reveal + " contains a goat");

    // Asks user if they want to switch
    System.out.println("Would you like to switch doors  ? (yes/no)");
    String swap = s.nextLine();

    // Cases for if user is right or wrong
    if(swap.equalsIgnoreCase("yes") && guess != car){
      System.out.println("Great job! You have switched doors and guessed correctly.");
    } else if(swap.equalsIgnoreCase("yes") && guess == car){
      System.out.println("Sorry! You switched doors but were incorrect.");
    } else if(swap.equalsIgnoreCase("no") && guess == car){
      System.out.println("Great job! You did not switch doors and you were correct.");
    } else if(swap.equalsIgnoreCase("no") && guess != car){
      System.out.println("Sorry! You did not switch and you were incorrect.");
    }

  }
  public static int doorReveal(int carPosition, int userGuess){
    /**
    * This method returns the door that has not been guessed or has the car in it
    * Uses a for loop given the car position and guess position
    * Loops thru values 1,2,3 and if it is not equal to both cars position and goats position
    * will return goat
    * @param carPosition int of door car is in
    * @param userGuess int of users guess of where car is
    * @return int
    */
    for(int goat = 1; goat < 4; goat++){
      if(!(goat == carPosition || goat == userGuess))
        return goat;
    }
    return -1;
  }
}
