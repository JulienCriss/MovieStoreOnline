package servicii.desktop;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import servicii.web.DataBasePath;

import java.sql.*;
/**
 * Servlet implementation class TestDesktop
 */
@WebServlet("/LoginAdmin")
public class LoginAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginAdmin() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession(true);
		PrintWriter out = response.getWriter();
		int ok = 0;
		String user = request.getParameter("user");
		String password = request.getParameter("password");
		
		System.out.print("sdsadasdasdsasad");
		
		Connection c = null;
	    Statement stmt = null;
	    try {
	      Class.forName("org.sqlite.JDBC");
	      c = DriverManager.getConnection(DataBasePath.connPath);
	      c.setAutoCommit(false);
	      stmt = c.createStatement();
	      String command = "SELECT tip_user FROM users WHERE username='"+user+"' AND password='"+password+"';";
	      ResultSet rs = stmt.executeQuery( command );
	      if ( rs.next() ) {
	         String  name = rs.getString("tip_user");
	         if(name.equals("admin")){
	        	 ok = 1;
	         }	         
	      }
	      rs.close();
	      stmt.close();
	      c.close();
	    } catch ( Exception e ) {
	      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
	      System.exit(0);
	    }
		if(ok==1){
			session.setAttribute("userIsLoged", "yes");
			out.print("login-ok");
		}else{
			
			out.print("login-not-ok");
		}
	}

}
