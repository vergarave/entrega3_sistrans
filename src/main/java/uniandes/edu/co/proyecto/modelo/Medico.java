package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="medicos")


public abstract class Medico {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
        private long id_medico;
        private String nombre;
        private int especialidad_id;
        private String registro_medico;
        private int ips_id;        
        public Medico(String nombre, int especialidad_id, String registro_medico, int ips_id) {
            this.nombre = nombre;
            this.especialidad_id = especialidad_id;
            this.registro_medico = registro_medico;
            this.ips_id = ips_id;
        }
        public long getId_medico() {
            return id_medico;
        }
        public void setId_medico(long id_medico) {
            this.id_medico = id_medico;
        }
        public String getNombre() {
            return nombre;
        }
        public void setNombre(String nombre) {
            this.nombre = nombre;
        }
        public int getEspecialidad_id() {
            return especialidad_id;
        }
        public void setEspecialidad_id(int especialidad_id) {
            this.especialidad_id = especialidad_id;
        }
        public String getRegistro_medico() {
            return registro_medico;
        }
        public void setRegistro_medico(String registro_medico) {
            this.registro_medico = registro_medico;
        }
        public int getIps_id() {
            return ips_id;
        }
        public void setIps_id(int ips_id) {
            this.ips_id = ips_id;
        }
        public Medico(){;}
        
}