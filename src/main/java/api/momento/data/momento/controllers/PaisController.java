package api.momento.data.momento.controllers;

import api.momento.data.momento.models.Pais;
import api.momento.data.momento.repository.PaisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/paises")
public class PaisController {
    @Autowired
    PaisRepository dbConnection;

    @CrossOrigin
    @GetMapping("/")
    public List<Pais> findAllRecords(){
        return dbConnection.findAll();
    }

    //Encontrar um único elemento por id
    @RequestMapping(value = "buscar/id/{id}", method = RequestMethod.GET)
    public Optional<Pais> searchById(@PathVariable String id) {
        return dbConnection.findPaisBypaisId(id);
    }

    //Encontrar um único elemento por nome
    @RequestMapping(value = "buscar/nome/{nome}", method = RequestMethod.GET)
    public Optional<Pais> searchByName(@PathVariable String nome) {
        return dbConnection.findPaisBypaisNome(nome);
    }

}
