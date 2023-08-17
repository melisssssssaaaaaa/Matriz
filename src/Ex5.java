import java.io.*;
import java.util.*;

public class Ex5 {
    public static final int NUM_CARTELAS = 10;
    public static final int NUM_NUMEROS = 6;
    public static final int NUM_MAXIMO = 60;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite quantas cartelas deseja preencher: ");
        int numCartelas = scanner.nextInt();
        scanner.nextLine(); 

        int[][] cartelas = new int[numCartelas][NUM_NUMEROS];

       
        Random random = new Random();
        for (int i = 0; i < numCartelas; i++) {
            for (int j = 0; j < NUM_NUMEROS; j++) {
                cartelas[i][j] = random.nextInt(NUM_MAXIMO) + 1;
            }
            Arrays.sort(cartelas[i]); 
        }

     
        System.out.println("\nCartelas e acertos:");
        for (int i = 0; i < numCartelas; i++) {
            System.out.print("Cartela " + (i + 1) + ": ");
            int[] numerosCartela = new int[NUM_NUMEROS];
            for (int j = 0; j < NUM_NUMEROS; j++) {
                numerosCartela[j] = cartelas[i][j];
            }
            int acertos = analisarAcertos(numerosCartela);
            System.out.println(Arrays.toString(numerosCartela) + " - Acertos: " + acertos);
        }

        
        salvarDadosEmArquivo(cartelas);

     
        carregarDadosDeArquivo();

        scanner.close();
    }

    public static int analisarAcertos(int[] numerosCartela) {
        int[] numerosSorteados = new int[NUM_NUMEROS];
        Random random = new Random();

       
        for (int i = 0; i < NUM_NUMEROS; i++) {
            numerosSorteados[i] = random.nextInt(NUM_MAXIMO) + 1;
        }
        Arrays.sort(numerosSorteados);

    
        int acertos = 0;
        for (int i = 0; i < NUM_NUMEROS; i++) {
            if (Arrays.binarySearch(numerosSorteados, numerosCartela[i]) >= 0) {
                acertos++;
            }
        }

        return acertos;
    }

    public static void salvarDadosEmArquivo(int[][] cartelas) {
        try {
            FileWriter fileWriter = new FileWriter("dados_loteria.txt");
            PrintWriter printWriter = new PrintWriter(fileWriter);

            for (int i = 0; i < cartelas.length; i++) {
                for (int j = 0; j < NUM_NUMEROS; j++) {
                    printWriter.print(cartelas[i][j] + " ");
                }
                printWriter.println();
            }

            printWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void carregarDadosDeArquivo() {
        try {
            File file = new File("dados_loteria.txt");
            Scanner scanner = new Scanner(file);

            System.out.println("\nDados carregados do arquivo:");
            int cartelaNum = 1;
            while (scanner.hasNextLine()) {
                String linha = scanner.nextLine();
                String[] partes = linha.split(" ");
                System.out.println("Cartela " + cartelaNum + ": " + Arrays.toString(partes));
                cartelaNum++;
            }

            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
