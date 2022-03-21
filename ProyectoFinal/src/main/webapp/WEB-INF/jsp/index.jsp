<!DOCTYPE html>
<html>

<body>

<h1>The form action attribute</h1>

<form action="/login" method="post">
  <label for="user">Username:</label>
  <input type="text" id="user" name="user"><br><br>
  <label for="password">password:</label>
  <input type="text" id="password" name="password"><br><br>
  <input type="submit" value="Submit">
</form>

<p>Click the "Submit" button and the form-data will be sent to a page on the 
server called "action_page.php".</p>

</body>
</html>