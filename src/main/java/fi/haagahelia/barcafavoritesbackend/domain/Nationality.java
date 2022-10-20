package fi.haagahelia.barcafavoritesbackend.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class Nationality {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long nationalityId;
	private String name;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "nationality")
	@JsonIgnoreProperties("nationality")
	private List<Player> players;

	public Nationality() {
		super();
		this.name = "";
	}

	public Nationality(String name) {
		super();
		this.name = name;
	}

	public Long getNationalityId() {
		return nationalityId;
	}

	public void setNationalityId(Long nationalityId) {
		this.nationalityId = nationalityId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Player> getPlayers() {
		return players;
	}

	public void setPlayers(List<Player> players) {
		this.players = players;
	}

	@Override
	public String toString() {
		return "Nationality [nationalityId=" + nationalityId + ", name=" + name + "]";
	}

}
