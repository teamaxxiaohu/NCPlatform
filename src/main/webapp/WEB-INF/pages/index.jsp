<%@ page import="com.gov.nc.bean.Account" %>
<%--
  Created by IntelliJ IDEA.
  User: Vincent_2
  Date: 2015/1/12
  Time: 15:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
 This is success page !
 <%
     Account account = (Account)session.getAttribute("curUser");

 %>
</body>
</html>
