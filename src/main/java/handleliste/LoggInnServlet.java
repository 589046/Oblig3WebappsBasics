package handleliste;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoggInnServlet
 */
@WebServlet("/LoggInn")
public class LoggInnServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static final String PASSORD = "Pass";
	private static final String SALT = PassordUtil.genererTilfeldigsalt();
	private static final String HASH = PassordUtil.hashMSalt(PASSORD, SALT);

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		out.print("<!DOCTYPE html>");
		out.print("<html>");
		out.print("<head>");
		out.print("<meta charset=\"ISO-8859-1\">");
		out.print("<title>Logg inn</title> </head>");
		out.print("<body>");
		out.print("<form action=\"LoggInn\" method=\"post\">"
				+ "<label for=\"password\">Feil med inn logging</label><br>"
				+ "<input type=\"password\" id=\"password\" name=\"password\"><br>"
				+ "<input type=\"submit\" value=\"Logg inn\"><br>"
				+ "</form>");
		out.print("</body>");
		out.print("</html>");

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (PassordUtil.validerPassord(request.getParameter("password"), SALT, HASH)) {
			response.sendRedirect("Handleliste");
		} else {
			response.sendRedirect("LoggInn");
		}
	}

}
