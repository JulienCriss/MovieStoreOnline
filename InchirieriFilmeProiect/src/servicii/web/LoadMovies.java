package servicii.web;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import java.sql.*;

@Path("/load-movies")
public class LoadMovies {

	@GET
	@Produces(MediaType.TEXT_HTML)
	public String LoadMoviesDBCat(@QueryParam("category") String categorie_film) {
		
		String  dinamicContent = new String();
		String HTMLContent = new String();
		
		Connection conn = null;
		Statement query = null;
		
	    try {
	      Class.forName("org.sqlite.JDBC");
	      conn = DriverManager.getConnection(DataBasePath.connPath);
	      conn.setAutoCommit(false);
      
	      query = conn.createStatement();
	      ResultSet result = query.executeQuery( "SELECT * FROM filme WHERE tip_film='"+categorie_film+"';" );
	      
	      while ( result.next() ) {
	         
	          String  nume_film = result.getString("nume_film");
	          double pret_film = result.getDouble("pret_film");
	          String imagine_film = result.getString("imagine_film");
	          int id_film = result.getInt("id_film");
	          String url_film = result.getString("trailer_url");
	          
	          url_film = url_film.replace("watch?v=", "v/");
	          
	          dinamicContent = "<form action=\"descriere.jsp\" method='get' id='formID_"+id_film+"'>"
	          		    + "<li class=\"col-sm-3\">"
	        			+"<div class=\"padding\">"
	        			+"<div style=\"padding-bottom:30px;\">"
	        	                +"<img title=\"Show Trailer\" style=\"cursor: pointer;\" onClick=\"show_trailer("+id_film+",'"+id_film+"_player'"+");\" width=\"230\" height=\"306\" src=\"image/"+imagine_film+"\" alt=\"Error Loading Image\"/>"
	        	        +"</div>"
	        	        // start frame trailer 
	        	        +"<div class=\"trailer_frame\" id=\""+id_film+"\"><div align=\"right\" style=\"margin-right:20px;margin-top:20px;\"><i onClick=\"hide_trailer("+id_film+",'"+id_film+"_player'"+");\" class=\"fa fa-close\"></i></div><iframe id=\""+id_film+"_player"+"\" style=\"margin-top: 15%;margin-left: 35%;\" width=\"640\" height=\"360\" src=\""+url_film+"?enablejsapi=1"+"\" frameborder=\"0\" allowfullscreen></iframe></div>"
	        	        //end frame trailer
	        	        +"<input type='text' name='idFilm' style='display:none' value='"+id_film+"'>"
	        	        +"<input type='text' name='numeFilm' style='display:none' value='"+nume_film+"'>"
	        	        +"<div class=\"inner\">"
	        	            +"<div class=\"f-left\">"
	        	                +"<div align=\"right\" class=\"price\"><font size=\"3\"><i class=\"fa fa-opencart\"></i> "+pret_film+" Lei</font>"
	        	                +"</div>"
	        	                +"<div class=\"name maxheight\"><a href=\"#\" onclick=\"document.getElementById('formID_"+id_film+"').submit();\"><font size=\"4\">"+nume_film+"</font></a></div>"
	        	            +"</div>"
	        	            +"<div class=\"cart\">"
	        	                +"<a onclick=\"adauga_produs("+id_film+");\" title=\"Add to cart\" data-id=\"48;\" class=\"button addToCart\">"
	        	                +"<span>Adauga in cos</span>"
	        	                +"</a>"
	        	            +"</div>"
	        	            +"<div class=\"clear\"></div>"
	        	        +"</div>"
	        	        +"<div class=\"clear\"></div>"
	        	    +"</div>"
	        	+"</li>"
	        	+"</form>";
	          
	          HTMLContent = HTMLContent + dinamicContent;
	       }   
	      result.close();
	      query.close();   
	      
	    } catch ( Exception e ) {
	      System.err.println( e.getClass().getName() + ": --->" + e.getMessage() );
	      HTMLContent = "<div style=\"margin-left:100px;\"><font style=\"color:red\"><h2><i class=\"fa fa-database\"></i> Error while trying to access database ...</h2><h5><i class=\"fa fa-cogs\"></i> Connection cannot be established ... </h5></font></div>";
	    }
	    
		try
		  {
		    if(conn != null)
		      conn.close();
		  }
		  catch(SQLException e)
		  {
		    // connection close failed.
		    System.err.println(e);
		  }
		
		if (HTMLContent.isEmpty())
		{
			HTMLContent = "<div style='padding-left:150px;font-size:20px;'><i class=\"fa fa-cloud\"></i> Nici un rezultat gasit ...</div>";
		}
		return HTMLContent;
	}
	
	
	@POST
	@Produces(MediaType.TEXT_HTML)
	public String LoadMoviesDB() {
		String  dinamicContent = new String();
		String HTMLContent = new String();
		
		Connection conn = null;
		Statement query = null;
		
	    try {
	      Class.forName("org.sqlite.JDBC");
	      conn = DriverManager.getConnection(DataBasePath.connPath);
	      conn.setAutoCommit(false);
      
	      query = conn.createStatement();
	      ResultSet result = query.executeQuery( "SELECT * FROM filme ORDER BY RANDOM() LIMIT 12;" );
	      
	      while ( result.next() ) {
	         
	          String  nume_film = result.getString("nume_film");
	          double pret_film = result.getDouble("pret_film");
	          String imagine_film = result.getString("imagine_film");
	          int id_film = result.getInt("id_film");
	          String url_film = result.getString("trailer_url");
	          
	          url_film = url_film.replace("watch?v=", "v/");
	          
	          dinamicContent = "<form action=\"descriere.jsp\" method='get' id='formID_"+id_film+"'>"
	          		    + "<li class=\"col-sm-3\">"
	        			+"<div class=\"padding\">"
	        			+"<div style=\"padding-bottom:30px;\">"
	        	                +"<img title=\"Show Trailer\" style=\"cursor: pointer;\" onClick=\"show_trailer("+id_film+",'"+id_film+"_player'"+");\" width=\"230\" height=\"306\" src=\"image/"+imagine_film+"\" alt=\"Error Loading Image\"/>"
	        	        +"</div>"
	        	        // start frame trailer 
	        	        +"<div class=\"trailer_frame\" id=\""+id_film+"\"><div align=\"right\" style=\"margin-right:20px;margin-top:20px;\"><i onClick=\"hide_trailer("+id_film+",'"+id_film+"_player'"+");\" class=\"fa fa-close\"></i></div><iframe id=\""+id_film+"_player"+"\" style=\"margin-top: 15%;margin-left: 35%;\" width=\"640\" height=\"360\" src=\""+url_film+"?enablejsapi=1"+"\" frameborder=\"0\" allowfullscreen></iframe></div>"
	        	        //end frame trailer
	        	        +"<input type='text' name='idFilm' style='display:none' value='"+id_film+"'>"
	        	        +"<input type='text' name='numeFilm' style='display:none' value='"+nume_film+"'>"
	        	        +"<div class=\"inner\">"
	        	            +"<div class=\"f-left\">"
	        	                +"<div align=\"right\" class=\"price\"><font size=\"3\"><i class=\"fa fa-opencart\"></i> "+pret_film+" Lei</font>"
	        	                +"</div>"
	        	                +"<div class=\"name maxheight\"><a href=\"#\" onclick=\"document.getElementById('formID_"+id_film+"').submit();\"><font size=\"4\">"+nume_film+"</font></a></div>"
	        	            +"</div>"
	        	            +"<div class=\"cart\">"
	        	                +"<a onclick=\"adauga_produs("+id_film+");\" title=\"Add to cart\" data-id=\"48;\" class=\"button addToCart\">"
	        	                +"<span>Adauga in cos</span>"
	        	                +"</a>"
	        	            +"</div>"
	        	            +"<div class=\"clear\"></div>"
	        	        +"</div>"
	        	        +"<div class=\"clear\"></div>"
	        	    +"</div>"
	        	+"</li>"
	        	+"</form>";
	          
	          HTMLContent = HTMLContent + dinamicContent;
	       }   
	      result.close();
	      query.close();   
	      
	    } catch ( Exception e ) {
	      System.err.println( e.getClass().getName() + ": --->" + e.getMessage() );
	      HTMLContent = "<div style=\"margin-left:100px;\"><font style=\"color:red\"><h2><i class=\"fa fa-database\"></i> Error while trying to access database ...</h2><h5><i class=\"fa fa-cogs\"></i> Connection cannot be established ... </h5></font></div>";
	    }
	    
		try
		  {
		    if(conn != null)
		      conn.close();
		  }
		  catch(SQLException e)
		  {
		    // connection close failed.
		    System.err.println(e);
		  }
		return HTMLContent;
	}

}