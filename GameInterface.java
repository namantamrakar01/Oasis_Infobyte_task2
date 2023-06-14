import java.util.Random;
import java.util.Scanner;

class GameFunctions
{
    int sysinput;
    int usinput;
    int numofguess = 0;

    GameFunctions() {
        Random random = new Random();
        this.sysinput = random.nextInt(100) + 1;
    }

    public boolean userInput(){
        if(numofguess < 10){
            System.out.println("Guess the number: ");
            this.usinput = GameInterface.takeIntegerInput(100);
            numofguess++;
            return false;
        }
        else {
            System.out.println("Number of attempts finished.");
            return true;
        }
    }


    public boolean Correct() {
        if(sysinput == usinput){
            System.out.println("Congratulation, you have guessed the number!!");
            System.out.println("Number of Guesses - " + numofguess);

            switch (numofguess){
                case 1:
                    System.out.println("Your score is 100");
                    break;

                case 2:
                    System.out.println("Your score is 90");
                    break;

                case 3:
                    System.out.println("Your score is 80");
                    break;

                case 4:
                    System.out.println("Your score is 70");
                    break;

                case 5:
                    System.out.println("Your score is 60");
                    break;

                case 6:
                    System.out.println("Your score is 50");
                    break;

                case 7:
                    System.out.println("Your score is 40");
                    break;

                case 8:
                    System.out.println("Your score is 30");
                    break;

                case 9:
                    System.out.println("Your score is 20");
                    break;

                case 10:
                    System.out.println("Your score is 10");
                    break;

            }
            System.out.println();
            return true;
        }
        else if ( numofguess < 10 && usinput > sysinput ) {
            if ( usinput - sysinput > 10 ) {
                System.out.println("Too High");
            }
            else {
                System.out.println("Little High");
            }
        }
        else if ( numofguess < 10 && usinput < sysinput ) {
            if ( sysinput - usinput > 10 ) {
                System.out.println("Too low");
            }
            else {
                System.out.println("Little low");
            }
        }
        return false;
    }

}


//Main class
public class GameInterface {
//    Scanner sc = new Scanner(System.in);
    public static int takeIntegerInput(int limit) {
        int input = 0;
        boolean temp = false;

        while (!temp) {
            try {
                Scanner sc = new Scanner(System.in);
                input = sc.nextInt();
                temp = true;

                if (temp && input > limit || input < 1) {
                    System.out.println("Choose the number between 1 to " + limit);
                    temp = false;
                }
            } catch (Exception e) {
                System.out.println("Enter only integer value");
                temp = false;
            }
        }
        ;
        return input;
    }

    //Main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to the Number Guessing Game.");
        System.out.println("To start the game enter 1 or to exit enter 2");
        int select = takeIntegerInput(2);
        int nextRound = 1;
        int numofrounds = 0;
        if(select == 1){
            while(nextRound == 1){
                GameFunctions gamef = new GameFunctions();
                boolean Matched = false;
                boolean LimitCrossed = false;
                System.out.println("Round " + numofrounds + " starts...");

                while(!Matched && !LimitCrossed){
                    LimitCrossed = gamef.userInput();
                    Matched = gamef.Correct();
                }

                System.out.println("Round " + numofrounds + " ends.\n");
                System.out.println("If you want to play another round enter 1 of if you want to exit enter 2");
                nextRound = takeIntegerInput(2);
                if(nextRound != 1){
                    System.exit(0);
                }
            }
        }
        else {
            System.exit(0);
        }
    }
}
