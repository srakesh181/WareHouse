<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    isELIgnored="false"%>
    <%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

 <head>
   <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
   <title>Item Registration</title>
 </head>
 <body>
	<div class="container">
	
		<div class="card">
			
			<!-- card header starts from here -->
					<div class="card-header bg-primary text-white">
							<h3>Welcome to Item Registration page</h3>
					</div>

			<!-- card body starts from here -->
					<div class="card-body">
						
						<!-- spring form starts here -->
								<form:form action="save" method="POST" modelAttribute="item">
									<!-- Row #1 -->
										<div class="row form-group">
											<div class="col-4">
												<label for="itemCode" class="control-label">
													Item Code
												</label>
											</div>	
											<div class="col6">
												<form:input path="itemCode" required="true" class="form-control"/>
												
											</div>
										</div> 
										
										<!-- Row #2 -->
											<div class="row form-group">
												<div class="col-4">
													<label for="itemWidth" class="control-label">
														Item Dimensions
													</label>
												</div>
												<div class="col-6">
													<div class="row form-group" > <!-- Inner starts from Here -->
														<div class="col-2">
															<label for="itemWidth" class="control-label">
																Width
															</label>
														</div>
														<div class="col-2">
															<form:input path="itemWidth" class="form-control"/>
														</div><br>
														<div class="col-2">
															<label for="itemLength" class="control-label">
																Length
															</label>
														</div>
														<div class="col-2">
															<form:input path="itemLength" class="form-control"/>
														</div><br>
														<div class="col-2">
															<label for="itemHeight" class="control-label">
																Height
															</label>
														</div>
														<div class="col-2">
															<form:input path="itemHeight" class="form-control"/>
														</div>
														
													</div>
												</div>
											</div>  <!-- Row ended here -->
										
										<!-- Row #3 -->
											<div class="row form-group">
												<div class="col-4">
													<label for="itemBaseCost" class="control-label">
														Base Cost
													</label>
												</div>
												<div class="col-6">
													<form:input path="itemBaseCost"  required="true" class="form-control"/>
												</div>
											</div>	
											
										<!-- Row #4 -->	
											<div class="row form-group">
												<div class="col-4">
													<label for="itemBaseCurrency" class="control-label">
														Base Currency
													</label>
												</div>
												<div class="col-6">
													<form:select path="itemBaseCurrency" required="true" class="form-control">
														<form:option value="">-SELECT</form:option>
														<form:option value="INR">INR</form:option>
														<form:option value="USD">USD</form:option>
														<form:option value="AUS">AUS</form:option>
														<form:option value="ERU">ERU</form:option>
													</form:select>
												</div>
											</div>								
										
										<!-- submit button -->
										
										<input type="submit" value="Register" class="btn btn-success">
										<a href="data" class="btn btn-success" >View All</a>
								</form:form>

					</div>		<!-- card body end  here -->
					
					
					<!-- card footer starts form here -->
						<div class="card-footer bg-primary text-white" >
							${msg}
						</div>
					
		
		</div> <!-- card end  --> 
	
	</div> <!-- container end -->

 </body>
</html>
