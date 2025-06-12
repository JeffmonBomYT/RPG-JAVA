import java.util.Random;
import java.util.Scanner;

public class Sistema {
    Role role = new Role();
    Scanner scan = new Scanner(System.in);
    Random rng = new Random();

    int mons_nivel, mons_hp, mons_hpmax, mons_xp, mons_ad;
    String mons_chose;
    boolean attack_mons = true;
    boolean mons = true;

    int opc_hab, opc_encontro;
    boolean opc_fight = true;

/* 
//________________________________________________________________________________________________
    void mons_atq() {

            System.out.println("Voce machucou o monstro.\n"+mons_hp+"/"+mons_hpmax+"\n");

            if (mons_hp > 0) {
                hp -= mons_ad;
                System.out.println("O monstro te atacou");
                System.out.println(hp+"/"+hpMax+"\n");
            }

            if (hp <= 0 && mons_hp > 0) {
                hp = 0;
                System.out.println("[Hp: "+hp+"/"+hpMax+"] - [Mons. Hp: "+mons_hp+"/"+mons_hpmax+"]");
                System.out.println("Você foi derrotado. Eu tinha grandes esperanças em você, que decepção!");
            }
            else if (hp > 0 && mons_hp <= 0) {
                System.out.println("[Hp: "+hp+"/"+hpMax+"] - [Mons. Hp: "+mons_hp+"/"+mons_hpmax+"]");
                System.out.println("Parabéns, você derrotou o monstro.");
                xp += mons_xp;
                System.out.println("Xp recebida: "+xp+"");
            }

    }
//________________________________________________________________________________________________
    public void fight() {       

        do {
            System.out.println("\n|--------------------------------------|");
            System.out.format(" 1 - %s ", hab1Name);
            System.out.format("| %s - 2", hab2Name);
            System.out.println("\n ");
            System.out.format(" 3 - %s ", hab3Name);
            System.out.format("| Back - 4");
            System.out.println("\n|--------------------------------------|");
            System.out.print("\n> ");
            opc_hab = scan.nextInt();

            switch (opc_hab) {
                case 1:
                    mons_hp -= hab1;
                    break;
                case 2:
                    mons_hp -= hab2;
                    break;
                case 3:
                    mons_hp -= hab3;
                    break;
                default:
                    System.out.println("Opção inválida");
            }

            mons_atq();        

        } while(opc_hab < 1 || opc_hab > 4);

    } 
*/

//________________________________________________________________________________________________
    public void encontro() {

        System.out.println("[Hp: "+role.hp+"/"+role.hpMax+"]"+
        "\n[Xp: "+role.xp+"]"+
        "\n[Hab1: "+role.hab1+"]"+
        "\n[Hab2: "+role.hab2+"]"+
        "\n[Hab3: "+role.hab3+"]\n");

         while (mons) {
            System.out.println("|--------------------|");
            System.out.println("|1 - Fight |  Bag - 3|");
            System.out.println("|                    |");
            System.out.println("|3 - Swap  |  Run - 4|");
            System.out.println("|--------------------|");
            System.out.print("\n> ");
            opc_encontro = scan.nextInt();
              
              switch (opc_encontro) {
                 case 1:
                    fight();
                    mons = false;
                    break;
                 case 2:
                    //...
                    mons = false;
                    break;
                 case 3:
                    //...
                    mons = false;
                    break;                   
                 case 4:
                    //...
                    System.out.println("Sistema não implementado");
                    mons = false;
                    break;
                 default:
                    System.out.println("Comando inválido. tente novamente");                   
              }//switch
              
         }
    }
//________________________________________________________________________________________________
    
//________________________________________________________________________________________________

//________________________________________________________________________________________________

































public void gerar_criatura() {
         String[] lista_mons = {"Slime", "Esqueleto", "Orc", "Coelho assasino", "Lobo"};
         mons_chose = lista_mons[rng.nextInt(lista_mons.length)];         

        switch (mons_chose) {
            case "Slime" -> mons_nivel = rng.nextInt(1, 2);
            case "Esqueleto" -> mons_nivel = rng.nextInt(2,4);
            case "Orc" -> mons_nivel = rng.nextInt(4, 6);
            case "Coelho assasino" -> mons_nivel = rng.nextInt(1, 3);
            case "Lobo" -> mons_nivel = rng.nextInt(2, 5);
        } 

        switch (mons_nivel) {
            case 1 -> {
                mons_hpmax = rng.nextInt(1, 7);
                mons_hp = mons_hpmax;
                mons_ad = rng.nextInt(1, 5);
            }
            case 2 -> {
                mons_hpmax = rng.nextInt(6, 11);
                mons_hp = mons_hpmax;
                mons_ad = rng.nextInt(4, 10);
            }
            case 3 -> {
                mons_hpmax = rng.nextInt(10, 15);
                mons_hp = mons_hpmax;
                mons_ad = rng.nextInt(9, 13);
            }
            case 4 -> {
                mons_hpmax = rng.nextInt(14, 20);
                mons_hp = mons_hpmax;
                mons_ad = rng.nextInt(12, 17);
            }
            case 5 -> {
                mons_hpmax = rng.nextInt(19, 25);
                mons_hp = mons_hpmax;
                mons_ad = rng.nextInt(16, 22);
            }
            case 6 -> {
                mons_hpmax = rng.nextInt(24, 30);
                mons_hp = mons_hpmax;
                mons_ad = rng.nextInt(21, 29);
            }
            case 7 -> {
                mons_hpmax = rng.nextInt(29, 36);
                mons_hp = mons_hpmax;
                mons_ad = rng.nextInt(28, 33);
            }
            case 8 -> {
                mons_hpmax = rng.nextInt(35, 42);
                mons_hp = mons_hpmax;
                mons_ad = rng.nextInt(32, 40);
            }
            case 9 -> {
                mons_hpmax = rng.nextInt(41, 50);
                mons_hp = mons_hpmax;
                mons_ad = rng.nextInt(39, 45);
            }
            case 10 -> {
                mons_hpmax = rng.nextInt(49, 56);
                mons_hp = mons_hpmax;
                mons_ad = rng.nextInt(44, 49);
            }
         }
         //Xp
         mons_xp = mons_hpmax + mons_ad;

         System.out.println("Surge um monstro, o "+mons_chose+
                            "\n[Nvl: "+mons_nivel+"]"+
                            "\n[Vida: "+mons_hp+"/"+mons_hpmax+"]"+
                            "\n[Dano: "+mons_ad+"]\n");
    }     
//________________________________________________________________________________________________
    public void mons_atq() {

                if (mons_hp > 0) {
                    role.hp -= mons_ad;
                    System.out.println("O monstro te atacou");
                    System.out.println(role.hp+"/"+role.hpMax+"\n");
                    
                    if (role.hp >= 1) {
                        fight();
                    }
                }

                if (role.hp <= 0 && mons_hp >= 1) {
                    role.hp = 0;
                    System.out.println("Você foi derrotado. Eu tinha grandes esperanças em você, que decepção!");
                    System.out.println("[Hp: "+role.hp+"/"+role.hpMax+"] - [Mons. Hp: "+mons_hp+"/"+mons_hpmax+"]");
                }
                else if (role.hp >= 1 && mons_hp <= 0) {
                    mons_hp = 0;
                    System.out.println("Parabéns, você derrotou o monstro.");
                    System.out.println("[Hp: "+role.hp+"/"+role.hpMax+"] - [Mons. Hp: "+mons_hp+"/"+mons_hpmax+"]");
                    System.out.println("Xp recebida: "+role.xp+"");
                    role.xp += mons_xp;
                }

            } 

//________________________________________________________________________________________________
    public void fight() {       

        while(opc_fight) {
            System.out.println("\n|--------------------------------------|");
            System.out.format(" 1 - %s ", role.hab1Name);
            System.out.format("| %s - 2", role.hab2Name);
            System.out.println("\n ");
            System.out.format(" 3 - %s ", role.hab3Name);
            System.out.format("| Back - 4");
            System.out.println("\n|--------------------------------------|");
            System.out.print("\n> ");
            opc_hab = scan.nextInt();

            switch (opc_hab) {
                case 1:
                    mons_hp -= role.hab1;
                    System.out.println("Você machucou o monstro.\n"+mons_hp+"/"+mons_hpmax+"\n");
                    opc_fight = false;
                    break;
                case 2:
                    mons_hp -= role.hab2;
                    System.out.println("Você machucou o monstro.\n"+mons_hp+"/"+mons_hpmax+"\n");
                    opc_fight = false;
                    break;
                case 3:
                    mons_hp -= role.hab3;
                    System.out.println("Você machucou o monstro.\n"+mons_hp+"/"+mons_hpmax+"\n");
                    opc_fight = false;
                    break;
                default:
                    System.out.println("Opção inválida");
            }

        } 

           
    }
}
