<%-- 
    Document   : fase4b
    Created on : 27-jun-2017, 2:34:52
    Author     : ivandavid
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Fase4b</title>
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
                <h1 class="stroke1">FASE 4b</h1>
            </div>
            <div class="col-sx-4 col-sm-4 col-md-4 col-lg-4"></div>

        </section>

        <!-- ******************** (  SECCION FASE 2 ) *********************** -->

        <section class="row">       
            <div class="col-sx-12 col-sm-12 col-md-12 col-lg-12">	
                <hr>
                <div class="container">
                    <div class="row destacados">
                        <div class="col-sx-4 col-sm-4 col-md-4 col-lg-4">
                            <div>
                                <img src="../resources/imgs/materias/test.jpg" alt="Ingeniería de Software" class="img-circle img-thumbnail">
                                <h2 class="stroke_materias">Testing</h2>
                                <div class="text-header-sm">
                                <ul class="text-center">
                                    <li><a class="stroke" href="">Documentaci&oacute;n</a></li>
                                </ul>							
                                </div>
                            </div>
                        </div>

                        <div class="col-sx-4 col-sm-4 col-md-4 col-lg-4">
                            <div>
                                <img src="../resources/imgs/materias/comunicaciones.jpg" alt="Comunicaciones" class="img-circle img-thumbnail">
                                <h2 class="stroke_materias">Etica</h2>
                                <div class="text-header-sm">
                                <ul class="text-center">
                                    <li><a class="stroke" href="">Medios</a></li>                                    
                                </ul>							
                                </div>
                            </div>
                        </div>

                        <div class="col-sx-4 col-sm-4 col-md-4 col-lg-4">
                            <div>
                                <img src="../resources/imgs/materias/emprender.jpg" alt="Diseño Web" class="img-circle img-thumbnail">
                                <h2 class="stroke_materias">Emprendimiento</h2>
                                <div class="text-header-sm">
                                <ul class="text-center">
                                    <li><a class="stroke" href="fs_dw_logo.jsp">Logotipo</a></li>                                    	
                                </ul>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>

            </div>                                  
        </section>

        <!-- ::::::::::::::::: SEGUNDA FILA MATERIAS :::::::::::::::::::::::::::-->

        <section class="row">       
            <div class="col-sx-12 col-sm-12 col-md-12 col-lg-12">
                <hr>	
                <div class="container">
                    <div class="row destacados">
                        <div class="col-sx-4 col-sm-4 col-md-4 col-lg-4">
                            <div>
                                <img src="../resources/imgs/materias/ingles.jpg" alt="Ingles" class="img-circle img-thumbnail">
                                <h2 class="stroke_materias">Ingles</h2>
                                <div class="text-header-sm">
                                <ul class="text-center">
                                    <li><a class="stroke" href="">Voz pasiva</a></li>
                                </ul>
                                </div>
                                    </div>
                                    </div>

                                    <div class="col-sx-4 col-sm-4 col-md-4 col-lg-4">
                                        <div>
                                            <img src="../resources/imgs/materias/php.jpg" alt="emprendimiento" class="img-circle img-thumbnail">
                                            <h2 class="stroke_materias">PHP</h2>
                                            <p class="text-header-sm">
                                            <ul class="text-center">
                                                <li><a class="stroke" href="">PROYECTO</a></li>
                                            </ul>							
                                            </div>
                                        </div>
                     </div>
                     <div class="col-sx-4 col-sm-4 col-md-4 col-lg-4"> </div>
                    </div>
                </div>                             
        </section> 
        <!--footer - pie de pagina-->
    <%@include file="../template/jsp/footer.jsp" %>
    </body>
</html>
