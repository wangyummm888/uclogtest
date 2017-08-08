<%--
  Created by IntelliJ IDEA.
  User: wangyu
  Date: 2017/8/7
  Time: 17:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="http://libs.baidu.com/jquery/2.0.0/jquery.min.js" type="text/javascript"></script>
    <script type="text/javascript">
        $(document).ready(function () {
            setInterval("startRequest()",1000);
        });
        function startRequest()
        {
                var logId=$("#logId").val();
                var topic=$("#topic").val();
                var lineNum=100;
                var data = {logId:logId,topic:topic,size:lineNum};
                $.ajax({
                    type : "get",
                    dataType : 'json',
                    async : false, //同步请求
                    url : "/uclogtest/getLog.do",
                    data : data,
                    timeout:1000,
                    success:function(dates){
                        var loggerId=null;
                        if(dates==null||dates.length ==0){
                            return ;
                        }else{
                        $.each(dates,function(i,data){
                            $("#logText").append(data.serverIp+"\n");
                            $('#logText').scrollTop( $('#logText')[0].scrollHeight );
                            loggerId=data.loggerId;
                        });
                        $("#logId").attr("value",loggerId);
                        }
                    },
                    error: function() {
                    }
                });
        }

    </script>
</head>
<body>
<p>日志内容</p>
<textarea id="logText" name="logText" readonly="readonly" rows="10" cols="20">
</textarea>
<input id="logId" type="hidden" value="0"/>
<input id="topic" type="hidden" value="product_crm"/>
</body>
</html>
