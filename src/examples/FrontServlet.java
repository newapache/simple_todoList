package examples;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;

/**
 * Servlet implementation class FrontServlet
 */
@WebServlet("/front")
public class FrontServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FrontServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
        int diceValue = (int)(Math.random() * 6) + 1; 
        //요청 처리결과 저장 
        // servlet1의 결과를 servlet2에서도 쓰기 위해 계속 유지되는 객체에 저장 
        // 어떤 값이든 다 맡길 수 있으므로 param은  obj type
        request.setAttribute("dice", diceValue);
        
        RequestDispatcher requestDispatehcer = request.getRequestDispatcher("/next");
        requestDispatehcer.forward(request, response);
	}

}
