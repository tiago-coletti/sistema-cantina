package model;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class DAO {

	private String driver = "com.mysql.cj.jdbc.Driver";
	private String url = "jdbc:mysql://127.0.0.1:3306/dbcantina?useTimezone=true&serverTimezone=UTC";
	private String user = "root";
	private String password = "#Mariah0427";

	private Connection conectar() {
		Connection con = null;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, password);
			return con;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}

	public boolean verificarLogin(String matricula, String senha) {
		String verify = "SELECT * FROM alunos WHERE matricula = ? AND senha = ?";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(verify);
			pst.setString(1, matricula);
			pst.setString(2, senha);
			ResultSet rs = pst.executeQuery();

			return rs.next();

		} catch (Exception e) {
			System.out.println(e);
			return false;
		}
	}

	public int obterId(String matricula) {
		String read1 = "SELECT id_aluno FROM alunos WHERE matricula = ?";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(read1);
			pst.setString(1, matricula);

			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				return rs.getInt("id_aluno");
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return -1;
	}

	/* DASHBOARD PRINCIPAL */
	public ArrayList<JavaBeans> listarCompras(int id_aluno, int limite) {
		ArrayList<JavaBeans> compras = new ArrayList<>();
		String read2 = "SELECT * FROM compras WHERE id_aluno = ? ORDER BY data_hora DESC LIMIT ?";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(read2);
			pst.setInt(1, id_aluno);
			pst.setInt(2, limite);

			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				JavaBeans compra = new JavaBeans();

				compra.setId_compra(rs.getInt("id_compra"));
				compra.setItemCompra(rs.getString("item"));
				compra.setValorCompra(rs.getDouble("valor"));
				compra.setDataHoraCompra(rs.getString("data_hora"));
				compra.setSaldoInicialCompra(rs.getDouble("saldo_inicial"));
				compra.setSaldoRestanteCompra(rs.getDouble("saldo_restante"));

				compras.add(compra);
			}
			con.close();
			return compras;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}

	public BigDecimal obterSaldoAtual(int id_aluno) {
		String query1 = "SELECT saldo FROM alunos WHERE id_aluno = ?";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(query1);
			pst.setInt(1, id_aluno);

			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				return rs.getBigDecimal("saldo");
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return BigDecimal.ZERO;
	}

	public BigDecimal obterTotalGastoMes(int id_aluno, int mes, int ano) {
		String query2 = "SELECT SUM(valor) AS total_gasto FROM compras WHERE id_aluno = ? AND MONTH(data_hora) = ? AND YEAR(data_hora) = ?";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(query2);
			pst.setInt(1, id_aluno);
			pst.setInt(2, mes);
			pst.setInt(3, ano);

			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				return rs.getBigDecimal("total_gasto");
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return BigDecimal.ZERO;
	}

	public BigDecimal obterUltimaRecarga(int id_aluno) {
		String query3 = "SELECT valor FROM recargas WHERE id_aluno = ? AND status = 'Aprovado' ORDER BY data_aprovacao DESC LIMIT 1";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(query3);
			pst.setInt(1, id_aluno);

			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				return rs.getBigDecimal("valor");
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return BigDecimal.ZERO;
	}

	/* DASHBOARD RECARGAS */
	public ArrayList<JavaBeans> listarRecargas(int id_aluno, int limite) {
		ArrayList<JavaBeans> recargas = new ArrayList<>();
		String read3 = "SELECT * FROM recargas WHERE id_aluno = ? ORDER BY data_envio DESC LIMIT ?";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(read3);
			pst.setInt(1, id_aluno);
			pst.setInt(2, limite);

			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				JavaBeans recarga = new JavaBeans();

				recarga.setId_recarga(rs.getInt("id_recarga"));
				recarga.setValorRecarga(rs.getDouble("valor"));
				recarga.setStatusRecarga(rs.getString("status"));
				recarga.setDataEnvio(rs.getString("data_envio"));
				recarga.setDataAprovacao(rs.getString("data_aprovacao"));
				recarga.setValorRecarga(rs.getDouble("valor"));
				recarga.setSaldoInicialRecarga(rs.getDouble("saldo_inicial"));
				recarga.setSaldoRestanteRecarga(rs.getDouble("saldo_restante"));

				recargas.add(recarga);
			}
			con.close();
			return recargas;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}

	public void testeConexao() {
		try {
			Connection con = conectar();
			System.out.println(con);
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}