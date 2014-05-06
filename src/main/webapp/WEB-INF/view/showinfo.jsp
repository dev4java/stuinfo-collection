<%@ page contentType="text/html;charset=UTF-8" %>
<%@include file="/WEB-INF/inc/globalConfig.jsp" %>
<!DOCTYPE html>    
<html>
	<head>
		<meta charset="utf-8">
		<title>Welcome</title>
	</head> 
	<body>
	<c:if test="${flag==0}">
		<h2></h2>
		<c:forEach items="${message}" var= "listSq" varStatus ="status">
			<%-- <c:if test="parent!=null"> --%>
			 	<h2>${listSq.id}</h2>
				<h2>${listSq.question}</h2>
				<h2>${listSq.answer}</h2> 
			<%-- </c:if> --%>
		</c:forEach>
	</c:if>
		
		
	</body>
</html>
