<%--
  Created by IntelliJ IDEA.
  User: wangyu
  Date: 2017/8/10
  Time: 11:19
  To change this template use File | Settings | File Templates.
--%>

<%
    String path = request.getContextPath();
    request.setAttribute("path",path);
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
    request.setAttribute("basePath",basePath);

%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>


<script type="text/javascript" src="${path}/layui/layui.js"></script>
<script type="text/javascript" src="${path}/layui/layui.js"></script>
<link rel="stylesheet" href="${path}/layui/css/layui.css" media="all" />

<script type="text/javascript">
    layui.use('layer', function(){
        var layer = layui.layer;
        layer.msg('${errorMessage}',function(){
            window.location.href="${path}/login/toLogin.do";
        })
    });
</script>
</html>
