package MODELO;

import DAO.ah4DAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;
import javax.swing.JOptionPane;

public class ah4DAORelacional implements ah4DAO{
    
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    conexk acceso = new conexk();

    //LinkedList<ah4> json = new LinkedList<>();
    Json js = new Json();
    @Override
    public LinkedList<ah4> listarSucursales() {
        String sql = "SELECT id_sucursal, nombre, direccion,correo,telefono FROM sucursales;";
        LinkedList<ah4> listar = new LinkedList<>();
        try {
            
            con = acceso.Conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                listar.add(new ah4(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5)));
                
            }
            return listar;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Algo ha salido mal: \n"+e+" \n Contactese con el desarrollador");
        }
        return null;
    }
    
     @Override
    public LinkedList<ah4> listarClientes() {
        String sql = "SELECT id_cliente, nombre, nit,correo,genero FROM clientes;";
        LinkedList<ah4> listar = new LinkedList<>();
        LinkedList<ah4Json> listara = new LinkedList<>();
        Json js = new Json();
        
        try {
            
            con = acceso.Conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                listar.add(new ah4(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getString(5)));
                listara.add(new ah4Json(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getString(5)));
            }
            return listar;
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Algo ha salido mal: \n"+e+" \n Contactese con el desarrollador");
        }
        return null;
    }
    
    

    @Override
    public ah4 obtener(int codigo) {
        String sql = "select * from clientes where id_cliente= ?";

        try {
            con = acceso.Conectar();
            ps = con.prepareStatement(sql);
            ps.setInt(1, codigo);
            rs = ps.executeQuery();
            if (rs.next()) {
                ah4 ah = new ah4(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getString(4),rs.getString(5));
                return ah;
            } else {
              JOptionPane.showMessageDialog(null,"Algo ha salido mal");  
            }
            return null;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Algo ha salido mal: \n"+e+" \n Contactese con el desarrollador");
        }
        return null;
    }

    @Override
    public void crearClientes(ah4 ah) {
        String sql = "insert into clientes(nombre,nit,correo,genero) values (?,?,?,?);";
        try{
            con = acceso.Conectar();
            ps = con.prepareStatement(sql);
            ps.setString(1, ah.getNombre());
            ps.setInt(2, ah.getNit());
            ps.setString(3, ah.getCorreo());
            ps.setString(4, ah.getGenero());
            ps.executeUpdate();
        }catch(Exception e){JOptionPane.showMessageDialog(null,"Algo ha salido mal: \n"+e+" \n Contactese con el desarrollador");}
    }

    @Override
    public void modificarCliente(ah4 ah) {
        String sql = "update clientes set nombre=?, nit=? , correo = ?, genero =? where id_cliente=?;";
        try {
            
            con = acceso.Conectar();
            ps = con.prepareStatement(sql);
            
            ps.setString(1, ah.getNombre());
            ps.setInt(2, ah.getNit());
            ps.setString(3, ah.getCorreo());
            ps.setString(4, ah.getGenero());
            ps.setInt(5, ah.getId());
            ps.executeUpdate();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Algo ha salido mal: \n"+e+" \n Contactese con el desarrollador");
        }
    }

    @Override
    public void eliminar(int codigo) {
        String sql = "DELETE FROM clientes WHERE id_cliente = ?;";
        try {
            con = acceso.Conectar();
            ps = con.prepareStatement(sql);
            ps.setInt(1, codigo);
            ps.executeUpdate();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Seleccione una fila");
        }
    }

    @Override
    public LinkedList<ah4Json> listarClientesJson() {
        String sql = "SELECT id_cliente, nombre, nit,correo,genero FROM clientes;";
       
        LinkedList<ah4Json> listara = new LinkedList<>();
        Json js = new Json();
        
        try {
            
            con = acceso.Conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                
                listara.add(new ah4Json(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getString(5)));
            }
            return listara;
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Algo ha salido mal: \n"+e+" \n Contactese con el desarrollador");
        }
        return null;
    }

   
    
}
