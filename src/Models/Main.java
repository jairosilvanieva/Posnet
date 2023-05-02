package Models;

public class Main {
    public static void main(String[] args) {
            Posnet posnet = new Posnet();
            Persona p = new Persona("36071890", "Jairo","Silva","2234219607", "jairosn22@gmail.com");
            TarjetaDeCredito t = new TarjetaDeCredito("galicia", "123456789",15000,EntidadFinanciera.CASTEMARD,p);

        System.out.println("tarjeta antes del pago: ");
        System.out.println(t);

        Ticket ticketgenetado = posnet.efectuarPago(t,10000, 5);
        System.out.println(ticketgenetado);

        System.out.println("Tarjeta despues del pago : ");

        System.out.println(t);


    }
}