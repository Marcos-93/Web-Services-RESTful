package br.com.livro.carros.service;

import br.com.livro.carros.domain.Carro;
import br.com.livro.carros.repository.CarrosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
    public List<Carro> getCarros(){
        try{
            List<Carro> carros = carroRepository.findAll();
            return carros;
        } catch (Exception e){
            e.printStackTrace();
            return new ArrayList<Carro>();
        }
    }
    public Carro getCarro(Long id){
        Optional<Carro> optional = carroRepository.findById(id);
        if(optional.isPresent()){
            return optional.get();
        }
        return null;
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
}
