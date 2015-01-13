<%--
  Created by IntelliJ IDEA.
  User: Vincent_2
  Date: 2014/12/16
  Time: 23:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
  String ctxPath = request.getContextPath();
%>
<html>
  <head>
      <title>User Register Page </title>
      <!-- css files links -->
      <link rel="stylesheet" type="text/css" href="<%=ctxPath%>/themes/default/easyui.css">
      <link rel="stylesheet" type="text/css" href="<%=ctxPath%>/themes/icon.css">
      <link rel="stylesheet" type="text/css" href="<%=ctxPath%>/css/index.css">

      <!-- bootstrap css include -->
      <link rel="stylesheet" type="text/css" href="<%=ctxPath%>/css/bootstrap.min.css">
      <link rel="stylesheet" type="text/css" href="<%=ctxPath%>/css/bootstrap-theme.min.css">

      <!-- javascript file includes-->
      <script type="text/javascript" src="<%=ctxPath%>/js/jquery-1.11.1.js"></script>
      <script type="text/javascript" src="<%=ctxPath%>/js/jquery.easyui.min.js"></script>
      <script type="text/javascript" src="<%=ctxPath%>/js/eventHandler.js"></script>
      <script type="text/javascript" src="<%=ctxPath%>/js/index.js"></script>
  </head>
  <body>
    <!-- reg_mainPanel -->
    <div id="reg_mainPanel" class="reg_mainPanel">
       <!-- layout panel-->
        <div class="panel panel-default autoHeight">
            <div class="panel-heading">
                <h3 class="panel-title">User Register </h3>
            </div>
            <div class="panel-body">
                <div id="div_reg_personal"  class="panel panel-default">
                    <form name="usrReg" action="/register/doRegister" method="post">
                        <div class="input-group">
                            <span class="input-group-addon">User Name:</span>
                            <input type="text" name="account" class="form-control" placeholder="enter your name here " maxlength="16">
                        </div>
                        <div class="alert alert-info lineHeight15" id="tip_username">Make sure that the length of your user name should be between 6 to 16</div>
                        <div class="input-group">
                            <span class="input-group-addon">Password key:</span>
                            <input type="password" name="password" class="form-control" placeholder="enter your password here" maxlength="16">
                        </div>
                        <div class="alert alert-info lineHeight15" id="tip_password">Your password should be easy to keep and hard to lose</div>
                        <div class="input-group">
                            <span class="input-group-addon">Nick Name:</span>
                            <input type="text" name="nickName" class="form-control" placeholder="enter your nick name here " maxlength="16">
                        </div>
                        <div class="alert alert-info lineHeight15" id="tip_nickname">Make sure that the length of your user name should be between 6 to 16</div>
                        <div class="input-group">
                            <span class="input-group-addon">E-mail Address:</span>
                            <input type="text" name="emailAddress" class="form-control" placeholder="enter your E-mail here" maxlength="16">
                        </div>
                        <div class="alert alert-info lineHeight15" id="tip_email">Please enter an E-mail address that often in use.</div>
                       <div class="hideCurrent">
                           <div class="input-group">
                               <span class="input-group-addon">Phone Number:</span>
                               <input type="text" name="phoneNum" class="form-control" placeholder="enter your phone number" maxlength="13">
                           </div>
                           <div class="alert alert-info lineHeight15" id="tip_phone">your phone number like 138xxxxxxx or 010-11111111.</div>
                       </div>
                        <div class="hideCurrent">
                            <div class="input-group">
                                <span class="input-group-addon">Birth Date:</span>
                                <input type="text" name="birthday" class="form-control" placeholder="enter your birth date" maxlength="13">
                            </div>
                            <div class="alert alert-info lineHeight15" id="tip_birth">your birthday. format like 20150101</div>
                        </div>
                        <div class="hideCurrent">
                            <div class="input-group">
                                <span class="input-group-addon">Address Info:</span>
                                <input type="text" name="address" class="form-control" placeholder="enter your address" maxlength="13">
                            </div>
                            <div class="alert alert-info lineHeight15" id="tip_address">the place you can receive goods.</div>
                        </div>
                        <div class="hideCurrent">
                            <span class="input-group-addon">Card Type:</span>
                            <div class="btn-group" data-toggle="buttons">
                                <label class="btn btn-primary">
                                    <input type="radio" name="cardType" id="option1" value="1"> ID_CARD
                                </label>
                                <label class="btn btn-primary">
                                    <input type="radio" name="cardType" id="option2" value="2"> DRIVER_LICENCE
                                </label>
                                <label class="btn btn-primary">
                                    <input type="radio" name="cardType" id="option3" value="3"> SOCIAL_CARD
                                </label>
                                <label class="btn btn-primary">
                                    <input type="radio" name="cardType" id="option4" value="4"> STUDENT_CARD
                                </label>
                            </div>
                            <div class="alert alert-info lineHeight15" id="tip_cardType">please choose your card type.</div>
                        </div>
                        <div class="hideCurrent">
                            <div class="input-group">
                                <span class="input-group-addon">Address Info:</span>
                                <input type="text" name="cardNum" class="form-control" placeholder="enter your Card Number here" maxlength="18">
                            </div>
                            <div class="alert alert-info lineHeight15" id="tip_cardNum">the place you can receive goods.</div>
                        </div>
                        <div class="moreInfo"><button id="showMore" type="button" class="btn btn-default">More Information</button></div>
                        <div class="btn_area">
                            <button type="reset" class="btn btn-default">Rewrite</button>
                            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            <button type="submit" class="btn btn-default">I'm Sure</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
  </body>

</html>
