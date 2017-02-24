import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class CreatePropertiesFile {

	public void CreatePropertiesFileMethod(){
		
		Properties prop = new Properties();
		prop.setProperty("database","db_merve");
		prop.setProperty("dbuser","root");
		prop.setProperty("dbpassword","1");
		
		try {
			prop.store(new FileOutputStream("config.properties"), null);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
	public void LoadPropertiesFile(){
		 Properties prop = new Properties();
	     try {
			prop.load(new FileInputStream("config.properties"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	             
	     System.out.println(prop.getProperty("database"));
	     System.out.println(prop.getProperty("dbuser"));
	     System.out.println(prop.getProperty("dbpassword"));		
	}		
}
