package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.DAO;
import model.JavaBeans;

@WebServlet(urlPatterns = { "/Controller", "/main", "/insert" })
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	DAO dao = new DAO();
	JavaBeans colaborador = new JavaBeans();

	public Controller() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String action = request.getServletPath();
		System.out.println(action);
		if (action.equals("/main")) {
			colaboradores(request, response);
		} else if (action.equals("/insert")) {
			novoColaborador(request, response);
		} else {
			response.sendRedirect("index.html");

		}
	}

	// Listar colaboradores
	protected void colaboradores(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Criando um objeto que irá receber os dados JavaBeans
		ArrayList<JavaBeans> lista = dao.listarColaborador();
		// Emcaminhar a lista ao documento cafe_da_manha.jsp
		request.setAttribute("colaboradores", lista);
		RequestDispatcher rd = request.getRequestDispatcher("cafe_da_manha.jsp");
		rd.forward(request, response);

	}

	// Novo Colaborador
	protected void novoColaborador(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Teste de recebimento de dados do formulário
		System.out.println(request.getParameter("nome"));
		System.out.println(request.getParameter("cpf"));
		System.out.println(request.getParameter("comida"));
		// setandor as variaveis Java Beans
		colaborador.setNome(request.getParameter("nome"));
		colaborador.setCpf(request.getParameter("cpf"));
		colaborador.setComida(request.getParameter("comida"));
		// invocar o método inserirColaborador passando o objeto contato
		dao.inserirColaborador(colaborador);
		// rediricionar para o documento cafe_da_manha.jsp
		response.sendRedirect("main");

	}
}
