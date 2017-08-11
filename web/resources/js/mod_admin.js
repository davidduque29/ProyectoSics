$().ready(function(){

			$('#button').click(function(){

			
			var nombre1=$('#nombre1').val();
			var nombre2=$('#nombre2').val();
			var apellido1=$('#apellido1').val();
			var apellido2=$('#apellido2').val();
			var rol=$('#rol').val();
			var func=$("#rol").change(function(){
            			var valor=$("#rol").val();
            			var texto=$("#rol option:selected").text();
            			$("#valorSeleccionado").html(valor+" - "+texto);
       				 });
			var estado=$('#estado').val();
			var cedula=$('#cedula').val();
			var clave=$('#clave').val();
			var email=$('#email').val();
			var cargo=$('#cargo').val();

			console.log('Email: '+email+' / Nombre1: '+nombre1+' / Nombre2: '+nombre2+
				     ' / Apellido1: '+apellido1+' / Apellido2: '+apellido2+
				     ' / cedula: '+cedula+' / Rol: '+rol+
				     ' / Estado: '+estado+' / Cargo: '+cargo);

		
				if (nombre1 == '' || nombre2 == '') {

					swal({
						title: "Campo requerido",	
						type: "info",
						text: "Por favor ingrese un nombre.",
						confirmButtonColor: "#337ab7",
						confirmButtonText: "Ok",				
					});
					}else if(apellido1 == '' || apellido2 == ''){
						swal({
						title: "Campo requerido",	
						type: "info",
						text: "Por favor ingrese un apellido.",
						confirmButtonColor: "#337ab7",
						confirmButtonText: "Ok",				
					});
					// }else if(rol != func){
					// 	swal({
					// 	title: "Campo requerido",	
					// 	type: "info",
					// 	text: "Por favor escoja una opción.",
					// 	confirmButtonColor: "#337ab7",
					// 	confirmButtonText: "Ok",				
					// });
					}else if(cedula == ''){
						swal({
						title: "Campo requerido",	
						type: "info",
						text: "Por favor ingrese un número de cédula.",
						confirmButtonColor: "#337ab7",
						confirmButtonText: "Ok",				
					});
					}else if(email == ''){
						swal({
						title: "Campo requerido",	
						type: "info",
						text: "Por favor ingrese un email.",
						confirmButtonColor: "#337ab7",
						confirmButtonText: "Ok",				
					});
					}else if(clave == ''){
						swal({
						title: "Campo requerido",	
						type: "info",
						text: "Por favor ingrese una contraseña.",
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
					}else{
					// swal('Enviando datos..');
					alert(':: Registro exitoso ::')
				}							
			});// fin clikc

// :::::::::::::::: boton consultar ::::::::::

			$('#btnConsult').click(function(){

			
			var nombre1=$('#nombre1').val();
			var nombre2=$('#nombre2').val();
			var apellido1=$('#apellido1').val();
			var apellido2=$('#apellido2').val();
			var rol=$('#rol').val();
			var func=$("#rol").change(function(){
            			var valor=$("#rol").val();
            			var texto=$("#rol option:selected").text();
            			$("#valorSeleccionado").html(valor+" - "+texto);
       				 });
			var estado=$('#estado').val();
			var cedula=$('#cedula').val();
			var clave=$('#clave').val();
			var email=$('#email').val();
			var cargo=$('#cargo').val();

			console.log('Email: '+email+' / Nombre1: '+nombre1+' / Nombre2: '+nombre2+
				     ' / Apellido1: '+apellido1+' / Apellido2: '+apellido2+
				     ' / cedula: '+cedula+' / Rol: '+rol+
				     ' / Estado: '+estado+' / Cargo: '+cargo);

		
				if (nombre1 == '' || nombre2 == '') {

					swal({
						title: "Campo requerido",	
						type: "info",
						text: "Por favor ingrese un nombre.",
						confirmButtonColor: "#337ab7",
						confirmButtonText: "Ok",				
					});
					}else if(apellido1 == '' || apellido2 == ''){
						swal({
						title: "Campo requerido",	
						type: "info",
						text: "Por favor ingrese un apellido.",
						confirmButtonColor: "#337ab7",
						confirmButtonText: "Ok",				
					});
					}else if(cedula == ''){
						swal({
						title: "Campo requerido",	
						type: "info",
						text: "Por favor ingrese un número de cédula.",
						confirmButtonColor: "#337ab7",
						confirmButtonText: "Ok",				
					});
					}else if(email == ''){
						swal({
						title: "Campo requerido",	
						type: "info",
						text: "Por favor ingrese un email.",
						confirmButtonColor: "#337ab7",
						confirmButtonText: "Ok",				
					});
					}else if(rol != func){
						swal({
						title: "Campo requerido",	
						type: "info",
						text: "Por favor escoja una opción.",
						confirmButtonColor: "#337ab7",
						confirmButtonText: "Ok",				
					});
					}else if(clave == ''){
						swal({
						title: "Campo requerido",	
						type: "info",
						text: "Por favor ingrese una contraseña.",
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
					}else{
					// swal('Enviando datos..');
					alert(':: Registro exitoso ::')
				}							
			});// fin clikc

// :::::::::::::::: boton actualizar::::::::::

		$('#btnUpdate').click(function(){
	
			var nombre1=$('#nombre1').val();
			var nombre2=$('#nombre2').val();
			var apellido1=$('#apellido1').val();
			var apellido2=$('#apellido2').val();
			var rol=$('#rol').val();
			var estado=$('#estado').val();
			var cedula=$('#cedula').val();
			var clave=$('#clave').val();
			var email=$('#email').val();
			var cargo=$('#cargo').val();

			console.log('Email: '+email+' / Nombre1: '+nombre1+' / Nombre2: '+nombre2+
				     ' / Apellido1: '+apellido1+' / Apellido2: '+apellido2+
				     ' / cedula: '+cedula+' / Rol: '+rol+
				     ' / Estado: '+estado+' / Cargo: '+cargo);

					if (nombre1 == '' || nombre2 == '' || apellido1 == '' || apellido2 == '' 
						|| rol == '' || estado == '' || cedula == '' || clave == '' ||
						 email == '' || cargo == '') {

						swal({
						  title: ":: ¡Actualizado! ::",
						  text: "..............",
						  timer: 2000,
						  showConfirmButton: false
						});

					}else{
						alert(':: Actualizacion exitosa ::');
						// swal({
						//   title: ":: Actualización exitosa ::",
						//   text: "..............",
						//   timer: 2000,
						//   showConfirmButton: false
						// });
					}
					
				// alert(':: Actualizacion exitosa ::')									
			});// fin clikc

// :::::::::::::::: boton Eliminar::::::::::

		$('#btnDelete').click(function(){
	
			var idUsuario=$('#cedula').val();
			var email=$('#email').val();


			console.log('Email: '+email+
				     ' / cedula: '+cedula);

		if (idUsuario == '') {

					swal({
						title: "Campo requerido",	
						type: "info",
						text: "¡No se ha seleccionado ningún dato!",
						text: "Ingrese un número de cédula.",
						confirmButtonColor: "#337ab7",
						confirmButtonText: "Ok",				
					});
					}else{
						alert(':: Eliminación exitosa ::')	
						// swal({
						//   title: ":: Eliminación exitosa ::",
						//   text: "..............",
						//   timer: 2000,
						//   showConfirmButton: false
						// });
					}// fin else

												
			});// fin clikc
				$('#btnProd').click(function(){
	
			var Formula=$('#Formula').val();
			var codFormula=$('#codFormula').val();
			var Descripcion=$('#Descripcion').val();
			
			console.log('Formula: '+Formula+' / codFormula: '+codFormula+' / Descripcion: '+Descripcion);

		
					if (Formula == '' || codFormula == '' || Descripcion == '') {

					swal({
						title: "Campo requerido",	
						type: "info",
						text: "¡No se ha ingresado ningún dato!",
						text: "Ingrese un número de cédula.",
						confirmButtonColor: "#337ab7",
						confirmButtonText: "Ok",				
					});
					}else{
						alert(':: Registro exitoso ::')	
						// swal({
						//   title: ":: Eliminación exitosa ::",
						//   text: "..............",
						//   timer: 2000,
						//   showConfirmButton: false
						// });
					}// fin else
				// alert(':: Actualizacion exitosa ::')									
			});// fin clikc
			
		});// fin ready