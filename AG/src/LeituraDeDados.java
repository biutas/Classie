import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class LeituraDeDados {
	
	static List<Professor> professores;
	static List<Curso> cursos;
	static List<Aula> aulas;
	
	public static void lerXML() throws ParserConfigurationException, SAXException, IOException {
		
		System.out.println("Lendo dados..");
		
		File finalFile = new File("dados/dados.xml");
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuider = dbFactory.newDocumentBuilder();
		Document doc = dBuider.parse(finalFile);
		doc.getDocumentElement().normalize();
		
		NodeList teacherNodes = doc.getDocumentElement().getChildNodes().item(2).getChildNodes();
		NodeList cursoNodes = doc.getDocumentElement().getChildNodes().item(4).getChildNodes();
		NodeList aulaNodes = doc.getDocumentElement().getChildNodes().item(6).getChildNodes();
		
		System.out.println("Criando objetos...");
		
		System.out.println("Carregando Professores...");
		professores = lerProfessores(teacherNodes);
		System.out.println("Carregando Cursos...");
		cursos = lerCursos(cursoNodes);
		System.out.println("Carregando Aulas...");
		aulas = lerAulas(aulaNodes);
		
		
	}
	
	public static List<Professor> lerProfessores(NodeList professorNodes){
		
		List<Professor> professores = new ArrayList<Professor>();
		for (int i = 0; i < professorNodes.getLength(); i++) {
			
			Node professorNode = professorNodes.item(i);
			
			if(professorNode.getNodeType() == Node.ELEMENT_NODE) {
				
				Professor professor = new Professor();
				
				Element professorElement = (Element) professorNodes;
				
				String horarios[] = professorElement.getAttribute("timeoff").replace(".", "").split(",");
				
				int[][] valorInt = new int[horarios.length][horarios[0].length()];
				
				for (int i1 = 0; i1 < horarios.length; i1++) {
					for (int j = 0; j < horarios[i1].length(); j++) {
						valorInt[j][i1] = Integer.parseInt(horarios[i1].substring(i1, i1+1));
						System.out.println(valorInt[i1]);
					}
				}
				
				professor.setDisponibilidade( valorInt );
				professor.setId(Integer.parseInt(professorElement.getAttribute("id")));
				professor.setNome(professorElement.getAttribute("name"));
				System.out.println(professorElement.getAttribute("name"));
				
				professores.add(professor);
				
			}
		}
		return professores;	
	}
	
	public static List<Curso> lerCursos(NodeList cursoNodes){
		
		List<Curso> cursos = new ArrayList<Curso>();
		for (int i = 0; i < cursoNodes.getLength(); i++) {
			
			Node cursoNode = cursoNodes.item(i);
			
			if(cursoNode.getNodeType() == Node.ELEMENT_NODE) {
				
				Curso curso = new Curso();
				
				Element cursoElement = (Element) cursoNodes;
				
				String horarios[] = cursoElement.getAttribute("timeoff").replace(".", "").split(",");
				
				int[][] valorInt = new int[horarios.length][horarios[0].length()];
				
				for (int i1 = 0; i1 < horarios.length; i1++) {
					for (int j = 0; j < horarios[i1].length(); j++) {
						valorInt[j][i1] = Integer.parseInt(horarios[i1].substring(i1, i1+1));
						System.out.println(valorInt[i1]);
					}
				}

				curso.setHorario( valorInt );
				curso.setId(Integer.parseInt(cursoElement.getAttribute("id")));
				curso.setNome(cursoElement.getAttribute("name"));
				curso.setSigla(cursoElement.getAttribute("short"));
				
				cursos.add(curso);
				
			}
		}
		return cursos;	
	}
	
public static List<Aula> lerAulas(NodeList aulasNodes){
		
		List<Aula> aulas = new ArrayList<Aula>();
		for (int i = 0; i < aulasNodes.getLength(); i++) {
			
			Node aulaNode = aulasNodes.item(i);
			
			if(aulaNode.getNodeType() == Node.ELEMENT_NODE) {
				
				Aula aula = new Aula();
				
				Element aulaElement = (Element) aulasNodes;
				
				String horarios[] = aulaElement.getAttribute("timeoff").replace(".", "").split(",");
				
				int[][] valorInt = new int[horarios.length][horarios[0].length()];
				
				for (int i1 = 0; i1 < horarios.length; i1++) {
					for (int j = 0; j < horarios[i1].length(); j++) {
						valorInt[j][i1] = Integer.parseInt(horarios[i1].substring(i1, i1+1));
						System.out.println(valorInt[i1]);
					}
				}

				aula.setIdAula(Integer.parseInt(aulaElement.getAttribute("id")));
				
				Professor p = null;
				
				for (int j = 0; j < valorInt.length; j++) {
					if(Integer.parseInt(aulaElement.getAttribute("teacherid")) == professores.get(j).getId()) {
						p = professores.get(j);
					}
				}
				
				aula.setProfessor( p );
				aula.setDuracaoPeriodos( Integer.parseInt(aulaElement.getAttribute("durationperiods")) );
				aula.setPeriodosPorSemana( Integer.parseInt(aulaElement.getAttribute("periodsperweek")) );
				
				aulas.add(aula);
				
			}
		}
		return aulas;	
	}
	
	

}
