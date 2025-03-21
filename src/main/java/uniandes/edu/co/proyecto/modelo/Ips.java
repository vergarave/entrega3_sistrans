package uniandes.edu.co.proyecto.modelo;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="ips")


public abstract class Ips {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
        private long id_ips;
        private String NIT;
        private String nombre;
        private String direccion;
        private String telefono;
        private List servicios_prestados;
        public long getId_ips() {
            return id_ips;
        }
        public void setId_ips(long id_ips) {
            this.id_ips = id_ips;
        }
        public String getNIT() {
            return NIT;
        }
        public void setNIT(String nIT) {
            NIT = nIT;
        }
        public String getNombre() {
            return nombre;
        }
        public void setNombre(String nombre) {
            this.nombre = nombre;
        }
        public String getDireccion() {
            return direccion;
        }
        public void setDireccion(String direccion) {
            this.direccion = direccion;
        }
        public String getTelefono() {
            return telefono;
        }
        public void setTelefono(String telefono) {
            this.telefono = telefono;
        }
        @Column(name = "servicios_prestados")
        @OneToMany
        private List<Servicio> serviciosPrestados;  

        public List<Servicio> getServiciosPrestados() {
            return serviciosPrestados;
        }
        
        public void setServiciosPrestados(List<Servicio> serviciosPrestados) {
            this.serviciosPrestados = serviciosPrestados;
        }
        public Ips(){;}



}
