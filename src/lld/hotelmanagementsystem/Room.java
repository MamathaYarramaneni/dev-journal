package lld.hotelmanagementsystem;

public class Room {
    private String id;
    private RoomType roomType;
    private RoomStatus roomStatus;

    Guest(RoomType roomType) {
        this.id = generateId();
        this.roomType = name;
        this.roomStatus = RoomStatus.AVAILABLE;
    }

    public RoomStatus getRoomStatus() {
        return roomStatus;
    }

    public synchronized void bookRoom() {
        if(this.roomStatus == RoomStatus.AVAILABLE) {
            this.roomStatus = RoomStatus.BOOKED;
        } else {
            throw new IllegalStateException("Room not available");
        }
    }

    public synchronized void checkIn() {
        if(this.roomStatus == RoomStatus.BOOKED) {
            this.roomStatus = RoomStatus.OCCUPIED;
        } else {
            throw new IllegalStateException("Room not booked");
        }
    }

    public synchronized void checkOut() {
        if(this.roomStatus == RoomStatus.OCCUPIED) {
            this.roomStatus = RoomStatus.AVAILABLE;
        } else {
            throw new IllegalStateException("Room is not occupied");
        }
    }
}