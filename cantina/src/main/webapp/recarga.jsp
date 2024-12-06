<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="model.JavaBeans"%>
<%@ page import="java.util.ArrayList"%>
<%
ArrayList<JavaBeans> ultimasRecargas = (ArrayList<JavaBeans>) request.getAttribute("ultimasRecargas");
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
    <link rel="stylesheet" href="https://unicons.iconscout.com/release/v4.0.8/css/line.css">

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
                <li><a href="principal">
                    <i class="uil uil-estate"></i>
                    <span class="link-name">Principal</span>
                </a></li>
                <li><a href="recarga">
                    <i class="uil uil-wallet"></i>
                    <span class="link-name">Recarga</span>
                </a></li>
                <li><a href="#">
                    <i class="uil uil-receipt"></i>
                    <span class="link-name">Extrato</span>
                </a></li>
                <li><a href="#">
                    <i class="uil uil-box"></i>
                    <span class="link-name">Itens</span>
                </a></li>
                <li><a href="#">
                    <i class="uil uil-utensils-alt"></i>
                    <span class="link-name">Cardápio</span>
                </a></li>
                <li><a href="#">
                    <i class="uil uil-info-circle"></i>
                    <span class="link-name">Suporte</span>
                </a></li>
            </ul>

            <ul class="logout-mode">
                <li><a href="logout">
                    <i class="uil uil-signout"></i>
                    <span class="link-name">Sair</span>
                </a></li>
                <li class="mode">
                    <a href="#">
                        <i class="uil uil-moon"></i>
                        <span class="link-name">Modo Escuro</span>
                    </a>
                    <div class="mode-toggle">
                        <span class="switch"></span>
                </div>
            </li>
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
                    <i class="uil uil-tachometer-fast-alt"></i>
                    <span class="text">Recarga</span>
                </div>
                
                <div class="boxes">
                    <div class="box box1 pix-box"> 
                        <i class="uil uil-qrcode-scan"></i>
                        <span class="text">PIX</span>
                        <button class="button-18" role="button" onclick="openPixModal()">Recarregar</button>
                    </div>
                    <div class="box box2 credito-box"> 
                        <i class="uil uil-credit-card"></i>
                        <span class="text">Cartão de crédito</span>
                        <button class="button-18" role="button">Recarregar</button>
                    </div>
                    <div class="box box3 transferencia-box"> 
                        <i class="uil uil-corner-up-left-alt"></i>
                        <span class="text">Transferência Bancária</span>
                        <button class="button-18" role="button">Recarregar</button>
                    </div>
                </div>
            </div>

            <div class="activity">
                <div class="title">
                    <i class="uil uil-clock-three"></i>
                    <span class="text">Últimas Recargas</span>
                </div>
                <div class="activity-data">
                    <div class="data names">
                        <span class="data-title">Data de Envio</span>
						<%
						if (ultimasRecargas != null && !ultimasRecargas.isEmpty()) {
						%>
						<%
						for (JavaBeans recarga : ultimasRecargas) {
						%>
						<span class="data-list"><%=recarga.getDataEnvio()%></span>
						<%
						}
						%>
						<%
						} else {
						%>
						<span class="data-list">Nenhuma recarga recente</span>
						<%
						}
						%>
                    </div>
                    <div class="data joined">
                        <span class="data-title">Valor</span>
						<%
						if (ultimasRecargas != null && !ultimasRecargas.isEmpty()) {
						%>
						<%
						for (JavaBeans recarga : ultimasRecargas) {
						%>
						<span class="data-list">R$ <%=recarga.getValorRecarga()%></span>
						<%
						}
						}
						%>
                    </div>
                    <div class="data joined">
                        <span class="data-title">Status</span>
						<%
						if (ultimasRecargas != null && !ultimasRecargas.isEmpty()) {
						%>
						<%
						for (JavaBeans recarga : ultimasRecargas) {
						%>
						<span class="data-list"><%=recarga.getStatusRecarga()%></span>
						<%
						}
						}
						%>
                    </div>
					<div class="data status">
						<span class="data-title">Saldo Inicial</span>
						<%
						if (ultimasRecargas != null && !ultimasRecargas.isEmpty()) {
						%>
						<%
						for (JavaBeans recarga : ultimasRecargas) {
						%>
						<span class="data-list">R$ <%=recarga.getSaldoInicialRecarga()%></span>
						<%
						}
						}
						%>
					</div>
					<div class="data type">
						<span class="data-title">Saldo Atual</span>
						<%
						if (ultimasRecargas != null && !ultimasRecargas.isEmpty()) {
						%>
						<%
						for (JavaBeans recarga : ultimasRecargas) {
						%>
						<span class="data-list">R$ <%=recarga.getSaldoRestanteRecarga()%></span>
						<%
						}
						}
						%>
					</div>
                </div>
            </div>
        </div>
    </section>

    <div id="pixModal" class="pix-modal">
        <div class="pix-modal-content">
            <span class="close" onclick="closePixModal()">&times;</span>
            <h2>Recarga via PIX</h2>
            <!-- Aviso sobre o tempo de aprovação -->
            <p class="warning-message">
                <strong>Atenção:</strong> O tempo de aprovação da transação pode demorar até 72 horas dependendo da disponibilidade da cantina.
            </p>
            <p><strong>Chave PIX (CNPJ):</strong> 12.345.678/0001-99</p>
            
            <!-- Explicação sobre como funciona -->
            <p class="info-message">
                Para realizar a recarga, faça uma transferência para a chave PIX acima. Após isso, anexe o comprovante de pagamento e clique em "Confirmar Recarga". Os arquivos aceitos são: .jpg, .jpeg, .png, .pdf.
            </p>
            
            <label for="pixValue">Valor da Recarga:</label>
            <input type="number" id="pixValue" placeholder="Digite o valor">
            
            <label for="pixFile">Anexar Comprovante:</label>
            <input type="file" id="pixFile" accept=".jpg, .jpeg, .png, .pdf">
            
            <button class="button-18" onclick="submitPix()">Confirmar Recarga</button>
        </div>
    </div>

    <script src="scripts/dashboard.js"></script>
    <script src="scripts/modal.js"></script>
</body>
</html>
