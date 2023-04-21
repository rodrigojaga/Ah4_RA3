package MODELO;
public class vendedoresPOO {
    private int id;
    private String nombre;
    private int caja;
    private int ventas;
    private String genero;
    private String password;

    public vendedoresPOO(int id, String nombre, int caja, int ventas, String genero, String password) {
        this.id = id;
        this.nombre = nombre;
        this.caja = caja;
        this.ventas = ventas;
        this.genero = genero;
        this.password = password;
    }

    public vendedoresPOO(String nombre, int caja, int ventas, String genero, String password) {
        this.nombre = nombre;
        this.caja = caja;
        this.ventas = ventas;
        this.genero = genero;
        this.password = password;
    }

    public vendedoresPOO(String nombre, String password) {
        this.nombre = nombre;
        this.password = password;
    }
  
    

    
    
   
    

    

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    

    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCaja() {
        return caja;
    }

    public void setCaja(int caja) {
        this.caja = caja;
    }

    public int getVentas() {
        return ventas;
    }

    public void setVentas(int ventas) {
        this.ventas = ventas;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }
    
    
}
