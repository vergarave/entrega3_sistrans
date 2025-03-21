package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Historial_Citas")

public abstract class HistorialCitas {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
        private long id_historias;
        private int afiliado_id;
        private int cita_id;
        private int orden_id;
        public long getId_historias() {
            return id_historias;
        }
        public void setId_historias(long id_historias) {
            this.id_historias = id_historias;
        }
        public int getAfiliado_id() {
            return afiliado_id;
        }
        public void setAfiliado_id(int afiliado_id) {
            this.afiliado_id = afiliado_id;
        }
        public int getCita_id() {
            return cita_id;
        }
        public void setCita_id(int cita_id) {
            this.cita_id = cita_id;
        }
        public int getOrden_id() {
            return orden_id;
        }
        public void setOrden_id(int orden_id) {
            this.orden_id = orden_id;
        }
        public HistorialCitas(){;}

}