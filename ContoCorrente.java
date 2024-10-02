public class ContoCorrente {
    private double saldo;
    private int numero;
    private String tipo;
    private static int numeroUltimoContoCreato = 1000;
    private static double tassoFamily = 0.01;
    private static double tassoBusiness = 0.02;

    public ContoCorrente(double saldoIniziale, String tipo) {
        this.saldo = saldoIniziale;
        numeroUltimoContoCreato++;
        this.numero = numeroUltimoContoCreato;
        this.tipo = tipo;
    }

    public void deposita(double importo) {
        saldo += importo;
        System.out.println("Versati: " + importo + " euro");
    }

    public boolean preleva(double importo) {
        if (saldo < importo)
            return false;
        else {
            saldo -= importo;
            System.out.println("Prelevati: " + importo + " euro");
            return true;
        }
    }

    public double ottieniSaldo() {
        return saldo;
    }

    public int ottieniNumero() {
        return numero;
    }

    public static int ottieniUltimoNumero() {
        return numeroUltimoContoCreato;
    }

    public String getTipo() {
        return tipo;
    }

    public static double getTassoFamily() {
        return tassoFamily;
    }

    public static double getTassoBusiness() {
        return tassoBusiness;
    }

    public static void setTassoFamily(double tasso) {
        tassoFamily = tasso;
    }

    public static void setTassoBusiness(double tasso) {
        tassoBusiness = tasso;
    }

    public void maturaInteressi() {
        if (tipo.equalsIgnoreCase("family")) {
            saldo += saldo * tassoFamily;
        } else if (tipo.equalsIgnoreCase("business")) {
            saldo += saldo * tassoBusiness;
        }
        System.out.println("Interessi maturati per conto " + numero + ": " + saldo);
    }
}