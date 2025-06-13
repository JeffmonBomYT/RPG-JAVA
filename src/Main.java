import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in); 
        Role role = new Role();
        Sistema sis = new Sistema(role);
        
        

        role.escolherClasse(); 
        sis.gerar_criatura();   
        sis.encontro();  
        sis.fight();

        role.MostrarStatus();
        
        System.out.println("Fim do teste"); 
 
    }
}
