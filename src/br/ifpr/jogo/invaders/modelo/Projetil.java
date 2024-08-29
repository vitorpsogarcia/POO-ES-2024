package br.ifpr.jogo.invaders.modelo;

public class Projetil extends Entidade {
    private boolean direcao; // true : cima / false : baixo

    public Projetil(int x, int y, int velocidade, boolean direcao) {
        this(x, y, velocidade);
        this.direcao = direcao;
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

    public void movimentarParaBaixoOuParaCima() {
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
