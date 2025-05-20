import java.util.Scanner;

public class testPlay {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in); 
        Role role = new Role();

        //role.op();
        role.escolherClasse();
        
        /* System.out.println("\nVOCE DESEJA IR PARA A CIDADE INICIAL DE <nome cidade tutorial>? - S/N");
        System.out.print("\n> ");
        String opc_ini_city = scan.next().toLowerCase();
        
        if (opc_ini_city.equals("s")) {

        }
        else if (opc_ini_city.equals("n")) {
           
        } */
    
        role.gerar_criatura();
        role.encontro();        
        role.fight();

    }
}
