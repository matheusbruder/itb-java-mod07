package br.com.mpbruder.perolas.controller;

import br.com.mpbruder.perolas.model.Pearl;
import br.com.mpbruder.perolas.service.PearlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pearl")
public class PearlController {

    @Autowired
    private PearlService service;

    @PostMapping("/insert")
    public ResponseEntity<Pearl> insert(@RequestBody Pearl pearl) {
        Pearl newPearl = service.insert(pearl);
        return new ResponseEntity<>(newPearl, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Pearl>> findAll() {
        List<Pearl> pearlList = service.findAll();
        return new ResponseEntity<>(pearlList, HttpStatus.OK);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Void> delete(@RequestParam long number_id) {
        service.delete(number_id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping
    public ResponseEntity<Pearl> update(@RequestBody Pearl pearl) {
        Pearl updatedPearl = service.update(pearl);
        return new ResponseEntity<>(updatedPearl, HttpStatus.OK);
    }

}
