package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

//Clase que mapea la tabla Ciudad en la base de datos
@Entity
@Table(name="ciudad")
public class Ciudad {

    @Id //Indica que es la llave primaria
    @GeneratedValue(strategy=GenerationType.AUTO) //Genera automaticamente el valor de la llave primaria
    private Integer codigo;

    //Atributos de la clase
    private String nombre;
    

    public Ciudad(String nombre)
    {
        this.nombre = nombre; 
    }

    public Ciudad()
    {;}

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    


}
