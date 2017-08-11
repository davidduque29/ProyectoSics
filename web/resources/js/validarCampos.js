$().ready(function(){
			$('#vacio').click(function(){

			var cedula=$('#idUsuario').val();
			

			console.log('Cedula: '+cedula);

		
				if (cedula === ''){
						swal({
						title: "Campo requerido",	
						type: "success",
						text: "Por favor ingrese su cédula.",
						confirmButtonColor: "#337ab7",
						confirmButtonText: "Ok"				
					});
				
				}else{
					alert(':::: Envio exitoso ::::');
				}				
			});// fin click	
});// fin ready
