<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>

<head>
    <style>
        .error {
            color:red;
        }
    </style>
</head>
<body>

<h2>You Winnin</h2>

<form:form action="processForm" modelAttribute="customer">

First Name
<form:input path="firstName"/>
<br>
Last Name
<form:input path="lastName"/>
<form:errors path="lastName" cssClass = "error"/>

<br>
Passes
<form:input path="passes"/>
<form:errors path="passes" cssClass = "error"/>

<br>
Address
<form:input path="postalCode"/>
<form:errors path="postalCode" cssClass = "error"/>

<br>
Course code
<form:input path="courseCode"/>
<form:errors path="courseCode" cssClass = "error"/>

<input type="submit" value="Submit"/>

</form:form>


</body>
</html>
