package padroescomportamentais.chainofresponsibility;

public class GerenteLoja extends SetorAtendimento {

    @Override
    protected boolean podeAtender(SolicitacaoAtendimento solicitacao) {
        return solicitacao.getTipo() == TipoSolicitacao.TROCA;
    }

    @Override
    protected String resolver(SolicitacaoAtendimento solicitacao) {
        return "Gerente da loja resolveu a solicitação " + solicitacao.getCodigo()
                + " do cliente " + solicitacao.getCliente() + ".";
    }
}