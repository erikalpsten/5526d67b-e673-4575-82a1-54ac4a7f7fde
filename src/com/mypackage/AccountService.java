package com.mypackage;  

import java.util.List;

import javax.crypto.spec.SecretKeySpec;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.xml.bind.DatatypeConverter;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import java.security.Key;
import java.security.SignatureException;

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
    public Account getAccount(@PathParam("accountID") String accountID, @HeaderParam("Token") String token) throws SignatureException {
	    byte[] apiKeySecretBytes = DatatypeConverter.parseBase64Binary("Example key, should be replaced");
	    Key key = new SecretKeySpec(apiKeySecretBytes, SignatureAlgorithm.HS512.getJcaName());
		
	    	Jws<Claims> claims = Jwts.parser()
	    	.setSigningKey(key)
	    	.parseClaimsJws(token);
	    	
	    	String access = (String) claims.getBody().get("access");
	    if (access.equals("yes")){
	    	// access granted - return proper account
	    	Account acc = AccountServer.getAccount(accountID);
	    	return acc;
	    } else {
	    	// access denied - return no content. Ought to be changed to http response 403
	    	return null;
	    }
   }
}