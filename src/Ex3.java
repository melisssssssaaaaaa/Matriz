import java.io.*;
import java.util.Scanner;

public class Ex3{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
 
        System.out.print("Digite o número de alunos: ");
        int numAlunos = scanner.nextInt();
        scanner.nextLine(); 

        String[] nomes = new String[numAlunos];
        double[][] notas = new double[numAlunos][2];

        for (int i = 0; i < numAlunos; i++) {
            System.out.print("Digite o nome do aluno " + (i + 1) + ": ");
            nomes[i] = scanner.nextLine();

            System.out.print("Digite a nota da prova 1: ");
            notas[i][0] = scanner.nextDouble();

            System.out.print("Digite a nota da prova 2: ");
            notas[i][1] = scanner.nextDouble();

            scanner.nextLine();
        }

       
        double[] medias = new double[numAlunos];
        double maiorNota = -1;
        double menorNota = 101;
        String nomeMaiorNota = "";
        String nomeMenorNota = "";
        double maiorMedia = -1;
        double menorMedia = 101;
        String nomeMaiorMedia = "";
        String nomeMenorMedia = "";
        double somaMedias = 0;

        for (int i = 0; i < numAlunos; i++) {
            medias[i] = (notas[i][0] + notas[i][1]) / 2;
            somaMedias += medias[i];

            if (notas[i][0] > maiorNota) {
                maiorNota = notas[i][0];
                nomeMaiorNota = nomes[i];
            }
            if (notas[i][0] < menorNota) {
                menorNota = notas[i][0];
                nomeMenorNota = nomes[i];
            }

            if (notas[i][1] > maiorNota) {
                maiorNota = notas[i][1];
                nomeMaiorNota = nomes[i];
            }
            if (notas[i][1] < menorNota) {
                menorNota = notas[i][1];
                nomeMenorNota = nomes[i];
            }

            if (medias[i] > maiorMedia) {
                maiorMedia = medias[i];
                nomeMaiorMedia = nomes[i];
            }
            if (medias[i] < menorMedia) {
                menorMedia = medias[i];
                nomeMenorMedia = nomes[i];
            }
        }

        double mediaTurma = somaMedias / numAlunos;

       
        System.out.println("\nAlunos acima da média da turma:");
        for (int i = 0; i < numAlunos; i++) {
            if (medias[i] > mediaTurma) {
                System.out.println(nomes[i]);
            }
        }

        System.out.println("\nAlunos abaixo da média da turma:");
        for (int i = 0; i < numAlunos; i++) {
            if (medias[i] < mediaTurma) {
                System.out.println(nomes[i]);
            }
        }

        System.out.println("\nResultados:");
        for (int i = 0; i < numAlunos; i++) {
            System.out.println("Aluno: " + nomes[i] + " - Notas: " + notas[i][0] + ", " + notas[i][1] + " - Média: " + medias[i]);
        }

        System.out.println("Maior nota: " + nomeMaiorNota + " - " + maiorNota);
        System.out.println("Menor nota: " + nomeMenorNota + " - " + menorNota);
        System.out.println("Maior média: " + nomeMaiorMedia + " - " + maiorMedia);
        System.out.println("Menor média: " + nomeMenorMedia + " - " + menorMedia);
        System.out.println("Média geral da turma: " + mediaTurma);

        
        salvarDadosEmArquivo(nomes, notas);

        carregarDadosDeArquivo();

        scanner.close();
    }

    public static void salvarDadosEmArquivo(String[] nomes, double[][] notas) {
        try {
            FileWriter fileWriter = new FileWriter("dados_alunos.txt");
            PrintWriter printWriter = new PrintWriter(fileWriter);

            for (int i = 0; i < nomes.length; i++) {
                printWriter.print(nomes[i] + " " + notas[i][0] + " " + notas[i][1] + "\n");
            }

            printWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void carregarDadosDeArquivo() {
        try {
            File file = new File("dados_alunos.txt");
            Scanner scanner = new Scanner(file);

            System.out.println("\nDados carregados do arquivo:");
            while (scanner.hasNextLine()) {
                String linha = scanner.nextLine();
                String[] partes = linha.split(" ");
                String nome = partes[0];
                double nota1 = Double.parseDouble(partes[1]);
                double nota2 = Double.parseDouble(partes[2]);
                System.out.println("Aluno: " + nome + " - Notas: " + nota1 + ", " + nota2);
            }

            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
