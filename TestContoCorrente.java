import java.util.Scanner;

public class TestContoCorrente {
    public static void main(String[] args) {
        ContoCorrente[] conti = new ContoCorrente[5];

        conti[0] = new ContoCorrente(1000, "family");
        conti[1] = new ContoCorrente(2000, "business");
        conti[2] = new ContoCorrente(1500, "family");
        conti[3] = new ContoCorrente(3000, "business");
        conti[4] = new ContoCorrente(2500, "family");

        for (int i = 0; i < conti.length; i++) {
            System.out.println("Conto " + conti[i].ottieniNumero() + ": Tipo: " + conti[i].getTipo() + ", Saldo: " + conti[i].ottieniSaldo() + " euro");
        }

        for (int i = 0; i < conti.length; i++) {
            conti[i].maturaInteressi();
        }

        ContoCorrente.setTassoBusiness(0.03);
        System.out.println("Nuovo tasso business: " + ContoCorrente.getTassoBusiness());

        Scanner scanner = new Scanner(System.in);

        System.out.print("Inserisci il numero del conto per il prelievo: ");
        int numeroConto = scanner.nextInt();
        System.out.print("Inserisci l'importo da prelevare: ");
        double importoPrelievo = scanner.nextDouble();
        for (ContoCorrente conto : conti) {
            if (conto.ottieniNumero() == numeroConto) {
                if (!conto.preleva(importoPrelievo)) {
                    System.out.println("Saldo insufficiente.");
                }
                break;
            }
        }

        System.out.print("Inserisci il numero del conto per il deposito: ");
        numeroConto = scanner.nextInt();
        System.out.print("Inserisci l'importo da depositare: ");
        double importoDeposito = scanner.nextDouble();
        for (ContoCorrente conto : conti) {
            if (conto.ottieniNumero() == numeroConto) {
                conto.deposita(importoDeposito);
                break;
            }
        }

        System.out.print("Inserisci il numero del conto per visualizzare il saldo: ");
        numeroConto = scanner.nextInt();
        for (ContoCorrente conto : conti) {
            if (conto.ottieniNumero() == numeroConto) {
                System.out.println("Il saldo attuale del conto " + numeroConto + " è: " + conto.ottieniSaldo() + " euro");
                break;
            }
        }
    }
}