import java.io.*;
import java.util.Scanner;

public class Ex4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o número de atletas: ");
        int numAtletas = scanner.nextInt();
        scanner.nextLine(); 
        double[][] saltos = new double[numAtletas][5];

        for (int i = 0; i < numAtletas; i++) {
            System.out.println("Atleta " + (i + 1) + ":");
            for (int j = 0; j < 5; j++) {
                System.out.print("Digite o salto " + (j + 1) + ": ");
                saltos[i][j] = scanner.nextDouble();
            }
        }

   
        double[] medias = new double[numAtletas];
        for (int i = 0; i < numAtletas; i++) {
            double soma = 0;
            double menorSalto = saltos[i][0];

            for (int j = 0; j < 5; j++) {
                soma += saltos[i][j];
                if (saltos[i][j] < menorSalto) {
                    menorSalto = saltos[i][j];
                }
            }

            medias[i] = (soma - menorSalto) / 4;
        }

        
        System.out.println("\nResultados dos saltos:");
        for (int i = 0; i < numAtletas; i++) {
            System.out.print("Atleta " + (i + 1) + " - Saltos: ");
            for (int j = 0; j < 5; j++) {
                System.out.print(saltos[i][j] + " ");
            }
            System.out.println("- Média: " + medias[i]);
        }

        
        double maiorMedia = medias[0];
        double menorMedia = medias[0];

        for (int i = 1; i < numAtletas; i++) {
            if (medias[i] > maiorMedia) {
                maiorMedia = medias[i];
            }
            if (medias[i] < menorMedia) {
                menorMedia = medias[i];
            }
        }

        System.out.println("\nMédia dos saltos do campeão: " + maiorMedia);
        System.out.println("Média dos saltos do último lugar: " + menorMedia);

   
        salvarDadosEmArquivo(saltos, medias);

        carregarDadosDeArquivo();

        scanner.close();
    }

    public static void salvarDadosEmArquivo(double[][] saltos, double[] medias) {
        try {
            FileWriter fileWriter = new FileWriter("dados_saltos.txt");
            PrintWriter printWriter = new PrintWriter(fileWriter);

            for (int i = 0; i < saltos.length; i++) {
                for (int j = 0; j < 5; j++) {
                    printWriter.print(saltos[i][j] + " ");
                }
                printWriter.print("- Média: " + medias[i]);
                printWriter.println();
            }

            printWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void carregarDadosDeArquivo() {
        try {
            File file = new File("dados_saltos.txt");
            Scanner scanner = new Scanner(file);

            System.out.println("\nDados carregados do arquivo:");
            while (scanner.hasNextLine()) {
                String linha = scanner.nextLine();
                String[] partes = linha.split(" ");
                System.out.print("Saltos: ");
                for (int i = 0; i < 5; i++) {
                    System.out.print(partes[i] + " ");
                }
                System.out.println("- " + partes[6]);
            }

            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
