<!doctype html>
<html lang="en">
<head>
   <meta charset="utf-8">
   <title>Administrador de personas</title>
  <link rel="stylesheet" href="jquery-ui-1.11.3.custom/jquery-ui.min.css">
  <script src="jquery-ui-1.11.3.custom/external/jquery/jquery.js"></script>
  <script src="jquery-ui-1.11.3.custom/jquery-ui.min.js"></script>
	
  <link rel="stylesheet" href="jquery-validation-1.13.1/demo/css/screen.css">	
  <script src="jquery-validation-1.13.1/dist/jquery.validate.js"></script>
</head>
<script>
   $(function() {
     $( "#Panelesdelaaplicacion" ).tabs();
   });
   $().ready(function() {
       // validate signup form on keyup and submit
      $("#formulariodeingreso").validate({
   rules: {
      apellido: {
	     required: true, 
	  },
      email: {
	     email: true
	  },
	     agree: "required"
      usuario: {
	  },
      contraseña: {
	     required: true, 
	  },
      confirm_contraseña: {
	     required: true, 
	     equalTo: "#contraseña"
	  },
      nombre: {
	     required: true, 
	  },
   },
   $().ready(function() {
       // validate signup form on keyup and submit
      $("#formulariodeeliminacion").validate({
   rules: {
      iddelapersona: {
	     digits: true, 
	  },
   },
   messages: {
      apellido: {
	     required: "Por favor ingrese un Apellido",
	  },
      email: {
	     email: "Por favor ingrese una direcci&oacuten de email valida"
	  },
	     agree: "Favor aceptar nuestra pol&iacutetica de acuerdo"               
      usuario: {
	  },
      contraseña: {
	     required: "Por favor ingrese un Contraseña", 

	  },
      confirm_contraseña: {
	     required: "Por favor ingrese un Contraseña", 
	     equalTo: "Por favor ingrese el mismo password"
	  },
      nombre: {
	     required: "Por favor ingrese un Nombre",
	  },
   },
   });
});
   messages: {
      iddelapersona: {
	     digits: "Por favor ingresesolamente digitos del 0 al 9",
	     maxlength: "El id de la persona debe tener como m&aacuteximo 10 caracteres de longitud",
	  },
   },
   });
});

    $(function() {
       $( document ).tooltip();
    });	        		  
	$(function() {
    $.ajax({
       url: "paises.xml",
       dataType: "xml",
       success: function( xmlResponse ) {
       var data = $( "tag", xmlResponse ).map(function() {
          return {
             value: $( "name", this ).text(),
             id: $( "tagId", this ).text()
          };
       }).get();
          $( "#paisdeorigen" ).autocomplete({
             source: data,
          });
       }
    });
    });					  										 
    $(function() {
       $( "#fechadenacimiento" ).datepicker({
	      changeYear: true, 
	      changeMonth: true, 
		  yearRange: "1960:2015",
		  dateFormat: "yy-mm-dd"
       });
    });   						    				  
    $(function() {
       $( document ).tooltip();
    });	        		  
</script>  

<body>
<div id="Panelesdelaaplicacion">
   <ul>      
      <li><a href="#Formulariodeingreso">Formulario de ingreso</a></li>
      <li><a href="#MostrarDatosPersonales">Mostrar Datos Personales</a></li>
      <li><a href="#Formulariodeeliminacion">Formulario de eliminacion</a></li>
   </ul>
   <div id ="Formulariodeingreso" >
   <form id="formulariodeingreso" method="POST" action="Agregar.php"> 
	  <p>
	     <label for="apellido">Apellido</label>
		 <input id="apellido" name="apellido" type="text"  title="Ingrese apellido completo"></br>
	  </p>
	  <p>
	     <label for="email">Email</label>
		 <input id="email" name="email" type="email" ></br> 
	  </p>
	  <fieldset> 
	      <legend>Genero</legend>
		  <label for="masculino">		 
  	         <input type="radio" id="masculino" name="genero" value="masculino" required>Masculino                  
		  </label>
		  <label for="femenino">		 
  	         <input type="radio" id=" femenino" name="genero" value=" femenino" > femenino                  
		  </label>
   	  </fieldset>					 			 
      <p>
         <label for="paisdeorigen">Pais de origen</label>
         <input id="paisdeorigen" type="text" name="paisdeorigen">
      </p>    					 
      <p>Fecha de nacimiento <input type="text" id="fechadenacimiento" name="fechadenacimiento" ></p>				 				 
	  <p>
	     <input  type="submit" value="Agregar">
	  </p>
	  <p>
         <label for="confirmaciondedatos">Confirmacion de datos</label>
	     <input type="checkbox" id="confirmaciondedatos" name="confirmaciondedatos">
	  </p>
				  
	  <p>
	     <label for="usuario">Usuario</label>
		 <input id="usuario" name="usuario" type="text" ></br>
	  </p>
	  <p>
	     <label for="contraseña">Contraseña</label>
	     <input id="contraseña" name="contraseña" type="password"  title="La contraseña debe tener al menos 8 caracteres"></br>          
	  </p>
	  <p>
	     <label for="confirm_contraseña">Confirm Contraseña</label>
		 <input id="confirm_contraseña" name="contraseña" type="password" 
	  </p>
	  <p>
	     <label for="nombre">Nombre</label>
		 <input id="nombre" name="nombre" type="text"  title="Ingrese su nombre completo"></br>
	  </p>
   </form> 
   </div>
   <div id ="MostrarDatosPersonales" >
   </div>
   <div id ="Formulariodeeliminacion" >
   <form id="formulariodeeliminacion" method="POST" action="Remover.php"> 
	  <p>
	     <label for="iddelapersona">Id de la persona</label>
		 <input id="iddelapersona" name="iddelapersona" type="text" ></br>
	  </p>
	  <p>
	     <input  type="submit" value="Eliminar">
	  </p>
   </form> 
   </div>
</div>
<div id="Cabecera">
   <h1>Person Manager</h1>
</div>
<div id="Piedepagina">
   <h1>Universidad Catolica Nuestra Señora de la Asuncion - 2015</h1>
</div>
</body>
</html>

