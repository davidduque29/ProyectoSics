<%-- 
    Document   : sustentacion
    Created on : 14-abr-2017, 19:25:06
    Author     : ivandavid
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Sustentacion</title>
        <!-- LINKS -->
        <%@include file="../template/jsp/linksustenta.jsp" %>    
    </head>
    <body>
        <!--header - Menu -->
        <%@include file="../template/jsp/header.jsp" %>
        <!--banner - logo-->
        <%@include file="../template/jsp/sectionbanner.jsp" %>  
        <!--contenido-->
        <hr>
        <section class="row">       
            <div class="col-sx-12 col-sm-12 col-md-12 col-lg-12">	
                <div class="row destacados">
                    <div class="col-sx-2 col-sm-2 col-md-2 col-lg-2">
                    </div>

                    <div class="col-sx-2 col-sm-2 col-md-2 col-lg-2">
                        <div>
                            <a class="stroke" href="fase2.jsp">
                                <img src="../resources/imgs/materias/2.jpg" alt="Ingeniería de Software" class="img-circle img-thumbnail">
                            </a>
                        </div>
                    </div>
                    <div class="col-sx-2 col-sm-2 col-md-2 col-lg-2">
                        <div>
                            <a class="stroke" href="fase3.jsp">
                                <img src="../resources/imgs/materias/3.jpg" alt="Ingeniería de Software" class="img-circle img-thumbnail">
                            </a>
                        </div>
                    </div>

                    <div class="col-sx-2 col-sm-2 col-md-2 col-lg-2">
                        <div>
                            <a class="stroke" href="fase4a.jsp">
                                <img src="../resources/imgs/materias/4a.jpg" alt="Ingeniería de Software" class="img-circle img-thumbnail">
                            </a>
                        </div>
                    </div>

                    <div class="col-sx-2 col-sm-2 col-md-2 col-lg-2">
                        <div>
                            <a class="stroke" href="fase4b.jsp">
                                <img src="../resources/imgs/materias/4b.jpg" alt="Ingeniería de Software" class="img-circle img-thumbnail">
                            </a>
                        </div>
                    </div>

                    <div class="col-sx-2 col-sm-2 col-md-2 col-lg-2">
                        <div>
                            <a class="stroke" href="#vacio" id="#vacio">
                                <img src="../resources/imgs/materias/5.jpg" alt="Ingeniería de Software" class="img-circle img-thumbnail">
                            </a>
                        </div>
                    </div>
                </div>
            </div>                                 
        </section>
        <hr>
        <!--footer - pie de pagina-->
        <%@include file="../template/jsp/footer.jsp" %>
    </body>
</html>
