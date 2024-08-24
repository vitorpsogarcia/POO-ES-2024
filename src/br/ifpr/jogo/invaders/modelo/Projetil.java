package br.ifpr.jogo.invaders.modelo;

public class Projetil extends Entidade {
    private boolean direcao; // true : cima / false : baixo

    public Projetil(int direcao) {
        // geramos os atributos randomicamente
        this(0, 0, 1);
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

    }
}
