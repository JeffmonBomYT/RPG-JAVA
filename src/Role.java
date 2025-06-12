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
    public void op() {
                         
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
}
//________________________________________________________________________________________________


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