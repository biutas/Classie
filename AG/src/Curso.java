
public class Curso {
	private int id;
	private String nome;
	private String sigla;
	private int horario[][];
	private int fase;

	public Curso() {
		// TODO Auto-generated constructor stub
	}

	public Curso(int id, String nome, int qtdFases) {
		this.id = id;
		this.nome = nome;

	}

	public void setId(int id) {
		this.id = id;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public void setSigla(String sigla) {
		this.sigla = sigla;
	}
	
	public void setHorario(int[][] horario) {
		this.horario = horario;
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
	
	public String getSigla() {
		return sigla;
	}
	
	public int[][] getHorario() {
		return horario;
	}

	public int getFase() {
		return fase;
	}

}
