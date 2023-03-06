package es.iesrafaelalberti.apicliente.factories;

import com.github.javafaker.Faker;
import es.iesrafaelalberti.apicliente.models.Heroe;
import es.iesrafaelalberti.apicliente.models.Universe;
import es.iesrafaelalberti.apicliente.models.Villano;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Random;

@Component
public class VillanoFactory {
    static Faker esFaker = new Faker(new Locale("es-ES"));
    static Random rand = new Random();

    public static List<Villano> get(int number, List<Universe> universes, List<Heroe> heroes) {
        List<Villano> villanos = new ArrayList<>();
        for(int i=0; i<number; i++)
            villanos.add(
                    new Villano(
                            universes.get(rand.nextInt(universes.size())),
                    esFaker.name().firstName(),
                    esFaker.name().firstName(),
                    esFaker.number().numberBetween(5,50),
                    esFaker.name().firstName(),
                    esFaker.name().firstName(),
                    heroes.get(rand.nextInt(heroes.size()))));

        return villanos;
    }
}
