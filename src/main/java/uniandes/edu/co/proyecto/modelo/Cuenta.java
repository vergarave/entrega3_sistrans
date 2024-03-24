package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="cuentas")
public class Cuenta {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private Integer numero_cuenta;
    private String estado;
    private Integer saldo;
    private String tipo;
    @ManyToOne
    @JoinColumn(name = "cliente", referencedColumnName = "id")
    private Cliente cliente;

    private String ultima_transaccion;
    private String gerente_oficina_creador;
    private String fecha_creacion;

    public Cuenta(Integer numero_cuenta, String estado, Integer saldo, String tipo, Cliente cliente,
            String ultima_transaccion, String gerente_oficina_creador, String fecha_creacion) {
        this.numero_cuenta = numero_cuenta;
        this.estado = estado;
        this.saldo = saldo;
        this.tipo = tipo;
        this.cliente = cliente;
        this.ultima_transaccion = ultima_transaccion;
        this.gerente_oficina_creador = gerente_oficina_creador;
        this.fecha_creacion = fecha_creacion;
    }

    public Cuenta() {
        ;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNumero_cuenta() {
        return numero_cuenta;
    }

    public void setNumero_cuenta(Integer numero_cuenta) {
        this.numero_cuenta = numero_cuenta;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Integer getSaldo() {
        return saldo;
    }

    public void setSaldo(Integer saldo) {
        this.saldo = saldo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public String getUltima_transaccion() {
        return ultima_transaccion;
    }

    public void setUltima_transaccion(String ultima_transaccion) {
        this.ultima_transaccion = ultima_transaccion;
    }

    public String getGerente_oficina_creador() {
        return gerente_oficina_creador;
    }

    public void setGerente_oficina_creador(String gerente_oficina_creador) {
        this.gerente_oficina_creador = gerente_oficina_creador;
    }

    public String getFecha_creacion() {
        return fecha_creacion;
    }

    public void setFecha_creacion(String fecha_creacion) {
        this.fecha_creacion = fecha_creacion;
    }

    

    


}