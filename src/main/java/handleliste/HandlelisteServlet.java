package handleliste;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Handleliste")
public class HandlelisteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setAttribute("items", HandlelisteUtil.handlelisten);
		request.getRequestDispatcher("Handleliste.jsp").forward(request, response);
	}
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException  {
		
		if (request.getParameter("leggTil") != "" & request.getParameter("leggTil") != null)
			HandlelisteUtil.add(request.getParameter("leggTil"));
		
		if (request.getParameter("slett") != null) 
			HandlelisteUtil.remove(request.getParameter("slett"));
		HandlelisteUtil.printAll();
		response.sendRedirect("Handleliste");
	}
}
