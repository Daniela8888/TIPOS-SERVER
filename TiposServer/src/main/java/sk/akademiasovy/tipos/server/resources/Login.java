package sk.akademiasovy.tipos.server.resources;




import javax.print.attribute.standard.Media;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.awt.*;

import org.eclipse.jetty.server.Authentication;
import sk.akademiasovy.tipos.server.Credentials;
import sk.akademiasovy.tipos.server.User;
import sk.akademiasovy.tipos.server.db.MySQL;

@Path("/auth")
public class Login {
    @POST
    @Path("/login")
    @Produces(MediaType.APPLICATION_JSON)
    public String checkCredentials(Credentials credential){
        System.out.println(credential);
        MySQL mySQL=new MySQL();
        User user=mySQL.getUser(credential.username,credential.password);
        return "{\"token\":\"abc\"}";

    }
}
