<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    isELIgnored="false"%>
    <%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>

 <head>
  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<title>Uom Register page</title>
 </head>
 <body>
	<div class="container">
		
			<div class="card">
				<!-- card header start from here -->
					<div class="card-header bg-primary text-white">
							<h3>Welcome to Uom Register page</h3>
					</div>

				<!-- card body start from here -->
					<div class="card-header">
						<!-- form fields -->
							<form:form action="save" method="POST" modelAttribute="uom">
								
								<!-- Row #1 -->
										<div class="row form-group">
												
												<div class="col-4">
														<label for="uomType" class="control-label">
																Uom Type
															</label>
												</div>
												<div class="col-6" >
														<form:select required="reqired"  path="uomType" class="form-control">
																<form:option value="">-SELECT-</form:option>
																<form:option value="PACKING">packing</form:option>
																<form:option value="NO PACKING">No packing</form:option>
																<form:option value="NA">-NA-</form:option>
														</form:select>
												</div>
										</div>
									<!-- Row #2   -->
										<div class="row form-group">
												
												<div class="col-4">
														<label for="uomModel" class="control-lable">
																Uom Model
														</label>
												</div>
												<div class="col-6">
														<form:input required="reqired" placeholder=" Enter Uom Model here " path="uomModel" class="form-control" />
														<form:errors path="uomModel"></form:errors>
												</div>
										</div>
									
									<!-- Row #3 -->
										<div class="row form-group">
												<div class="col-4">
														<label for="uomDescription" class="control-form">
																Description
														</label>
												</div>
												<div class="col-6">
														<form:textarea required="reqired" placeholder=" Enter Description here" path="uomDescription" class="form-control" ></form:textarea>
												</div>
										</div>
									<!-- submit burton-->
											<input type="submit" class="btn btn-success" value="Create Uom"/>
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