 <%@page isELIgnored="false" %>
 <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
 <h1 style="color:red;text-align:center">Register Employee</h1>
 <form:form modelAttribute="emp">
 <table border="1" bgcolor="cyan" align="center">
 <tr>
 <td>Employee Name::</td>
 <td><form:input path="ename"/></td>
 </tr>
 
 <tr>
 <td>Employee desg::</td>
 <td><form:input path="job"/></td>
 </tr>
 
 <tr>
 <td>Employee salary::</td>
 <td><form:input path="sal"/></td>
 </tr>
 <tr>
 <td colspan="2" align="center"><input type="submit" value="register Employee"/></td>
 </tr>
 </table>
 
 </form:form>