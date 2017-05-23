package com.example.inventory;


import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Controller
 */
@WebServlet("/controller")
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Controller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Database database = new Database();
		String name = request.getParameter("name");
		String qty = request.getParameter("qty");
		String price = request.getParameter("price");
		String action = request.getParameter("action");
		String id = request.getParameter("id");
		if(action == null){
			request.setAttribute("database", database.selectAll());
			getServletContext().getRequestDispatcher("/inventory.jsp").forward(request, response);
		}
		else if(action.equals("create")){
		Inventory inventory = new Inventory(name,Integer.parseInt(qty),Double.parseDouble(price));
		database.create(inventory);
		request.setAttribute("database", database.selectAll());
		getServletContext().getRequestDispatcher("/inventory.jsp").forward(request, response);
		}
		else if(action.equals("remove")){
			database.remove(Integer.parseInt(id));
			request.setAttribute("database", database.selectAll());
			getServletContext().getRequestDispatcher("/inventory.jsp").forward(request, response);
		}
		else if(action.equals("update")){
			
		}
		else if(action.equals("logout")){
			request.getSession().setAttribute("error", null);
			response.sendRedirect("index.jsp");
		}
		else{
		request.setAttribute("database", database.selectAll());
		getServletContext().getRequestDispatcher("/inventory.jsp").forward(request, response);}
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
