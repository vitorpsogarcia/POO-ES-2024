package br.ifpr.jogo.invaders.logica;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import br.ifpr.jogo.invaders.modelo.Entidade;
import br.ifpr.jogo.invaders.modelo.Inimigo;
import br.ifpr.jogo.invaders.modelo.NaveJogador;
import br.ifpr.jogo.invaders.modelo.Projetil;

public class Controlador {
    private static final int VELOCIDADE_INICIAL_NAVE = 1;
    private static final int QUANTIDADE_DE_COLUNAS = 10;
    private static final int QUANTIDADE_DE_LINHAS = 10;
    private static final List<Projetil> disparos = new ArrayList<>();
    private static final List<Inimigo> inimigos = new ArrayList<>();
    private static final Entidade[][] matriz = new Entidade[QUANTIDADE_DE_COLUNAS][QUANTIDADE_DE_LINHAS];
    private static final NaveJogador jogador = criaNaveJogador();

    public static int getVelocidadeInicialNave() {
        return VELOCIDADE_INICIAL_NAVE;
    }

    public static int getQuantidadeDeColunas() {
        return QUANTIDADE_DE_COLUNAS;
    }

    public static int getQuantidadeDeLinhas() {
        return QUANTIDADE_DE_LINHAS;
    }

    public static Entidade[][] getMatriz() {
        return matriz;
    }

    public static NaveJogador getNaveJogador() {
        return jogador;
    }

    private static NaveJogador criaNaveJogador() {
        int posicaoEmY = QUANTIDADE_DE_LINHAS - 1;
        int posicaoEmX = (int) QUANTIDADE_DE_COLUNAS / 2;
        NaveJogador nave = new NaveJogador(posicaoEmX, posicaoEmY, VELOCIDADE_INICIAL_NAVE, 2);

        matriz[posicaoEmY][posicaoEmX] = nave;
        return nave;
    }

    public static Projetil criaProjetil(int x, int y, int velocidade, boolean direcao, boolean aliado) {
        Projetil projetil = new Projetil(x, y, velocidade, direcao, aliado);
        disparos.add(projetil);
        matriz[y][x] = projetil;
        return projetil;
    }

    public static Inimigo criaInimigo() {
        Random random = new Random();
        int x = 0;
        while (true) {
            x = random.nextInt(QUANTIDADE_DE_COLUNAS - 1);

            if (matriz[0][x] == null) {
                break;
            }
        }

        Inimigo inimigo = new Inimigo(x, 0, VELOCIDADE_INICIAL_NAVE, 10, 1);
        inimigos.add(inimigo);
        matriz[inimigo.getY()][inimigo.getX()] = inimigo;
        return inimigo;
    }

    public static void imprimeMatriz() {
        StringBuilder sb = new StringBuilder();
        if (jogador.getQuantidadeVidas() == 0) {
            System.out.println("Fim de jogo!");
            System.exit(0);
        }
        for (int i = 0; i < QUANTIDADE_DE_LINHAS; i++) {
            for (int j = 0; j < QUANTIDADE_DE_COLUNAS; j++) {
                if (matriz[i][j] == null) {
                    sb.append("|      ");
                } else if (matriz[i][j] instanceof NaveJogador) {
                    sb.append("| NAVE ");
                } else if (matriz[i][j] instanceof Projetil) {
                    sb.append("|   ^  ");
                } else if (matriz[i][j] instanceof Inimigo) {
                    sb.append("|   ¤  ");
                }

                if (j == QUANTIDADE_DE_COLUNAS - 1) {
                    sb.append("|");
                }
            }
            sb.append("\n");
        }

        System.out.println(sb.toString());
    }

    public static void atualizarPosicao(){
        matriz[jogador.getY()][jogador.getX()] = null;
        jogador.atualizarPosicao();
        matriz[jogador.getY()][jogador.getX()] = jogador;

        for (int i = 0; i < disparos.size(); i++) {
            Projetil disparo = (Projetil) disparos.get(i);
            if(!(matriz[disparo.getY()][disparo.getX()] instanceof NaveJogador)){
                matriz[disparo.getY()][disparo.getX()] = null;
            }
            disparo.atualizarPosicao();
            int y = disparo.getY();
            int x = disparo.getX();
            if (y < 0 || y > QUANTIDADE_DE_LINHAS - 1 || x < 0 || x > QUANTIDADE_DE_COLUNAS - 1) {
                disparos.remove(i);
                i--;
            } else if (matriz[y][x] instanceof Inimigo) {
                disparos.remove(i);
                i--;
                inimigos.remove(matriz[y][x]);
                jogador.setPontuacao(jogador.getPontuacao() + ((Inimigo)matriz[y][x]).getPontos());
                matriz[y][x] = null;
            }else {
                matriz[disparo.getY()][disparo.getX()] = disparo;
            }
        }

        for (int i = 0; i < inimigos.size(); i++) {
            Inimigo inimigo = (Inimigo) inimigos.get(i);
            if (inimigo.vaiMover()) {
                matriz[inimigo.getY()][inimigo.getX()] = null;
            }
            inimigo.atualizarPosicao();
            int x = inimigo.getX();
            int y = inimigo.getY();
            if (matriz[y][x] instanceof Projetil && ((Projetil)matriz[y][x]).isDoJogador()) {
                disparos.remove(matriz[y][x]);
                inimigos.remove(i);
                jogador.setPontuacao(jogador.getPontuacao() + inimigo.getPontos());
                i--;
                matriz[y][x] = null;
            } else if (y == QUANTIDADE_DE_LINHAS - 1) {
                matriz[y][x] = null;
                inimigos.remove(i);
                jogador.setQuantidadeVidas(jogador.getQuantidadeVidas() - 1);
                i--;
            } else {
                matriz[inimigo.getY()][inimigo.getX()] = inimigo;
            }
        }

        if (inimigos.size() <= 5) {
            criaInimigo();
        }
    }
}
