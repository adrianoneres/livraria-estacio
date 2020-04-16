package me.adrianoneres.model;

import javax.persistence.*;

@Entity
@Table(name = "produtos")
@DiscriminatorValue("DURAVEL")
public class ProdutoDuravel extends Produto {
}
