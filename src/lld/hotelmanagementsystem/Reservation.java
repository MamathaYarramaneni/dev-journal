package lld.hotelmanagementsystem;

public class Reservation {
    private String id;
    private Guest guest;
    private Room room;
    private LocalDate checkIn;
    private LocalDate checkOut;
    private ReservationStatus reservationStatus;

    Reservation(Guest guest, Room room, LocalDate checkIn, LocalDate checkOut) {
        this.id = generateId();
        this.room = room;
        this.guest = guest;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.reservationStatus = ReservationStatus.CONFIRMED;
    }

    String generateId() {
        return UUID.randomId().toString();
    }

    public synchronized void cancelReservation() {
        if(ReservationStatus.CONFIRMED) {
            this.reservationStatus = ReservationStatus.CANCELLED;
            room.checkOut();
        } else {
            throw new IllegalArgumentException("reservation not confirmed");
        }
    }
}