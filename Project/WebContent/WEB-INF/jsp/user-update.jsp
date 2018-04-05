<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>user-update</title>
<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" href="css/login.css">
<link rel="stylesheet" href="css/login,reboot.css">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
</head>
<body>
	<!-- As a heading -->
	<nav class="navbar navbar-light bg-light">
		<span class="navbar-brand mb-0 h1"></span>
		<a class="navbar-brand"href="LogoutServlet" class="btn btn-danger">ログアウト</a>
	</nav>
	<div class="login-form2">
	<div class="container">
		<div class = user-input-area>
		<center>
			<h1>ユーザ情報更新</h1>
		</center>
		</div>



		<c:if test="${errMsg != null}" >
		<center>
		<p class="text-danger">
		${errMsg}
		</p>
		</center>
		</c:if>


	<form class="form-signin" action="UserUpdateServlet" method="post">
		<div class="login-input-area">
			<div class="login-input-area2">
				<div class="form-group row">
				  	 <div class = "col-sm-4">
				  	 <div class = "span.sample5">
	   				 <input type="text" readonly class="form-control-plaintext"value="ログインID">
	   				 </div>
	   				 </div>
	   				 <div class="col-sm-8">
	     			 <input type="text" readonly class="form-control-plaintext"value="${user.loginId}" name = "loginId">
	     			 <input type="hidden" value="${user.id}" name = "id">
	     			 <input type="hidden" value="${user.loginId}" name = "loginId">
	    		  	 </div>
	  			 </div>
	  		</div>

			<div class="form-group row">
					<label for="inputPassword" class="col-sm-4 col-form-label">パスワード</label>
					<div class="col-sm-8">
						<input type="password" class="form-control" id="inputPassword"
							placeholder="Password"  name = "password">
					</div>
				</div>

			<div class = "login-input-area2">
				<div class="form-group row">
					<label for="inputPassword" class="col-sm-4 col-form-label">パスワード(確認)</label>
						<div class="col-sm-8">
						<input type="password" class="form-control" id="inputPassword"placeholder="Password" name = "password1">
						</div>
				</div>
			</div>

			<div class = "login-input-area2">
				<div class="form-group row">
					<label for="inputPassword" class="col-sm-4 col-form-label">ユーザー名</label>
						<div class="col-sm-8">
						<input type="text" class="form-control"value= "${user.name}"  name = "name">
						</div>
				</div>
			</div>

			<div class = "login-input-area2">
				<div class="form-group row">
					<label for="inputPassword" class="col-sm-4 col-form-label">生年月日</label>
						<div class="col-sm-8">
						<input type="date" class="form-control" value = "${user.birthDateStr}"  name = "birthDate">
						</div>
				</div>
			</div>

		</div>


			<center>
				<div class="btn btn-primary btn-lg">
				<input type="submit" class="btn btn-primary" value="更新">
				</div>
			</center>
	</form>
			<p class="text-right">
			<a class="btn btn-link" href="UserListServlet" role="button">戻る</a>
			</p>
	</div>
	</div>
</body>
</html>