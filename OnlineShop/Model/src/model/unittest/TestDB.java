package model.unittest;

import java.util.ArrayList;
import java.util.List;

import model.CustomerDO;
import model.DataAccess;
import model.EmployeeDO;
import model.JobDO;
import model.ProductDO;

public class TestDB {
    public TestDB() {
        super();
    }

    public static void main(String[] args) {
        DataAccess da = new DataAccess();
        
        
        
        List<EmployeeDO> myTestList =  da.getEmployees(); 
        for(EmployeeDO edo : myTestList){
            System.out.println(edo.getFirst_name());
        }
        
        
        List<CustomerDO> myTestList2 =  da.getCustomers(); 
        for(CustomerDO cdo : myTestList2){
            System.out.println(cdo.getName());
        }
        
        
        List<ProductDO> myTestList3 =  da.getProducts(); 
        for(ProductDO pdo : myTestList3){
            System.out.println(pdo.getDescription());
        }
        
        
        List<JobDO> myTestList4 =  da.getJobs(); 
        for(JobDO jdo : myTestList4){
            System.out.println(jdo.getFunction());
        }
            
            
        System.out.println("*********************************************");    
        System.out.println("Should be 6 records."); 
        List<EmployeeDO> myTestList5 =  da.getEmployees(13, 19); 
        for(EmployeeDO edo : myTestList5){
            System.out.println(edo.getFirst_name());
        }
            
        String userName = "Krisztina";
        String password = "Bogyo";
        
        
       // String sql = "INSERT INTO MYUSERS (User_Name, Password) VALUES ('"  + userName  + "', '" + password + "')";
        //String longString = "Select user_name, password from RepCustOrder.Myusers where user_name = '" + userName +"' and password = '" + password +"'";
        da.signUp(userName, password)   ;
            
            
    }
}
