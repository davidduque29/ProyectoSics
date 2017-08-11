$().ready(function(){
			$('#button').click(function(){

			var email=$('#email').val();
			var nombres=$('#nombres').val();
			var apellidos=$('#apellidos').val();
			var cargo=$('#cargo').val();
			var comentarios=$('#comentarios').val();

			console.log('Email: '+email+' / Nombres: '+nombres+' / Apellidos: '+apellidos+' / Cargo: '+cargo+' / Comentarios: '+comentarios);

		
				if (email == '') {

					swal({
						title: "Campo requerido",	
						type: "info",
						text: "Por favor ingrese un email.",
						confirmButtonColor: "#337ab7",
						confirmButtonText: "Ok",				
					});
				}else if($("#email").val().indexOf('@', 0) == -1 || $("#email").val().indexOf('.', 0) == -1) {
						swal({
						title: "Campo requerido",	
						type: "info",
						text: "Faltan datos al correo.",
						confirmButtonColor: "#337ab7",
						confirmButtonText: "Ok",				
					});
				}else if(cargo == ''){
						swal({
						title: "Campo requerido",	
						type: "info",
						text: "Por favor ingrese un cargo.",
						confirmButtonColor: "#337ab7",
						confirmButtonText: "Ok",				
					});
				}else if(comentarios == ''){
						swal({
						title: "Campo requerido",	
						type: "info",
						text: "Por favor ingrese un comentario.",
						confirmButtonColor: "#337ab7",
						confirmButtonText: "Ok",				
					});
				}else{
					swal('::Envio exitoso..::');
					// alert(':: Envio exitoso ::')
				}							
			});
		});// fin ready
		