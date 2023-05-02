package Models;

public class Posnet {
    public static final double RECARGO_POR_CUOTA = 0.03;
    public static final int MIN_CANT_CUOTAS = 1;
    public static final int MAX_CANT_CUOTAS = 6;

    public Ticket efectuarPago(TarjetaDeCredito tarjeta, double montoAAbonar, int cantCouta){
       Ticket elTicket = null;
        if(datosValidos(tarjeta, montoAAbonar, cantCouta)){
            double montoFinal = montoAAbonar + montoAAbonar*recargoSegunCuotas(cantCouta);
            if(tarjeta.tieneSaldoDisponible(montoFinal)){
                tarjeta.descontar(montoFinal);
                String nomApe = tarjeta.nombreCompletoDeTitular();
                double montoPorCuota = montoFinal/ cantCouta;
                elTicket = new Ticket (nomApe, montoFinal, montoPorCuota);
            }
        }
        return elTicket;
    }
    private boolean datosValidos(TarjetaDeCredito tarjeta, double monto, int cant){
       boolean esTarjetaValida = tarjeta != null;
       boolean esMontoValida = monto>0;
       boolean cantCuotasValidas = cant >= MIN_CANT_CUOTAS && cant <= MAX_CANT_CUOTAS;

       return  esMontoValida && esTarjetaValida && cantCuotasValidas;
    }

    private double recargoSegunCuotas(int cantCuotas){

        return (cantCuotas -1) * RECARGO_POR_CUOTA;
    }
}
