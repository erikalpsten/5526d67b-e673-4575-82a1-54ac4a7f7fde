package com.mypackage;  

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List; 
import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlElement; 
import javax.xml.bind.annotation.XmlRootElement; 

@XmlRootElement (name = "account")
public class Account implements Serializable { 
   private static final long serialVersionUID = 1L;

   /* unique id of the account */
   public String accountID;

   /* present value of the account in the given currency */
    public BigDecimal accountValue;   
   
   /* currency abbreviation, such as USD, HKD, SGD */
    public String currency;

   /* true if account is active, false if under review */
    public boolean isAccountActive;

   /* list of the people that own the account */
    public List<String> accountOwnersNames; 
   
   /* Assets held in the account */
    public List<Asset> holdings;
   
    public Account(){} 
    
    public Account(String accountID, BigDecimal accountValue, String currency, boolean isAccountActive, ArrayList<String> accountOwnersNames, ArrayList<Asset> holdings) {
        this.accountID = accountID;
        this.accountValue = accountValue;
        this.currency = currency;
        this.isAccountActive = isAccountActive;
        this.accountOwnersNames = accountOwnersNames;
        this.holdings = holdings;
    }
   
    public String getAccountID() { 
        return accountID; 
    }  
    @XmlElement 
    public void setAccountID(String ID) { 
    	this.accountID = ID; 
    } 
    public BigDecimal getAccountValue(){
    	return accountValue;
    }
    @XmlElement
    public void setAccountValue(BigDecimal accountValue){
    	this.accountValue = accountValue;
    }
    public String getCurrency() { 
    	return currency; 
    } 
    @XmlElement
    public void setCurrency(String currency) { 
    	this.currency = currency; 
    }
    public boolean getIsAccountActive(){
    	return isAccountActive;
    }
    @XmlElement 
    public void setIsAccountActive(boolean isAccountActive){
    	this.isAccountActive = isAccountActive;
    }
    public List<String> getAccountOwnersNames(){
    	return accountOwnersNames;
    }
    @XmlElement
    public void setaccountOwnersNames(List<String> accountOwnersNames){
    	this.accountOwnersNames = accountOwnersNames;
    }
    public List<Asset> getHoldings() {
    	return holdings;
    }
    @XmlElement
    public void setHoldings(List<Asset> holdings){
    	this.holdings = holdings;
    }
}	 