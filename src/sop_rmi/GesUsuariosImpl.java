package sop_rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class GesUsuariosImpl extends UnicastRemoteObject implements GesUsuariosInt{
    private ArrayList<PersonalDTO> personal;

    
    public GesUsuariosImpl() throws RemoteException{
        super();
        this.usuarios = new ArrayList();
    }

    @Override
    public boolean registrarPersonal(PersonalDTO objUsuario) throws RemoteException{
        System.out.println("Entrando a registrar usuario");
        boolean bandera=false;
        
        if(personal.size() < 5)
        {            
            bandera=personal.add(objUsuario);
            System.out.println("Usuario registrado: identificación: " + objUsuario.getId() + ", nombres: " + objUsuario.getNombreCompleto());
        }
        
        return bandera;
    }

    @Override
    public PersonalDTO consultarPersonal(int id) throws RemoteException{
        
        System.out.println("Entrando a consultar usuario");
        UsuarioDTO objUsuario=null;
        
        for (int i = 0; i < this.personal.size(); i++) {
            if(this.misUsuarios.get(i).getID()==identificacion)
            {
                objUsuario=this.personal.get(i);
                break;
            }
        }
        return objUsuario;  
    }
}
