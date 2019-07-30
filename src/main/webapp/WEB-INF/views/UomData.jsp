<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    isELIgnored="false"%>
    
   <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
  <title>Uom-Data</title>
 </head>
 <body>
 	<div class="container">
			
			<div class="card">
				
				<!-- card starts from here -->
					<div class="card-header bg-primary text-white">
							<h3> Welcome to  Uom Data page</h3>
							
							<a href="excel" class="btn btn-success">Excel Export</a>
							
							<a href="pdf" class="btn btn-success">Pdf Export</a>
							
							 <a href="charts" class="btn btn-success">Charts</a>
					</div>
				
				<!-- card body starts from here -->
						<div class="card-body">
							
							<!-- table starts from here -->
									<table  class="table table-bordered table-hover">
											<tr>
													<th>uomId</th>
													<th>UomType</th>
													<th>UomModel</th>
													<!-- <th>UomDescrption</th> -->
													<th  colspan="3">OPERATIONS</th>
											</tr>
											
											<!-- data Receving from the Controller using EL -->
											<c:forEach items="${list}" var="ob">
												<tr>
													<td><c:out value="${ob.uomId}"/></td>
													<td><c:out value="${ob.uomType}"/></td>
													<td><c:out value="${ob.uomModel}"/></td>
													<%-- <td><c:out value="${ob.uomDescription}"/></td> --%>
													<td>
														<a href="delete?uomId=${ob.uomId}" class="btn btn-danger">DELETE</a>
													</td>
													<td>
														<a href="edit?uomId=${ob.uomId}" class="btn btn-warning">EDIT</a>
													</td>
													<td>
														<a href="view?uomId=${ob.uomId}" class="btn btn-success">VIEW</a>
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