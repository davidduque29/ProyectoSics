<!-- Metadatos -->
	<meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
	<meta name="description" content="Sistema de Información">
	<meta name="keywords" content="html5, css3, diseño web">
	
	<!-- Estilos -->
	<link rel="shortcut icon" href="../resources/imgs/Favicon/FAVICON_70X74-SICS9.png">
	<link rel="stylesheet" href="../resources/css/estilos1.css">
	<link rel="stylesheet" href="../resources/css/fase2_cont.css">
	<link rel="stylesheet" href="../resources/css/estilo_fase2.css">
	<link rel="stylesheet" href="../resources/css/fuentes.css">
	<link rel="stylesheet" href="../resources/css/toog.js.css">
	<link rel="stylesheet" href="../resources/css/bootstrap.min.css">
	<link rel="stylesheet" href="../resources/css/font-awesome.min.css">
	<link rel="stylesheet" href="../resources/css/sweetalert.css">

	<!-- SCRIPTS -->
		<!-- funciona para la barra de navegacion -->
  		<script src="../resources/js/jquery-2.2.3.js"></script>
  		<script src="../resources/js/bootstrap.min.js"></script>
  		<!-- fin funcion para la barra de navegacion -->
  		<script src="../resources/js/sweetalert.min.js"></script>

<script>
	$().ready(function(){
			$('a[id="#vacio"]').click(function(){
				swal({

					title: "DESHABILITADO",

					
					type: "warning",
					text: "No contiene datos",
					confirmButtonColor: "#DD6B55",
					confirmButtonText: "Ok",
				
					
				},
				function(isConfirm){
				});
			});
		});
</script>
