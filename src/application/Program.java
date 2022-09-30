package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation;

public class Program {

	//throws ParseException método main não precisa tratar o tipo de exceção do parse
	//Ou tratar a exceção com try catch
	public static void main(String[] args) throws ParseException {
		
		Scanner sc = new Scanner(System.in);		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.print("Room number: ");
		int roomNumber = sc.nextInt();
		
		System.out.print("Check - in date (dd/MM/yyyy): ");
		Date checkIn = sdf.parse(sc.next());
		
		System.out.print("Check - out date (dd/MM/yyyy): ");
		Date checkOut = sdf.parse(sc.next());
	
	//Verificar e tratar a data de entrada não pode ser posterior a de saída (método after)
		
		//Se a data chekout não for depois do checkin é preciso parar o programa
		if(!checkOut.after(checkIn)) {
			System.out.println("Error in reservation: Check-out date must be after check-in date");
		}
		else {
			
			Reservation res = new Reservation(roomNumber, checkIn, checkOut);
			
			System.out.println("Reservation: " + res.toString());
			
			System.out.println();
			System.out.println("Enter data to update the reservation:");
			System.out.println("Check - in date (dd/MM/yyyy): ");
			checkIn = sdf.parse(sc.next());
			System.out.print("Check - out date (dd/MM/yyyy): ");
			checkOut = sdf.parse(sc.next());
			
	//Para atualizar as datas	
			//Para as datas serem somente futuras
			
			Date now = new Date();
			if(checkIn.before(now) || checkOut.before(now)) {
				System.out.println("Reservation dates for update must be future dates");
			}
			else if(!checkOut.after(checkIn)) {
				System.out.println("Error in reservation: Check-out date must be after check-in date");
			}
			else {
				res.updateDates(checkIn, checkOut);
				System.out.println("Reservation: " + res);
			}
			
			
		}
		
	
		sc.close();
	}

}

