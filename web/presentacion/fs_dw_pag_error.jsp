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
        <title>fase2-DisenoWeb-PaginaError</title>
        <!-- LINKS -->
        <%@include file="../template/jsp/linksustenta.jsp" %>      
    </head>
    <body>
        <!--header - Menu -->
        <%@include file="../template/jsp/header.jsp" %>
        <!--banner - logo-->
        <%@include file="../template/jsp/sectionbanner.jsp" %>  
        <!--contenido-->
        <section class="row fondo_mate center-block">       
            <div class="col-sx-1 col-sm-1 col-md-1 col-lg-1">

            </div>
            <div class="col-sx-10 col-sm-10 col-md-10 col-lg-10">
                <img src="../resources/imgs/pag_error/ERROR 404.png" class="img-dw" alt="logo">
                <p>
                    <a href="../resources/imgs/pag_error/ERROR 404.png" download="ERROR 404.png" class="btn btn-info btn-md">
                        <span class="glyphicon glyphicon-download-alt"></span> 		
                    </a>
                     <a href="fase2.jsp" class="btn btn-success"><span class="glyphicon glyphicon-circle-arrow-left "></span> Regresar</a>
                </p>
            </div>
            <div class="col-sx-1 col-sm-1 col-md-1 col-lg-1">

            </div>
        </section>
        <!--footer - pie de pagina-->
         <%@include file="../template/jsp/footer.jsp" %>
    </body>
</html>
