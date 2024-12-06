package controller;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.DAO;
import model.JavaBeans;

@WebServlet({ "/Controller", "/main", "/principal", "/recarga", "/logout"})
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	DAO dao = new DAO();
	JavaBeans usuario = new JavaBeans();

	public Controller() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getServletPath();
		System.out.println(action);
		if (action.equals("/main")) {
			realizarLogin(request, response);
		} else if (action.equals("/principal")) {
			dashboardPrincipal(request, response);
		} else if (action.equals("/recarga")) {
			dashboardRecarga(request, response);
		} else if (action.equals("/logout")) {
			logout(request, response);
		} else {
			response.sendRedirect("index.html");
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getServletPath();
		System.out.println(action);
		if (action.equals("/main")) {
			realizarLogin(request, response);
		} else if (action.equals("/principal")) {
			dashboardPrincipal(request, response);
		} else if (action.equals("/recarga")) {
			dashboardRecarga(request, response);
		} else if (action.equals("/logout")) {
			logout(request, response);
		} else {
			response.sendRedirect("index.html");
		}
	}

	protected void realizarLogin(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String matricula = request.getParameter("matricula");
		String senha = request.getParameter("senha");

		if (dao.verificarLogin(matricula, senha)) {
			request.getSession().setAttribute("matricula", matricula);

			int idAluno = dao.obterId(matricula);
			ArrayList<JavaBeans> ultimasCompras = dao.listarCompras(idAluno, 5);

			BigDecimal saldoAtual = dao.obterSaldoAtual(idAluno);
			BigDecimal ultimaRecarga = dao.obterUltimaRecarga(idAluno);

			LocalDate dataAtual = LocalDate.now();
			int mesAtual = dataAtual.getMonthValue();
			int anoAtual = dataAtual.getYear();
			BigDecimal totalGastoMes = dao.obterTotalGastoMes(idAluno, mesAtual, anoAtual);

			request.setAttribute("ultimasCompras", ultimasCompras);
			request.setAttribute("saldoAtual", saldoAtual);
			request.setAttribute("totalGastoMes", totalGastoMes);
			request.setAttribute("ultimaRecarga", ultimaRecarga);

			RequestDispatcher rd = request.getRequestDispatcher("main.jsp");
			rd.forward(request, response);
		} else {
			response.sendRedirect("index.html?error=1");
		}
	}

	protected void dashboardPrincipal(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String matricula = (String) request.getSession().getAttribute("matricula");
		if (matricula == null) {
			response.sendRedirect("index.html?error=sessionExpired");
			return;
		}
		try {
			int idAluno = dao.obterId(matricula);
			ArrayList<JavaBeans> ultimasCompras = dao.listarCompras(idAluno, 5);

			BigDecimal saldoAtual = dao.obterSaldoAtual(idAluno);
			BigDecimal ultimaRecarga = dao.obterUltimaRecarga(idAluno);

			LocalDate dataAtual = LocalDate.now();
			int mesAtual = dataAtual.getMonthValue();
			int anoAtual = dataAtual.getYear();
			BigDecimal totalGastoMes = dao.obterTotalGastoMes(idAluno, mesAtual, anoAtual);

			request.setAttribute("ultimasCompras", ultimasCompras);
			request.setAttribute("saldoAtual", saldoAtual);
			request.setAttribute("totalGastoMes", totalGastoMes);
			request.setAttribute("ultimaRecarga", ultimaRecarga);

			RequestDispatcher rd = request.getRequestDispatcher("main.jsp");
			rd.forward(request, response);
		} catch (Exception e) {
			response.sendRedirect("error.jsp?error=dashboardError");
		}
	}

	protected void dashboardRecarga(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String matricula = (String) request.getSession().getAttribute("matricula");
		if (matricula == null) {
			response.sendRedirect("index.html?error=sessionExpired");
			return;
		}
		try {
			int idAluno = dao.obterId(matricula);
			ArrayList<JavaBeans> ultimasRecargas = dao.listarRecargas(idAluno, 4);

			request.setAttribute("ultimasRecargas", ultimasRecargas);

			RequestDispatcher rd = request.getRequestDispatcher("recarga.jsp");
			rd.forward(request, response);
		} catch (Exception e) {
			response.sendRedirect("error.jsp?error=recargaError");
		}
	}
	
	protected void logout(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getSession().invalidate();
		response.sendRedirect("index.html");
	}
}
