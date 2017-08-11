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
        <title>fase2-DisenoWeb-Mapa</title>
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
                <h1 class="text-header-g">Mapa de Navegaci&oacute;n</h1>
            </div>
        </section>

        <section class="row fondo_mate center-block">       
            <div class="col-sx-1 col-sm-1 col-md-1 col-lg-1">

            </div>
            <div class="col-sx-10 col-sm-10 col-md-10 col-lg-10">
                <img src="../resources/docs/Fase_3/Diseño_webi/mapa.pdf" class="img-dw" alt="logo">
                <p>
                    <a href="../resources/docs/Fase_3/Diseño_webi/mapa.pdf" download="mapa.pdf" class="btn btn-info btn-md">
                        <span class="glyphicon glyphicon-download-alt"></span> 		
                    </a>
                </p>
            </div>
            <div class="col-sx-1 col-sm-1 col-md-1 col-lg-1">

            </div>
        </section>

        <!-- boton regresar -->
        <section class="row pull-right">
            <div class="col-sx-1 col-sm-1 col-md-1 col-lg-1">


            </div>
            <div class="col-sx-11 col-sm-11 col-md-11 col-lg-11 ">

                <a href="fase3.jsp" class="btn btn-success"><span class="glyphicon glyphicon-circle-arrow-left "></span> Regresar</a>

            </div>
        </section>
        <section class="row fondo_mate">
            <div class="col-sx-12 col-sm-12 col-md-12 col-lg-12" div-vacio">

        </div>
    </section>	
        <!--footer - pie de pagina-->
         <%@include file="../template/jsp/footer.jsp" %>
    </body>
</html>
