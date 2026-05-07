package padroescomportamentais.chainofresponsibility;

public class MecanicoBicicletas extends SetorAtendimento {

    @Override
    protected boolean podeAtender(SolicitacaoAtendimento solicitacao) {
        return solicitacao.getTipo() == TipoSolicitacao.MANUTENCAO;
    }

    @Override
    protected String resolver(SolicitacaoAtendimento solicitacao) {
        return "Mecânico de bicicletas resolveu a solicitação " + solicitacao.getCodigo()
                + " do cliente " + solicitacao.getCliente() + ".";
    }
}