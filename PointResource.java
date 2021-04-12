package org.acme.rest.json;

import java.security.SecureRandom;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Map.Entry;
import java.util.AbstractMap.SimpleEntry;


@Path("/")
public class PointResource {

    
    
    private List<Point> points = new ArrayList<Point>();
    //private List<encPoint> encpoints = new ArrayList<encPoint>();
	private HashMap<String,encPoint> tokenencPoint= new HashMap<String,encPoint>();

    
	
    public PointResource() {
     
    }
    
    @Path("/points")
    @GET
	@Produces(MediaType.APPLICATION_JSON)
    public Response listofpoint() {
    	encPoint enc = new encPoint();
    	enc.token = "sssssssssssss";  
    	//enc.setPoints(points);
    	//tok.add(enc);
    	tokenencPoint.get(enc.token);
    	tokenscore ts = new tokenscore();
    	ts.setSum(tokenencPoint.get(enc.token).sum());
    	ts.setToken(enc.token);
		return Response.ok(ts, MediaType.APPLICATION_JSON).build();	

    }
/*
    @GET
    @Path("/username/{username}")
    public Set<Country> name(@PathParam String name) {
        return countriesService.getByName(name);
    }
    */
    //@Produces(MediaType.APPLICATION_JSON)
    @Path("/points")
    @Consumes(MediaType.APPLICATION_JSON)
    @POST
    public void add(encPoint repoint) {

    	if(!tokenencPoint.containsKey(repoint.getToken()))
    		tokenencPoint.put(repoint.getToken(),repoint);
    	else {
        	encPoint recencpoint = tokenencPoint.get(repoint.getToken());
        	recencpoint.NumberofAttempt = recencpoint.NumberofAttempt + repoint.NumberofAttempt;
        	recencpoint.addPoint(repoint.getPoints());	
        	tokenencPoint.remove(repoint.getToken());
        	tokenencPoint.put(repoint.getToken(),recencpoint);
        	//recencpoint.setNumberofAttempt(repoint.getNumberofAttempt());
        	//recencpoint.setPoints(repoint.getPoints());
        	//recencpoint.setToken(repoint.getToken());
    	}
    	//points.addAll(repoint.getPoints());
    }
    
    