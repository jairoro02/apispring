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

        Heroe ironman = new Heroe(universes.get(0), "Iron Man", "I am Iron Man, the embodiment of innovation and resilience. Tony Stark is my name, and I proudly wear the mantle of a genius, billionaire, and superhero. My life changed when I created the revolutionary Iron Man suit.", 0, "Male", "https://i.pinimg.com/originals/08/1e/e0/081ee009c7e3e423eacdb74c956d8004.png","https://i.ibb.co/jDtZ1Gg/ironman-banner.jpg");
        heroes.add(ironman);

        Heroe superman = new Heroe(universes.get(1), "Superman", "I am Superman, the Last Son of Krypton. With my incredible powers, I protect Earth from any threat. I stand for truth, justice, and the American way.", 0, "Male", "https://i.ibb.co/fMx9gdy/Superman.webp","https://i.ibb.co/k2PMKnj/superman-banner.jpg");
        heroes.add(superman);

        Heroe spiderman = new Heroe(universes.get(0), "Spider-Man", "With great power comes great responsibility. As Spider-Man, I swing through the streets of New York, using my abilities to protect the innocent and fight against crime.", 0, "Male", "https://www.freepnglogos.com/uploads/spiderman-png/spiderman-lumus-deviantart-34.png","https://i.ibb.co/F0ZHqW1/spiderman-banner.webp");
        heroes.add(spiderman);

        Heroe batman = new Heroe(universes.get(1), "Batman", "I am Batman, the Dark Knight of Gotham City. Using my intellect, gadgets, and martial arts skills, I strike fear into the hearts of criminals. I am vengeance, I am the night.", 0, "Male", "https://www.pngplay.com/wp-content/uploads/6/Batman-DC-Comics-Transparent-PNG.png","https://i.ibb.co/k5ZYfwj/batman-banner.jpg");
        heroes.add(batman);

        Heroe captainAmerica = new Heroe(universes.get(0), "Captain America", "I am Captain America, a symbol of justice and patriotism. With my shield in hand, I fight for freedom and protect the innocent from any threat to our great nation.", 0, "Male", "https://i.ibb.co/DrQxKFd/Marvel-Now-Cap.webp","https://i.ibb.co/x7MC5HW/captainamerica-banner.webp");
        heroes.add(captainAmerica);

        Heroe wonderWoman = new Heroe(universes.get(1), "Wonder Woman", "I am Wonder Woman, a warrior princess of the Amazons. With my lasso of truth and Amazonian strength, I fight for peace, love, and justice in the world of men.", 0, "Female", "https://bewitchedbookworms.com/wp-content/uploads/2013/03/wonderwoman.png","https://i.ibb.co/K69LnZM/wonderwoman-banner.png");
        heroes.add(wonderWoman);

        Heroe blackWidow = new Heroe(universes.get(0), "Black Widow", "As Black Widow, I am a highly skilled spy and master in martial arts. I use my talents to infiltrate and dismantle criminal organizations, ensuring that justice is served.", 0, "Female", "https://i.ibb.co/NY76Fs7/Black-Widow-LFNY.webp","https://i.ibb.co/R9nPCPJ/blackwidow-banner.webp");
        heroes.add(blackWidow);

        Heroe flash = new Heroe(universes.get(1), "Flash", "I am Flash, the fastest man alive. With my superhuman speed, I race against time to protect Central City and fight crime. I am the lightning that strikes with justice.", 0, "Male", "https://i.pinimg.com/originals/83/10/59/83105916580f7b38172a68bc0cd688bb.png","https://i.ibb.co/c3SSzgc/flash-banner.jpg");
        heroes.add(flash);

        Heroe thor = new Heroe(universes.get(0), "Thor", "I am Thor, the God of Thunder. With my mighty hammer Mjolnir, I protect the realms from evil forces. As an Asgardian, I bring strength and lightning to those who oppose me.", 0, "Male", "https://i.ibb.co/F4XD7gW/Classic-Thor.webp","https://i.ibb.co/GchjN9F/thor-banner.jpg");
        heroes.add(thor);

        Heroe aquaman = new Heroe(universes.get(1), "Aquaman", "I am Aquaman, the king of Atlantis. With my ability to communicate with sea creatures and command the oceans, I defend the underwater realm and protect the surface world.", 0, "Male", "https://i.ibb.co/3185wgC/Aquaman.webp","https://i.ibb.co/K6pzRqL/aqua-banner.jpg");
        heroes.add(aquaman);

        Heroe hulk = new Heroe(universes.get(0), "Hulk", "I am Hulk, a raging green monster fueled by gamma radiation. When anger takes over, my strength knows no bounds. I smash through obstacles and villains, defending the innocent.", 0, "Male", "https://i.pinimg.com/originals/9d/28/ed/9d28ed4f08d480d51708e1213b8a94a2.png", "https://i.ibb.co/gVmWZzP/hulk-banner.webp");
        heroes.add(hulk);

        Heroe greenLantern = new Heroe(universes.get(1), "Green Lantern", "I am Green Lantern, a member of the Green Lantern Corps. With my power ring fueled by willpower, I patrol the universe and protect it from all threats. In brightest day, in blackest night.", 0, "Male", "https://i.ibb.co/kmPB8z5/Hal-Jordan-GL.webp","https://i.ibb.co/rd6QhHM/green-banner.webp");
        heroes.add(greenLantern);

        heroesRepository.saveAll(heroes);
        //List<Person> people = PersonFactory.get();
        Person persona = new Person("jairoro","jairoro@gmail.com","paco1234");
        //people.add(person);
        personRepository.save(persona);

        //Villanos

        List<Villano> villanos = new ArrayList<>();


        Villano venom = new Villano(universes.get(0), "Venom", "I am Venom, an alien symbiote thirsty for power and chaos. My dark nature drives me to dominate my enemies and consume their life force. No one can escape my immense power and ferocity. Prepare to face your worst nightmare.", 0, "Male", "https://i.ibb.co/KWHHYZx/Venom.webp","https://i.ibb.co/cYR6kG7/venom-banner.webp", spiderman);
        villanos.add(venom);

        Villano joker = new Villano(universes.get(1), "Joker", "Ha ha ha! I am the Joker, the Clown Prince of Crime! My chaotic antics and twisted sense of humor will drive you to the brink of madness. Prepare for a night of chaos and mayhem, Batman!", 0, "Male", "https://i.ibb.co/TqNrd3t/Joker.png","https://i.ibb.co/1sZ5FCD/joker-banner.webp", batman);
        villanos.add(joker);

        Villano thanos = new Villano(universes.get(0), "Thanos", "I am Thanos, the Mad Titan. With the power of the Infinity Gauntlet, I seek to bring balance to the universe by wiping out half of all life. Your attempts to stop me are futile. Prepare to face the inevitability of your own destruction.", 0, "Male", "https://i.ibb.co/2688V7v/thanos-marvel-comics-render-by-egg84-df4u9iw-fullview.png","https://i.ibb.co/KX61JQC/thanos-banner.jpg", ironman);
        villanos.add(thanos);

        Villano lexLuthor = new Villano(universes.get(1), "Lex Luthor", "I am Lex Luthor, the genius billionaire and mastermind behind LexCorp. My intelligence and wealth make me a formidable foe for Superman and all those who stand in my way. Prepare to witness my brilliance and ambition, Superman!", 0, "Male", "https://upload.wikimedia.org/wikipedia/en/9/9b/Lex_Luthor_%28comic_book_supervillain%29_infobox_image.png","https://i.ibb.co/1r9Zycv/lexluthor-banner.jpg", superman);
        villanos.add(lexLuthor);

        Villano magneto = new Villano(universes.get(0), "Magneto", "I am Magneto, the master of magnetism. As a mutant, I fight for the superiority of mutants over humans. With my control over metal, I will crush anyone who stands in my way. Prepare to witness the rise of mutants and the fall of humanity.", 0, "Male", "https://i.ibb.co/nc25qdp/Magneto.webp","https://i.ibb.co/zmn1nRw/magneto-banner.png", ironman);
        villanos.add(magneto);

        Villano harleyQuinn = new Villano(universes.get(1), "Harley Quinn", "Hi Puddin'! I'm Harley Quinn, the Joker's loyal and unpredictable sidekick. With my mallet and acrobatic skills, I'll give you a show you won't forget. Get ready for some fun and mischief, Bat-Freak!", 0, "Female", "https://i.ibb.co/b1zM5FR/Harley-Quinn.webp","https://i.ibb.co/KGhctRm/harleyquinn-banner.jpg", batman);
        villanos.add(harleyQuinn);

        Villano greenGoblin = new Villano(universes.get(0), "Green Goblin", "I am Green Goblin, the embodiment of chaos and terror. With my glider and arsenal of deadly weapons, I will bring fear to the streets. Your attempts to stop me will be in vain. Prepare to face your worst nightmares.", 0, "Male", "https://i.ibb.co/mTpxHd0/Green-Goblin-Marvel-XP.webp","https://i.ibb.co/Xx83tMm/green-gobling-banner.webp", spiderman);
        villanos.add(greenGoblin);

        Villano darkseid = new Villano(universes.get(1), "Darkseid", "I am Darkseid, the ruler of Apokolips and the embodiment of tyranny! My ultimate goal is to conquer the universe and bend all to my will. Prepare to kneel before me, Justice League!", 0, "Male", "https://i.ibb.co/kxdbszw/Darkseid-New52-Render.webp","https://i.ibb.co/tsM8QY2/darkseid-banner.webp", superman);
        villanos.add(darkseid);

        Villano hela = new Villano(universes.get(0), "Hela", "I am Hela, the Goddess of Death. With my power over dark magic and ability to control the dead, I will bring destruction and chaos to Asgard and the entire universe. Prepare to face the wrath and power of Death itself.", 0, "Female", "https://i.ibb.co/pJMKGw6/Hela.webp","https://i.ibb.co/VVtC79M/hela-banner.webp", thor);
        villanos.add(hela);

        Villano catwoman = new Villano(universes.get(1), "Catwoman", "Meow! I'm Catwoman, the skilled thief with a taste for luxury. With my feline agility and cunning, I'll always stay one step ahead. Prepare for a game of cat and mouse, Batman!", 0, "Female", "https://i.ibb.co/zhvPJ5S/image-processing20200410-24803-iivzt1.png","https://i.ibb.co/wS8nfQG/catwoman-banner.webp", batman);
        villanos.add(catwoman);

        Villano kingpin = new Villano(universes.get(0), "Kingpin", "I am Kingpin, the relentless crime lord. My intelligence and brute strength have allowed me to control the city's underworld. Your efforts to maintain peace will be in vain. Soon you will find yourself trapped in my web of corruption and violence.", 0, "Male", "https://www.pngplay.com/wp-content/uploads/12/Kingpin-Transparent-Free-PNG.png","https://i.ibb.co/mJTQJvK/kingping-banner.jpg", spiderman);
        villanos.add(kingpin);

        Villano reverseFlash = new Villano(universes.get(1), "Reverse-Flash", "I am the Reverse-Flash, the arch-nemesis of the Flash! With my ability to tap into the negative Speed Force, I can match and even surpass the Scarlet Speedster's velocity.", 0, "Male", "https://i.ibb.co/Jj7s1Pv/Reverse-Flash.webp","https://i.ibb.co/sFc42Gb/reverseflash-banner.webp", flash);
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
