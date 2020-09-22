package br.com.livro.carros.repository;

import br.com.livro.carros.model.Carro;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CarrosRepository extends JpaRepository<Carro, Long> {
    public List<Carro> findByTipo(String tipo);
    public Carro findByNome(String nome);
}
