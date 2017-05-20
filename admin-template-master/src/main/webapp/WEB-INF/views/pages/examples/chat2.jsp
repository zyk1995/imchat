<%--
  Created by IntelliJ IDEA.
  User: zyk
  Date: 2017/5/10
  Time: 21:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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

    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/bootstrap/css/bootstrap.min.css">
    <%--<!-- Font Awesome -->--%>
    <%--<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.5.0/css/font-awesome.min.css">--%>
    <%--<!-- Ionicons -->--%>
    <%--<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/ionicons/2.0.1/css/ionicons.min.css">css--%>
    <!-- Theme style -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/dist/css/AdminLTE.min.css">
    <link rel="alternate icon" type="image/png" href="${pageContext.request.contextPath}/resources/assets/i/favicon.png">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/assets/css/amazeui.min.css"/>

    <script src="${pageContext.request.contextPath}/resources/assets/js/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/assets/js/amazeui.min.js"></script>
    <!-- UM相关资源 -->
    <link href="${pageContext.request.contextPath}/resources/assets/umeditor/themes/default/css/umeditor.css" type="text/css" rel="stylesheet">
    <script type="text/javascript" charset="utf-8" src="${pageContext.request.contextPath}/resources/assets/umeditor/umeditor.config.js"></script>
    <script type="text/javascript" charset="utf-8" src="${pageContext.request.contextPath}/resources/assets/umeditor/umeditor.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/assets/umeditor/lang/zh-cn/zh-cn.js"></script>
</head>
<body>

<div id="main">
    <!-- 聊天内容展示区域 -->
    <div id="ChatBox" class="am-g am-g-fixed" >
        <div class="am-u-lg-12" style="height:400px;border:1px solid #999;overflow-y:scroll;">
            <ul id="chatContent" class="am-comments-list am-comments-list-flip">
                <li id="msgtmp" class="am-comment" style="display:none;">
                    <a href="">
                        <img class="am-comment-avatar" src="${pageContext.request.contextPath}/resources/assets/images/other.jpg" alt=""/>
                    </a>
                    <div class="am-comment-main" >
                        <header class="am-comment-hd">
                            <div class="am-comment-meta">
                                <a ff="nickname" href="#link-to-user" class="am-comment-author">某人</a>
                                <time ff="msgdate" datetime="" title="">2014-7-12 15:30</time>
                            </div>
                        </header>
                        <div ff="content" class="am-comment-bd">此处是消息内容</div>
                    </div>
                </li>
            </ul>
        </div>
    </div>
    <!-- 聊天内容发送区域 -->
    <div id="EditBox" class="am-g am-g-fixed">
        <!--style给定宽度可以影响编辑器的最终宽度-->
        <script type="text/plain" id="myEditor" style="width:100%;height:140px;"></script>
        <button id="send" type="button" class="am-btn am-btn-primary am-btn-block">发送</button>
    </div>

</div>
<script type="text/javascript">

    $(function(){

        //实例化编辑器
        var um = UM.getEditor('myEditor',{
            initialContent:"请输入聊天信息...",
            autoHeightEnabled:false,
            toolbar:[
                'source | undo redo | bold italic underline strikethrough | superscript subscript | forecolor backcolor | removeformat |',
                'insertorderedlist insertunorderedlist | selectall cleardoc paragraph | fontfamily fontsize' ,
                '| justifyleft justifycenter justifyright justifyjustify |',
                'link unlink | emotion image video  | map'
            ]
        });

        var nickname = "${loginUser.nickname}";
        var othername = "${other.nickname}";
        var socket = new WebSocket("ws://${pageContext.request.getServerName()}:${pageContext.request.getServerPort()}${pageContext.request.contextPath}/ChatSocket?nickname=${loginUser.nickname}");
        console.log("ws://${pageContext.request.getServerName()}:${pageContext.request.getServerPort()}${pageContext.request.contextPath}/ChatSocket");

        //接收服务器的消息
        socket.onmessage=function(ev){
            var obj = eval(   '('+ev.data+')'   );
            addMessage(obj);
        }

        $("#send").click(function(){
            if (!um.hasContents()) {  // 判断消息输入框是否为空
                // 消息输入框获取焦点
                console.log("pass1");
                um.focus();
                // 添加抖动效果
                $('.edui-container').addClass('am-animation-shake');
                setTimeout("$('.edui-container').removeClass('am-animation-shake')", 1000);
            } else {
                console.log("pass2");
                //获取输入框的内容
                var txt = um.getContent();
                //构建一个标准格式的JSON对象（划掉）字符串
                var obj = JSON.stringify({
                    loginId:"${loginUser.loginId}",
                    nickname:nickname,
                    content:txt,
                    to:othername
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
