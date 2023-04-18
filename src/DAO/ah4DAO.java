package DAO;

import MODELO.ah4;
import MODELO.ah4Json;
import java.util.LinkedList;

public interface ah4DAO {
    public LinkedList<ah4> listarSucursales();
    
    public LinkedList<ah4> listarClientes();
    public LinkedList<ah4Json> listarClientesJson();
    
    public ah4 obtener(int codigo);
    
    public void crearClientes(ah4 ah);

    public void modificarCliente(ah4 ah);

    public void eliminar(int codigo);
    
    //public LinkedList<ah4> compararLogin();
    
    //public LinkedList<ah4> gerente();
    
    //public LinkedList<evalti> usuex();
}
