package com.mypackage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class clientAccountDisplay {
	
	private static void sendGet(String ip, String port, String accountID) throws Exception{
		
		String urlString = "http://" + ip + ":" + port + "/UserManagement/rest/AccountService/accounts/" + accountID;
		URL url = new URL(urlString);
		
		HttpURLConnection con = (HttpURLConnection) url.openConnection();
		con.setRequestMethod("GET");
		con.setRequestProperty("Accept", "application/json");
		
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
			sendGet(args[1], args[3], args[5]);
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
}