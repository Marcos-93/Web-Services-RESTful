package br.com.livro.carros.repository;

import br.com.livro.carros.model.Carro;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CarrosRepository extends JpaRepository<Carro, Long> {
    public List<Carro> findByTipo(String tipo);
    public Optional<Carro> findByNome(String nome);
}
