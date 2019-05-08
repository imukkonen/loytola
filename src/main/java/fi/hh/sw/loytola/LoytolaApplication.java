package fi.hh.sw.loytola;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import fi.hh.sw.loytola.domain.Animal;
import fi.hh.sw.loytola.domain.AnimalKind;
import fi.hh.sw.loytola.domain.AnimalKindRepository;
import fi.hh.sw.loytola.domain.AnimalRepository;
import fi.hh.sw.loytola.domain.Breed;
import fi.hh.sw.loytola.domain.BreedRepository;
import fi.hh.sw.loytola.domain.DepartureCause;
import fi.hh.sw.loytola.domain.DepartureCauseRepository;
import fi.hh.sw.loytola.domain.Room;
import fi.hh.sw.loytola.domain.RoomKind;
import fi.hh.sw.loytola.domain.RoomKindRepository;
import fi.hh.sw.loytola.domain.RoomRepository;
import fi.hh.sw.loytola.domain.Sex;
import fi.hh.sw.loytola.domain.SexRepository;
import fi.hh.sw.loytola.domain.User;
import fi.hh.sw.loytola.domain.UserRepository;


@SpringBootApplication
public class LoytolaApplication {

private static final DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
	
private static final Logger log = LoggerFactory.getLogger(LoytolaApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(LoytolaApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner roomDemo(RoomRepository rrepository, RoomKindRepository rkrepository, AnimalKindRepository akrepository, AnimalRepository arepository, BreedRepository brepository, SexRepository srepository, DepartureCauseRepository drepository, UserRepository urepository) {
		return (args) -> {
			
			log.info("save a couple of rooms");
			rkrepository.save(new RoomKind("Isot koirat", 10));
			rkrepository.save(new RoomKind("Pienet koirat", 10));
			rkrepository.save(new RoomKind("Kissat", 10));
			rkrepository.save(new RoomKind("Linnut", 8));
			rkrepository.save(new RoomKind("Matelijat", 5));
			rkrepository.save(new RoomKind("Jyrsijät", 8));
			rkrepository.save(new RoomKind("Kanit", 8));
			rkrepository.save(new RoomKind("No room", 8));
			
			rrepository.save(new Room("IK-1", 5, 0, rkrepository.findByName("Isot koirat").get(0)));
			rrepository.save(new Room("PK-1", 10, 10, rkrepository.findByName("Pienet koirat").get(0)));
			rrepository.save(new Room("K-1", 15, 15, rkrepository.findByName("Kissat").get(0)));
			rrepository.save(new Room("Kk-1", 15, 15, rkrepository.findByName("Kanit").get(0)));
			rrepository.save(new Room("J-1", 15, 15, rkrepository.findByName("Jyrsijät").get(0)));
			rrepository.save(new Room("J-2", 15, 15, rkrepository.findByName("Jyrsijät").get(0)));
			rrepository.save(new Room("M-1", 15, 15, rkrepository.findByName("Matelijat").get(0)));
			rrepository.save(new Room("L-1", 15, 15, rkrepository.findByName("Linnut").get(0)));
			rrepository.save(new Room("NN", 0, 0, rkrepository.findByName("No room").get(0)));
			
			akrepository.save(new AnimalKind("Kissa"));
			akrepository.save(new AnimalKind("Koira"));
			akrepository.save(new AnimalKind("Kani"));
			akrepository.save(new AnimalKind("Jyrsijä"));
			akrepository.save(new AnimalKind("Matelija"));
			akrepository.save(new AnimalKind("Lintu"));
			akrepository.save(new AnimalKind("Muu"));
			
			brepository.save(new Breed("Mopsi"));
			brepository.save(new Breed("Sekarotu"));
			brepository.save(new Breed("Persi"));
			brepository.save(new Breed("Marsu"));
			brepository.save(new Breed("Hiirihamsteri"));
			brepository.save(new Breed("Siperian maaorava"));
			brepository.save(new Breed("Kilpikonna"));
			brepository.save(new Breed("Popukaija"));
			brepository.save(new Breed("Belgianjätti"));
			
			srepository.save(new Sex("uros"));
			srepository.save(new Sex("naaras"));
			srepository.save(new Sex("epäselvä")); 
			
			drepository.save(new DepartureCause("Vanha omistaja löytynyt"));
			drepository.save(new DepartureCause("Uusi omistaja löytynyt"));
			drepository.save(new DepartureCause("Eutanasia"));
			
			Date dd = df.parse("23-04-2019");
			
			arepository.save(new Animal("Koira2019-1","musta värinen, arvioitu noin 3 vuotta vanha, valkoinen kaulus", dd, akrepository.findByName("Koira").get(0), rrepository.findByName("PK-1").get(0), brepository.findByName("Mopsi").get(0), srepository.findByName("naaras").get(0)));
			arepository.save(new Animal("Kissa2019-1","musta värinen, arvioitu noin 3 vuotta vanha, valkoinen kaulus", dd, akrepository.findByName("Kissa").get(0), rrepository.findByName("K-1").get(0), brepository.findByName("Persi").get(0), srepository.findByName("naaras").get(0)));
			arepository.save(new Animal("Kani2019-1","valkoinen, massiivinen, korkea ja pitkärunkoinen kani isoilla korvilla, noin 7 kg", dd, akrepository.findByName("Kani").get(0), rrepository.findByName("Kk-1").get(0), brepository.findByName("Belgianjätti").get(0), srepository.findByName("epäselvä").get(0)));
			arepository.save(new Animal("Jyrsijä2019-1","ruskea, arvioitu noin 2 vuotta vanha, painaa noin 1,8 kg.", dd, akrepository.findByName("Jyrsijä").get(0), rrepository.findByName("J-1").get(0), brepository.findByName("Marsu").get(0), srepository.findByName("naaras").get(0)));
			arepository.save(new Animal("Matelija2019-1","kotikilpikonna, arvon mukaan noin 10 vuotta vanha", dd, akrepository.findByName("Matelija").get(0), rrepository.findByName("M-1").get(0), brepository.findByName("Kilpikonna").get(0), srepository.findByName("epäselvä").get(0)));
			arepository.save(new Animal("Lintu2019-1","vihreä-keltainen, terve ja hyvinvoiva papukaija, arvioitu noin 5 vuotta vanha, osaa sanoa 'terve'", dd, akrepository.findByName("Lintu").get(0), rrepository.findByName("L-1").get(0), brepository.findByName("Popukaija").get(0), srepository.findByName("uros").get(0)));
			arepository.save(new Animal("Jyrsijä2019-2","harmahtava, suuret kovat ja pitkä karvainen häntä jonka päässä on tupsumaista karvaa, noin 8cm pitkä, ruumis  noin 7cm, ruumiin karva on melko pitkää ja pehmeää, vatsapuoli on vaalea,4 vuotta vanha", dd, akrepository.findByName("Jyrsijä").get(0), rrepository.findByName("J-1").get(0), brepository.findByName("Hiirihamsteri").get(0), srepository.findByName("uros").get(0)));
			arepository.save(new Animal("Jyrsijä2019-3","ruskea, painaa 60 g, sen ruumis on 13 cm pitkä ja tuuhea häntä on lähes yhtä pitkä, selässä kulkee pituussuunnassa viisi mustaa raitaa hiekanruskealla pohjalla, vatsapuoli on vaalea", dd, akrepository.findByName("Jyrsijä").get(0), rrepository.findByName("J-2").get(0), brepository.findByName("Siperian maaorava").get(0), srepository.findByName("uros").get(0)));
			
			
			// Create users: admin/adminadmin user/useruser
						User user1 = new User("user", "$2a$04$hFxjj6Y41fiP9RuaP5./feAR6G99wZGcNE8DuLnnGgmXFQ8QRbtxS", "user@test.fi", "USER");
						User user2 = new User("admin", "$2a$04$p/JiAezhcjGaxz.SuR48z.4rA6UmrSFWVKuyRZTefpgS7j7mx1RAq", "ADMIN");
						urepository.save(user1);
						urepository.save(user2);
		
		};
	}
	

}
		

