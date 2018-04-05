<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>user-delete</title>
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
			<h1>ユーザ削除確認</h1>
		</center>

		</div>

		<td>
		<div class = "login-input-area2">
		<center>
		<p>ログインID: ${user.loginId} <br>
		を本当に削除してもよろしいでしょうか。<p>
		</td>
		</center>


		<div class = "login-input-area2">

			<div class="row">
			 <div class = "col-sm-6 text-right">
			 <a class="btn btn-primary btn-lg"  href="UserListServlet">キャンセル</a>
			</div>

			<div class="col-sm-6">
				<form action="UserDeleteServlet" method="post"">
				<input type="hidden" name="id" value= "${user.id}" >
				<button type="submit" class="btn btn-primary btn-lg">　　OK　　</button>
				</form>
				</div>

		    </div>

			</div>

		</div>
			<p class="text-right">
			<a class="btn btn-link" href="UserListServlet" role="button">戻る</a>
			</p>
	</div>
	</div>
</body>
</html>