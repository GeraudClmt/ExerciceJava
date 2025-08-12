//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        System.out.println("Le hello de geraud");
        System.out.println("Je vais taider à déménager !!!");

        int nbTotalCartons = 34;
        int nbVoyages = 0;

        while(nbTotalCartons > 0){
            if(nbTotalCartons >= 9){
                nbTotalCartons-=9;
                System.out.println("Un voyage de 9 cartons");
            }else {
                System.out.println("Un voyage de " + nbTotalCartons + " cartons");
                nbTotalCartons-=nbTotalCartons;
            }
            nbVoyages++;
        }
        System.out.println("Terminé, avec "+ nbVoyages + " voyages");

    }
}
