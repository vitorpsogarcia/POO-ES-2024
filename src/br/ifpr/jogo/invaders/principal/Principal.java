package br.ifpr.jogo.invaders.principal;

import java.util.Scanner;
import br.ifpr.jogo.invaders.logica.LogicaCriacao;
import br.ifpr.jogo.invaders.modelo.Entidade;
import br.ifpr.jogo.invaders.modelo.NaveJogador;

public class Principal {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        Entidade[][] matriz = LogicaCriacao.criaMatriz();
        NaveJogador nave = LogicaCriacao.criaNaveJogador();

        matriz[nave.getY()][nave.getX()] = nave;
        int opcao = 0;
        do {
            LogicaCriacao.imprimeMatriz(matriz);
            System.out.println("Digite 0 - Sair | 1 - Esq | 2 - Dir");
            opcao = teclado.nextInt();
            matriz[nave.getY()][nave.getX()] = null;
            if (opcao == 1) {
                nave.movimentarParaEsquerda();
            } else if (opcao == 2) {
                nave.movimentarParaDireita();
            }
            //logica para atirar
            
            matriz[nave.getY()][nave.getX()] = nave;
        } while (opcao != 0);

    }
}
