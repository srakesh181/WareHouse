<%@page import="javax.persistence.Table"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
   <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
 <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<title>document</title>
</head>
<body>
	
	<form action="upload" enctype="multipart/form-data">
		<pre>
		File Id	: <input type="text" name="fileId" />
		Document: <input type="file" name="file" />
		
		<input type="submit" value="upload"/>
		</pre>
	</form>
	
	<%-- <table border="1">
		
		<tr>
			<th>File Name </th>
			<th>link</th>
		</tr>
		
		<c:forEach items="${list}" value="ob">
			
			<tr>
				<td><c:out value="${ob.[1]}"/></td>
			</tr>
			<tr>
				<td>
					<a href="download?fileId="${ob.[0]}">Download
					
					<img src="../resources/images/download.jpg" width="30" height="30"/></a>
				</td>
			</tr>
		
		</c:forEach>	
	</table>
 --%>
</body>
</html>