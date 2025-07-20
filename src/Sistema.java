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
    int monsNivel, monsHp, monsHpMax, monsXp, monsDamage;
    String monsChoose;
    boolean monsAlive = true;

    int opcHab, opcEncontro;
    boolean opcFight = true;
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
         monsChoose = lista_mons[rng.nextInt(lista_mons.length)];         

        switch (monsChoose) {
            case "Slime" -> monsNivel = 1 + rng.nextInt(2);
            case "Esqueleto" -> monsNivel = 1 + rng.nextInt(4);
            case "Orc" -> monsNivel = 1 + rng.nextInt(6);
            case "Coelho assasino" -> monsNivel = 1 + rng.nextInt(3);
            case "Lobo" -> monsNivel = 1 + rng.nextInt(5);
        } 

        switch (monsNivel) {
            case 1 -> {
                monsHpMax = 1 + rng.nextInt(7);
                monsHp = monsHpMax;
                monsDamage = 1 + rng.nextInt(5);
            }
            case 2 -> {
                monsHpMax = 1 + rng.nextInt(11);
                monsHp = monsHpMax;
                monsDamage = 1 + rng.nextInt(10);
            }
            case 3 -> {
                monsHpMax = 1 + rng.nextInt(15);
                monsHp = monsHpMax;
                monsDamage = 1 + rng.nextInt(13);
            }
            case 4 -> {
                monsHpMax = 1 + rng.nextInt(20);
                monsHp = monsHpMax;
                monsDamage = 1 + rng.nextInt(17);
            }
            case 5 -> {
                monsHpMax = 1 + rng.nextInt(25);
                monsHp = monsHpMax;
                monsDamage = 1 + rng.nextInt(22);
            }
            case 6 -> {
                monsHpMax = 1 + rng.nextInt(30);
                monsHp = monsHpMax;
                monsDamage = 1 + rng.nextInt(29);
            }
            case 7 -> {
                monsHpMax = 1 + rng.nextInt(36);
                monsHp = monsHpMax;
                monsDamage = 1 + rng.nextInt(33);
            }
            case 8 -> {
                monsHpMax = 1 + rng.nextInt(42);
                monsHp = monsHpMax;
                monsDamage = 1 + rng.nextInt(40);
            }
            case 9 -> {
                monsHpMax = 1 + rng.nextInt(50);
                monsHp = monsHpMax;
                monsDamage = 1 + rng.nextInt(45);
            }
            case 10 -> {
                monsHpMax = 1 + rng.nextInt(56);
                monsHp = monsHpMax;
                monsDamage = 1 + rng.nextInt(49);
            }
         }
         
         monsXp = monsHpMax + monsDamage; //Xp

         System.out.println("Surge um monstro, o "+monsChoose+" [Nvl: "+monsNivel+"]"+
                            "\n[Vida: "+monsHp+"/"+monsHpMax+"]"+
                            "\n[Dano: "+monsDamage+"]\n");
    }          
//________________________________________________________________________________________________           
    public void encontro() {

        while (monsAlive) {
            System.out.println("|--------------------| [Hp: "+role.hp+"/"+role.hpMax+"]");
            System.out.println("|1 - Fight |  Bag - 3| [Xp: "+role.xp+"/"+role.xpMax+"]");
            System.out.println("|                    | [Hab1: "+role.hab1+"]");
            System.out.println("|3 - Swap  |  Run - 4| [Hab2: "+role.hab2+"]");
            System.out.println("|--------------------| [Hab3: "+role.hab3+"]");
            System.out.print("\n> ");
            opcEncontro = scan.nextInt();
              
            switch (opcEncontro) {
                case 1:
                    fight();
                    monsAlive = false;
                    break;
                case 2:
                    //...
                    System.out.println("Sistema não implementado");
                    monsAlive = false;
                    break;
                case 3:
                    //...
                    System.out.println("Sistema não implementado");
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

        do {
            System.out.println("\n|--------------------------------------|");
            System.out.format(" 1 - %s ", role.hab1Name);
            System.out.format("| %s - 2", role.hab2Name);
            System.out.println("\n ");
            System.out.format(" 3 - %s ", role.hab3Name);
            System.out.format("| Back - 4");
            System.out.println("\n|--------------------------------------|");
            System.out.print("\n> ");
            opcHab = scan.nextInt();

            switch (opcHab) {
                case 1:
                    monsHp -= role.hab1;
                    System.out.println("Você machucou o monstro.\n"+monsHp+"/"+monsHpMax+"\n");
                    if (monsHp <= 0) {
                        opcFight = false;
                    }
                    break;
                case 2:
                    monsHp -= role.hab2;
                    System.out.println("Você machucou o monstro.\n"+monsHp+"/"+monsHpMax+"\n");
                    if (monsHp <= 0) {
                        opcFight = false;
                    }
                    break;
                case 3:
                    monsHp -= role.hab3;
                    System.out.println("Você machucou o monstro.\n"+monsHp+"/"+monsHpMax+"\n");
                    if (monsHp <= 0) {
                        opcFight = false;
                    }
                    break;
                default:
                    System.out.println("Opção inválida");
            } 
             
            if (monsHp > 0 && role.hp > 0) {
                role.hp -= monsDamage;
                System.out.println("O monstro te atacou");
                System.out.println(role.hp+"/"+role.hpMax+"\n");
                
                if (role.hp <= 0 && monsHp > 0)  {
                    role.hp = 0;
                    System.out.println("Você foi derrotado. Eu tinha grandes esperanças em você, que decepção!");
                    System.out.println("[Hp: "+role.hp+"/"+role.hpMax+"] - [Mons. Hp: "+monsHp+"/"+monsHpMax+"]");
                    opcFight = false;
                    break;
                }    
                else if (monsHp <= 0 && role.hp > 0) {
                    monsHp = 0;
                    System.out.println("Parabéns, você derrotou o monstro.");
                    System.out.println("[Hp: "+role.hp+"/"+role.hpMax+"] - [Mons. Hp: "+monsHp+"/"+monsHpMax+"]");
                    System.out.println("Xp recebida: "+monsXp);
                    role.xp += monsXp;
                    opcFight = false;
                    break;
                }
            }
            
        } while(opcFight);
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
- acampamento de guerra/posto avançado
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