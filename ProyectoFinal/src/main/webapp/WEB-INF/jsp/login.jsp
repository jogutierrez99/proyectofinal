<!DOCTYPE html>
<html>

<body>

<h1>Login</h1>

<form action="/login/usuario" method="POST">
  <label for="username">Username:</label>
  <input type="text" id="username" name="username" required><br><br>
  <label for="password">password:</label>
  <input type="password" id="password" name="password" required><br><br>
  <input type="submit" value="Submit">
</form><br><br>

<h1>${mensaje}</h1>

</body>
</html>