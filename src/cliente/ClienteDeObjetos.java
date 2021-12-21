package cliente;

import sop_rmi.GesUsuariosInt;

public class ClienteDeObjetos{
    private static GesUsuariosInt objRemoto;

    public static void main (String[] args){
        int numPuertoRMIRegistry =0;
        String direccionIpRMIRegistry ="";
        System.out.println("Cual es la direccion ip donde se encuentra el rmiREgistry");
        direccionIpRMIRegistry = cliente.UtilidadesConsola.leerCadena();
        System.out.println("Cual es el numero de puerto por el cual escucha el rmiREgistry");
        numPuertoRMIRegistry = cliente.UtilidadesConsola.leerCadena();
    }
}