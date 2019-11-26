
public class Aula {
	private int idAula;
	private Disciplina disciplina;
	private Professor professor;
	private int DuracaoPeriodos;
	private int PeriodosPorSemana;

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
	
	public void setDuracaoPeriodos(int duracaoPeriodos) {
		DuracaoPeriodos = duracaoPeriodos;
	}
	
	public void setPeriodosPorSemana(int periodosPorSemana) {
		PeriodosPorSemana = periodosPorSemana;
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
	
	public int getDuracaoPeriodos() {
		return DuracaoPeriodos;
	}
	
	public int getPeriodosPorSemana() {
		return PeriodosPorSemana;
	}
	
}
