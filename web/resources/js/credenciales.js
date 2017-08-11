	$().ready(function(){
		$('button[type="submit"]').click(function(e){
			e.preventDefault();
			usuario = $('#email').val();
			contraseña = $('#contraseña').val();
			console.log(usuario+','+contraseña); //Muestra el resultado en consola.
			if(usuario == 'ivduque@hotmail.com' && contraseña == '11111'){


				console.log(usuario+','+contraseña);
				window.location.href = 'mod_administrador.html';
			}else if($("#email").val().indexOf('@', 0) == -1 || $("#email").val().indexOf('.', 0) == -1) {
						swal({
						title: "Campo requerido",	
						type: "info",
						text: "Faltan datos al correo.",
						confirmButtonColor: "#337ab7",
						confirmButtonText: "Ok",				
					});
			} else if(usuario == 'ivduque@hotmail.com' && contraseña == '22222'){
				// attr = Atributo jQuery submit form
				$('#formulario').attr('action', 'mod_lider.html');
				$('#formulario').submit();
			} else if(usuario == 'ivduque@hotmail.com' && contraseña == '33333'){
				// attr = Atributo jQuery submit form
				$('#formulario').attr('action', 'mod_planeador.html');
				$('#formulario').submit();
			}else if(usuario == 'ivduque@hotmail.com' && contraseña == '44444'){
				// attr = Atributo jQuery submit form
				$('#formulario').attr('action', 'mod_gestor.html');
				$('#formulario').submit();
			} else if(usuario == ''){
				// attr = Atributo jQuery submit form
				
								swal({
					title: " Por favor llene el campo",
					text: "NO se admite campos vacios.",
					type: "warning",
					// showCancelButton: true,
					confirmButtonColor: "#DD6B55",
					confirmButtonText: "Ok",
					// cancelButtonText: "No, cancelar",
					closeOnConfirm: false,
					closeOnCancel: false

				});
			} else if(contraseña == ''){
				// attr = Atributo jQuery submit form
				
								swal({
					title: " Por favor llene el campo",
					text: "NO se admite campos vacios.",
					type: "warning",
					// showCancelButton: true,
					confirmButtonColor: "#DD6B55",
					confirmButtonText: "Ok",
					// cancelButtonText: "No, cancelar",
					closeOnConfirm: false,
					closeOnCancel: false

				});
			} else {
								swal({
					title: "Usuario o contraseña ...",
					text: "no son válidos.",
					type: "warning",
					showCancelButton: false,
					cancelButtonColor: "#DD6B55",
					confirmButtonText: "OK",
					closeOnCancel: true
				},
				function(isConfirm){
					if (isConfirm) {
						swal("Deleted!", "Your imaginary file has been deleted.", "success");
					} else {
						swal("Cancelled", "Your imaginary file is safe :)", "error");
					}
				});
				// alert('Usuario o contraseña no son válidos');
			}
		});
	});
	$().ready(function(){
			$('#claves').click(function(){
				swal({

					title: "CREDENCIALES",

					
					type: "success",
					text: "Clave:11111 - Admin Clave:22222 - Lider Clave:33333 - planeador Clave:44444 - Gestor",
					confirmButtonColor: "#337ab7",
					confirmButtonText: "Ok",
	
					
				});
				
			});// fin click	
		});// fin ready