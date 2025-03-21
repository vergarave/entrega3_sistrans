package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="especialidades")


public abstract class Especialida {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
        private long id_especialidad;
        private String nombre;
        public Especialida(String nombre) {
            this.nombre = nombre;
        }
        public long getId_especialidad() {
            return id_especialidad;
        }
        public void setId_especialidad(long id_especialidad) {
            this.id_especialidad = id_especialidad;
        }
        public String getNombre() {
            return nombre;
        }
        public void setNombre(String nombre) {
            this.nombre = nombre;
        }
        public Especialida(){;}

}
