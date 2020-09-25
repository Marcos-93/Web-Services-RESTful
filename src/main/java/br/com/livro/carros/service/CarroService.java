package br.com.livro.carros.service;

import br.com.livro.carros.service.dto.CarroDto;
import br.com.livro.carros.model.Carro;
import br.com.livro.carros.repository.CarrosRepository;
import br.com.livro.carros.service.form.AtualizaCarroForm;
import br.com.livro.carros.service.form.CarrosForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@Service
public class CarroService {
    @Autowired
    private CarrosRepository carroRepository;

/*    @Autowired
    public CarroService(@Qualifier(value = "mysql") CarrosDao carroRepository) {
        this.carroRepository = carroRepository;
    }
*/
    public List<CarroDto> getCarros(){
        List<Carro> carros = carroRepository.findAll();
        return CarroDto.converter(carros);

    }
    public ResponseEntity<CarroDto> getCarro(Long id){
        Optional<Carro> optional = carroRepository.findById(id);
        if(optional.isPresent()){
            return ResponseEntity.ok(new CarroDto(optional.get()));
        }
        return ResponseEntity.notFound().build();
    }
    public List<CarroDto> getByTipo(String tipo){
        List<Carro> carros = carroRepository.findByTipo(tipo);
        return CarroDto.converter(carros);
    }
    public ResponseEntity<CarroDto> getByName(String nome){
        Optional<Carro> optional = carroRepository.findByNome(nome);
        if (optional.isPresent()){
            return ResponseEntity.ok(new CarroDto(optional.get()));
        }
        return ResponseEntity.notFound().build();

    }
    public boolean delete(Long id){
        Optional optional = carroRepository.findById(id);
        if(optional.isPresent()){
            carroRepository.delete((Carro) optional.get());
            return true;
        }
        return false;
    }
    public ResponseEntity<CarroDto> cadastrar(CarrosForm form, UriComponentsBuilder uriBuilder) {
        Carro carro = form.converter();
        carroRepository.save(carro);
        URI uri = uriBuilder.path("/carros/{id}").buildAndExpand(carro.getId()).toUri();
        return ResponseEntity.created(uri).body(new CarroDto(carro));
    }

    public ResponseEntity<CarroDto> atualiza(Long id, AtualizaCarroForm form) {
        Optional<Carro> optional = carroRepository.findById(id);
        if(optional.isPresent()){
            Carro carro = form.atualiza(id, carroRepository);
            return ResponseEntity.ok(new CarroDto(carro));
        }
        return ResponseEntity.notFound().build();
    }
}
