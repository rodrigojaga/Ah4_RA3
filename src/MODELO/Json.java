package MODELO;

import VISTAS.principal;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Desktop;
import java.awt.Font;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.util.LinkedList;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;








public class Json {
    String json;
    String jsonSucursales;
    String rutaG;
    Document documento;
        FileOutputStream fileOutputStream;
        
        com.itextpdf.text.Font fuenteTitulo = FontFactory.getFont(FontFactory.TIMES_ROMAN, 16);
        com.itextpdf.text.Font fuenteParrafo = FontFactory.getFont(FontFactory.HELVETICA, 12);
        
        
        
    private String leerarchivo() {
        JFileChooser fc = new JFileChooser();
        JPanel datos = new JPanel();
        int op = fc.showOpenDialog(datos);
        String content = "";
        if (op == JFileChooser.APPROVE_OPTION) {
            File pRuta = fc.getSelectedFile();
            String ruta = pRuta.getAbsolutePath();
            File archivo = null;
            FileReader fr = null;
            BufferedReader br = null;

            try {
                archivo = new File(ruta);
                fr = new FileReader(archivo);
                br = new BufferedReader(fr);
                String linea = "";

                while ((linea = br.readLine()) != null) {
                    content += linea + "\n";
                }
                return content;

            } catch (FileNotFoundException ex) {
                JOptionPane.showInputDialog(null, "No se encontro el archivo");
            } catch (IOException ex) {
                JOptionPane.showInputDialog(null, "No se pudo abrir el archivo");
            } finally {
                try {
                    if (null != fr) {
                        fr.close();
                    }
                } catch (Exception e2) {
                    JOptionPane.showInputDialog(null, "No se encontro el archivo");
                    return "";
                }
            }
            return content;
        }
        return null;
    }
    
    public void carga_masivaClientes() throws FileNotFoundException, IOException, ParseException {

        String archivo_retorno = leerarchivo();

        JsonParser parse = new JsonParser();

        JsonArray matriz = parse.parse(archivo_retorno).getAsJsonArray();

        for (int i = 0; i < matriz.size(); i++) {
            
            JsonObject object = matriz.get(i).getAsJsonObject();
            String s = object.get("genero").getAsString().toUpperCase();
            clientesPOO ah = new clientesPOO(object.get("nombre").getAsString(),object.get("nit").getAsInt(),
            object.get("correo").getAsString(),s);
            ah4DAORelacional ad = new ah4DAORelacional();
            ad.crearClientes(ah);
            //principal pr = new principal();
            //pr.setVisible(true);
            //dispose();
            //System.out.println("nombre: " + object.get("nombre").getAsString() + " Caja: " + object.get("caja").getAsInt());
            
        }
        JOptionPane.showMessageDialog(null, "Carga masiva finalizada. \nPuede que sea necesario recargar para ver cambios");

    }
    public void carga_masivaSucursales() throws FileNotFoundException, IOException, ParseException {
        String archivo_retorno = leerarchivo();
        JsonParser parse = new JsonParser();
        JsonArray matriz = parse.parse(archivo_retorno).getAsJsonArray();
        for (int i = 0; i < matriz.size(); i++) {
            JsonObject object = matriz.get(i).getAsJsonObject();
            sucursalesPOO ah = new sucursalesPOO(object.get("nombre").getAsString(),object.get("direccion").getAsString(),
            object.get("correo").getAsString(),object.get("telefono").getAsInt());
            ah4DAORelacional ad = new ah4DAORelacional();
            ad.crearSucursales(ah);
          }
        JOptionPane.showMessageDialog(null, "Carga masiva finalizada. \nPuede que sea necesario recargar para ver cambios");
    }
    public void carga_masivaProductos() throws FileNotFoundException, IOException, ParseException{
        String archivo_retorno = leerarchivo();
        JsonParser parse = new JsonParser();
        JsonArray matriz = parse.parse(archivo_retorno).getAsJsonArray();
        for (int i = 0; i < matriz.size(); i++) {
            JsonObject object = matriz.get(i).getAsJsonObject();
            productosPOO ah = new productosPOO(object.get("nombre").getAsString(),object.get("descripcion").getAsString(),
            object.get("cantidad").getAsInt(),object.get("precio").getAsDouble());
            ah4DAORelacional ad = new ah4DAORelacional();
            ad.crearProductos(ah);
          }
        JOptionPane.showMessageDialog(null, "Carga masiva finalizada. \nPuede que sea necesario recargar para ver cambios");
    }
    
    
    private void generar_pdf(String datos) throws FileNotFoundException, DocumentException {
        FileOutputStream gen = new FileOutputStream("Clientes.pdf");
        Document documento = new Document();

        PdfWriter.getInstance(documento, gen);
        documento.open();

        Paragraph parrafo = new Paragraph("Datos de Clientes");
        parrafo.setAlignment(1);
        documento.add(parrafo);
        documento.add(new Paragraph("\n"));
        
        parrafo.setAlignment(0);
        documento.add(new Paragraph(datos));
        documento.add(new Paragraph("\n"));

        //String texto = "Hola a todos, mi nombre es Javier Giron y tengo 22 años";
        //documento.add(new Paragraph(texto));
        documento.close();
        JOptionPane.showMessageDialog(null, "El archivo se creo correctamente");
        try {
            File clientes_doc = new File("Clientes.pdf");
            Desktop.getDesktop().open(clientes_doc);
        } catch (Exception e) {
        }
    }
    private void generar_pdfSucursales(String datos) throws FileNotFoundException, DocumentException {
        FileOutputStream gen = new FileOutputStream("Sucursales.pdf");
        Document documento = new Document();

        PdfWriter.getInstance(documento, gen);
        documento.open();

        Paragraph parrafo = new Paragraph("Datos de Sucursales");
        parrafo.setAlignment(1);
        documento.add(parrafo);
        documento.add(new Paragraph("\n"));
        
        parrafo.setAlignment(0);
        documento.add(new Paragraph(datos));
        documento.add(new Paragraph("\n"));

        //String texto = "Hola a todos, mi nombre es Javier Giron y tengo 22 años";
        //documento.add(new Paragraph(texto));
        documento.close();
        JOptionPane.showMessageDialog(null, "El archivo se creo correctamente");
        try {
            File sucursales_doc = new File("Sucursales.pdf");
            Desktop.getDesktop().open(sucursales_doc);
        } catch (Exception e) {
        }
    }
    
    public void crearjson() throws FileNotFoundException, DocumentException {
        LinkedList<String> xz = new LinkedList<>();
        String json = "[\n";
        ah4DAORelacional ad = new ah4DAORelacional();
        
        
        
        
        for (ah4Json dat : ad.listarClientesJson()) {
            Object ayuda[] = new Object[5];
            ayuda[0] = dat.getCodigo();
            ayuda[1] = dat.getNombre();
            ayuda[2] = dat.getNit();
            ayuda[3] = dat.getCorreo();
            ayuda[4] = dat.getGenero();
            int z = (int) ayuda[0];
            String a = ayuda[1]+"";
            int b = (int) ayuda[2];
            String c = ayuda[3]+"";
            String d = ayuda[4]+"";
            xz.add(a);
            ah4Json ah = new ah4Json(z,a,b,c,d);
            
            Gson gson = new Gson();
            int i = -1;i++;
            
            if(i<xz.size()){
                json += gson.toJson(ah) + ", \n";
            }else {
                json += gson.toJson(ah);
            }    
                    
                        
            
        }
        
        
            
        
        
        
        

        json += "]";
        generar_pdf(json);
        // Imprimir la representación JSON
        
    }
    public void crearjsonSucursales() throws FileNotFoundException, DocumentException {
        LinkedList<String> xz = new LinkedList<>();
        String json = "[\n";
        ah4DAORelacional ad = new ah4DAORelacional();
        for (sucursalesPOO dat : ad.listarSucursales()) {
            Object ayuda[] = new Object[5];
            ayuda[0] = dat.getId();
            ayuda[1] = dat.getNombre();
            ayuda[2] = dat.getDireccion();
            ayuda[3] = dat.getCorreo();
            ayuda[4] = dat.getTelefono();
            int z = (int) ayuda[0];
            String a = ayuda[1]+"";
            String b = ayuda[2]+"";
            String c = ayuda[3]+"";
            int d = (int) ayuda[4];
            xz.add(a);
            sucursalesPOO sp = new sucursalesPOO(z,a,b,c,d);
            
            Gson gson = new Gson();
            int i = -1;i++;
            
            if(i<xz.size()){
                json += gson.toJson(sp) + ", \n";
            }else {
                json += gson.toJson(sp);
            }     
        }
        json += "]";
        generar_pdfSucursales(json);
    
    }
   
    
    
    
    
    
    
    
    
    
    //Reutilizable
    public void crearDocumento(String ruta,String titulo) throws FileNotFoundException, DocumentException{
        //Tipo de hoja y margenes left-right-top-bottom
        rutaG = ruta;
        documento = new Document(PageSize.A4,25,25,50,50);
        
        //archivo que se va a generar 
        //String ruta = "Ingresar ruta donde se crea el pdf";
        fileOutputStream = new FileOutputStream(ruta + "\\"+titulo+".pdf");
        
        PdfWriter.getInstance(documento, fileOutputStream);
        abrir(titulo);
        
    }
    //Reutilizable
    public void abrir(String titulo) throws DocumentException{
        documento.open();
        titulo(titulo);
    }
    //Reutilizable
    public void titulo(String texto) throws DocumentException{
        PdfPTable tabla = new PdfPTable(1);
        PdfPCell celda = new PdfPCell(new Phrase(texto,fuenteTitulo));
        celda.setColspan(5);
        celda.setBorderColor(BaseColor.WHITE);
        celda.setHorizontalAlignment(Element.ALIGN_CENTER);
        tabla.addCell(celda);
        documento.add(tabla);
        parrafo("Datos para la vizualizacion de la tabla "+texto);
    }
    //Reutilizable
    public void parrafo(String texto) throws DocumentException{
        Paragraph parrafo = new Paragraph();
        parrafo.add(new Phrase(texto,fuenteParrafo));
        documento.add(parrafo);
        saltosLinea();
    }
    //Reutilizable
    public void saltosLinea() throws DocumentException{
        Paragraph saltos = new Paragraph();
        saltos.add(new Phrase(Chunk.NEWLINE));
        saltos.add(new Phrase(Chunk.NEWLINE));
        documento.add(saltos);
        agregartabla();
    }
    //No reutilizable
    public void agregartabla() throws DocumentException{
        PdfPTable tabla = new PdfPTable(5);
        tabla.addCell("Id Producto");
        tabla.addCell("Nombre");
        tabla.addCell("Descripcion");
        tabla.addCell("Cantidad");
        tabla.addCell("Precio");
        ah4DAORelacional ahd = new ah4DAORelacional();
        LinkedList<productosPOO> productos = ahd.listarProductos();
        for(productosPOO producto: productos){
            tabla.addCell(String.valueOf(producto.getId()));
            tabla.addCell(producto.getNombre());
            tabla.addCell(producto.getDescripcion());
            tabla.addCell(String.valueOf(producto.getCantidad()));
            tabla.addCell(String.valueOf(producto.getPrecio()));
        }
       documento.add(tabla);
       JOptionPane.showMessageDialog(null, "El archivo se creo correctamente");
       cerrar();
       
    }
    //No reutlizable
    public void cerrar(){
        documento.close();
        int respuesta = JOptionPane.showConfirmDialog(null, "Desea abrir el archivo?", 
                "CONFIRMAR", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if(respuesta==JOptionPane.YES_OPTION){
                try {
                    File productos_doc = new File(rutaG+"\\Productos.pdf");
                    Desktop.getDesktop().open(productos_doc);
                } catch (Exception e) {
                    }        
            }else if(respuesta==JOptionPane.NO_OPTION){
            }
        
    }

   


}
