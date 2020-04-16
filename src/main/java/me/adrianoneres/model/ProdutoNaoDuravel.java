package me.adrianoneres.model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
@Table(name = "produtos")
@DiscriminatorValue("NAO_DURAVEL")
public class ProdutoNaoDuravel extends Produto {

    @Column(name = "data_vencimento")
    private Date dataVencimento;

    public Date getDataVencimento() {
        return dataVencimento;
    }

    public String getDataVencimentoFormatada(String pattern) {
        return new SimpleDateFormat(pattern).format(dataVencimento);
    }

    public void setDataVencimento(Date dataVencimento) {
        this.dataVencimento = dataVencimento;
    }
}
