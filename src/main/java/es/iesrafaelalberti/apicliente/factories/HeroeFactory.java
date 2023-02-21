package es.iesrafaelalberti.apicliente.factories;

import es.iesrafaelalberti.apicliente.models.Heroe;
import es.iesrafaelalberti.apicliente.models.Universe;
import es.iesrafaelalberti.apicliente.models.Villano;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Random;

import com.github.javafaker.Faker;



@Component
public class HeroeFactory {

    static Faker esFaker = new Faker(new Locale("es-ES"));
    static Random rand = new Random();

    public static List<Heroe> get(int number, List<Universe> universes) {
        List<Heroe> heroes = new ArrayList<>();
        for(int i=0; i<number; i++)
            heroes.add(new Heroe(universes.get(rand.nextInt(universes.size())),
                    esFaker.date().birthday(),
                    esFaker.name().firstName(),
                    esFaker.name().firstName(),
                    esFaker.number().numberBetween(5,50),
                    esFaker.name().firstName(),
                    esFaker.name().firstName()));

        return heroes;
    }
}
