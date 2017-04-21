package com.mypackage;  

import java.util.ArrayList; 
import java.util.List;  
import java.math.BigDecimal;

public class AccountServer { 
   public static List<Account> getAllAccounts(){ 
      
      List<Account> userList = new ArrayList<Account>(); 
      Account acc1 = new Account("12345", new BigDecimal(10), "USD", true, new ArrayList<String>(){{add("bob"); add("mr test");}}, new ArrayList<Asset>(){{add(new Asset("test1", new BigDecimal(100))); add(new Asset("test4", new BigDecimal(10.2)));}} );
      Account acc2 = new Account("11111", new BigDecimal(30), "SGD", true, new ArrayList<String>(){{add("john"); add("ms test");}}, new ArrayList<Asset>(){{add(new Asset("test2", new BigDecimal(101)));}} );
      userList.add(acc1); 
      userList.add(acc2);
            
      return userList; 
   }
   
   public static Account getAccount(String accountID){
	   List<Account> accounts = getAllAccounts();
	   for(Account acc : accounts){
		   if (acc.getAccountID().equals(accountID)){
			   return acc;
		   }
	   }
	   return null;
   }
}