/* Aba Sobreposta(recargas) */
function openPixModal() {
    document.getElementById("pixModal").style.display = "block";
}
function closePixModal() {
    document.getElementById("pixModal").style.display = "none";
}
// Função para simular o envio da recarga
function submitPix() {
    const valor = document.getElementById("pixValue").value;
    const file = document.getElementById("pixFile").files[0];
    
    if (valor && file) {
        alert("Recarga via PIX realizada com sucesso!");
        // Aqui você pode fazer o envio do valor e arquivo para o servidor ou realizar qualquer outra ação.
        closePixModal();
    } else {
        alert("Por favor, preencha todos os campos.");
    }
}
window.onclick = function(event) {
    if (event.target === document.getElementById("pixModal")) {
        closePixModal();
    }
};
