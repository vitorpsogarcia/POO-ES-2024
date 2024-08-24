package br.ifpr.jogo.invaders.modelo;

public class Inimigo extends Entidade {
    private int pontos;

    public Inimigo() {
        // geramos os atributos randomicamente
        this(0, 0, 1);
    }

    private Inimigo(int x, int y, int velocidade) {
        super(x, y, velocidade);
    }

    public int getPontos() {
        return pontos;
    }

    public void setPontos(int pontos) {
        this.pontos = pontos;
    }

    public void movimentarParaBaixo() {
        // TODO: pensar como fazer a lógica
    }
}
