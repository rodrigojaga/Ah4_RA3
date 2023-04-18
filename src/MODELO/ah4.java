package MODELO;
public class ah4 {
    // clientes productos sucursales vendedores
    private int id;
    // clientes prodcutos sucursales vendedores
    private String nombre;
    // clientes
    private int nit;
    // clientes sucursales
    private String correo;
    // clientes vendedores
    private String genero;
    // productos
    private String descripcion;
    //productos
    private int cantidad;
    // productos
    private double precio;
    //sucursales
    private String direccion;
    // sucursales
    private int telefono;
    //vendedores
    private int caja;
    // vendedores
    private int ventas;

    //constructores

    
    //clientes
    public ah4(int id, String nombre, int nit, String correo, String genero) {
        this.id = id;
        this.nombre = nombre;
        this.nit = nit;
        this.correo = correo;
        this.genero = genero;
    }
    
    //clientes 
    public ah4(String nombre, int nit, String correo, String genero) {
        this.nombre = nombre;
        this.nit = nit;
        this.correo = correo;
        this.genero = genero;
    }
    
    

    //productos
    public ah4(int id, String nombre, String descripcion, int cantidad, double precio) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.cantidad = cantidad;
        this.precio = precio;
    }

    //sucursales
    public ah4(int id, String nombre, String correo, String direccion, int telefono) {
        this.id = id;
        this.nombre = nombre;
        this.correo = correo;
        this.direccion = direccion;
        this.telefono = telefono;
    }

    //vendedores
    public ah4(int id, String nombre, String genero, int caja, int ventas) {
        this.id = id;
        this.nombre = nombre;
        this.genero = genero;
        this.caja = caja;
        this.ventas = ventas;
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

    public int getNit() {
        return nit;
    }

    public void setNit(int nit) {
        this.nit = nit;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
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
    
    
    
    
    
}
