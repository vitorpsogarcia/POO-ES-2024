package br.ifpr.jogo.invaders.modelo;

public class Nave extends Entidade {
    public Nave() {
        // geramos os atributos randomicamente
        this(0, 0, 1);
    }

    private Nave(int x, int y, int velocidade) {
        super(x, y, velocidade);
    }
}
