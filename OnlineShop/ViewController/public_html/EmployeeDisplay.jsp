<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ page contentType="text/html;charset=windows-1252"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ page import="model.* , java.util.*"%>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=windows-1252"/>
    <title>EmployeeDisplay02</title>
  </head>
  <body>
    <%   DataAccess da = new DataAccess();
        List<EmployeeDO> employees = da.getEmployees(); %>
    <table border="1"  bgcolor="Red" >
      <tr>
        <th>Employee_id</th>
        <th>Last_name</th> 
        <th>First_name</th>
      </tr>
       
      <%   for (EmployeeDO e : employees){ %>
       
      <tr>
        <td >
          <font color="White"> <%= e.getEmployee_ID() %> </font>
        </td>
        <td>
          <font color="White">  <%= e.getFirst_name() %> </font>
        </td>
        <td>
           <font color="White">  <%=  e.getLast_name()  %> </font>
        </td>
      </tr>
       
      <% } %>
    </table>
    
    
     <a href="Menu.html">Main menu</a>
  </body>
</html>