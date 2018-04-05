<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>user_list</title>
<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" href="css/login.css">
<link rel="stylesheet" href="css/login,reboot.css">

</head>
<body>
    <!-- header -->
    <header>
      <nav class="navbar-light bg-light">
      	<div class="container">
      		<div class="navbar-header">
            <a class="navbar-brand" href="userCreate.html">ユーザ管理システム</a>
      		</div>

          <ul class="nav navbar-nav navbar-right">
            <li class="navbar-text">${userInfo.name} さん </li>
  			<li class="dropdown">
  			  <a href="LogoutServlet" class="navbar-link logout-link">ログアウト</a>

            </li>
  		  </ul>
      	</div>
      </nav>
    </header>

	<div class="container">
		<div class = user-input-area>
		<center>
			<h1>ユーザー一覧</h1>
		</center>
		</div>


	<p class="text-right">
	<a class="btn btn-link" href="UserregisterServlet" role="button">新規登録</a>
	</p>

		<form class="form-signin"  action="UserListServlet" method="post">

			<div class="login-input-area">
				<div class = "login-input-area2">
				<div class="form-group row">
					<label for="inputPassword" class="col-sm-4 col-form-label">ログインID</label>
					<div class="col-sm-8">
						<input type="text" class="form-control" id="inputPassword" name = "loginId"
							placeholder="login ID">
					</div>
				</div>
				</div>

				<div class = "login-input-area2">
				<div class="form-group row">
					<label for="inputPassword" class="col-sm-4 col-form-label">ユーザ名</label>
					<div class="col-sm-8">
						<input type="text" class="form-control" id="inputPassword" name = "name"
							placeholder="user Name">
					</div>
				</div>
				</div>

				<div class = "login-input-area2">
					<div class="form-group row">
						<label for="inputPassword" class="col-sm-4 col-form-label">生年月日</label>
						<div class="col-sm-8 row">

							<div class="col-sm-5">
								<input type="date" class="form-control" id="inputPassword"
									placeholder="生年月日" name = "birthdate1">
							</div>
							<div class="col-sm-2">
							<center>
							～
							</center>
							</div>
							<div class="col-sm-5">
								<input type="date" class="form-control" id="inputPassword"
									placeholder="生年月日" name = "birthdate2">
							</div>
						</div>
					</div>
				  </div>
			</div>


			<p class="text-right">
				<div class="btn btn-primary btn-lg">
				<input type="submit" class="btn btn-primary" value="検索">
				</div>
			</p>
	 	</form>

			<hr>


       <div class="table table-bordered">
             <table class="table table-striped">
               <thead>
                 <tr>
                   <th>ログインID</th>
                   <th>ユーザ名</th>
                   <th>生年月日</th>
                   <th></th>
                 </tr>
               </thead>
               <tbody>
                 <c:forEach var="user" items="${userList}" >
                   <tr>
                     <td>${user.loginId}</td>
                     <td>${user.name}</td>
                     <td>${user.birthDate}</td>
                     <td>
                       <a class="btn btn-primary" href="UserDetailServlet?id=${user.id}">詳細</a>

					<c:choose>
					   <c:when test="${userInfo.loginId == 'admin'}">
					        <a class="btn btn-success" href="UserUpdateServlet?id=${user.id}">更新</a>
					   </c:when>
					   <c:when test = "${userInfo.loginId == user.loginId }">
					    <a class="btn btn-success" href="UserUpdateServlet?id=${user.id}">更新</a>
                       </c:when>
                    </c:choose>


						<c:if test="${userInfo.loginId == 'admin'}">
                       <a class="btn btn-danger" href ="UserDeleteServlet?id=${user.id}">削除</a>
						</c:if>
                     </td>
                   </tr>
                 </c:forEach>
               </tbody>
             </table>
           </div>




</body>
</html>