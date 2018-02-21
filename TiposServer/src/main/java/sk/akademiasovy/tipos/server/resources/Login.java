package sk.akademiasovy.tipos.server.resources;




import javax.print.attribute.standard.Media;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import sk.akademiasovy.tipos.server.Credentials;
import sk.akademiasovy.tipos.server.User;
import sk.akademiasovy.tipos.server.db.MySQL;

@Path("/auth")
public class Login {
    @POST
    @Path("/login")
    @Produces(MediaType.APPLICATION_JSON)
    public String checkCredentials(Credentials credential) {
        System.out.println(credential.getUsername());
        MySQL mySQL = new MySQL();
        User user = mySQL.getUser(credential.username, credential.password);
        if (user == null) {
            return "{}";
        } else {
            String result;
            result = "{\"firstname\":\"" + user.getFirstname() + "\" , ";
            result = "\"lastname\":\"" + user.getLastname() + "\" , ";
            result = "\"email\":\"" + user.getEmail() + "\" , ";
            result = "\"login\":\"" + user.getLogin() + "\" , ";
            result = "\"token\":\"" + user.getToken() + "\"}";
            return result;
        }

    }

    @GET
    @Path("/logout")
    @Produces(MediaType.APPLICATION_JSON)
    public String logout (@PathParam("token") String token, @PathParam("token") String login) {
        MySQL mySQL= new MySQL();
        mySQL.logout(token);
        return "{}";
    }
}
