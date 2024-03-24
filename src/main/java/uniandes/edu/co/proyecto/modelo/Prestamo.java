package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="prestamos")
public class Prestamo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String estado;
    private String tipo;
    private Float monto;
    private Float interes;
    private Integer numero_cuotas;
    private String dia_mes_pagar_cuota;
    private Float valor_cuota;
    @ManyToOne
    @JoinColumn(name = "cliente", referencedColumnName = "id")
    private Cliente cliente;
    private Integer gerente_creador;
    private Float saldo_pendiente;


    public Prestamo(String estado, String tipo, Float monto, Float interes, Integer numero_cuotas,
            String dia_mes_pagar_cuota, Float valor_cuota, Cliente cliente, Integer gerente_creador,
            Float saldo_pendiente) {
        this.estado = estado;
        this.tipo = tipo;
        this.monto = monto;
        this.interes = interes;
        this.numero_cuotas = numero_cuotas;
        this.dia_mes_pagar_cuota = dia_mes_pagar_cuota;
        this.valor_cuota = valor_cuota;
        this.cliente = cliente;
        this.gerente_creador = gerente_creador;
        this.saldo_pendiente = saldo_pendiente;
    }
    
    public Prestamo() {
        ;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Float getMonto() {
        return monto;
    }

    public void setMonto(Float monto) {
        this.monto = monto;
    }

    public Float getInteres() {
        return interes;
    }

    public void setInteres(Float interes) {
        this.interes = interes;
    }

    public Integer getNumero_cuotas() {
        return numero_cuotas;
    }

    public void setNumero_cuotas(Integer numero_cuotas) {
        this.numero_cuotas = numero_cuotas;
    }

    public String getDia_mes_pagar_cuota() {
        return dia_mes_pagar_cuota;
    }

    public void setDia_mes_pagar_cuota(String dia_mes_pagar_cuota) {
        this.dia_mes_pagar_cuota = dia_mes_pagar_cuota;
    }

    public Float getValor_cuota() {
        return valor_cuota;
    }

    public void setValor_cuota(Float valor_cuota) {
        this.valor_cuota = valor_cuota;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Integer getGerente_creador() {
        return gerente_creador;
    }

    public void setGerente_creador(Integer gerente_creador) {
        this.gerente_creador = gerente_creador;
    }

    public Float getSaldo_pendiente() {
        return saldo_pendiente;
    }

    public void setSaldo_pendiente(Float saldo_pendiente) {
        this.saldo_pendiente = saldo_pendiente;
    }


}