package es.iesrafaelalberti.apicliente.factories;


import com.github.javafaker.Faker;
import es.iesrafaelalberti.apicliente.models.Person;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@Component
public class PersonFactory {
    static Faker esFaker = new Faker(new Locale("es-ES"));


    public static List<Person> get() {
        List<Person> people = new ArrayList<>();
        for(int i=0; i<2; i++)
            people.add(
                    new Person(

                            esFaker.name().username(),
                            esFaker.internet().emailAddress(),
                            esFaker.internet().password()
                            ));

        return people;
    }
}
