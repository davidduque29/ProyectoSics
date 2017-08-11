<%-- 
    Document   : quienes
    Created on : 14-abr-2017, 18:35:51
    Author     : ivandavid
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Quienes somos</title>
        <!--LINKS-->
        <%@include file="../template/jsp/links.jsp" %>
    </head>
    <body>
        <!--header-->
        <%@include file="../template/jsp/header.jsp" %>
        <!--banner-->
        <%@include file="../template/jsp/sectionbanner.jsp" %> 

        <!--section - contenido-->
        <!-- ..........    S E C C I O N    Q UI E N E S    S O M O S ....................... --> 
        <section class="row container-fluid contenedor-nosotros">
            <div class="col-sx-12 col-sm-12 col-md-12 col-lg-12">

                <section class="row container-fluid">
                    <div class="col-sx-12 col-sm-12 col-md-12 col-lg-12">
                    </div>
                </section>
                <section class="row container-fluid text-center">
                    <div class="col-sx-12 col-sm-12 col-md-12 col-lg-12">
                        <h1 class="myshadow text-header-g">Quienes Somos</h1>
                    </div>
                </section>

                <section class="row container-fluid contenedor-nosotros">
                    <div class="col-sx-12 col-sm-12 col-md-12 col-lg-12">
                        <section class="row container-fluid">

                            <div class="col-sx-3 col-sm-3 col-md-3 col-lg-3">
                                <img src="resources/imgs/nosotros/programadora.png" alt="">
                            </div>
                            <div class="col-sx-5 col-sm-5 col-md-5 col-lg-5 text-justify info_nos">
                                <h1 class="text-header-m">Origen Sics</h1><br>
                                <h4>
                                    El propósito de nuestro proyecto fue desarrollar un sistema de información que permitiera el control y seguimiento de la línea de producción de Quipitos, de la empresa Quala S.A 
                                    En la visita realizada visualizamos la planta de producción, en la que encontramos algunos problemas en el área de control dado al manejo obsoleto de la información mediante un Excel.
                                    Debido a lo mencionado anteriormente hemos desarrollado un sistema de información que permite obtener informes en tiempo real, llevando a una toma de decisiones certera y oportuna.
                                    Para nosotros es importante continuar en el seguimiento de los procesos de producción, ya que en un futuro le podremos incorporar mejoras a nuestro sistema de información.

                                </h4>	
                            </div>
                            <div class="col-sx-4 col-sm-4 col-md-4 col-lg-4">
                                <img  class="img-redonda" src="../resources/imgs/nosotros/logo-quala.png" alt="">
                            </div>
                        </section>
                    </div>
                </section>				
                <section class="row container-fluid contenedor-nosotros">
                    <div class="col-sx-12 col-sm-12 col-md-12 col-lg-12">
                        <section class="row container-fluid">

                            <div class="col-sx-3 col-sm-3 col-md-3 col-lg-3">
                                <img src="../imgs/nosotros/programador.png" alt="">
                            </div>
                            <div class="col-sx-5 col-sm-5 col-md-5 col-lg-5 pull-left img-section">
                                <div class="logo_quienes"></div>
                            </div>
                            <div class="col-sx-4 col-sm-4 col-md-4 col-lg-4 text-justify info_nos">

                                <h1 class="text-header-s">Funcionalidad producto</h1><br>
                                <h4>
                                    •	Realizar el registro de novedades de la producción durante su proceso.
                                    •	Realizar el control y seguimiento del consumo de los materiales que se usan en la producción de la línea de Quipitos.
                                    •	Generar y visualizar los reportes estadísticos del stock de los materiales y novedades del proceso.
                                    •	Permitir el registro de recepción de P.T (Producto Terminado)
                                    •	Permitir el registro de los procesos de calidad del P.T (Producto Terminado)
                                    •	Visualizar indicadores de novedades y productividad en tiempo real, mostrando el comportamiento del proceso de producción.
                                </h4>

                            </div>
                        </section>
                    </div>
                </section>				

                <section class="row container-fluid contenedor-nosotros">
                    <div class="col-sx-12 col-sm-12 col-md-12 col-lg-12 espacio">

                    </div>
                </section> 

            </div>
        </section>

        <!--footer-->
        <%@include file="../template/jsp/footer.jsp" %>
    </body>
</html>
