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

import dao.UserDao;
import model.User;

/**
 * Servlet implementation class UserDeleteServlet
 */
@WebServlet("/UserDeleteServlet")
public class UserDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserDeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
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

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/user-delete.jsp");
		dispatcher.forward(request, response);



	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id3 = request.getParameter("id");

		UserDao userDao1 = new UserDao();
		userDao1.deletedatabase(id3);
		response.sendRedirect("UserListServlet");


	}

}
