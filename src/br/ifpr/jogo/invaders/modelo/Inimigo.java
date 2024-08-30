package br.ifpr.jogo.invaders.modelo;

public class Inimigo extends Entidade {
    private int pontos;
    private int contadorAndar = 0;
    private int andarQuando;

    public Inimigo(int posX, int posY, int velocidade, int pontos, int andarQuando) {
        this(posX, posY, velocidade);
        this.pontos = pontos;
        this.andarQuando = andarQuando;
    }

    private Inimigo(int x, int y, int velocidade) {
        super(x, y, velocidade);
    }

    public int getPontos() {
        return pontos;
    }

    public void atualizarPosicao() {
        if (contadorAndar == andarQuando) {
            this.setY(this.getY() + 1);
            contadorAndar = 0;
        } else {
            contadorAndar++;
        }
    }

    public boolean vaiMover() {
        return contadorAndar == andarQuando;
    }
}
