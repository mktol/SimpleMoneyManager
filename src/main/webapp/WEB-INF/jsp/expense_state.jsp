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

    <!-- Custom styles for this template -->
    <%--<link href="<c:url value="/pages/css/jumbotron-narrow.css" />" rel="stylesheet">--%>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.0/jquery.min.js"></script>

    <script src="/js/expense_state.js"></script>
    <script src="/js/jquery-3.1.0.js"></script>

    <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js"></script>
    <![endif]-->
</head>

<body>
<<<<<<< HEAD
<div class="container">

    <form action="/personal/expense" method="post" id="expenseForm">
        <fieldset class="form-group">
            <label for="cost">Цена</label>
            <input type="text" class="form-control" id="cost" placeholder="Цена">
        </fieldset>
        <fieldset class="form-group">
            <label for="description">Товар</label>
            <input type="text" class="form-control" id="description" placeholder="Описание">
        </fieldset>

        <fieldset class="form-group">
            <label for="category">категория</label>
            <input type="text" class="form-control" id="category" placeholder="категория">
        </fieldset>

        <input type="submit" class="btn btn-default" value="submit">
    </form>

    <input type="button" id="updateTb" class="btn btn-success" value="update table">
    <input type="text" id="categoryName"  value="food">
    <input type="button" id="findExpBuCat" class="btn btn-success" value="find by category">

    <table class="display" id="expenseTable">
        <thead>
        <tr>

            <th>description</th>
            <th>cost</th>
            <th>category</th>
            <th>creationDate</th>
        </tr>
        </thead>
        <tbody>
        <tr class="success">
            <td id="desc"></td>
            <td id="cost_id"></td>
            <td id="category_val"></td>
            <td id="date"></td>

        </tr>
        <tr>
            <td>desc blaba</td>
            <td> fal</td>
            <td>gak</td>
            <td>mak</td>

        </tr>

        </tbody>
    </table>

</div>
=======
    <div class="container">

        <form action="/personal/expense" method="post" id="expenseForm">
            <fieldset class="form-group">
                <label for="cost">Цена</label>
                <input type="text" class="form-control" id="cost" placeholder="Цена">
            </fieldset>
            <fieldset class="form-group">
                <label for="description">Товар</label>
                <input type="text" class="form-control" id="description" placeholder="Описание">
            </fieldset>

            <fieldset class="form-group">
                <label for="category">категория</label>
                <input type="text" class="form-control" id="category" placeholder="категория">
            </fieldset>

            <input type="submit" class="btn btn-default" value="submit">
        </form>


        <table class="table">
            <thead>
            <tr>
                <th>id</th>
                <th>description</th>
                <th>cost</th>
                <th>category</th>
                <th>creation date</th>
            </tr>
            </thead>
            <tbody>
            <tr class="success">
                <td id="id"></td>
                <td id="desc"></td>
                <td id="cat"></td>
                <td id="date"></td>

            </tr>

            </tbody>
        </table>
        <script>
            $( document ).ready(function() {
                // Handler for .ready() called.
                console.log("Im loaded!!! ");
                console.log("res/stat/js!!! ");
            });
            $(function() {
                $("#expense_form").submit("click", function (event) {
                    event.preventDefault();
                    var cost = $("#cost").val();
                    console.log(cost);
                });
            });
            $("#expenseForm").submit( function (event) {
                event.preventDefault();
                var cost = $("#cost").val();
                var description = $("#description").val();
                var category = $("#category").val();
                ;
                $.ajax(
                        {
                            type: "POST",
                            url: "/personal/expense",
                            data: JSON.stringify({cost, description, category}),
                            contentType: "application/json; charset=utf-8",
                            dataType: "json",
                            success: function (data) {
                                alert(data);
                            },
                            failure: function (errMsg) {
                                alert(errMsg);
                            }
                        }
                );
            });

            $( "#target" ).submit(function( event ) {
                alert( "Handler for .submit() called." );
                event.preventDefault();
            });



            $( "#other" ).click(function() {
                $( "#target" ).submit();
            });

            var putExpenseInTable =  function(data){

            }
        </script>
    </div>
>>>>>>> 45468d1978d9425efa6c6ac6e848508ba6f27729
</body>
</html>