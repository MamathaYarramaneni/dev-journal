package lld.hotelmanagementsystem;

public class HotelManager {
    private static HotelManager instance;
    private final Map<String, Reservation> reservations;
    private final Map<String, Guest> guests;
    private final Map<String, Room> rooms;

    HotelManager() {
        guests = new ConcurrentHashMap<>();
        reservations = new ConcurrentHashMap<>();
        rooms = new ConcurrentHashMap<>();
    }

    public static synchronized HotelManager getInstance() {
        if(this.instance == null) {
            this.instance = new HotelManager();
        }
        return null;
    }

    public void addRoom(Room room) {
        this.rooms.putIfAbsent(room.getId(), room);
    }

    public void getRoom(Room roomId) {
        this.rooms.get(room.getId());
    }

    public void addGuest(Guest guest) {
        this.guests.putIfAbsent(guest.getId(), guest);
    }

    public synchronized Reservation bookRoom(Room room, Guest guest, LocalDate checkinDate, LocalDate checkoutDate) {
        if(room.getStatus() == RoomStatus.AVAILABLE) {
            room.bookRoom();
            Reservation reservation = new Reservation(guest, room, checkinDate, checkoutDate);
            this.reservations.put(reservation.getId(), reservation);
        }
        return null;
    }

    public synchronized void cancelReservation(String reservationId) {
        Reservation reservation = reservations.get(reservationId);
        if(reservation != null) {
            reservation.cancel();
            reservations.remove(reservationId);
        }
    }

    public synchronized void checkIn(String reservationId) {
        Reservation reservation = this.reservations.get(reservationId);
        if(reservation != null && reservation.getStatus()  == Reservation.CONFIRMED) {
            reservation.getRoom().checkIn();
        } else {
            throw new IllegalArgumentException("reservation not confirmed");
        }
    }

    public synchronized void checkOut(String reservationId) {
        Reservation reservation = this.reservations.get(reservationId);
        if(reservation != null && reservation.getStatus()  == Reservation.CONFIRMED) {
            reservation.getRoom().checkOut();
        } else {
            throw new IllegalArgumentException("reservation not confirmed");
        }
    }
}