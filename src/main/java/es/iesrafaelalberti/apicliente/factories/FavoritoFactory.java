package es.iesrafaelalberti.apicliente.factories;

import es.iesrafaelalberti.apicliente.models.Favorito;
import es.iesrafaelalberti.apicliente.models.Heroe;
import es.iesrafaelalberti.apicliente.models.Person;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Component
public class FavoritoFactory {
    static Random rand = new Random();

    public static List<Favorito> get(int number, Person person, List<Heroe> heroes) {
        List<Favorito> favoritos = new ArrayList<>();
        for(int i=0; i<number; i++)
            favoritos.add(
                    new Favorito(
                            person,
                            heroes.get(rand.nextInt(heroes.size()))
                            ));

        return favoritos;
    }

}
