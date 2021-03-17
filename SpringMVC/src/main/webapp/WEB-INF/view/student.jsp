<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<body>

<h2>You Winnin</h2>

<form:form action="processForm" modelAttribute="student">

First Name
<form:input path="firstName"/>
<br>
Last Name
<form:input path="lastName"/>
<br>
Country
<form:select path="country">
    <!--<form:option value="India" label="India"/>
    <form:option value="France" label="France"/>-->

    <form:options items="${student.values}"/>
</form:select>
<br>
Language
<br>
Java<form:radiobutton path="language" value="Java"/>
Python<form:radiobutton path="language" value="Python"/>
<br>
OS
<br>
Win <form:checkbox path="os" value="win"/>
Linux <form:checkbox path="os" value="Linux"/>


<input type="submit" value="Submit"/>

</form:form>



</body>
</html>
