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
    console.log(cost);
});

$( "#target" ).submit(function( event ) {
    alert( "Handler for .submit() called." );
    event.preventDefault();
});



$( "#other" ).click(function() {
    $( "#target" ).submit();
});