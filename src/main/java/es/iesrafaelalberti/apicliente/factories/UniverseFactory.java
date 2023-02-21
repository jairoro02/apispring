package es.iesrafaelalberti.apicliente.factories;

import com.github.javafaker.Faker;
import es.iesrafaelalberti.apicliente.models.Heroe;
import es.iesrafaelalberti.apicliente.models.Universe;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@Component
public class UniverseFactory {

    static Faker esFaker = new Faker(new Locale("es-ES"));

    public static List<Universe> get() {
        List<Universe> universes = new ArrayList<>();
        for(int i=0; i<2; i++)
            universes.add(new Universe(esFaker.name().firstName()));

        return universes;
    }
}
