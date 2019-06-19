<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/include/include-link.jspf"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style>
.recommend-card {
	border-bottom: 2px solid gold;
}

.category-btn {
	background-color: #f8f9fa;
	margin: 3px;
	height: 200px
}

.category-text {
	margin-top: 50%;
}
</style>


</head>
<body>
	<!-- 
	<sec:authorize access="isAnonymous()">
		<h5>
			<a href='<c:url value="/member/loginMem"/>'>LOGIN</a> 로그인 해주세요.
		</h5>
	</sec:authorize>
 -->
	<div
		class="navbar navbar-expand fixed-top navbar-dark bg-primary shadow">
		<a class="navbar-brand h1" href="#">Foocommend</a>
		<div class="collapse navbar-collapse">
			<ul class="navbar-nav">
				<li class="nav-item dropdown"><a
					class="nav-link dropdown-toggle" data-toggle="dropdown" href="#"
					aria-expanded="true">test1</a>
					<div class="dropdown-menu">
						<a class="dropdown-item">test1-1</a> <a class="dropdown-item">test1-2</a>
						<a class="dropdown-item">test1-3</a> <a class="dropdown-item">test1-4</a>
					</div></li>
				<li class="nav-item dropdown"><a class="nav-link" href="#"
					aria-expanded="true">test2</a></li>
			</ul>
		</div>
	</div>
	<div class="text-center">
		<div class="container">
			<c:forEach var="recommentItem" items="${resultRecommendList }"
				varStatus="status">
				<p>${recommentItem.store_number }</p>
				<p>${recommentItem.store_name }
			</c:forEach>

			<div class="row justify-content-center">
				<div class="col-xl-2 col-lg-2 col-md-2 col-sm-5 col-4 mr-4">
					<div class=" recommend-card ">
						<a>1</a>
					</div>
					<div>
						<a><small>이미지 띄우고 설명</small></a>
					</div>
				</div>
				<div class="col-xl-2 col-lg-2 col-md-2 col-sm-5 col-4 mr-4">
					<div class=" recommend-card ">
						<a>2</a>
					</div>
					<div>
						<a><small>이미지 띄우고 설명</small></a>
					</div>
				</div>
				<div class="col-xl-2 col-lg-2 col-md-2 col-sm-5 col-4 mr-4">
					<div class=" recommend-card ">
						<a>3</a>
					</div>
					<div>
						<a><small>이미지 띄우고 설명</small></a>
					</div>
				</div>
				<div class="col-xl-2 col-lg-2 col-md-2 col-sm-5 col-4 mr-4">
					<div class=" recommend-card ">
						<a>4</a>
					</div>
					<div>
						<a><small>이미지 띄우고 설명</small></a>
					</div>
				</div>
				<div class="col-xl-2 col-lg-2 col-md-2 col-sm-4 col-4 mr-4 mt-4">
					<div>
						<a><img
							src="<c:url value='/resources/ui_image/badFaceY.png'/>"
							width="20" height="20"><small>&nbsp;별로에요</small></a>
					</div>
				</div>
			</div>
		</div>
	</div>
	<hr>
	<div class="text-center mt-5">
		<div class="row">
			<div class="col-xl-8 col-lg-8 col-md-8 col-sm-8 col-8 ">
				<div class="row justify-content-center">
					<div
						class="col-xl-3 col-lg-3 col-md-3 col-sm-5 col-12 category-btn shadow-md text-center">
						<a class="category-text">카테고리 블록(버튼)</a>
					</div>
					<div
						class="col-xl-3 col-lg-3 col-md-3 col-sm-5 col-12 category-btn shadow-md text-center">
						<a class="category-text">카테고리 블록(버튼)</a>
					</div>
					<div
						class="col-xl-3 col-lg-3 col-md-3 col-sm-5 col-12 category-btn shadow-md text-center">
						<a class="category-text">카테고리 블록(버튼)</a>
					</div>
					<div
						class="col-xl-3 col-lg-3 col-md-3 col-sm-5 col-12 category-btn shadow-md text-center">
						<a class="category-text">카테고리 블록(버튼)</a>
					</div>
					<div
						class="col-xl-3 col-lg-3 col-md-3 col-sm-5 col-12 category-btn shadow-md text-center">
						<a class="category-text">카테고리 블록(버튼)</a>
					</div>
					<div
						class="col-xl-3 col-lg-3 col-md-3 col-sm-5 col-12 category-btn shadow-md text-center">
						<a class="category-text">카테고리 블록(버튼)</a>
					</div>
				</div>
			</div>
			<div class="col-xl-4 col-lg-4 col-md-4 col-sm-4 col-4">
				<div class="row">
					<div class="col-xl-12 col-lg-12 col-md-12 col-sm-12 col-12">
						<div class="container justify-content-center">
							<a>회원 정보 </a>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<button class="btn btn-primary">sdf</button>
</body>
</html>