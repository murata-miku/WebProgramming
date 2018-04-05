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
 * Servlet implementation class UserDetailServlet
 */
@WebServlet("/UserDetailServlet")
public class UserDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserDetailServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 *
	 *
	 *
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		User user1 = (User) session.getAttribute("userInfo");
		if(user1 == null) {
			response.sendRedirect("LoginServlet");
			return;
		}

		// URLからGETパラメータとしてIDを受け取る
		String id1 = request.getParameter("id");

		// 確認用：idをコンソールに出力
		System.out.println(id1);


		// 未実装：idを引数にして、idに紐づくユーザ情報を出力する
		UserDao userdao = new UserDao();
		User user = userdao.detailShow(id1);


		// ユーザ情報をリクエストスコープにセットしてjspにフォワード
		request.setAttribute("user", user);

		// ユーザ詳細画面にフォワード
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/user-detail.jsp");
		dispatcher.forward(request, response);

	}


}