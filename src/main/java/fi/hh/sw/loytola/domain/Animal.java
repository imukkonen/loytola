package fi.hh.sw.loytola.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Animal {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO) 
	 private long animalId;
	 private String name;
	 private String description;
	 
	 private Date foundDate;
	 private Date disapDate;
	 private Date departureDate;
	 private int theme; //0- kadonnut, 1- löytänyt
	 private int status; //1- hyväksytty, 0 - ei hyväksytty
	 private String uname; //ilmoittajan nimi
	 private String phone; //ilmoittajan puhelin numero
	 
	 
	 @ManyToOne
	 @JsonIgnore
	  @JoinColumn(name = "animalKindId")
	 private AnimalKind animalKind;
	 
	 @ManyToOne
	 @JsonIgnore
	  @JoinColumn(name = "roomId")
	 private Room room;
	 
	 @ManyToOne
	 @JsonIgnore
	  @JoinColumn(name = "breedId")
	 private Breed breed;
	 
	 @ManyToOne
	 @JsonIgnore
	  @JoinColumn(name = "sexId")
	 private Sex sex;
	 
	 @ManyToOne
	 @JsonIgnore
	  @JoinColumn(name = "departureCauseId")
	 private DepartureCause departureCause;
	 
	 
	
	 public Animal() {
		super();
			}

	public Animal(String name, String description, Date foundDate, AnimalKind animalKind, Room room, Breed breed,
			Sex sex) {
		super();
		this.name = name;
		this.description = description;
		this.foundDate = foundDate;
		this.status=1;
		this.animalKind = animalKind;
		this.room = room;
		this.breed = breed;
		this.sex = sex;
		this.theme=1;
	}
	
	public Animal(int theme, String name, String description, Date foundDate, AnimalKind animalKind, Breed breed,
			Sex sex, String uname, String phone) {
		super();
		this.theme =theme;
		this.name = name;
		this.description = description;
		this.foundDate = foundDate;
		this.status=0;
		this.animalKind = animalKind;
		this.breed = breed;
		this.sex = sex;
		this.uname=uname;
		this.phone=phone;
		
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Date getDisapDate() {
		return disapDate;
	}

	public void setDisapDate(Date disapDate) {
		this.disapDate = disapDate;
	}

	public int getTheme() {
		return theme;
	}

	public void setTheme(int theme) {
		this.theme = theme;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public AnimalKind getAnimalKind() {
		return animalKind;
	}

	public void setAnimalKind(AnimalKind animalKind) {
		this.animalKind = animalKind;
	}

	public Room getRoom() {
		return room;
	}

	public void setRoom(Room room) {
		this.room = room;
	}

	public Breed getBreed() {
		return breed;
	}

	public void setBreed(Breed breed) {
		this.breed = breed;
	}

	public Sex getSex() {
		return sex;
	}

	public void setSex(Sex sex) {
		this.sex = sex;
	}

	public DepartureCause getDepartureCause() {
		return departureCause;
	}

	public void setDepartureCause(DepartureCause departureCause) {
		this.departureCause = departureCause;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getAnimalId() {
		return animalId;
	}

	public void setAnimalId(long animalId) {
		this.animalId = animalId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getFoundDate() {
		return foundDate;
	}

	public void setFoundDate(Date foundDate) {
		this.foundDate = foundDate;
	}

	public Date getDepartureDate() {
		return departureDate;
	}

	public void setDepartureDate(Date departureDate) {
		this.departureDate = departureDate;
	}
	 
	 
	 
	 
}
