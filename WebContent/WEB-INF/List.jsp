<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!doctype html>
<html lang="en">
<head>
	<title>Store Front</title>
	<!-- Latest compiled and minified CSS -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">	
	<%-- <link rel="stylesheet" href="https://bootswatch.com/paper/bootstrap.min.css"> --%>
</head>
<body>
<div class="container">

	<!-- Page Header -->
	<div class="page-header">
		<h2>
			JP_Init	
				<small>Welcome</small>
		</h2>
	</div>

	<form action="AddLink" method="post">
		<div class="page-header">
			<div class="col-xs-9 col-sm-10">
				<div class="form-group">
					<label class="sr-only" for="AddLink">Enter Title </label>
					<input type="text" class="form-control" id="title" name="title" placeholder="Enter Title">
				</div>
				<div class="form-group">
					<label class="sr-only" for="AddLink">Enter Link </label>
					<input type="text" class="form-control" id="url" name="url" placeholder="Enter Link">
				</div>
				
			</div>
			<div class="col-xs-3 col-sm-2">
				<button type="submit" class="btn btn-success btn-block">Add</button>
			</div>
		</div>
	</form>

	<c:if test="${empty list}">
		<div class="jumbotron">
			<h1>Uh-Oh! <small>No one has posted yet, want to be the first?!?!?!?</small></h1>
		</div>
	</c:if>

	<c:if test="${not empty list}">
	<table class="table table-hover table-striped table-bordered">
		<thead>
			<tr>
				<th>Votes</th>
				<th>Tile</th>
				<th>Link</th>
				<th>Upvote</th>
				<th>Downvote</th>
				
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${list}" var="list">
			<div class="link">
				<tr>	
					<td>
							<span id="count">${list.count}</span>				
					</td>				
					<td>
							${list.title}					
					</td>
					<td>
							<a href="${list.link}">${list.link}	</a>				
					</td>
					<td>
					
						<c:url value="Upvote" var="updateUrl">
						   <c:param name="id" value="${list.id}"/>
						   
						</c:url>
						
						<a class="btn btn-default btn-xs" href="${updateUrl}">Upvote</a>
						
					</td>
					<td>
					
						<c:url value="Downvote" var="updateUrl">
						   <c:param name="id" value="${list.id}"/>
						   
						</c:url>
						
						<a class="btn btn-default btn-xs" href="${updateUrl}">Downvote</a>
						
					</td>
					
				</tr>
				</div>
			</c:forEach>
			
		</tbody>
	</table>
	</c:if>
	
</body>
</html>