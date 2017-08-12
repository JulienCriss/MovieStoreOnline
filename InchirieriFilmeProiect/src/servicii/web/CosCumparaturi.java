package servicii.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class CosCumparaturi
 */
@WebServlet("/adauga-produs")
public class CosCumparaturi extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CosCumparaturi() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession(true);
		String id_film = request.getParameter("id_film");
		
		String cos = session.getAttribute("cosCumparaturi").toString();
	
		if(cos.equals("0"))
		{
			cos = 0 + "," + id_film;
			session.setAttribute("cosCumparaturi", cos);
	 
		}
		else
		{

			
			if(!(cos.contains(id_film)))
			{
				cos = cos + "," + id_film;
			}
			session.setAttribute("cosCumparaturi", cos);
		}

	}

}
