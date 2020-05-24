<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en" dir="ltr">
  <head>
    <meta charset="utf-8">
    <title></title>
    <link rel="stylesheet" href="/AgendaJPA/JSPs/publico/style.css">
  </head>
  <body>
  <form action="/AgendaJPA/ServletCrearUsuario" method="post">
<div class="login-box">
  <h1>Sign up</h1>
  <div class="textbox">
    <label ID="Cedula">Cedula:</label>
    <br>
    <input type="text" placeholder="" name="cedula" >
  </div>

  <div class="textbox">
    <label id="Nombre">Nombre</label>
    <br>
    <input type="text" placeholder="" name="nombre" >
  </div>

  <div class="textbox">
    <label id="Apellido">Apellido</label>
    <br>
    <input type="text" placeholder="" name="apellido">
  </div>

  <div class="textbox">
  <label id="Correo">Correo</label>
  <br>
  <input type="text" placeholder="" name="correo">
  </div>

  <div class="textbox">
    <label id="Contrasena">Contraseña</label>
    <br>
    <input type="password" placeholder="" name="contrasena">
  </div>

  <input type="submit" class="btn" value="Sign up">
</div>
</form>
  </body>
</html>