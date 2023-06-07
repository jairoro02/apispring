package es.iesrafaelalberti.apicliente.boot;

import es.iesrafaelalberti.apicliente.factories.*;
import es.iesrafaelalberti.apicliente.models.*;
import es.iesrafaelalberti.apicliente.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
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

        //Creación de universos manual
        Universe marvel = new Universe("Marvel");
        Universe dc = new Universe("DC");

        List<Universe> universes = new ArrayList<>();
        universes.add(marvel);
        universes.add(dc);
        universeRepository.saveAll(universes);

        //Creación de Heroes manual
        List<Heroe> heroes = new ArrayList<>();

        Heroe ironman = new Heroe(universes.get(0), "Iron Man", "I am Iron Man, the embodiment of innovation and resilience. Tony Stark is my name, and I proudly wear the mantle of a genius, billionaire, and superhero. My life changed when I created the revolutionary Iron Man suit.", 0, "Male", "image");
        heroes.add(ironman);

        Heroe spiderman = new Heroe(universes.get(0), "Spider-Man", "With great power comes great responsibility. As Spider-Man, I swing through the streets of New York, using my abilities to protect the innocent and fight against crime.", 0, "Male", "image");
        heroes.add(spiderman);

        Heroe captainAmerica = new Heroe(universes.get(0), "Captain America", "I am Captain America, a symbol of justice and patriotism. With my shield in hand, I fight for freedom and protect the innocent from any threat to our great nation.", 0, "Male", "image");
        heroes.add(captainAmerica);

        Heroe blackWidow = new Heroe(universes.get(0), "Black Widow", "As Black Widow, I am a highly skilled spy and master in martial arts. I use my talents to infiltrate and dismantle criminal organizations, ensuring that justice is served.", 0, "Female", "image");
        heroes.add(blackWidow);

        Heroe thor = new Heroe(universes.get(0), "Thor", "I am Thor, the God of Thunder. With my mighty hammer Mjolnir, I protect the realms from evil forces. As an Asgardian, I bring strength and lightning to those who oppose me.", 0, "Male", "image");
        heroes.add(thor);

        Heroe hulk = new Heroe(universes.get(0), "Hulk", "I am Hulk, a raging green monster fueled by gamma radiation. When anger takes over, my strength knows no bounds. I smash through obstacles and villains, defending the innocent.", 0, "Male", "image");
        heroes.add(hulk);

        Heroe blackPanther = new Heroe(universes.get(0), "Black Panther", "I am Black Panther, the protector of Wakanda. With my enhanced abilities and vibranium suit, I ensure the safety and prosperity of my people, while also fighting for justice around the world.", 0, "Male", "image");
        heroes.add(blackPanther);

        Heroe captainMarvel = new Heroe(universes.get(0), "Captain Marvel", "I am Captain Marvel, a cosmic-powered superhero. With the energy of the Tesseract flowing through me, I defend Earth and the universe from intergalactic threats. Together, we can achieve anything.", 0, "Female", "image");
        heroes.add(captainMarvel);

        Heroe doctorStrange = new Heroe(universes.get(0), "Doctor Strange", "I am Doctor Strange, the Sorcerer Supreme. With my mastery of the mystic arts, I protect the world from supernatural threats. I bend reality and time to ensure the balance between dimensions.", 0, "Male", "image");
        heroes.add(doctorStrange);

        Heroe scarletWitch = new Heroe(universes.get(0), "Scarlet Witch", "I am Scarlet Witch, a mutant with reality-altering powers. I strive to control and use my abilities responsibly, protecting both mutants and humans from harm.", 0, "Female", "image");
        heroes.add(scarletWitch);

        Heroe antMan = new Heroe(universes.get(0), "Ant-Man", "I am Ant-Man, a master of size manipulation. With my suit and shrinking abilities, I can go unnoticed or grow in size, all while using my skills to fight alongside other heroes.", 0, "Male", "image");
        heroes.add(antMan);

        Heroe groot = new Heroe(universes.get(0), "Groot", "I am Groot. Although my vocabulary is limited, my loyalty and strength are immeasurable. I stand with my fellow Guardians of the Galaxy to protect the cosmos.", 0, "Male", "image");
        heroes.add(groot);

        Heroe superman = new Heroe(universes.get(1), "Superman", "I am Superman, the Last Son of Krypton. With my incredible powers, I protect Earth from any threat. I stand for truth, justice, and the American way.", 0, "Male", "image");
        heroes.add(superman);

        Heroe batman = new Heroe(universes.get(1), "Batman", "I am Batman, the Dark Knight of Gotham City. Using my intellect, gadgets, and martial arts skills, I strike fear into the hearts of criminals. I am vengeance, I am the night.", 0, "Male", "image");
        heroes.add(batman);

// Continuar creando los otros 10 héroes de DC

        Heroe wonderWoman = new Heroe(universes.get(1), "Wonder Woman", "I am Wonder Woman, a warrior princess of the Amazons. With my lasso of truth and Amazonian strength, I fight for peace, love, and justice in the world of men.", 0, "Female", "image");
        heroes.add(wonderWoman);

        Heroe flash = new Heroe(universes.get(1), "Flash", "I am Flash, the fastest man alive. With my superhuman speed, I race against time to protect Central City and fight crime. I am the lightning that strikes with justice.", 0, "Male", "image");
        heroes.add(flash);

        Heroe aquaman = new Heroe(universes.get(1), "Aquaman", "I am Aquaman, the king of Atlantis. With my ability to communicate with sea creatures and command the oceans, I defend the underwater realm and protect the surface world.", 0, "Male", "image");
        heroes.add(aquaman);

        Heroe greenLantern = new Heroe(universes.get(1), "Green Lantern", "I am Green Lantern, a member of the Green Lantern Corps. With my power ring fueled by willpower, I patrol the universe and protect it from all threats. In brightest day, in blackest night.", 0, "Male", "image");
        heroes.add(greenLantern);

        Heroe batwoman = new Heroe(universes.get(1), "Batwoman", "I am Batwoman, a vigilante dedicated to fighting crime in Gotham City. I use my skills, gadgets, and determination to bring justice to the streets, following in Batman's footsteps.", 0, "Female", "image");
        heroes.add(batwoman);

        Heroe martianManhunter = new Heroe(universes.get(1), "Martian Manhunter", "I am Martian Manhunter, the last survivor of Mars. With my shape-shifting abilities and telepathic powers, I defend Earth from extraterrestrial threats. I am a guardian of two worlds.", 0, "Male", "image");
        heroes.add(martianManhunter);

        Heroe greenArrow = new Heroe(universes.get(1), "Green Arrow", "I am Green Arrow, a skilled archer and vigilante. With my bow and arrow, I fight against corruption and injustice in Star City. I am the voice of the forgotten.", 0, "Male", "image");
        heroes.add(greenArrow);

        Heroe hawkman = new Heroe(universes.get(1), "Hawkman", "I am Hawkman, an immortal warrior from the planet Thanagar. With my wings and Nth metal armor, I soar through the skies and protect Earth from both terrestrial and extraterrestrial threats.", 0, "Male", "image");
        heroes.add(hawkman);

        Heroe zatanna = new Heroe(universes.get(1), "Zatanna", "I am Zatanna, a skilled magician and sorceress. With my mastery of spells and incantations, I defend the world from supernatural forces and seek to maintain the balance between magic and reality.", 0, "Female", "image");
        heroes.add(zatanna);

        Heroe cyborg = new Heroe(universes.get(1), "Cyborg", "I am Cyborg, a half-man, half-machine superhero. With my cybernetic enhancements, I possess incredible strength and technological abilities. I use my powers to fight alongside other heroes and protect the innocent.", 0, "Male", "image");
        heroes.add(cyborg);

        Heroe blackCanary = new Heroe(universes.get(1), "Black Canary", "I am Black Canary, a highly skilled martial artist and metahuman with the power of the Canary Cry. I fight for justice and use my sonic scream to take down criminals and defend the innocent.", 0, "Female", "image");
        heroes.add(blackCanary);

        heroesRepository.saveAll(heroes);
        //List<Person> people = PersonFactory.get();
        Person persona = new Person("jairoro","jairoro@gmail.com","paco1234");
        //people.add(person);
        personRepository.save(persona);
        /*
        List<Favorito> favoritos = FavoritoFactory.get(2, persona,heroe);
        favoritosRepository.saveAll(favoritos);
        List<Villano> villanos = VillanoFactory.get(7,universes,heroe);
        villanosRepository.saveAll(villanos);

         */
    }
}
