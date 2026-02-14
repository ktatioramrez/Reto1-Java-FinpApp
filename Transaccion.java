import java.util.Scanner;
import java.util.ArrayList;

public class FinpApp {
    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        ArrayList<Transaccion> movimientos = new ArrayList<>();
        double saldo = 0;
        int opcion = 0;

        do {
            System.out.println("\n--- MI GESTOR FINANCIERO ---");
            System.out.println("1. Agregar Ingreso");
            System.out.println("2. Agregar Gasto");
            System.out.println("3. Ver Saldo y Movimientos");
            System.out.println("4. Salir");
            System.out.print("Selecciona una opción: ");
            opcion = leer.nextInt();
            leer.nextLine(); // Limpiar el buffer

            if (opcion == 1 || opcion == 2) {
                System.out.print("Descripción: ");
                String desc = leer.nextLine();
                System.out.print("Monto: ");
                double monto = leer.nextDouble();

                if (opcion == 2) monto *= -1; // Si es gasto, el monto es negativo

                movimientos.add(new Transaccion(desc, monto));
                saldo += monto;
                System.out.println("¡Registro exitoso!");
            } else if (opcion == 3) {
                System.out.println("Saldo actual: $" + saldo);
                for (Transaccion t : movimientos) {
                    System.out.println("- " + t.getDescripcion() + ": $" + t.getMonto());
                }
            }
        } while (opcion != 4);
        System.out.println("¡Hasta pronto!");
    }
}