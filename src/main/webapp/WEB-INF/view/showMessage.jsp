<%@ page contentType="text/html;charset=UTF-8" %>
<%@include file="/WEB-INF/inc/globalConfig.jsp" %>
<!DOCTYPE html>    
<html>
	<head>
		<meta charset="utf-8">
		<title>Welcome</title>
	</head> 
	<body>
		<h2>${message.uStuName}</h2>
		<h2>${message.uStuSex}</h2>
		<h2>${message.uStuBirthday}</h2>
		<h2>${message.uStuHujiAddress}</h2>
		<h2>${message.uStuAddress}</h2>
		<h2>${message.uStuApplyDept}</h2>
		${message.parent }
		<c:forEach items="${message.parent}" var= "parents" varStatus ="status">
			<%-- <c:if test="parent!=null"> --%>
				 <h2>${parents.name}</h2>
				<h2>${parents.company}</h2> 
			<%-- </c:if> --%>
		</c:forEach>
		-----------------------
		<c:forEach items="${message.userAnswer}" var= "userAnswers" varStatus ="status">
			<%-- <c:if test="parent!=null"> --%>
				 <h2>${userAnswers.question}</h2>
				<h2>${userAnswers.answer}</h2> 
			<%-- </c:if> --%>
		</c:forEach>
	</body>
</html>
