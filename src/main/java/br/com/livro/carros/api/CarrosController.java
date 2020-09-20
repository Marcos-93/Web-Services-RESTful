package br.com.livro.carros.api;

import br.com.livro.carros.domain.Carro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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
    @GetMapping("/teste")
    public String getTest(){
        return "Deu certo";
    }
}
