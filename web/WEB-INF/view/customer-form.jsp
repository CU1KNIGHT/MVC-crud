<%-- Add support for Spring MVC From Tags--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="from" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>customer form</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
          integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">

</head>
<body>
<%--       action= send to spring MVC mapping  ( in CustomerController.java: @PostMapping("/saveCustomer")   )    --%>
<%--                                             same as customer in addAtrribure in showFormForAdd method in CustomerController--%>
<form:form action="saveCustomer" modelAttribute="customer" method="post">
    <%--            need to associate this data with customer id --%>
    <from:hidden path="id"/>

    <div class="container">
        <h3> Save Customer</h3>
        <div class="row">
            <div class="col">
                <form:input path="firstName" type="text" class="form-control" placeholder="First name"/>
            </div>
            <div class="col">
                <form:input path="lastName" type="text" class="form-control" placeholder="Last name"/>

            </div>
            <div class="col">
                <form:input path="email" type="text" class="form-control" placeholder="email"/>
            </div>

        </div>
        <div style="clear: both;"></div>
        <div class="col">
            <button type="submit" class="btn btn-primary">Submit</button>
        </div>
    </div>
</form:form>

</body>
</html>
