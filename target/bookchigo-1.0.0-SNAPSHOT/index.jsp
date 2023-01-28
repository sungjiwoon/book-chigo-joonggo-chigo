<%@ page contentType="text/html; charset=utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
	<title>Welcome</title>
</head>
<body>
<% response.sendRedirect(request.getContextPath() + "/main"); %>
</body>
</html>
