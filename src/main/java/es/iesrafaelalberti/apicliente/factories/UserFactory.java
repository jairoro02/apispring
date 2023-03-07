package es.iesrafaelalberti.apicliente.factories;


import com.github.javafaker.Faker;
import es.iesrafaelalberti.apicliente.models.Universe;
import es.iesrafaelalberti.apicliente.models.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@Component
public class UserFactory {
    static Faker esFaker = new Faker(new Locale("es-ES"));


    public static List<User> get() {
        List<User> users = new ArrayList<>();
        for(int i=0; i<2; i++)
            users.add(
                    new User(
                            esFaker.name().firstName(),
                            esFaker.name().username()
                            ));

        return users;
    }
}
