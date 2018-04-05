package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UserDao;
import model.User;

@WebServlet("/UserListServlet")
public class UserListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserListServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO 未実装：ログインセッションがない場合、ログイン画面にリダイレクトさせる(2018/03/20時点)
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("userInfo");
		if(user == null) {
			response.sendRedirect("LoginServlet");
			return;
		}


			// ユーザ一覧情報を取得
			UserDao userDao = new UserDao();
			List<User> userList = userDao.findAll();

			// リクエストスコープにユーザ一覧情報をセット
			request.setAttribute("userList", userList);

			// ユーザ一覧のjspにフォワード
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/user_list.jsp");
			dispatcher.forward(request, response);




	}



	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String loginId1 =  request.getParameter("loginId");
		String name2 =  request.getParameter("name");
		String birthDate1 = request.getParameter("birthdate1");
		String birthDate2 = request.getParameter("birthdate2");

		UserDao userDao2 = new UserDao();
		List<User> userList = userDao2.findSearch(loginId1,name2,birthDate1,birthDate2);

		request.setAttribute("userList", userList);

		// ユーザ一覧のjspにフォワード
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/user_list.jsp");
		dispatcher.forward(request, response);

	}

}
