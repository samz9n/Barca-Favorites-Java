package fi.haagahelia.barcafavoritesbackend.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fi.haagahelia.barcafavoritesbackend.domain.Player;
import fi.haagahelia.barcafavoritesbackend.domain.PlayerRepo;

@Service
public class PlayerServiceImpl implements PlayerService {

	@Autowired
	private PlayerRepo playerRepo;

	@Override
	public Player savePlayer(Player player) {
		return playerRepo.save(player);
	}

	@Override
	public List<Player> getPlayers() {
		return (List<Player>) playerRepo.findAll();
	}

}
