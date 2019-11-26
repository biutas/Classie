import java.io.IOException;
import java.util.Random;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

public class main {

	// Declaracao das variaveis
	// Populacao
	private static int tamPopulacao = 2;
	private static int tamCromossomo = 10;
	private static int nAulas = 9;
	private static int[][] populacao = new int[tamPopulacao][tamCromossomo];
	private int[] cromossomo = new int[tamCromossomo];
	private static int pMax = 10000;

	// Metodos de selecao, porcentagem que sera usada por cada metodo, numeros de 0
	// a 1
	private int elitismo = 1;
	private static double roletaSimples = 1;

	// Probabilidade de Cruzamento, 0 a 100
	private static int pCruzamento = 100;
	// Probabilidade de Mutacao, numeros de 0 a 100
	private int pMutacao = 20;

	static int pontuacaoFinal = 3000;

	public static void main(String[] args) {
		
		try {
			LeituraDeDados.lerXML();
		} catch (ParserConfigurationException | SAXException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// Cria primeira Populacao de Cromossomos,
		// cada cromossomo sera uma linha de uma matriz,
		// A matriz e' a Populacao
		for (int i = 0; i < tamPopulacao; i++) {
			populacao[i] = criarCromossomo(tamCromossomo, nAulas);
		}
		// Print da populacao
		for (int i = 0; i < tamPopulacao; i++) {
			for (int j = 0; j < tamCromossomo; j++) {
				System.out.print(populacao[i][j] + " ");
			}
			System.out.println();
		}

		int menorPontuacao = Integer.MAX_VALUE;

		// Laco de repeticao, repete ate o programa achar valor menor que a pontuacao
		// desejada(OBJETIVO)
		int OBJETIVO = 1000;
		while (menorPontuacao > OBJETIVO) {

			// Gera a nova populacao
			populacao = novaPopulacao(populacao).clone();

			// Print da nova populacao
			for (int i = 0; i < tamPopulacao; i++) {
				for (int j = 0; j < tamCromossomo; j++) {
					System.out.print(populacao[i][j]);
				}
				// Avalia para procurar o cromossomo com menor pontuacao
				if (funcaoAvaliacao(populacao[i]) < menorPontuacao) {
					menorPontuacao = funcaoAvaliacao(populacao[i]);
				}
				System.out.println();
			}

			System.out.println(menorPontuacao);

		}

	}

	// Gera nova populacao a partir da populacao anterior
	public static int[][] novaPopulacao(int[][] populacao) {
		int[][] novaPopulacao = new int[tamPopulacao][tamCromossomo];
		int[][] cruzamentos = new int[tamPopulacao][tamCromossomo];
		// Classifica as pontuacoes dos cromossomos
		int[] pontuacao = new int[tamPopulacao];
		pontuacao[0] = 0;

		for (int i = 1; i < tamPopulacao; i++) {
			pontuacao[i] = funcaoAvaliacao(populacao[i]) + pontuacao[i - 1];
		}

		System.out.println("Somatorio " + pontuacao[tamPopulacao - 1]);

		// Decide quais cromossomos serão cruzados
		int nAleatorio = 0;
		int cont = 0;
		for (int i = 0; i < tamPopulacao; i++) {
			nAleatorio = geradorAleatorio(pontuacao[tamPopulacao - 1]);
			for (int j = 1; j < tamPopulacao; j++) {
				if (nAleatorio <= pontuacao[j]) {
					cruzamentos[cont] = populacao[j - 1].clone();
					cont++;
					j = tamPopulacao;
				}
			}
		}

		for (int i = 0; i < tamPopulacao; i++) {
			for (int j = 0; j < tamCromossomo; j++) {
				System.out.print(cruzamentos[i][j]);
			}
			System.out.println();
		}

		// Faz cruzamento de cromossomos
		for (int i = 0; i < tamPopulacao; i += 2) {
			fazerCruzamentoSimples(cruzamentos[i].clone(), cruzamentos[i + 1].clone(), novaPopulacao, i);
		}
		return novaPopulacao;
	}

	public static int[][] fazerCruzamentoSimples(int[] cromossomoA, int[] cromossomoB, int[][] novaPopulacao, int i) {
		// int[][] cromossomoC = new int[2][tamCromossomo];
		int[][] cromossomoC = new int[2][tamCromossomo];
		int[] cromossomoFilhoA = cromossomoA.clone();
		int[] cromossomoFilhoB = cromossomoB.clone();

		if (geradorAleatorio(100) <= pCruzamento) {

			int[] cromossomoFilhoA0 = cromossomoA.clone();
			int[] cromossomoFilhoB0 = cromossomoB.clone();

			int pontoCruzamento = geradorAleatorio(tamCromossomo);
			System.out.println("Ponto Cruzamento " + pontoCruzamento);

			for (int j = 0; j < pontoCruzamento; j++) {
				cromossomoFilhoA[j] = cromossomoFilhoB0[j];
				cromossomoFilhoB[j] = cromossomoFilhoA0[j];
			}

			novaPopulacao[i] = mutacaoSimples(cromossomoFilhoA);
			novaPopulacao[i + 1] = mutacaoSimples(cromossomoFilhoB);

		} else {
			novaPopulacao[i] = mutacaoSimples(cromossomoFilhoA);
			novaPopulacao[i + 1] = mutacaoSimples(cromossomoFilhoB);
		}

		return cromossomoC;
	}

	public static int[] mutacaoSimples(int[] cromossomo) {
		if (geradorAleatorio(100) <= 20) {
			int pontoMutacao = geradorAleatorio(tamCromossomo - 1);
			System.out.println("Mutacao " + pontoMutacao);
			cromossomo[pontoMutacao] = geradorAleatorio(nAulas);
		}
		return cromossomo;
	}

	public static int[] criarCromossomo(int tamCromossomo, int nAulas) {
		Random gerador = new Random();
		nAulas += 1;
		int[] vector = new int[tamCromossomo];

		for (int i = 0; i < tamCromossomo; i++) {
			vector[i] = gerador.nextInt(nAulas);
		}
		return vector;
	}

	public static int geradorAleatorio(int nMax) {
		Random gerador = new Random();
		return gerador.nextInt(nMax + 1);
	}
	
	// Funcao de avaliacao dos cromossomos, esta parte sera usada no servidor
	public static int funcaoAvaliacao(int[] cromossomo) {
		// Pontuacao do cromossomo sendo testado
		int pontuacao = 0;
		// Todas as variaveis criadas para ter algum tipo de avaliacao para testes
		int n;
		int nAulas = 0;
		int nAulasMax = 1;
		// Verificar aulas
		for (int i = 0; i < cromossomo.length; i++) {
			n = cromossomo[i];
			nAulas = 0;
			for (int j = 0; j < cromossomo.length; j++) {
				if (n == cromossomo[j]) {
					nAulas++;
					if (nAulas > nAulasMax) {
						pontuacao += 10;
					}
				}
			}
		}
		// Verificar indisponibilidade

		return pontuacao;
	}

}

/*
 * for (int i = 0; i < cromossomo.length; i++) { n = cromossomo[i]; nAulas = 0;
 * for (int j = 0; j < cromossomo.length; j++) { if (n == cromossomo[j]) {
 * nAulas++; } } int sobra = nAulasMax - nAulas; if(sobra > 0){ pontuacao +=
 * 30*sobra; } }
 */
