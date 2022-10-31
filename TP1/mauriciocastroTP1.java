import java.util.Scanner;

public class mauriciocastroTP1 {

	private static String[] nomes;
	private static float[] nota1, nota2;

	private static final int TAMANHO = 100; 		

	private static void imprimir() {		
		for (int i = 0; i < TAMANHO; i++) {
			if(nomes[i] != null) {
				imprimir(i);
			}
		}
	}

	private static void imprimir(int indice) {
		float mediaNota = calcularAvaliacao(indice);
		
		System.out.println("<"+indice+"> " + 
							nomes[indice] + " * " + 
							mediaNota + " * " +
							obterSituacao(mediaNota)
							);
	}
	
	private static float calcularAvaliacao(int indice){
		return (nota1[indice] + nota2[indice]) / 2;

	}
	// verificar condicao !
	private static String obterSituacao(float sl){		
		if(sl < 4) {
			return "Reprovado";

		} else if (sl >= 7){
			return "Aprovado";
		}
		return "Prova final";
	}

	public static void main(String[] args) {
		nomes = new String[TAMANHO];
		nota1 = new float[TAMANHO];
		nota2 = new float[TAMANHO];
		

		// Locale.setDefault(Locale.US);
		Scanner in = new Scanner(System.in);
		
		String opcao;
		int pos = 0;

		do {
			System.out.println("[1] Cadastrar");
			System.out.println("[2] Consultar um");
			System.out.println("[3] Consultar todos");
			System.out.println("[4] Sair");
			
			System.out.print("Informe a opcao desejada: ");						
			opcao = in.next();
			
			switch (opcao) {
			case "1":
				if(pos < TAMANHO) {
					System.out.print("Informe o nome do aluno: ");	
					nomes[pos] = in.next();
		
					System.out.print("Informe a sua nota AV1: ");	
					nota1[pos] = in.nextFloat();
					
					System.out.print("Informe a sua nota AV2: ");	
					nota2[pos] = in.nextFloat();
					
					imprimir(pos);

					pos++;
				} else {
					System.out.println("Impossivel realizar um novo cadastramento!");
				}
				break;

			case "2":
				System.out.print("Informe o indice do Aluno para ser impresso: ");						
				int id = in.nextInt();

				if(id >= 0 && id < pos) {
					imprimir(id);
				} else {
					System.out.println("O indice ["+id+"] e invalido!!!");
				}
				break;

			case "3":
				imprimir();
				break;

			case "4":
				System.out.println("Saida");
				break;

			default:
				System.out.println("A opcao ["+opcao+"] invalida");
				break;
			}
		} while (!"4".equalsIgnoreCase(opcao));
				
		System.out.println("Processamento finalizado!!!");
		
		in.close();
	}
}