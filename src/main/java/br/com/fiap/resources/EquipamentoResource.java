package br.com.fiap.resources;

import br.com.fiap.domain.equipamento.model.Equipamento;
import br.com.fiap.domain.equipamento.repository.EquipamentoRepository;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/equipamento")
public class EquipamentoResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<?> findAll() {
        return EquipamentoRepository.findAll();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public Response findById(@PathParam("id") Long id) {
        Equipamento e = EquipamentoRepository.findById(id);
        if (e != null) {
            Response.ResponseBuilder res = Response.ok();
            res.entity(e);
            return res.build();
        }else{
            Response.ResponseBuilder res = Response.status(404);
            return res.build();
        }
    }

}
