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
        numPuertoRMIRegistry = cliente.UtilidadesConsola.leerEntero();

        objRemoto = (GesUsuarioInt) UtilidadesRegistroC.obtenerObjRemoto(direccionIpRMIRegistry,numPuertoRMIRegistry,"ObjetoRemotoPersonal");
        MenuPrincipal();
    }
    

    private static void MenuPrincipal()
    {
        int opcion = 0;
        do
        {
            System.out.println("==Menu==");
            System.out.println("1. Registrar Usuario");			
            System.out.println("2. Consultar Cantidad de Usuarios");
            System.out.println("3. Consultar usuario");
            System.out.println("4. Salir");

            opcion = UtilidadesConsola.leerEntero();

            switch(opcion)
            {
                case 1:
                        Opcion1();
                        break;
                case 2:
                        Opcion2();
                        break;	
                case 3:
                        Opcion3();
                        break;
                case 4:
                        System.out.println("Salir...");
                        break;
                default:
                        System.out.println("Opción incorrecta");
            }

        }while(opcion != 4);
    }

    private static void Opcion1() 
    {
        try
        {
            System.out.println("==Registro del Cliente==");
            System.out.println("Ingrese la identificacion");
            int id = UtilidadesConsola.leerEntero();
            System.out.println("Ingrese el nombre completo ");
            String nombres = UtilidadesConsola.leerCadena();
            System.out.println("Ingrese los apellidos ");
            String apellidos = UtilidadesConsola.leerCadena();
            UsuarioDTO objUsuario= new UsuarioDTO(id, nombres, apellidos);

            boolean valor = objRemoto.registrarUsuario(objUsuario);//invocación al método remoto
            if(valor)
                    System.out.println("Registro realizado satisfactoriamente...");
            else
                    System.out.println("no se pudo realizar el registro...");
        }
        catch(RemoteException e)
        {
            System.out.println("La operacion no se pudo completar, intente nuevamente...");
        }
    }

    private static void Opcion2()
    {	
        try
        {
            System.out.println("==Numero de usuarios==");
            int tamanio  = objRemoto.consultarCantidadUsuarios();
            System.out.println("El numero de usuarios registrados es de: "+ tamanio);
        }
        catch(RemoteException e)
        {
            System.out.println("La operación no se pudo completar, intente nuevamente...");
            System.out.println("Excepcion generada: " + e.getMessage());
        }	
    }

    private static void Opcion3() 
    {
        try
        {
            System.out.println("==Consulta de un Cliente==");
            System.out.println("Ingrese la identificacion");
            int id = UtilidadesConsola.leerEntero();			

            UsuarioDTO objUsuario= objRemoto.consultarUsuario(id);
            if(objUsuario!=null)
            {
                    System.out.println("Nombres: " + objUsuario.getNombres());
                    System.out.println("Apellidos: " + objUsuario.getApellidos());
            }
            else
                    System.out.println("Usuario no encontrado");
        }
        catch(RemoteException e)
        {
            System.out.println("La operacion no se pudo completar, intente nuevamente...");
        }
    }
}