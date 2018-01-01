/**
 * Created by yektan on 1.01.2018.
 */
$(document).ready(function () {

    $("#credit-form").submit(function (event) {

        //stop submit the form, we will post it manually.
        event.preventDefault();

        fire_ajax_submit();

    });

});

function fire_ajax_submit() {

    var credit = {}
    credit = $("#credit").val();

    $("#btn-send").prop("disabled", true);

    $.ajax({
        type: "POST",
        contentType: "application/json",
        url: "/api/whatismyrate",
        data: JSON.stringify(credit),
        dataType: 'json',
        cache: false,
        timeout: 600000,
        processData:false,
        success: function (data) {

            var json = "<h4>Sistemin Cevabı:</h4><div class='alert alert-success' role='alert'>"
                +"Kredi Dereceniz: "+ JSON.stringify(data, null, 4) + "</div>";
            $('#feedback').html(json);

            console.log("SUCCESS : ", data);
            $("#btn-send").prop("disabled", false);

        },
        error: function (e) {

            var json = "<h4>Sistemin Cevabı:</h4><div class='alert alert-danger' role='alert'>"
                +"Hata: "+ "Lütfen girmiş olduğunuz değeri kontrol edip tekrar deneyiniz." + "</div>";
            $('#feedback').html(json);

            console.log("ERROR : ", e);
            $("#btn-send").prop("disabled", false);

        }
    });

}
