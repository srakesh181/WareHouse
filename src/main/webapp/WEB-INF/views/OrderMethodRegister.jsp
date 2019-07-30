<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    isELIgnored="false"%>
 <%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
   
<!DOCTYPE html>
<html>
<head>
  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<title>OrderMethod Register</title>
 </head>
 <body>
	<div class="container">
		
			<div class="card">
				<!-- card header start from here -->
					<div class="card-header bg-primary text-white">
							<h3>Welcome to Order Method Register page</h3>
					</div>

				<!-- card body start from here -->
					<div class="card-header">
						<!-- form fields -->
							<form:form action="save" method="POST" modelAttribute="orderMethod">
								
									<!-- Row #1 -->
										<div class="row form-group">
												
												<div class="col-4">
														<label for="orderMethodMode" required="required" palceholder="Enter Order Mode here" class="control-label">
																Oder Mode
															</label>
												</div>
												<div class="col-6">
													<form:radiobutton path="orderMethodMode" value="SALE" />Sale  &nbsp &nbsp
													<form:radiobutton path="orderMethodMode" value="PURCHASE"/>Purchase
												</div>
										</div>
								
								<!-- Row #2 -->
										<div class="row form-group">
												
												<div class="col-4">
														<label for="orderMethodCode" class="control-label">
																Oder Code
															</label>
												</div>
												<div class="col-6">
														<form:input path="orderMethodCode" required="required" palceholder="Enter Order Code here" class="form-control"/>
												</div>
										</div>
									<!-- Row #3   -->
										<div class="row">
												
												<div class="col-4">
														<label for="orderMethodExecuteType" class="control-lable">
																Execute Type
														</label>
												</div>
												<div class="col-6">
														<form:select path="orderMethodExecuteType" required="required" class="form-control">
																<form:option value="">-SELECT-</form:option>
																<form:option value="FIFO">FIFO</form:option>
																<form:option value="LIFO">LIFO</form:option>
																<form:option value="FCFO">FCFO</form:option>
																<form:option value="FEFO">FEFO</form:option>
														</form:select>
												</div>
										</div>

										<!-- Row #4 -->
										<div class="row">
												<div class="col-4">
														<label for="orderAccept" class="control-form">
																Order Accept
														</label>
												</div>
												<div class="col-6">
														<form:checkbox path="orderMethodAccept" required="required" value="MULTI-MODEL" />Multi-Model<br>
														<form:checkbox path="orderMethodAccept"   value="ACCEPT-RETURN"/>Accept-Return<br>
														<form:checkbox path="orderMethodAccept"   value="SERVICE-EXTEND"/>Service-Extend
												</div>
										</div>
									
									<!-- Row #5 -->
										<div class="row">
												<div class="col-4">
														<label for="Description" class="control-form">
																Description
														</label>
												</div>
												<div class="col-6">
														<form:textarea path="Description" class="form-control" />
												</div>
										</div>
									<!-- submit burton-->
											<input type="submit" class="btn btn-success" value="Create Order Method"/>
											<a href="data" role="button" class="btn btn-primary">View All</a>
							</form:form> <!-- form ended-->
					</div>	<!-- card body ended>

				<!-- card footer starts from here -->
					<div class="card-footer bg-info text-white">
							${msg}
					</div>	<!-- card footer end

			</div>		<!-- card end -->
	</div>	<!-- contianer end -->
 
</body>
</html>