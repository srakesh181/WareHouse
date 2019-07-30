<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    isELIgnored="false"%>
    
   <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
  <title>Uom-View</title>
 </head>
 <body>
 	<div class="container">
			
			<div class="card">
				
				<!-- card starts from here -->
					<div class="card-header bg-primary text-white">
							<h3> Welcome to  Uom View page</h3>
					</div>
				
				<!-- card body starts from here -->
						<div class="card-body">
							
							<!-- table starts from here -->
									<table  class="table table-bordered table-hover">
											<tr>
												<th>uomId</th>
												<td>${ob.uomId}</td>
											</tr>
											<tr>
												<th>UomType</th>
												<td>${ob.uomType}></td>
											</tr>
											<tr>
												<th>UomModel</th>
												<td>${ob.uomModel}</td>
											</tr>
											<tr>
												<th>UomDescrption</th>
												<td>${ob.uomDescription}</td>
												
											</tr>
													
									</table>

						</div>	<!-- card body ended -->
				
				<!-- card footer starts from here -->
						<div class="card-footer bg-danger text-white">
							<a href="delete?uomId=${ob.uomId}" class="btn btn-warning">DELETE</a>
													
							<a href="edit?uomId=${ob.uomId}" class="btn btn-warning">EDIT</a>
							
							<a href="excel?uomId=${ob.uomId}" class="btn btn-warning">EXCEL EXPORT</a>	
							
							<a href="pdf?uomId=${ob.uomId}" class="btn btn-warning">PDF EXPORT</a>					
						</div> <!-- card footer end
			</div>	<!-- card end -->
	</div>	<!-- container end --> 
 
</body>
</html>