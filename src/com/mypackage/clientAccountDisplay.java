package com.mypackage;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import java.security.Key;
import javax.crypto.spec.SecretKeySpec;


import javax.xml.bind.DatatypeConverter;

public class clientAccountDisplay {
	
	private static void sendGet(String ip, String port, String accountID) throws Exception{
		
	    //We will sign our JWT with our ApiKey secret
	    byte[] apiKeySecretBytes = DatatypeConverter.parseBase64Binary("Example key, should be replaced");
	    Key key = new SecretKeySpec(apiKeySecretBytes, SignatureAlgorithm.HS512.getJcaName());

		String compactJws = Jwts.builder()
		  .setSubject("Token Verification")
		  .claim("access", "yes")					// should be stated somewhere else
		  .signWith(SignatureAlgorithm.HS512, key)
		  .compact();
		
		// test print jwt
		System.out.println(compactJws);
		
		String urlString = "http://" + ip + ":" + port + "/UserManagement/rest/AccountService/accounts/" + accountID;
		//String urlString = "http://localhost:8080/UserManagement/rest/AccountService/accounts/11111";
		URL url = new URL(urlString);
		
		HttpURLConnection con = (HttpURLConnection) url.openConnection();
		con.setRequestMethod("GET");
		con.setRequestProperty("Accept", "application/json");
		con.setRequestProperty("Token", compactJws);
		
		int responeCode = con.getResponseCode();

        System.out.println("\nSending 'GET' request to URL : " + url);
        System.out.println("Response Code : " + responeCode);
        
		BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));
		
		String out;
		while ((out = br.readLine()) != null){
			System.out.println(out);
		}
		
		con.disconnect();
	}
	
	public static void main(String[] args) {
		try{
			sendGet("localhost","8080","11111");			
			sendGet("localhost","8080","12345");
			//sendGet(args[1], args[3], args[5]);
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
}
