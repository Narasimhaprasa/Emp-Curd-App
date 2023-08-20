 <%@page isELIgnored="false" %>
 <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 
 <c:choose>
   <c:when test="${!empty empsData}">
   <table border="1" bgcolor="cyan" align="center">
   <tr>
   <th>EmpNo</th>
   <th>EmpName</th>
   <th>Job</th>
   <th>Salary</th>
   <th>Opertions</th>
   </tr>
   
   <c:forEach var="emp" items="${empsData}">
   <tr>
    <td>${emp.empno}</td>
    <td>${emp.ename}</td>
    <td>${emp.job}</td>
    <td>${emp.sal }</td>
    <td> <a href="edit?no=${emp.empno}"><img src="images/edit.jpg" width="60" height="50"/></a>&nbsp;&nbsp;&nbsp; <a href="delete?no=${emp.empno}" onclick="return confirm('Do you want to delete?')"><img src="images/delete.jpg" width="60" height="60"/></a> </td>
   </tr>
   </c:forEach>
   </table>
   </c:when>
   <c:otherwise>
     <h1 style="red;text-align:center">Records Not Found</h1>
   </c:otherwise>
 </c:choose>
 <br><br>
 <hr>
 <h1 style="text-align:center"> <a href="add" ><img src="images/register.jpg" width="70" height="70"> AddEmployee </a></h1>
 
 <c:if test="${!empty resultMsg}">
  <h3 style="color:green;text-align:center">${resultMsg }</h3>
 </c:if>