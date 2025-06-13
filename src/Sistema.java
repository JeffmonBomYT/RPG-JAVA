import java.util.Random;
import java.util.Scanner;

public class Sistema {
    Scanner scan = new Scanner(System.in);
    Random rng = new Random();

    Role role; 

    public Sistema(Role role) {
        this.role = role;
    }
//_______________________________________________________________________________________________
    int mons_nivel, mons_hp, mons_hpmax, mons_xp, mons_ad;
    String mons_chose;
    boolean monsAlive = true;

    int opc_hab, opc_encontro;
    boolean opc_fight = true;

//________________________________________________________________________________________________
    public void op() {
                         
        System.out.println("[GENERIC HERO] (T-RPG)");
        System.out.println("\nDesejas jogar [GENERIC HERO]? - S/N");
        System.out.print("\n> ");
        String opc_op = scan.next().toLowerCase();
        
        if (opc_op.equals("s")) {
            System.out.println("\nSEJA BEM-VINDO AO MUNDO DE THURFEND");

            System.out.println("\nQUAL SERÁ O NOME DO HERÓI QUE PARTICIPARÁ DE CANTIGAS DE BARDOS?");
            System.out.print("\n> ");
            role.nome = scan.next();
            System.out.println("\n"+role.nome+"? BELO NOME, PORÉM, SÓ COM NOME NÃO SE DERROTA O MAL. ENTÃO, QUAL É SEU ESTILO DE COMBATE?");
            
            role.escolherClasse(); 

        }
        else if (opc_op.equals("n")) {
            System.out.println("Adeus.");
            System.exit(1);
        }
         
    }
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
    public void encontro() {

         while (monsAlive) {
            System.out.println("|--------------------| [Hp: "+role.hp+"/"+role.hpMax+"]");
            System.out.println("|1 - Fight |  Bag - 3| [Xp: "+role.xp+"]");
            System.out.println("|                    | [Hab1: "+role.hab1+"]");
            System.out.println("|3 - Swap  |  Run - 4| [Hab2: "+role.hab2+"]");
            System.out.println("|--------------------| [Hab3: "+role.hab3+"]");
            System.out.print("\n> ");
            opc_encontro = scan.nextInt();
              
              switch (opc_encontro) {
                 case 1:
                    fight();
                    monsAlive = false;
                    break;
                 case 2:
                    //...
                    monsAlive = false;
                    break;
                 case 3:
                    //...
                    monsAlive = false;
                    break;                   
                 case 4:
                    //...
                    System.out.println("Sistema não implementado");
                    monsAlive = false;
                    break;
                 default:
                    System.out.println("Comando inválido. tente novamente");                   
              }//switch
              
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
                    if (mons_hp <= 0) {
                        opc_fight = false;
                    }
                    break;
                case 2:
                    mons_hp -= role.hab2;
                    System.out.println("Você machucou o monstro.\n"+mons_hp+"/"+mons_hpmax+"\n");
                    if (mons_hp <= 0) {
                        opc_fight = false;
                    }
                    break;
                case 3:
                    mons_hp -= role.hab3;
                    System.out.println("Você machucou o monstro.\n"+mons_hp+"/"+mons_hpmax+"\n");
                    if (mons_hp <= 0) {
                        opc_fight = false;
                    }
                    break;
                default:
                    System.out.println("Opção inválida");
            }

            if (mons_hp > 0 && role.hp > 0) {
                role.hp -= mons_ad;
                System.out.println("O monstro te atacou");
                System.out.println(role.hp+"/"+role.hpMax+"\n");
                if (role.hp <= 0 && mons_hp > 0) {
                    break;
                }
            }

            FimBatalha();
            

        } 
    }
//________________________________________________________________________________________________
    public void FimBatalha() {
        if (role.hp <= 0 && mons_hp > 0)  {
            role.hp = 0;
            System.out.println("Você foi derrotado. Eu tinha grandes esperanças em você, que decepção!");
            System.out.println("[Hp: "+role.hp+"/"+role.hpMax+"] - [Mons. Hp: "+mons_hp+"/"+mons_hpmax+"]");
        }             
        else if (mons_hp <= 0 && role.hp > 0) {
            mons_hp = 0;
            System.out.println("Parabéns, você derrotou o monstro.");
            System.out.println("[Hp: "+role.hp+"/"+role.hpMax+"] - [Mons. Hp: "+mons_hp+"/"+mons_hpmax+"]");
            System.out.println("Xp recebida: "+mons_xp);
            role.xp += mons_xp;
        }
            }
//________________________________________________________________________________________________
    public void bag() {
        
    }
//________________________________________________________________________________________________
    public void swap() {
         
    }
//________________________________________________________________________________________________
    public void run() {

    }
//________________________________________________________________________________________________    
}

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