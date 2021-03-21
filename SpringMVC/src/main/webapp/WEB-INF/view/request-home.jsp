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
Name
<form action="name" >
    <input type="text" name="name">
    <input type="submit" value="Submit"/>
</form>

<br>
Explicit Name
<form action="explicitName">
    <input type="text" name="name">
    <input type="submit" value="Submit"/>
</form>

<br>
required Name
<form action="requiredName">
    <input type="text" name="name">
    <input type="submit" value="Submit"/>
</form>

<br>
optionalName
<form action="optionalName">
    <input type="text" name="name">
    <input type="submit" value="Submit"/>
</form>

<br>
defaultName
<form action="defaultName">
     <input type="text" name="name">
    <input type="submit" value="Submit"/>
</form>

<br>
mapName
<form action="mapName">
    <input type="text" name="name">
    <input type="submit" value="Submit"/>
</form>

<br>
multiName
<form action="multiName">
    <input type="text" name="name">
    <input type="submit" value="Submit"/>
</form>



</body>
</html>
