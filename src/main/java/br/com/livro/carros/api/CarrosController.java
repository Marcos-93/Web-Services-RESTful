package br.com.livro.carros.api;

import br.com.livro.carros.domain.Carro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.com.livro.carros.service.CarroService;

import java.util.List;

@RestController
@RequestMapping("/carros")
public class CarrosController {
    private CarroService carroService;

    @Autowired
    public CarrosController(CarroService carroService) {
        this.carroService = carroService;
    }
    @GetMapping
    public List<Carro> getCarros(){
        return carroService.getCarros();
    }
    @GetMapping("/{id}")
    public Carro getCarro(@PathVariable("id") Long id){
        return carroService.getCarro(id);
    }
    @GetMapping("/tipo/{tipo}")
    public List<Carro> getByTipo(@PathVariable("tipo") String tipo){
        return carroService.getByTipo(tipo);
    }
    @GetMapping("/nome/{nome}")
    public Carro getByName(@PathVariable String nome){
        return carroService.getByName(nome);
    }
}
