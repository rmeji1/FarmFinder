
package com.farmfinder.services;

import java.io.IOException;
import java.util.ArrayList;

import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.data.annotation.Id;

import com.farmfinder.model.* ;
import com.farmfinder.commands.MetadataRepo ;
import com.farmfinder.metadata.Metadata ;
import java.lang.reflect.Field ;

@Path("/metadata")
public class MetadataService {
	ObjectMapper mapper = new ObjectMapper();
	
	
	@PUT
	@Path("/create/farm/metadata")
	@Produces(MediaType.APPLICATION_JSON)
	public Response createFarmMetadata(){
		/*@Id private String id ;
			private String name ;
			private String pass ;
			private String street ;
			private String city ;
			private String state ;
			private String zip ;
			private String phoneNum ;
			private String email ;
			private ArrayList<Product> product ; */
		
		Metadata meta = new Metadata(Farm.class) ;

		
		
	}
	
	@GET
	@Path("/farm")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getFarmMetadata() {
		Farm farm = new Farm();
		String farmJSON;
		try {
			/*returns json object of a book */
			farmJSON = mapper.writeValueAsString(farm);
			return Response.status(200).entity(farmJSON).build();
		} catch (JsonGenerationException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return Response.status(500).build();
	}

	@GET
	@Path("/categories")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getCategoryMetadata() {
		Category cat = new Category();
		String catJSON;
		try {
			/*returns json object of a book */
			catJSON = mapper.writeValueAsString(cat);
			return Response.status(200).entity(catJSON).build();
		} catch (JsonGenerationException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return Response.status(500).build();
	}
	
	@GET
	@Path("/product")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getProductMetadata() {
		Product prd = new Product();
		String prdJSON;
		try {
			/*returns json object of a book */
			prdJSON = mapper.writeValueAsString(prd);
			return Response.status(200).entity(prdJSON).build();
		} catch (JsonGenerationException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return Response.status(500).build();
	}
}


