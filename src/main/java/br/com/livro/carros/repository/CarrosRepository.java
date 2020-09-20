package br.com.livro.carros.repository;

import br.com.livro.carros.domain.Carro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarrosRepository extends JpaRepository<Carro, Long> {
}
