package servicii.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoadCos
 */
@WebServlet("/load-cos")
public class LoadCos extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoadCos() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession(true);
		if (session.getAttribute("userLoged") != null) {
			
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();

			String html_cod = new String();
		
			//@SuppressWarnings("unchecked")
			String cos = session.getAttribute("cosCumparaturi").toString();
			
			cos = cos.replace('[', ' ');
			cos = cos.replace(']', ' ');
			
			html_cod = "<div class=\"cart-info\">" + 
					"    <div class=\"shop-cart\">" + 
					"        <table class=\"table table-bordered \">" + 
					"            <thead>" + 
					"                <tr>" + 
					"                    <td class=\"image\">Image</td>" + 
					"                    <td class=\"name\">Titlu Film</td>" + 
					"                    <td class=\"model\">#ID Film</td>" + 
					"                    <td class=\"quantity\">Sterge</td>" + 
					"                    <td class=\"price-td\">Pret</td>" + 
					"                </tr>" + 
					"            </thead>" + 
					"            <tbody>";
			
			Connection conn = null;
			Statement query = null;
			double pret_total = 0;
			
			try {
				Class.forName("org.sqlite.JDBC");
				conn = DriverManager.getConnection(DataBasePath.connPath);
				
				conn.setAutoCommit(false);

				query = conn.createStatement();
				ResultSet result = query.executeQuery("Select nume_film,pret_film,imagine_film,id_film  from filme where id_film in ("+ cos + ");");
				
				while (result.next()) {

					String nume_film = result.getString("nume_film");
					int id = result.getInt("id_film");
					double pret_film = result.getDouble("pret_film");
					String imagine_film = result.getString("imagine_film");
					
					pret_total += pret_film;

					String aux_cod = new String();
					aux_cod =" <tr>" + 
							"                    <td class=\"image\"><img style=\"width:39px\" src=\"image/"+imagine_film+"\"></td>" + 
							"                    <td class=\"name\">" + 
							"                        <div>"+nume_film+"</div>" + 
							"                        <div></div>" + 
							"                    </td>" + 
							"                    <td class=\"model\">#"+id+"</td>" + 
							"                    <td class=\"quantity\">" + 
							"                        <div class=\"wrapper mt5\">" + 
							"                            <a href=\"#\"><i class=\"fa fa-trash\"></i></a>" + 
							"                        </div>" + 
							"                    </td>" + 
							"                    <td class=\"price\">"+pret_film+" Ron</td>" + 
							"                </tr>";

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
			
			String end_cod =   "<tr>" + 
					"                	<td>" + 
					"                		Total:" + 
					"                	</td>" + 
					"                	<td>" + String.format("%.2f",pret_total) + 
					"                	 Ron</td>" + 
					"                </tr>" + 
					"            </tbody>" + 
					"        </table>" + 
					"    </div>" + 
					"</div>"+ 
					"<div class=\"buttons\">" + 
					"<div class=\"center\"><button style='color:#000' href=\"#\" onclick=\"trimiteComanda()\" class=\"button-cont-right\">Checkout<i class=\"fa fa-check\"></i></button></div>" + 
					"</div>";

		
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


}
