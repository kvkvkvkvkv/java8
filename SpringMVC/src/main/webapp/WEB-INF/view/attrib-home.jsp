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

<h2>${name}</h2>

<br>
modelAttributes

<form action="modelAttributes" >
    <input type="submit" value="Submit"/>
</form>


</body>
</html>
