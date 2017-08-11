$().ready(function(){

					
			$('#button1').click(function(){
				
			var Codigo=$('#Codigo').val();
			var Cantidad=$('#Cantidad').val();
			var Marca=$('#Marca').val();
			var Peso=$('#Peso').val();
			var Ancho=$('#Ancho').val();
			var Alto=$('#Alto').val();
			var Descripción=$('#Descripción').val();
				

			console.log( ' Codigo: '+Codigo+'/ Cantidad: '+Cantidad+'  / Marca: '+Marca+
				     ' / Peso: '+Peso+' / Ancho: '+Ancho+' / Alto: '+Alto+' /Descripción: '+Descripción);
		
				if (Codigo == '') {

					swal({
						title: "Campo requerido",	
						type: "info",
						text: "Por favor ingrese Codigo.",
						confirmButtonColor: "#337ab7",
						confirmButtonText: "Ok",				
					});
					}else if(Cantidad == '' ){
						swal({
						title: "Campo requerido",	
						type: "info",
						text: "Por favor ingrese Cantidad.",
						confirmButtonColor: "#337ab7",
						confirmButtonText: "Ok",				
					});
					
					}else if(Marca == ''){
						swal({
						title: "Campo requerido",	
						type: "info",
						text: "Por favor ingrese Marca",
						confirmButtonColor: "#337ab7",
						confirmButtonText: "Ok",				
					});
					}else if(Peso == ''){
						swal({
						title: "Campo requerido",	
						type: "info",
						text: "Por favor ingrese Peso.",
						confirmButtonColor: "#337ab7",
						confirmButtonText: "Ok",				
					});
					}else if(Ancho == ''){
						swal({
						title: "Campo requerido",	
						type: "info",
						text: "Por favor ingrese Ancho.",
						confirmButtonColor: "#337ab7",
						confirmButtonText: "Ok",				
					});
					}else if(Alto == ''){
						swal({
						title: "Campo requerido",	
						type: "info",
						text: "Por favor ingrese un Alto.",
						confirmButtonColor: "#337ab7",
						confirmButtonText: "Ok",				
					});
					}else if(Descripción == ''){
						swal({
						title: "Campo requerido",	
						type: "info",
						text: "Por favor ingrese Descripción.",
						confirmButtonColor: "#337ab7",
						confirmButtonText: "Ok",				
					});
					}else{
					alert(':: Registro exitoso ::')
				}							
			});// fin clikc

// :::::::::::::::: procesos ::::::::::

			$('#button2').click(function(){

			
			var Codigo=$('#Codigo').val();
			var nombre=$('#nombre').val();
			var Marca=$('#Marca').val();
			

			console.log('Codigo: '+Codigo+' / Nombre: '+nombre+' / Marca: '+Marca);

		
				if (Codigo == '' ) {

					swal({
						title: "Campo requerido",	
						type: "info",
						text: "Por favor ingrese  Codigo.",
						confirmButtonColor: "#337ab7",
						confirmButtonText: "Ok",				
					});
					}else if(nombre == '' ){
						swal({
						title: "Campo requerido",	
						type: "info",
						text: "Por favor ingrese  nombre.",
						confirmButtonColor: "#337ab7",
						confirmButtonText: "Ok",				
					});
					}else if(Marca == ''){
						swal({
						title: "Campo requerido",	
						type: "info",
						text: "Por favor ingrese Marca.",
						confirmButtonColor: "#337ab7",
						confirmButtonText: "Ok",				
					});
					
					}else{
					alert(':: Registro exitoso ::')
				}							
			});// fin clikc



// :::::::::::::::: consultar ::::::::::

			$('#button3').click(function(){

			
			var Codigo=$('#Codigo').val();
			var nombre=$('#nombre').val();
			
			

			console.log('Codigo: '+Codigo+' / Nombre: '+nombre);

		
				if (Codigo == '' ) {

					swal({
						title: "Campo requerido",	
						type: "info",
						text: "Por favor ingrese  Codigo.",
						confirmButtonColor: "#337ab7",
						confirmButtonText: "Ok",				
					});
					}else if(nombre == '' ){
						swal({
						title: "Campo requerido",	
						type: "info",
						text: "Por favor ingrese  nombre.",
						confirmButtonColor: "#337ab7",
						confirmButtonText: "Ok",				
					});
					
					}else{
					alert(':: Registro exitoso ::')
				}							
			});// fin clikc



// :::::::::::::::: calidad::::::::::


		$('#button4').click(function(){

			
			var Codigo=$('#Codigo').val();
			var Descripción=$('#Descripción').val();
			var Cantidad=$('#Cantidad').val();
			
			

			console.log('Codigo: '+Codigo+' / Descripción: '+Descripción+' / Cantidad: '+Cantidad);

		
				if (Codigo == '' ) {

					swal({
						title: "Campo requerido",	
						type: "info",
						text: "Por favor ingrese  Codigo.",
						confirmButtonColor: "#337ab7",
						confirmButtonText: "Ok",				
					});
					}else if(Descripción == '' ){
						swal({
						title: "Campo requerido",	
						type: "info",
						text: "Por favor ingrese  Descripción.",
						confirmButtonColor: "#337ab7",
						confirmButtonText: "Ok",				
					});
						}else if(Cantidad == '' ){
						swal({
						title: "Campo requerido",	
						type: "info",
						text: "Por favor ingrese  Cantidad.",
						confirmButtonColor: "#337ab7",
						confirmButtonText: "Ok",				
					});
					
					}else{
					
					alert(':: Registro exitoso ::')
				}							
			});// fin clikc
		});// fin ready

