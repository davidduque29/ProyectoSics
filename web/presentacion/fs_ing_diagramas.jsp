<%-- 
    Document   : fs_ing_diagramas
    Created on : 16-jun-2017, 9:54:37
    Author     : ivandavid
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
         <title>Fase2-Diagramas</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <!-- Metadatos -->
        <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
        <meta name="description" content="Sistema de Información">
        <meta name="keywords" content="html5, css3, diseño web">

        <!-- Estilos -->
        <link rel="shortcut icon" href="sources/imgs/Favicon/FAVICON_70X74-SICS9.png">
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
        
        <!-- ******************** (  1. PROCESOS ) *********************** -->

        <section class="row container-fluid text-center">  
            <div class="col-sx-12 col-sm-12 col-md-12 col-lg-12">
                <section class="row">
                    <div class="div-vacio"></div>
                </section>

                <section class="row">
                    <div class="col-sx-1 col-sm-1 col-md-1 col-lg-1 margin-btn">    
                        <a href="#Procesos" class="btn btn-success"><span class="glyphicon glyphicon-tag clear"></span> Proce.
                        </a>        
                    </div>
                    <div class="col-sx-1 col-sm-1 col-md-1 col-lg-1">
                        <a href="#flujo" class="btn btn-success margin-btn"><span class="glyphicon glyphicon-tag "></span> Flujo.
                        </a>
                    </div>

                    <div class="col-sx-1 col-sm-1 col-md-1 col-lg-1 margin-btn">
                        <a href="#caso_uso" class="btn btn-success"><span class="glyphicon glyphicon-tag "></span> C.uso
                        </a>        
                    </div>
                    <div class="col-sx-1 col-sm-1 col-md-1 col-lg-1 margin-btn">
                        <a href="#extendido" class="btn btn-success"><span class="glyphicon glyphicon-tag"></span> C.ext.
                        </a>        
                    </div>
                    <div class="col-sx-1 col-sm-1 col-md-1 col-lg-1 margin-btn">
                        <a href="#Entidad" class="btn btn-success"><span class="glyphicon glyphicon-tag"></span> Entid.
                        </a>        
                    </div>
                    <div class="col-sx-1 col-sm-1 col-md-1 col-lg-1 margin-btn">
                        <a href="#Clases" class="btn btn-success"><span class="glyphicon glyphicon-tag"></span> Clas.
                        </a>        
                    </div>
                    <div class="col-sx-1 col-sm-1 col-md-1 col-lg-1 margin-btn">
                        <a href="#Actividades" class="btn btn-success"><span class="glyphicon glyphicon-tag "></span> Activ.
                        </a>        
                    </div>

                    <div class="col-sx-1 col-sm-1 col-md-1 col-lg-1 margin-btn">
                        <a href="#Estado" class="btn btn-success margin-btn"><span class="glyphicon glyphicon-tag "></span> Esta.
                        </a>        
                    </div>
                    <div class="col-sx-1 col-sm-1 col-md-1 col-lg-1 margin-btn">
                        <a href="#Secuencia" class="btn btn-success"><span class="glyphicon glyphicon-tag "></span> Secu.
                        </a>        
                    </div>
                    <div class="col-sx-1 col-sm-1 col-md-1 col-lg-1 margin-btn">
                        <a href="#Comunicación" class="btn btn-success margin-btn"><span class="glyphicon glyphicon-tag "></span> Comun.
                        </a>        
                    </div>  
                    <div class="col-sx-1 col-sm-1 col-md-1 col-lg-1">
                        <div class="col-sx-1 col-sm-1 col-md-1 col-lg-1 margin-btn">
                            <a href="#paquetes" class="btn btn-success margin-btn"><span class="glyphicon glyphicon-tag "></span> Paq.
                            </a>    
                        </div>  
                    </div>  
                    <div class="col-sx-1 col-sm-1 col-md-1 col-lg-1"></div>        
                </section>

                <section id="Procesos"></section>
                <section class="row container-fluid text-center">       
                    <div class="col-sx-12 col-sm-12 col-md-12 col-lg-12 text-center">   
                        <h1 class="text-header-g">1. Diagrama</h1>
                        <h1 class="text-header-g">Procesos</h1>
                    </div>
                </section>

                <section class="row center-block">       
                    <div class="col-sx-3 col-sm-3col-md-3 col-lg-3"></div>
                    <div class="col-sx-6 col-sm-6 col-md-6 col-lg-6">

                        <!-- D I A G   P R O C E S O -->
                        <iframe src="../resources/docs/IngenieriaSoftware/Diagramas/1_DIAG_PROCESOS/diag_procesos.pdf" style="width:100%; height:450px;" frameborder="0" allowfullscreen></iframe>
                    </div>
                    <div class="col-sx-2 col-sm-2 col-md-2 col-lg-2"></div>
                </section>

                <!-- ........................    BOTONES    .............................-->
                <section class="row"><!-- ((((.. boton Descarga ..)))) -->
                    <div class="col-sx-9 col-sm-9col-md-9 col-lg-9"></div>
                    <div class="col-sx-1 col-sm-1 col-md-1 col-lg-1">



                    </div>
                    <div class="col-sx-2 col-sm-2 col-md-2 col-lg-2"></div>
                </section>

                <section class="row">
                    <div class="col-sx-12 col-sm-12 col-md-12 col-lg-12 div-vacio">    </div>
                </section>  

                <!-- (((((((((((((((( boton regresar ))))))))))))))))-->
                <section class="row pull-right">
                    <div class="col-sx-1 col-sm-1 col-md-1 col-lg-1"></div>
                    <div class="col-sx-11 col-sm-11 col-md-11 col-lg-11 pull-right">

                        <p><!-- ((((.. boton Descarga ..)))) -->                
                            <a href="../resources/docs/IngenieriaSoftware/Diagramas/1_DIAG_PROCESOS/Diagrama-de-Produccion.png" download="Diagrama de Produccion.png" class="btn btn-info btn-md">
                                <span class="glyphicon glyphicon-download-alt"></span>      
                            </a>
                        </p>    

                        <a href="fase2.jsp" class="btn btn-success"><span class="glyphicon glyphicon-circle-arrow-left "></span> Regresar</a>

                    </div>
                </section>

                <section class="row">
                    <div class="col-sx-12 col-sm-12 col-md-12 col-lg-12 div-vacio"> </div>
                </section>  
                <!-- ...................     FIN BOTONES    ......................-->
            </div>
        </section>


        <!-- ******************** (  2. FLUJOS ) *********************** -->

        <section class="row container-fluid text-center">  
            <div class="col-sx-12 col-sm-12 col-md-12 col-lg-12">

                <section class="row">
                    <div class="col-sx-1 col-sm-1 col-md-1 col-lg-1 margin-btn">    
                        <a href="#Procesos" class="btn btn-success"><span class="glyphicon glyphicon-tag clear"></span> Proce.
                        </a>        
                    </div>
                    <div class="col-sx-1 col-sm-1 col-md-1 col-lg-1">
                        <a href="#flujo" class="btn btn-success margin-btn"><span class="glyphicon glyphicon-tag "></span> Flujo.
                        </a>
                    </div>

                    <div class="col-sx-1 col-sm-1 col-md-1 col-lg-1 margin-btn">
                        <a href="#caso_uso" class="btn btn-success"><span class="glyphicon glyphicon-tag "></span> C.uso
                        </a>        
                    </div>
                    <div class="col-sx-1 col-sm-1 col-md-1 col-lg-1 margin-btn">
                        <a href="#extendido" class="btn btn-success"><span class="glyphicon glyphicon-tag"></span> C.ext.
                        </a>        
                    </div>
                    <div class="col-sx-1 col-sm-1 col-md-1 col-lg-1 margin-btn">
                        <a href="#Entidad" class="btn btn-success"><span class="glyphicon glyphicon-tag"></span> Entid.
                        </a>        
                    </div>
                    <div class="col-sx-1 col-sm-1 col-md-1 col-lg-1 margin-btn">
                        <a href="#Clases" class="btn btn-success"><span class="glyphicon glyphicon-tag"></span> Clas.
                        </a>        
                    </div>
                    <div class="col-sx-1 col-sm-1 col-md-1 col-lg-1 margin-btn">
                        <a href="#Actividades" class="btn btn-success"><span class="glyphicon glyphicon-tag "></span> Activ.
                        </a>        
                    </div>

                    <div class="col-sx-1 col-sm-1 col-md-1 col-lg-1 margin-btn">
                        <a href="#Estado" class="btn btn-success margin-btn"><span class="glyphicon glyphicon-tag "></span> Esta.
                        </a>        
                    </div>
                    <div class="col-sx-1 col-sm-1 col-md-1 col-lg-1 margin-btn">
                        <a href="#Secuencia" class="btn btn-success"><span class="glyphicon glyphicon-tag "></span> Secu.
                        </a>        
                    </div>
                    <div class="col-sx-1 col-sm-1 col-md-1 col-lg-1 margin-btn">
                        <a href="#Comunicación" class="btn btn-success margin-btn"><span class="glyphicon glyphicon-tag "></span> Comun.
                        </a>        
                    </div>  
                    <div class="col-sx-1 col-sm-1 col-md-1 col-lg-1">
                        <div class="col-sx-1 col-sm-1 col-md-1 col-lg-1 margin-btn">
                            <a href="#paquetes" class="btn btn-success margin-btn"><span class="glyphicon glyphicon-tag "></span> Paq.
                            </a>    
                        </div>  
                    </div>  
                    <div class="col-sx-1 col-sm-1 col-md-1 col-lg-1"></div>        
                </section>

                <section id="flujo"></section>
                <section class="row container-fluid text-center">       
                    <div class="col-sx-12 col-sm-12 col-md-12 col-lg-12 text-center">   
                        <h1 class="text-header-g">2. Diagrama</h1>
                        <h1 class="text-header-g">flujo</h1>
                    </div>
                </section>

                <section class="row center-block">       
                    <div class="col-sx-3 col-sm-3col-md-3 col-lg-3"></div>
                    <div class="col-sx-6 col-sm-6 col-md-6 col-lg-6">

                        <!-- D I A G   F L U J O-->
                        <iframe src="../resources/docs/IngenieriaSoftware/Diagramas/10_DIAG_FLUJO/diag_flujo.pdf" style="width:100%; height:450px;" frameborder="0" allowfullscreen></iframe>
                    </div>
                    <div class="col-sx-2 col-sm-2 col-md-2 col-lg-2"></div>
                </section>

                <!-- ........................    BOTONES    .............................-->
                <section class="row"><!-- ((((.. boton Descarga ..)))) -->
                    <div class="col-sx-9 col-sm-9col-md-9 col-lg-9"></div>
                    <div class="col-sx-1 col-sm-1 col-md-1 col-lg-1">



                    </div>
                    <div class="col-sx-2 col-sm-2 col-md-2 col-lg-2"></div>
                </section>

                <section class="row">
                    <div class="col-sx-12 col-sm-12 col-md-12 col-lg-12" div-vacio">    </div>
                </section>  

                <!-- (((((((((((((((( boton regresar ))))))))))))))))-->
                <section class="row pull-right">
                    <div class="col-sx-1 col-sm-1 col-md-1 col-lg-1"></div>
                    <div class="col-sx-11 col-sm-11 col-md-11 col-lg-11 pull-right">

                        <p><!-- ((((.. boton Descarga ..)))) -->                
                            <a href="../resources/docs/IngenieriaSoftware/Diagramas/10_DIAG_FLUJO/diag_flujo.pdf" download="diag_flujo.pdf" class="btn btn-info btn-md">
                                <span class="glyphicon glyphicon-download-alt"></span>      
                            </a>
                        </p>    

                        <a href="fase2.jsp" class="btn btn-success"><span class="glyphicon glyphicon-circle-arrow-left "></span> Regresar</a>

                    </div>
                </section>

                <section class="row">
                    <div class="col-sx-12 col-sm-12 col-md-12 col-lg-12 div-vacio"> </div>
                </section>  
                <!-- ...................     FIN BOTONES    ......................-->
            </div>
        </section>



        <!-- ******************** (  3. CASOS DE USO ) *********************** -->



        <section class="row container-fluid">
            <div class="col-sx-1 col-sm-1 col-md-1 col-lg-1 margin-btn">    
                <a href="#Procesos" class="btn btn-success"><span class="glyphicon glyphicon-tag clear"></span> Proce.
                </a>        
            </div>
            <div class="col-sx-1 col-sm-1 col-md-1 col-lg-1">
                <a href="#flujo" class="btn btn-success margin-btn"><span class="glyphicon glyphicon-tag "></span> Flujo.
                </a>
            </div>

            <div class="col-sx-1 col-sm-1 col-md-1 col-lg-1 margin-btn">
                <a href="#caso_uso" class="btn btn-success"><span class="glyphicon glyphicon-tag "></span> C.uso
                </a>        
            </div>
            <div class="col-sx-1 col-sm-1 col-md-1 col-lg-1 margin-btn">
                <a href="#extendido" class="btn btn-success"><span class="glyphicon glyphicon-tag"></span> C.ext.
                </a>        
            </div>
            <div class="col-sx-1 col-sm-1 col-md-1 col-lg-1 margin-btn">
                <a href="#Entidad" class="btn btn-success"><span class="glyphicon glyphicon-tag"></span> Entid.
                </a>        
            </div>
            <div class="col-sx-1 col-sm-1 col-md-1 col-lg-1 margin-btn">
                <a href="#Clases" class="btn btn-success"><span class="glyphicon glyphicon-tag"></span> Clas.
                </a>        
            </div>
            <div class="col-sx-1 col-sm-1 col-md-1 col-lg-1 margin-btn">
                <a href="#Actividades" class="btn btn-success"><span class="glyphicon glyphicon-tag "></span> Activ.
                </a>        
            </div>

            <div class="col-sx-1 col-sm-1 col-md-1 col-lg-1 margin-btn">
                <a href="#Estado" class="btn btn-success margin-btn"><span class="glyphicon glyphicon-tag "></span> Esta.
                </a>        
            </div>
            <div class="col-sx-1 col-sm-1 col-md-1 col-lg-1 margin-btn">
                <a href="#Secuencia" class="btn btn-success"><span class="glyphicon glyphicon-tag "></span> Secu.
                </a>        
            </div>
            <div class="col-sx-1 col-sm-1 col-md-1 col-lg-1 margin-btn">
                <a href="#Comunicación" class="btn btn-success margin-btn"><span class="glyphicon glyphicon-tag "></span> Comun.
                </a>        
            </div>  
            <div class="col-sx-1 col-sm-1 col-md-1 col-lg-1">
                <div class="col-sx-1 col-sm-1 col-md-1 col-lg-1 margin-btn">
                    <a href="#paquetes" class="btn btn-success margin-btn"><span class="glyphicon glyphicon-tag "></span> Paq.
                    </a>    
                </div>  
            </div>  
            <div class="col-sx-1 col-sm-1 col-md-1 col-lg-1"></div>        
        </section>

        <section id="caso_uso"></section>
        <section class="row container-fluid text-center">       
            <div class="col-sx-12 col-sm-12 col-md-12 col-lg-12 text-center">   
                <h1 class="text-header-g">3. Diagrama</h1>
                <h1 class="text-header-g">casos de uso</h1>
            </div>
        </section>

        <section class="row center-block">       
            <div class="col-sx-1 col-sm-1 col-md-1 col-lg-1"></div>
            <div class="col-sx-9 col-sm-9 col-md-9 col-lg-9">


            </div>
            <div class="col-sx-2 col-sm-2 col-md-2 col-lg-2"></div>
        </section>

        <!-- ........................    BOTONES    .............................-->
        <section class="row"><!-- ((((.. boton Descarga ..)))) -->
            <div class="col-sx-3 col-sm-3col-md-3 col-lg-3"></div>
            <div class="col-sx-6 col-sm-6 col-md-6 col-lg-6">


                <!-- D I A G   C A S O S  D E  U S O -->
                <iframe src="../resources/docs/IngenieriaSoftware/Diagramas/2_DIAGRAMA_CASOS_USO/Dgs_caso_de_uso.pdf" style="width:100%; height:450px;" frameborder="0" allowfullscreen></iframe>

            </div>
            <div class="col-sx-3 col-sm-3 col-md-3 col-lg-3"></div>
        </section>

        <section class="row">
            <div class="col-sx-12 col-sm-12 col-md-12 col-lg-12" div-vacio">    </div>
        </section>  

        <!-- (((((((((((((((( boton regresar ))))))))))))))))-->
        <section class="row pull-right">
            <div class="col-sx-1 col-sm-1 col-md-1 col-lg-1"></div>
            <div class="col-sx-11 col-sm-11 col-md-11 col-lg-11 pull-right">


                <p><!-- ((((.. boton Descarga ..)))) -->                
                    <a href="../resources/docs/IngenieriaSoftware/Diagramas/2_DIAGRAMA_CASOS_USO/Dgs_caso_de_uso.pdf" download="Dgs_caso_de_uso.pdf" class="btn btn-info btn-md">
                        <span class="glyphicon glyphicon-download-alt"></span>      
                    </a>
                </p>

                <a href="fase2.jsp" class="btn btn-success"><span class="glyphicon glyphicon-circle-arrow-left "></span> Regresar</a>

            </div>
        </section>

        <section class="row">
            <div class="col-sx-12 col-sm-12 col-md-12 col-lg-12 div-vacio"> </div>
        </section>  
        <!-- ...................     FIN BOTONES    ......................-->
    </div>
</section>

<!-- ******************** (  4. C.U EXTENDIDO ) *********************** -->
<section id="extendido"></section>

<section class="row container-fluid">
    <div class="col-sx-1 col-sm-1 col-md-1 col-lg-1 margin-btn">    
        <a href="#Procesos" class="btn btn-success"><span class="glyphicon glyphicon-tag clear"></span> Proce.
        </a>        
    </div>
    <div class="col-sx-1 col-sm-1 col-md-1 col-lg-1">
        <a href="#flujo" class="btn btn-success margin-btn"><span class="glyphicon glyphicon-tag "></span> Flujo.
        </a>
    </div>

    <div class="col-sx-1 col-sm-1 col-md-1 col-lg-1 margin-btn">
        <a href="#caso_uso" class="btn btn-success"><span class="glyphicon glyphicon-tag "></span> C.uso
        </a>        
    </div>
    <div class="col-sx-1 col-sm-1 col-md-1 col-lg-1 margin-btn">
        <a href="#extendido" class="btn btn-success"><span class="glyphicon glyphicon-tag"></span> C.ext.
        </a>        
    </div>
    <div class="col-sx-1 col-sm-1 col-md-1 col-lg-1 margin-btn">
        <a href="#Entidad" class="btn btn-success"><span class="glyphicon glyphicon-tag"></span> Entid.
        </a>        
    </div>
    <div class="col-sx-1 col-sm-1 col-md-1 col-lg-1 margin-btn">
        <a href="#Clases" class="btn btn-success"><span class="glyphicon glyphicon-tag"></span> Clas.
        </a>        
    </div>
    <div class="col-sx-1 col-sm-1 col-md-1 col-lg-1 margin-btn">
        <a href="#Actividades" class="btn btn-success"><span class="glyphicon glyphicon-tag "></span> Activ.
        </a>        
    </div>

    <div class="col-sx-1 col-sm-1 col-md-1 col-lg-1 margin-btn">
        <a href="#Estado" class="btn btn-success margin-btn"><span class="glyphicon glyphicon-tag "></span> Esta.
        </a>        
    </div>
    <div class="col-sx-1 col-sm-1 col-md-1 col-lg-1 margin-btn">
        <a href="#Secuencia" class="btn btn-success"><span class="glyphicon glyphicon-tag "></span> Secu.
        </a>        
    </div>
    <div class="col-sx-1 col-sm-1 col-md-1 col-lg-1 margin-btn">
        <a href="#Comunicación" class="btn btn-success margin-btn"><span class="glyphicon glyphicon-tag "></span> Comun.
        </a>        
    </div>  
    <div class="col-sx-1 col-sm-1 col-md-1 col-lg-1">
        <div class="col-sx-1 col-sm-1 col-md-1 col-lg-1 margin-btn">
            <a href="#paquetes" class="btn btn-success margin-btn"><span class="glyphicon glyphicon-tag "></span> Paq.
            </a>    
        </div>  
    </div>  
    <div class="col-sx-1 col-sm-1 col-md-1 col-lg-1"></div>        
</section>

<section class="row container-fluid text-center">       
    <div class="col-sx-12 col-sm-12 col-md-12 col-lg-12 text-center">   
        <h1 class="text-header-g">4. Diagrama</h1>
        <h1 class="text-header-g">caso de uso extendido</h1>
    </div>
</section>

<section class="row center-block">       
    <div class="col-sx-3 col-sm-3col-md-3 col-lg-3"></div>
    <div class="col-sx-6 col-sm-6 col-md-6 col-lg-6">

        <!-- C A S O   U S O  E X T E N D I D O -->
        <iframe src="../resources/docs/IngenieriaSoftware/Diagramas/3_DIAG__C_U_EXTENDIDO/Cu_ext_Quala.pdf" style="width:100%;height:450px;" frameborder="0" allowfullscreen></iframe>
    </div>
    <div class="col-sx-3 col-sm-3 col-md-3 col-lg-3"></div>
</section>

<!-- ........................    BOTONES    .............................-->
<section class="row"><!-- ((((.. boton Descarga ..)))) -->
    <div class="col-sx-9 col-sm-9col-md-9 col-lg-9"></div>
    <div class="col-sx-1 col-sm-1 col-md-1 col-lg-1">



    </div>
    <div class="col-sx-2 col-sm-2 col-md-2 col-lg-2"></div>
</section>

<section class="row">
    <div class="col-sx-12 col-sm-12 col-md-12 col-lg-12" div-vacio">    </div>
</section>  

<!-- (((((((((((((((( boton regresar ))))))))))))))))-->
<section class="row pull-right">
    <div class="col-sx-1 col-sm-1 col-md-1 col-lg-1"></div>
    <div class="col-sx-11 col-sm-11 col-md-11 col-lg-11 pull-right">

        <p><!-- ((((.. boton Descarga ..)))) -->                
            <a href="../resources/docs/IngenieriaSoftware/Diagramas/3_DIAG__C_U_EXTENDIDO/Cu_ext_Quala.pdf" download="Cu_ext_Quala.pdf" class="btn btn-info btn-md">
                <span class="glyphicon glyphicon-download-alt"></span>      
            </a>
        </p>

        <a href="fase2.jsp" class="btn btn-success"><span class="glyphicon glyphicon-circle-arrow-left "></span> Regresar</a>

    </div>
</section>

<section class="row">
    <div class="col-sx-12 col-sm-12 col-md-12 col-lg-12 div-vacio"> </div>
</section>  
<!-- ...................     FIN BOTONES    ......................-->
</div>
</section>


<!-- ******************** (  5. ENTIDAD RELACION) ********************* -->
<section id="Entidad"></section>


<section class="row container-fluid">
    <div class="col-sx-1 col-sm-1 col-md-1 col-lg-1 margin-btn">    
        <a href="#Procesos" class="btn btn-success"><span class="glyphicon glyphicon-tag clear"></span> Proce.
        </a>        
    </div>
    <div class="col-sx-1 col-sm-1 col-md-1 col-lg-1">
        <a href="#flujo" class="btn btn-success margin-btn"><span class="glyphicon glyphicon-tag "></span> Flujo.
        </a>
    </div>

    <div class="col-sx-1 col-sm-1 col-md-1 col-lg-1 margin-btn">
        <a href="#caso_uso" class="btn btn-success"><span class="glyphicon glyphicon-tag "></span> C.uso
        </a>        
    </div>
    <div class="col-sx-1 col-sm-1 col-md-1 col-lg-1 margin-btn">
        <a href="#extendido" class="btn btn-success"><span class="glyphicon glyphicon-tag"></span> C.ext.
        </a>        
    </div>
    <div class="col-sx-1 col-sm-1 col-md-1 col-lg-1 margin-btn">
        <a href="#Entidad" class="btn btn-success"><span class="glyphicon glyphicon-tag"></span> Entid.
        </a>        
    </div>
    <div class="col-sx-1 col-sm-1 col-md-1 col-lg-1 margin-btn">
        <a href="#Clases" class="btn btn-success"><span class="glyphicon glyphicon-tag"></span> Clas.
        </a>        
    </div>
    <div class="col-sx-1 col-sm-1 col-md-1 col-lg-1 margin-btn">
        <a href="#Actividades" class="btn btn-success"><span class="glyphicon glyphicon-tag "></span> Activ.
        </a>        
    </div>

    <div class="col-sx-1 col-sm-1 col-md-1 col-lg-1 margin-btn">
        <a href="#Estado" class="btn btn-success margin-btn"><span class="glyphicon glyphicon-tag "></span> Esta.
        </a>        
    </div>
    <div class="col-sx-1 col-sm-1 col-md-1 col-lg-1 margin-btn">
        <a href="#Secuencia" class="btn btn-success"><span class="glyphicon glyphicon-tag "></span> Secu.
        </a>        
    </div>
    <div class="col-sx-1 col-sm-1 col-md-1 col-lg-1 margin-btn">
        <a href="#Comunicación" class="btn btn-success margin-btn"><span class="glyphicon glyphicon-tag "></span> Comun.
        </a>        
    </div>  
    <div class="col-sx-1 col-sm-1 col-md-1 col-lg-1">
        <div class="col-sx-1 col-sm-1 col-md-1 col-lg-1 margin-btn">
            <a href="#paquetes" class="btn btn-success margin-btn"><span class="glyphicon glyphicon-tag "></span> Paq.
            </a>    
        </div>  
    </div>  
    <div class="col-sx-1 col-sm-1 col-md-1 col-lg-1"></div>        
</section>  

<section class="row container-fluid text-center">       
    <div class="col-sx-12 col-sm-12 col-md-12 col-lg-12 text-center">   
        <h1 class="text-header-g">5. Diagrama</h1>
        <h1 class="text-header-g">entidad relación</h1>
    </div>
</section>

<section class="row center-block">       
    <div class="col-sx-3 col-sm-3col-md-3 col-lg-3"></div>
    <div class="col-sx-6 col-sm-6 col-md-6 col-lg-6">

        <!-- D I A G   E N T I D A D  R E L A C I O N -->
        <iframe src="../resources/docs/IngenieriaSoftware/Diagramas/4_DIAG_MER/Dgs_mer.pdf" style="width:100%;height:450px;" frameborder="0" allowfullscreen></iframe>
    </div>
    <div class="col-sx-3 col-sm-3 col-md-3 col-lg-3"></div>
</section>

<!-- ........................    BOTONES    .............................-->
<section class="row"><!-- ((((.. boton Descarga ..)))) -->
    <div class="col-sx-9 col-sm-9col-md-9 col-lg-9"></div>
    <div class="col-sx-1 col-sm-1 col-md-1 col-lg-1">



    </div>
    <div class="col-sx-2 col-sm-2 col-md-2 col-lg-2"></div>
</section>

<section class="row">
    <div class="col-sx-12 col-sm-12 col-md-12 col-lg-12" div-vacio">    </div>
</section>  

<!-- (((((((((((((((( boton regresar ))))))))))))))))-->
<section class="row pull-right">
    <div class="col-sx-1 col-sm-1 col-md-1 col-lg-1"></div>
    <div class="col-sx-11 col-sm-11 col-md-11 col-lg-11 pull-right">

        <p><!-- ((((.. boton Descarga ..)))) -->                
            <a href="../resources/docs/IngenieriaSoftware/Diagramas/4_DIAG_MER/Dgs_mer.pdf" download="Dgs_mer.pdf" class="btn btn-info btn-md">
                <span class="glyphicon glyphicon-download-alt"></span>      
            </a>
        </p>

        <a href="fase2.jsp" class="btn btn-success"><span class="glyphicon glyphicon-circle-arrow-left "></span> Regresar</a>

    </div>
</section>

<section class="row">
    <div class="col-sx-12 col-sm-12 col-md-12 col-lg-12 div-vacio"> </div>
</section>  
<!-- ...................     FIN BOTONES    ......................-->
</div>
</section>


<!-- ********************    (  6. CLASES )    *********************** -->
<section id="Clases"></section>


<section class="row container-fluid">
    <div class="col-sx-1 col-sm-1 col-md-1 col-lg-1 margin-btn">    
        <a href="#Procesos" class="btn btn-success"><span class="glyphicon glyphicon-tag clear"></span> Proce.
        </a>        
    </div>
    <div class="col-sx-1 col-sm-1 col-md-1 col-lg-1">
        <a href="#flujo" class="btn btn-success margin-btn"><span class="glyphicon glyphicon-tag "></span> Flujo.
        </a>
    </div>

    <div class="col-sx-1 col-sm-1 col-md-1 col-lg-1 margin-btn">
        <a href="#caso_uso" class="btn btn-success"><span class="glyphicon glyphicon-tag "></span> C.uso
        </a>        
    </div>
    <div class="col-sx-1 col-sm-1 col-md-1 col-lg-1 margin-btn">
        <a href="#extendido" class="btn btn-success"><span class="glyphicon glyphicon-tag"></span> C.ext.
        </a>        
    </div>
    <div class="col-sx-1 col-sm-1 col-md-1 col-lg-1 margin-btn">
        <a href="#Entidad" class="btn btn-success"><span class="glyphicon glyphicon-tag"></span> Entid.
        </a>        
    </div>
    <div class="col-sx-1 col-sm-1 col-md-1 col-lg-1 margin-btn">
        <a href="#Clases" class="btn btn-success"><span class="glyphicon glyphicon-tag"></span> Clas.
        </a>        
    </div>
    <div class="col-sx-1 col-sm-1 col-md-1 col-lg-1 margin-btn">
        <a href="#Actividades" class="btn btn-success"><span class="glyphicon glyphicon-tag "></span> Activ.
        </a>        
    </div>

    <div class="col-sx-1 col-sm-1 col-md-1 col-lg-1 margin-btn">
        <a href="#Estado" class="btn btn-success margin-btn"><span class="glyphicon glyphicon-tag "></span> Esta.
        </a>        
    </div>
    <div class="col-sx-1 col-sm-1 col-md-1 col-lg-1 margin-btn">
        <a href="#Secuencia" class="btn btn-success"><span class="glyphicon glyphicon-tag "></span> Secu.
        </a>        
    </div>
    <div class="col-sx-1 col-sm-1 col-md-1 col-lg-1 margin-btn">
        <a href="#Comunicación" class="btn btn-success margin-btn"><span class="glyphicon glyphicon-tag "></span> Comun.
        </a>        
    </div>  
    <div class="col-sx-1 col-sm-1 col-md-1 col-lg-1">
        <div class="col-sx-1 col-sm-1 col-md-1 col-lg-1 margin-btn">
            <a href="#paquetes" class="btn btn-success margin-btn"><span class="glyphicon glyphicon-tag "></span> Paq.
            </a>    
        </div>  
    </div>  
    <div class="col-sx-1 col-sm-1 col-md-1 col-lg-1"></div>        
</section>  

<section class="row container-fluid text-center">       
    <div class="col-sx-12 col-sm-12 col-md-12 col-lg-12 text-center">   
        <h1 class="text-header-g">6. Diagrama</h1>
        <h1 class="text-header-g">clases</h1>
    </div>
</section>

<section class="row center-block">       
    <div class="col-sx-3 col-sm-3col-md-3 col-lg-3"></div>
    <div class="col-sx-6 col-sm-6 col-md-6 col-lg-6">

        <!-- D I A G   C L A S E S -->
        <iframe src="../resources/docs/IngenieriaSoftware/Diagramas/5_DIAG_CLASES/Dgs_clas.pdf" style="width:100%;height:450px;" frameborder="0" allowfullscreen></iframe>
    </div>
    <div class="col-sx-3 col-sm-3 col-md-3 col-lg-3"></div>
</section>

<!-- ........................    BOTONES    .............................-->
<section class="row"><!-- ((((.. boton Descarga ..)))) -->
    <div class="col-sx-9 col-sm-9col-md-9 col-lg-9"></div>
    <div class="col-sx-1 col-sm-1 col-md-1 col-lg-1">



    </div>
    <div class="col-sx-2 col-sm-2 col-md-2 col-lg-2"></div>
</section>

<section class="row">
    <div class="col-sx-12 col-sm-12 col-md-12 col-lg-12" div-vacio">    </div>
</section>  

<!-- (((((((((((((((( boton regresar ))))))))))))))))-->
<section class="row pull-right">
    <div class="col-sx-1 col-sm-1 col-md-1 col-lg-1"></div>
    <div class="col-sx-11 col-sm-11 col-md-11 col-lg-11 pull-right">

        <p><!-- ((((.. boton Descarga ..)))) -->                
            <a href="../resources/docs/IngenieriaSoftware/Diagramas/5_DIAG_CLASES/Dgs_clas.pdf" download="Dgs_clases.pdf" class="btn btn-info btn-md">
                <span class="glyphicon glyphicon-download-alt"></span>      
            </a>
        </p>

        <a href="fase2.jsp" class="btn btn-success"><span class="glyphicon glyphicon-circle-arrow-left "></span> Regresar</a>

    </div>
</section>

<section class="row">
    <div class="col-sx-12 col-sm-12 col-md-12 col-lg-12 div-vacio"> </div>
</section>  
<!-- ...................     FIN BOTONES    ......................-->
</div>
</section>


<!-- ******************** (  7. ACTIVIDADES ) *********************** -->
<section id="Actividades"></section>

<section class="row container-fluid">
    <div class="col-sx-1 col-sm-1 col-md-1 col-lg-1 margin-btn">    
        <a href="#Procesos" class="btn btn-success"><span class="glyphicon glyphicon-tag clear"></span> Proce.
        </a>        
    </div>
    <div class="col-sx-1 col-sm-1 col-md-1 col-lg-1">
        <a href="#flujo" class="btn btn-success margin-btn"><span class="glyphicon glyphicon-tag "></span> Flujo.
        </a>
    </div>

    <div class="col-sx-1 col-sm-1 col-md-1 col-lg-1 margin-btn">
        <a href="#caso_uso" class="btn btn-success"><span class="glyphicon glyphicon-tag "></span> C.uso
        </a>        
    </div>
    <div class="col-sx-1 col-sm-1 col-md-1 col-lg-1 margin-btn">
        <a href="#extendido" class="btn btn-success"><span class="glyphicon glyphicon-tag"></span> C.ext.
        </a>        
    </div>
    <div class="col-sx-1 col-sm-1 col-md-1 col-lg-1 margin-btn">
        <a href="#Entidad" class="btn btn-success"><span class="glyphicon glyphicon-tag"></span> Entid.
        </a>        
    </div>
    <div class="col-sx-1 col-sm-1 col-md-1 col-lg-1 margin-btn">
        <a href="#Clases" class="btn btn-success"><span class="glyphicon glyphicon-tag"></span> Clas.
        </a>        
    </div>
    <div class="col-sx-1 col-sm-1 col-md-1 col-lg-1 margin-btn">
        <a href="#Actividades" class="btn btn-success"><span class="glyphicon glyphicon-tag "></span> Activ.
        </a>        
    </div>

    <div class="col-sx-1 col-sm-1 col-md-1 col-lg-1 margin-btn">
        <a href="#Estado" class="btn btn-success margin-btn"><span class="glyphicon glyphicon-tag "></span> Esta.
        </a>        
    </div>
    <div class="col-sx-1 col-sm-1 col-md-1 col-lg-1 margin-btn">
        <a href="#Secuencia" class="btn btn-success"><span class="glyphicon glyphicon-tag "></span> Secu.
        </a>        
    </div>
    <div class="col-sx-1 col-sm-1 col-md-1 col-lg-1 margin-btn">
        <a href="#Comunicación" class="btn btn-success margin-btn"><span class="glyphicon glyphicon-tag "></span> Comun.
        </a>        
    </div>  
    <div class="col-sx-1 col-sm-1 col-md-1 col-lg-1">
        <div class="col-sx-1 col-sm-1 col-md-1 col-lg-1 margin-btn">
            <a href="#paquetes" class="btn btn-success margin-btn"><span class="glyphicon glyphicon-tag "></span> Paq.
            </a>    
        </div>  
    </div>  
    <div class="col-sx-1 col-sm-1 col-md-1 col-lg-1"></div>        
</section>

<section class="row container-fluid text-center">       
    <div class="col-sx-12 col-sm-12 col-md-12 col-lg-12 text-center">   
        <h1 class="text-header-g">7. Diagrama</h1>
        <h1 class="text-header-g">actividades</h1>
    </div>
</section>

<section class="row center-block">       
    <div class="col-sx-3 col-sm-3col-md-3 col-lg-3"></div>
    <div class="col-sx-6 col-sm-6 col-md-6 col-lg-6">

        <!-- D I A G   A C T I V I D A D E S -->
        <iframe src="../resources/docs/IngenieriaSoftware/Diagramas/6_DIAG_ACTIVIDADES/Dgs_actividades.pdf" style="width:100%;height:450px;" frameborder="0" allowfullscreen></iframe>
    </div>
    <div class="col-sx-3 col-sm-3 col-md-3 col-lg-3"></div>
</section>

<!-- ........................    BOTONES    .............................-->
<section class="row"><!-- ((((.. boton Descarga ..)))) -->
    <div class="col-sx-9 col-sm-9col-md-9 col-lg-9"></div>
    <div class="col-sx-1 col-sm-1 col-md-1 col-lg-1">



    </div>
    <div class="col-sx-2 col-sm-2 col-md-2 col-lg-2"></div>
</section>

<section class="row">
    <div class="col-sx-12 col-sm-12 col-md-12 col-lg-12" div-vacio">    </div>
</section>  

<!-- (((((((((((((((( boton regresar ))))))))))))))))-->
<section class="row pull-right">
    <div class="col-sx-1 col-sm-1 col-md-1 col-lg-1"></div>
    <div class="col-sx-11 col-sm-11 col-md-11 col-lg-11 pull-right">

        <p><!-- ((((.. boton Descarga ..)))) -->                
            <a href="../resources/docs/IngenieriaSoftware/Diagramas/6_DIAG_ACTIVIDADES/Dgs_actividades.pdf" download="Dgs_actividades.pdf" class="btn btn-info btn-md">
                <span class="glyphicon glyphicon-download-alt"></span>      
            </a>
        </p>

        <a href="fase2.jsp" class="btn btn-success"><span class="glyphicon glyphicon-circle-arrow-left "></span> Regresar</a>

    </div>
</section>

<section class="row">
    <div class="col-sx-12 col-sm-12 col-md-12 col-lg-12 div-vacio"> </div>
</section>  
<!-- ...................     FIN BOTONES    ......................-->
</div>
</section>


<!-- ***********************  (  8. ESTADO )  ************************ -->
<section id="Estado"></section>


<section class="row container-fluid">
    <div class="col-sx-1 col-sm-1 col-md-1 col-lg-1 margin-btn">    
        <a href="#Procesos" class="btn btn-success"><span class="glyphicon glyphicon-tag clear"></span> Proce.
        </a>        
    </div>
    <div class="col-sx-1 col-sm-1 col-md-1 col-lg-1">
        <a href="#flujo" class="btn btn-success margin-btn"><span class="glyphicon glyphicon-tag "></span> Flujo.
        </a>
    </div>

    <div class="col-sx-1 col-sm-1 col-md-1 col-lg-1 margin-btn">
        <a href="#caso_uso" class="btn btn-success"><span class="glyphicon glyphicon-tag "></span> C.uso
        </a>        
    </div>
    <div class="col-sx-1 col-sm-1 col-md-1 col-lg-1 margin-btn">
        <a href="#extendido" class="btn btn-success"><span class="glyphicon glyphicon-tag"></span> C.ext.
        </a>        
    </div>
    <div class="col-sx-1 col-sm-1 col-md-1 col-lg-1 margin-btn">
        <a href="#Entidad" class="btn btn-success"><span class="glyphicon glyphicon-tag"></span> Entid.
        </a>        
    </div>
    <div class="col-sx-1 col-sm-1 col-md-1 col-lg-1 margin-btn">
        <a href="#Clases" class="btn btn-success"><span class="glyphicon glyphicon-tag"></span> Clas.
        </a>        
    </div>
    <div class="col-sx-1 col-sm-1 col-md-1 col-lg-1 margin-btn">
        <a href="#Actividades" class="btn btn-success"><span class="glyphicon glyphicon-tag "></span> Activ.
        </a>        
    </div>

    <div class="col-sx-1 col-sm-1 col-md-1 col-lg-1 margin-btn">
        <a href="#Estado" class="btn btn-success margin-btn"><span class="glyphicon glyphicon-tag "></span> Esta.
        </a>        
    </div>
    <div class="col-sx-1 col-sm-1 col-md-1 col-lg-1 margin-btn">
        <a href="#Secuencia" class="btn btn-success"><span class="glyphicon glyphicon-tag "></span> Secu.
        </a>        
    </div>
    <div class="col-sx-1 col-sm-1 col-md-1 col-lg-1 margin-btn">
        <a href="#Comunicación" class="btn btn-success margin-btn"><span class="glyphicon glyphicon-tag "></span> Comun.
        </a>        
    </div>  
    <div class="col-sx-1 col-sm-1 col-md-1 col-lg-1">
        <div class="col-sx-1 col-sm-1 col-md-1 col-lg-1 margin-btn">
            <a href="#paquetes" class="btn btn-success margin-btn"><span class="glyphicon glyphicon-tag "></span> Paq.
            </a>    
        </div>  
    </div>  
    <div class="col-sx-1 col-sm-1 col-md-1 col-lg-1"></div>        
</section>  

<section class="row container-fluid text-center">       
    <div class="col-sx-12 col-sm-12 col-md-12 col-lg-12 text-center">   
        <h1 class="text-header-g">8. Diagrama</h1>
        <h1 class="text-header-g">estado</h1>
    </div>
</section>

<section class="row center-block">       
    <div class="col-sx-3 col-sm-3col-md-3 col-lg-3"></div>
    <div class="col-sx-6 col-sm-6 col-md-6 col-lg-6">

        <!-- D I A G   E S T A D O-->
        <iframe src="../resources/docs/IngenieriaSoftware/Diagramas/7_DIAG_ESTADO/Dgs_esta.pdf" style="width:100%;height:450px;" frameborder="0" allowfullscreen></iframe>
    </div>
    <div class="col-sx-3 col-sm-3 col-md-3 col-lg-3"></div>
</section>

<!-- ........................    BOTONES    .............................-->
<section class="row"><!-- ((((.. boton Descarga ..)))) -->
    <div class="col-sx-9 col-sm-9col-md-9 col-lg-9"></div>
    <div class="col-sx-1 col-sm-1 col-md-1 col-lg-1">



    </div>
    <div class="col-sx-2 col-sm-2 col-md-2 col-lg-2"></div>
</section>

<section class="row">
    <div class="col-sx-12 col-sm-12 col-md-12 col-lg-12 div-vacio">    </div>
</section>  

<!-- (((((((((((((((( boton regresar ))))))))))))))))-->
<section class="row pull-right">
    <div class="col-sx-1 col-sm-1 col-md-1 col-lg-1"></div>
    <div class="col-sx-11 col-sm-11 col-md-11 col-lg-11 pull-right">

        <p><!-- ((((.. boton Descarga ..)))) -->                
            <a href="../resources/docs/IngenieriaSoftware/Diagramas/7_DIAG_ESTADO/Dgs_esta.pdf" download="Dgs_estado.pdf" class="btn btn-info btn-md">
                <span class="glyphicon glyphicon-download-alt"></span>      
            </a>
        </p>

        <a href="fase2.jsp" class="btn btn-success"><span class="glyphicon glyphicon-circle-arrow-left "></span> Regresar</a>

    </div>
</section>

<section class="row">
    <div class="col-sx-12 col-sm-12 col-md-12 col-lg-12 div-vacio"> </div>
</section>  
<!-- ...................     FIN BOTONES    ......................-->
</div>
</section>      


<!-- ********************    (  9. SECUENCIA ) *********************** -->
<section id="Secuencia"></section>


<section class="row container-fluid">
    <div class="col-sx-1 col-sm-1 col-md-1 col-lg-1 margin-btn">    
        <a href="#Procesos" class="btn btn-success"><span class="glyphicon glyphicon-tag clear"></span> Proce.
        </a>        
    </div>
    <div class="col-sx-1 col-sm-1 col-md-1 col-lg-1">
        <a href="#flujo" class="btn btn-success margin-btn"><span class="glyphicon glyphicon-tag "></span> Flujo.
        </a>
    </div>

    <div class="col-sx-1 col-sm-1 col-md-1 col-lg-1 margin-btn">
        <a href="#caso_uso" class="btn btn-success"><span class="glyphicon glyphicon-tag "></span> C.uso
        </a>        
    </div>
    <div class="col-sx-1 col-sm-1 col-md-1 col-lg-1 margin-btn">
        <a href="#extendido" class="btn btn-success"><span class="glyphicon glyphicon-tag"></span> C.ext.
        </a>        
    </div>
    <div class="col-sx-1 col-sm-1 col-md-1 col-lg-1 margin-btn">
        <a href="#Entidad" class="btn btn-success"><span class="glyphicon glyphicon-tag"></span> Entid.
        </a>        
    </div>
    <div class="col-sx-1 col-sm-1 col-md-1 col-lg-1 margin-btn">
        <a href="#Clases" class="btn btn-success"><span class="glyphicon glyphicon-tag"></span> Clas.
        </a>        
    </div>
    <div class="col-sx-1 col-sm-1 col-md-1 col-lg-1 margin-btn">
        <a href="#Actividades" class="btn btn-success"><span class="glyphicon glyphicon-tag "></span> Activ.
        </a>        
    </div>

    <div class="col-sx-1 col-sm-1 col-md-1 col-lg-1 margin-btn">
        <a href="#Estado" class="btn btn-success margin-btn"><span class="glyphicon glyphicon-tag "></span> Esta.
        </a>        
    </div>
    <div class="col-sx-1 col-sm-1 col-md-1 col-lg-1 margin-btn">
        <a href="#Secuencia" class="btn btn-success"><span class="glyphicon glyphicon-tag "></span> Secu.
        </a>        
    </div>
    <div class="col-sx-1 col-sm-1 col-md-1 col-lg-1 margin-btn">
        <a href="#Comunicación" class="btn btn-success margin-btn"><span class="glyphicon glyphicon-tag "></span> Comun.
        </a>        
    </div>  
    <div class="col-sx-1 col-sm-1 col-md-1 col-lg-1">
        <div class="col-sx-1 col-sm-1 col-md-1 col-lg-1 margin-btn">
            <a href="#paquetes" class="btn btn-success margin-btn"><span class="glyphicon glyphicon-tag "></span> Paq.
            </a>    
        </div>  
    </div>  
    <div class="col-sx-1 col-sm-1 col-md-1 col-lg-1"></div>        
</section>

<section class="row container-fluid text-center">       
    <div class="col-sx-12 col-sm-12 col-md-12 col-lg-12 text-center">   
        <h1 class="text-header-g">9. Diagrama</h1>
        <h1 class="text-header-g">secuencia</h1>
    </div>
</section>

<section class="row center-block">       
    <div class="col-sx-3 col-sm-3col-md-3 col-lg-3"></div>
    <div class="col-sx-6 col-sm-6 col-md-6 col-lg-6">

        <!-- D I A G   S E C U E N C I A -->
        <iframe src="../resources/docs/IngenieriaSoftware/Diagramas/8_DIAG_SECUENCIA/Dgs_secuencia.pdf" style="width:100%;height:450px;" frameborder="0" allowfullscreen></iframe>
    </div>
    <div class="col-sx-3 col-sm-3 col-md-3 col-lg-3"></div>
</section>

<!-- ........................    BOTONES    .............................-->
<section class="row"><!-- ((((.. boton Descarga ..)))) -->
    <div class="col-sx-9 col-sm-9col-md-9 col-lg-9"></div>
    <div class="col-sx-1 col-sm-1 col-md-1 col-lg-1">



    </div>
    <div class="col-sx-2 col-sm-2 col-md-2 col-lg-2"></div>
</section>

<section class="row">
    <div class="col-sx-12 col-sm-12 col-md-12 col-lg-12" div-vacio">    </div>
</section>  

<!-- (((((((((((((((( boton regresar ))))))))))))))))-->
<section class="row pull-right">
    <div class="col-sx-1 col-sm-1 col-md-1 col-lg-1"></div>
    <div class="col-sx-11 col-sm-11 col-md-11 col-lg-11 pull-right">

        <p><!-- ((((.. boton Descarga ..)))) -->                
            <a href="../resources/docs/IngenieriaSoftware/Diagramas/8_DIAG_SECUENCIA/Dgs_secuencia.pdf" download="Dgs_secuencia.pdf" class="btn btn-info btn-md">
                <span class="glyphicon glyphicon-download-alt"></span>      
            </a>
        </p>

        <a href="fase2.`jsp" class="btn btn-success"><span class="glyphicon glyphicon-circle-arrow-left "></span> Regresar</a>

    </div>
</section>

<section class="row">
    <div class="col-sx-12 col-sm-12 col-md-12 col-lg-12 div-vacio"> </div>
</section>  
<!-- ...................     FIN BOTONES    ......................-->
</div>
</section>


<!-- ********************   (  10. COMUNICACION ) *********************** -->
<section id="Comunicación"></section>


<section class="row container-fluid">
    <div class="col-sx-1 col-sm-1 col-md-1 col-lg-1 margin-btn">    
        <a href="#Procesos" class="btn btn-success"><span class="glyphicon glyphicon-tag clear"></span> Proce.
        </a>        
    </div>
    <div class="col-sx-1 col-sm-1 col-md-1 col-lg-1">
        <a href="#flujo" class="btn btn-success margin-btn"><span class="glyphicon glyphicon-tag "></span> Flujo.
        </a>
    </div>

    <div class="col-sx-1 col-sm-1 col-md-1 col-lg-1 margin-btn">
        <a href="#caso_uso" class="btn btn-success"><span class="glyphicon glyphicon-tag "></span> C.uso
        </a>        
    </div>
    <div class="col-sx-1 col-sm-1 col-md-1 col-lg-1 margin-btn">
        <a href="#extendido" class="btn btn-success"><span class="glyphicon glyphicon-tag"></span> C.ext.
        </a>        
    </div>
    <div class="col-sx-1 col-sm-1 col-md-1 col-lg-1 margin-btn">
        <a href="#Entidad" class="btn btn-success"><span class="glyphicon glyphicon-tag"></span> Entid.
        </a>        
    </div>
    <div class="col-sx-1 col-sm-1 col-md-1 col-lg-1 margin-btn">
        <a href="#Clases" class="btn btn-success"><span class="glyphicon glyphicon-tag"></span> Clas.
        </a>        
    </div>
    <div class="col-sx-1 col-sm-1 col-md-1 col-lg-1 margin-btn">
        <a href="#Actividades" class="btn btn-success"><span class="glyphicon glyphicon-tag "></span> Activ.
        </a>        
    </div>

    <div class="col-sx-1 col-sm-1 col-md-1 col-lg-1 margin-btn">
        <a href="#Estado" class="btn btn-success margin-btn"><span class="glyphicon glyphicon-tag "></span> Esta.
        </a>        
    </div>
    <div class="col-sx-1 col-sm-1 col-md-1 col-lg-1 margin-btn">
        <a href="#Secuencia" class="btn btn-success"><span class="glyphicon glyphicon-tag "></span> Secu.
        </a>        
    </div>
    <div class="col-sx-1 col-sm-1 col-md-1 col-lg-1 margin-btn">
        <a href="#Comunicación" class="btn btn-success margin-btn"><span class="glyphicon glyphicon-tag "></span> Comun.
        </a>        
    </div>  
    <div class="col-sx-1 col-sm-1 col-md-1 col-lg-1">
        <div class="col-sx-1 col-sm-1 col-md-1 col-lg-1 margin-btn">
            <a href="#paquetes" class="btn btn-success margin-btn"><span class="glyphicon glyphicon-tag "></span> Paq.
            </a>    
        </div>  
    </div>  
    <div class="col-sx-1 col-sm-1 col-md-1 col-lg-1"></div>        
</section>

<section class="row container-fluid text-center">       
    <div class="col-sx-12 col-sm-12 col-md-12 col-lg-12 text-center">   
        <h1 class="text-header-g">10. Diagrama</h1>
        <h1 class="text-header-g">comunicación</h1>
    </div>
</section>

<section class="row center-block">       
    <div class="col-sx-3 col-sm-3col-md-3 col-lg-3"></div>
    <div class="col-sx-6 col-sm-6 col-md-6 col-lg-6">

        <iframe src="../resources/docs/IngenieriaSoftware/Diagramas/9_DIAG_COMUNICACION/Dgs_comunicacion.pdf" style="width:100%;height:450px;" frameborder="0" allowfullscreen></iframe>

    </div>
    <div class="col-sx-3 col-sm-3 col-md-3 col-lg-3"></div>
</section>

<!-- ........................    BOTONES    .............................-->
<section class="row"><!-- ((((.. boton Descarga ..)))) -->
    <div class="col-sx-9 col-sm-9col-md-9 col-lg-9"></div>
    <div class="col-sx-1 col-sm-1 col-md-1 col-lg-1">


    </div>
    <div class="col-sx-2 col-sm-2 col-md-2 col-lg-2"></div>
</section>

<section class="row">
    <div class="col-sx-12 col-sm-12 col-md-12 col-lg-12" div-vacio">    </div>
</section>  

<!-- (((((((((((((((( boton regresar ))))))))))))))))-->
<section class="row pull-right">
    <div class="col-sx-1 col-sm-1 col-md-1 col-lg-1"></div>
    <div class="col-sx-11 col-sm-11 col-md-11 col-lg-11 pull-right">

        <p><!-- ((((.. boton Descarga ..)))) -->                
            <a href="../resources/docs/IngenieriaSoftware/Diagramas/9_DIAG_COMUNICACION/Dgs_comunicacion.pdf" download="Dgs_comunicacion.pdf" class="btn btn-info btn-md">
                <span class="glyphicon glyphicon-download-alt"></span>      
            </a>
        </p>


        <a href="fase2.jsp" class="btn btn-success"><span class="glyphicon glyphicon-circle-arrow-left "></span> Regresar</a>

    </div>
</section>

<section class="row">
    <div class="col-sx-12 col-sm-12 col-md-12 col-lg-12 div-vacio"> </div>
</section>  
<!-- ...................     FIN BOTONES    ......................-->


<!-- ********************   (  11. PAQUETES ) *********************** -->
<section id="paquetes"></section>


<section class="row container-fluid">
    <div class="col-sx-1 col-sm-1 col-md-1 col-lg-1 margin-btn">    
        <a href="#Procesos" class="btn btn-success"><span class="glyphicon glyphicon-tag clear"></span> Proce.
        </a>        
    </div>
    <div class="col-sx-1 col-sm-1 col-md-1 col-lg-1">
        <a href="#flujo" class="btn btn-success margin-btn"><span class="glyphicon glyphicon-tag "></span> Flujo.
        </a>
    </div>

    <div class="col-sx-1 col-sm-1 col-md-1 col-lg-1 margin-btn">
        <a href="#caso_uso" class="btn btn-success"><span class="glyphicon glyphicon-tag "></span> C.uso
        </a>        
    </div>
    <div class="col-sx-1 col-sm-1 col-md-1 col-lg-1 margin-btn">
        <a href="#extendido" class="btn btn-success"><span class="glyphicon glyphicon-tag"></span> C.ext.
        </a>        
    </div>
    <div class="col-sx-1 col-sm-1 col-md-1 col-lg-1 margin-btn">
        <a href="#Entidad" class="btn btn-success"><span class="glyphicon glyphicon-tag"></span> Entid.
        </a>        
    </div>
    <div class="col-sx-1 col-sm-1 col-md-1 col-lg-1 margin-btn">
        <a href="#Clases" class="btn btn-success"><span class="glyphicon glyphicon-tag"></span> Clas.
        </a>        
    </div>
    <div class="col-sx-1 col-sm-1 col-md-1 col-lg-1 margin-btn">
        <a href="#Actividades" class="btn btn-success"><span class="glyphicon glyphicon-tag "></span> Activ.
        </a>        
    </div>

    <div class="col-sx-1 col-sm-1 col-md-1 col-lg-1 margin-btn">
        <a href="#Estado" class="btn btn-success margin-btn"><span class="glyphicon glyphicon-tag "></span> Esta.
        </a>        
    </div>
    <div class="col-sx-1 col-sm-1 col-md-1 col-lg-1 margin-btn">
        <a href="#Secuencia" class="btn btn-success"><span class="glyphicon glyphicon-tag "></span> Secu.
        </a>        
    </div>
    <div class="col-sx-1 col-sm-1 col-md-1 col-lg-1 margin-btn">
        <a href="#Comunicación" class="btn btn-success margin-btn"><span class="glyphicon glyphicon-tag "></span> Comun.
        </a>        
    </div>  
    <div class="col-sx-1 col-sm-1 col-md-1 col-lg-1">
        <div class="col-sx-1 col-sm-1 col-md-1 col-lg-1 margin-btn">
            <a href="#paquetes" class="btn btn-success margin-btn"><span class="glyphicon glyphicon-tag "></span> Paq.
            </a>    
        </div>  
    </div>  
    <div class="col-sx-1 col-sm-1 col-md-1 col-lg-1"></div>        
</section>

<section class="row container-fluid text-center">       
    <div class="col-sx-12 col-sm-12 col-md-12 col-lg-12 text-center">   
        <h1 class="text-header-g">11. Diagrama</h1>
        <h1 class="text-header-g">Paquetes</h1>
    </div>
</section>

<section class="row center-block">       
    <div class="col-sx-3 col-sm-3col-md-3 col-lg-3"></div>
    <div class="col-sx-6 col-sm-6 col-md-6 col-lg-6">

        <iframe src="../resources/docs/IngenieriaSoftware/Diagramas/11_DIAG_PAQUETES/Dgs_paquete.pdf" style="width:100%;height:450px;" frameborder="0" allowfullscreen></iframe>

    </div>
    <div class="col-sx-3 col-sm-3 col-md-3 col-lg-3"></div>
</section>

<!-- ........................    BOTONES    .............................-->
<section class="row"><!-- ((((.. boton Descarga ..)))) -->
    <div class="col-sx-9 col-sm-9col-md-9 col-lg-9"></div>
    <div class="col-sx-1 col-sm-1 col-md-1 col-lg-1">


    </div>
    <div class="col-sx-2 col-sm-2 col-md-2 col-lg-2"></div>
</section>

<section class="row">
    <div class="col-sx-12 col-sm-12 col-md-12 col-lg-12" div-vacio">    </div>
</section>  

<!-- (((((((((((((((( boton regresar ))))))))))))))))-->
<section class="row pull-right">
    <div class="col-sx-1 col-sm-1 col-md-1 col-lg-1"></div>
    <div class="col-sx-11 col-sm-11 col-md-11 col-lg-11 pull-right">

        <p><!-- ((((.. boton Descarga ..)))) -->                
            <a href="../resources/docs/IngenieriaSoftware/Diagramas/11_DIAG_PAQUETES/Dgs_paquete.pdf" download="Dgs_paquetes.pdf" class="btn btn-info btn-md">
                <span class="glyphicon glyphicon-download-alt"></span>      
            </a>
        </p>


        <a href="fase2.jsp" class="btn btn-success"><span class="glyphicon glyphicon-circle-arrow-left "></span> Regresar</a>

    </div>
</section>

<section class="row">
    <div class="col-sx-12 col-sm-12 col-md-12 col-lg-12 div-vacio"> </div>
</section>  
<!-- ...................     FIN BOTONES    ......................-->
</div>
</section>
        
        <%@include file="../template/jsp/footer.jsp" %>
    </body>
</html>
