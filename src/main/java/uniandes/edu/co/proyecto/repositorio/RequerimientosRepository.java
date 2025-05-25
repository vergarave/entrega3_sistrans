package uniandes.edu.co.proyecto.repositorio;

import java.util.Date;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class RequerimientosRepository {

    @Autowired
    private MongoTemplate mongoTemplate;

    public List<Document> consultarAgendaRFC1(String codigoServicio) {
        Date ahora = new Date();
        Date enCuatroSemanas = new Date(ahora.getTime() + 1000L * 60 * 60 * 24 * 28); // 4 semanas

        List<Document> pipeline = Arrays.asList(
            new Document("$match", new Document("disponible", true)
                .append("fecha", new Document("$gte", ahora).append("$lte", enCuatroSemanas))
                .append("servicio", codigoServicio)),

            new Document("$lookup", new Document()
                .append("from", "servicios")  // nombre de la colección de servicios
                .append("localField", "servicio")
                .append("foreignField", "_id")
                .append("as", "servicio_info")),

            new Document("$unwind", "$servicio_info"),

            new Document("$lookup", new Document()
                .append("from", "medicos")
                .append("localField", "medico")
                .append("foreignField", "_id")
                .append("as", "medico_info")),

            new Document("$unwind", "$medico_info"),

            new Document("$lookup", new Document()
                .append("from", "ips")
                .append("localField", "ips")
                .append("foreignField", "_id")
                .append("as", "ips_info")),

            new Document("$unwind", "$ips_info"),

            new Document("$project", new Document("fecha", 1)
                .append("hora", 1)
                .append("servicio", "$servicio_info.nombre")
                .append("medico", "$medico_info.nombre")
                .append("ips", "$ips_info.nombre"))
        );

        return mongoTemplate.getCollection("agendamiento").aggregate(pipeline).into(new ArrayList<>());
    }

    public List<Document> consultarServiciosMasSolicitadosRFC2(Date fechaInicio, Date fechaFin) {
        List<Document> pipeline = Arrays.asList(
            new Document("$match", new Document("fecha", new Document("$gte", fechaInicio).append("$lte", fechaFin))),

            new Document("$group", new Document("_id", "$servicio")
                .append("cantidad", new Document("$sum", 1))),

            new Document("$sort", new Document("cantidad", -1)),

            new Document("$limit", 20),

            new Document("$lookup", new Document()
                .append("from", "servicios")
                .append("localField", "_id")
                .append("foreignField", "_id")
                .append("as", "servicio_info")),

            new Document("$unwind", "$servicio_info"),

            new Document("$project", new Document("codigo", "$_id")
                .append("nombre", "$servicio_info.nombre")
                .append("cantidad", 1))
        );

        return mongoTemplate.getCollection("agendamiento").aggregate(pipeline).into(new ArrayList<>());
    }

}
