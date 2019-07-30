<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    isELIgnored="false"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
   <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<title>Item view page</title>
</head>
<body>
	<div class="container">
		
		<div class="card">
			
			<!-- card header starts from here -->
				<div class="card-header bg-primary text-white">
					<h3>Welcome to Item View page</h3>
				</div>
			
			<!-- card body starts from here -->
						<div class="card-body">
							
							<!-- table starts from here -->
									<table  class="table table-bordered table-hover">
											<tr>
												<th>itemId</th>
												<td>${ob.itemId}</td>
											</tr>
											<tr>
												<th>itemCode</th>
												<td>${ob.itemCode}</td>
											</tr>	
											<tr>
												<th>itemWidth</th>
												<td>${ob.itemWidth}</td>
											</tr>
											<tr>
												<th>itemLength</th>
												<td>${ob.itemLength}</td>
											</tr>
											<tr>
												<th>itemHeight</th>
												<td>${ob.itemHeight}</td>
											</tr>
											<tr>
												<th>itemBaseCost</th>
												<td>${ob.itemBaseCost}</td>
											</tr>
											<tr>
												<th>itemBaseCurrency</th>
												<td>${ob.itemBaseCurrency}
											</tr>
										
									</table>
							</div>		

			<!-- card footer starts from here -->
				<div class="card-footer bg-primary text-white">
				
				<a href="delete?itemId=${ob.itemId}" class="btn btn-warniW">DELETE</a>
				
				<a href="edit?itemId=${ob.itemId}" class="btn btn-warning">EDIT</a>
				
				<a href="" class="btn btn-warning">EXCEL EXPORT</a>	
							
				<a href="" class="btn btn-warning">PDF EXPORT</a>	
				</div>
			
		</div>	<!-- card end here -->
		
	</div> <!-- container end here -->
</body>
</html>