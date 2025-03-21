package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;

@Entity
@Table(name="contribuyentes")
@PrimaryKeyJoinColumn(name="id_afiliado")

public abstract class Contribuyente extends Afiliado{

    @OneToMany
    private Afiliado contribuyente_id;




}
