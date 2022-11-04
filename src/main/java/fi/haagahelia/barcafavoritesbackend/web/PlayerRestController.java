package fi.haagahelia.barcafavoritesbackend.web;

import java.net.URISyntaxException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import fi.haagahelia.barcafavoritesbackend.domain.Player;
import fi.haagahelia.barcafavoritesbackend.domain.PlayerRepo;

@RestController
//@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping(value = "/api/", method = RequestMethod.GET)
public class PlayerRestController {

	@Autowired
	PlayerRepo playerRepo;

	// GET ALL PLAYERS RESTful
	@GetMapping("/players")
	public List<Player> getPlayers() {
		return (List<Player>) playerRepo.findAll();
	}

	// GET PLAYER RESTful
	@GetMapping("/player/{id}")
	public Player getPlayer(@PathVariable Long id) {
		return playerRepo.findById(id).orElseThrow(RuntimeException::new);
	}

	// ADD NEW PLAYER RESTful
	@PostMapping("/player/new")
	public @ResponseBody Player newPlayer(@RequestBody Player player) throws URISyntaxException {
		return playerRepo.save(player);
	}

	// UPDATE/EDIT PLAYER RESTful
	@PutMapping("/player/{id}")
	// @PreAuthorize("hasAuthority('ADMIN')")
	public @ResponseBody Player updatePlayer(@PathVariable Long id, @RequestBody Player player) {
		Player currentPlayer = playerRepo.findById(id).orElseThrow(RuntimeException::new);
		currentPlayer.setFirstName(player.getFirstName());
		currentPlayer.setLastName(player.getLastName());
		currentPlayer.setPosition(player.getPosition());
		currentPlayer.setAge(player.getAge());
		currentPlayer.setShirtNumber(player.getShirtNumber());
		currentPlayer.setNationality(player.getNationality());

		return playerRepo.save(currentPlayer);
	}

	// DELETE PLAYER RESTful
	@DeleteMapping("/player/{id}")
	// @PreAuthorize("hasAuthority('ADMIN')")
	public void deletePlayer(@PathVariable Long id) {
		playerRepo.deleteById(id);
	}

}
