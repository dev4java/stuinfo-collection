<%@ page contentType="text/html;charset=UTF-8" %>
<%@include file="/WEB-INF/inc/globalConfig.jsp" %>
<!DOCTYPE html>    
<html>
	<head>
		<meta charset="utf-8">
		<title>Welcome</title>
	</head> 
	<body>
		<h2></h2>
		<c:forEach items="${message}" var= "stu" varStatus ="status">
			<%-- <c:if test="parent!=null"> --%>
			 	<h2>${stu.id}</h2>
				<h2>${stu.name}</h2>
				<h2>${stu.birthday}</h2> 
				<h2>${stu.stuanswer}</h2> 
				<h2>${stu.address}</h2> 
			<%-- </c:if> --%>
		</c:forEach>
		
		
	</body>
</html>
