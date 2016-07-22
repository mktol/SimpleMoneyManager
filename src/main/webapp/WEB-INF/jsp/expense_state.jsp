<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>

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
    <%--<link href="<c:url value="/pages/css/jumbotron-narrow.css" />" rel="stylesheet">--%>

    <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js"></script>
    <![endif]-->
</head>

<body>
    <div class="container">
        <form action="/personal/expense" method="post">
            <fieldset class="form-group">
                <label for="cost">Цена</label>
                <input type="text" class="form-control" id="cost" placeholder="Цена">
            </fieldset>
            <fieldset class="form-group">
                <label for="description">Товар</label>
                <input type="text" class="form-control" id="description" placeholder="Описание">
            </fieldset>

            <fieldset class="form-group">
                <label for="category">Товар</label>
                <input type="text" class="form-control" id="category" placeholder="категория">
            </fieldset>

            <fieldset class="form-group">
                <label for="expense">Товар</label>
                <input type="text" class="form-control" id="expense" placeholder="Товар">
            </fieldset>
            <button type="submit" class="btn btn-default">Submit</button>
        </form>
    </div>
</body>
</html>