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
            System.out.println("1. Registrar personal");			
            System.out.println("2. Consultar personal");
            System.out.println("3. Salir");

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

            int opcionTI = 0;
            String varTipoIdentificacion="";
            do
                {
                System.out.println("==TIPO DE IDENTIFICACION==");
                System.out.println("1. Cedula de Ciudadania");			
                System.out.println("2. Tarjeta de Identidad");
                System.out.println("3. Pasaporte");
                

                opcionTI = UtilidadesConsola.leerEntero();

                switch(opcion)
                {
                    case 1:
                            varTipoIdentificacion="CC"
                            break;
                    case 2:
                            varTipoIdentificacion="TI"
                            break;	
                    case 3:
                            varTipoIdentificacion="PP"
                            break;
                    default:
                            System.out.println("Opción incorrecta");
                }

            }while(opcionTI != -1);

            System.out.println("Ingrese el numero de identificacion");
            int varId = UtilidadesConsola.leerEntero();
            if (id < 0){
                bandera = true;
            }

            System.out.println("Ingrese el nombre completo ");
            String varNombres = UtilidadesConsola.leerCadena();

            System.out.println("Ingrese la ocupacion del nuevo usuario ");
            String varOcupacion="";
             do
                {
                System.out.println("==TIPO DE OCUPACION==");
                System.out.println("1. Secretaria");			
                System.out.println("2. Profesional de acondicionamiento fisico");
                

                opcionTI = UtilidadesConsola.leerEntero();

                switch(opcion)
                {
                    case 1:
                            varOcupacion="Secretaria"
                            break;
                    case 2:
                            varOcupacion="Personal de acondicioamiento fisico"
                            break;	

                    default:
                            System.out.println("Opción incorrecta");
                }

            }while(opcionTI != -1);

        

            System.out.println("Ingrese el usuario ");
            String varUsuario = UtilidadesConsola.leerCadena();

            if (varUsuario<8){
                bandera=true;
            }


            System.out.println("Ingrese la contraseña ");
            String varContraseña = UtilidadesConsola.leerCadena();

            if (varContraseña<8){
                bandera=true;
            }
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
        int id = -1;
        try
        {
            System.out.println("========================");
            System.out.println("==Consulta de personal==");
            System.out.println("========================");

            System.out.println("Digite el id del personal a buscar");

            id = UtilidadesConsola.leerEntero();

            PersonalDTO personal  = objRemoto.consultarPersonal(id);
            System.out.println();
        }
        catch(RemoteException e)
        {
            System.out.println("La operación no se pudo completar, intente nuevamente...");
            System.out.println("Excepcion generada: " + e.getMessage());
        }	
    }

}