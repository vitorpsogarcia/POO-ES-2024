package br.ifpr.jogo.invaders.modelo;

public class Projetil extends Entidade {
    private boolean direcao; // true : cima / false : baixo
    private boolean doJogador;

    public Projetil(int x, int y, int velocidade, boolean direcao, boolean aliado) {
        this(x, y, velocidade);
        this.direcao = direcao;
        this.doJogador = aliado;
    }

    private Projetil(int x, int y, int velocidade) {
        super(x, y, velocidade);
    }

    public boolean isDirecao() {
        return direcao;
    }

    public void setDirecao(boolean direcao) {
        this.direcao = direcao;
    }

    public boolean isDoJogador() {
        return doJogador;
    }

    public void atualizarPosicao() {
        if (direcao) {
            this.setY(
                this.getY() - this.getVelocidade()
            );
        } else {
            this.setY(
                this.getY() + this.getVelocidade()
            );
        }
    }
}
