package br.ifpr.jogo.invaders.modelo;

public class Entidade {
    private int x;
    private int y;
    private int velocidade;

    // Construtor padrão inexistente

    public Entidade(int x, int y, int velocidade) {
        this.x = x;
        this.y = y;
        this.velocidade = velocidade;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getVelocidade() {
        return velocidade;
    }

    public void setVelocidade(int velocidade) {
        this.velocidade = velocidade;
    }
}
