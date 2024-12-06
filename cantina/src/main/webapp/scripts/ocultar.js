/*=============== MOSTRAR OCULTAR SENHA LOGIN ===============*/
const passwordAccess = (loginPass, loginEye) => {
	const input = document.getElementById(loginPass),
		iconEye = document.getElementById(loginEye)

	iconEye.addEventListener('click', () => {
		// Mudar senha para texto
		input.type = input.type === 'password' ? 'text' : 'password';

		// Trocar ícone
		iconEye.classList.toggle('ri-eye-fill');
		iconEye.classList.toggle('ri-eye-off-fill');
	});
}
passwordAccess('password', 'loginPassword');
