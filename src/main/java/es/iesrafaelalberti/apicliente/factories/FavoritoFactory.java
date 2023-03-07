package es.iesrafaelalberti.apicliente.factories;

import es.iesrafaelalberti.apicliente.models.Favorito;
import es.iesrafaelalberti.apicliente.models.Heroe;
import es.iesrafaelalberti.apicliente.models.Universe;
import es.iesrafaelalberti.apicliente.models.Villano;
import es.iesrafaelalberti.apicliente.models.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Component
public class FavoritoFactory {
    static Random rand = new Random();

    public static List<Favorito> get(int number, List<User> users, List<Heroe> heroes) {
        List<Favorito> favoritos = new ArrayList<>();
        for(int i=0; i<number; i++)
            favoritos.add(
                    new Favorito(
                            users.get(rand.nextInt(users.size())),
                            heroes.get(rand.nextInt(heroes.size()))
                            ));

        return favoritos;
    }

}
