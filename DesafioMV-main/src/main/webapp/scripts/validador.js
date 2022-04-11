/**
 * Validação de formulário 
 * autor João Victor de Santana
 */

function validar() {
	let nome = frmColaborador.nome.value
	let cpf = frmColaborador.cpf.value
    let comida = frmColaborador.comida.value
	if (nome === "") {
		alert('Preencha o campo Nome')
		frmColaborador.nome.focus();
		return false

	}
	if (cpf === "") {
		alert('Preencha o campo CPF')
		frmColaborador.cpf.focus();
		return false

	}
	if (comida === "") {
		alert('Preencha o campo Comida')
		frmColaborador.comida.focus();
		return false

	} else {
		document.forms["frmColaborador"].submit()
	}

}