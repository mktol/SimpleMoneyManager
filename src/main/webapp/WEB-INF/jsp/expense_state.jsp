<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
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
    <link href="https://cdn.datatables.net/1.10.12/css/dataTables.bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <%--<link href="<c:url value="/pages/css/jumbotron-narrow.css" />" rel="stylesheet">--%>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.0/jquery.min.js"></script>
   <%--table--%>
    <script src="https://code.jquery.com/jquery-1.12.3.js"></script>
    <script src="https://cdn.datatables.net/1.10.12/js/jquery.dataTables.min.js"></script>
    <script src="https://cdn.datatables.net/1.10.12/js/dataTables.bootstrap.min.js"></script>



    <script src="/js/expense_state.js"></script>
    <script src="/js/typeahead.bundle.js"></script>
    <%--<script src="/js/jquery-3.1.0.js"></script>--%>

    <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
    <!--<script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>-->
    <!--<script src="https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js"></script>-->
    <![endif]-->
</head>

<body>


    <div class="container">
        <h2>${user_name}</h2>
        <h2>${user_email}</h2><h5>All spent: ${expense_sum}; not current user</h5>
        <form action="/personal/expense" method="post" id="expenseForm">
            <fieldset class="form-group">
                <label for="cost">Цена</label>
                <input type="text" class="form-control" id="cost" placeholder="Цена">
            </fieldset>
            <fieldset class="form-group">
                <label for="description">Товар</label>
                <input type="text" class="form-control" id="description" placeholder="Описание">
            </fieldset>

            <fieldset class="form-group" id="remote">
                <label for="category">категория</label>
                <input type="text" class="form-control typeahead col-md-4" id="category" placeholder="категория">
            </fieldset>

            <input type="submit" class="btn btn-default" value="submit">
        </form>


        <table id = "expenseTable" class="table">
            <thead>
            <tr>
                <th>description</th>
                <th>cost</th>
                <th>category</th>
                <th>creation date</th>
            </tr>
            </thead>
            <tbody>


            </tbody>
        </table>

        <hr>
    </div>
</body>
</html>