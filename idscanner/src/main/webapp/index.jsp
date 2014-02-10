<%@ page import="com.google.inject.Injector"%>
<%@ page import="org.kdev.idscanner.service.ImageResource"%>
<html>
  
  <head>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    <link type="text/css" rel="stylesheet" href="main.css">
    <title>ID Scanner</title>
  </head>

  <body>
    <%
      Injector inj = (Injector) pageContext.getServletContext().getAttribute(Injector.class.getName());
      ImageResource imgResource = inj.getInstance(ImageResource.class);
      String img = imgResource.getImage(request.getParameter("id"));
      boolean isCountryDirector = false; 
    %>

    <div style="position:relative; width:100%; height:100%; <%if(isCountryDirector){%>background-color:orange;<%}%>" >
      <div class="image-person">
        <img src="data:image/png;base64,<%=img%>" height="100%"/>
      </div>
      <div class="text-person">
        <table>
          <tr>
            <td><b>Country:</b> </td><td>Ukraine</td>
          </tr>
          <tr>
            <td><b>Name:</b> </td><td>Mykola Koval</td>
          </tr>
        </table>
      </div>
    </div>
  </body>
  
</html>