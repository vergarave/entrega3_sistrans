package uniandes.edu.co.proyecto.modelo;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="producto")
public class Producto {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    
    private Integer identificador;
    private String nombre;
    private Double costoEnBodega;
    private String presentacion;
    private Double cantidadPresentacion;
    private String unidadMedida;
    private String volumenEmpaque;
    private String pesoEmpaque;
    private LocalDate fechaExpiracion;
    private String codigoDeBarras;

    @ManyToOne
    @JoinColumn(name="clasificacionCategoria", referencedColumnName = "codigo")
    private Categoria clasificacionCategoria;

    public Producto(String nombre, Double costoEnBodega, String presentacion, 
        Double cantidadPresentacion, String unidadMedida, String volumenEmpaque,
        String pesoEmpaque, LocalDate fechaExpiracion, String codigoDeBarras, 
        Categoria clasificacionCategoria
    ) {
        this.nombre = nombre;
        this.costoEnBodega = costoEnBodega;
        this.presentacion = presentacion;
        this.cantidadPresentacion = cantidadPresentacion;
        this.unidadMedida = unidadMedida;
        this.volumenEmpaque = volumenEmpaque;
        this.pesoEmpaque = pesoEmpaque;
        this.fechaExpiracion = fechaExpiracion;
        this.codigoDeBarras = codigoDeBarras;
        this.clasificacionCategoria = clasificacionCategoria;
    }

    public Producto()
    {;}

    public Integer getIdentificador() {
        return identificador;
    }

    public String getNombre() {
        return nombre;
    }

    public Double getCostoEnBodega() {
        return costoEnBodega;
    }

    public String getPresentacion() {
        return presentacion;
    }

    public Double getCantidadPresentacion() {
        return cantidadPresentacion;
    }

    public String getUnidadMedida() {
        return unidadMedida;
    }

    public String getVolumenEmpaque() {
        return volumenEmpaque;
    }

    public String getPesoEmpaque() {
        return pesoEmpaque;
    }

    public LocalDate getFechaExpiracion() {
        return fechaExpiracion;
    }

    public String getCodigoDeBarras() {
        return codigoDeBarras;
    }

    public Categoria getClasificacionCategoria() {
        return clasificacionCategoria;
    }

    public void setIdentificador(Integer identificador) {
        this.identificador = identificador;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCostoEnBodega(Double costoEnBodega) {
        this.costoEnBodega = costoEnBodega;
    }

    public void setPresentacion(String presentacion) {
        this.presentacion = presentacion;
    }

    public void setCantidadPresentacion(Double cantidadPresentacion) {
        this.cantidadPresentacion = cantidadPresentacion;
    }

    public void setUnidadMedida(String unidadMedida) {
        this.unidadMedida = unidadMedida;
    }

    public void setVolumenEmpaque(String volumenEmpaque) {
        this.volumenEmpaque = volumenEmpaque;
    }

    public void setPesoEmpaque(String pesoEmpaque) {
        this.pesoEmpaque = pesoEmpaque;
    }

    public void setFechaExpiracion(LocalDate fechaExpiracion) {
        this.fechaExpiracion = fechaExpiracion;
    }

    public void setCodigoDeBarras(String codigoDeBarras) {
        this.codigoDeBarras = codigoDeBarras;
    }

    public void setClasificacionCategoria(Categoria clasificacionCategoria) {
        this.clasificacionCategoria = clasificacionCategoria;
    }

}
