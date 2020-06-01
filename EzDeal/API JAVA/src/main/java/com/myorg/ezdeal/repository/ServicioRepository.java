package com.myorg.ezdeal.repository;

import com.myorg.ezdeal.models.Servicio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ServicioRepository extends JpaRepository<Servicio, Long> {


    @Query("SELECT s FROM Servicio s order by s.fechaPublicacion desc")
    List<Servicio> listarServicios() throws Exception;

    @Query(
            value = "select * from servicio " +
                    "join usuario on servicio.anunciante_id = usuario.anunciante_id " +
                    "join anunciante on anunciante.anunciante_id = usuario.anunciante_id " +
                    "join membresia on membresia.membresia_id = anunciante.membresia_id " +
                    "order by case when membresia.nombre = 'Gold' then '1' " +
                    "when membresia.nombre = 'Free' then '2' else membresia.nombre end ",
            nativeQuery = true
    )
    List<Servicio> listarOrdenandoPorMembresia() throws Exception;

    @Query(
            value = "select * from servicio " +
                    "join usuario on servicio.anunciante_id = usuario.anunciante_id " +
                    "join anunciante on anunciante.anunciante_id = usuario.anunciante_id " +
                    "join membresia on membresia.membresia_id = anunciante.membresia_id " +
                    "where servicio.titulo like :keyword " +
                    "order by case when membresia.nombre = 'Gold' then '1' " +
                    "when membresia.nombre = 'Free' then '2' else membresia.nombre end ",
            nativeQuery = true
    )
    List<Servicio>listarServiciosPorTitulo(@Param("keyword") String keyword) throws Exception;

    @Query("SELECT s FROM Servicio s JOIN Usuario u ON s.anunciante.id = u.id " +
            "JOIN Anunciante a ON a.id = u.infoAnunciante.id JOIN Membresia m ON " +
            "m.id = a.membresia.id where  m.id = ?1")
    List<Servicio> listarPorMembresia(Long membresiaId) throws Exception;

    @Query("SELECT s FROM Servicio s JOIN Usuario u ON u.id = s.anunciante.id WHERE u.id = ?1")
    List<Servicio> listarPorAnunciante(Long anuncianteId) throws Exception;

    List<Servicio> findByTituloLike(String titulo) throws Exception;



}
