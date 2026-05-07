package padroescomportamentais.chainofresponsibility;

public class LojaBicicletas {

    private SetorAtendimento cadeiaAtendimento;

    public LojaBicicletas() {
        this.cadeiaAtendimento = criarCadeiaAtendimento();
    }

    private SetorAtendimento criarCadeiaAtendimento() {
        SetorAtendimento atendente = new AtendenteLoja();
        SetorAtendimento mecanico = new MecanicoBicicletas();
        SetorAtendimento garantia = new SetorGarantia();
        SetorAtendimento gerente = new GerenteLoja();

        atendente.setProximo(mecanico);
        mecanico.setProximo(garantia);
        garantia.setProximo(gerente);

        return atendente;
    }

    public String atenderSolicitacao(SolicitacaoAtendimento solicitacao) {
        return cadeiaAtendimento.atender(solicitacao);
    }

    public SetorAtendimento getCadeiaAtendimento() {
        return cadeiaAtendimento;
    }
}