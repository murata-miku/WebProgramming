package controller;

import java.io.IOException
;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import common.Common;
import dao.UserDao;
import model.User;
/**
 * Servlet implementation class UserUpdateServlet
 */
@WebServlet("/UserUpdateServlet")
public class UserUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserUpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		User user1 = (User) session.getAttribute("userInfo");
		if(user1 == null) {
			response.sendRedirect("LoginServlet");
			return;
		}


		String id2 = request.getParameter("id");

		UserDao userDao = new UserDao();
		User user = userDao.detailShow(id2);

		// リクエストスコープにユーザ一覧情報をセット
		request.setAttribute("user", user);


		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/user-update.jsp");
		dispatcher.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id =  request.getParameter("id");
		String password11 =  request.getParameter("password");
		String password22 =  request.getParameter("password1");
		String loginId1 = request.getParameter("loginId");
		String birthDate1 = request.getParameter("birthDate");
		String name1 = request.getParameter("name");



		if(!password11.equals(password22)) {
			request.setAttribute("errMsg", "入力した内容は正しくありません");


			User user = new User(Integer.parseInt(id), loginId1, name1, Common.convertDate(birthDate1));
			request.setAttribute("user", user);

			// ユーザ情報更新画面に移行
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/user-update.jsp");
			dispatcher.forward(request, response);
			return;
		}

		if(birthDate1 == "" || name1 == "") {
			request.setAttribute("errMsg", "入力した内容は正しくありません");

			User user = new User(Integer.parseInt(id), loginId1, name1, Common.convertDate(birthDate1));
			request.setAttribute("user", user);

			// リクエストスコープにユーザ一覧情報をセット
			request.setAttribute("user", user);

			// ユーザ情報更新画面に移行
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/user-update.jsp");
			dispatcher.forward(request, response);
			return;
		}


		else {
		String loginId = request.getParameter("loginId");
		String password = request.getParameter("password");
		String birthDate = request.getParameter("birthDate");
		String name = request.getParameter("name");

		UserDao userDao1 = new UserDao();
		userDao1.update(loginId, password,name,birthDate);

		response.sendRedirect("UserListServlet");
		}
		}

	}



