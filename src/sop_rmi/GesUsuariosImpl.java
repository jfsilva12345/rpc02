package sop_rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicasRemoteObject;
import java.util.ArrayList;

public class GesUsuariosImpl extends UnicastRemoteObject implements GesUsuariosInt{
    private ArrayList<UsuarioDTO> usuarios;
    private int contador=0;
    
    public class GesUsuariosImpl() throws RemoteException{
        super();
        this.usuarios = new ArrayList();
    }

    @override
    public boolean registrarUsuario(PersonalDTO objUsuario) throws RemoteException{
        System.out.println("Entrando a registrar usuario");
        boolean bandera=false;
        
        if(misUsuarios.size() < 5)
        {            
            bandera=misUsuarios.add(objUsuario);
            System.out.println("Usuario registrado: identificación: " + objUsuario.getID() + ", nombres: " + objUsuario.getNombres() + ", apellidos. " +objUsuario.getApellidos() );
        }
        
        return bandera;
    }

    @override
    public PersonalDTO consultarUsuario(int id) throws RemoteException{
        
        System.out.println("Entrando a consultar usuario");
        UsuarioDTO objUsuario=null;
        contador = 0;

        for(PersonalDTO personal : usuarios){
            if(usuarios.get(i).getID()==identificacion){
                   objUsuario=usuarios.get(i);
                break;
            }
            contado´++;
        }
        return objUsuario;  
    }
}
