<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2019-04-17
  Time: 13:25
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %><html>
<head>
    <title>Index</title>
</head>
<body>
<jsp:include page="../partials/navbar.jsp" />

<h1>Here are all the Ads:</h1>

<c:forEach var="Ad" items="${Ads}">
    <div class="ads">
        <h2>${Ad.getTitle()}</h2>
    </div>
</c:forEach>
</body>
</html>
