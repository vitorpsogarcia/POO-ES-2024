package br.ifpr.jogo.invaders.principal;

import java.util.Scanner;

import br.ifpr.jogo.invaders.logica.Controlador;
import br.ifpr.jogo.invaders.modelo.NaveJogador;

public class Principal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        NaveJogador jogador = Controlador.getNaveJogador();
        int opcao = 0;
        do{
            Controlador.imprimeMatriz();
            System.out.println("Vidas: " + jogador.getQuantidadeVidas() + "  | Pontos: " + jogador.getPontuacao());
            System.out.print("1 - esquerda | 2 - direita | 0 - Sair\nOpção: ");
            try {
                opcao = sc.nextInt();
                if (!(opcao >= 0 && opcao <= 2)) {
                    throw new Exception();
                }
            } catch (Exception e) {
                sc.nextLine();
                continue;
            }
            switch (opcao) {
                case 1:
                    jogador.setLadoMovimentacao(-1);
                    break;
                case 2:
                    jogador.setLadoMovimentacao(1);
                    break;
                default:
                    break;
            }

            Controlador.atualizarPosicao();
        } while (opcao != 0);
        sc.close();
    }
}
