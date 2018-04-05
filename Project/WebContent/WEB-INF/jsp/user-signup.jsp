<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ユーザ新規登録</title>

<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" href="css/login.css">
<link rel="stylesheet" href="css/login,reboot.css">
</head>
<body>

	<!-- As a heading -->
	<nav class="navbar navbar-light bg-light">
		<span class="navbar-brand mb-0 h1"></span>
		<a class="navbar-brand"href="UserListServlet" class="btn btn-danger">ログアウト</a>
	</nav>



	<div class="container">
		<div class = user-input-area>
		<center>
			<h1>ユーザ新規登録</h1>
		</center>
		</div>
		<center>
		<p class="text-danger">
		<c:if test="${errMsg != null}" >
		${errMsg}
		</center>
		</c:if>
		</p>


		<form class="form-signin" action="UserregisterServlet" method="post">
			<div class="login-input-area">
				<div class = "login-input-area2">
				<div class="form-group row">
					<label for="inputPassword" class="col-sm-4 col-form-label">ログインID</label>
						<div class="col-sm-8">
						<input type="text" class="form-control" name = "loginId"id="inputPassword"placeholder="login ID">
						</div>
				</div>
				</div>

				<div class = "login-input-area2">
				<div class="form-group row">
					<label for="inputPassword" class="col-sm-4 col-form-label">パスワード</label>
						<div class="col-sm-8">
						<input type="password" class="form-control" name = "password" id="inputPassword"placeholder="Password">
						</div>
				</div>
				</div>

				<div class = "login-input-area2">
				<div class="form-group row">
					<label for="inputPassword" class="col-sm-4 col-form-label">パスワード(確認)</label>
						<div class="col-sm-8">
						<input type="password" class="form-control" name = "password2"id="inputPassword"placeholder="Password">
						</div>
				</div>
				</div>

				<div class = "login-input-area2">
				<div class="form-group row">
					<label for="inputPassword" class="col-sm-4 col-form-label">ユーザー名</label>
						<div class="col-sm-8">
						<input type="text" class="form-control"name = "name" id="inputPassword"placeholder="user Name">
						</div>
				</div>
				</div>

		        <div class = "login-input-area2">
				<div class="form-group row">
					<label for="inputPassword" class="col-sm-4 col-form-label">生年月日</label>
						<div class="col-sm-8">
						<input type="date" class="form-control" name = "birthDate"id="inputPassword" placeholder="birthday">
						</div>
				</div>
				</div>
			</div>
					<center>
					<div class="btn btn-primary btn-lg">
					<input type="submit" class="btn btn-primary" value="登録">
					</div>
				</center>
		</form>

			<p class="text-right">
			<a class="btn btn-link" href="UserListServlet" role="button">戻る</a>
			</p>
	</div>



</body>
</html>