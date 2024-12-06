// Função para verificar os parâmetros da URL
function getQueryParam(param) {
	const urlParams = new URLSearchParams(window.location.search);
	return urlParams.get(param);
}

// Verifica se existe um erro na URL
const error = getQueryParam('error');
if (error === '1') {
	document.getElementById('error-message').textContent = 'Matrícula ou senha inválidas!';
	document.getElementById('error-message').style.display = 'block';
}
