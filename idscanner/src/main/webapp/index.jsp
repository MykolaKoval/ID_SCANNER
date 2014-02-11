<%@ page import="com.google.inject.Injector"%>
<%@ page import="org.kdev.idscanner.service.PersonService"%>
<%@ page import="org.kdev.idscanner.domain.entity.Person"%>
<html>
  
  <head>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    <link type="text/css" rel="stylesheet" href="main.css">
    <title>ID Scanner</title>
  </head>

  <body>
    <%
      Injector inj = (Injector) pageContext.getServletContext().getAttribute(Injector.class.getName());
      PersonService personService = inj.getInstance(PersonService.class);
      Person person = personService.getPerson(request.getParameter("id"));
    %>

    <div style="position:relative; width:100%; height:100%; <%if(person.isDirector()){%>background-color:orange;<%}%>" >
      <div class="image-person">
        <img src="data:image/png;base64,<%=person.getImg()%>" height="100%"/>
      </div>
      <div class="text-person">
        <table>
          <tr>
            <td><b>Country:</b> </td><td><%=person.getCountry()%></td>
          </tr>
          <tr>
            <td><b>Name:</b> </td><td><%=person.getName()%> <%=person.getSurname()%></td>
          </tr>
        </table>
      </div>
    </div>
  </body>
  
</html>