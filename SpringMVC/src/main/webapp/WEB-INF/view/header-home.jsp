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
header
<form action="header" >
    <input type="submit" value="Submit"/>
</form>

<br>
headerInt
<form action="headerInt">
    <input type="submit" value="Submit"/>
</form>

<br>
multiHeader
<form action="multiHeader">
    <input type="submit" value="Submit"/>
</form>

</body>
</html>
