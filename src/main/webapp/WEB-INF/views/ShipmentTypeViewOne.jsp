<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">

<meta charset="ISO-8859-1">
<title>View Page</title>
</head>
<body>
	<div class="container">
			
			<div class="card">
				
				<!-- card starts from here -->
					<div class="card-header bg-primary text-white">
							<h3> Welcome to  Shipment Type View page</h3>
					</div>
				
				<!-- card body starts from here -->
						<div class="card-body">
							
							<!-- table starts from here -->
									<table  class="table table-bordered table-hover">
											<tr>
												<th>ShipmentTypeId</th>
												<td>${ob.shipmentTypeId}</td>
											</tr>
											<tr>
												<th>ShipmentMode</th>
												<td>${ob.shipmentMode}</td>
											</tr>
											<tr>
												<th>ShipmentCode</th>
												<td>${ob.shipmentCode}</td>
											</tr>
											<tr>
												<th>EnableShipment</th>
												<td>${ob.enableShipment}</td>
											</tr>
											<tr>
												<th>ShipmentGrade</th>
												<td>${ob.shipmentGrade}</td>
											</tr>
											<tr>
												<th>Description</th>
												<td>${ob.description}</td>
											</tr>
													
									</table>
									<pre>
										
									</pre>
						</div>	<!-- card body ended -->
				
				<!-- card footer starts from here -->
						<div class="card-footer bg-danger text-white"> &nbsp; &nbsp;
						
						<a href="delete?shipmentTypeId=${ob.shipmentTypeId}" role="button"  class="btn btn-success">DELETE FORM HERE</a>
						
						<a href="edit?shipmentTypeId=${ob.shipmentTypeId}" role="button"  class="btn btn-success">EDIT FROM HERE</a>
						
						<a href="excel?shipmentTypeId=${ob.shipmentTypeId}" class="btn btn-warning">EXCEL EXPORT</a>	
							
						<a href="pdf?shipmentTypeId=${ob.shipmentTypeId}" class="btn btn-warning">PDF EXPORT</a>	
							
						</div> <!-- <!-- card footer end -->
			</div>	<!-- card end -->
	</div>	<!-- container end --> 

</body>
</html>