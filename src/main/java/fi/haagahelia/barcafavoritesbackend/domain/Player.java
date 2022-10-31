package fi.haagahelia.barcafavoritesbackend.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "players")
public class Player {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long playerId;
	private String firstName;
	private String lastName;
	private String position;
	private Integer age;
	private Integer shirtNumber;

	@ManyToOne
	@JoinColumn(name = "nationalityid")
	@JsonIgnoreProperties("players")
	private Nationality nationality;

	public Player() {
		super();
		this.firstName = "";
		this.lastName = "";
		this.position = "";
		this.age = null;
		this.shirtNumber = null;
		this.nationality = null;
	}

	public Player(String firstName, String lastName, String position, Integer age, Integer shirtNumber,
			Nationality nationality) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.position = position;
		this.age = age;
		this.shirtNumber = shirtNumber;
		this.nationality = nationality;
	}

	public Long getPlayerId() {
		return playerId;
	}

	public void setPlayerId(Long playerId) {
		this.playerId = playerId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Nationality getNationality() {
		return nationality;
	}

	public void setNationality(Nationality nationality) {
		this.nationality = nationality;
	}

	public Integer getShirtNumber() {
		return shirtNumber;
	}

	public void setShirtNumber(Integer shirtNumber) {
		this.shirtNumber = shirtNumber;
	}

	@Override
	public String toString() {
		if (this.nationality != null) {
			return "Player [playerId=" + playerId + ", firstName=" + firstName + ", lastName=" + lastName
					+ ", position=" + position + ", age=" + age + ", shirtNumber=" + shirtNumber + ", nationality="
					+ this.getNationality() + "]";
		} else {
			return "Player [playerId=" + playerId + ", firstName=" + firstName + ", lastName=" + lastName
					+ ", position=" + position + ", age=" + age + ", shirtNumber=" + shirtNumber + "]";
		}
	}

}
