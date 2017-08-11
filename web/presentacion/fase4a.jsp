<%-- 
    Document   : fase4
    Created on : 27-jun-2017, 2:34:37
    Author     : ivandavid
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>fase4a</title>
        <!-- LINKS -->
        <%@include file="../template/jsp/linksustenta.jsp" %> 
    </head>
    <body>
        <!--header - Menu -->
        <%@include file="../template/jsp/header.jsp" %>
        <!--banner - logo-->
        <%@include file="../template/jsp/sectionbanner.jsp" %>  
        <!--contenido-->
        <!-- ******************** (  SECCION FASE 2 ) *********************** -->
        <section class="row container-fluid text-center">       
            <div class="col-sx-1 col-sm-1 col-md-1 col-lg-1">
                <a class="stroke back" href="sustentacion.jsp" style="text-decoration: none;">
                   ..<i class="fa fa-home" aria-hidden="true"></i>
                    <!--flecha: alt+27-->
                 </a>
            </div>
            <div class="col-sx-3 col-sm-3 col-md-3 col-lg-3"></div>
            <div class="col-sx-4 col-sm-4 col-md-4 col-lg-4">	
                <h1 class="stroke1">FASE 4a</h1>
            </div>
            <div class="col-sx-4 col-sm-4 col-md-4 col-lg-4"></div>

        </section>

        <!-- ******************** (  SECCION FASE 3 ) *********************** -->

        <section class="row">       
            <div class="col-sx-12 col-sm-12 col-md-12 col-lg-12">	
                <hr>
                <div class="container">
                    <div class="row destacados">
                        <div class="col-sx-4 col-sm-4 col-md-4 col-lg-4">
                            <div>
                                <img src="../resources/imgs/materias/mysql.jpg" alt="Ingeniería de Software" class="img-circle img-thumbnail">
                                <h2 class="stroke_materias">Base de Datos</h2>
                                <div class="text-header-sm">
                                <ul>
                                    <li><a class="stroke" href="">Consultas</a></li><br>
                                </ul>							
                                </div>
                            </div>
                        </div>

                        <div class="col-sx-4 col-sm-4 col-md-4 col-lg-4">
                            <div>
                                <img src="../resources/imgs/materias/emprender.jpg" alt="Diseño Web" class="img-circle img-thumbnail">
                                <h2 class="stroke_materias">Emprendimiento</h2>
                                <div class="text-header-sm">
                                <ul>
                                    <li><a class="stroke" href="">Actividad Emprendimiento</a></li>
                                </ul>							
                                </div>
                            </div>
                        </div>

                        <div class="col-sx-4 col-sm-4 col-md-4 col-lg-4">
                            <div>

                            </div>
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
