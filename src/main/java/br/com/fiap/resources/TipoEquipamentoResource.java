package br.com.fiap.resources;

import br.com.fiap.domain.equipamento.repository.TipoEquipamentoRepository;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/tipo-equipamento")
public class TipoEquipamentoResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAll(){
        return Response.ok(TipoEquipamentoRepository.findAll()).build();
    }

}
