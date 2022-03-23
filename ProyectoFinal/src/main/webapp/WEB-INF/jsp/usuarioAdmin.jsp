<!DOCTYPE html>
<html>
<head>

<style type="text/css">
#formularioAdd {
	display: none;
}
#formularioUpdate {
	display: none;
}
#formularioDelete {
	display: none;
}
</style>

<script type="text/javascript">
	function mostrarAdd() {
		document.getElementById('formularioAdd').style.display = 'block';
	}
	function mostrarUpdate() {
		document.getElementById('formularioUpdate').style.display = 'block';
	}
	function mostrarDelete() {
		document.getElementById('formularioDelete').style.display = 'block';
	}
	
	
	function ocultarAdd() {
		document.getElementById('formularioAdd').style.display = 'none';
	}
	function ocultarUpdate() {
		document.getElementById('formularioUpdate').style.display = 'none';
	}
	function ocultarDelete() {
		document.getElementById('formularioDelete').style.display = 'none';
	}
	
</script>
</head>


<body>

	<h1>Vista Admin</h1>

	<table class="table">
		<thead>
			<tr>
				<th scope="col"><button type="button" onclick="mostrarAdd();">Añadir Usuario</button></th>
				<th scope="col"><button type="button" onclick="mostrarUpdate();">Actualizar Usuario</button></th>
				<th scope="col"><button type="button" onclick="mostrarDelete();">Eliminar Usuario</button></th>
			</tr>
		</thead>
	</table>




	<table class="table">
		<thead>
			<tr>
				<th scope="col">
				
					<div id="formularioAdd">
						<form action="/login/usuario/add" method="post">
							<label for="roleid">Roleid:</label> <select name="roleid"
								id="roleid">
								<option value="1">1</option>
								<option value="2">2</option>
								<option value="3">3</option>
							</select><br>
							<br> <label for="user">Username:</label> <input type="text"
								id="user" name="user"><br>
							<br> <label for="password">password:</label> <input
								type="password" id="password" name="password"><br>
							<br> <input type="submit" value="Submit">
						</form><br>
							<button type="button" onclick="ocultarAdd();">ocultar</button><br><br>
					</div>

				</th>
				<th scope="col">
				
					<div id="formularioUpdate">
						<form action="/login/usuario/updateAdmin" method="post">
							<label for="id">id:</label> <input type="number" id="id" name="id"><br>
							<br> <label for="roleid">Roleid:</label> <select
								name="roleid" id="roleid">
								<option value="1">1</option>
								<option value="2">2</option>
								<option value="3">3</option>
							</select><br>
							<br> <label for="user">Username:</label> <input type="text"
								id="user" name="user"><br>
							<br> <label for="password">password:</label> <input
								type="password" id="password" name="password"><br>
							<br> <label for="enabled">Enabled:</label> <input
								type="number" id="enabled" name="enabled"><br>
							<br> <input type="submit" value="Submit">
						</form><br>
							<button type="button" onclick="ocultarUpdate();">ocultar</button><br><br>
					</div>

				</th>
				<th scope="col">
				
					<div id="formularioDelete">
					<form action="/login/usuario/delete" method="post">

						<label for="id">id:</label> <input type="number" id="id" name="id"><br>
						<br> <input type="submit" value="Submit">
					</form><br>
						<button type="button" onclick="ocultarDelete();">ocultar</button><br><br>
					</div>
					
				</th>
			</tr>
		</thead>
	</table>



</body>
</html>