<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Hola mundo!</title>
        <!-- BOOTSTRAP 4.5 -->
	<link rel="stylesheet"
		href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
		integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z"
		crossorigin="anonymous">
		<!-- CUSTOM STYLE -->
	
    </head>

    <body>
        <main class="container">
        	<section class="row">
        		<h1 class="col-12 text-center">Listado de ciudades y ayuda</h1>
        	</section>
        	<section class="row col-6 m-auto">
        		<div class="table-responsive">
        			<table class="table table-sm table-hover table-striped table-bordered">
        				<thead class="thead-light">
        					<tr>
        						<th scope="col">#</th>
        						<th scope="col">Ciudad</th>
        						<th scope="col">Tipo de ayuda</th>
        						<th scope="col">Monto</th>
        					</tr>
        				</thead>
        				<tbody>
        					<c:forEach items="${listaA}" var="a">
	        					<tr>
	        						<td scope="row">${ a.getId()}</td>
	        						<td scope="row">${ a.getCiudad()}</td>
	        						<td scope="row">${ a.getTipoAyuda()}</td>
	        						<td scope="row">${ a.getMonto()}</td>
	        					</tr>        					
        					</c:forEach>
        				</tbody>
        			</table>
        		</div>
        	</section>
        	<section class="row">
        		<h2 class="h2 text-center col-12">Agregar Ayuda</h2>
        		<form class="col-4 m-auto" action="agregarAyuda" method="POST">
        			<div class="form-group row">
        				<label class="col">Beneficiario:</label>
        				<select class="col form-control" id="idBenef" name="idBenef">
        					<c:forEach items="${listaBenef}" var="b">
        						<option value="${b.getId()}">${b.getNombre()}</option>
        					</c:forEach>
        				</select>
        			</div>
        			<div class="form-group row">
        				<label class="col">*Monto</label>
        				<input class="form-control col" type="number" name="monto" required="required">
        			</div>
        			<div class="form-group row">
        				<label class="col">*Motivo</label>
        				<input class="form-control col" type="text" name="motivo" required="required">
        			</div>
        			<div class="form-group row">
        				<input type="submit" value="Agregar" class="btn btn-primary w-100">
        			</div>
        			<small class="text-danger">* campos obligatorios</small>
        		</form>
        	</section>
        </main>
    </body>
    
	<!-- BOOTSTRAP 4.5 JS -->
	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
		integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"
		integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN"
		crossorigin="anonymous"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"
		integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV"
		crossorigin="anonymous"></script>

</html>
