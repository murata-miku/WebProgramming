<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>user-detail</title>
<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" href="css/login.css">
<link rel="stylesheet" href="css/login,reboot.css">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
</head>
<body>

	<!-- As a heading -->
	<nav class="navbar navbar-light bg-light">
		<span class="navbar-brand mb-0 h1"></span>
		<a class="navbar-brand"href="login.html" class="btn btn-danger">ログアウト</a>
	</nav>
	<div class="login-form2">
	<div class="container">
		<div class = user-input-area>
		<center>
			<h1>ユーザ情報詳細参照</h1>
		</center>
		</div>


			<div class="login-input-area">
			<div class="login-input-area2">
				<div class="form-group row">
				  	 <div class = "col-sm-4">
				  	 <div class = "span.sample5">
	   				 <input type="text" readonly class="form-control-plaintext"value="ログインID">
	   				 </div>
	   				 </div>
	   				 <div class="col-sm-8">
	     			 <td>${user.loginId}</td>
	    		  	 </div>
	  			 </div>
	  		</div>

	  		<div class="login-input-area2">
				  <div class="form-group row">
				  	 <div class = "col-sm-4">
	   				 <input type="text" readonly class="form-control-plaintext"value="ユーザー名">
	   				 </div>
	   				 <div class="col-sm-8">
	     			  <td>${user.name}</td>
	    		  	 </div>
	  			 </div>
	  		</div>

	  		<div class="login-input-area2">
				  <div class="form-group row">
				  	 <div class = "col-sm-4">
	   				 <input type="text" readonly class="form-control-plaintext"value="生年月日">
	   				 </div>
	   				 <div class="col-sm-8">
	     			  <td>${user.birthDate}</td>
	    		  	 </div>
	  			 </div>
	  		</div>

	  		<div class="login-input-area2">
				  <div class="form-group row">
				  	 <div class = "col-sm-4">
	   				 <input type="text" readonly class="form-control-plaintext"value="登録日時">
	   				 </div>
	   				 <div class="col-sm-8">
	 				 <td>${user.createDate}</td>
	    		  	 </div>
	  			 </div>
	  		</div>

	  		<div class="login-input-area2">
				  <div class="form-group row">
				  	 <div class = "col-sm-4">
	   				 <input type="text" readonly class="form-control-plaintext"value="更新日時">
	   				 </div>
	   				 <div class="col-sm-8">
	     			 <td>${user.updateDate}</td>
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