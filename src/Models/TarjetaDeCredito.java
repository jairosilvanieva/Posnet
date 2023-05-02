package Models;

public class TarjetaDeCredito {
    private String entidadBancaria;
    private String nroTarjeta;
    private double saldo;
    private EntidadFinanciera entidadFinanciera;
    private Persona titular;

    public TarjetaDeCredito(String entidadBancaria, String nroTarjeta, double saldo, EntidadFinanciera entidadFinanciera, Persona titular) {
        this.entidadBancaria = entidadBancaria;
        this.nroTarjeta = nroTarjeta;
        this.saldo = saldo;
        this.entidadFinanciera = entidadFinanciera;
        this.titular = titular;
    }

    public boolean tieneSaldoDisponible(double monto) {
        return saldo >= monto;
    }
    public void descontar (double monto) {
        saldo -= monto;
    }

    public  String nombreCompletoDeTitular() {
        return titular.nombreCompleto();
    }

    @Override
    public String toString() {
        return "TarjetaDeCredito{" +
                "entidadBancaria='" + entidadBancaria + '\'' +
                ", nroTarjeta='" + nroTarjeta + '\'' +
                ", saldo=" + saldo +
                ", entidadFinanciera=" + entidadFinanciera +
                ", titular=" + titular +
                '}';
    }
}
