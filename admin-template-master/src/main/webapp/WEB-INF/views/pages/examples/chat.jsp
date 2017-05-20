<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c"
           uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>AdminLTE | Dashboard</title>
    <meta content='width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no' name='viewport'>
    <!-- bootstrap 3.0.2 -->
    <link href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
    <!-- font Awesome -->
    <link href="${pageContext.request.contextPath}/resources/css/font-awesome.min.css" rel="stylesheet" type="text/css" />
    <!-- Ionicons -->
    <link href="${pageContext.request.contextPath}/resources/css/ionicons.min.css" rel="stylesheet" type="text/css" />
    <!-- Theme style -->
    <link href="${pageContext.request.contextPath}/resources/css/AdminLTE.css" rel="stylesheet" type="text/css" />

    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources//bootstrap/css/bootstrap.min.css">
    <%--<!-- Font Awesome -->--%>
    <%--<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.5.0/css/font-awesome.min.css">--%>
    <%--<!-- Ionicons -->--%>
    <%--<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/ionicons/2.0.1/css/ionicons.min.css">css--%>
    <!-- Theme style -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/dist/css/AdminLTE.min.css">
    <!-- AdminLTE Skins. Choose a skin from the css/skins
         folder instead of downloading all of them to reduce the load. -->


</head>
<body>
<div class="box box-primary direct-chat direct-chat-primary">
    <div class="box-header with-border">
        <h3 class="box-title">Direct Chat</h3>
    </div>
    <!-- /.box-header -->
    <div class="box-body" style="margin: 40px">
        <!-- Conversations are loaded here -->
        <div class="direct-chat-messages">
            <!-- Message. Default to the left -->
            <div class="direct-chat-msg">
                <div class="direct-chat-info clearfix">
                    <span class="direct-chat-name pull-left">Alexander Pierce</span>
                    <span class="direct-chat-timestamp pull-right">23 Jan 2:00 pm</span>
                </div>
                <!-- /.direct-chat-info -->
                <img class="direct-chat-img" src="${pageContext.request.contextPath}/resources/dist/img/user1-128x128.jpg" alt="Message User Image"><!-- /.direct-chat-img -->
                <div class="direct-chat-text">
                    Is this template really for free? That's unbelievable!
                </div>
                <!-- /.direct-chat-text -->
            </div>
            <!-- /.direct-chat-msg -->

            <!-- Message to the right -->
            <div class="direct-chat-msg right">
                <div class="direct-chat-info clearfix">
                    <span class="direct-chat-name pull-right">Sarah Bullock</span>
                    <span class="direct-chat-timestamp pull-left">23 Jan 2:05 pm</span>
                </div>
                <!-- /.direct-chat-info -->
                <img class="direct-chat-img" src="${pageContext.request.contextPath}/resources/dist/img/user3-128x128.jpg" alt="Message User Image"><!-- /.direct-chat-img -->
                <div class="direct-chat-text">
                    You better believe it!
                </div>
                <!-- /.direct-chat-text -->
            </div>
            <!-- /.direct-chat-msg -->

            <!-- Message. Default to the left -->
            <div class="direct-chat-msg">
                <div class="direct-chat-info clearfix">
                    <span class="direct-chat-name pull-left">Alexander Pierce</span>
                    <span class="direct-chat-timestamp pull-right">23 Jan 2:00 pm</span>
                </div>
                <!-- /.direct-chat-info -->
                <img class="direct-chat-img" src="${pageContext.request.contextPath}/resources/dist/img/user1-128x128.jpg" alt="Message User Image"><!-- /.direct-chat-img -->
                <div class="direct-chat-text">
                    Is this template really for free? That's unbelievable!
                </div>
                <!-- /.direct-chat-text -->
            </div>
            <!-- /.direct-chat-msg -->

            <!-- Message to the right -->
            <div class="direct-chat-msg right">
                <div class="direct-chat-info clearfix">
                    <span class="direct-chat-name pull-right">Sarah Bullock</span>
                    <span class="direct-chat-timestamp pull-left">23 Jan 2:05 pm</span>
                </div>
                <!-- /.direct-chat-info -->
                <img class="direct-chat-img" src="${pageContext.request.contextPath}/resources/dist/img/user3-128x128.jpg" alt="Message User Image"><!-- /.direct-chat-img -->
                <div class="direct-chat-text">
                    You better believe it!
                </div>
                <!-- /.direct-chat-text -->
            </div>
            <!-- /.direct-chat-msg -->
        </div>
        <!--/.direct-chat-messages-->


    </div>
    <!-- /.box-body -->
    <div class="box-footer" >
        <form action="#" method="post">
            <div class="input-group">
                <input type="text" name="message" placeholder="Type Message ..." class="form-control">
                <span class="input-group-btn">
                        <button type="button" id="send" class="btn btn-primary btn-flat">Send</button>
                </span>
            </div>
        </form>
    </div>
    <!-- /.box-footer-->
    </div>
<script src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js" type="text/javascript"></script>
<!-- AdminLTE App -->
<script src="${pageContext.request.contextPath}/resources/js/AdminLTE/app.js" type="text/javascript"></script>
<!-- AdminLTE for demo purposes -->
<script src="${pageContext.request.contextPath}/resources/js/AdminLTE/demo.js" type="text/javascript"></script>

<!-- jQuery 2.2.3 -->
<script src="${pageContext.request.contextPath}/resources/plugins/jQuery/jquery-2.2.3.min.js"></script>
<!-- Bootstrap 3.3.6 -->
<script src="${pageContext.request.contextPath}/resources/bootstrap/js/bootstrap.min.js"></script>
<!-- Slimscroll -->
<script src="${pageContext.request.contextPath}/resources/plugins/slimScroll/jquery.slimscroll.min.js"></script>
<!-- FastClick -->
<script src="${pageContext.request.contextPath}/resources/plugins/fastclick/fastclick.js"></script>
<!-- AdminLTE App -->
<script src="${pageContext.request.contextPath}/resources/dist/js/app.min.js"></script>
<!-- AdminLTE for demo purposes -->
<script src="${pageContext.request.contextPath}/resources/dist/js/demo.js"></script>

<script type="text/javascript">

    $(function(){

        var nickname = "小龙虾"+Math.random();
        var socket = new WebSocket("ws://${pageContext.request.getServerName()}:${pageContext.request.getServerPort()}${pageContext.request.contextPath}/websocket");
        console.log("ws://${pageContext.request.getServerName()}:${pageContext.request.getServerPort()}${pageContext.request.contextPath}/websocket");

        //接收服务器的消息
        socket.onmessage=function(ev){
            var obj = eval(   '('+ev.data+')'   );
            addMessage(obj);
        }

        $("#send").click(function(){
            if (!um.hasContents()) {  // 判断消息输入框是否为空
                // 消息输入框获取焦点
                um.focus();
                // 添加抖动效果
                $('.edui-container').addClass('am-animation-shake');
                setTimeout("$('.edui-container').removeClass('am-animation-shake')", 1000);
            } else {
                //获取输入框的内容
                var txt = um.getContent();
                //构建一个标准格式的JSON对象（划掉）字符串
                var obj = JSON.stringify({
                    nickname:nickname,
                    content:txt
                });
                // 发送消息
                socket.send(obj);
                // 清空消息输入框
                um.setContent('');
                // 消息输入框获取焦点
                um.focus();
            }

        });
    });

    //人名nickname，时间date，是否自己isSelf，内容content
    function addMessage(msg){
        var box = $("#msgtmp").clone(); 	//复制一份模板，取名为box
        box.show();							//设置box状态为显示
        box.appendTo("#chatContent");		//把box追加到聊天面板中
        box.find('[ff="nickname"]').html(msg.nickname); //在box中设置昵称
        box.find('[ff="msgdate"]').html(msg.date); 		//在box中设置时间
        box.find('[ff="content"]').html(msg.content); 	//在box中设置内容
        box.addClass(msg.isSelf? 'am-comment-flip':'');	//右侧显示
        box.addClass(msg.isSelf? 'am-comment-warning':'am-comment-success');//颜色
        box.css((msg.isSelf? 'margin-left':'margin-right'),"20%");//外边距
        $("#ChatBox div:eq(0)").scrollTop(999999); 	//滚动条移动至最底部
    }
</script>
</body>
</html>