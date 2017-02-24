import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class NewServlet
 */
@WebServlet("/NewServlet")
public class NewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public NewServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		final String ad = request.getParameter("ad");
		final String soyad = request.getParameter("soyad");
		final String sehir = request.getParameter("sehir");
		final String sifre = request.getParameter("sifre");
		
		final PrintWriter pw = response.getWriter();
		pw.println("<html><head><body>");
		pw.println("Name : " + ad + "<br>");
		pw.println("Surname : " + soyad + "<br>");
		

		pw.println("</body></head></html>");
		pw.close();
		
		/*CreatePropertiesFile c = new CreatePropertiesFile();
		c.CreatePropertiesFileMethod();
		c.LoadPropertiesFile();*/

		PersonCRUD personTableObject = new PersonCRUD();
		if(request.getParameter("submit").equals("Kaydet"))
		{
			try {
				personTableObject.AddInfo(ad, soyad,sehir,sifre);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (NamingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(request.getParameter("submit").equals("Sil"))
		{
			try {
				personTableObject.DeleteInfo(ad,soyad,sehir,sifre);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (NamingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(request.getParameter("submit").equals("Guncelle"))
		{
			try {
				personTableObject.UpdateInfo(ad,soyad,sehir,sifre);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (NamingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
