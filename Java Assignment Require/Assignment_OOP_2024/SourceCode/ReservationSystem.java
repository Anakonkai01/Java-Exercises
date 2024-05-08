import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class ReservationSystem {
    private ArrayList<Accommodation> accommodations;

    // Requirement 1: Load data
    public ReservationSystem(String accPath, String roomPath, String roomOfAccPath) {
        this.accommodations = loadAccommodations(accPath, roomPath, roomOfAccPath);
    }

    public ArrayList<Accommodation> getAccommodations() {
        return accommodations;
    }

    // Requirement 1
    public ArrayList<Accommodation> loadAccommodations(String accPath, String roomPath, String roomOfAccPath) {
        ArrayList<Accommodation> acc = new ArrayList<>();
        try{
            BufferedReader reader = new BufferedReader(new FileReader(accPath));
            String line;
            while((line = reader.readLine()) != null){
                String[] parts = line.split(",");
                int numberArgument = parts.length; 
                switch(numberArgument) {
                    case 5: 
                        acc.add(new Homestay(Integer.parseInt(parts[0]), parts[1], parts[2], parts[3], Float.parseFloat(parts[4])));
                        break;
                    case 7:
                        boolean convertYesNo = parts[5].equals("yes");
                        acc.add(new Resort(Integer.parseInt(parts[0]), parts[1], parts[2], parts[3],Float.parseFloat(parts[6]),Integer.parseInt(parts[4]),convertYesNo));
                        break;
                    case 6:
                        acc.add(new Hotel(Integer.parseInt(parts[0]), parts[1], parts[2], parts[3],Float.parseFloat(parts[5]),Integer.parseInt(parts[4])));
                        break;
                    case 10:
                        boolean convertYesNo_pool = parts[4].equals("yes");
                        boolean convertYesNo_Drink = parts[5].equals("yes");
                        boolean convertYesNo_Breakfast = parts[6].equals("yes");
                        boolean convertYesNo_Gym = parts[7].equals("yes");
                        acc.add(new Villa(Integer.parseInt(parts[0]), parts[1], parts[2], parts[3], convertYesNo_pool, convertYesNo_Drink, convertYesNo_Breakfast, convertYesNo_Gym, Integer.parseInt(parts[8]), Integer.parseInt(parts[9])));
                        break;
                    case 11:
                        convertYesNo_pool = parts[4].equals("yes");
                        convertYesNo_Drink = parts[5].equals("yes");
                        convertYesNo_Breakfast = parts[6].equals("yes");
                        convertYesNo_Gym = parts[7].equals("yes");
                        boolean convertYesNo_Bar = parts[8].equals("yes");
                        acc.add(new CruiseShip(Integer.parseInt(parts[0]), parts[1], parts[2], parts[3], convertYesNo_pool, convertYesNo_Drink, convertYesNo_Breakfast, convertYesNo_Gym,Integer.parseInt(parts[9]), Integer.parseInt(parts[10]),convertYesNo_Bar));
                        break;
                }
            }
            reader.close();
        }
        catch(IOException e){
            System.out.println("Error Req1: " + e.getMessage());
        }
        return acc;
    }


    // Requirement 2
    public ArrayList<Accommodation> searchForRoom(String city, int numOfPeople) {
        /* Code here */
        return null;
    }

    // Requirement 3
    public ArrayList<Accommodation> searchForRoomByRange(String reservationPath, double priceFrom, double priceTo,
            Date checkin, Date checkout, String city, int numOfPeople) {
        /* Code here */
        return null;
    }

    // Requirement 4
    public ArrayList<Accommodation> searchInAdvance(String city, Integer numOfPeople, String roomType,
            Boolean privatePool, Integer starQuality, Boolean freeBreakfast, Boolean privateBar) {
        /* Code here */
        return null;
    }

    // Requirement 5
    public double performReservation(String reservationPath, Accommodation acc, Room room, Date checkin, Date checkout)
            throws Exception {
        /* Code here */
        return 0.0;
    }

    // Helper functions for req 5
    public long diffBetweenDays(long dateStart, long dateEnd) {
        Date date = new Date(dateStart * 1000);
        Date date1 = new Date(dateEnd * 1000);

        long diff = Math.abs(date1.getTime() - date.getTime());
        long numOfDays = TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
        return numOfDays;
    }
}
