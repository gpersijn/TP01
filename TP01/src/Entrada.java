import java.util.Scanner;

public class Entrada extends Metodos{
	
	public void atribuir(double[][][] temperatura) {
		
		for(int z = 0; z < 10; z++) {
			for(int m = 0; m < 12; m++) {
				for(int n = 0; n < 31; n++) {
					temperatura[z][m][n] = 0;
				}
			}
		}
		 
	}
	
	public void lerDados(double[][][] temperatura, int ano, int mes) {
		 
		Scanner leitura = new Scanner(System.in);
		int verificacao = 0;
		
		System.out.println("\nDigite as médias de temperatura diária no mês " + mes + " de " + ano);
		
			for (int i = 0; i < dias(mes, ano) ; i++) {
				System.out.print("Dia " + (i+1) + ": ");
				try {
					temperatura[vetorAno(ano)][mes-1][i] = leitura.nextDouble();
				} catch (Exception a) {
					leitura.nextLine();
					i--;
					System.out.println("ERRO DE LEITURA, REPITA:");
				}
			}
			
		System.out.println("\nDados armazenados com sucesso!\n");
    }    
}
