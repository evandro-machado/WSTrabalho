/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package recursos;

import classes.Cliente;
import classes.Genero;
import classes.ListaGeneros;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.PathParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import static javax.ws.rs.HttpMethod.POST;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author Evandro
 */

@Path("generic")
public class GenericResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of GenericResource
     */
    public GenericResource() {
    }

    /**
     * Retrieves representation of an instance of recursos.GenericResource
     * @return an instance of java.lang.String
     */
//@Path("/{id}")  publicStringgetJson(@PathParam("id") String id) {
    @Path("/{escolha}")
    @GET
    @Produces("application/json")
    public ListaGeneros getJson(Cliente cliente) {
        
        //TODO return proper representation object
        List<Genero> listaGenero = new ArrayList();
        Genero genero = new Genero();
        genero.setIdGenero(1);
        genero.setNome("Teste1!");
        listaGenero.add(genero);
        genero = new Genero();
        genero.setIdGenero(2);
        genero.setNome("Teste2!");
        listaGenero.add(genero);
        genero.setIdGenero(3);
        genero = new Genero();
        genero.setNome("Teste3!");
        listaGenero.add(genero);
        ListaGeneros generoLista = new ListaGeneros();
        generoLista.setListaGeneros(listaGenero);
        return generoLista;
        
    }

    /**
     * PUT method for updating or creating an instance of GenericResource
     * @param content representation for the resource
     * @return an HTTP response with content of the updated or created resource.
     */
    @PUT
    @Consumes("application/json")
    public void putJson(String content) {
    }
    @POST
    @Consumes("application/json")
    @Produces("application/json")
    public void putJson(Cliente cliente) throws ClassNotFoundException {
        ClienteDAO clienteDAO = new ClienteDAO();
        clienteDAO.cadastrarCliente(cliente);
    }
}
