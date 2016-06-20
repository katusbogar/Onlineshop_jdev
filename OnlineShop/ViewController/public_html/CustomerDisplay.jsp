<!----------------------------------------------------------------------------------------------------------------------------------------------------------------
//customerdisplay.jps -->

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ page contentType="text/html;charset=windows-1252"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ page import="model.* , java.util.*"%>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=windows-1252"/>
    <title>CustomerDisplay</title>
  </head>
  <body>
    <%   DataAccess da = new DataAccess();
        List<CustomerDO> customer = da.getCustomers(); %>
    <table border="1"  bgcolor="Green" >
      <tr>
        <th>Customer ID</th>
        <th>Name</th> 
        <th>Address</th>
        <th>City</th>
      </tr>
       
      <%   for (CustomerDO c : customer){ %>
       
      <tr>
        <td >
          <font color="White"> <%= c.getCustomer_ID()%> </font>
        </td>
        <td>
          <font color="White">  <%= c.getName() %> </font>
        </td>
        <td>
           <font color="White">  <%= c.getAddress()%> </font>
        </td>
        
        <td>
           <font color="White">  <%= c.getCity()%> </font>
        </td>
      </tr>
        <% } %>
    </table>
    <a href="Menu.html">Main menu</a>
  </body>
</html>
       