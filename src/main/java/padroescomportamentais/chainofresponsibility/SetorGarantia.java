package padroescomportamentais.chainofresponsibility;

public class SetorGarantia extends SetorAtendimento {

    @Override
    protected boolean podeAtender(SolicitacaoAtendimento solicitacao) {
        return solicitacao.getTipo() == TipoSolicitacao.GARANTIA;
    }

    @Override
    protected String resolver(SolicitacaoAtendimento solicitacao) {
        return "Setor de garantia resolveu a solicitação " + solicitacao.getCodigo()
                + " do cliente " + solicitacao.getCliente() + ".";
    }
}