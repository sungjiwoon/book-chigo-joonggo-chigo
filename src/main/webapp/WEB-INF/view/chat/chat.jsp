<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>

<head>
	<link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet"
		  id="bootstrap-css">
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	<link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.css" type="text/css"
		  rel="stylesheet">
	<link href="<c:url value="/style/chat/chat.css" />" rel="stylesheet">
	<script src="<c:url value="/js/socket.io.min.js" />"></script>
</head>

<body>
<div class="container">
	<h3 class=" text-center">채팅방</h3>
	<div class="messaging">
		<div class="inbox_msg">
			<div class="mesgs">
				<div class="msg_history">
				</div>
				<div class="type_msg">
					<div class="input_msg_write">
						<input type="text" class="write_msg" placeholder="메시지를 입력하세요."/>
						<button class="msg_send_btn" type="button"><i class="fa fa-paper-plane-o"
																	  aria-hidden="true"></i></button>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
<script>
    $(function () {
        var memberId = "${memberId}";
        var username = "${username}";
        var chatId = "${chatId}";
        var chatRoomId = "${chatRoomId}";

        <c:forEach var="message" items="${messages}">
			var messageJson = {
			    memberId: "${message.memberId}",
                message: "${message.message}",
                registrationDate: "${message.registrationDate}",
				username: "${message.id}",
			}
        	if ("${message.memberId}" == memberId) {
                addMessage(messageJson, "O");
            } else {
                addMessage(messageJson, "I");
            }
		</c:forEach>

        var socket = io("http://118.67.134.49:3999");

        // 채팅방 접속
        socket.emit("login", {
            chatId: chatRoomId,
            username: username
        });

		// 서버로부터의 메시지가 수신되면
        socket.on("login", function (data) {
//            $("#chatLogs").append("<div><strong>" + data + "</strong> has joined</div>");
        });

// 서버로부터의 메시지가 수신되면
        socket.on("chat", function (data) {
            console.log("메시지 수신>> : " + JSON.stringify(data));
            if (username == data.username) {
                addMessage(data, "O");
            } else {
                addMessage(data, "I");
			}
        });

        $(".write_msg").on("keyup",function(key){
            console.log("key : " + key.keyCode);
            if(key.keyCode == 13) {
				sendMessage(key);
            }
        });

		$(".msg_send_btn").click(function(e) {
           sendMessage(e);
		});

        function sendMessage(e) {
            e.preventDefault();


            var $msgForm = $(".write_msg");
            if($msgForm.val() == "") return ;

            // 서버로 메시지를 전송한다.
            socket.emit("chat", {message: $msgForm.val(), username: username});

            var data = {
                memberId: memberId,
                id: username,
                chatId: chatId,
                message: $msgForm.val()
            };

            $msgForm.val("");

            $.ajax({
                url : "insert.do",
                type : "POST",
                data : JSON.stringify(data),
                dataType : 'json',
                contentType : "application/json",
                success: function(result) {
                }
            });
        }

    });

    function addMessage(data, type) {
        console.log("data : " + data);
        if (type == "I") {
            $(".msg_history").append("<div class=\"incoming_msg\">\n" +
                "\t\t\t\t\t\t<div class=\"incoming_msg_img\"> " + data.username + "</div>\n" +
                "\t\t\t\t\t\t<div class=\"received_msg\">\n" +
                "\t\t\t\t\t\t\t<div class=\"received_withd_msg\">\n" +
                "\t\t\t\t\t\t\t\t<p>" + data.message + "</p>\n" +
                "\t\t\t\t\t\t\t\t<span class=\"time_date\"> " + data.registrationDate + "</span>\n" +
                "\t\t\t\t\t\t\t</div>\n" +
                "\t\t\t\t\t\t</div>\n" +
                "\t\t\t\t\t</div>");
        } else if (type == "O") {
            $(".msg_history").append("<div class=\"outgoing_msg\">\n" +
                "\t\t\t\t\t\t<div class=\"sent_msg\">\n" +
                "\t\t\t\t\t\t\t<p>" + data.message + "</p>\n" +
                "\t\t\t\t\t\t\t<span class=\"time_date\"> " + data.registrationDate + "</span>\n" +
                "\t\t\t\t\t\t</div>\n" +
                "\t\t\t\t\t</div>");
		}
        $(".msg_history").scrollTop($(".msg_history")[0].scrollHeight);
	}
</script>
</body>

</html>
