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

        Heroe ironman = new Heroe(universes.get(0), "Iron Man", "I am Iron Man, the embodiment of innovation and resilience. Tony Stark is my name, and I proudly wear the mantle of a genius, billionaire, and superhero. My life changed when I created the revolutionary Iron Man suit.", 0, "Male", "https://i.pinimg.com/originals/08/1e/e0/081ee009c7e3e423eacdb74c956d8004.png");
        heroes.add(ironman);

        Heroe superman = new Heroe(universes.get(1), "Superman", "I am Superman, the Last Son of Krypton. With my incredible powers, I protect Earth from any threat. I stand for truth, justice, and the American way.", 0, "Male", "https://static.wikia.nocookie.net/personajes-de-ficcion-database/images/6/64/Superman.png/revision/latest?cb=20200909145020&path-prefix=es");
        heroes.add(superman);

        Heroe spiderman = new Heroe(universes.get(0), "Spider-Man", "With great power comes great responsibility. As Spider-Man, I swing through the streets of New York, using my abilities to protect the innocent and fight against crime.", 0, "Male", "https://www.freepnglogos.com/uploads/spiderman-png/spiderman-lumus-deviantart-34.png");
        heroes.add(spiderman);

        Heroe batman = new Heroe(universes.get(1), "Batman", "I am Batman, the Dark Knight of Gotham City. Using my intellect, gadgets, and martial arts skills, I strike fear into the hearts of criminals. I am vengeance, I am the night.", 0, "Male", "https://www.pngplay.com/wp-content/uploads/6/Batman-DC-Comics-Transparent-PNG.png");
        heroes.add(batman);

        Heroe captainAmerica = new Heroe(universes.get(0), "Captain America", "I am Captain America, a symbol of justice and patriotism. With my shield in hand, I fight for freedom and protect the innocent from any threat to our great nation.", 0, "Male", "https://static.wikia.nocookie.net/vsbattles/images/b/b5/MarvelNowCap.png/revision/latest/scale-to-width-down/340?cb=20211225213345");
        heroes.add(captainAmerica);

        Heroe wonderWoman = new Heroe(universes.get(1), "Wonder Woman", "I am Wonder Woman, a warrior princess of the Amazons. With my lasso of truth and Amazonian strength, I fight for peace, love, and justice in the world of men.", 0, "Female", "https://bewitchedbookworms.com/wp-content/uploads/2013/03/wonderwoman.png");
        heroes.add(wonderWoman);

        Heroe blackWidow = new Heroe(universes.get(0), "Black Widow", "As Black Widow, I am a highly skilled spy and master in martial arts. I use my talents to infiltrate and dismantle criminal organizations, ensuring that justice is served.", 0, "Female", "https://static.wikia.nocookie.net/marvelfanon/images/1/15/Black_Widow_LFNY.png/revision/latest?cb=20180401041903&path-prefix=es");
        heroes.add(blackWidow);

        Heroe flash = new Heroe(universes.get(1), "Flash", "I am Flash, the fastest man alive. With my superhuman speed, I race against time to protect Central City and fight crime. I am the lightning that strikes with justice.", 0, "Male", "https://i.pinimg.com/originals/83/10/59/83105916580f7b38172a68bc0cd688bb.png");
        heroes.add(flash);

        Heroe thor = new Heroe(universes.get(0), "Thor", "I am Thor, the God of Thunder. With my mighty hammer Mjolnir, I protect the realms from evil forces. As an Asgardian, I bring strength and lightning to those who oppose me.", 0, "Male", "https://static.wikia.nocookie.net/featteca/images/c/cb/Classic_Thor.png/revision/latest/scale-to-width-down/500?cb=20210227064825&path-prefix=es");
        heroes.add(thor);

        Heroe aquaman = new Heroe(universes.get(1), "Aquaman", "I am Aquaman, the king of Atlantis. With my ability to communicate with sea creatures and command the oceans, I defend the underwater realm and protect the surface world.", 0, "Male", "https://static.wikia.nocookie.net/death-battle-en-espanol/images/8/84/Aquaman.png/revision/latest?cb=20210427202832&path-prefix=es");
        heroes.add(aquaman);

        Heroe hulk = new Heroe(universes.get(0), "Hulk", "I am Hulk, a raging green monster fueled by gamma radiation. When anger takes over, my strength knows no bounds. I smash through obstacles and villains, defending the innocent.", 0, "Male", "https://i.pinimg.com/originals/9d/28/ed/9d28ed4f08d480d51708e1213b8a94a2.png");
        heroes.add(hulk);

        Heroe greenLantern = new Heroe(universes.get(1), "Green Lantern", "I am Green Lantern, a member of the Green Lantern Corps. With my power ring fueled by willpower, I patrol the universe and protect it from all threats. In brightest day, in blackest night.", 0, "Male", "https://static.wikia.nocookie.net/character-stats-and-profiles/images/e/ef/Hal-Jordan-GL.png/revision/latest/scale-to-width-down/400?cb=20200915140735");
        heroes.add(greenLantern);

        heroesRepository.saveAll(heroes);
        //List<Person> people = PersonFactory.get();
        Person persona = new Person("jairoro","jairoro@gmail.com","paco1234");
        //people.add(person);
        personRepository.save(persona);

        //Villanos

        List<Villano> villanos = new ArrayList<>();


        Villano venom = new Villano(universes.get(0), "Venom", "I am Venom, an alien symbiote thirsty for power and chaos. My dark nature drives me to dominate my enemies and consume their life force. No one can escape my immense power and ferocity. Prepare to face your worst nightmare.", 0, "Male", "https://static.wikia.nocookie.net/versus-compendium/images/8/8a/Venom.png/revision/latest?cb=20181009060720", spiderman);
        villanos.add(venom);

        Villano joker = new Villano(universes.get(1), "Joker", "Ha ha ha! I am the Joker, the Clown Prince of Crime! My chaotic antics and twisted sense of humor will drive you to the brink of madness. Prepare for a night of chaos and mayhem, Batman!", 0, "Male", "https://ar.salvat.com/colecciones/heroes-y-villanos/images/fig-joker309x365.png?crc=3868932655", batman);
        villanos.add(joker);

        Villano thanos = new Villano(universes.get(0), "Thanos", "I am Thanos, the Mad Titan. With the power of the Infinity Gauntlet, I seek to bring balance to the universe by wiping out half of all life. Your attempts to stop me are futile. Prepare to face the inevitability of your own destruction.", 0, "Male", "https://images-wixmp-ed30a86b8c4ca887773594c2.wixmp.com/f/335e007c-4af8-4e62-8040-af07c0929c24/df4u9iw-745bbac8-15c3-41a9-bc1d-f504f043714d.png/v1/fill/w_500,h_852/thanos__marvel_comics__render_by_egg84_df4u9iw-fullview.png?token=eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ1cm46YXBwOjdlMGQxODg5ODIyNjQzNzNhNWYwZDQxNWVhMGQyNmUwIiwiaXNzIjoidXJuOmFwcDo3ZTBkMTg4OTgyMjY0MzczYTVmMGQ0MTVlYTBkMjZlMCIsIm9iaiI6W1t7ImhlaWdodCI6Ijw9ODUyIiwicGF0aCI6IlwvZlwvMzM1ZTAwN2MtNGFmOC00ZTYyLTgwNDAtYWYwN2MwOTI5YzI0XC9kZjR1OWl3LTc0NWJiYWM4LTE1YzMtNDFhOS1iYzFkLWY1MDRmMDQzNzE0ZC5wbmciLCJ3aWR0aCI6Ijw9NTAwIn1dXSwiYXVkIjpbInVybjpzZXJ2aWNlOmltYWdlLm9wZXJhdGlvbnMiXX0.BI_t82PeH7sSbz829n-WcedU4Y74a1GtFTr78Icl5n8", ironman);
        villanos.add(thanos);

        Villano lexLuthor = new Villano(universes.get(1), "Lex Luthor", "I am Lex Luthor, the genius billionaire and mastermind behind LexCorp. My intelligence and wealth make me a formidable foe for Superman and all those who stand in my way. Prepare to witness my brilliance and ambition, Superman!", 0, "Male", "https://upload.wikimedia.org/wikipedia/en/9/9b/Lex_Luthor_%28comic_book_supervillain%29_infobox_image.png", superman);
        villanos.add(lexLuthor);

        Villano magneto = new Villano(universes.get(0), "Magneto", "I am Magneto, the master of magnetism. As a mutant, I fight for the superiority of mutants over humans. With my control over metal, I will crush anyone who stands in my way. Prepare to witness the rise of mutants and the fall of humanity.", 0, "Male", "https://static.wikia.nocookie.net/marvelvscapcomespaol/images/5/5e/Magneto.png/revision/latest?cb=20130319035355&path-prefix=es", ironman);
        villanos.add(magneto);

        Villano harleyQuinn = new Villano(universes.get(1), "Harley Quinn", "Hi Puddin'! I'm Harley Quinn, the Joker's loyal and unpredictable sidekick. With my mallet and acrobatic skills, I'll give you a show you won't forget. Get ready for some fun and mischief, Bat-Freak!", 0, "Female", "https://static.wikia.nocookie.net/death-battle-en-espanol/images/3/3f/Harley_Quinn.png/revision/latest?cb=20220308234135&path-prefix=es", batman);
        villanos.add(harleyQuinn);

        Villano greenGoblin = new Villano(universes.get(0), "Green Goblin", "I am Green Goblin, the embodiment of chaos and terror. With my glider and arsenal of deadly weapons, I will bring fear to the streets. Your attempts to stop me will be in vain. Prepare to face your worst nightmares.", 0, "Male", "https://static.wikia.nocookie.net/avengersalliance/images/e/ed/Green_Goblin_Marvel_XP.png/revision/latest?cb=20120420211509", spiderman);
        villanos.add(greenGoblin);

        Villano darkseid = new Villano(universes.get(1), "Darkseid", "I am Darkseid, the ruler of Apokolips and the embodiment of tyranny! My ultimate goal is to conquer the universe and bend all to my will. Prepare to kneel before me, Justice League!", 0, "Male", "https://static.wikia.nocookie.net/vsbattles/images/7/7d/DarkseidNew52Render.png/revision/latest?cb=20190530022450", superman);
        villanos.add(darkseid);

        Villano hela = new Villano(universes.get(0), "Hela", "I am Hela, the Goddess of Death. With my power over dark magic and ability to control the dead, I will bring destruction and chaos to Asgard and the entire universe. Prepare to face the wrath and power of Death itself.", 0, "Female", "https://static.wikia.nocookie.net/character-level/images/d/db/Hela.png/revision/latest?cb=20191127160937", thor);
        villanos.add(hela);

        Villano catwoman = new Villano(universes.get(1), "Catwoman", "Meow! I'm Catwoman, the skilled thief with a taste for luxury. With my feline agility and cunning, I'll always stay one step ahead. Prepare for a game of cat and mouse, Batman!", 0, "Female", "https://static.wikia.nocookie.net/death-battle-en-espanol/images/3/3f/Harley_Quinn.png/revision/latest?cb=20220308234135&path-prefix=es", batman);
        villanos.add(catwoman);

        Villano kingpin = new Villano(universes.get(0), "Kingpin", "I am Kingpin, the relentless crime lord. My intelligence and brute strength have allowed me to control the city's underworld. Your efforts to maintain peace will be in vain. Soon you will find yourself trapped in my web of corruption and violence.", 0, "Male", "https://www.pngplay.com/wp-content/uploads/12/Kingpin-Transparent-Free-PNG.png", spiderman);
        villanos.add(kingpin);

        Villano reverseFlash = new Villano(universes.get(0), "Reverse-Flash", "I am the Reverse-Flash, the arch-nemesis of the Flash! With my ability to tap into the negative Speed Force, I can match and even surpass the Scarlet Speedster's velocity.", 0, "Male", "https://static.wikia.nocookie.net/characterprofile/images/5/57/ReverseFlash.png/revision/latest?cb=20210925193042", flash);
        villanos.add(reverseFlash);

        villanosRepository.saveAll(villanos);
        /*
        List<Favorito> favoritos = FavoritoFactory.get(2, persona,heroe);
        favoritosRepository.saveAll(favoritos);
        List<Villano> villanos = VillanoFactory.get(7,universes,heroe);
        villanosRepository.saveAll(villanos);

         */
    }
}
