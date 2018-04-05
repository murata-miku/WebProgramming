package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UserDao;
import model.User;

/**
 * Servlet implementation class UserregisterServlet
 */
@WebServlet("/UserregisterServlet")
public class UserregisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserregisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */

//    注意！現在ユーザー一覧の画面から、ユーザ新規登録画面に移行できない(2018/03/28)　サーブレット同士繋いでいないため、ユーザ新規登録に直接アドレスを入力することで
//    ユーザ新規登録画面に移行することができる。(ユーザ一覧画面にこのサーブレットの情報を何とか載せたい)
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("userInfo");
		if(user == null) {
			response.sendRedirect("LoginServlet");
			return;
		}

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/user-signup.jsp");
		dispatcher.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String password1 =  request.getParameter("password");
		String password2 =  request.getParameter("password2");
		String loginId1 = request.getParameter("loginId");
		String birthDate1 = request.getParameter("birthDate");
		String name1 = request.getParameter("name");


		UserDao userDao1 = new UserDao();
		User user = userDao1.findByloginId(loginId1);


		if(user != null) {
			request.setAttribute("errMsg", "入力した内容は正しくありません");

			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/user-signup.jsp");
			dispatcher.forward(request, response);
			return;
		}



		if(!password1.equals(password2)) {
			request.setAttribute("errMsg", "入力した内容は正しくありません");

			// ユーザ新規登録画面に移行
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/user-signup.jsp");
			dispatcher.forward(request, response);
			return;
		}

		if(password1 == "" || loginId1 == "" || birthDate1 == "" || name1 == "") {
			request.setAttribute("errMsg", "入力した内容は正しくありません");

			// ユーザ新規登録画面に移行
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/user-signup.jsp");
			dispatcher.forward(request, response);
			return;
		}



		// リクエストパラメータの入力項目を取得
		else {
		String loginId = request.getParameter("loginId");
			String password = request.getParameter("password");
			String birthDate = request.getParameter("birthDate");
			String name = request.getParameter("name");


			UserDao userDao = new UserDao();
			userDao.create(loginId, password,name,birthDate);

			// ユーザ一覧のサーブレットにリダイレクト
			response.sendRedirect("UserListServlet");
		}


	}

}
