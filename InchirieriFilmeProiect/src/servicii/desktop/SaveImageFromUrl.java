package servicii.desktop;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.imageio.ImageIO;

@SuppressWarnings("unused")
public class SaveImageFromUrl {
	public static void saveImage(String imageUrl, String destinationFile,String imgExtension) throws IOException {
		//String urlStr = "http://www.earthtimes.org/newsimage/osteoderms-storing-minerals-helped-huge-dinosaurs-survive_3011.jpg";
		URL url = new URL(imageUrl);
		HttpURLConnection connection = (HttpURLConnection) url
		        .openConnection();
		connection.setRequestProperty(
		    "User-Agent",
		    "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_7_5) AppleWebKit/537.31 (KHTML, like Gecko) Chrome/26.0.1410.65 Safari/537.31");
		BufferedImage image = ImageIO.read(connection.getInputStream());
		try{
	        File fileTemp = new File(destinationFile);
	          if (fileTemp.exists()){
	             fileTemp.delete();
	          }
	      }catch(Exception e){
	         // if any error occurs
	         e.printStackTrace();
	      }
		File f = new File(destinationFile);
		ImageIO.write(image, imgExtension, f);
	}
}