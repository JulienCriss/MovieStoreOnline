package servicii.web;

import javax.ws.rs.GET;
//import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.QueryParam;

import java.sql.*;

/**
 * Servlet implementation class LoadDescription
 */
@Path("/load-description")
public class LoadDescription {
	// Metoda apelata daca tipul media cerut este TEXT_PLAIN
	

		// Metoda apelata daca tipul media cerut este HTML
		@GET
		@Produces(MediaType.TEXT_HTML)
		public String LoadMovie (@QueryParam("idFilm") int idFilm,@QueryParam("numeFilm") String numeFilm) {
			
			
			Connection conn = null;
			Statement query = null;
			
			String dinamicPart = "";
			
			String nume_film = "";
			int id_film = 0;
			String imagine = "";
			double pret = 0;
			String tip_film = "";
			String url_film = "";
			String descriere_film = "";
			
			
			try {
			      Class.forName("org.sqlite.JDBC");
			      conn = DriverManager.getConnection(DataBasePath.connPath);
			      conn.setAutoCommit(false);
		      
			      query = conn.createStatement();
			      ResultSet result = query.executeQuery( "SELECT descriere_film,trailer_url,tip_film,pret_film,imagine_film FROM filme WHERE id_film="+idFilm+" AND nume_film='"+numeFilm+"';" );
			      
			      while ( result.next() ) {
			    	  
			    	  nume_film = numeFilm;
			    	  id_film = idFilm;
			    	  
			    	  imagine = result.getString("imagine_film");
			    	  
			    	  descriere_film = result.getString("descriere_film");
			    	  
			    	  url_film = result.getString("trailer_url");
			    	  url_film = url_film.replace("watch?v=", "v/");
			    	  
			    	  pret = result.getDouble("pret_film");
			    	  
			    	  tip_film = result.getString("tip_film");	
			    	  tip_film = tip_film.toUpperCase();
			   
			      }   
			      result.close();
			      query.close();   
			      
			    } catch ( Exception e ) {
			      System.err.println( e.getClass().getName() + ": --->" + e.getMessage() );
			      dinamicPart = "<div style=\"margin-left:100px;\"><font style=\"color:red\"><h2><i class=\"fa fa-database\"></i> Error while trying to access database ...</h2><h5><i class=\"fa fa-cogs\"></i> Connection cannot be established ... </h5></font></div>";
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

			if(nume_film.compareTo("")!=0 && id_film != 0)
			{
				dinamicPart = "<div class='col-sm-9 col-sm-12' id='content'" + 
						"    style='width: 100%;'>" + 
						"    <div class='breadcrumb'>" + 
						"        <a href='#'>"+tip_film+ "</a> » <a href='#' class='last'>"+nume_film+"</a>" + 
						"    </div>" + 
						"    <div class='product-info'>" + 
						"        <div class='row'>" + 
						"            <div class='col-sm-4'>" + 
						"                <h1 class='view'>Lorem ipsum dolor sit amet conse" + 
						"                    ctetur adipisicing" + 
						"                </h1>" + 
						"                <div id='default_gallery' class='left spacing'" + 
						"                    style='margin-left: 50px;'>" + 
						"                    <div>" + 
						"                        <img width='270' height='376'" + 
						"                            src='image/"+imagine+"'" + 
						"                            alt='Error Loading Image'>" + 
						"                    </div>" + 
						"                </div>" + 
						"            </div>" + 
						"            <div class='col-sm-8'>" + 
						"                <h1>"+numeFilm+"</h1>" +
						"                <div class='description'>" + 
						"                    <div class='product-section'>" + 
						"                        <span>#Cod Film: "+idFilm+"</span><br><span>Availability:</span>" + 
						"                        <div class='prod-stock'>In Stock</div>" + 
						"                    </div>" + 
						"                    <div class='price'>" + 
						"                        <span class='text-price'>Pret:</span> <span" + 
						"                            class='price-new'>"+pret+" Lei</span>"+
						"                    </div>" + 
						"                    <div class='cart'>" + 
						"                        <div class='prod-row'>" + 
						"                            <div class='cart-top'>" + 
						"                                <div class='cart-top-padd form-inline'>" + 
						"                                     <a onclick=\"adauga_produs("+id_film+");\" id='button-cart'" + 
						"                                        class='button-prod'><span>Adauga in cos</span></a>" + 
						"                                </div>" + 
						"                                <div class='clear'></div>" + 
						"                            </div>" + 
						"                        </div>" + 
						"                    </div>" + 
						"                    <div>"+ 
												// start frame trailer 
	        	        "						<div class=\"trailer_frame\" id=\""+id_film+"\"><div align=\"right\" style=\"margin-right:20px;margin-top:20px;\"><i onClick=\"hide_trailer("+id_film+",'"+id_film+"_player'"+");\" class=\"fa fa-close\"></i></div><iframe id=\""+id_film+"_player"+"\" style=\"margin-top: 15%;margin-left: 35%;\" width=\"640\" height=\"360\" src=\""+url_film+"?enablejsapi=1"+"\" frameborder=\"0\" allowfullscreen></iframe></div>"+
	        	        						//end frame trailer
						"					 </div>"+
						"                    <div class='clear'></div><div><img src='image/YouTube-icon.png' style='width:25px;'><span class='grow' title=\"Show Trailer\" style=\"cursor: pointer;\" onClick=\"show_trailer("+id_film+",'"+id_film+"_player'"+");\"> Urmareste Trailer</span></div>" + 
						"                </div>" + 
						"            </div>" + 
						"        </div>" + 
						"        <div class='tabs'>" + 
						"            <div class='tab-heading'> Descriere</div>" + 
						"            <div class='tab-content'>" + 
						"                <p>" + descriere_film +
						"                </p>" + 
						"            </div>" + 
						"        </div>" + 
						"    </div>" + 
						"</div>";
			}
			else
			{
				dinamicPart = "<div style=\"margin-left:100px;\"><font style=\"color:red\"><h2><i class=\"fa fa-database\"></i> Error while trying to access database ...</h2><h5><i class=\"fa fa-cogs\"></i> Connection cannot be established ... </h5></font></div>";
			}
			
					
			return dinamicPart;
		}
}
