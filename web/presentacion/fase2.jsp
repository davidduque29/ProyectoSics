<%-- 
    Document   : fase2
    Created on : 14-abr-2017, 19:32:58
    Author     : ivandavid
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Fase2</title>
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
                <h1 class="stroke1">FASE 2</h1>
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
                                <img src="../resources/imgs/materias/ing_soft.jpg" alt="Ingeniería de Software" class="img-circle img-thumbnail">
                                <h2 class="stroke_materias">Ingenieria Software</h2>
                                <div class="text-header-sm">
                                <ul class="text-center">
                                    <li><a class="stroke" href="fs_ing_diagramas.jsp">Diagramas</a></li>
                                </ul>							
                                </div>
                            </div>
                        </div>

                        <div class="col-sx-4 col-sm-4 col-md-4 col-lg-4">
                            <div>
                                <img src="../resources/imgs/materias/comunicaciones.jpg" alt="Comunicaciones" class="img-circle img-thumbnail">
                                <h2 class="stroke_materias">Comunicaciones</h2>
                                <div class="text-header-sm">
                                <ul class="text-center">
                                    <li><a class="stroke" href="fs_com_.jsp">Proyecto SICS</a></li>
                                    <li><a class="stroke" href="fs_com_ieee.jsp">Doc IEEE</a></li>
                                    <li><a class="stroke" href="fs_com_analisis.jsp">Doc An&aacute;lisis</a></li>
                                </ul>							
                                </div>
                            </div>
                        </div>

                        <div class="col-sx-4 col-sm-4 col-md-4 col-lg-4">
                            <div>
                                <img src="../resources/imgs/materias/web.jpg" alt="Diseño Web" class="img-circle img-thumbnail">
                                <h2 class="stroke_materias">Dise&ntilde;o Web</h2>
                                <div class="text-header-sm">
                                <ul class="text-center">
                                    <li><a class="stroke" href="fs_dw_logo.jsp">Logotipo</a></li>
                                    <li><a class="stroke" href="fs_dw_mockups.jsp">Wireframe</a></li>
                                    <li><a class="stroke" href="fs_dw_manual.jsp">Manual imagen</a></li>
                                    <li><a class="stroke" href="fs_dw_pag_error.jsp">P&aacute;ginas error</a></li>	
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
                                    <li><a class="stroke" href="fs_eng_use_case.jsp">Use case</a></li>
                                </ul>
                                </div>
                                    </div>
                                    </div>

                                    <div class="col-sx-4 col-sm-4 col-md-4 col-lg-4">
                                        <div>
                                            <img src="../resources/imgs/materias/emprender.jpg" alt="emprendimiento" class="img-circle img-thumbnail">
                                            <h2 class="stroke_materias">Emprendimiento</h2>
                                            <p class="text-header-sm">
                                            <ul class="text-center">
                                                <li><a class="stroke" href="fs_emp_costos.jsp">Costos</a></li>
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
