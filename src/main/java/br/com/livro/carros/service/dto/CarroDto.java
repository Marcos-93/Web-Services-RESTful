package br.com.livro.carros.service.dto;

import br.com.livro.carros.model.Carro;

import java.util.List;
import java.util.stream.Collectors;

public class CarroDto {
    private Long id;
    private String nome;
    private String tipo;
    private String descricao;

    public CarroDto(Carro carro) {
        this.id = carro.getId();
        this.nome = carro.getNome();
        this.tipo = carro.getTipo();
        this.descricao = carro.getDescricao();
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getTipo() {
        return tipo;
    }

    public String getDescricao() {
        return descricao;
    }
    public static List<CarroDto> converter(List<Carro> carros){
        return carros.stream().map(CarroDto::new).collect(Collectors.toList());
    }
}
