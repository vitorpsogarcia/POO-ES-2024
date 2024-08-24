package br.ifpr.jogo.invaders.principal;

import br.ifpr.jogo.invaders.logica.LogicaCriacao;
import br.ifpr.jogo.invaders.modelo.Entidade;
import br.ifpr.jogo.invaders.modelo.NaveJogador;

public class Principal {
    public static void main(String[] args) {
        Entidade[][] matriz = LogicaCriacao.criaMatriz();
        NaveJogador nave = LogicaCriacao.criaNaveJogador();

        matriz[nave.getY()][nave.getX()] = nave;

        LogicaCriacao.imprimeMatriz(matriz);
    }
}
