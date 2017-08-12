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
 * Servlet implementation class DataMovies
 */
@WebServlet("/DataMovies")
public class DataMovies extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DataMovies() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession(true);
		PrintWriter out = response.getWriter();
		String userLoged = (String) session.getAttribute("userIsLoged");

		if(userLoged == "yes")
		{
			String []name = new String[7];
			Connection c = null;
		    Statement stmt = null;
		    try {
		      Class.forName("org.sqlite.JDBC");
		      c = DriverManager.getConnection(DataBasePath.connPath);
		      c.setAutoCommit(false);
		      stmt = c.createStatement();
		      String command = "SELECT * FROM filme;";
		      ResultSet rs = stmt.executeQuery( command );
		      while ( rs.next() ) {
		    	 name[0] = Integer.toString(rs.getInt("id_film"));
		         name[1] = rs.getString("nume_film");         
		         name[2] = rs.getString("tip_film");
		         name[3] = Integer.toString(rs.getInt("pret_film"));
		         name[4] = rs.getString("trailer_url");
		         name[5] = rs.getString("imagine_film");
		         name[6] = rs.getString("descriere_film");
		         out.println(name[0]+"<<"+name[1]+"<<"+name[2]+"<<"+name[3]+"<<"+name[4]+"<<"+name[5]+"<<"+name[6] + "<end>");
		      }
		      rs.close();
		      stmt.close();
		      c.close();
		    } catch ( Exception e ) {
		      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
		      System.exit(0);
		    }
		}
		else
		{
			out.print("You are not loged!");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

}
