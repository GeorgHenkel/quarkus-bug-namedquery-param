package org.acme;

import javax.ws.rs.BadRequestException;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/norms")
@Consumes(MediaType.APPLICATION_JSON)
public class NormResource
{
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Norm> listAll()
    {
        return Norm.listAll();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Norm createNorm(Norm norm)
    {
        if (Norm.findByTitle(norm.getTitle()).isPresent())
        {
            throw new BadRequestException("Norm with title [" + norm.getTitle() + " found.");
        }

        norm.persist();
        return norm;
    }
}
