package br.ifpr.jogo.invaders.modelo;

public class Projetil extends Entidade {
    private boolean direcao; // true : cima / false : baixo

    public Projetil(int x, int y, int velocidade, boolean direcao) {
        super(x, y, velocidade);
        this.direcao = direcao;
    }

    public boolean isDirecao() {
        return direcao;
    }

    public void setDirecao(boolean direcao) {
        this.direcao = direcao;
    }

    public void movimentarParaBaixoOuParaCima() {

    }
}
