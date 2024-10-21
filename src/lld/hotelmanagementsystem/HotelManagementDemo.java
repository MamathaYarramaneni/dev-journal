package lld.hotelmanagementsystem;

public class HotelManagementDemo {
    HotelManager hotelManager = HotelManager.getInstance();

    Room room1 = new Room('1', );
    Room room2 = new Room('2', );
    Room room3 = new Room('3', );

//    Hotel hotel1 = new Hotel();
//    Hotel hotel2 = new Hotel();

    hotelManager.addRoom(room1);
    hotelManager.addRoom(room2);

    Guest guest1 = new Guest(1, 'MY');
    Guest guest2 = new Guest(2, 'R');

    hotelManager.addGuest(guest1);
    hotelManager.addGuest(guest2);

    // Book room
    LocalDate checkinDate = LocalDate.now();
    LocalDate checkoutDate = checkinDate.plusDays(3);
    Reservation reservation1 = hotelManager.bookRoom(guest1, room1, checkinDate, checkoutDate);

    // check-in
    hotelManager.checkIn(reservation1.getId());
    System.out.println('Check in: ', reservation1.getId());

    // check-out
    hotelManager.checkOut(reservation1.getId());
    System.out.println('Check out: ', reservation1.getId());

    // cancel reservation
    hotelManager.cancelReservation(reservation1.getId());
    System.out.println("Reservation Cancelled: ", reservation1.getId());
}