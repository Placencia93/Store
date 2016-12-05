<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!doctype html>
<html lang="en">
<head>
<title>Store Front</title>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
	integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
	crossorigin="anonymous">
<%-- <link rel="stylesheet" href="https://bootswatch.com/paper/bootstrap.min.css"> --%>
</head>
<body>
	<div class="container">

		<!-- Page Header -->
		<div class="page-header">
			<h2>Inventory to Store Manager Page</h2>
		</div>

		<form action="AddItemToStore" method="post">
			<div class="row">
				<div class="col-xs-9 col-sm-10">
					<div class="form-group">
						<label class="sr-only" for="addItem">addItem</label> <input
							type="text" class="form-control" id="name" name="name"
							placeholder="Enter Name Of Item">
					</div>
					<div class="form-group">
						<label class="sr-only" for="addItem">addDescription</label> <input
							type="text" class="form-control" id="description" name="description"
							placeholder="Enter description Of Item">
					</div>
					<div class="form-group">
						<label class="sr-only" for="addItem">addPrice</label> <input
							type="text" class="form-control" id="price" name="price"
							placeholder="Enter Price Of Item">
					</div>
					<div class="form-group">
						<label class="sr-only" for="addQuantity">addPrice</label> <input
							type="text" class="form-control" id="quantity" name="quantity"
							placeholder="Enter Quantity Of Item">
					</div>
					
				</div>
				<div class="col-xs-3 col-sm-2">
					<button type="submit" class="btn btn-success btn-block">Add Item</button>
				</div>
			</div>
		</form>

		<c:if test="${empty inventory}">
			<div class="jumbotron">
				<h1>
					Uh-Oh! <small>All items are sold out at this time</small>
				</h1>
			</div>
		</c:if>

		<c:if test="${not empty inventory}">
			<table class="table table-hover table-striped table-bordered">
				<thead>
					<tr>
						<th>Name</th>
						<th>Description</th>
						<th>Price</th>
						<th>Quantity</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${inventory}" var="inventory">
						<tr>
							<td>${inventory.name}</td>
							<td>${inventory.description}</td>
							<td>${inventory.price}</td>
							<td>${inventory.quantity}</td>


						</tr>
					</c:forEach>

					
					<tr>
						<a class="btn btn-primary btn-xs" href="History">Check Paid Orders</a>
					</tr>

				</tbody>
			</table>
		</c:if>
</body>
</html>