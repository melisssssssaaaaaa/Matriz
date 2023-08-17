import java.io.*;
import java.util.Scanner;

public class Ex2{
    public static final int NUM_PRODUTOS = 5;
    public static final int NUM_SUPERMERCADOS = 5;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double[][] precos = new double[NUM_PRODUTOS][NUM_SUPERMERCADOS];

        for (int i = 0; i < NUM_PRODUTOS; i++) {
            System.out.println("Produto " + (i + 1) + ":");
            for (int j = 0; j < NUM_SUPERMERCADOS; j++) {
                System.out.print("Preço no Supermercado " + (j + 1) + ": ");
                precos[i][j] = scanner.nextDouble();
            }
        }

      
        System.out.println("\nPreços em cada supermercado:");
        for (int i = 0; i < NUM_PRODUTOS; i++) {
            System.out.print("Produto " + (i + 1) + ": ");
            for (int j = 0; j < NUM_SUPERMERCADOS; j++) {
                System.out.print(precos[i][j] + " ");
            }
            System.out.println();
        }

       
        double[] mediasProdutos = new double[NUM_PRODUTOS];
        for (int i = 0; i < NUM_PRODUTOS; i++) {
            double soma = 0;
            for (int j = 0; j < NUM_SUPERMERCADOS; j++) {
                soma += precos[i][j];
            }
            mediasProdutos[i] = soma / NUM_SUPERMERCADOS;
        }

       
        double[] somasSupermercados = new double[NUM_SUPERMERCADOS];
        for (int j = 0; j < NUM_SUPERMERCADOS; j++) {
            double soma = 0;
            for (int i = 0; i < NUM_PRODUTOS; i++) {
                soma += precos[i][j];
            }
            somasSupermercados[j] = soma;
        }

     
        double valorTotalMaisBarato = somasSupermercados[0];
        double valorTotalMaisCaro = somasSupermercados[0];
        int indexMaisBarato = 0;
        int indexMaisCaro = 0;

        for (int j = 1; j < NUM_SUPERMERCADOS; j++) {
            if (somasSupermercados[j] < valorTotalMaisBarato) {
                valorTotalMaisBarato = somasSupermercados[j];
                indexMaisBarato = j;
            }
            if (somasSupermercados[j] > valorTotalMaisCaro) {
                valorTotalMaisCaro = somasSupermercados[j];
                indexMaisCaro = j;
            }
        }

        System.out.println("\nValor total no supermercado mais barato (Supermercado " + (indexMaisBarato + 1) + "): " + valorTotalMaisBarato);
        System.out.println("Valor total no supermercado mais caro (Supermercado " + (indexMaisCaro + 1) + "): " + valorTotalMaisCaro);

     
        salvarDadosEmArquivo(precos);

       
        double[][] dadosCarregados = carregarDadosDeArquivo();

        scanner.close();
    }

    public static void salvarDadosEmArquivo(double[][] dados) {
        try {
            FileWriter fileWriter = new FileWriter("dados.txt");
            PrintWriter printWriter = new PrintWriter(fileWriter);

            for (int i = 0; i < NUM_PRODUTOS; i++) {
                for (int j = 0; j < NUM_SUPERMERCADOS; j++) {
                    printWriter.print(dados[i][j] + " ");
                }
                printWriter.println();
            }

            printWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static double[][] carregarDadosDeArquivo() {
        double[][] dados = new double[NUM_PRODUTOS][NUM_SUPERMERCADOS];

        try {
            File file = new File("dados.txt");
            Scanner scanner = new Scanner(file);

            for (int i = 0; i < NUM_PRODUTOS; i++) {
                for (int j = 0; j < NUM_SUPERMERCADOS; j++) {
                    dados[i][j] = scanner.nextDouble();
                }
            }

            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return dados;
    }
}
