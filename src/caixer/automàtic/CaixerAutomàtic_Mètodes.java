package caixer.automàtic;

import llibreries.CaixerAutomàtic_VariablePosicions;
import java.util.Scanner;
import llibreries.CaixerAutomàtic_VariablePosicions;

public class CaixerAutomàtic_Mètodes extends CaixerAutomàtic_VariablePosicions {

    private static CaixerAutomàtic_VariablePosicions var = new CaixerAutomàtic_VariablePosicions();
    private static Scanner sc = new Scanner(System.in);
    private static CaixerAutomàtic_Thread3 fil1 = new CaixerAutomàtic_Thread3();
    private static CaixerAutomàtic_Thread2 fil2 = new CaixerAutomàtic_Thread2();

    //private static int posicions = var.getPosicions();
    private static int contador = 0;
    private static String nomUsuari, contrassenya, metodeIngressarSaldo = "Ingressar", metodeConsultarSaldo = "Consultar", metodeRetirarDiners = "Retirar", metodeSortirCaixer = "Sortir", guardador;
    private static boolean checkTrue = false, checkTrue1 = true,checkktrue;

    private static String[] nomsIContres = new String[20];
    private static int[] diners = new int[20];

    public static void IniciSessió_Principal() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Nom d'usuari: ");
        nomUsuari = sc.nextLine();
        System.out.print("Contrassenya: ");
        String contrassenya = sc.nextLine();
        Array();

    }

    private static void Array() {

        while (checkTrue1) {
            if (nomsIContres[contador] != null) {
                contador++;

                if (nomsIContres[contador] == nomUsuari + "," + contrassenya) {
                    System.out.println("Has iniciat sessió amb èxit!");
                    checkTrue = true;

                } else {
                    System.out.println("No hi ha cap compte amb aquest nom d'usuari i aquesta contrassenya. Torna-ho a provar. "
                            + "\nSi no dispons d'un compte, crea'l més avall: ");
                    checkTrue = false;
                    contador--;
                    IniciSessió_Principal();
                }

            } else {
                nomsIContres[contador] = nomUsuari + "," + contrassenya;
                System.out.println("Has registrat un nou compte amb èxit!\n");
                checkTrue1 = false;
                Opcions();

            }
        }

    }

    private static void IngressarSaldo() {
        System.out.print("\nEscriu la quantitat de diners que vols ingressar: ");
        try {
            String saver = sc.nextLine();
            int saver2 = Integer.parseInt(saver);
            diners[contador] += saver2;
            System.out.println("S'ha ingressat els diners correctament.");
            Opcions();

        } catch (Exception e) {
            System.out.println("Hi ha hagut un error.");
        }
    }

    private static void ConsultarSaldo() {

        try {
            String stringTemporal = String.valueOf(diners[contador]);
            System.out.println("El teu saldo actual és: " + stringTemporal.replaceAll("nul", ""));
        } catch (Exception e) {
            System.out.println("El teu saldo actual és: 0");
        }
        Opcions();

    }

    private static void RetirarDiners() {
        System.out.print("\nEscriu la quantitat de diners que vols retirar: ");
        try {
            String saver = sc.nextLine();
            int saver2 = Integer.parseInt(saver);
            diners[contador] -= saver2;
            System.out.println("S'ha retirat els diners correctament.");
            String stringTemporal = String.valueOf(diners[contador]);
            System.out.println("El teu saldo actual és: " + stringTemporal.replaceAll("nul", ""));
        } catch (Exception e) {
            System.out.println("No has pogut retirar diners del saldo, ja que no dispons de diners.");
        }
        Opcions();
    }

    private static void SortirCaixer() {
        System.out.println("\nSortint...");
        System.out.println("S'ha sortit del caixer. Si vols tornar a entrar escriu 'Entrar'.");
        fil1.start();
        String gg = sc.nextLine();
        fil2.setGg(gg);
        fil2.start();
        boolean ifYes = false;
        fil1.setIfYes(ifYes);
        if (checkktrue){
            fil2.stop();
        }
        //fil2.stop();
    }

    private static void Opcions() {
        System.out.println("\nEscriu 'Ingressar' per a ingressar diners");
        System.out.println("Escriu 'Consultar' per a consultar el saldo");
        System.out.println("Escriu 'Retirar' per a retirar diners");
        System.out.println("Escriu 'Sortir' per a sortir del caixer\n");
        System.out.print("Insereix la instrucció: ");
        guardador = sc.nextLine();
        if (guardador.equals(metodeIngressarSaldo) || guardador.equals(metodeConsultarSaldo) || guardador.equals(metodeRetirarDiners) || guardador.equals(metodeSortirCaixer)) {
            if (guardador.equals(metodeIngressarSaldo)) {
                IngressarSaldo();
            }
            if (guardador.equals(metodeConsultarSaldo)) {
                ConsultarSaldo();
            }
            if (guardador.equals(metodeRetirarDiners)) {
                RetirarDiners();
            }
            if (guardador.equals(metodeSortirCaixer)) {
                SortirCaixer();
            }
        } else {
            System.out.println("No has introduït cap de les opcions correctament. Tornaho a intentar.");
            Opcions();
        }

    }

    public static void setCheckktrue(boolean aCheckktrue) {
        checkktrue = aCheckktrue;
    }

}
