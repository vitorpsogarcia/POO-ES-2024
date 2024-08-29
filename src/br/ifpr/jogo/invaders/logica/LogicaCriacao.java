package br.ifpr.jogo.invaders.logica;

import java.util.ArrayList;

import br.ifpr.jogo.invaders.modelo.Entidade;
import br.ifpr.jogo.invaders.modelo.NaveJogador;
// import java.util.Random;
import br.ifpr.jogo.invaders.modelo.Projetil;

public class LogicaCriacao {
    private static final int VELOCIDADE_INICIAL_NAVE = 1;
    private static final int QUANTIDADE_DE_COLUNAS = 10;
    private static final int QUANTIDADE_DE_LINHAS = 10;

    public static int getVelocidadeInicialNave() {
        return VELOCIDADE_INICIAL_NAVE;
    }

    public static int getQuantidadeDeColunas() {
        return QUANTIDADE_DE_COLUNAS;
    }

    public static int getQuantidadeDeLinhas() {
        return QUANTIDADE_DE_LINHAS;
    }

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
                    System.out.print("[" + i + ", " + j + "] ");
                } else if (matriz[i][j] instanceof NaveJogador) {
                    System.out.print("[NAVE] ");
                } else if (matriz[i][j] instanceof Projetil) {
                    System.out.print("[PEW ] ");
                }
            }
            System.err.println();
        }
    }

    public static void atualizaDisparos(ArrayList<Projetil> projetil) {
        for (Projetil p : projetil) {
            p.movimentarParaBaixoOuParaCima();
        }
    }
}
