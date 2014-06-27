package com.farmfinder.services;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import javax.management.relation.RoleInfo;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.management.relation.Role;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import com.farmfinder.commands.CategoryRepo;
import com.farmfinder.commands.ProductRepo;
import com.farmfinder.config.MongoConfig;
import com.farmfinder.commands.FarmRepo ;
import com.farmfinder.model.* ;

@Path("/farmfinder")
public class FarmFinder {
	ObjectMapper mapper = new ObjectMapper();
	
	@POST
	@Path("/createFarm")
	@Produces(MediaType.APPLICATION_JSON)
	public Response createFarm(){
		ApplicationContext ctx = new AnnotationConfigApplicationContext(MongoConfig.class);
		CategoryRepo repo = (CategoryRepo) ctx.getBean(CategoryRepo.class) ;
		/*Create new category class*/ 
		Category cat = new Category() ;
		cat.setName("Strawberry") ;		
		repo.save(cat) ;
		return Response.status(201).entity(cat).build() ;
	}
	
	/*
	 * url: rest/farmfinder/farm -X POST
	 * Goal: Get json and create a new farm
	 */
	@POST
	@Path("/farm")
	@Produces(MediaType.APPLICATION_JSON)
	public Response createFarm(String jsonData){
		/*Get repo to be used later to save the farm*/
		ApplicationContext ctx = new AnnotationConfigApplicationContext(MongoConfig.class) ;
		FarmRepo repo = (FarmRepo) ctx.getBean(FarmRepo.class) ;
		/*Uses ObjectMapper to convert jsonData to Farm Object*/
		Farm farm;
		try {
			System.out.println(jsonData) ;
			farm = mapper.readValue(jsonData, Farm.class);
			HashMap<String,String> roles = new HashMap() ;
			roles.put("name", "user") ;
			farm.setRoles(roles);
			repo.save(farm) ;
			return Response.status(201).entity(farm).build();
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return Response.status(500).entity(jsonData).build() ; 
	}


	/*---------------------------------------------------
	 *  url: rest/farmfinder/farm -X GET
	 *  Get all of the farms stored in database
	 */
	@GET
	@Path("/farm")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllFarms(){
		/*Get repo to be used later to save the farm*/
		ApplicationContext ctx = new AnnotationConfigApplicationContext(MongoConfig.class) ;
		FarmRepo repo = (FarmRepo) ctx.getBean(FarmRepo.class) ;
		List<Farm> farms = repo.findAll() ;
		return Response.status(200).entity(farms).build();
	}
	
	/*---------------------------------------------------
	 *  url: rest/farmfinder/farm/page/{num} -X GET
	 *  Get a group of 10 farms specifying by page number
	 */
	@GET
	@Path("/farm/page/{page}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getFarmByPage(@PathParam("page") int page){
		/*Get repo to be used later to save the farm*/
		ApplicationContext ctx = new AnnotationConfigApplicationContext(MongoConfig.class) ;
		FarmRepo repo = (FarmRepo) ctx.getBean(FarmRepo.class) ;
		Page<Farm> farms = repo.findAll( new PageRequest(page, 10)) ;
		return Response.status(200).entity(farms).build();
	}
	
	/*---------------------------------------------------
	 *  url: rest/farmfinder/farm/{state} -X GET
	 *  Get farms by state
	 */
	@GET
	@Path("/farm/{state}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getFarmByState(@PathParam("state") String state){
		/*Get repo to be used later to save the farm*/
		ApplicationContext ctx = new AnnotationConfigApplicationContext(MongoConfig.class) ;
		FarmRepo repo = (FarmRepo) ctx.getBean(FarmRepo.class) ;
		List<Farm> farms = repo.findByState(state) ;
		return Response.status(200).entity(farms).build();
	}
	
	/*---------------------------------------------------
	 *  url: rest/farmfinder/product
	 *  Get farms by state
	 */
	@POST
	@Path("/product")
	@Produces(MediaType.APPLICATION_JSON)
	public Response createProduct(String data){
		/*Get repo to be used later to save the farm*/
		ApplicationContext ctx = new AnnotationConfigApplicationContext(MongoConfig.class) ;
		ProductRepo repo = (ProductRepo) ctx.getBean(ProductRepo.class) ;
		Product product = null ;
		try {
			System.out.println(data) ;
			product = mapper.readValue(data, Product.class);
			repo.save(product) ;
			return Response.status(201).entity(product).build();
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return Response.status(500).entity(data).build() ;
	}
}







