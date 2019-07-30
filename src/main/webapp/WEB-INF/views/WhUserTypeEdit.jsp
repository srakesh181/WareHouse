<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    isELIgnored="false"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@taglib prefix="form"  uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<title> WhUserType Edit page</title>
 </head>
 <body>
	<div class="container">
		
			<div class="card">
				<!-- card header start from here -->
					<div class="card-header bg-primary text-white">
							<h3>Welcome to WhUserType Edit page</h3>
					</div>

				<!-- card body start from here -->
					<div class="card-header">
						<!-- form fields -->
							<form:form action="update" method="POST" modelAttribute="whUserType">
									
									<!-- Row #1 -->
										<div class="row form-group">
												<div class="col-4">
														<label for="whUserTypeId" class="control-form">
																whUserTypeId
														</label>
												</div>
												<div class="col-6">
														<form:input path="whUserTypeId" readOnly="true" class="form-control" />
												</div>
										</div>
								
									<!-- Row #2 -->
										<div class="row form-group">
												
												<div class="col-4">
														<label for="userType" class="control-label">
																User Type
															</label>
												</div>
												<div class="col-6">
													
														<form:radiobutton   path="whUserType" required="required" value="VENDOR"/>Vendor &nbsp;&nbsp;
													
													
														<form:radiobutton    path="whUserType" value="CUSTOMER"/>Customer
													
												</div>
										</div>
								
								<!-- Row #3 -->
										<div class="row form-group">
												
												<div class="col-4">
														<label for="userCode" class="control-label">
																User Code
															</label>
												</div>
												<div class="col-6">
														<form:input  path="whUserCode" required="required" placeholder="Enter User Code Here" class="form-control"/>
												</div>
										</div>
									<!-- Row #4   -->
										<div class="row form-group">
												
												<div class="col-4">
														<label for="userFor" class="control-lable">
																User For
														</label>
												</div>
												<div class="col-6">
														<form:select  path="whUserFor" required="required" class="form-control">
																<form:option value="">-SELECT-</form:option>
																<form:option value="PURCHASE">Purchase</form:option>
																<form:option value="SALE">Sale</form:option>
														</form:select>
												</div>
										</div>

										<!-- Row #5-->
										<div class="row form-group">
												<div class="col-4">
														<label for="userEmail" class="control-form">
																User Email
														</label>
												</div>
												<div class="col-6">
														<form:input path="whUserEmail" required="required" placeholder="Enter Email Here" class="form-control"/>
														
												</div>
										</div>
									
									<!-- Row #6 -->
										<div class="row form-group">
												<div class="col-4">
														<label for="userContact" class="control-form">
																User Contact
														</label>
												</div>
												<div class="col-6">
														<form:input path="whuserContact" required="required" placeholder="Enter Contact Here" class="form-control" />
												</div>
										</div>

										<!-- Row #7 -->
										<div class="row form-group">
												<div class="col-4">
														<label for="userIdType" class="control-form">
																User Id Type
														</label>
												</div>
												<div class="col-6">
														<form:select  path="whUserIdType" required="required" class="form-control">
																<form:option value="">-SELECT-</form:option>
																<form:option value="PAN CARD">PAN CARD</form:option>
																<form:option value="ADHAR CARD">ADHAR CARD</form:option>
																<form:option value="VOTER ID">VOTER ID</form:option>
																<form:option value="OTHER">OTHER</form:option>
														</form:select>
												</div>
										</div>

										<!-- Row #8 -->
										<div class="row form-group">
												<div class="col-4">
														<label for="idNumber" class="control-form">
																Id Number
														</label>
												</div>
												<div class="col-6">
														<form:input path="whUserIdNumber" required="required" placeholder="Enter Id number" class="form-control" />
												</div>
										</div>

									<!-- submit burton-->
											<input type="submit" class="btn btn-success" value="Update User"/>
							</form:form> <!-- form ended-->
					</div>	<!-- card body ended>

				<!-- card footer starts from here -->
					<div class="card-footer bg-info text-white">
						
					</div>	<!-- card footer end

			</div>		<!-- card end -->
	</div>	<!-- contianer end -->
 </body>
</html>