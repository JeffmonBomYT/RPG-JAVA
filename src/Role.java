import java.util.Random;
import java.util.Scanner;

public class Role {
    Scanner scan = new Scanner(System.in);

    String classe, nome;
    int hp;
    int hpMax;
    int dano;
    int nvl, xp=0;
    int hab1, hab2, hab3;
    String hab1Name, hab2Name, hab3Name;

    int mons_nivel, mons_hp, mons_hpmax, mons_xp, mons_ad;

    int opc_char, opc_hab;
    String opc_status, opc_encontro;
    boolean mons = true;

//________________________________________________________________________________________________
    void op() {
                         
        System.out.println("[GENERIC HERO] (T-RPG)");
        System.out.println("\nDesejas jogar [GENERIC HERO]? - S/N");
        System.out.print("\n> ");
        String opc_op = scan.next().toLowerCase();
        
        if (opc_op.equals("s")) {
            System.out.println("\nSEJA BEM-VINDO AO MUNDO DE THURFEND");
            System.out.println("\nVOCE ESTÁ AMBIENTADO COM JOGOS DE TEXT-RPG? - S/N");
            System.out.print("\n> ");
            String opc_tutorial = scan.next().toUpperCase();

        switch (opc_tutorial) {
            case "N":
                System.out.println("\nEm um text-rpg, voce decide acoes digitando letras ou textos no prompt quando solicitado, resultando em uma acao. ");
                System.out.println("___________________________________");
                break;
            case "S":
                break;
                
            default:
                System.out.println("Comando digitado incorretamente.");
        }

        System.out.println("\nQUAL SERÁ O NOME DO HERÓI QUE PARTICIPARÁ DE CANTIGAS DE BARDOS?");
        System.out.print("\n> ");
        nome = scan.next();
        System.out.println("\n"+nome+"? BELO NOME, PORÉM, SÓ COM NOME NÃO SE DERROTA O MAL. ENTÃO, QUAL É SEU ESTILO DE COMBATE?");
        
        escolherClasse(); 

        }
        else if (opc_op.equals("n")) {
            System.out.println("Adeus.");
            System.exit(1);
        }
         
    }
//________________________________________________________________________________________________
    String escolherClasse() { 
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
       
        return classe;

    }
//________________________________________________________________________________________________
    void gerar_criatura() {
        Random rnd = new Random();
         String[] lista_mons = {"Slime", "Esqueleto", "Orc", "Coelho assasino", "Lobo"};
         String mons_chose = lista_mons[rnd.nextInt(lista_mons.length)];         

        switch (mons_chose) {
            case "Slime" -> mons_nivel = rnd.nextInt(1, 2);
            case "Esqueleto" -> mons_nivel = rnd.nextInt(2,4);
            case "Orc" -> mons_nivel = rnd.nextInt(4, 6);
            case "Coelho assasino" -> mons_nivel = rnd.nextInt(1, 3);
            case "Lobo" -> mons_nivel = rnd.nextInt(2, 5);
        } 

        switch (mons_nivel) {
            case 1 -> {
                mons_hpmax = rnd.nextInt(1, 7);
                mons_hp = mons_hpmax;
                mons_ad = rnd.nextInt(1, 5);
            }
            case 2 -> {
                mons_hpmax = rnd.nextInt(6, 11);
                mons_hp = mons_hpmax;
                mons_ad = rnd.nextInt(4, 10);
            }
            case 3 -> {
                mons_hpmax = rnd.nextInt(10, 15);
                mons_hp = mons_hpmax;
                mons_ad = rnd.nextInt(9, 13);
            }
            case 4 -> {
                mons_hpmax = rnd.nextInt(14, 20);
                mons_hp = mons_hpmax;
                mons_ad = rnd.nextInt(12, 17);
            }
            case 5 -> {
                mons_hpmax = rnd.nextInt(19, 25);
                mons_hp = mons_hpmax;
                mons_ad = rnd.nextInt(16, 22);
            }
            case 6 -> {
                mons_hpmax = rnd.nextInt(24, 30);
                mons_hp = mons_hpmax;
                mons_ad = rnd.nextInt(21, 29);
            }
            case 7 -> {
                mons_hpmax = rnd.nextInt(29, 36);
                mons_hp = mons_hpmax;
                mons_ad = rnd.nextInt(28, 33);
            }
            case 8 -> {
                mons_hpmax = rnd.nextInt(35, 42);
                mons_hp = mons_hpmax;
                mons_ad = rnd.nextInt(32, 40);
            }
            case 9 -> {
                mons_hpmax = rnd.nextInt(41, 50);
                mons_hp = mons_hpmax;
                mons_ad = rnd.nextInt(39, 45);
            }
            case 10 -> {
                mons_hpmax = rnd.nextInt(49, 56);
                mons_hp = mons_hpmax;
                mons_ad = rnd.nextInt(44, 49);
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
    void mons_atq() {
        do {
            hp -= mons_ad;
            
            if (mons_hp > 0) {
                System.out.println("O monstro te atacou");
                System.out.println(hp+"/"+hpMax+"\n");
            }

            if (hp <= 0 && mons_hp > 0) {
                hp = 0;
                System.out.println("Voce foi derrotado. Eu tinha grandes esperanças em você, que decepção!");
                break;
            }
            else {
                System.out.println("Parabéns, você derrotou o monstro. sua recompensa: \n["+mons_xp+"] Xp");
                xp += mons_xp;
                System.out.println("[Xp: "+xp+"]");
            }

            return;

        } while (mons_hp >= 0);

    }
//________________________________________________________________________________________________
    void fight() {       

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

            if (mons_hp <= 0) {
                mons_hp = 0;
            }

            System.out.println("Voce machucou o monstro.\n"+mons_hp+"/"+mons_hpmax+"\n");

            mons_atq();

        } while(opc_hab < 1 || opc_hab > 4);

    }
//________________________________________________________________________________________________
    void encontro() {

        System.out.println("[Hp: "+hp+"/"+hpMax+"]"+
        "\n[Xp: "+xp+"]"+
        "\n[Hab1: "+hab1+"]"+
        "\n[Hab2: "+hab2+"]"+
        "\n[Hab3: "+hab3+"]\n");

         while (mons) {
            System.out.println("|--------------------|");
            System.out.println("|1 - Fight |  Bag - 3|");
            System.out.println("|                    |");
            System.out.println("|3 - Swap  |  Run - 4|");
            System.out.println("|--------------------|");
            System.out.print("\n> ");
            opc_encontro = scan.next().toLowerCase();
              
              switch (opc_encontro) {
                 case "fight":
                    fight();
                    mons = false;
                    break;
                 case "bag":
                    //...
                    mons = false;
                    break;
                 case "swap":
                    //...
                    mons = false;
                    break;                   
                 case "run":
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




}




        //case "MAGO":
        //          Classe = new int[] {/*Hp*/12,/*HPMax*/12, /*Hab1*/6, /*Hab2*/9, /*Hab3*/15};

/*

 IDEIAS:

- tela inicial ##
    L> escolher nome ##
- escolher classe 


- ## gerar um monstro  
- ## encontro com monstros  
     L> talvez batalha dupla
    ## L> interface de batalha 
    ## L> interface de espólio / derrota

- cidades
- viajem
    L> chance de algo acontecer

- descanso    
    L> estabelecimentos
    L> ao ar livre


---------------------------------|
<cidade inicial>
- acampamento de guerra
- general - guia de introducao 
                 L> 1º combate
                 L> acoes basicas

---------------------------------|
TIRAR TEMPORARIAMENTE:
- por ora, tirar melle de "arqueiro"
- escolher 1 aliado 

________________________________________

INTERFACE DE ENCONTRO
System.out.println("|----------------|");
System.out.println("|  Fight     Bag |");
System.out.println("|                |");
System.out.println("|  Swap      Run |");
System.out.println("|----------------|");

INTERCADE DE LUTA
System.out.println("|----------------|");
System.out.println("|  Hab1     Hab2 |");
System.out.println("|                |");
System.out.println("|  Hab3     Back |");
System.out.println("|----------------|");

//MAGO
mago_hpmax = 12;
mago_hab1 = 6;
mago_hab2 = 9; (6 * 1.5)
mago_hab3 = 15;
         
//CAVALEIRO          
cavaleiro_hpmax = 20;
cavaleiro_hab1 = 10; 
cavaleiro_hab2 = 15; (12 + 3)
cavaleiro_hab3 = 20;
                 
//ARQUEIRO
arqueiro_hpmax = 16;
arqueiro_hab1 = 9; 
arqueiro_hab2 = 12; (9 + 3) 
arqueiro_hab3 = 18;
 */