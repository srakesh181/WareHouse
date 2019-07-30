<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    isELIgnored="false"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
 <head>
  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
  <title>Order Method Data</title>
 </head>
 <body>
 	<div class="container">
			
			<div class="card">
				
				<!-- card starts from here -->
					<div class="card-header bg-primary text-white">
							<h3> Welcome to  Order Method Data page</h3>
							
							<a href="excel" class="btn btn-success">EXCEL EXPORT</a>
							
							 <a href="pdf" class="btn btn-success">PDF EXPORT</a>
							 
							 <a href="charts" class="btn btn-success">Charts</a>
					</div>
				
				<!-- card body starts from here -->
						<div class="card-body">
							
							<!-- table starts from here -->
									<table  class="table table-bordered table-hover">
											<tr>
													<th>ID</th>
													<th>OrderMode</th>
													<th>OrderCode</th>
													<!-- <th>ExecuteType</th>
													<th>OrderAccept</th>
													<th>Description</th> -->
													<th  colspan="3">OPERATIONS</th>
											</tr>
											<!-- Receiving data from the controller -->
										<c:forEach items="${list}"  var="ob">
											<tr>
												<td><c:out value="${ob.orderMethodId}"/></td>
												<td><c:out value="${ob.orderMethodMode}"/></td>
												<td><c:out value="${ob.orderMethodCode}"/></td>
												<%-- <td><c:out value="${ob.orderMethodExecuteType}"/></td>
												<td><c:out value="${ob.orderMethodAccept}"/></td>
												<td><c:out value="${ob.description }"/></td> --%>
												<td>
													<a href="delete?orderMethodId=${ob.orderMethodId}" class="btn btn-danger">DELETE</a>
												</td>
												<td>
													<a href="edit?orderMethodId=${ob.orderMethodId}" class="btn btn-warning">EDIT</a>
												</td>
												<td>
													<a href="view?orderMethodId=${ob.orderMethodId}" class="btn btn-success">VIEW</a>
												</td>
												
											</tr>
										</c:forEach>
									</table>

						</div>	<!-- card body ended -->
				
				<!-- card footer starts from here -->
						<div class="card-footer bg-danger text-white">
							 ${msg}
						</div> <!-- card footer end
			</div>	<!-- card end -->
	</div>	<!-- container end --> 
  
</body>
</html>