package es.iesrafaelalberti.apicliente.boot;

import es.iesrafaelalberti.apicliente.factories.*;
import es.iesrafaelalberti.apicliente.models.*;
import es.iesrafaelalberti.apicliente.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Seeder implements CommandLineRunner {

    @Autowired
    PersonRepository personRepository;

    @Autowired
    FavoritosRepository favoritosRepository;

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
        //List<Person> people = PersonFactory.get();
        Person persona = new Person("jairoro","paco1234");
        //people.add(person);
        personRepository.save(persona);
        List<Favorito> favoritos = FavoritoFactory.get(5, persona,heroes);
        favoritosRepository.saveAll(favoritos);
        List<Villano> villanos = VillanoFactory.get(7,universes,heroes);
        villanosRepository.saveAll(villanos);
    }
}
