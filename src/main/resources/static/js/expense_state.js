$( document ).ready(function() {



    $('#expenseTable').DataTable();
    // Handler for .ready() called.
    console.log("Im loaded!!! ");
    console.log("res/stat/js!!! ");



$("#expenseForm").submit( function (event) {
    event.preventDefault();
    var cost = $("#cost").val();
    var description = $("#description").val();
    var category = $("#category").val();
    var expense = new Object();
    expense.cost = cost;
    expense.description = description;
    expense.category = category;
    var expenseJson = JSON.stringify(expense);
    $.ajax({
        url: "/personal/expense",
        type: "POST",
        contentType: "application/json; charset=utf-8",
        dataType: "json",
        data: expenseJson,
        success: function (data) {
            var table = $('#expenseTable').DataTable();
            table.row.add([
                123,
                data.description,
                data.cost,
                data.category,
                data.creationDate
            ]).draw(false);


        }
        ,
        failure: function (errMsg) {
            alert(errMsg);
        }

    });
});

$( "#target" ).submit(function( event ) {
    alert( "Handler for .submit() called." );
    event.preventDefault();
});

$("#findExpBuCat").on("click", function(){
    var category = $("#categoryName").val();
    var url = "/personal/expenses/"+category;
    $.ajax({
        url:url,
       type: "GET",
        contentType: "application/json; charset=utf-8",
        dataType: "json",
        success: function (data) {
            var table = $('#expenseTable').DataTable();
            for(var rNumber in data){
                var r = data[rNumber];
                console.log(r);
                table.row.add([
                    r.description,
                    r.cost,
                    r.category,
                    r.creationDate
                ]).draw(false);
            }


        }
        ,
        failure: function (errMsg) {
            alert(errMsg);
        }

    });
});

$("#updateTb").on("click", function () {
    $.ajax(
        {
            type: "POST",
            url: "/personal/expenses",

            contentType: "application/json; charset=utf-8",
            dataType: "json",
            success: function (data) {
                var table = $('#expenseTable').DataTable();
                for(var rNumber in data){
                    var r = data[rNumber];
                    console.log(r);
                    table.row.add([
                        r.description,
                        r.cost,
                        r.category,
                        r.creationDate
                    ]).draw(false);
                }


            }
            ,
            failure: function (errMsg) {
                alert(errMsg);
            }
        }
    );
});

$( "#other" ).click(function() {
    $( "#target" ).submit();
});




    $('input[name=category]').typeahead({
            //источник данных
            source: function (query, process) {
                return $.post('getusername', {'name':query},
                    function (response) {
                        var data = new Array();
                        //преобразовываем данные из json в массив
                        $.each(response, function(i, name)
                        {
                            data.push(i+'_'+name);
                        })
                        return process(data);
                    },
                    'json'
                );
            }
            //источник данных
            //вывод данных в выпадающем списке
            , highlighter: function(item) {
                var parts = item.split('_');
                parts.shift();
                return parts.join('_');
            }
            //вывод данных в выпадающем списке
            //действие, выполняемое при выборе елемента из списка
            , updater: function(item) {
                var parts = item.split('_');
                var userId = parts.shift();
                $.post('getuserdata', {'user_id':userId},
                    function (user) {
                        $('input[name=email]').val(user.email);
                        $('input[name=phone]').val(user.phone);
                    },
                    'json'
                );
                return parts.join('_');
            }
            //действие, выполняемое при выборе елемента из списка
        }
    );


}); // ready end
