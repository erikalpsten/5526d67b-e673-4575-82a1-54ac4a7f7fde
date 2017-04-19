package com.mypackage;  

import java.util.List; 
import javax.ws.rs.GET; 
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces; 
@Path("/AccountService") 

public class AccountService {  
   AccountServer accServer = new AccountServer();  
   @GET 
   @Path("/accounts") 
   @Produces("application/json") 
   public List<Account> getAccounts(){ 
      return accServer.getAllAccounts(); 
   }  
   
   @GET
   @Path("/accounts/{accountID}")
   @Produces("application/json")
   public Account getAccount(@PathParam("accountID") String accountID){
	   return accServer.getAccount(accountID);
   }
}