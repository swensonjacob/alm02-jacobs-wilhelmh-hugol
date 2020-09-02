$(document).ready(function () {

    $("#fortune-btn").click(function () {

        $.getJSON('http://localhost:8081/fortune?name=' + $('#full-name').val() +
            '&nationality=' + $('#nationality').val() +
            '&age=' + $('#age').val(), function (data) {

            $("#text-area").val(data.message);
        });
    });
});