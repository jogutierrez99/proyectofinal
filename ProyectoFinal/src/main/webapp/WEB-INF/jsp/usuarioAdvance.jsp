<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<style type="text/css">
		#formulario{
			display: none;
		}
	</style>
	
	<script type="text/javascript">
		function mostrar(){
			document.getElementById('formulario').style.display = 'block';
		}
		function ocultar(){
			document.getElementById('formulario').style.display = 'none';
		}
	</script>
</head>
<body>
<h1>Vista Advance</h1>

<h1>Actualizar Usuario</h1>

<button type="button" onclick="mostrar();">mostrar</button><br><br>

<div id="formulario">
<form action="/login/usuario/update" method="post">

  <label for="id">id:</label>
  <input type="number" id="id" name="id" required><br><br>
  
  <label for="user">Username:</label>
  <input type="text" id="user" name="user" required><br><br>
  
  <label for="password">password:</label>
  <input type="password" id="password" name="password" required><br><br>
  
  <input type="submit" value="Submit">
</form><br><br>
<button type="button" onclick="ocultar();">ocultar</button><br><br>
</div>

</body>

</html>