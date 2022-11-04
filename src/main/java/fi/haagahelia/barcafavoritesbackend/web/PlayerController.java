package fi.haagahelia.barcafavoritesbackend.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import fi.haagahelia.barcafavoritesbackend.domain.NationalityRepo;
import fi.haagahelia.barcafavoritesbackend.domain.Player;
import fi.haagahelia.barcafavoritesbackend.domain.PlayerRepo;

@Controller
public class PlayerController {
	@Autowired
	PlayerRepo playerRepo;
	@Autowired
	NationalityRepo nationalityRepo;

	// SAVE player (for edit)
	@PostMapping(value = "/player/save")
	public String save(Player player) {
		playerRepo.save(player);
		return "redirect:http://localhost:3000/players";
	}

	// EDIT player view
	@GetMapping(value = "/player/edit/{id}")
	public String getEditPage(@PathVariable("id") Long id, Model model) {
		model.addAttribute("player", playerRepo.findById(id));
		return "editplayer";
	}

	// ADD new player
	@GetMapping(value = "/player/add")
	public String addPlayer(Model model) {
		model.addAttribute("player", new Player());
		model.addAttribute("nationalities", nationalityRepo.findAll());
		return "addplayer";
	}
}
