package es.iesrafaelalberti.apicliente.boot;

import es.iesrafaelalberti.apicliente.factories.HeroeFactory;
import es.iesrafaelalberti.apicliente.factories.UniverseFactory;
import es.iesrafaelalberti.apicliente.factories.VillanoFactory;
import es.iesrafaelalberti.apicliente.models.Heroe;
import es.iesrafaelalberti.apicliente.models.Universe;
import es.iesrafaelalberti.apicliente.models.Villano;
import es.iesrafaelalberti.apicliente.repositories.HeroesRepository;
import es.iesrafaelalberti.apicliente.repositories.UniverseRepository;
import es.iesrafaelalberti.apicliente.repositories.VillanosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Seeder implements CommandLineRunner {

    @Autowired
    UniverseRepository universeRepository;

    @Autowired
    HeroesRepository heroesRepository;

    @Autowired
    VillanosRepository villanosRepository;

    @Override
    public void run(String... args){
        List<Universe> universes = UniverseFactory.get();
        universeRepository.saveAll(universes);
        List<Heroe> heroes = HeroeFactory.get(5,universes);
        heroesRepository.saveAll(heroes);
        List<Villano> villanos = VillanoFactory.get(7,universes,heroes);
        villanosRepository.saveAll(villanos);
    }
}
