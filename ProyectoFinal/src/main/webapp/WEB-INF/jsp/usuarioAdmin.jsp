<!DOCTYPE html>
<html>

<body>
<h1>Usuario: ${tipoUsuario}</h1>
<h1>Vista Admin</h1>

<form action="/login/usuario/update" method="post">

  <label for="id">id:</label>
  <input type="number" id="id" name="id" ><br><br>
  
  <label for="roleid">Roleid:</label>
  <input type="number" id="roleid" name="roleid" ><br><br>
  
  <label for="user">Username:</label>
  <input type="text" id="user" name="user" ><br><br>
  
  <label for="password">password:</label>
  <input type="password" id="password" name="password" ><br><br>
  
  <label for="enabled">Enabled:</label>
  <input type="number" id="enabled" name="enabled" ><br><br>
  
  <input type="submit" value="Submit">
</form>

</body>
</html>