package br.com.livro.carros.service.form;

import br.com.livro.carros.model.Carro;

public class CarrosForm {
    public String tipo;
    public String nome;
    public String descricao;

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Carro converter() {
        return new Carro(this.tipo,this.nome,this.descricao);
    }
}
