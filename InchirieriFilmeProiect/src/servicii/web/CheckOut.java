package servicii.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class CheckOut
 */
@WebServlet("/check-out")
public class CheckOut extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckOut() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession(true);
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		Connection conn = null;
		Statement query = null;
		
		String username = session.getAttribute("userLoged").toString();
		
		if (session.getAttribute("userLoged") != null) {
			
			String cos = session.getAttribute("cosCumparaturi").toString();
			
			if(!(cos.equals("0")))
			{
				cos = cos.replace('[', ' ');
				cos = cos.replace(']', ' ');
				
				try {
					Class.forName("org.sqlite.JDBC");
					conn = DriverManager.getConnection(DataBasePath.connPath);
					conn.setAutoCommit(false);
					
					
					Date dt = new Date();
					
					Calendar c = Calendar.getInstance(); 
					c.setTime(dt); 
					c.add(Calendar.DATE, 3);
					dt = c.getTime();

					query = conn.createStatement();
					query.executeUpdate("INSERT INTO perioada_inchirieri (username,id_film,perioada_stop) values ('"+username+"','"+cos+"','"+dt+"')");
					
					session.setAttribute("cosCumparaturi","0");


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
			else
			{
				//mesaj cosul este gol
				out.println("<div style='margin-left:100px;'>Ne pare  rau dar nu puteti trimite mai departe aceasta comanda deoarece cosul dumneavoastra este gol.<br>Adaugati un produs apoi incercati din nou.</div>");
			}
		}
		
		
	}



}
