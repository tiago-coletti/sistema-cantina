<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="model.JavaBeans"%>
<%@ page import="java.util.ArrayList"%>
<%
ArrayList<JavaBeans> ultimasCompras = (ArrayList<JavaBeans>) request.getAttribute("ultimasCompras");
%>

<!DOCTYPE html>
<html lang="pt-BR">
<head>
<meta charset='utf-8'>
<meta http-equiv='X-UA-Compatible' content='IE=edge'>
<title>FoodBooks</title>
<meta name='viewport' content='width=device-width, initial-scale=1'>

<!----======== CSS ======== -->
<link rel='stylesheet' href='style.css'>

<!----======== Iconscout CSS ======== -->
<link rel="stylesheet"
	href="https://unicons.iconscout.com/release/v4.0.8/css/line.css">

</head>
<body>
	<nav>
		<div class="logo-name">
			<div class="logo-image">
				<img src="imagens/logo.jpg" alt="">
			</div>

			<span class="logo_name">FoodBooks</span>
		</div>
		<div class="menu-items">
			<ul class="nav-links">
				<li><a href="principal"> <i class="uil uil-estate"></i> <span
						class="link-name">Principal</span>
				</a></li>
				<li><a href="recarga"> <i class="uil uil-wallet"></i> <span
						class="link-name">Recarga</span>
				</a></li>
				<li><a href="#"> <i class="uil uil-receipt"></i> <span
						class="link-name">Extrato</span>
				</a></li>
				<li><a href="#"> <i class="uil uil-box"></i> <span
						class="link-name">Itens</span>
				</a></li>
				<li><a href="#"> <i class="uil uil-utensils-alt"></i> <span
						class="link-name">Cardápio</span>
				</a></li>
				<li><a href="#"> <i class="uil uil-info-circle"></i> <span
						class="link-name">Suporte</span>
				</a></li>
			</ul>

			<ul class="logout-mode">
				<li><a href="logout"> <i class="uil uil-signout"></i> <span
						class="link-name">Sair</span>
				</a></li>
				<li class="mode"><a href="#"> <i class="uil uil-moon"></i>
						<span class="link-name">Modo Escuro</span>
				</a>
					<div class="mode-toggle">
						<span class="switch"></span>
					</div></li>
			</ul>
		</div>
	</nav>

	<section class="dashboard">
		<div class="top">
			<i class="uil uil-bars sidebar-toggle"></i>
		</div>

		<div class="dash-content">
			<div class="overview">
				<div class="title">
					<i class="uil uil-tachometer-fast-alt"></i> <span class="text">Principal</span>
				</div>

				<div class="boxes">
					<div class="box box1">
						<i class="uil uil-money-bill"></i> <span class="text">Créditos
							Disponíveis</span> <span class="number"><%=request.getAttribute("saldoAtual")%></span>
					</div>
					<div class="box box2">
						<i class="uil uil-shopping-cart"></i> <span class="text">Total
							Gasto</span> <span class="number"><%=request.getAttribute("totalGastoMes")%></span>
					</div>
					<div class="box box3">
						<i class="uil uil-bill"></i> <span class="text">Última
							Recarga</span> <span class="number"><%=request.getAttribute("ultimaRecarga")%></span>
					</div>
				</div>
			</div>

			<div class="activity">
				<div class="title">
					<i class="uil uil-clock-three"></i> <span class="text">Últimas
						Compras</span>
				</div>
				<div class="activity-data">
					<div class="data names">
						<span class="data-title">Data</span>
						<%
						if (ultimasCompras != null && !ultimasCompras.isEmpty()) {
						%>
						<%
						for (JavaBeans compra : ultimasCompras) {
						%>
						<span class="data-list"><%=compra.getDataHoraCompra()%></span>
						<%
						}
						%>
						<%
						} else {
						%>
						<span class="data-list">Nenhuma compra recente</span>
						<%
						}
						%>
					</div>
					<div class="data joined">
						<span class="data-title">Valor</span>
						<%
						if (ultimasCompras != null && !ultimasCompras.isEmpty()) {
						%>
						<%
						for (JavaBeans compra : ultimasCompras) {
						%>
						<span class="data-list">R$ <%=compra.getValorCompra()%></span>
						<%
						}
						}
						%>
					</div>
					<div class="data email">
						<span class="data-title">Item</span>
						<%
						if (ultimasCompras != null && !ultimasCompras.isEmpty()) {
						%>
						<%
						for (JavaBeans compra : ultimasCompras) {
						%>
						<span class="data-list"><%=compra.getItemCompra()%></span>
						<%
						}
						}
						%>
					</div>
					<div class="data status">
						<span class="data-title">Saldo Inicial</span>
						<%
						if (ultimasCompras != null && !ultimasCompras.isEmpty()) {
						%>
						<%
						for (JavaBeans compra : ultimasCompras) {
						%>
						<span class="data-list">R$ <%=compra.getSaldoInicialCompra()%></span>
						<%
						}
						}
						%>
					</div>
					<div class="data type">
						<span class="data-title">Saldo Atual</span>
						<%
						if (ultimasCompras != null && !ultimasCompras.isEmpty()) {
						%>
						<%
						for (JavaBeans compra : ultimasCompras) {
						%>
						<span class="data-list">R$ <%=compra.getSaldoRestanteCompra()%></span>
						<%
						}
						}
						%>
					</div>
				</div>
			</div>
		</div>
	</section>

	<script src="scripts/dashboard.js"></script>
</body>
</html>