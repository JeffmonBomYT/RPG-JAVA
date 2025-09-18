
import java.util.Scanner;

public class Role {
    Scanner scan = new Scanner(System.in);

    public String classe, name;
    public int hp;
    public int hpMax;
    public int nivel, xp, xpMax;
    public int hab1, hab2, hab3;
    public String hab1Name, hab2Name, hab3Name;

    private int opcSelectClass;
    private String opcStatus;
//=================================================
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
            opcSelectClass = scan.nextInt();

            switch (opcSelectClass) {
                case 1:
                    classe = "Cavaleiro";
                    nivel = 0;
                    xp = 0;
                    xpMax = 50;
                    hpMax = 20;
                    hp = hpMax;
                    hab1 = 10;
                    hab1Name = "Mellee Atk";
                    hab2 = 15;
                    hab2Name = "Strg. Atk";
                    hab3 = 20;
                    hab3Name = "Divn. Smite";
                break;
                case 2:
                    classe = "Mago";
                    nivel = 0;
                    xp = 0;
                    xpMax = 30;
                    hpMax = 12;
                    hp = hpMax;
                    hab1 = 6;
                    hab1Name = "Magc. Atk";
                    hab2 = 9;
                    hab2Name = "Magc. Missiles";
                    hab3 = 15;
                    hab3Name = "Fire Ball";
                break;
                case 3:
                    classe = "Arqueiro";
                    nivel = 0;
                    xp = 0;
                    xpMax = 40;  
                    hpMax = 16;
                    hp = hpMax;
                    hab1 = 9;
                    hab1Name = "Bow Shot";
                    hab2 = 12;
                    hab2Name = "Precs. Atk";
                    hab3 = 18;
                    hab3Name = "Giant Arrow";
                break;
                default:
                    System.out.println("\nClasse não existente ou escrita incorretamente");
                break;
            }
        } while (opcSelectClass < 1 || opcSelectClass > 3);

        System.out.println("Desejas ver os status da classe? - S/N");
        System.out.print("\n> ");
        opcStatus = scan.next().toUpperCase();
        if(opcStatus.equals("S")) {
            mostrarStatus();   
        }
    }
//--------------------------------------------------------------
    public void mostrarStatus() {
        System.out.println("\n|-------------------|");
        System.out.println(" [Classe: "+classe+"]");
        System.out.println(" [Hp: "+hp+"/"+hpMax+"]");
        System.out.println(" [Xp: "+xpMax+"]");
        System.out.println(" [Hab1: "+hab1+"]");
        System.out.println(" [Hab2: "+hab2+"]");
        System.out.println(" [Hab3: "+hab3+"]");
        System.out.println("|-------------------|\n");

        ZaWardo();
    }
//--------------------------------------------------------------
    public void ZaWardo() {
        try {
            Thread.sleep(1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
//--------------------------------------------------------------
    public void verificarXP() {
        if (xp >= xpMax) {
            int xpTemp = Math.abs(xp - xpMax);
            System.out.println("\nParabéns, você subiu de nivel! "+nivel+" -> "+(nivel+1));     
            nivel++;
            xpMax += 15;
            xp = xpTemp;
        }
    }
//--------------------------------------------------------------
    
//--------------------------------------------------------------

//--------------------------------------------------------------
    

}

/*
    Implementar um sistema que faça com que seja atribuído por nivel de personagem:
    XpMax e fazer com que se Xp chegar a XpMax aumentar o nivel do  jogador e atribuir um 
    novo valor (talvez baseado em algum calculo) à XpMax
*/