import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class RPG { 
//_______________________________________________________________
//VARIÁVEIS

    Scanner scan = new Scanner(System.in);
    Random rnd = new Random();
    
    //OPCOES - STRING
    String opc_class, opc_encontro, opc_status, opc_bag_back;
    //OPCOES - INT
    int opc_fight;
    //...
    String nome;
    //BOOLEAN
    Boolean stop = true, mons = true;
    //INIMIGOS
    int mons_hp, mons_hpmax, mons_ad, mons_xp, mons_nivel;

    int[] Classe;


//_______________________________________________________________
     public static void op(RPG main) {
                         
         System.out.println("[GENERIC HERO] (T-RPG)");
         System.out.println("\nDesejas jogar [GENERIC HERO]? \nS/N");
         System.out.print("\n> ");
         String opc_op = main.scan.next().toLowerCase();
         
         if (opc_op.equals("s")) {
            System.out.println("\nSEJA BEM-VINDO AO MUNDO DE THURFEND");
            System.out.println("\nVOCE ESTÁ AMBIENTADO COM JOGOS DE TEXT-RPG? - S/N");
            System.out.print("\n> ");
            String opc_tutorial = main.scan.next().toUpperCase();
    
            switch (opc_tutorial) {
                case "N" -> {
                    System.out.println("\nEm um text-rpg, voce decide acoes digitando letras ou textos no prompt quando solicitado, resultando em uma acao. ");
                    System.out.println("___________________________________");
                 }
    
                case "S" -> {
                 }
                default -> System.out.println("Comando digitado incrretamente.");
            }
    
            System.out.println("\nQUAL SERÁ O NOME DO HERÓI QUE PARTICIPARÁ DE CANTIGAS DE BARDOS?");
            System.out.print("\n> ");
            main.nome = main.scan.next();
            System.out.println("\n"+main.nome+"? BELO NOME, PORÉM, SÓ COM NOME NÃO SE DERROTA O MAL. ENTÃO, QUAL SERÁ SUA SEU ESTILO DE COMBATE?");
            
            choice_classe(main); 
         }
         else if (opc_op.equals("n")) {
              System.out.println("Adeus.");
              System.exit(0);
         }
         
    }
//_______________________________________________________________
    public static void choice_classe(RPG main) {       
            
        while (main.stop) { 
            System.out.println(" ________________________");
            System.out.println("|   ESCOLHA SUA CLASSE   |");
            System.out.println("|------------------------|");
            System.out.println("| - Mago                 |");
            System.out.println("| - Cavaleiro            |");
            System.out.println("| - Arqueiro             |");
            System.out.println("|________________________|");
            System.out.print("\n> ");
            main.opc_class = main.scan.next().toUpperCase();                                           
            
            switch (main.opc_class) {
                case "MAGO":
                    main.Classe = new int[] {/*Hp*/12,/*HPMax*/12, /*Hab1*/6, /*Hab2*/9, /*Hab3*/15};
                    break;
                case "CAVALEIRO":
                    main.Classe = new int[] {/*Hp*/20,/*HPMax*/20, /*Hab1*/10, /*Hab2*/15, /*Hab3*/20};
                    break;
                case "ARQUEIRO":
                    main.Classe = new int[] {/*Hp*/16,/*HPMax*/16, /*Hab1*/9, /*Hab2*/12, /*Hab3*/18};
                    break;
                default:
                    break;
            }

            if (main.opc_class.equals("CAVALEIRO") || main.opc_class.equals("MAGO") || main.opc_class.equals("ARQUEIRO")) {
                main.stop = false;
            }
            else {
                System.out.println("Essa classe não existe ou foi escrita incorretamente.");
            }

            System.out.println("\nDesejas ver os status de sua classe?");
            System.out.println("S/N");
            System.out.print("\n> ");
            main.opc_status = main.scan.next().toUpperCase();

            switch (main.opc_status) {
                case "S" -> System.out.println("\n[Hp: "+main.Classe[0]+"/"+main.Classe[1]+"]"+
                                       "\n[Hab1: "+main.Classe[2]+"]"+
                                       "\n[Hab2: "+main.Classe[3]+"]"+
                                       "\n[Hab3: "+main.Classe[4]+"]\n");
                case "N" -> {
                }
                default -> {
                    System.out.println("Comando inválido");
                    main.stop = true;
                }
            }
        

        }//while       

    } 
//_______________________________________________________________
    public static void gerar_criatura(RPG main) {
                 
         String[] lista_mons = {"Slime", "Esqueleto", "Orc", "Coelho assasino", "Lobo"};
         String mons_chose = lista_mons[main.rnd.nextInt(lista_mons.length)];         

        switch (mons_chose) {
            case "Slime" -> main.mons_nivel = main.rnd.nextInt(1, 2);
            case "Esqueleto" -> main.mons_nivel = main.rnd.nextInt(2,4);
            case "Orc" -> main.mons_nivel = main.rnd.nextInt(4, 6);
            case "Coelho assasino" -> main.mons_nivel = main.rnd.nextInt(1, 3);
            case "Lobo" -> main.mons_nivel = main.rnd.nextInt(2, 5);
        } 

        switch (main.mons_nivel) {
            case 1 -> {
                main.mons_hpmax = main.rnd.nextInt(1, 7);
                main.mons_hp = main.mons_hpmax;
                main.mons_ad = main.rnd.nextInt(1, 5);
            }
            case 2 -> {
                main.mons_hpmax = main.rnd.nextInt(6, 11);
                main.mons_hp = main.mons_hpmax;
                main.mons_ad = main.rnd.nextInt(4, 10);
            }
            case 3 -> {
                main.mons_hpmax = main.rnd.nextInt(10, 15);
                main.mons_hp = main.mons_hpmax;
                main.mons_ad = main.rnd.nextInt(9, 13);
            }
            case 4 -> {
                main.mons_hpmax = main.rnd.nextInt(14, 20);
                main.mons_hp = main.mons_hpmax;
                main.mons_ad = main.rnd.nextInt(12, 17);
            }
            case 5 -> {
                main.mons_hpmax = main.rnd.nextInt(19, 25);
                main.mons_hp = main.mons_hpmax;
                main.mons_ad = main.rnd.nextInt(16, 22);
            }
            case 6 -> {
                main.mons_hpmax = main.rnd.nextInt(24, 30);
                main.mons_hp = main.mons_hpmax;
                main.mons_ad = main.rnd.nextInt(21, 29);
            }
            case 7 -> {
                main.mons_hpmax = main.rnd.nextInt(29, 36);
                main.mons_hp = main.mons_hpmax;
                main.mons_ad = main.rnd.nextInt(28, 33);
            }
            case 8 -> {
                main.mons_hpmax = main.rnd.nextInt(35, 42);
                main.mons_hp = main.mons_hpmax;
                main.mons_ad = main.rnd.nextInt(32, 40);
            }
            case 9 -> {
                main.mons_hpmax = main.rnd.nextInt(41, 50);
                main.mons_hp = main.mons_hpmax;
                main.mons_ad = main.rnd.nextInt(39, 45);
            }
            case 10 -> {
                main.mons_hpmax = main.rnd.nextInt(49, 56);
                main.mons_hp = main.mons_hpmax;
                main.mons_ad = main.rnd.nextInt(44, 49);
            }
         }
         //Xp
         main.mons_xp = main.mons_hpmax + main.mons_ad;

         System.out.println("Surge um monstro, o "+mons_chose+
                             " [Nvl. "+main.mons_nivel+"]"+
                            "\n[Vida: "+main.mons_hp+"/"+main.mons_hpmax+"]"+
                            "\n[Dano: "+main.mons_ad+"]\n");
         
    }     
//_______________________________________________________________
    public static void mons_atq(RPG main) {

        while (main.mons_hp >= 0) {

                main.Classe[0] -= main.mons_ad;
                System.out.println("O monstro te atacou");
                System.out.println(main.Classe[0]+"/"+main.Classe[1]+"\n");
                
                if (main.Classe[0] <= 0 && main.mons_hp > 0) {
                    main.Classe[0] = 0;
                    System.out.println("Voce foi derrotado. Eu tinha esperancas em você, que decepção!");
                    break;
                }
                return;

        }

    }
//_______________________________________________________________      
    public static void encontro(RPG main) {
         
         while (main.mons) {
         System.out.println("|----------------|");
         System.out.println("|  Fight     Bag |");
         System.out.println("|                |");
         System.out.println("|  Swap      Run |");
         System.out.println("|----------------|");
         System.out.print("\n> ");
         main.opc_encontro = main.scan.next().toLowerCase();
              
              switch (main.opc_encontro) {
                 case "fight" -> {
                     fight(main);
                     main.mons = false;
                 }
                   
                 case "bag" -> {
                     bag(main);
                     main.mons = false;
                 }
                   
                 case "swap" -> {
                     swap(main);
                     main.mons = false;
                 }
                   
                 case "run" -> {
                     System.out.println("Sistema não implementado");
                     main.mons = false;
                 }
                   
                 default -> System.out.println("Comando inválido. tente novamente");                   
              }//switch
              
         }
    }
//_______________________________________________________________         
    public static void fight(RPG main) {       

        if (main.mons_hp > 0) {
            switch (main.opc_class) {             
                case "MAGO" -> {
                    System.out.println("\n|-----------------------------|");
                    System.out.println("|1  Mag. atck     Mag. miss  2|");
                    System.out.println("|                             |");
                    System.out.println("|3  Fire ball     Back       4|");
                    System.out.println("|-----------------------------|");
                    System.out.print("\n> ");
                    main.opc_fight = main.scan.nextInt();
                    
                    switch (main.opc_fight) {
                        case 1 -> main.mons_hp -= main.Classe[2];
                        
                        case 2 -> main.mons_hp -= main.Classe[3];
                        
                        case 3 -> main.mons_hp -= main.Classe[4];
                        
                        case 4 -> encontro(main);
                        
                        default -> {
                        }
                        
                    }// switch - mago
                }

                
                case "CAVALEIRO" -> {
                    System.out.println("\n|------------------------------|");
                    System.out.println("|1  Mellee atq     Str. atack 2|");
                    System.out.println("|                              |");
                    System.out.println("|3  Div. smite     Back       4|");
                    System.out.println("|------------------------------|");
                    System.out.print("\n> ");
                    main.opc_fight = main.scan.nextInt();
                    
                    switch (main.opc_fight) {
                        case 1 -> main.mons_hp -= main.Classe[2];
                        
                        case 2 -> main.mons_hp -= main.Classe[3];
                        
                        case 3 -> main.mons_hp -= main.Classe[4];
                        
                        case 4 -> encontro(main);
                        
                        default -> {
                        }
                    }// switch - guerreiro
                }

                
                case "ARQUEIRO" -> {
                    System.out.println("\n|------------------------------|");
                    System.out.println("|1  Bow shot       Pres. shot 2|");
                    System.out.println("|                              |");
                    System.out.println("|3  Giant arrow    Back       4|");
                    System.out.println("|------------------------------|");
                    System.out.print("\n> ");
                    main.opc_fight = main.scan.nextInt();
                    
                    switch (main.opc_fight) {
                        case 1 -> main.mons_hp -= main.Classe[2];
                        
                        case 2 -> main.mons_hp -= main.Classe[3];
                        
                        case 3 -> main.mons_hp -= main.Classe[4];
                        
                        case 4 -> encontro(main);
                        
                        default -> {
                        }
                    }//switch - arqueiro
                }
        
            }//switch - geral

            if (main.mons_hp <= 0) {
                main.mons_hp = 0;
            }

            System.out.println("Voce machucou o monstro.\n"+main.mons_hp+"/"+main.mons_hpmax+"\n");

            mons_atq(main);

        }//while

            System.out.println("Parabens, voce derrotou o monstro. sua recompensa: \n["+main.mons_xp+"] Xp");
         
        
    }
//_______________________________________________________________
    public static void bag(RPG main) {
        ArrayList<String> bag = new ArrayList<>(Arrays.asList("\n", "Pocao de vida", "Pocao de vida", "Pocao de vida"));
        System.out.println(String.join("\n- ", bag));
        System.out.println("Back");
        System.out.print("\n> ");
        main.opc_bag_back = main.scan.next().toLowerCase();

        if (main.opc_bag_back.equals("back")){
            encontro(main);
        }

    }
//_______________________________________________________________
    public static void swap(RPG main) {
        ArrayList<String> swap_team = new ArrayList<>(Arrays.asList(""));
        System.out.println(String.join("\n- ", swap_team));
        System.out.println("Back");
        System.out.print("\n> ");
        main.opc_bag_back = main.scan.next().toLowerCase();

        if (main.opc_bag_back.equals("back")){
            encontro(main);
        }
         //add aliado
         
    }
//_______________________________________________________________
    public static void run(RPG main) {

    }
//_______________________________________________________________

//_______________________________________________________________    

//_______________________________________________________________
    public static void main(String[] args) {
        RPG main = new RPG();      

        //op(main);
        choice_classe(main);  
        gerar_criatura(main);
        encontro(main);         
        
         
        /* 
        
        System.out.println("\nVOCE DESEJA IR PARA A CIDADE INICIAL DE <nome cidade tutorial>? - S/N");
        System.out.print("\n> ");
        String opc_ini_city = main.scan.next().toLowerCase();
        
        switch (opc_ini_city) {
            case "s":
                System.out.println("TUDO BEM. PORÉM, POR HOJE É MELHOR VOCE DESCANSAR, AMANHÃD CEDO COMEÇAREMOS");
                break;
            case "n":
            System.out.println("TUDO BEM. PORÉM, POR HOJE É MELHOR VOCE DESCANSAR, AMANHÃ CEDO COMEÇAREMOS");
                break;
        }

          encontro(main); */
    
        System.out.println("Fim");    
    }
    
}
//_______________________________________________________________
/*
 
## = feito 
≈≈ = +/- feito
 
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
main.mago_hpmax = 12;
main.mago_hab1 = 6;
main.mago_hab2 = 9; (6 * 1.5)
main.mago_hab3 = 15;
         
//CAVALEIRO          
main.cavaleiro_hpmax = 20;
main.cavaleiro_hab1 = 10; 
main.cavaleiro_hab2 = 15; (12 + 3)
main.cavaleiro_hab3 = 20;
                 
//ARQUEIRO
main.arqueiro_hpmax = 16;
main.arqueiro_hab1 = 9; 
main.arqueiro_hab2 = 12; (9 + 3) 
main.arqueiro_hab3 = 18;
         
   

 */