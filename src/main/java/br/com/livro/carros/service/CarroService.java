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
    public List<Carro> getByTipo(String tipo){
        return carroRepository.findByTipo(tipo);
    }
    public Carro getByName(String nome){
        return carroRepository.findByNome(nome);
    }
    public boolean delete(Long id){
        Optional optional = carroRepository.findById(id);
        if(optional.isPresent()){
            carroRepository.delete((Carro) optional.get());
            return true;
        }
        return false;
    }
    public boolean save(Carro carro){
        try{
          carroRepository.save(carro);
          return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
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
