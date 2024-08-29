package br.ifpr.jogo.invaders.principal;

import java.util.ArrayList;
import java.util.Scanner;

import br.ifpr.jogo.invaders.logica.LogicaCriacao;
import br.ifpr.jogo.invaders.modelo.Entidade;
import br.ifpr.jogo.invaders.modelo.NaveJogador;
import br.ifpr.jogo.invaders.modelo.Projetil;

public class Principal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Entidade[][] matriz = LogicaCriacao.criaMatriz();
        NaveJogador nave = LogicaCriacao.criaNaveJogador();
        matriz[nave.getY()][nave.getX()] = nave;

        int opcao = 0;
        ArrayList<Projetil> projeteis = new ArrayList<Projetil>();
        do {
            LogicaCriacao.imprimeMatriz(matriz);
            System.out.println("\n0 - sair | 1 - ESQ | 2 - DIR");
            opcao = sc.nextInt();
            sc.nextLine();

            matriz[nave.getY()][nave.getX()] = null;
            Projetil projetil = null;
            if (opcao == 1) {
                projetil = nave.movimentarParaEsquerda();
            } else if (opcao == 2) {
                projetil = nave.movimentarParaDireita();
            }
            if (projetil instanceof Projetil) {
                matriz[projetil.getY()][projetil.getX()] = projetil;
                projeteis.add(projetil);
            }
            matriz[nave.getY()][nave.getX()] = nave;
        } while (opcao != 0);

        sc.close();
    }
}
