import java.util.Scanner;

public class Input {

    public static void calculateToHit() {
        Scanner in = new Scanner(System.in);

        for (;;) {

            Personaggio pg = new Personaggio(0, 0);

            System.out.println();

            System.out.print("Inserire la CA del pg: ");
            pg.setArmorClass(in.nextInt());
            //System.out.println();

            System.out.print("Inserire il bonus d'attacco base del pg: ");
            pg.setBonusAttaccoBase(in.nextInt());
            //System.out.println();

            pg.toHit();
        }
    }
}






