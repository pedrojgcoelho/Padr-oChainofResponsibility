package padroescomportamentais.chainofresponsibility;

public class AtendenteLoja extends SetorAtendimento {

    @Override
    protected boolean podeAtender(SolicitacaoAtendimento solicitacao) {
        return solicitacao.getTipo() == TipoSolicitacao.INFORMACAO;
    }

    @Override
    protected String resolver(SolicitacaoAtendimento solicitacao) {
        return "Atendente da loja resolveu a solicitação " + solicitacao.getCodigo()
                + " do cliente " + solicitacao.getCliente() + ".";
    }
}