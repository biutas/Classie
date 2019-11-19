
public class Curso {
	private int id;
	private String nome;
	private int qtdFases;

	public Curso() {
		// TODO Auto-generated constructor stub
	}

	public Curso(int id, String nome, int qtdFases) {
		this.id = id;
		this.nome = nome;
		this.qtdFases = qtdFases;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setQtdFases(int qtdFases) {
		this.qtdFases = qtdFases;
	}

	public int getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public int getQtdFases() {
		return qtdFases;
	}

}
