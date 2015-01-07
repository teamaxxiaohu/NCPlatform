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
        <div class="panel panel-default">
            <div class="panel-heading">
                <h3 class="panel-title">User Register </h3>
            </div>
            <div class="panel-body">
                <div class="btn-group">
                    <button type="button" class="btn btn-default">Phone Number Register</button>
                    <button type="button" class="btn btn-default">Email Address Register</button>
                    <button type="button" id="reg_person" class="btn btn-default">Personal Information Register</button>
                </div>
                <p>
                <div id="div_reg_personal"  class="panel panel-default">
                    <form name="usrReg" action="/register/doRegister" method="post">
                        <div class="input-group">
                            <span class="input-group-addon">User Name:</span>
                            <input type="text" name="userName" class="form-control" placeholder="enter your name here " maxlength="16">
                        </div>
                        <div class="alert alert-info lineHeight15">Make sure that the length of your user name should be between 6 to 16</div>
                        <div class="input-group">
                            <span class="input-group-addon">Password key:</span>
                            <input type="password" name="userPwd" class="form-control" placeholder="enter your password here" maxlength="16">
                        </div>
                        <div class="alert alert-info lineHeight15">Your password should be easy to keep and hard to lose</div>
                        <div class="input-group">
                            <span class="input-group-addon">E-mail Address:</span>
                            <input type="text" name="userEmail" class="form-control" placeholder="enter your E-mail here" maxlength="16">
                        </div>
                        <div class="alert alert-info lineHeight15">Please enter an E-mail address that often in use.</div>
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
