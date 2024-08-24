package br.ifpr.turma;

import java.util.Scanner;

public class App {
    static Turma[] turmas = new Turma[10];
    static int quantidadeTurma = 0;
    static int quantidadeEstudantes = 0;
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws Exception {
        int opcao = 0;

        do {
            exibirMenu();
            opcao = scanner.nextInt();
            roteador(opcao);
        } while (opcao != 0);
    }

    public static void roteador(int opcao) {
        switch (opcao) {
            case 1:
                cadastrarTurma();
                break;
            case 2:
                // fazer cadastro de campus
                break;
            case 3:
                // fazer cadastro de curso
                break;
            case 4:
                // fazer cadastro de estudante
                break;
            case 5:
                // fazer cadastro de matricula
                break;
            case 6:
                gerarRelatorio();
                break;
            default:
                if (opcao != 0) {
                    System.out.println("Opção inválida");
                }
                break;
        }
    }

    public static void gerarRelatorio() {
        for (int i = 0; i < quantidadeTurma; i++) {
            System.out.println("Nome turma: " + turmas[i].nome);
            System.out.println("Numero minimo: " + turmas[i].numeroMinimo);
            System.out.println("Ano de ingresso: " + turmas[i].anoIngresso);
        }
    }

    public static void cadastrarTurma() {
        scanner.nextLine();// apaga o enter (\n)
        Turma turma = new Turma();
        System.out.println("Digite o nome da turma: ");
        turma.nome = scanner.nextLine();
        System.out.println("Digite a numero minimo de alunos: ");
        turma.numeroMinimo = scanner.nextInt();
        System.out.println("Digite o ano de ingresso: ");
        turma.anoIngresso = scanner.nextInt();
        turmas[quantidadeTurma] = turma;
        quantidadeTurma++;
    }

    public static void exibirMenu() {
        System.out.println("============================");
        System.out.println("[1] Cadastro de turma: ");
        System.out.println("[2] Cadastro de campus: ");
        System.out.println("[3] Cadastro de curso: ");
        System.out.println("[4] Cadastro de estudante: ");
        System.out.println("[5] Cadastro de matricula: ");
        System.out.println("[6] Exibir tudo: ");
        System.out.println("[0] Sair: ");
        System.out.println("============================");
    }
}
