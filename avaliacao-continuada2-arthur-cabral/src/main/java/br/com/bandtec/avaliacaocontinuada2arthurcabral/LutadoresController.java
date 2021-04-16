package br.com.bandtec.avaliacaocontinuada2arthurcabral;

import br.com.bandtec.avaliacaocontinuada2arthurcabral.Lutadores;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/lutadores")
public class LutadoresController {

    @Autowired
    private LutadoresRepository repository;

    @GetMapping
    public ResponseEntity getLutadores(){
        List<Lutadores> lutadores = repository.findAllByOrderByForcaGolpeDesc();
        if(lutadores.isEmpty()){
            return ResponseEntity.status(204).build();
        } else {
            return ResponseEntity.status(200).body(lutadores);
        }
    }

    @PostMapping
    public ResponseEntity postLutadores(@RequestBody @Valid Lutadores novoLutador){
        repository.save(novoLutador);
        return ResponseEntity.status(201).build();
    }

    @GetMapping("/contagem-vivos")
    public ResponseEntity getLutadoresVivos(){
        List<Lutadores> lutadores = repository.findByVivoTrue();
        if(lutadores.isEmpty()){
            return ResponseEntity.status(204).build();
        } else {
            return ResponseEntity.status(200).body(lutadores);
        }
    }

//    @PostMapping("{id}/concentrar")
//    public ResponseEntity postConcentrar(@RequestParam @Valid Integer id){
//        Optional<Lutadores> lutadorOptional = repository.findById(id);
//        if(lutadorOptional.isPresent()){
//
//        }
//
//    }
    @GetMapping("/contagem-mortos")
    public ResponseEntity getLutadoresMortos(){
        List<Lutadores> lutadores = repository.findByVivoFalse();
        if(lutadores.isEmpty()){
            return ResponseEntity.status(204).build();
        } else {
            return ResponseEntity.status(200).body(lutadores);
        }
    }
}
