package sop_rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicasRemoteObject;
import java.util.ArrayList;

public class GesUsuariosImpl extends UnicasRemoteObject implements GesUsuariosInt{
    private ArrayList<UsuarioDTO> usuarios;
    private int contador=0;
    
    public class GesUsuariosImpl() throws RemoteException{

    }

    @override
    public boolean registrarUsuario(PersonalDTO objUsuario) throws RemoteException{

    }

    @override
    public PersonalDTO consultarUsuario(int id) throws RemoteException{
        
    }
}
