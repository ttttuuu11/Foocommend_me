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

.card-columns { @include media-breakpoint-only(lg) { column-count:4;
	
}
@
include



 



media-breakpoint-only



 



(
xl



 



)
{
column-count






:



 



5;
}
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
	<!-- sidebar -->
	<div class="row">
		<nav class="col-sm-3 col-md-3 col-lg-3 col-xl-3 d-none d-sm-block bg-light sidebar">
			
		</nav>


		<!-- recommend menu -->
		<div class="card-columns col-sm-9 col-md-9 col-lg-9 col-xl-9">
			<c:forEach var="recommentItem" items="${resultRecommendList }"
				varStatus="status">
				<div class="card p-3 shadow">
					<img class="card-img-top"
						src="<c:url value='/resources/store_image/${restaurantIntroList[status.index].restaurant_idx}.jpg'/>"
						alt="X">
					<div class="card-body">
						<h5 class="card-title">${recommentItem.store_name }</h5>
						<hr>
						<p class="card-text">${ restaurantIntroList[status.index].restaurant_menu }
						</p>
						<div class="row flex-row-reverse">
							<button type="button" class="btn btn-outline-warning ml-2	">스크랩</button>
							<button type="button" class="btn btn-outline-primary">좋아요</button>
						</div>
					</div>
				</div>
			</c:forEach>
		</div>
	</div>
	<!-- 
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
		

	</div> -->
</body>
</html>