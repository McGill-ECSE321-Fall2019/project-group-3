package com.ecse321.group3.tutorME.domain;

import com.ecse321.group3.tutorME.domain.enums.Availabilities;
import com.ecse321.group3.tutorME.domain.enums.RoomSize;

import javax.persistence.*;

@Entity
@Table(name="room")
public class Room {

	@Id
	@Column
	private int room_id;

	@Column
	private int numberOfSeats;

	@Enumerated(EnumType.STRING)
	@Column
	private Availabilities roomAvailability;

	@Enumerated(EnumType.STRING)
	@Column
	private RoomSize size;

	@OneToOne(mappedBy = "room")
	private Lesson lesson;

	public Room() {}

	public Room(int room_id, int numberOfSeats, Availabilities roomAvailability, RoomSize size, Lesson lesson) {
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
	public Availabilities getRoomAvailability() {
		return roomAvailability;
	}
	public void setRoomAvailability(Availabilities roomAvailability) {
		this.roomAvailability = roomAvailability;
	}
	public RoomSize getSize() {
		return size;
	}
	public void setSize(RoomSize size) {
		this.size = size;
	}

	public Lesson getLesson() {
		return lesson;
	}

	public void setLesson(Lesson lesson) {
		this.lesson = lesson;
	}
}
