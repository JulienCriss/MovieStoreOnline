package servicii.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.sql.*;

/**
 * Servlet implementation class Test
 */
@WebServlet("/add-user")
public class RegisterUser extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RegisterUser() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession(true);
		String username = request.getParameter("username");
		String telefon = request.getParameter("telefon");
		String email = request.getParameter("email");
		String parola = request.getParameter("parola");

		Connection conn = null;
		Statement query = null;
		int num_result = 0;

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		try {
			Class.forName("org.sqlite.JDBC");
			conn = DriverManager
					.getConnection(DataBasePath.connPath);
			conn.setAutoCommit(false);

			query = conn.createStatement();
			ResultSet result = query
					.executeQuery("SELECT * FROM users WHERE email='" + email
							+ "' AND username='" + username + "'");

			while (result.next()) {
				++num_result;
			}

			if (num_result == 1) {
				out.println("<div><font color=\"red\"><h2><i class=\"fa fa-warning\"></i> Eroare la creearea noului cont </h2>"
						+ "						<div class=\"separator clearfix\"></div>"
						+ "						<p>"
						+ "							<b>Ne pare rau, dar se pare ca acest email este deja asignat unui cont. Te rugam sa incerci alt email sau incearca din nou cu mai mare atentie.</b>"
						+ "						</p></font></div>");
			} else {
				query = conn.createStatement();
				query.executeUpdate("INSERT INTO users (username,email,password,nr_telefon,tip_user) values ('"
						+ username
						+ "','"
						+ email
						+ "','"
						+ parola
						+ "','"
						+ telefon + "','user')");

				out.println("<div><h2><font><i class=\"fa fa-user\"></i></font> Contul dumneavoastra a fost creat cu succes!</h2>"
						+ "						<div class=\"separator clearfix\"></div>"
						+ "						<p>"
						+ "							<b>Echipa noastra iti ureaza shoping placut in continuare.</b>"
						+ "						</p></div>");

				session.setAttribute("userLoged", username);
				session.setAttribute("cosCumparaturi","0");

			}

			result.close();
			query.close();
			conn.commit();

		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": --->"
					+ e.getMessage());
			out.println("<div style=\"margin-left:100px;\"><font style=\"color:red\"><h2><i class=\"fa fa-database\"></i> Error while trying to access database ...</h2><h5><i class=\"fa fa-cogs\"></i> Connection cannot be established ... </h5></font></div>");
		}

		try {
			if (conn != null)
				conn.close();
		} catch (SQLException e) {
			// connection close failed.
			System.err.println(e);
			
			
		}

	}

}
