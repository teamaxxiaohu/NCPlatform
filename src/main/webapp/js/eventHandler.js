/**
 * Created by Vincent_2 on 2014/12/16.
 * This js file is mainly to solve the button click events.
 */

$(document).ready(function(){

    /* user register button event */
    $("#btn_reg").click(function(){

        $.ajax({
            url :  "/register",
            type:"get",
            dataType : "text/html"
        });

    });


});