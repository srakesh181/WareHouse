<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    isELIgnored="false"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
  <title>Shipment Type Data</title>
 </head>
 <body>
 	<div class="container">
			
			<div class="card">
				
				<!-- card starts from here -->
					<div class="card-header bg-primary text-white">
							<h3> Welcome to  Shipment Type Data page</h3>
							
							<a href="excel" class="btn btn-success">EXCEL EXPORT</a>
							
							 <a href="pdf" class="btn btn-success">PDF EXPORT</a>
							 
							 <a href="charts" class="btn btn-success">Charts</a>
					</div>
				
				<!-- card body starts from here -->
						<div class="card-body">
							
							<!-- table starts from here -->
									<table  class="table table-bordered table-hover">
											<tr>
													<th>ShipmentTypeId</th>
													<th>ShipmentMode</th>
													<th>ShipmentCode</th>
													<!-- <th>EnableShipment</th>
													<th>ShipmentGrade</th>
													<th>Description</th> -->
													<th  colspan="3">&nbsp; &nbsp; &nbsp; &nbsp; OPERATIONS</th>
											</tr>
											<!-- Receving data from the controller -->
										<c:forEach items="${list}" var="ob">
											<tr> 
												<td><c:out value="${ob.shipmentTypeId}"/></td>
												<td><c:out value="${ob.shipmentMode}"/></td>
												<td><c:out value="${ob.shipmentCode}"/></td>
												<%-- <td><c:out value="${ob.enableShipment}"/></td>
												<td><c:out value="${ob.shipmentGrade}"/></td>
												<td><c:out value="${ob.description}"/></td>
												 --%>
												<td>
													<a href="delete?shipmentTypeId=${ob.shipmentTypeId}" data-toggle="tooltip" title="Deletes"><img  src="../resources/images/delete.png" width="30" height="30" /></a>
												</td>
												<td>
													<a href="edit?shipmentTypeId=${ob.shipmentTypeId}" class="btn bg-primary text-white">EDIT</a>
												</td>
												<td>
													<a href="view?shipmentTypeId=${ob.shipmentTypeId}" class="btn bg-primary text-white">VIEW</a>
												</td>
											</tr>
											</c:forEach>
									</table>

						</div>	<!-- card body ended -->
				
				<!-- card footer starts from here -->
						<div class="card-footer bg-danger text-white">
							 ${msg}
							 
						</div> <!-- <!-- card footer end -->
			</div>	<!-- card end -->
	</div>	<!-- container end --> 
  
 </body>
</html>
