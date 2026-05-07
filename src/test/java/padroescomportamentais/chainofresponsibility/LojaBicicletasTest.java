package padroescomportamentais.chainofresponsibility;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LojaBicicletasTest {

    @Test
    public void deveAtenderSolicitacaoDeInformacaoNoAtendente() {
        LojaBicicletas loja = new LojaBicicletas();
        SolicitacaoAtendimento solicitacao = new SolicitacaoAtendimento(
                "SOL-001",
                "João",
                "Cliente deseja saber o preço de uma bicicleta.",
                TipoSolicitacao.INFORMACAO
        );

        assertEquals(
                "Atendente da loja resolveu a solicitação SOL-001 do cliente João.",
                loja.atenderSolicitacao(solicitacao)
        );
    }

    @Test
    public void deveEncaminharSolicitacaoDeManutencaoParaMecanico() {
        LojaBicicletas loja = new LojaBicicletas();
        SolicitacaoAtendimento solicitacao = new SolicitacaoAtendimento(
                "SOL-002",
                "Maria",
                "Cliente precisa ajustar o freio da bicicleta.",
                TipoSolicitacao.MANUTENCAO
        );

        assertEquals(
                "Mecânico de bicicletas resolveu a solicitação SOL-002 do cliente Maria.",
                loja.atenderSolicitacao(solicitacao)
        );
    }

    @Test
    public void deveEncaminharSolicitacaoDeGarantiaParaSetorGarantia() {
        LojaBicicletas loja = new LojaBicicletas();
        SolicitacaoAtendimento solicitacao = new SolicitacaoAtendimento(
                "SOL-003",
                "Carlos",
                "Cliente solicita garantia por defeito no câmbio.",
                TipoSolicitacao.GARANTIA
        );

        assertEquals(
                "Setor de garantia resolveu a solicitação SOL-003 do cliente Carlos.",
                loja.atenderSolicitacao(solicitacao)
        );
    }

    @Test
    public void deveEncaminharSolicitacaoDeTrocaParaGerente() {
        LojaBicicletas loja = new LojaBicicletas();
        SolicitacaoAtendimento solicitacao = new SolicitacaoAtendimento(
                "SOL-004",
                "Ana",
                "Cliente solicita troca completa da bicicleta.",
                TipoSolicitacao.TROCA
        );

        assertEquals(
                "Gerente da loja resolveu a solicitação SOL-004 do cliente Ana.",
                loja.atenderSolicitacao(solicitacao)
        );
    }

    @Test
    public void deveRetornarNaoAtendidaQuandoNaoHouverResponsavelNaCadeia() {
        SetorAtendimento atendente = new AtendenteLoja();
        SolicitacaoAtendimento solicitacao = new SolicitacaoAtendimento(
                "SOL-005",
                "Pedro",
                "Cliente solicita análise de garantia.",
                TipoSolicitacao.GARANTIA
        );

        assertEquals(
                "Solicitação SOL-005 não pôde ser atendida pela loja.",
                atendente.atender(solicitacao)
        );
    }

    @Test
    public void devePermitirMontarCadeiaPersonalizada() {
        SetorAtendimento atendente = new AtendenteLoja();
        SetorAtendimento gerente = new GerenteLoja();
        atendente.setProximo(gerente);

        SolicitacaoAtendimento solicitacao = new SolicitacaoAtendimento(
                "SOL-006",
                "Fernanda",
                "Cliente solicita troca completa da bicicleta.",
                TipoSolicitacao.TROCA
        );

        assertEquals(
                "Gerente da loja resolveu a solicitação SOL-006 do cliente Fernanda.",
                atendente.atender(solicitacao)
        );
    }
}