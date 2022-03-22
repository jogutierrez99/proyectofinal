<!DOCTYPE html>
<html>

<body>

<h1>Vista Admin</h1>

<h1>Añadir Usuario</h1>

<form action="/login/usuario/add" method="post">

  <label for="roleid">Roleid:</label>
	<select name="roleid" id="roleid">
  		<option value="1">1</option>
  		<option value="2">2</option>
  		<option value="3">3</option>
	</select><br><br> 
  
  <label for="user">Username:</label>
  <input type="text" id="user" name="user" ><br><br>
  
  <label for="password">password:</label>
  <input type="password" id="password" name="password" ><br><br>
  
  <input type="submit" value="Submit">
</form>

<h1>Actualizar Usuario</h1>

<form action="/login/usuario/updateAdmin" method="post">

  <label for="id">id:</label>
  <input type="number" id="id" name="id" ><br><br>
  
  <label for="roleid">Roleid:</label>
	<select name="roleid" id="roleid">
  		<option value="1">1</option>
  		<option value="2">2</option>
  		<option value="3">3</option>
	</select><br><br> 
  
  <label for="user">Username:</label>
  <input type="text" id="user" name="user" ><br><br>
  
  <label for="password">password:</label>
  <input type="password" id="password" name="password" ><br><br>
  
  <label for="enabled">Enabled:</label>
  <input type="number" id="enabled" name="enabled" ><br><br>
  
  <input type="submit" value="Submit">
</form>

<h1>Eliminar Usuario</h1>

<form action="/login/usuario/delete" method="post">

  <label for="id">id:</label>
  <input type="number" id="id" name="id" ><br><br>
  
  <input type="submit" value="Submit">
</form>

</body>
</html>