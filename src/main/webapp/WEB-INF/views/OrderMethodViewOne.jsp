<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    isELIgnored="false"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
 <head>
  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
  <title>Order view Data</title>
 </head>
 <body>
 	<div class="container">
			
			<div class="card">
				
				<!-- card starts from here -->
					<div class="card-header bg-primary text-white">
							<h3> Welcome to  Order Method View page</h3>
					</div>
				
				<!-- card body starts from here -->
						<div class="card-body">
							
							<!-- table starts from here -->
									<table  class="table table-bordered table-hover">
											<tr>
													<th>ID</th>
													<td>${ob.orderMethodId}</td>
											</tr>
											<tr>
												<th>OrderMode</th>
												<td>${ob.orderMethodMode}</td>
											</tr>
											<tr>
												<th>OrderCode</th>
												<td>${ob.orderMethodCode}</td>
											</tr>
											<tr>
												 <th>ExecuteType</th>
												 <td>${ob.orderMethodExecuteType}</td>
											</tr>
											<tr>
												<th>OrderAccept</th>
												<td>${ob.orderMethodAccept}</td>
											</tr>
											<tr>
												<th>Description</th>
												<td>${ob.description }</td>
											</tr>
											
									
												
												
												
												
												
												
												
												
									</table>

						</div>	<!-- card body ended -->
				
				<!-- card footer starts from here -->
						<div class="card-footer bg-danger text-white">
								<a href="delete?orderMethodId=${ob.orderMethodId}" class="btn btn-warning">DELETE</a>
												
								<a href="edit?orderMethodId=${ob.orderMethodId}" class="btn btn-warning">EDIT</a>
								
								<a href="" class="btn btn-warning">EXCEL EXPORT</a>	
							
								<a href="" class="btn btn-warning">PDF EXPORT</a>						
						</div> <!-- card footer end
			</div>	<!-- card end -->
	</div>	<!-- container end --> 
  
</body>
</html>