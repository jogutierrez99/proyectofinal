<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<body>
<h1>Usuario: ${tipoUsuario}</h1>
<h1>Vista Advance</h1>

<form action="/login/usuario/update" method="post">

  <label for="id">id:</label>
  <input type="number" id="id" name="id" required><br><br>
  
  <label for="roleid">Roleid:</label>
  <input type="number" id="roleid" name="roleid" required><br><br>
  
  <label for="user">Username:</label>
  <input type="text" id="user" name="user" required><br><br>
  
  <label for="password">password:</label>
  <input type="password" id="password" name="password" required><br><br>
  
  <input type="submit" value="Submit">
</form>

</body>
</html>