package padroescomportamentais.chainofresponsibility;

public class LojaBicicletasChainDemo {

    public static void main(String[] args) {
        LojaBicicletas loja = new LojaBicicletas();

        SolicitacaoAtendimento informacao = new SolicitacaoAtendimento(
                "SOL-001",
                "João",
                "Cliente deseja saber o preço de uma Mountain Bike Aro 29.",
                TipoSolicitacao.INFORMACAO
        );

        SolicitacaoAtendimento manutencao = new SolicitacaoAtendimento(
                "SOL-002",
                "Maria",
                "Cliente precisa ajustar o freio da bicicleta.",
                TipoSolicitacao.MANUTENCAO
        );

        SolicitacaoAtendimento garantia = new SolicitacaoAtendimento(
                "SOL-003",
                "Carlos",
                "Cliente solicita garantia por defeito no câmbio.",
                TipoSolicitacao.GARANTIA
        );

        SolicitacaoAtendimento troca = new SolicitacaoAtendimento(
                "SOL-004",
                "Ana",
                "Cliente solicita troca completa da bicicleta.",
                TipoSolicitacao.TROCA
        );

        System.out.println(loja.atenderSolicitacao(informacao));
        System.out.println(loja.atenderSolicitacao(manutencao));
        System.out.println(loja.atenderSolicitacao(garantia));
        System.out.println(loja.atenderSolicitacao(troca));
    }
}