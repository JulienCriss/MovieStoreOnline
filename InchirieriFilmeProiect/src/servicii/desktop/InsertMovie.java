package servicii.desktop;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;

import servicii.web.DataBasePath;
import sun.misc.BASE64Decoder;

/**
 * Servlet implementation class InsertMovie
 */
@SuppressWarnings("unused")
@WebServlet("/InsertMovie")
public class InsertMovie extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertMovie() {
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

		if(userLoged == "yes")
		{
			String nume = request.getParameter("nume");
			String tip = request.getParameter("tip");
			String pret = request.getParameter("pret");
			String trailer = request.getParameter("trailer");
			String descriere = request.getParameter("descriere");
			String imageExtension = request.getParameter("imageExtension");
			String imageURL = request.getParameter("imageURL");
			String imageName = nume.replace(' ', '_') + "." +imageExtension;

			String absoluteDiskPath = getServletContext().getRealPath("\\..\\..\\..\\..\\..\\..\\");
			String tempFolder = getServletContext().getRealPath("\\");
			absoluteDiskPath += "\\InchirieriFilme_IULIAN\\WebContent\\image\\"+imageName;
			tempFolder += "\\WebContent\\image\\"+imageName;
			System.out.println(absoluteDiskPath);
			SaveImageFromUrl.saveImage(imageURL, absoluteDiskPath, imageExtension);
			SaveImageFromUrl.saveImage(imageURL, "C:\\Users\\Iulian\\git\\InchirieriFilmeProiect\\WebContent\\image\\"+imageName, imageExtension);
			
			
			Connection c = null;
		    Statement stmt = null;
		    try {
		      Class.forName("org.sqlite.JDBC");
		      c = DriverManager.getConnection(DataBasePath.connPath);
		      c.setAutoCommit(false);
		      System.out.println("Insert Movie: Opened database successfully");

		      stmt = c.createStatement();
		      String sql = "INSERT INTO filme (nume_film,tip_film,pret_film,trailer_url,imagine_film,descriere_film) " +
		                   "VALUES ('"+nume+"','"+tip+"',"+pret+",'"+trailer+"','"+imageName+"','"+descriere+"');"; 
		      stmt.executeUpdate(sql);

		      stmt.close();
		      c.commit();
		      c.close();
		    } catch ( Exception e ) {
		      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
		      out.print("no succes");
		    }
		    System.out.println("Records created successfully");
			out.print("succes");
			
		}
		else
		{
			out.print("You are not loged!");
		}
	}

}
