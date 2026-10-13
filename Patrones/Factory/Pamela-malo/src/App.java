import java.util.Scanner;

public class App {
    static void main() {
        Scanner sc = new Scanner(System.in);
        int opcion  = -1;
        while (opcion != 0){
            System.out.println("\n1.Bosque oscuro  ");
            System.out.println("2.Castillo embrujado  ");
            System.out.println("3.Volcan Infernal  ");
            System.out.println("0.Salir   ");
            System.out.println("Elige un nivel");
            opcion  = sc.nextInt();

            if (opcion >= 1 && opcion <= 3){
                Nivel nivel = new Nivel(opcion);
                nivel.jugar();
            } else if (opcion != 0){
                System.out.println("Opcion invalida");
            }
        }
        sc.close();
    }
}
