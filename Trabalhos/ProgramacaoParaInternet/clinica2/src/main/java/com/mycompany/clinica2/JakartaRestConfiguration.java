package com.mycompany.clinica2;

import com.mycompany.clinica2.model.EnderecoModel;
import jakarta.ws.rs.ApplicationPath;
import jakarta.ws.rs.core.Application;

/**
 * Configures Jakarta RESTful Web Services for the application.
 * @author Juneau
 */
@ApplicationPath("resources")
public class JakartaRestConfiguration extends Application {
    
    EnderecoModel endereco = new EnderecoModel();
    
    
}
