package DAO;

import MODELO.clientesPOO;
import MODELO.ah4Json;
import MODELO.productosPOO;
import MODELO.sucursalesPOO;
import java.util.LinkedList;

public interface ah4DAO {
    public LinkedList<sucursalesPOO> listarSucursales();
    public LinkedList<clientesPOO> listarClientes();
    public LinkedList<productosPOO> listarProductos();
    
    
    public LinkedList<ah4Json> listarClientesJson();
    
    
    public clientesPOO obtener(int codigo);
    public sucursalesPOO obtenerSucu(int codigo);
    public productosPOO obtenerPro(int codigo);
    
    
    public void crearClientes(clientesPOO ah);
    public void crearSucursales(sucursalesPOO ah);
    public void crearProductos(productosPOO ah);
    
    
    public void modificarCliente(clientesPOO ah);
    public void modificarSucursal(sucursalesPOO ah);
    public void modificarProducto(productosPOO ah);
    
    public void eliminar(int codigo);
    public void eliminarSucu(int codigo);
    public void eliminarPro(int codigo);
    
    //public LinkedList<ah4> compararLogin();
    
    //public LinkedList<ah4> gerente();
    
    //public LinkedList<evalti> usuex();
}
