package br.ifpr.jogo.invaders.modelo;

public class Projetil extends Entidade {

    public Projetil() {
        // geramos os atributos randomicamente
        this(0, 0, 1);
    }

    private Projetil(int x, int y, int velocidade) {
        super(x, y, velocidade);
    }
}
