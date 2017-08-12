package servicii.desktop;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import servicii.web.DataBasePath;

/**
 * Servlet implementation class DeleteMovie
 */
@SuppressWarnings("unused")
@WebServlet("/DeleteMovie")
public class DeleteMovie extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DeleteMovie() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession(true);
		PrintWriter out = response.getWriter();
		String userLoged = (String) session.getAttribute("userIsLoged");
		String id_film = request.getParameter("id_film");
		int ok = 1;
		if(userLoged == "yes")
		{
			Connection c = null;
			Statement stmt = null;
			try {
				Class.forName("org.sqlite.JDBC");
				c = DriverManager.getConnection(DataBasePath.connPath);
				c.setAutoCommit(false);

				stmt = c.createStatement();
				String sql = "DELETE from filme where id_film="+id_film;
				stmt.executeUpdate(sql);
				c.commit();
				stmt.close();
				c.close();
			} catch ( Exception e ) {
				System.err.println( e.getClass().getName() + ": " + e.getMessage() );
				System.exit(0);
				ok = 0;
			}
			try {
				Class.forName("org.sqlite.JDBC");
				c = DriverManager.getConnection(DataBasePath.connPath);
				c.setAutoCommit(false);

				stmt = c.createStatement();
				String sql = "DELETE from perioada_inchirieri where id_film="+id_film;
				stmt.executeUpdate(sql);
				c.commit();
				stmt.close();
				c.close();
			} catch ( Exception e ) {
				System.err.println( e.getClass().getName() + ": " + e.getMessage() );
				System.exit(0);
				ok = 0;
			}
			if(ok==1)
			{
				out.print("succes");
			}else
			{
				out.print("error");
			}
		}
	}

}
