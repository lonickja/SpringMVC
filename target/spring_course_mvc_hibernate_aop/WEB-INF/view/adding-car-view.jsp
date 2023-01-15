<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<body>
<h2>Adding new Employee form</h2>
<br>
<form:form action="saveCar" modelAttribute="car">
    <form:hidden path="id"/>
    Brand<form:input path="brand"/>
    <br>
    PH<form:input path="ph"/>
    <br>
    Year<form:input path="year"/>
    <br>
    <input type="submit" value="OK"/>
</form:form>
</body>
</html>