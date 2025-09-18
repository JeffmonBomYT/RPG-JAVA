public class Main {
    public static void main(String[] args) throws Exception {
        Role role = new Role();
        Sistema sis = new Sistema(role);
        Story his = new Story(role);

        his.opening();
        his.introduction();
        sis.gerarCriatura();
        sis.meeting();
        sis.gerarCriatura();
        sis.meeting();
        sis.gerarCriatura();
        sis.meeting();
        
        System.out.println("Fim do teste");
    }
} 
/*
 
extra de dar as habilidades baseado no nivel
 */