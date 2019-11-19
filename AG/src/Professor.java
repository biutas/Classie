
public class Professor {
	private int id;
	private String nome;
	private int[] disponibilidade;

	public Professor() {
		// TODO Auto-generated constructor stub
	}

	public Professor(int id, String nome, int[] disponibilidade) {
		this.id = id;
		this.nome = nome;
		this.disponibilidade = disponibilidade;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int[] getDisponibilidade() {
		return disponibilidade;
	}

	public int getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public void setDisponibilidade(int[] disponibilidade) {
		this.disponibilidade = disponibilidade;
	}
	
}
