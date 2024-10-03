package uniandes.edu.co.proyecto.entities;

import java.time.LocalDate;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "productos")
public class Producto extends BaseEntity {

    private String nombre;

    private double costoBodega;

    private double precioUnitario;

    private Integer presentacion;

    private Integer cantidad;

    private String unidadMedida;

    private double volumenEmpaque;

    private double pesoEmpaque;

    private LocalDate fechaVencimiento;

    private String codigoBarras;

    private Categoria categoria;
}
