package com.mycompany.clinica.ws.resources;

import com.mycompany.clinica.ws.model.EnderecoModel;
import com.mycompany.clinica.ws.model.EspecialidadeModel;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;

/**
 *
 * @author 
 */
@Path("jakartaee10")
public class JakartaEE10Resource {
    
    public Response ping(){
        
        return Response
                .ok("ping Jakarta EE")
                .build();
    }
}
