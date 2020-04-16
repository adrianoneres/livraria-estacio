package me.adrianoneres.model;

import javax.persistence.*;

@Entity
@Table(name = "produtos")
@DiscriminatorValue("LIVRO")
public class Livro extends Produto {

    @ManyToOne
    @JoinColumn(name = "id_autor", foreignKey = @ForeignKey(name = "livro_autor"))
    private Autor autor;

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }
}
