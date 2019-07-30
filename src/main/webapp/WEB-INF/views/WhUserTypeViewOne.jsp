<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    isELIgnored="false"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
  <title>WhUserType  view page</title>
 </head>
 <body>
 	<div class="container">
			
			<div class="card">
				
				<!-- card starts from here -->
					<div class="card-header bg-primary text-white">
							<h3> Welcome to  WhUser Type View page</h3>
					</div>
				
				<!-- card body starts from here -->
						<div class="card-body">
							
							<!-- table starts from here -->
									<table  class="table table-bordered table-hover">
											<tr>
												<th>ID</th>
												<td>${ob.whUserTypeId}"/></td>
											</tr>
											<tr>
												<th>UserType</th>
												<td>${ob.whUserType}</td>
											</tr>
											<tr>
												<th>UserCode</th>
												<td>${ob.whUserCode}</td>
											</tr>
											<tr>
												<th>UserFor</th>
												<td>${ob.whUserFor}</td>
											</tr>	
											<tr>
												<th>UserEmail</th>
												<td>${ob.whUserEmail}</td>
											</tr>
											<tr>
												<th>UserContact</th>
												<td>${ob.whuserContact}</td>
											</tr>
											<tr>
												<th>UserIdType</th>
												<td>${ob.whUserIdType}</td>
											</tr>
											<tr>
												<th>IdNumber</th>
												<td>${ob.whUserIdNumber}</td>
											</tr>
											
									</table>

						</div>	<!-- card body ended -->
				
				<!-- card footer starts from here -->
						<div class="card-footer bg-danger text-white">
						
						<a href="delete?whUserTypeId=${ob.whUserTypeId}" role="button" class="btn btn-warning">DELETE</a>
						
						
						<a href="edit?whUserTypeId=${ob.whUserTypeId}" class="btn btn-warning">EDIT</a>
						
						<a href="excel" class="btn btn-warning">EXCEL EXPORT</a>	
							
							<a href="pdf" class="btn btn-warning">PDF EXPORT</a>	
						</div> <!-- card footer end
			</div>	<!-- card end -->
	</div>	<!-- container end --> 
  
 
</body>
</html>