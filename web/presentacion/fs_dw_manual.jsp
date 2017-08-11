<%-- 
    Document   : fs_dw_pag_error
    Created on : 16-jun-2017, 14:26:30
    Author     : ivandavid
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>fase2-DisenoWeb-Manual</title>
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
        <section class="row container-fluid text-center fondo_mate">       
            <div class="col-sx-12 col-sm-12 col-md-12 col-lg-12">		

                <section class="row container-fluid text-center">       
                    <div class="col-sx-12 col-sm-12 col-md-12 col-lg-12 text-center">	
                        <h1 class="text-header-g">Manual de imagen</h1>
                        <h1 class="text-header-g">corporativa</h1>
                    </div>
                </section>

                <section class="row center-block">       
                    <div class="col-sx-3 col-sm-3 col-md-3 col-lg-3"></div>
                    <div class="col-sx-6 col-sm-6 col-md-6 col-lg-6">

                        <!-- M A N U A L   I M A G E N   C O R P O R A T I V A -->
                        <iframe src="../resources/docs/DiseñoWeb/MANUAL COPRORATIVO/ManualCorporativo.pdf" style="width:100%; height:450px;" frameborder="0" allowfullscreen></iframe>
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
                            <a href="../resources/docs/DiseñoWeb/MANUAL COPRORATIVO/ManualCorporativo.pdf" download="ManualCorporativo.pdf" class="btn btn-info btn-md">
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
