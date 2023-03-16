package es.iesrafaelalberti.apicliente.services;

import es.iesrafaelalberti.apicliente.dto.HeroeCreateDTO;
import es.iesrafaelalberti.apicliente.models.Heroe;
import es.iesrafaelalberti.apicliente.repositories.HeroesRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service @Transactional
public class HeroeService {

    @Autowired
    HeroesRepository heroesRepository;

    public Heroe herocreate(HeroeCreateDTO newHero){
        return heroesRepository.save(new Heroe(newHero));
    }
}
