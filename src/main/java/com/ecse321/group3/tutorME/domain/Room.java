package com.ecse321.group3.tutorME.domain;

import com.ecse321.group3.tutorME.domain.enums.Availabilities;
import com.ecse321.group3.tutorME.domain.enums.RoomSize;

import javax.persistence.*;

@Entity
public class Room {

	@Id
	@Column
	private int roomId;

	@Column
	private int numberOfSeats;

	@Enumerated(EnumType.STRING)
	@Column
	private Availabilities roomAvailability;

	@Enumerated(EnumType.STRING)
	@Column
	private RoomSize size;

	public Room() {}

	public Room(int roomId, int numberOfSeats, Availabilities roomAvailability, RoomSize size) {
		super();
		this.roomId = roomId;
		this.numberOfSeats = numberOfSeats;
		this.roomAvailability = roomAvailability;
		this.size = size;
	}

	public int getRoomId() {
		return roomId;
	}

	public void setRoomId(int roomId) {
		this.roomId = roomId;
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
	
	
	
}
