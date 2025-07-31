import java.util.Scanner;

public class Story {
    Scanner scan = new Scanner(System.in);

    Role role;
    public Story(Role role) {
        this.role = role;
    }
//---------------------------------------------------------------
    public void opening() {
        System.out.println("[GENERIC HERO] (T-RPG)");
        System.out.println("\nDesejas jogar [GENERIC HERO]? - S/N");
        System.out.print("\n> ");
        String opc_op = scan.next().toLowerCase();
        
        if (opc_op.equals("s")) {
            System.out.println("\nSEJA BEM-VINDO AO MUNDO DE THURFEND");

            System.out.println("\nQUAL SERÁ O NOME DO HERÓI QUE PARTICIPARÁ DE CANTIGAS DE BARDOS?");
            System.out.print("\n> ");
            role.name = scan.next();
            System.out.println("\n"+role.name+"? BELO NOME, PORÉM, SÓ COM NOME NÃO SE DERROTA O MAL. ENTÃO, QUAL É SEU ESTILO DE COMBATE?");
            
            role.escolherClasse(); 

        }
        else if (opc_op.equals("n")) {
            System.out.println("ADEUS");
            System.exit(1);
        }
    }
    
//---------------------------------------------------------------
    public void introduction() {
        //  fazer um "tutorial" (talvez em um posto avançado), com mêcanicas de: encontro(), fight(), recomepnsas,
        //entre outras.
        //  sugerir próximo local a ir (nomes de cidades (pedir à terceiros)) + eventos aleatórios durante viajens. 
        System.out.println("    Está tudo preto, você não enxerga nada. até que se percebe em um abismo, sem sons, sensações, somente sua angustia que não te abandona não importa onde você vá. até que derepente, de onde você assimila ser uma direção que remeta para cima, surge um raio de luz, que almenta cada e cada vez mais, e a partir do nada você consegue distiguir algo, uma voz, parece estar te chamando... "+role.name+"!!");
        System.out.println("    Você acorda, com um soldado apontando uma tocha para o seu rosto e te balançando para acorda-lo.");
        System.out.println("    Quando você recobra seus pensamentos você se lembra, estava em um posto avançado do império para defender a fronteira contra os monstros que o imperador havia sonhado com seu dom de precognição.");
        System.out.println("    O soldado te apressa para que se levante e se prepare para a batalha que já houvera se iniciado.");

        System.out.println("Mecânicas: ");
        System.out.println("Você utiliza de comandos pré-determinados com o teclado,digitando sua intenção e precionando [Enter] para enviar o comando. enfim, vamos à prática");
    
    
    }
//---------------------------------------------------------------
    public void primeiroAto() {
        //acrodar numa floresta, ouvir barulhos, seguir até o acampamento de guerra/posto avançado, começar tutorial
    }
//---------------------------------------------------------------

//---------------------------------------------------------------

//---------------------------------------------------------------

//---------------------------------------------------------------




}
