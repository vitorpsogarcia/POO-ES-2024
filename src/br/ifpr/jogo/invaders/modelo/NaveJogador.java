package br.ifpr.jogo.invaders.modelo;

import br.ifpr.jogo.invaders.logica.LogicaCriacao;

public class NaveJogador extends Entidade {
    private int pontuacao;
    private int quantidadeVidas;

    // Construtor personalizado - sobrecarregado
    public NaveJogador(int x, int y, int velocidade) {
        super(x, y, velocidade);
    }

    // getters e setters
    public int getPontuacao() {
        return pontuacao;
    }

    public void setPontuacao(int pontuacao) {
        this.pontuacao = pontuacao;
    }

    public int getQuantidadeVidas() {
        return quantidadeVidas;
    }

    public void setQuantidadeVidas(int quantidadeVidas) {
        this.quantidadeVidas = quantidadeVidas;
    }

    // métodos
    public Projetil movimentarParaEsquerda() {
        int x = this.getX();
        x -= this.getVelocidade();

        if (x < 0) {
            x = 0;
        } else if (x > LogicaCriacao.getQuantidadeDeColunas() - 1) {
            x = LogicaCriacao.getQuantidadeDeColunas() - 1;
        }

        Projetil projetil = this.atirar();
        this.setX(x);

        return projetil;
    }

    public Projetil movimentarParaDireita() {
        int x = this.getX();
        x += this.getVelocidade();

        if (x < 0) {
            x = 0;
        } else if (x > LogicaCriacao.getQuantidadeDeColunas() - 1) {
            x = LogicaCriacao.getQuantidadeDeColunas() - 1;
        }

        Projetil projetil = this.atirar();
        this.setX(x);

        return projetil;
    }

    public Projetil atirar() {
        Projetil projetil = new Projetil(this.getX(), this.getY() - 1, 1, true);
        return projetil;
    }

}
