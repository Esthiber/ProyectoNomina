package p3.project.projectogestionnomina.Interacciones;

import p3.project.projectogestionnomina.CONST;
import p3.project.projectogestionnomina.Empleados.Empleado;

import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class Sys {


    public static void Wait(String mensaje) throws IOException {
        if (mensaje.isEmpty()) mensaje = "Pulse Enter para Continuar...";
        System.out.println(mensaje);
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
    }

    public static void Wait() throws IOException {
        System.out.println("Pulse Enter para Continuar...");
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
    }

    public static void Mensaje(String mensaje) throws IOException {
        System.out.println(">>" + mensaje);
    }

    public static int Menu(String[] arg) throws IOException {
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < arg.length; i++) {
            System.out.println((i + 1) + ". " + arg[i]);
        }
        System.out.println("\nSeleccione una opcion:");
        return scanner.nextInt();
    }

    public static void Titulo(String titulo) {
        System.out.println("--- " + titulo + " ---");
    }

    public static Empleado NuevoEmpleado() {
//        Random random = new Random();
//        Empleado e = new Empleado(
//                CONST.FUNNY_IDS[random.nextInt(0, CONST.FUNNY_IDS.length)],
//                CONST.FUNNY_NAMES[random.nextInt(0, CONST.FUNNY_NAMES.length)],
//                CONST.FUNNY_LASTNAMES[random.nextInt(0, CONST.FUNNY_LASTNAMES.length)],
//                CONST.FUNNY_AGES[random.nextInt(0, CONST.FUNNY_AGES.length)],
//                random.nextInt(0, 2) == 0 ? "Masculino" : "Femenino",
//                CONST.FUNNY_EMAILS[random.nextInt(0, CONST.FUNNY_EMAILS.length)],
//                CONST.FUNNY_PHONENUMBERS[random.nextInt(0, CONST.FUNNY_PHONENUMBERS.length)],
//                CONST.FUNNY_ROLES[random.nextInt(0, CONST.FUNNY_ROLES.length)],
//                random.nextDouble(15000.00, 200000.01),
//                CONST.FUNNY_JOINDATES[random.nextInt(0, CONST.FUNNY_JOINDATES.length)],
//                CONST.FUNNY_BANKACCOUNTS[random.nextInt(0, CONST.FUNNY_BANKACCOUNTS.length)]
//        );
//        e.getCuenta().setIDPropietario(e.getID());
//        return e;
        return new Empleado();
    }

    public static String PedirInput(String s) throws IOException {
        Sys.Mensaje(s);
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }
}
