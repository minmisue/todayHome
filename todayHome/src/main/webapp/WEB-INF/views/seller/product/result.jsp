<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: kun
  Date: 2023/06/01
  Time: 4:37 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
	<title>Title</title>
</head>
<body>
<div style="display: flex; flex-direction: column; justify-content: center; align-items: center; border: 1px solid black; width: 700px; margin: 100px auto; padding: 50px">
	<h2>[${user.userName}] 가입 완료 되었습니다.</h2>
	<p>id : ${user.userId}</p>

	<c:forEach items="${user.schoolName}" var="name" varStatus="status">
		<p>학교명 : ${name}, 기간 : [ ${user.schoolDate1.get(status.index)} ~ ${user.schoolDate2.get(status.index)} ]</p>
	</c:forEach>

	<c:forEach items="${user.licenseName}" var="name" varStatus="status">
		<p>자격증명 : ${name}, 취득 일자 : ${user.licenseDate.get(status.index)}</p>
	</c:forEach>
</div>


</body>
</html>
