<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width">
  <script src="https://code.jquery.com/jquery-1.6.4.js"></script>
  <title>JS Bin</title>
</head>
<body>
<div class="display"></div>
  <script>

  $.getJSON('http://localhost:8080/login/usuario/listarUno/3', function(data){
    var display = `User_ID: ${data.id}<br>
    				Username: ${data.user}<br>`
    $(".display").html(display);
  });
  </script>
</body>
</html>