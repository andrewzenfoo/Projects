import java.util.Random;

/**
 * Created by andrew on 4/14/16.
 */
public class Personaggio {

    private static final int D20=20;

    private int armorClass;
    private int bonusAttaccoBase;

    public Personaggio(int armorClass, int bonusAttaccoBase) {
        this.armorClass = armorClass;
        this.bonusAttaccoBase = bonusAttaccoBase;
    }

    public int getBonusAttaccoBase() {
        return bonusAttaccoBase;
    }

    public void setBonusAttaccoBase(int bonusAttaccoBase) {
        this.bonusAttaccoBase = bonusAttaccoBase;
    }

    public int getArmorClass() {
        return armorClass;
    }

    public void setArmorClass(int armorClass) {
        this.armorClass = armorClass;
    }

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    public void toHit() {
       Random d20 = new Random();

       int tiro = (d20.nextInt(D20)+1);

       System.out.printf("%d + %d = %d\n", tiro, bonusAttaccoBase, tiro+bonusAttaccoBase);

       if (tiro + bonusAttaccoBase > armorClass) {
           System.out.println("Il nemico è stato colpito");
       }
       else {
           System.out.println("Mancato");
       }

       if (tiro == 20) {
           System.out.println("Minaccia di critico");
       }
    }

}
