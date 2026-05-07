package padroescomportamentais.chainofresponsibility;

public class SolicitacaoAtendimento {

    private String codigo;
    private String cliente;
    private String descricao;
    private TipoSolicitacao tipo;

    public SolicitacaoAtendimento(String codigo, String cliente, String descricao, TipoSolicitacao tipo) {
        this.codigo = codigo;
        this.cliente = cliente;
        this.descricao = descricao;
        this.tipo = tipo;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getCliente() {
        return cliente;
    }

    public String getDescricao() {
        return descricao;
    }

    public TipoSolicitacao getTipo() {
        return tipo;
    }
}