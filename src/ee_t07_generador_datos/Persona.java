package ee_t07_generador_datos;
/**
 * 
 * @author (EMANUEL LOPEZ) 
 * @version (a version number or a date)
 */
public class Persona<T>{
	   protected T Nombre; 
	   protected Integer Edad;
	   protected T Direccion;
	   protected T Telefono;
	   protected T Correo;
	public Persona(T nombre,Integer edad,T direccion,T telefono,T correo){
	    this.Nombre=nombre;
	    this.Edad=edad;
	    this.Direccion=direccion;
	    this.Telefono=telefono;
	    this.Correo=correo;
	}
	public T getNombre() {
	    return Nombre;
	}
	public void setNombre(T nombre) {
	    Nombre = nombre;
	}
	public Integer getEdad() {
	    return Edad;
	}
	public void setEdad(Integer edad) {
	    Edad = edad;
	}
	public T getDierccion() {
	    return Direccion;
	}
	public void setDierccion(T diereccion) {
	    Direccion = diereccion;
	}
	public T getTelefono() {
	    return Telefono;
	}
	public void setTelefono(T telefono) {
	    Telefono = telefono;
	}
	public T getCorreo() {
	    return Correo;
	}
	public void setCorreo(T correo) {
	    Correo = correo;
	}
	@Override
	public String toString() {
	    return ""+Nombre+"|"+Edad+"|"+Direccion+"|"+Telefono+"|"+Correo;
	}
	public T ToString(){
	    String R="Nombre: "+Nombre+"\nEdad: "+Edad+"\nDireccion: "+Direccion+"\nTelefono: "+Telefono+"\nCorreo: "+Correo+"\n";
	    return (T)R;
	}
	}