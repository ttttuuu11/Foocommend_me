<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/include/include-link.jspf"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
html, body {
	width: 100%;
	height: 100%;
}

.whitefont {
	color: white;
}

.loginform {
	border-radius: 15px;
}

.bgImg {
	height: 45%;
	width: 100%;
	overflow: hidden;
}

.bgImg img {
	height: auto;
	width: auto;
	margin-top: -10%;
	margin-bottom: -20%;
}

.bgImg img:after {
	background: rgba(0, 255, 0, 0.1);
}
</style>
</head>

<script>
	$(function() {
		// run the currently selected effect
		function runEffect() {
			// get effect type from
			var selectedEffect = $("#effectTypes").val();

			// Most effect types need no options passed by default
			var options = {};
			// some effects have required parameters
			if (selectedEffect === "scale") {
				options = {
					percent : 50
				};
			} else if (selectedEffect === "size") {
				options = {
					to : {
						width : 200,
						height : 60
					}
				};
			}

			// Run the effect
			$("#effect").hide(selectedEffect, options, 1000, callback);
		}
		;

		// Callback function to bring a hidden box back
		function callback() {
			setTimeout(function() {
				$("#effect").removeAttr("style").hide().fadeIn();
			}, 1000);
		}
		;

		// Set effect from select menu value
		$("#joinBtn").on("click", function() {
			runEffect();
		});

		// Set effect from select menu value
		$("#loginBtn").on("click", function() {
			$("#loginForm").attr("action", "/foocommend/loginCheck");
			$("#loginForm").attr("method", "post");
			$("#loginForm").submit();
		});

	});
</script>

<body class="text-center bg-primary">
	<div class="container justify-content-center">
		<h1 class="whitefont">Foocommend</h1>
		<c:forEach var="memberItem" items="${list }"
			varStatus="status">
			<p>${memberItem.mem_id }</p>
		</c:forEach>

		<div class="row justify-content-center">
			<div
				class="loginform card border-primary col-xl-4 col-lg-5 col-md-7 col-sm-10 col-10">
				<form class="form-signin mt-3" id="loginForm">
					<div class="form-label-group mb-2">
						<input type="text" class="form-control" id="memId" name="memId"
							placeholder="ID">
					</div>
					<div class="form-label-group mb-2">
						<input type="password" class="form-control" id="memPw"
							name="memPw" placeholder="PASSWORD">
					</div>
					<div class="custom-control custom-checkbox mb-3">
						<input type="checkbox" id="rememberId" name="rememberId"
							class="custom-control-input"> <label
							class="custom-control-label" for="rememberId">Remember me</label>
					</div>
					<input name="${_csrf.parameterName}" type="hidden"
						value="${_csrf.token}" />
					<button type="button" class="btn btn-primary btn-block"
						id="loginBtn">로그인</button>
					<button type="button" class="btn btn-light btn-block mb-3"
						id="joinBtn">회원가입</button>
					<c:if test="${not empty SPRING_SECURITY_LAST_EXCEPTION}">
						<font color="red" class="mb-3">
							<p>
								Your login attempt was not successful due to <br />
								${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message}
							</p> <c:remove var="SPRING_SECURITY_LAST_EXCEPTION" scope="session" />
						</font>
					</c:if>

				</form>
			</div>

		</div>

	</div>
	<!-- 
	<div class="bgImg mt-5 fixed-bottom">
		<img src="<c:url value='/resources/ui_image/bg_pizza.jpg'/>"
			alt="backgroundImg" width="100%" height="30%">
	</div>
	 -->
</body>
</html>