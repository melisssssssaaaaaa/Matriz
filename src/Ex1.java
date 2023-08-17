import java.util.Scanner;

public class Ex1 {

	public static void main(String[] args) {
Scanner input = new Scanner (System.in);
		
		int num = 0;
		int l;
		int c;
		int diagonalprincipal = 0;
		int diagonalsecundaria = 0;
		int soma = 0;
		float media = 0;	
		int maiornum = 0;
		int menornum = 0;
		int contadorpar = 0;
		int contadorimpar=0;
			
		
		
		do {
		System.out.println("Insira um valor inteiro impar entre 3 e 11: ");
		num= input.nextInt();
		}
		while ((num<3) || (num>11)||(num%2==0)); 
		
		int matriz[] []= new int [num][num];
		
		for (l=0;l<num;l++) {
			for(c=0;c<num;c++) {
				System.out.println("Informe os valores para cada uma das posi��es da matriz.");
				matriz[l][c]=input.nextInt();
				
				soma+=matriz[l][c];
				media=soma/matriz[l][c];
				
				if (l==c) {
					diagonalprincipal+=matriz[l][c];
				}
				
				if((l+c)==num-1) {
					diagonalsecundaria+=matriz[l][c];
				}
				
				if (matriz[l][c]%2==0) {
					contadorpar++;
				}else {
					contadorimpar++;
				}

				if (l==0) {
					maiornum=matriz[l][c];
					menornum=matriz[l][c];
				} 
			
				else {
					if (matriz[l][c] < menornum) {
						menornum = matriz[l][c];
					}
					if (matriz[l][c] > maiornum) {
						maiornum = matriz[l][c];
					}            
				}
		}
		}
		
		System.out.println("A soma dos elementos da matriz: " + soma);
		System.out.println("A media dos elementos da matriz: "+media);
		System.out.println("O maior valor da matriz: " + maiornum);	
		System.out.println("O menor valor da matriz: " + menornum);
		System.out.println("Contador de pares: " + contadorpar);
		System.out.println("Contador de �mpares: " + contadorimpar);
		System.out.println("Soma da diagonal principal: " + diagonalprincipal);
		System.out.println("A soma da diagonal secund�ria: " + diagonalsecundaria);
		
		
		for (l=0;l<num;l++) {
			for(c=0;c<num;c++) {
		System.out.print(matriz[l][c]+"|");
		}
		System.out.println();	
	}
		
		input.close();	
	}

}