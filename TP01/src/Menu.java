import java.util.Scanner;

public class Menu extends Entrada{

	public static void main(String[] args) {
		 
		Scanner ler = new Scanner(System.in);
		Entrada entrada = new Entrada();
		Metodos metodo = new Metodos();
		int ano, mes;
		int escolha;
		
		double[][][] temperatura = new double[10][12][31];
		entrada.atribuir(temperatura);
		 
		do {	
			System.out.print("Bem vindo à Central INMTE!\n\n1 - Entrada de temperaturas\n2 - Cálculo da Temperatura Média\n3 - Cálculo da Temperatura Mínima\n4 - Cálculo da Temperatura Máxima\n5 - Relatório\n6 - Sair\n\nEscolha: ");
			try {
				escolha = ler.nextInt();
			}  catch(Exception e) {
				System.out.println("Opção Inválida!\n");
				break; 
			}  
			
			if(escolha == 6) {
				break;
			} 
			
			do {   
		    	System.out.print("Digite o Ano: ");
		    	ano = ler.nextInt();  
		    	System.out.print("Digite o Mês: ");
		    	mes = ler.nextInt();  
		    	if(metodo.verificar(ano, mes) == false) {
		    		System.out.println("Digite uma data válida! Apenas anos de 2011 a 2020 e meses de 1 a 12");
		    	}  
			} while (metodo.verificar(ano, mes) != true);
			
			switch(escolha) {
			
				case 1:
					entrada.lerDados(temperatura, ano, mes); 
				 	break;   
				case 2: 
					System.out.println("Média: " + metodo.media(temperatura, ano, mes) + "\n");
					break;
				case 3:
					System.out.println("Temperatura mínima: " + metodo.minimo(temperatura, ano, mes) + "\n");
					break;
				case 4:     
					System.out.println("Temperatura máxima: " + metodo.maximo(temperatura, ano, mes) + "\n");
					break;
				case 5:
					if(metodo.media(temperatura, ano, mes) == 0 && metodo.minimo(temperatura, ano, mes) == 0 && metodo.maximo(temperatura, ano, mes) == 0) {
						System.out.println("\nRELATÓRIO GERAL:    !Atenção: Parece que não houve inserção de dados, se necessário volte ao ITEM 1");
					} else {
						System.out.println("\nRELATÓRIO GERAL:");
					}
					System.out.println("A) Média: " + metodo.media(temperatura, ano, mes)); 
					System.out.println("B) Temperatura máxima: " + metodo.maximo(temperatura, ano, mes)); 
					System.out.println("C) Temperatura mínima: " + metodo.minimo(temperatura, ano, mes));
					System.out.print("D) ");
					metodo.diario(temperatura, ano, mes); 
					break;
				case 6: 
					escolha = 6;
					break;
				default:
					System.out.println("Escolha inválida!");
					break; 
			}  
 
		} while(escolha != 6);
		
		System.out.println("Volte sempre!");
	}
}
