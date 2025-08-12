//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        System.out.println("Le hello de geraud");
        System.out.println("Je vais taider à déménager !!!");

        Scanner scanner = new Scanner(System.in);
        int nbTotalCartons = positifNumber(scanner, "Combien de cartons avez vous ?");
        int truckCapacity = positifNumber(scanner, "Combien de cartons on peut mettre dans votre camion ?");
        scanner.close();

        int nbVoyages = countNbVoyage(nbTotalCartons, truckCapacity);
        System.out.println("Terminé, avec "+ nbVoyages + " voyages");

    }
    public static int positifNumber(Scanner scanner, String message){
        boolean isNumber = false;
        int positifNumber = 0;

        while (!isNumber) {
            System.out.println(message);
            if(scanner.hasNextInt()) {
                positifNumber = scanner.nextInt();
                if(positifNumber > 0) {
                    isNumber = true;
                }else{
                    System.out.println("Le nombre doit être supérieur à O !");
                }
            }else{
                System.out.println("Ce n'est pas un nombre. Réessayez !");
                scanner.next();
            }
        }
        return positifNumber;
    }

    public static int countNbVoyage(Integer nbTotalCartons, Integer truckCapacity){
        int nbVoyages = 0;
        while(nbTotalCartons > 0){
            if(nbTotalCartons >= truckCapacity){
                nbTotalCartons-=truckCapacity;
                System.out.println("Un voyage de " + truckCapacity + " cartons");
            }else {
                System.out.println("Un voyage de " + nbTotalCartons + " cartons");
                nbTotalCartons-=nbTotalCartons;
            }
            nbVoyages++;
        }
        return nbVoyages;
    }
}
