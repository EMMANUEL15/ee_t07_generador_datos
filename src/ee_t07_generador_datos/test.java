package ee_t07_generador_datos;
import java.io.*;
import java.util.*;
import javax.swing.*;
import javax.swing.JFileChooser;
import java.util.logging.Logger;
public class test extends javax.swing.JFrame{
    /**
     * Menu principal
     * carga un archivo que qu contien los datos que toma aleatoriamente
     *  imprime es archivo importado este caso esta comentado!
     * toma  la cantidad ingrasada para que generar datos
     * finalmente guarda los datos generdados en formto csv
     */
     public  void Ejecutar()throws FileNotFoundException,IOException,Exception{
        Coleccion c = new Coleccion();
        c.cargar("dataNov.csv");      //Nombre del Archivo
        //c.BASE();                     //IMPRIME  LA BASE DE DATOS***********************************
        int Cantidad=Integer.parseInt(JOptionPane.showInputDialog("Cantidad de Datos: "));
        c.GenerarDatos(Cantidad);           //Grenrador de datos
        File Archivo;
        JFileChooser filechooser=new JFileChooser();
        int opcion = filechooser.showDialog(this,"Guardar");
        String Nombre="";
       if(opcion==JFileChooser.APPROVE_OPTION){
             Nombre=(filechooser.getSelectedFile().getPath())+Nombre;
        }
        c.Datos(Nombre);
   }
   /**
    * metodo ejecuble
    */
   public static void main(String args[])throws FileNotFoundException,IOException,Exception{
    test t=new test();
    t.Ejecutar();
    }
    }