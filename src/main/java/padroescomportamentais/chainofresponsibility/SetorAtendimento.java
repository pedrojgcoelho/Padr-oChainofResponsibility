package padroescomportamentais.chainofresponsibility;

public abstract class SetorAtendimento {

    protected SetorAtendimento proximo;

    public void setProximo(SetorAtendimento proximo) {
        this.proximo = proximo;
    }

    public String atender(SolicitacaoAtendimento solicitacao) {
        if (podeAtender(solicitacao)) {
            return resolver(solicitacao);
        }

        if (proximo != null) {
            return proximo.atender(solicitacao);
        }

        return "Solicitação " + solicitacao.getCodigo() + " não pôde ser atendida pela loja.";
    }

    protected abstract boolean podeAtender(SolicitacaoAtendimento solicitacao);

    protected abstract String resolver(SolicitacaoAtendimento solicitacao);
}