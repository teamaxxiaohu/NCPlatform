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

    /* show more register information*/
    $("#showMore").click(function(){
        if($(this).html()=="More Information"){
            $(".hideCurrent").css({"display":"block"});
            $(this).html("Hidden");
        }else if($(this).html()=="Hidden"){
            $(".hideCurrent").css({"display":"none"});
            $(this).html("More Information");
        }
    });

    $("input[name='cardTypee']").bind("click",function(){
        alert($(this).value);
    });
});