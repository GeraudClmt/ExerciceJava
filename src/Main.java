//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Le hello de geraud");
        System.out.println("Je vais taider à déménager !!!");
        int nbVoyages = 0;
        int nbTotalCartons = 0;
        int truckCapacity = 0;
        boolean isNumbernbTotalCartons = false;
        boolean isNumbertruckCapacity = false;

        while (!isNumbernbTotalCartons) {
            System.out.println("Combien de cartons avez vous ?");
            if(input.hasNextInt()) {
                nbTotalCartons = input.nextInt();
                if(nbTotalCartons > 0) {
                    isNumbernbTotalCartons = true;
                }else{
                    System.out.println("Le nombre doit être supérieur à O !");
                }
            }else{
                System.out.println("Ce n'est pas un nombre. Réessayez !");
                input.next();
            }
        }
        while(!isNumbertruckCapacity) {
            System.out.println("Combien de cartons on peut mettre dans votre camion ?");
            if(input.hasNextInt()) {
                truckCapacity = input.nextInt();
                if(truckCapacity > 0) {
                    isNumbertruckCapacity = true;
                }else{
                    System.out.println("Le nombre doit être supérieur à O !");
                }
            }else{
                System.out.println("Ce n'est pas un nombre. Réessayez !");
                input.next();
            }
        }
        input.close();

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
        System.out.println("Terminé, avec "+ nbVoyages + " voyages");

    }
}
