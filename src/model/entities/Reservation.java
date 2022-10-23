package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import model.exeptions.DomainExecption;

public class Reservation {
	
	private Integer roomNumber;
	private Date checkIn;
	private Date checkOut;
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	//throws DomainException não seria preciso se utilizasse o RuntimeException
	public Reservation(Integer roomNumber, Date checkIn, Date checkOut) throws DomainExecption {

//Programação defensiva: Tratar já no construtor
		if(!checkOut.after(checkIn)) {
			throw new DomainExecption("Error in reservation: Check-out date must be after check-in date");
		}
		this.roomNumber = roomNumber;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}
	public Integer getRoomNumber() {
		return roomNumber;
	}
	public void setRoomNumber(Integer roomNumber) {
		this.roomNumber = roomNumber;
	}
	public Date getCheckIn() {
		return checkIn;
	}
	public Date getCheckOut() {
		return checkOut;
	}

	public long duration() {
		
		long diff = checkOut.getTime() - checkIn.getTime();	
		return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
	}
	
	//throws DomainException será usado para propagar a exceção que será tratada no programa principal com o catch
	
	//throws DomainException não seria preciso se utilizasse o RuntimeException
	public void updateDates(Date checkIn, Date checkOut) throws DomainExecption {
		
		Date now = new Date();
		if(checkIn.before(now) || checkOut.before(now)) {
	
			throw new DomainExecption("Reservation dates for update must be future dates");
		}
		
		if(!checkOut.after(checkIn)) {
			throw new DomainExecption("Error in reservation: Check-out date must be after check-in date");
		}
		
		this.checkIn = checkIn;
		this.checkOut = checkOut;

	}
	
	@Override
	public String toString(){
		return "Room"
			+ roomNumber
			+ ", check-in: "
			+ sdf.format(checkIn)
			+ ", check-out: "
			+ sdf.format(checkOut)
			+ ", "
			+ duration()
			+ " nigths";
		
	}
	

}
