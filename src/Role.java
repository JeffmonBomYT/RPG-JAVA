import java.util.Random;
import java.util.Scanner;

public class Role {
    Scanner scan = new Scanner(System.in);
    Random rng = new Random();

    String classe, nome;
    int hp;
    int hpMax;
    int dano;
    int nvl, xp=0;
    int hab1, hab2, hab3;
    String hab1Name, hab2Name, hab3Name;

    int opc_char;
    String opc_status;

//________________________________________________________________________________________________
    public void escolherClasse() { 
        do {
            System.out.println("\n|----------------------|");
            System.out.println("|  Escolha sua classe  |");
            System.out.println("| -------------------- |");
            System.out.println("| 1 - Cavaleiro        |");
            System.out.println("| 2 - Mago             |");
            System.out.println("| 3 - Arqueiro         |");
            System.out.println("|----------------------|");
            System.out.print("\n> ");
            opc_char = scan.nextInt();

        switch (opc_char) {
            case 1:          
                classe = "Cavaleiro";
                nvl = 1;
                hpMax = 20;
                hp = hpMax;
                hab1 = 10; 
                hab1Name = "Mellee atq";
                hab2 = 15; //(12 + 3)
                hab2Name = "Str. attack";
                hab3 = 20;
                hab3Name = "Div. Smite";

                break;
            case 2:
                classe = "Mago";
                nvl = 1;
                hpMax = 12;
                hp = hpMax;
                hab1 = 6;
                hab1Name = "Mag. attack";
                hab2 = 9; //(6 * 1.5)
                hab2Name = "Mag. missiles";
                hab3 = 15;
                hab3Name = "Fire Ball";

                break;
            case 3:
                classe = "Arqueiro";
                nvl = 1;
                hpMax = 16;
                hp = hpMax;
                hab1 = 9; 
                hab1Name = "Bow Shot";
                hab2 = 12; //(9 + 3) 
                hab2Name = "Pres. Shot";
                hab3 = 18;
                hab3Name = "Giant Arrow";

                break;
            default:
                System.out.println("\nClasse não existe ou foi escrita incorretamente");
        } 
        
        } while (opc_char > 3 || opc_char < 1);   
        
            System.out.println("\nDesejas ver os status de sua classe? S/N");
            System.out.print("\n> ");
            opc_status = scan.next().toUpperCase();

            if (opc_status.equals("S")) {
                    System.out.println("\n|-------------------|");
                    System.out.println(" Classe: "+classe);
                    System.out.println(" Hp: "+hp+"/"+hpMax);
                    System.out.println(" Xp: "+xp);
                    System.out.println(" Hab1: "+hab1);
                    System.out.println(" Hab2: "+hab2);
                    System.out.println(" Hab3: "+hab3);
                    System.out.println("|-------------------|\n");
            }
            
    }
//________________________________________________________________________________________________
}