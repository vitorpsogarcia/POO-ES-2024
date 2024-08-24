package br.ifpr.jogo.invaders.modelo;

public class NaveJogador extends Entidade {
    private int pontuacao;
    private int quantidadeVidas;

    // Construtor padrão
    public NaveJogador() {
        // geramos os atributos randomicamente
        this(0, 0, 1);
    }

    // Construtor personalizado - sobrecarregado
    private NaveJogador(int x, int y, int velocidade) {
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
    public void movimentarParaEsquerda() {

    }

    public void movimentarParaDireita() {

    }

    public void atirar() {

    }

}
