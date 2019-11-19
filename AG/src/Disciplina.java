
public class Disciplina {
	private int id;
	private String nome;
	private Curso curso;
	private int creditos;
	private int fase;

	public Disciplina() {
		// TODO Auto-generated constructor stub
	}

	public Disciplina(int id, String nome, Curso curso, int creditos, int fase) {
		this.id = id;
		this.nome = nome;
		this.curso = curso;
		this.creditos = creditos;
		this.fase = fase;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	public void setCreditos(int creditos) {
		this.creditos = creditos;
	}

	public void setFase(int fase) {
		this.fase = fase;
	}

	public int getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public Curso getCurso() {
		return curso;
	}

	public int getCreditos() {
		return creditos;
	}

	public int getFase() {
		return fase;
	}

}
