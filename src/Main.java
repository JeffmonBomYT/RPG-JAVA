import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in); 
        Role role = new Role();
        Sistema sis = new Sistema();

        //role.op();
        role.escolherClasse();
        
        /* System.out.println("\nVOCE DESEJA IR PARA A CIDADE INICIAL DE <nome cidade tutorial>? - S/N");
        System.out.print("\n> ");
        String opc_ini_city = scan.next().toLowerCase();
        
        if (opc_ini_city.equals("s")) {

        }
        else if (opc_ini_city.equals("n")) {
           
        } */
    
        sis.gerar_criatura();
        sis.encontro();        
        sis.fight();

        System.out.println("Fim do teste");

    }
}
