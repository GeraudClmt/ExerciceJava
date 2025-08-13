import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
/**
 * Main class for the moving program
 */
public class Main {
    private static FileWriter logs;
    /**
     *
     * @param args The arguments passed on the command line
     */
    public static void main(String[] args) {
        try {
            logs = new FileWriter("logs.txt", true);
        }catch(IOException e){
            System.out.println(e.getMessage());
        }

        showMessage("Le hello de geraud");
        showMessage("Je vais taider à déménager !!!");

        Scanner scanner = new Scanner(System.in);
        int totalCardboard = positifNumber(scanner, "Combien de cartons avez vous ?");
        int truckCapacity = positifNumber(scanner, "Combien de cartons on peut mettre dans votre camion ?");
        scanner.close();

        int tripCount = countNbVoyage(totalCardboard, truckCapacity);
        showMessage("Terminé, avec "+ tripCount + " voyages");

        try {
            logs.close();
        }catch(IOException e){
            System.out.println(e.getMessage());
        }

    }

    /**
     *
     * @param message The message to display in the console
     */
    public static void showMessage(String message){
        System.out.println(message);

        LocalDateTime nowDateAndTime = LocalDateTime.now();
        DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formatedNowDateAndTime = nowDateAndTime.format(format);

        try {
            logs.write(formatedNowDateAndTime + " " + message +"\n");
        }catch(IOException e){
            System.out.println(e.getMessage());
        }
    }

    /**
     *
     * @param scanner The input scanner
     * @param message The message to display when entering data
     * @return The correct number entered by the user, if it is positive
     */
    public static int positifNumber(Scanner scanner, String message){
        boolean isNumber = false;
        int positifNumber = 0;

        while (!isNumber) {
            showMessage(message);
            if(scanner.hasNextInt()) {
                positifNumber = scanner.nextInt();
                if(positifNumber > 0){
                    isNumber = true;
                }else{
                    showMessage("Le nombre doit être supérieur à O !");
                }
            }else{
                showMessage("Ce n'est pas un nombre. Réessayez !");
                scanner.next();
            }
        }
        showMessage(Integer.toString(positifNumber));
        return positifNumber;
    }

    /**
     *
     * @param totalCardboard Number of boxes to move
     * @param truckCapacity Number of boxes that can be moved in one truck trip
     * @return The number of trips for the move
     */
    public static int countNbVoyage(Integer totalCardboard, Integer truckCapacity){
        int tripCount = 0;
        while(totalCardboard > 0){
            if(totalCardboard >= truckCapacity){
                totalCardboard-=truckCapacity;
                showMessage("Un voyage de " + truckCapacity + " cartons");
            }else {
                showMessage("Un voyage de " + totalCardboard + " cartons");
                totalCardboard-=totalCardboard;
            }
            tripCount++;
        }
        return tripCount;
    }
}
