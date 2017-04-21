package com.mypackage;  

import java.util.List; 
import javax.ws.rs.GET; 
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.json.JSONObject;

import com.google.gson.Gson; 
@Path("/AccountService") 

public class AccountService {  
   @GET 
   @Path("/accounts") 
   @Produces("application/json") 
   public List<Account> getAccounts(){ 
      return AccountServer.getAllAccounts(); 
   }  
   
   @GET
   @Path("/accounts/{accountID}")
   @Produces("application/json")
   public Account getAccount(@PathParam("accountID") String accountID) throws Exception{
	   Account acc = AccountServer.getAccount(accountID);
	   Gson gson = new Gson();
	   
	   String jsonString = gson.toJson(acc);
	   JSONObject json = new JSONObject(jsonString);
	   
	   //System.out.println(json);
	   return acc;
   }
}