package fr.pizzeria.admin.metier;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import fr.pizzeria.model.Client;


@Path("/clients")
public class ClientResource {
	@Inject
	private ClientServiceEJB c;
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Client> findAllClients(){
		return c.findAllClients();		
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public void saveNewClient(Client client) {
		 c.saveNewClient(client);
	}
	
	@PUT
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public boolean updateClient(@PathParam("id") int code, Client client) {
		return c.updateClient(code, client);		
	}
	
	@DELETE
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public boolean deleteClient(@PathParam("id") int client) {
		return c.deleteClient(client);
	}


	public Client findClientById(int code) {
	
	    return c.findClientByID(code);
	}
	/*public boolean isCodeExist(String codePizza) {
		return pizzaJpa.isCodeExist(codePizza);

	}*/
}

