package br.ifpr.jogo.invaders.modelo;

import br.ifpr.jogo.invaders.logica.Controlador;

public class NaveJogador extends Entidade {
    private int pontuacao;
    private int quantidadeVidas;
    private int ladoMovimentacao = 0;

    // Construtor personalizado - sobrecarregado
    public NaveJogador(int x, int y, int velocidade, int quantidadeVidas) {
        super(x, y, velocidade);
        this.pontuacao = 0;
        this.quantidadeVidas = quantidadeVidas;
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

    public int getLadoMovimentacao() {
        return ladoMovimentacao;
    }

    public void setLadoMovimentacao(int ladoMovimentacao) {
        this.ladoMovimentacao = ladoMovimentacao;
    }

    // métodos
    public void movimentar(int direcao) {
        int x = this.getX();
        x += this.getVelocidade() * direcao;

        if (x <= 0) {
            x = 0;
        } else if (x >= Controlador.getQuantidadeDeColunas() - 1) {
            x = Controlador.getQuantidadeDeColunas() - 1;
        }

        this.atirar();
        this.setX(x);
    }

    public void atirar() {
        Controlador.criaProjetil(
            this.getX(),
            this.getY(),
            1,
            true,
            true
        );
    }

    public void atualizarPosicao() {
        this.movimentar(ladoMovimentacao);
        this.ladoMovimentacao = 0;
    }

}
