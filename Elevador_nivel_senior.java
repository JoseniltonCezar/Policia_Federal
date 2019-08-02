/**
 *
 * @author Josenilton da Silva Cezar
 */

import java.util.Scanner;
import java.util.ArrayList;

public class Elevador_nivel_senior
{

	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);  //Criação do scanner
		
		final int limitePeso = 8; //Limite da diferença de peso entre as cabines
		int nCaixas = 0;  //Numero de caixas
		int pesoCaixaSegundoAndarr = 0; //Peso da caixa do segundo andar
		
		nCaixas = input.nextInt(); //Input do número de caixas
		
		ArrayList<Integer> pesoCaixas = new ArrayList<Integer>();  //Criação da arraylist que vai conter o peso das caixas		
		
		for (int i = 0; i < nCaixas; i++) {
			pesoCaixas.add(input.nextInt()); //Adiciona o peso das caixas no arraylist
		}
		
		pesoCaixas.sort(null); //Orgaiza o arraylist em ordem crescente
		
		int j = 0; //index da caixa que está sendo movida para o segundo andar.
		
		for (int i = 0; i < factorial(nCaixas); i++) { //For para fazer o calculo do elevador
			if (pesoCaixas.get(j) - pesoCaixaSegundoAndarr <= limitePeso) { //se o peso da caixa na posição(j) - o peso da caixa no segundo andar for menor que 8, então a caixa sobe.
				pesoCaixaSegundoAndarr = pesoCaixas.get(j); //define o peso da caixa que estará no segundo andar, sendo ele a caixa que antes estava no primeiro andar			
				if (pesoCaixaSegundoAndarr == pesoCaixas.get(pesoCaixas.size() -1)) { //if para ver se a caixa mais pesada já está no segundo andar.
					pesoCaixas.remove(pesoCaixas.size() - 1);
					j = 0;
					continue;
				}
			}
			else {
				System.out.println("N");
				input.close();
				return;
			}
			j++;
		}
		
		System.out.println("S");
		
		input.close();
	}
	//fim main
	
	public static int factorial (int number) { //calculo de fatorial. Básicamente dependendo do número de caixas os movimentos do elevador vão ser uma fatorial.
		int sum = 0;
		while (number > 0) {
			sum += number + (number - 1);
			number -= 2;
		}	
		return sum;
	}
}
//fim da class
