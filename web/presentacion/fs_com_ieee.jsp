<%-- 
    Document   : fs_com_ieee
    Created on : 16-jun-2017, 9:44:04
    Author     : ivandavid
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Fase2-Comunicacion-DocIEEE</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <!-- Metadatos -->
        <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
        <meta name="description" content="Sistema de Información">
        <meta name="keywords" content="html5, css3, diseño web">

        <!-- Estilos -->
        <link rel="shortcut icon" href="resources/imgs/Favicon/FAVICON_70X74-SICS9.png">
        <link rel="stylesheet" href="../resources/css/estilos1.css">
        <link rel="stylesheet" href="../resources/css/estilo_fase2.css">
        <link rel="stylesheet" href="../resources/css/fuentes.css">
        <link rel="stylesheet" href="../resources/css/toog.js.css">
        <link rel="stylesheet" href="../resources/css/bootstrap.min.css">
        <link rel="stylesheet" href="../resources/css/font-awesome.min.css">
    </head>
    <body>
        <!--header - Menu -->
        <%@include file="../template/jsp/header.jsp" %>
        <!--banner - logo-->
        <%@include file="../template/jsp/sectionbanner.jsp" %>  
        <!--contenido-->
        		<!-- ::::::::::    Fin CABEZOTE   ::::::::::: -->


        <!-- ******************** (  SECCION FASE 2 ) *********************** -->
        <section class="row container-fluid text-center fondo_mate">       
            <div class="col-sx-12 col-sm-12 col-md-12 col-lg-12">		

                <section class="row container-fluid text-center">       
                    <div class="col-sx-12 col-sm-12 col-md-12 col-lg-12 text-center">	
                        <h1 class="text-header-g">Documento IEEE 830</h1>
                    </div>
                </section>

                <section class="row">       
                    <div class="col-sx-3 col-sm-3 col-md-3 col-lg-3"></div>
                    <div class="col-sx-6 col-sm-6 col-md-6 col-lg-6">

                        <!-- C O M U N I C A C I O N -->
                        <iframe src="../resources/docs/Comunicacion/IEEE_830_Quala S.pdf" style="width:100%; height:450px;" frameborder="0" allowfullscreen></iframe>
                    </div>
                    <div class="col-sx-3 col-sm-3 col-md-3 col-lg-3"></div>
                </section>

                <!-- ........................    BOTONES  	.............................-->
                <section class="row"><!-- ((((.. boton Descarga ..)))) -->
                    <div class="col-sx-9 col-sm-9col-md-9 col-lg-9"></div>
                    <div class="col-sx-1 col-sm-1 col-md-1 col-lg-1">



                    </div>
                    <div class="col-sx-2 col-sm-2 col-md-2 col-lg-2"></div>
                </section>

                <section class="row">
                    <div class="col-sx-12 col-sm-12 col-md-12 col-lg-12 div-vacio">	</div>
                </section>	

                <!-- (((((((((((((((( boton regresar ))))))))))))))))-->
                <section class="row pull-right">
                    <div class="col-sx-1 col-sm-1 col-md-1 col-lg-1"></div>
                    <div class="col-sx-11 col-sm-11 col-md-11 col-lg-11 pull-right">

                        <p><!-- ((((.. boton Descarga ..)))) -->				
                            <a href="../resources/docs/Comunicacion/IEEE_830_Quala S.pdf" download="IEEE_830_Quala S.pdf" class="btn btn-info btn-md">
                                <span class="glyphicon glyphicon-download-alt"></span> 				
                            </a>
                        </p>

                        <a href="fase2.jsp" class="btn btn-success"><span class="glyphicon glyphicon-circle-arrow-left "></span> Regresar</a>

                    </div>
                </section>

                <section class="row">
                    <div class="col-sx-12 col-sm-12 col-md-12 col-lg-12 div-vacio">	</div>
                </section>	
                <!-- ...................     FIN BOTONES   	......................-->
            </div>
        </section>

        <!--footer - pie de pagina-->
        <%@include file="../template/jsp/footer.jsp" %>
    </body>
</html>
