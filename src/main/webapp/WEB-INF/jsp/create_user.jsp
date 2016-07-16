<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Spring Security</title>

    <!-- Bootstrap core CSS -->
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <%--<link href="<c:url value="/pages/css/signin.css" />" rel="stylesheet">--%>

    <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js"></script>
    <![endif]-->
</head>

<body>

<div class="container" style="width: 300px;">
    <form:form action = "/user/create" method="post" commandName="form" >
        <div class="form-group">
            <label for="Email">Email address</label>
            <form:input path="email" type="email" class="form-control col-sm-6" id="email" placeholder="Email"/> <form:errors path="email" cssClass="error"/>
        </div>
        <div class="form-group">
            <label for="name">name</label>
            <form:input path="name" type="text" class="form-control col-sm-6" id="name" placeholder="name"/>
        </div>
        <div class="form-group">
            <label for="password">Password</label>
            <form:input path="password" type="password" class="form-control col-sm-6" id="password" placeholder="Password"/> <form:errors path="password" cssClass="error"/>
        </div>


        <button type="submit" class="btn btn-default">Submit</button>
    </form:form>


</div>

</body>
</html>