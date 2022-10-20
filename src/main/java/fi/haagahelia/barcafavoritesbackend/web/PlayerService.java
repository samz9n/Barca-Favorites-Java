package fi.haagahelia.barcafavoritesbackend.web;

import java.util.List;

import org.springframework.stereotype.Service;

import fi.haagahelia.barcafavoritesbackend.domain.Player;

@Service
public interface PlayerService {
	public Player savePlayer(Player player);

	public List<Player> getPlayers();
}
