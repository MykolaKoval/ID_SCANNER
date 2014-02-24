<%@ page import="com.google.inject.Injector"%>
<%@ page import="org.kdev.idscanner.service.PersonService"%>
<%@ page import="org.kdev.idscanner.domain.entity.Person"%>
<html>
  
  <head>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    <link type="text/css" rel="stylesheet" href="main.css">
    <title>ID Scanner</title>
    <script type="text/javascript" src="jquery.js"></script>
    <script type="text/javascript">
         $(window).load(function(){
			 $('#imgID').attr('height',$(window).height());
		 });
	</script>
  </head>

  <body>
    <%
      Injector injector = (Injector) pageContext.getServletContext().getAttribute(Injector.class.getName());
      PersonService personService = injector.getInstance(PersonService.class);
      Person person = personService.get(request.getParameter("id"));
    %>

    <div style="position:relative; width:100%; height:100%; <%if(person.isDirector()){%>background-color:orange;<%}%>" >
      <div class="image-person">
        <img id="imgID" src="data:image/png;base64,<%=person.getImg()%>" />
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