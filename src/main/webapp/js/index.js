/**
 * Created by Vincent_2 on 2014/12/16.
 */
$(document).ready(function(){

    /*Register button click event handler*/
    $("#register").bind("click",function(){
        location.href="/register";
    });

    /* commit login information*/
    $("#doLogin").bind("click",function(){
        location.href="/doLogin";
    });

    /* show register panel when button clicked*/
    $("#div_reg_personal").bind("click",function(){
        $("#div_reg_personal").css({"display":"block"});
    });
});