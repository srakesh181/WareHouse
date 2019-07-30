<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    isELIgnored="false"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
  <title>WhUserType  Data page</title>
 </head>
 <body>
 	<div class="container">
			
			<div class="card">
				
				<!-- card starts from here -->
					<div class="card-header bg-primary text-white">
							<h3> Welcome to  WhUser Type Data page</h3>
							
							<a href="excel" class="btn btn-success">Excel Export</a>
							
							<a href="pdf" class="btn btn-success">Pdf Export</a>
							
							 <a href="charts" class="btn btn-success">Charts</a>
					</div>
				
				<!-- card body starts from here -->
						<div class="card-body">
							
							<!-- table starts from here -->
									<table  class="table table-bordered table-hover">
											<tr>
													<th>ID</th>
													<th>UserType</th>
													<th>UserCode</th>
													<!-- <th>UserFor</th>
													<th>UserEmail</th>
													<th>UserContact</th>
													<th>UserIdType</th>
													<th>IdNumber</th> -->
													<th  colspan="3">OPERATIONS</th>
											</tr>
											<c:forEach items="${list}" var="ob">
												<tr>
													<td><c:out value="${ob.whUserTypeId}"/></td>
													<td><c:out value="${ob.whUserType}"/></td>
													<td><c:out value="${ob.whUserCode}"/></td>
													<%-- <td><c:out value="${ob.whUserFor}"/></td>
													<td><c:out value="${ob.whUserEmail}"/></td>
													<td><c:out value="${ob.whuserContact}"/></td>
													<td><c:out value="${ob.whUserIdType}"/></td>
													<td><c:out value="${ob.whUserIdNumber}"/></td> --%>
													<td>
														<a href="delete?whUserTypeId=${ob.whUserTypeId}" role="button" class="btn btn-danger">DELETE</a>
													</td>
													<td>
														<a href="edit?whUserTypeId=${ob.whUserTypeId}" class="btn btn-warning">EDIT</a>
													</td>
													<td>
														<a href="view?whUserTypeId=${ob.whUserTypeId}" class="btn btn-success">VIEW</a>
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