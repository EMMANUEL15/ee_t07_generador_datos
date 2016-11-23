package ee_t07_generador_datos;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.*;
import java.util.*;
public class Coleccion<T>
{
     public ArrayList<Persona> datos = new ArrayList<Persona>();
     public ArrayList<T> Nombres= new ArrayList<T>();
     public ArrayList<T> Direcciones= new ArrayList<T>();
     public ArrayList<T> Telefonos= new ArrayList<T>();
     public ArrayList<T> Correos= new ArrayList<T>();
     public String D1,D2,D3,D4; Integer Ct;
  /**
   * GENERA LINEAS PARA DAR FORMTO A LA TERMNAL
   */
     public void lineas(){
    for(int i=0;i<=50;i++){
        System.out.print("---");
    }
    System.out.println();
    }
  /**
   * IMPRIME LOS DATOS AGREGADOS EN CADA ARRAYLIST (Nombre,Direccion,Telefono,Correo))
   */
  public void BASE(){// Imprime Lista Base
    lineas();
    System.out.println("\t\t\tBase De Datos ");
    lineas();   int c=0;
    Iterator<T> nombreIterator = Nombres.iterator();
    Iterator<T> direccionesIterator = Direcciones.iterator();
    Iterator<T> telefonosIterator = Telefonos.iterator();
    Iterator<T> correosIterator = Correos.iterator();
    System.out.format("%-30s %-30s %-30s %-30s %n",D1,D2,D3,D4);lineas();
    while(nombreIterator.hasNext()){ 
           c++;
           T Nombre = nombreIterator.next(); 
           T Direccion = direccionesIterator.next(); 
           T Telefono = telefonosIterator.next(); 
           T Correo = correosIterator.next();  
           System.out.format("%-30s %-30s %-30s %-30s %n",Nombre,Direccion,Telefono,Correo);
    }
    System.out.format("%-30s %-30s %-30s %-30s %n","total:"+c,"total:"+c,"total:"+c,"total:"+c);
  }
  /**
   * SE IMPORTA UNA ARCHIVO SCV COMO BASE (CONTIEN LOS DATOS QUE SE TOMARAN ALEATORIAMENTE)
   * SEPARA LA LOS DATOS DEL ARCHIVO EN UNA ARRAY DE NOMBRE, DIRECCIONES, TELEFONOS Y CORREOS
   * ASIGNA EL LIMITE TE SE TOMARAN LOS DATOS
   */  
  public void cargar(String a)throws FileNotFoundException,IOException,Exception{
            Integer i=0; 
            String A=a;
            File   archivo= new File(A);
            FileReader leido= new FileReader(archivo);
            BufferedReader  m = new BufferedReader(leido);
            String linea;
            linea=m.readLine();
        while(linea!=null){
            String columna[]=linea.split("\\|");
            linea = m.readLine();
            if(i==0){
               this.D1=columna[0]; this.D2=columna[1]; this.D3=columna[2]; this.D4=columna[3];
            }else{
               Nombres.add((T)columna[0]);
               Direcciones.add((T)columna[1]);
               Telefonos.add((T)columna[2]);
               Correos.add((T)columna[3]);
            }
            i++;
            } 
        this.Ct=i-1;
            }
  /**
   * GENERADOR DE DATOS.
   * GENERA LOS DATOS TOMANDO ALEATORIAMENTE UN DATOS DE CADA POSICION DE ARRAY.
   * EN EL CASO DE LA EDAD LO ASIGINA DE 10-90.
   * DE LOS DATOS GENERADOS CREA UN OBJETTO DE TIPO PERSONA.
   * IMPRIME LOS DATOS DE CADA OBJETO EN CONSOLA.
   * POR ULTIMO LO AGREGA EN EL ARRAY PERSONA.
   */          
  public void GenerarDatos(Integer cantidad){
      System.out.println("\n\n");
      for(int i=1;i<=cantidad;i++){
          Integer N=(int)(Math.random()*Ct);        //Nombre
          Integer E=(int)(Math.random()*80+10);     //Edad
          Integer D=(int)(Math.random()*Ct);        //Direccion
          Integer T=(int)(Math.random()*Ct);        //Telefono
          Integer C=(int)(Math.random()*Ct);        //Correo
          Persona P=new Persona(Nombres.get(N),E,Direcciones.get(D),Telefonos.get(T),Correos.get(C));
          System.out.println(P.ToString());
          datos.add(P);
        }
    }
    /**
     *GUARDA LOS DATOS GENERADOS EN UN ARCHIVO CVS.
     *RECORRE EL ARRAY PERSONA GUARDADO LOS DATOS EN CADA LINEA DEL ARCHIVO.
     *IMPRIEME LOS DATOS EN FORMATO QUE SE GUARDAN EN EL ARCHIVO.
     */
   public void Datos(String Archivo)throws FileNotFoundException,IOException,Exception{// Imprime Lista de Datos Generados
    lineas(); System.out.println("\t\tLista de Datos Generados");lineas();
    Iterator<Persona> personaIterator = datos.iterator();
    System.out.println(D1+"|"+D2+"|"+D3+"|"+D4);lineas();
    File nu=new File(Archivo+".csv");
    BufferedWriter es= new BufferedWriter(new FileWriter(nu));
    String text=(D1+"|"+"Edad|"+D2+"|"+D3+"|"+D4);
    es.write(text);es.newLine(); es.flush(); 
    while(personaIterator.hasNext()){ 
           Persona P = personaIterator.next(); 
           System.out.format("%-30s  %n",P);
           es.write(P.toString()); 
           es.newLine(); 
           es.flush(); 
    }
  }
        }