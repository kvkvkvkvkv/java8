<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<body>

<h2>You Winnin</h2>


First Name
${student.firstName}
<br>
Last Name
${student.lastName}
<br>
Country
${student.country}
<br>
Language
${student.language}
<br>
OS
<ul>
    <c:forEach var="val" items="${student.os}">
        <li>${val}</li>
    </c:forEach>
</ul>


</body>
</html>
