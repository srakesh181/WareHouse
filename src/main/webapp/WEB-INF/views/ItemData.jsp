<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    isELIgnored="false"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
   <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<title>Item Data page</title>
</head>
<body>
	<div class="container">
		
		<div class="card">
			
			<!-- card header starts from here -->
				<div class="card-header bg-primary text-white">
					<h3>Welcome to Item Data page</h3>
				</div>
			
			<!-- card body starts from here -->
						<div class="card-body">
							
							<!-- table starts from here -->
									<table  class="table table-bordered table-hover">
											<tr>
													<th>itemId</th>
													<th>itemCode</th>
													<th>itemWidth</th>
													<th>itemLength</th>
													<th>itemHeight</th>
													<th>itemBaseCost</th>
													<th>itemBaseCurrency</th>
													<th  colspan="3">&nbsp; &nbsp; &nbsp; &nbsp; OPERATIONS</th>
											</tr>
											<!-- Receiving data from the controller -->
										<c:forEach items="${list}" var="ob">
											<tr> 
												<td><c:out value="${ob.itemId}"/></td>
												<td><c:out value="${ob.itemCode}"/></td>
												<td><c:out value="${ob.itemWidth}"/></td>
												<td><c:out value="${ob.itemLength}"/></td>
												<td><c:out value="${ob.itemHeight}"/></td>
												<td><c:out value="${ob.itemBaseCost}"/></td>
												<td><c:out value="${ob.itemBaseCurrency}" />
												<td>
													<a href="delete?itemId=${ob.itemId}" class="btn btn-danger">DELETE</a>
												</td>
												<td>
													<a href="edit?itemId=${ob.itemId}" class="btn btn-warning">EDIT</a>
												</td>
												<td>
													<a href="view?itemId=${ob.itemId}" class="btn btn-success">VIEW</a>
												</td>
											</tr>
											</c:forEach>
									</table>
							</div>		

			<!-- card footer starts from here -->
				<div class="card-footer bg-primary text-white">
					${msg}
				</div>
			
		</div>	<!-- card end here -->
		
	</div> <!-- container end here -->
</body>
</html>