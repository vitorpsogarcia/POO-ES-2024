package br.ifpr.jogo.invaders.modelo;

public class Inimigo extends Entidade {

    public Inimigo() {
        // geramos os atributos randomicamente
        this(0, 0, 1);
    }

    private Inimigo(int x, int y, int velocidade) {
        super(x, y, velocidade);
    }
}
