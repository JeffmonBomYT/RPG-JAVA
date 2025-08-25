import java.util.ArrayList;
import java.util.Random; 
import java.util.Scanner;

public class Sistema {
    Scanner scan = new Scanner(System.in); 
    Random rng = new Random();

    Role role;
    public Sistema(Role role) {
        this.role = role;
    }

//------------------------------------------------------------------------------------------------
    private int monsNivel, monsHp, monsHpMax, monsXp, monsDamage;
    private String monsChoice;
    private int opcAbility, opcMeeting, opcBackBag;   
//------------------------------------------------------------------------------------------------
    public void gerarCriatura() {
        String[] lista_mons = {"Slime", "Esqueleto", "Orc", "Coelho assasino", "Lobo"};
        monsChoice = lista_mons[rng.nextInt(lista_mons.length)];         

        switch (monsChoice) {
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

        System.out.println("\nSurge um monstro, o "+monsChoice+" [Nvl: "+monsNivel+"]"+
                        "\n[Vida: "+monsHp+"/"+monsHpMax+"]"+
                        "\n[Dano: "+monsDamage+"]\n");
    }       
//------------------------------------------------------------------------------------------------
    public void meeting() {
            System.out.println("Seu turno!");
            System.out.println("|--------------------| [Hp: "+role.hp+"/"+role.hpMax+"]");
            System.out.println("|1 - Fight |  Bag - 3| [Xp: "+role.xp+"/"+role.xpMax+"]");
            System.out.println("|                    | [Hab1: "+role.hab1+"]");
            System.out.println("|2 - Swap  |  Run - 4| [Hab2: "+role.hab2+"]");
            System.out.println("|--------------------| [Hab3: "+role.hab3+"]");
            System.out.print("\n> ");
            opcMeeting = scan.nextInt();
                
            switch (opcMeeting) {
                case 1:
                    fight();
                    break;
                case 2:
                    System.out.println("Sistema não implementado");
                    break;
                case 3:
                    bag();
                    break;                   
                case 4:
                    run();
                    break;
                default:
                    System.out.println("Comando inválido. tente novamente");                   
            }
        
              
    }
//------------------------------------------------------------------------------------------------
    public void fight() {
        System.out.println("|--------------------------------------|");
        System.out.format("| 1 - %s ", role.hab1Name);
        System.out.format("| %s - 2", role.hab2Name);
        System.out.println("\n|                                      |");
        System.out.format("| 3 - %s ", role.hab3Name);
        System.out.format("| Back - 4");
        System.out.println("\n|--------------------------------------|");
        System.out.print("\n> ");
        opcAbility = scan.nextInt();

        switch (opcAbility) {
            case 1:
                monsHp -= role.hab1;
                System.out.println("Você machucou o monstro.\n"+monsHp+"/"+monsHpMax+"\n");
                break;
            case 2:
                monsHp -= role.hab2;
                System.out.println("Você machucou o monstro.\n"+monsHp+"/"+monsHpMax+"\n");
                break;
            case 3:
                monsHp -= role.hab3;
                System.out.println("Você machucou o monstro.\n"+monsHp+"/"+monsHpMax+"\n");
                break;
            case 4:
                meeting();
            default:
                System.out.println("Opção inválida");
        }   
        
        
        if (monsHp > 0 && role.hp > 0) {
            System.out.println("Turno do oponente!"); 
            role.hp -= monsDamage;
            System.out.println("O monstro te atacou");
            System.out.println(role.hp+"/"+role.hpMax+"\n");
        }    
        
        if (monsHp > 0 && role.hp > 0) {
            fight();
        }    
        
        if (role.hp <= 0 && monsHp > 0)  {
            role.hp = 0; 
            System.out.println("Você foi derrotado. Eu tinha grandes esperanças em você, que decepção!");
            System.out.println("[Hp: "+role.hp+"/"+role.hpMax+"] - [Mons. Hp: "+monsHp+"/"+monsHpMax+"]");
        }    
        else if (monsHp <= 0 && role.hp > 0) {
            monsHp = 0;
            System.out.println("Parabéns, você derrotou o monstro.");
            System.out.println("[Hp: "+role.hp+"/"+role.hpMax+"] - [Mons. Hp: "+monsHp+"/"+monsHpMax+"]");
            role.xp += monsXp;
            System.out.println("Xp recebida: "+monsXp+" | [Seu Xp: "+role.xp+"/"+role.xpMax+"]");
        }
    }   
    //------------------------------------------------------------------------------------------------
    public void bag() {
        ArrayList<String> bolsa = new ArrayList<>();
        System.out.println("Bolsa: \n");
        bolsa.add("Poção de vida");
        bolsa.add("Poção de vida");
        bolsa.add("Poção de vida");
        if (role.classe.equals("Arqueiro")) {
            bolsa.add("Arco");
            bolsa.add("32 Flechas");
            bolsa.add("Adaga");
        }
        else if (role.classe.equals("Cavaleiro")) {
            bolsa.add("Espada Larga");
            bolsa.add("Armadura de couro");
            bolsa.add("Baralho de cartas");

        }
        else if (role.classe.equals("Mago")) {
            bolsa.add("Cajado");
            bolsa.add("Robe de mago");
            bolsa.add("Amuleto de bruxa");
        }

        for (String itemNaBolsa : bolsa) {
            System.out.println("["+itemNaBolsa+"]"); 
        }

        System.out.println("\n0 - Voltar");
        opcBackBag = scan.nextInt();

        if (opcBackBag == 0) {
            meeting();
        }
        else {
            System.out.println("Comando inválido");
        }
    }
//------------------------------------------------------------------------------------------------
    public void swap() {
         
    } 
//------------------------------------------------------------------------------------------------
    public void run() {
        int nRandom = 1 + rng.nextInt(100);
        if (nRandom <= 60) {
            System.out.println("\nVocê fugiu!");
        }
        else {
            System.out.println("\nNão conseguiu fugir!");
            meeting();
        }
    }
//------------------------------------------------------------------------------------------------
    
//------------------------------------------------------------------------------------------------
//------------------------------------------------------------------------------------------------
//------------------------------------------------------------------------------------------------
//------------------------------------------------------------------------------------------------
//------------------------------------------------------------------------------------------------
    
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
