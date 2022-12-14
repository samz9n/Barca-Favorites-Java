package fi.haagahelia.barcafavoritesbackend.web;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import fi.haagahelia.barcafavoritesbackend.domain.NationalityRepo;
import fi.haagahelia.barcafavoritesbackend.domain.Player;
import fi.haagahelia.barcafavoritesbackend.domain.PlayerRepo;

@Controller
public class PlayerController implements WebMvcConfigurer {
	@Autowired
	PlayerRepo playerRepo;
	@Autowired
	NationalityRepo nationalityRepo;

	// SAVE player (for edit)
	@PostMapping(value = "/player/save")
	public String save(@Valid Player player, BindingResult bindingRes, Model model) {
		if (bindingRes.hasErrors()) {
			model.addAttribute("nationalities", nationalityRepo.findAll());
			return "editplayer";
		}
		playerRepo.save(player);
//		LOCALHOST
//		return "redirect:http://localhost:3000/players";
		return "redirect:https://barcafavorites-frontend.herokuapp.com/players";
	}

	// SAVE NEW player (for adding new player)
	@PostMapping(value = "/player/add")
	public String saveNew(@Valid Player player, BindingResult bindingRes, Model model) {
		if (bindingRes.hasErrors()) {
			model.addAttribute("nationalities", nationalityRepo.findAll());
			return "addplayer";
		}
		playerRepo.save(player);
//		LOCALHOST
//		return "redirect:http://localhost:3000/players";
		return "redirect:https://barcafavorites-frontend.herokuapp.com/players";
	}

	// EDIT player view
	@GetMapping(value = "/player/edit/{id}")
	public String getEditPage(@PathVariable("id") Long id, Model model) {
		model.addAttribute("player", playerRepo.findById(id));
		model.addAttribute("nationalities", nationalityRepo.findAll());
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
