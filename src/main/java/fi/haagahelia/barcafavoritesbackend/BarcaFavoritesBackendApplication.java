package fi.haagahelia.barcafavoritesbackend;

import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import fi.haagahelia.barcafavoritesbackend.domain.Nationality;
import fi.haagahelia.barcafavoritesbackend.domain.NationalityRepo;
import fi.haagahelia.barcafavoritesbackend.domain.Player;
import fi.haagahelia.barcafavoritesbackend.domain.PlayerRepo;
import fi.haagahelia.barcafavoritesbackend.domain.User;
import fi.haagahelia.barcafavoritesbackend.domain.UserRepository;

@SpringBootApplication
public class BarcaFavoritesBackendApplication {
	private static final org.jboss.logging.Logger log = LoggerFactory.logger(BarcaFavoritesBackendApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(BarcaFavoritesBackendApplication.class, args);
	}

	@Bean
	public CommandLineRunner playerRunner(PlayerRepo playerRepo, NationalityRepo nationalityRepo,
			UserRepository userRepo) {
		return (args) -> {
			log.info("save players");

			Nationality spain = new Nationality("Spain");
			nationalityRepo.save(spain);
			Nationality netherlands = new Nationality("Netherlands");
			nationalityRepo.save(netherlands);
			Nationality germany = new Nationality("Germany");
			nationalityRepo.save(germany);
			Nationality france = new Nationality("France");
			nationalityRepo.save(france);
			Nationality ivorycoast = new Nationality("Ivory Coast");
			nationalityRepo.save(ivorycoast);
			Nationality brasil = new Nationality("Brasil");
			nationalityRepo.save(brasil);
			Nationality denmark = new Nationality("Denmark");
			nationalityRepo.save(denmark);
			Nationality poland = new Nationality("Poland");
			nationalityRepo.save(poland);
			Nationality uruguay = new Nationality("Uruguay");
			nationalityRepo.save(uruguay);

			playerRepo.save(new Player("Marc-André", "ter Stegen", "goalkeeper", 30, 1, germany));
			playerRepo.save(new Player("Inaki", "Pena", "goalkeeper", 23, 26, spain));
			playerRepo.save(new Player("Alex", "Balde", "defender", 19, 28, spain));
			playerRepo.save(new Player("Ronald", "Aurajo", "defender", 23, 4, uruguay));
			playerRepo.save(new Player("Jules", "Kounde", "defender", 23, 23, france));
			playerRepo.save(new Player("Eric", "Garcia", "defender", 21, 24, spain));
			playerRepo.save(new Player("Jordi", "Alba", "defender", 33, 18, spain));
			playerRepo.save(new Player("Andreas", "Christensen", "defender", 26, 15, denmark));
			playerRepo.save(new Player("Gerard", "Pique", "defender", 35, 3, spain));
			playerRepo.save(new Player("Hector", "Bellerin", "defender", 27, 2, spain));
			playerRepo.save(new Player("Marcos", "Alonso", "defender", 31, 17, spain));
			playerRepo.save(new Player("Sergio", "Busquets", "midfielder", 34, 5, spain));
			playerRepo.save(new Player("Frankie", "de Jong", "midfielder", 25, 21, netherlands));
			playerRepo.save(new Player("Pablo", "Gavi", "midfielder", 18, 30, spain));
			playerRepo.save(new Player("Sergi", "Roberto", "midfielder", 30, 20, spain));
			playerRepo.save(new Player("Raphael", "Raphinha", "forward", 25, 22, brasil));
			playerRepo.save(new Player("Ousmane", "Dembele", "forward", 25, 7, france));
			playerRepo.save(new Player("Ansu", "Fati", "forward", 19, 10, spain));
			playerRepo.save(new Player("Robert", "Lewandowski", "forward", 34, 9, poland));
			playerRepo.save(new Player("Memphis", "Depay", "forward", 28, 14, netherlands));
			playerRepo.save(new Player("Ferran", "Torres", "forward", 22, 11, spain));
			playerRepo.save(new Player("Pedro(Pedri)", "Lopez", "midfielder", 19, 8, spain));
			playerRepo.save(new Player("Riqui", "Puig", "midfielder", 23, 6, spain));
			playerRepo.save(new Player("Franck", "Kessie", "midfielder", 25, 19, ivorycoast));

			User user = new User("user", "$2a$10$g.ZCRog6ISBv7mL.SsoIVe1hL0VjtBW/GkDMV/DizZrX.8jbmjNTa",
					"user.test@email.com", "USER");
			User admin = new User("admin", "$2a$10$x1ROXKyHM0x.5IKb3qHeOusgPHqnkK3uYU./6mAJ4rCbinmOalYdS",
					"admin.test@email.com", "ADMIN");
			userRepo.save(user);
			userRepo.save(admin);

			log.info("Fetch all players");
			for (Player player : playerRepo.findAll()) {
				log.info(player.toString());
			}
			log.info("Fetch all users");
			for (User usr : userRepo.findAll()) {
				log.info(usr.toString());
			}
		};
	}
}
