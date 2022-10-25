package fi.haagahelia.barcafavoritesbackend.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fi.haagahelia.barcafavoritesbackend.domain.Player;

@CrossOrigin(maxAge = 3600)
@RestController
@RequestMapping("/api/")
public class PlayerController {

	@Autowired
	PlayerService playerService;

	@GetMapping("/players")
	public List<Player> getPlayers() {
		return playerService.getPlayers();
	}

	@PostMapping("/add")
	public String add(@RequestBody Player player) {
		playerService.savePlayer(player);
		return "Added new player";
	}

	@GetMapping(value = "/test")
	public String indexPage() {
		return "test";
	}
}
