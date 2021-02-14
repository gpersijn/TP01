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
			System.out.print("Bem vindo � Central INMTE!\n\n1 - Entrada de temperaturas\n2 - C�lculo da Temperatura M�dia\n3 - C�lculo da Temperatura M�nima\n4 - C�lculo da Temperatura M�xima\n5 - Relat�rio\n6 - Sair\n\nEscolha: ");
			try {
				escolha = ler.nextInt();
			}  catch(Exception e) {
				System.out.println("Op��o Inv�lida!\n");
				break; 
			}  
			
			if(escolha == 6) {
				break;
			} 
			
			do {   
		    	System.out.print("Digite o Ano: ");
		    	ano = ler.nextInt();  
		    	System.out.print("Digite o M�s: ");
		    	mes = ler.nextInt();  
		    	if(metodo.verificar(ano, mes) == false) {
		    		System.out.println("Digite uma data v�lida! Apenas anos de 2011 a 2020 e meses de 1 a 12");
		    	}  
			} while (metodo.verificar(ano, mes) != true);
			
			switch(escolha) {
			
				case 1:
					entrada.lerDados(temperatura, ano, mes); 
				 	break;   
				case 2: 
					System.out.println("M�dia: " + metodo.media(temperatura, ano, mes) + "\n");
					break;
				case 3:
					System.out.println("Temperatura m�nima: " + metodo.minimo(temperatura, ano, mes) + "\n");
					break;
				case 4:     
					System.out.println("Temperatura m�xima: " + metodo.maximo(temperatura, ano, mes) + "\n");
					break;
				case 5:
					if(metodo.media(temperatura, ano, mes) == 0 && metodo.minimo(temperatura, ano, mes) == 0 && metodo.maximo(temperatura, ano, mes) == 0) {
						System.out.println("\nRELAT�RIO GERAL:    !Aten��o: Parece que n�o houve inser��o de dados, se necess�rio volte ao ITEM 1");
					} else {
						System.out.println("\nRELAT�RIO GERAL:");
					}
					System.out.println("A) M�dia: " + metodo.media(temperatura, ano, mes)); 
					System.out.println("B) Temperatura m�xima: " + metodo.maximo(temperatura, ano, mes)); 
					System.out.println("C) Temperatura m�nima: " + metodo.minimo(temperatura, ano, mes));
					System.out.print("D) ");
					metodo.diario(temperatura, ano, mes); 
					break;
				case 6: 
					escolha = 6;
					break;
				default:
					System.out.println("Escolha inv�lida!");
					break; 
			}  
 
		} while(escolha != 6);
		
		System.out.println("Volte sempre!");
	}
}
