package br.com.livro.carros.api;

import br.com.livro.carros.model.Carro;
import br.com.livro.carros.service.dto.CarroDto;
import br.com.livro.carros.service.form.AtualizaCarroForm;
import br.com.livro.carros.service.form.CarrosForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import br.com.livro.carros.service.CarroService;
import org.springframework.web.util.UriComponentsBuilder;

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
    public List<CarroDto> getCarros(){
        return carroService.getCarros();
    }
    @PostMapping
    public ResponseEntity<CarroDto> cadastrar(@RequestBody CarrosForm form, UriComponentsBuilder uriBuilder){
       return carroService.cadastrar(form,uriBuilder);
    }
    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<CarroDto> atualizar(@PathVariable Long id, @RequestBody AtualizaCarroForm form){
        return carroService.atualiza(id,form);
    }
    @GetMapping("/{id}")
    public ResponseEntity<CarroDto> buscarCarro(@PathVariable("id") Long id){
        return carroService.getCarro(id);
    }
    @GetMapping("/tipo/{tipo}")
    public List<Carro> buscarPorTipo(@PathVariable("tipo") String tipo){
        return carroService.getByTipo(tipo);
    }
    @GetMapping("/nome/{nome}")
    public Carro buscarPorNome(@PathVariable String nome){
        return carroService.getByName(nome);
    }
}
