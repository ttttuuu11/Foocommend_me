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
		// Set effect from select menu value
		$("#loginBtn").on("click", function() {
			location.href="/member/login"
		});

		// Set effect from select menu value
		$("#registerBtn").on("click", function() {
			$("#joinform").attr("action", "/foocommend/member/joinMem");
			$("#joinform").attr("method", "post");
			$("#joinform").submit();
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
				class="joinform card border-primary col-xl-4 col-lg-5 col-md-7 col-sm-10 col-10">
				<form class="form-signin mt-3" id="loginForm">
					<div class="form-label-group mb-2">
						<input type="text" class="form-control" id="username" name="username"
							placeholder="ID">
					</div>
					<div class="form-label-group mb-2">
						<input type="password" class="form-control" id="password"
							name="password" placeholder="PASSWORD">
					</div>
					<button type="button" class="btn btn-primary btn-block"
						id="registerBtn">가입하기</button>
					<button type="button" class="btn btn-light btn-block mb-3"
						id="loginBtn">돌아가기</button>
				</form>
			</div>

		</div>

	</div>
</body>
</html>