<%--
  Created by IntelliJ IDEA.
  User: Mahmoud
  Date: 20/09/17
  Time: 1:44 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>show customers list</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
          integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
</head>
<body>
<%-- add a search box--%>
<form:form action="search" method="GET">
    serach Customer: <input type="text" name="searchName" />
    <button type="submit" class="btn btn-primary" value="Search">search</button>
    <input type="submit" value="Search" class="add-button" />

</form:form>
<table class="table table-striped">
    <thead>
    <tr>
        <th scope="col">id</th>
        <th scope="col"> First name</th>
        <th scope="col">Last name</th>
        <th scope="col">email</th>
        <th scope="col">Action</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="tempCustomer" items="${customers}">
        <!-- construct an "update" link with customer id -->
        <c:url var="updateLink" value="/customer/showFormForUpdate">
            <c:param name="customerId" value="${tempCustomer.id}"/>
        </c:url>
<%--        construct an "delete link with customer id--%>
        <c:url var="deleteLink" value="/customer/delete">
            <c:param name="customerId" value="${tempCustomer.id}"/>
        </c:url>
        <tr scope="row">
            <td>${tempCustomer.id}</td>
            <td>${tempCustomer.firstName}</td>
            <td>${tempCustomer.lastName}</td>
            <td>${tempCustomer.email}</td>
            <td>
                <a href="${updateLink}">Update</a>
                |
                <a href="${deleteLink}"  onclick="if (!(confirm('Are you sure you want to delete this customer?'))) return false"  >delete</a>

            </td>
        </tr>
    </c:forEach>

    </tbody>
</table>

<%-- add button --%>
<input type="button" value="Add Customer" onclick="window.location.href='showFormForAdd'; return false;"
       class="button"/>
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js" integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV" crossorigin="anonymous"></script>
</body>


</html>
