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
 * Servlet implementation class LoginUser
 */
@WebServlet("/login-user")
public class LoginUser extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginUser() {
		super();
		// TODO Auto-generated constructor stub
	}

	/* verifica daca user ul este logat */
	protected void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		
		if (session.getAttribute("userLoged") != null) {
			
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();

			String html_cod = new String();
		
			//@SuppressWarnings("unchecked")
			String cos = session.getAttribute("cosCumparaturi").toString();
			
			cos = cos.replace('[', ' ');
			cos = cos.replace(']', ' ');

			html_cod = "<div class=\"heading\">"
					+ "	<span class=\"link_a\"> <i class=\"fa fa-shopping-cart\"></i>"
					+ "		<span class=\"sc-button\"></span>"
					+ "		<span id=\"cart-total\">" + (cos.split(",").length-1)
					+ "</span> <i class=\"fa fa-angle-down\"></i>"
					+ "		<span class=\"clear\"></span>" + "	</span>"
					+ "</div>" + "<div class=\"content\">"
					+ "	<div class=\"content-scroll\">"
					+ "		<div class=\"mini-cart-info\" >"
					+ "			<table class=\"cart\">" + "				<tbody>";
			

			
			Connection conn = null;
			Statement query = null;
			double pret_total = 0;

			try {
				Class.forName("org.sqlite.JDBC");
				conn = DriverManager.getConnection(DataBasePath.connPath);
				
				conn.setAutoCommit(false);

				query = conn.createStatement();
				ResultSet result = query.executeQuery("Select nume_film,pret_film,imagine_film  from filme where id_film in ("+ cos + ");");
				
				while (result.next()) {

					String nume_film = result.getString("nume_film");
					double pret_film = result.getDouble("pret_film");
					String imagine_film = result.getString("imagine_film");
					
					pret_total += pret_film;

					String aux_cod = new String();
					aux_cod = "<tr>"
							+ "	<td class=\"image\"><a href=\"#\"><img width=\"47\" src=\"image/"
							+ imagine_film
							+ "\" alt=\"Error loading image\" ></a></td>"
							+ "	<td class=\"name\"><a href=\"\">"
							+ nume_film
							+ "</a>"
							+ "	<div></div><span class=\"total\">"
							+ pret_film
							+ " Ron</span>"
							+ "	<div class=\"remove\">"
							+ "	<span"
							+ "	onclick=\"(getURLVar('route') == 'checkout/cart' || getURLVar('route') == 'checkout/checkout') ? location = 'index.php?route=checkout/cart&amp;remove=49::' : $('#cart').load('index.php?route=module/cart&amp;remove=49::' + ' #cart > *');\"><i"
							+ "	class=\"fa fa-times-circle\"></i>Remove</span>"
							+ "	</div></td>" + "	</tr>";

					html_cod = html_cod + aux_cod;
				}
				result.close();
				query.close();

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

			String end_cod = "</tbody>"
					+ "		</table>"
					+ "		<table class=\"total\">"
					+ "			<tbody>"
					+ "				<tr>"
					+ "					<td class=\"text-right total-right\"><b>Total:</b></td>"
					+ "					<td class=\"text-left total-left\"><span"
					+ "						class=\"t-price\">"+String.format("%.2f",pret_total)+" Ron</span></td>"
					+ "				</tr>"
					+ "			</tbody>"
					+ "		</table>"
					+ "	</div>"
					+ "	<div class=\"checkout\">"
					+ "		<a class=\"button\""
					+ "			href=\"cos-cumparaturi.jsp\"><span>Verifica Cos</span></a>"   
					+ "	</div>" + "</div>" + "								</div>";

			html_cod += end_cod;

			out.println(html_cod);		
		}
		else
		{
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			out.println(0);
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession(true);
		String username = request.getParameter("username");
		String parola = request.getParameter("parola");

		Connection conn = null;
		Statement query = null;
		int num_result = 0;

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		try {
			Class.forName("org.sqlite.JDBC");
			conn = DriverManager.getConnection(DataBasePath.connPath);
			conn.setAutoCommit(false);

			query = conn.createStatement();
			ResultSet result = query.executeQuery("SELECT * FROM users WHERE password='"+ parola + "' AND username='" + username + "'");

			while (result.next()) {
				++num_result;
			}

			if (num_result == 0) {
				out.println("<div><font color=\"red\"><h2><i class=\"fa fa-warning\"></i> Eroare de autentificare </h2>"
						+ "						<div class=\"separator clearfix\"></div>"
						+ "						<p>"
						+ "							<b><i class=\"fa fa-lock\"></i> Ne pare rau, dar se pare ca nu exista nici un cont cu user-ul '"
						+ username
						+ "' sau parola a fost introdusa gresit.Te rugam sa incerci din nou cu mai multa atentie.</b><br><br><br> <a href=\"/InchirieriFilme/login.jsp\" class=\"button-cont-right\">Incearca din nou<i class=\"fa fa-arrow-circle-right\"></i></a>"
						+ "						</p></font></div>");
			} else {

				out.println("<div><h2><font><i class=\"fa fa-user\"></i></font> Autentificare cu succes!</h2>"
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
