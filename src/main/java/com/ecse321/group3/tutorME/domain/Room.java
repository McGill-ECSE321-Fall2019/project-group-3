package com.ecse321.group3.tutorME.domain;

import com.ecse321.group3.tutorME.domain.enums.RoomSize;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="room")
public class Room {

	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int room_id;

	@Column
	private int numberOfSeats;

	@OneToOne
	private Schedule roomAvailability;

	@Enumerated(EnumType.STRING)
	@Column
	private RoomSize size;

	@OneToMany(mappedBy = "room")
    @JsonManagedReference(value = "room-lesson")
	private List<Lesson> lesson;

	public Room() {}

	public Room(int room_id, int numberOfSeats, Schedule roomAvailability, RoomSize size, List<Lesson> lesson) {
		super();
		this.room_id = room_id;
		this.numberOfSeats = numberOfSeats;
		this.roomAvailability = roomAvailability;
		this.size = size;
		this.lesson = lesson;
	}

	public int getRoom_id() {
		return room_id;
	}

	public void setRoom_id(int room_id) {
		this.room_id = room_id;
	}

	public int getNumberOfSeats() {
		return numberOfSeats;
	}
	public void setNumberOfSeats(int numberOfSeats) {
		this.numberOfSeats = numberOfSeats;
	}
	public Schedule getRoomAvailability() {
		return roomAvailability;
	}
	public void setRoomAvailability(Schedule roomAvailability) {
		this.roomAvailability = roomAvailability;
	}
	public RoomSize getSize() {
		return size;
	}
	public void setSize(RoomSize size) {
		this.size = size;
	}

	public List<Lesson> getLesson() {
		return lesson;
	}

	public void setLesson(List<Lesson> lesson) {
		this.lesson = lesson;
	}
}
