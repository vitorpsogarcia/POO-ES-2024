package br.ifpr.jogo.invaders.logica;

import br.ifpr.jogo.invaders.modelo.Entidade;
import br.ifpr.jogo.invaders.modelo.NaveJogador;
// import java.util.Random;

public class LogicaCriacao {
    private static final int VELOCIDADE_INICIAL_NAVE = 1;
    private static final int QUANTIDADE_DE_COLUNAS = 10;
    private static final int QUANTIDADE_DE_LINHAS = 10;

    public static Entidade[][] criaMatriz() {
        Entidade[][] matriz = new Entidade[QUANTIDADE_DE_LINHAS][QUANTIDADE_DE_COLUNAS];
        return matriz;
    }

    public static NaveJogador criaNaveJogador() {
        int posicaoEmY = QUANTIDADE_DE_LINHAS - 1;
        int posicaoEmX = (int) QUANTIDADE_DE_COLUNAS / 2;
        NaveJogador nave = new NaveJogador(posicaoEmX, posicaoEmY, VELOCIDADE_INICIAL_NAVE);
        return nave;
    }

    public static void imprimeMatriz(Entidade[][] matriz) {
        for (int i = 0; i < QUANTIDADE_DE_LINHAS; i++) {
            for (int j = 0; j < QUANTIDADE_DE_COLUNAS; j++) {
                if (matriz[i][j] == null) {
                    System.out.print("[" + i + " , " + j + "] ");
                } else if (matriz[i][j] instanceof NaveJogador) {
                    System.out.print("[ NAVE] ");
                }
            }
            System.err.println();
        }
    }
}
