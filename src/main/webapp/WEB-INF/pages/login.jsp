<%--
  Created by IntelliJ IDEA.
  User: Vincent_2
  Date: 2014/12/16
  Time: 21:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
  String ctxPath = request.getContextPath();
%>
<html>
<head>
    <title>南充12345公共平台</title>
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
    <!-- main div -- set a div at the center of screen -->
    <div id="mainDiv" class="mainDiv">
        <!-- login panel div-->
        <div id="loginPanel" class="loginPanel">
            <div class="panel panel-default">
                <div class="panel-heading">
                    <h3 class="panel-title">User Login</h3>
                </div>
                <div class="panel-body">
                    <form name="userLogin" action="/doLogin" method="post">
                        <div class="input-group">
                            <span class="input-group-addon">UserName:</span>
                            <input type="text" name="userName" class="form-control" maxlength="16">
                        </div>
                        <br/>
                        <div class="input-group">
                            <span class="input-group-addon">Password: </span>
                            <input type="password" name="userPwd" class="form-control" maxlength="16">
                        </div>
                        <br/>
                        <div class="btn_area">
                            <button type="button" class="btn btn-default" id="register">Register</button>
                            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            <button type="submit" id="doLogin" class="btn btn-default">Login in</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>

    </div>
</body>
</html>
