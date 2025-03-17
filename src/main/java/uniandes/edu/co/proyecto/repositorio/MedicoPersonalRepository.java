package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.MedicoPersonal;

@Repository
public interface MedicoPersonalRepository extends JpaRepository<MedicoPersonal, String>{

    @Query(value = "SELECT * FROM medicospersonal", nativeQuery = true)
    Collection<MedicoPersonal> darMedicosPersonal();

    @Query(value = "SELECT * FROM medicospersonal WHERE registroMedico = :registroMedico", nativeQuery = true)
    MedicoPersonal darMedicoPersonal(@Param("registroMedico") String registroMedico);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO medicospersonal (registroMedico, tipoDoc, numDoc, nombre) VALUES (:registroMedico, :tipoDoc, :numDoc, :nombre)", nativeQuery = true)
    void insertarMedicoPersonal(@Param("registroMedico") String registroMedico, @Param("tipoDoc") String tipoDoc, @Param("numDoc") Integer numDoc, @Param("nombre") String nombre);

    @Modifying
    @Transactional
    @Query(value = "UPDATE medicospersonal SET tipoDoc = :tipoDoc, numDoc = :numDoc, nombre = :nombre WHERE registroMedico = :registroMedico", nativeQuery = true)
    void actualizarMedicoPersonal(@Param("registroMedico") String registroMedico, @Param("tipoDoc") String tipoDoc, @Param("numDoc") Integer numDoc, @Param("nombre") String nombre);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM medicospersonal WHERE registroMedico = :registroMedico", nativeQuery = true)
    void eliminarMedicoPersonal(@Param("registroMedico") String registroMedico);
}
