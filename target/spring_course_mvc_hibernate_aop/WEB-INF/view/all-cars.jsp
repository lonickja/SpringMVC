<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<body>
<h2>All Cars</h2>
<br>
<table>
    <tr>
        <th>Brand</th>
        <th>PH</th>
        <th>Year</th>
        <th>Operations</th>
    </tr>

    <c:forEach var="car" items="${allCars}">

        <c:url var="updateButton" value="/updateCar">
            <c:param name="carId" value="${car.id}"/>
        </c:url>

        <tr>
            <td>${car.brand}</td>
            <td>${car.ph}</td>
            <td>${car.year}</td>
            <td>
                <input type="button" value="Update"
                       onclick="window.location.href='${updateButton}'"/>
            </td>
        </tr>
    </c:forEach>
</table>
<br>
<input type="button" value="Add" onclick="window.location.href='addNewCar'"/>
</body>
</html>