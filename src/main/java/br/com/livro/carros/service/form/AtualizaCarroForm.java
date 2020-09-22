package br.com.livro.carros.service.form;

import br.com.livro.carros.model.Carro;
import br.com.livro.carros.repository.CarrosRepository;

public class AtualizaCarroForm {
    public String nome;
    public String tipo;
    public  String descricao;
    public Carro atualiza(Long id, CarrosRepository carroRepository) {
        Carro carro = carroRepository.getOne(id);
        carro.setNome(this.nome);
        carro.setTipo(this.tipo);
        carro.setDescricao(this.descricao);
        return carro;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
