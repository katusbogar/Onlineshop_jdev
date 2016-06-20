package model.unittest;

import model.DataAccess;

public class TestAuthentication {
    public TestAuthentication() {
        super();
    }

    public static void main(String[] args) {
        DataAccess da = new DataAccess();
        
        String userName = "Katalin";
        String password = "Bella3";
        
        boolean userExists = da.authenticate(userName, password);
        
       
        
        if(userExists){
            System.out.println("User exists in DB, you can log on.");
        }else{
            System.out.println("User does not exist in DB, you can not log on.");
        }
        
        
        userName = "Katalinka";
        password = "Bella8";
        
        
        userExists = da.authenticate(userName, password);
        
       
        
        if(userExists){
            System.out.println("User exists in DB, you can log on.");
        }else{
            System.out.println("User does not exist in DB, you can not log on.");
        }
        
        
    }
}
