import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class HelloWorld
 */
@WebServlet({ "/TrataRequisicao", "/HelloWorld", "/ola", "/servlet/hello",
		"/ola.html", "/cesar/gay" })
public class HelloWorld extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public HelloWorld() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		PrintWriter saida = response.getWriter();
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		HttpSession sessao = request.getSession();

		RequestDispatcher despachante = request
				.getRequestDispatcher("saida.jsp");

		String usuario = request.getParameter("nmusuario");
		String senha = request.getParameter("nmsenha");

		if (usuario.equals("Joao") && senha.equals("123")) {

			sessao.setAttribute("attrMensagem",
					"Usuário Logou e o Will é viado");

		} else {

			sessao.setAttribute("attrMensagem",
					"Usuário Não Logou e o Will continua sendo viado");

		}

		despachante.forward(request, response);
		
	}

}
