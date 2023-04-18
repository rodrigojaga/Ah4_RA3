package MODELO;

import VISTAS.principal;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Desktop;
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
    //ah4DAORelacional ahd = new ah4DAORelacional();
    //LinkedList<String> listarjson = new LinkedList<>();
    String json;
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
            ah4 ah = new ah4(object.get("nombre").getAsString(),object.get("nit").getAsInt(),
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
    
}