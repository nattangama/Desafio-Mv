package model;

public class JavaBeans {
	private String idcolab;
	private String nome;
	private String cpf;
	private String comida;

	public JavaBeans() {
		super();
	}
	

	public JavaBeans(String idcolab, String nome, String cpf, String comida) {
		super();
		this.idcolab = idcolab;
		this.nome = nome;
		this.cpf = cpf;
		this.comida = comida;
	}


	public String getIdcolab() {
		return idcolab;
	}

	public void setIdcolab(String idcolab) {
		this.idcolab = idcolab;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getComida() {
		return comida;
	}

	public void setComida(String comida) {
		this.comida = comida;
	}

	

}
