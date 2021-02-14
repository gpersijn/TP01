import java.util.Scanner;
public class Metodos {
	 
	public void diario(double[][][] temperatura, int ano, int mes) {
		Scanner coletar = new Scanner(System.in);
		String resposta;
		
		System.out.println("Gostaria de ver as médias diárias deste mês?  (Sim/Nao)");
		resposta = coletar.next();
		
		if(resposta.equalsIgnoreCase("Sim")) {
			for (int i = 0; i < dias(mes, ano) ; i++) {
			    System.out.print("Dia " + (i+1) + ": " + temperatura[vetorAno(ano)][mes-1][i]);
			    if(i != (dias(mes, ano) - 1)) {
			    	System.out.print(" - ");
			    }
			}
		}
		System.out.println("\n");
	}
	
	public double maximo(double[][][] temperatura, int ano, int mes) {
		Scanner colete = new Scanner(System.in);
		Metodos metodos = new Metodos();
		 
		double maior = temperatura[vetorAno(ano)][(mes-1)][0];
		
		for(int i = 0; i < metodos.dias(mes, ano); i ++){
			if(maior < temperatura[vetorAno(ano)][(mes-1)][i]){
                maior = temperatura[vetorAno(ano)][(mes-1)][i];
            }
	  	}
		
		return maior;
	}
	
	public double minimo(double[][][] temperatura, int ano, int mes) {
		 
		Scanner leia = new Scanner(System.in);
		Metodos metodos = new Metodos();
		
		double menor = temperatura[vetorAno(ano)][(mes-1)][0];
		
		for(int i = 0; i < metodos.dias(mes, ano); i ++){
			if(menor > temperatura[vetorAno(ano)][(mes-1)][i]){
                menor = temperatura[vetorAno(ano)][(mes-1)][i];
            }
	  	}
		return menor;
	}
	
	public double media(double[][][] temperatura, int ano, int mes) {
		
		double media;
		double soma = 0; 
		Scanner get = new Scanner(System.in);
		Metodos metodo = new Metodos();
	    
	    for(int i = 0; i < metodo.dias(mes, ano); i ++){
	    	soma += temperatura[vetorAno(ano)][(mes-1)][i];
	  	}
	    
	    media = soma/metodo.dias(mes, ano);
	    return media;
	      
	}

	public boolean verificar(int ano, int mes) {
		if(mes < 1 || mes > 12) {
			return false;
		}
		if(ano < 2011 || ano > 2020) {
			return false;
		}
		return true;
	} 
	 
	public int dias(int mes, int ano) {
		int dia = 0;
		 
		if(mes == 1 || mes == 3 || mes == 5 || mes == 7 || mes == 8 || mes == 10|| mes == 12) {
			dia = 31;
		} else if (mes == 4 || mes == 6 || mes == 9 || mes == 11) {
			dia = 30;
		} else if (mes == 2) {
			if(ano % 4 == 0 && (ano % 100 != 0 || ano % 400 == 0)) {
            	dia = 29;
			} else {
				dia = 28;
			}
		}
		
		return dia;
	}
	
	public int vetorAno(int ano) {
		int vetorAno = 10;
		
		switch(ano) {
			case 2011:
				vetorAno = 0;
				break; 
			case 2012: 
				vetorAno = 1;
				break; 
			case 2013:
				vetorAno = 2;
				break;
			case 2014:
				vetorAno = 3;
				break;
			case 2015:
				vetorAno = 4;
				break;
			case 2016:
				vetorAno = 5;
				break;
			case 2017:
				vetorAno = 6;
				break;
			case 2018:
				vetorAno = 7;
				break;
			case 2019:
				vetorAno = 8;
				break;
			case 2020:
				vetorAno = 9;
				break;
			default:
				System.out.println("ERRO");
				break;
		}
		return vetorAno;
	}
}
