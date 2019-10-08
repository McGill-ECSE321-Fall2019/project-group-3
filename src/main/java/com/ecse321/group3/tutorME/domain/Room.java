package com.ecse321.group3.tutorME.domain;

import com.ecse321.group3.tutorME.domain.enums.Availabilities;
import com.ecse321.group3.tutorME.domain.enums.RoomSize;

public class Room {
	private int numberOfSeats;
	private Availabilities roomAvailability;
	private RoomSize size;
	public Room() {}
	public Room(int numberOfSeats, Availabilities roomAvailability, RoomSize size) {
		super();
		this.numberOfSeats = numberOfSeats;
		this.roomAvailability = roomAvailability;
		this.size = size;
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
