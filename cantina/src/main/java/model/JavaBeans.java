package model;

public class JavaBeans {
	// Atributos da tabela alunos
	private int id_aluno;
	private String nome;
	private String matricula;
	private double saldo;
	private String email;
	private String telefone;

	// Atributos da tabela recargas
	private int id_recarga;
	private double valorRecarga;
	private String statusRecarga;
	private byte[] comprovante;
	private String dataEnvio;
	private String dataAprovacao;
	private double saldoInicialRecarga;
	private double saldoRestanteRecarga;


	// Atributos da tabela compras
	private int id_compra;
	private String itemCompra;
	private double valorCompra;
	private String tipoProduto;
	private String dataHoraCompra;
	private double saldoInicialCompra;
	private double saldoRestanteCompra;

	// Construtor padrão
	public JavaBeans() {
	}

	// Construtor para alunos
	public JavaBeans(int id_aluno, String nome, String matricula, double saldo, String email, String telefone) {
		this.id_aluno = id_aluno;
		this.nome = nome;
		this.matricula = matricula;
		this.saldo = saldo;
		this.email = email;
		this.telefone = telefone;
	}

	// Construtor para recargas
	public JavaBeans(int id_recarga, double valorRecarga, String statusRecarga, byte[] comprovante, String dataEnvio,
			String dataAprovacao, double saldoInicialRecarga, double saldoRestanteRecarga) {
		super();
		this.id_recarga = id_recarga;
		this.valorRecarga = valorRecarga;
		this.statusRecarga = statusRecarga;
		this.comprovante = comprovante;
		this.dataEnvio = dataEnvio;
		this.dataAprovacao = dataAprovacao;
		this.saldoInicialRecarga = saldoInicialRecarga;
		this.saldoRestanteRecarga = saldoRestanteRecarga;
	}
	
	// Construtor para compras
	public JavaBeans(int id_compra, String itemCompra, double valorCompra, String tipoProduto, String dataHoraCompra,
			double saldoInicialCompra, double saldoRestanteCompra) {
		super();
		this.id_compra = id_compra;
		this.itemCompra = itemCompra;
		this.valorCompra = valorCompra;
		this.tipoProduto = tipoProduto;
		this.dataHoraCompra = dataHoraCompra;
		this.saldoInicialCompra = saldoInicialCompra;
		this.saldoRestanteCompra = saldoRestanteCompra;
	}

	// Getters e Setters para atributos da tabela alunos
	public int getId_aluno() {
		return id_aluno;
	}

	public void setId_aluno(int id_aluno) {
		this.id_aluno = id_aluno;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	// Getters e Setters para atributos da tabela recargas
	public int getId_recarga() {
		return id_recarga;
	}

	public void setId_recarga(int id_recarga) {
		this.id_recarga = id_recarga;
	}

	public double getValorRecarga() {
		return valorRecarga;
	}

	public void setValorRecarga(double valorRecarga) {
		this.valorRecarga = valorRecarga;
	}

	public String getStatusRecarga() {
		return statusRecarga;
	}

	public void setStatusRecarga(String statusRecarga) {
		this.statusRecarga = statusRecarga;
	}

	public byte[] getComprovante() {
		return comprovante;
	}

	public void setComprovante(byte[] comprovante) {
		this.comprovante = comprovante;
	}

	public String getDataEnvio() {
		return dataEnvio;
	}

	public void setDataEnvio(String dataEnvio) {
		this.dataEnvio = dataEnvio;
	}

	public String getDataAprovacao() {
		return dataAprovacao;
	}

	public void setDataAprovacao(String dataAprovacao) {
		this.dataAprovacao = dataAprovacao;
	}

	public String getTipoProduto() {
		return tipoProduto;
	}

	public void setTipoProduto(String tipoProduto) {
		this.tipoProduto = tipoProduto;
	}

	// Getters e Setters para atributos da tabela compras
	public int getId_compra() {
		return id_compra;
	}

	public void setId_compra(int id_compra) {
		this.id_compra = id_compra;
	}

	public String getItemCompra() {
		return itemCompra;
	}

	public void setItemCompra(String itemCompra) {
		this.itemCompra = itemCompra;
	}

	public double getValorCompra() {
		return valorCompra;
	}

	public void setValorCompra(double valorCompra) {
		this.valorCompra = valorCompra;
	}

	public String getDataHoraCompra() {
		return dataHoraCompra;
	}

	public void setDataHoraCompra(String dataHoraCompra) {
		this.dataHoraCompra = dataHoraCompra;
	}

	public double getSaldoInicialRecarga() {
		return saldoInicialRecarga;
	}

	public void setSaldoInicialRecarga(double saldoInicialRecarga) {
		this.saldoInicialRecarga = saldoInicialRecarga;
	}

	public double getSaldoRestanteRecarga() {
		return saldoRestanteRecarga;
	}

	public void setSaldoRestanteRecarga(double saldoRestanteRecarga) {
		this.saldoRestanteRecarga = saldoRestanteRecarga;
	}

	public double getSaldoInicialCompra() {
		return saldoInicialCompra;
	}

	public void setSaldoInicialCompra(double saldoInicialCompra) {
		this.saldoInicialCompra = saldoInicialCompra;
	}

	public double getSaldoRestanteCompra() {
		return saldoRestanteCompra;
	}

	public void setSaldoRestanteCompra(double saldoRestanteCompra) {
		this.saldoRestanteCompra = saldoRestanteCompra;
	}
}
