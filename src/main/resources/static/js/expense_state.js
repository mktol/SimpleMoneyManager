$( document ).ready(function() {



    // $('#expenseTable').DataTable();
    // Handler for .ready() called.
    console.log("Im loaded!!! ");
    console.log("res/stat/js!!! ");



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
    console.log(cost);
});

$( "#target" ).submit(function( event ) {
    alert( "Handler for .submit() called." );
    event.preventDefault();
});

$("#updateTb").on("click", function () {
    $.ajax(
        {
            type: "POST",
            url: "/personal/expenses",

            contentType: "application/json; charset=utf-8",
            dataType: "json",
            success: function (data) {

                $('#expenseTable').DataTable({
                    data: data,
                    columns: [
                        { data: 'name' },
                        { data: 'position' },
                        { data: 'salary' },
                        { data: 'office' }
                    ]})

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


}); // ready end
