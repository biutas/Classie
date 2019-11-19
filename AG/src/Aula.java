
public class Aula {
	private int idAula;
	private Disciplina disciplina;
	private Professor professor;

	public Aula() {
		// TODO Auto-generated constructor stub
	}

	public Aula(int idAula, Disciplina disciplina, Professor professor) {
		this.idAula = idAula;
		this.disciplina = disciplina;
		this.professor = professor;
	}

	public void setIdAula(int idAula) {
		this.idAula = idAula;
	}

	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}

	public void setProfessor(Professor professor) {
		this.professor = professor;
	}

	public int getIdAula() {
		return idAula;
	}

	public Disciplina getDisciplina() {
		return disciplina;
	}

	public Professor getProfessor() {
		return professor;
	}
}
