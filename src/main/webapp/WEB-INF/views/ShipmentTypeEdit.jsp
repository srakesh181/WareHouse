<!doctype html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    isELIgnored="false"%>
    <%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html lang="en">
 <head>
   <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
   <title>ShipmentType Edit page</title>
 </head>
 <body>
	<div class="container">
	
		<div class="card">
			
			<!-- card header starts from here -->
					<div class="card-header bg-primary text-white">
							<h3>Welcome to Shipment Type Edit Page</h3>
					</div>

			<!-- card body starts from here -->
					<div class="card-body">
						
						<!-- spring form strats here -->
								<form:form action="update" method="POST" modelAttribute="shipmentType">
								
								
										<!-- Row #1-->
												<div class="row form-group">
														<div class="col-4">
																<label for="shipmentTypeId" class="control-label">
																		ShipmentTypeId
																</label>
														</div>
														<div class="col-6">
																<form:input    path="shipmentTypeId" readOnly="true" class="form-control"/>
														</div>
												</div>  <!-- Row ended -->
								
										
										<!-- Row #2 -->
												<div class="row form-group" >
													<div class="col-4">
														<label for="shipmentMode"  class="control-label">
																Shipment Mode
														</label>
													</div>
													<div class="col-6">
														<form:select  required="required"   path="shipmentMode" class="form-control">
															<form:option value="">-SELECT-</form:option>
															<form:option value="AIR">Air</form:option>
															<form:option value="TRUCK">Truck</form:option>
															<form:option value="SHIP">Ship</form:option>
															<form:option value="TRAIN">Train</form:option>
														</form:select>
													</div>
												</div>	<!-- Row ended -->
										
										<!-- Row #3-->
												<div class="row form-group">
														<div class="col-4">
																<label for="shipmentCode" class="control-label">
																		Shipment Code
																</label>
														</div>
														<div class="col-6">
																<form:input required="required" readOnly="true" placeholder="Enter Shipment Code Here"  path="shipmentCode" class="form-control"/>
														</div>
												</div>  <!-- Row ended -->
										
										<!-- Row #4 -->
												<div class="row form-group">
														<div class="col-4">
																<label for="enableShipment" class="control-label">
																		Enable Shipment
																</label>
														</div>
														<div class="col-6">
																<form:select   path="enableShipment" class="control-label">
																		<form:option value="">-SELECT</form:option>
																		<form:option value="YES">Yes</form:option>
																		<form:option value="NO">No</form:option>
																</form:select>
														</div>
												</div> <!-- row end -->
										
										<!-- Row #5 -->
												<div class="row form-group">
														<div class="col-4">
																<label for="shipmentGrade" class="control-label">
																		Shipment Grade
																</label>
														</div>
														<div class="col-6">
																<form:radiobutton   path="shipmentGrade" value="A"/>A &nbsp;&nbsp;
																<form:radiobutton    path="shipmentGrade" value="B"/>B &nbsp;&nbsp;
																<form:radiobutton    path="shipmentGrade" value="C"/>C
														</div>
												</div> <!-- row end -->

										<!-- Row #6 -->
											<div class="row form-group">
													<div class="col-4" >
															<label for="description" class="control-label">
																	Description
															</label>
													</div>
													<div class="col-6">
															<form:textarea required="required" placeholder="Enter Description Here" path="description" class="form-control" ></form:textarea>
													</div>
											</div>		<!-- row end  -->
									
									<!-- submit  button-->
											<input type="submit" value="Update Shipment" class="btn btn-success"/>
								
								</form:form>

					</div>		<!-- card body end  here -->

			<!-- card footer starts from here -->	
					<div class="card-footer bg-info text-white">
						
							
					</div> <!-- card footer end -->
		</div> <!-- card end  -->
	
	</div> <!-- container end -->

 </body>
</html>
