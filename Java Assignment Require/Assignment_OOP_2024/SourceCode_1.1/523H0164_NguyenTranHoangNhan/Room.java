public class Room {
    private int ID_Room;
    private String name_Room;
    private int floor_number_Room;
    private String genre_Room;
    private int bed_number_Room;
    private int maximum_peoples_Room;
    private double floor_area_Room;
    private double price_night_Room;

    public Room(int iD_Room, String name_Room, int floor_number_Room, String genre_Room, int bed_number_Room,
            int maximum_peoples_Room, double floor_area_Room, double price_night_Room) {
        this.ID_Room = iD_Room;
        this.name_Room = name_Room;
        this.floor_number_Room = floor_number_Room;
        this.genre_Room = genre_Room;
        this.bed_number_Room = bed_number_Room;
        this.maximum_peoples_Room = maximum_peoples_Room;
        this.floor_area_Room = floor_area_Room;
        this.price_night_Room = price_night_Room;
    }

    public int getID_Room() {
        return ID_Room;
    }

    public void setID_Room(int iD_Room) {
        ID_Room = iD_Room;
    }

    public String getName_Room() {
        return name_Room;
    }

    public void setName_Room(String name_Room) {
        this.name_Room = name_Room;
    }

    public int getFloor_number_Room() {
        return floor_number_Room;
    }

    public void setFloor_number_Room(int floor_number_Room) {
        this.floor_number_Room = floor_number_Room;
    }

    public String getGenre_Room() {
        return genre_Room;
    }

    public void setGenre_Room(String genre_Room) {
        this.genre_Room = genre_Room;
    }

    public int getBed_number_Room() {
        return bed_number_Room;
    }

    public void setBed_number_Room(int bed_number_Room) {
        this.bed_number_Room = bed_number_Room;
    }

    public int getMaximum_peoples_Room() {
        return maximum_peoples_Room;
    }

    public void setMaximum_peoples_Room(int maximum_peoples_Room) {
        this.maximum_peoples_Room = maximum_peoples_Room;
    }

    public double getFloor_area_Room() {
        return floor_area_Room;
    }

    public void setFloor_area_Room(double floor_area_Room) {
        this.floor_area_Room = floor_area_Room;
    }

    public double getPrice_night_Room() {
        return price_night_Room;
    }

    public void setPrice_night_Room(double price_night_Room) {
        this.price_night_Room = price_night_Room;
    }

    @Override
    public String toString() {
        return "Room [" + ID_Room + ", " + name_Room + ", " + floor_number_Room
                + ", " + genre_Room + ", " + bed_number_Room + ", "
                + maximum_peoples_Room + ", " + floor_area_Room + ", "
                + price_night_Room + "]";
    }
}
