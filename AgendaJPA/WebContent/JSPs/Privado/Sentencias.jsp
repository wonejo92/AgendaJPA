<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Servicios</title>
<link href="/AgendaJPA/JSPs/Privado/css/editor.css" rel="stylesheet" />
</head>
<body>
	<c:set var="ced" scope="session" value="${cedula}"/>
	<p> ${ced} </p>
	<c:set var="obj_tabla" value="${requestScope['lst_telefonos'] }"></c:set>
	<c:forEach var="item" items="${obj_tabla}">
	</c:forEach>
	
	<div class="container-fluid">
		<div class="row" style="margin-bottom: 2%;">
			<div class=" col-5   col-sm-5">
				<div class="form-group">
					<form action="/AgendaJPA/ServletListarCedula" method="post">
						<label>Listar Por Cédula:</label> <input type="text"
							class="form-control" name="cedula" placeholder="0105904321" />
							<button type="submit"   class="btn btn-secondary"
							style="margin-right: 2em;">Buscar.
							</button>
					</form>
					<br />
					<div class="form-group">
						<form action="/AgendaJP/ServletListarCorreo" method="post">
							<label>Listar Por Correo:</label> <input type="text"
								class="form-control" name="correo" placeholder="ejemplo@hotmail.com" '/>
							<button type="submit" class="btn btn-secondary"
							style="margin-right: 2em;">Buscar.
							</button>
						</form>
					</div>
				</div>
			</div>
			
			
			
		</div>

		<div class="row marketing">
			<div class="col-lg-6" style="text-align: left;">
			<form action="/PracticaAgenda/ServletCrearTelefono" method="post" >
			<input type="hidden" name="Cedula" value="${ced}">
				<h4>
					Datos Telefónicos <br />
				</h4>
				<ul class="list-group">
					<li class="list-group-item"><br />
						<div class="form-group">
							<label>Código:</label><input type="text" name="codigoN"  class="form-control" />
						</div></li>
					<li class="list-group-item"><br />
						<div class="form-group">
							<label>Numero:</label><input type="text" name="numeroN" class="form-control" />
						</div></li>
					<li class="list-group-item"><br />
						<div class="form-group">
						<label>Tipo:</label><input type="text" name="tipoN" class="form-control" />
						</div></li>
				</ul>
				<ul class="list-group">
					<li class="list-group-item" style="margin-bottom: 2%;"><br />
						<div class="form-group">
						<label>Operadora:</label><input type="text" name="operadoraN" class="form-control" />
						</div></li>
						<button type="submit" name="action" value="Crear" class="btn btn-secondary"
						style="margin-right: 2em;">Crear Nuevo Registro</button>
						<button type="submit" name="action" value="Modificar" class="btn btn-secondary"
						style="margin-right: 2em;">Actualizar Registro</button>
					</form>		
				</ul>
				<div class="btn-group" role="group" aria-label="Basic example">
				</div>
				<div class="row">
					<div class="col-sm-4"></div>
					<div class="col-sm-4 col-5"></div>
					<div class="col-sm-4"></div>
				</div>
				<div class="container"
					style="min-height: 150px; text-align: center;">
					<div class="btn-group" role="group" aria-label="Basic example">
						</div>	
						<br></br>
						<div class="btn-group" role="group" aria-label="Basic example">
						</div>
				</div>
			</div>
			<div class="col-lg-6">
			<form action="/PracticaAgenda/ServletEliminar" method="post">
			<button type="submit" class="btn btn-secondary"
				style="margin-right: 2em;">Eliminar Numero.
				</button>
				<ul class="list-group">
					<li class="list-group-item"><br />
						<div class="form-group">
							<label>Código:</label><input type="text" name="codigo" class="form-control" />
						</div>
				</ul>
				</form>
				<br></br>
				<ul class="list-group">
					<li class="list-group-item"><br/>
						<div class="form-group">
				<form action="/PracticaAgenda/Telefonos" method="post">
				<input type="hidden" name="Cedula" value="${ced}">
				<button type="submit" class="btn btn-secondary"
				style="margin-right: 2em;">Listar Numeros.</button>
				<label>Lista de Teléfonos:</label>
				</form>
						</div> 
						<c:if test="${obj_tabla != null}">
							<table class="table table-dark">
							<thead>
								<tr>
									<th>codigo</th>
									<th>Numero</th>
									<th>Tipo</th>
									<th>Operadora</th>
									<th>Cedula_Usuario</th>
									<th>Email</th>
									<th>Call</th>
									
								</tr>
							</thead>
							<tbody>
							<c:forEach var="telefono" items="${obj_tabla}">
								<tr>
									<td>${telefono.codigo}</td>
									<td>${telefono.numero}</td>
									<td>${telefono.tipo}</td>
									<td>${telefono.operadora}</td>
									<td>${telefono.cedulaU.cedula}</td>
									<td><a href="mailto:ckevin@est.ups.edu.ec">Send Email.</a></td>
									<td><a href="tel:0991269100">Call.</a></td>
								</tr>
							</c:forEach>
							</tbody>
							
							</table>
						</c:if>

					</li>
				</ul>
			</div>
		</div>

	</div>
	
</body>
</html>