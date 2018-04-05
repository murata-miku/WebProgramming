<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ログイン場面</title>
<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" href="css/login.css">
<link rel="stylesheet" href="css/login,reboot.css">


</head>
<body>

	<div class="login-form">
    <div class="container">

	<c:if test="${errMsg != null}" >
	    <div class="alert alert-primary" role="alert">
		  ${errMsg}
		</div>
	</c:if>

		<center>
			<h1>ログイン場面</h1>
		</center>


        <form class="form-signin" action="LoginServlet" method="post">
			<div class="login-input-area">
				<div class = "login-input-area2">
				<div class="form-group row">
					<label for="inputPassword" class="col-sm-4 col-form-label">ログインID</label>
					<div class="col-sm-8">
						<input type="text" name="loginId" class="form-control" id="inputLoginId"
							placeholder="login ID">
					</div>
				</div>
				</div>

				<div class = "login-input-area2">
				<div class="form-group row">
					<label for="inputPassword" class="col-sm-4 col-form-label">パスワード</label>
					<div class="col-sm-8">
						<input type="password" name="password" class="form-control" id="inputPassword"
							placeholder="Password">
					</div>
				</div>
				</div>

			</div>

			<center>
			<button class="btn btn-lg btn-primary btn-block btn-signin" type="submit">ログイン</button>
			</center>
		  </form>
	</div>
	</div>

</body>
</html>