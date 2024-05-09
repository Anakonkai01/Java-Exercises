import java.util.*;
import java.util.concurrent.TimeUnit;
import java.io.*;

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
            BufferedReader reader1 = new BufferedReader(new FileReader(accPath));
            String line;
            while((line = reader1.readLine()) != null){
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
                    default:
                        System.out.println("Error Req1: Wrong number of arguments");
                        break;
                }
            }
            reader1.close();
        }
        catch(IOException e){
            System.out.println("Error reader1 Req1: " + e.getMessage());
            e.printStackTrace();
        }

        // add room
        ArrayList<Room> rooms = new ArrayList<>(); 
        try{
            BufferedReader reader2 = new BufferedReader(new FileReader(roomPath));
            String line;
            while ((line = reader2.readLine()) != null) {
                String[] parts = line.split(","); 
                rooms.add(new Room(Integer.parseInt(parts[0]), parts[1], Integer.parseInt(parts[2]),
                                    parts[3], Integer.parseInt(parts[4]), Integer.parseInt(parts[5]),
                                    Double.parseDouble(parts[6]), Double.parseDouble(parts[7])));
            }
            reader2.close();
        } catch (IOException e) {
            System.out.println("Error reader2 req1");
            e.printStackTrace();
        }

        // add room of accommodation
        try{
            BufferedReader reader3 = new BufferedReader(new FileReader(roomOfAccPath));
            String line;

            HashMap<Integer, ArrayList<Integer>> roomMap = new HashMap<>();

            while((line = reader3.readLine()) != null){
                String[] parts = line.split(",");

                int key = Integer.parseInt(parts[0]);
                int value = Integer.parseInt(parts[1]);

                if (roomMap.containsKey(key)) {
                    roomMap.get(key).add(value);
                } else {
                    ArrayList<Integer> list = new ArrayList<>();
                    list.add(value);
                    roomMap.put(key, list);
                }
            }
            reader3.close();
            for (Integer key : roomMap.keySet()) {
                ArrayList<Room> tempRoom = new ArrayList<>();
                for(Accommodation a : acc){
                    if(a.getID_Accommodation() == key){
                        for(Integer value : roomMap.get(key)){
                            for(Room r : rooms){
                                if(r.getID_Room() == value){
                                    tempRoom.add(r);
                                }
                            }
                        }
                        CommonAccommodation b = (CommonAccommodation) a;
                        b.setRooms(tempRoom);
                    }
                }
            }
        }
        catch (IOException e){
            System.out.println("Error reader3 req1");
            e.printStackTrace();
        }
        
        return acc;
    }


    // Requirement 2
    public ArrayList<Accommodation> searchForRoom(String city, int numOfPeople) {
        ArrayList<Accommodation> result = new ArrayList<>();
        ArrayList<Accommodation> luxury = new ArrayList<>();
        ArrayList<Accommodation> common = new ArrayList<>();

        for(Accommodation a : accommodations){
            if(a.city_Accommodation.equals(city)){
                if(a instanceof CommonAccommodation){
                    CommonAccommodation b  = (CommonAccommodation) a;
                    // tong toan bo people trong tat ca cac room
                    for(Room room : b.rooms){
                        if(room.getMaximum_peoples_Room() >= numOfPeople){
                            common.add(b);
                            break;
                        }
                    }
                }
                else{
                    LuxuryAccommodation b = (LuxuryAccommodation) a;
                    if(b.getMaximum_people_can_serve_LuxuryAccommodation() >= numOfPeople){
                        luxury.add(b);
                    }
                }
            }
        }
        Collections.sort(luxury, new Comparator<Accommodation>() {
            @Override
            public int compare(Accommodation a1, Accommodation a2) {
                return a1.getName_Accommodation().compareTo(a2.getName_Accommodation());
            }
        });

        // sort
        Collections.sort(common, new Comparator<Accommodation>() {
            @Override
            public int compare(Accommodation a1, Accommodation a2) {
                return a1.getName_Accommodation().compareTo(a2.getName_Accommodation());
            }
        });
        result.addAll(luxury);
        result.addAll(common);
        return result;
    }

    // Requirement 3
    public ArrayList<Accommodation> searchForRoomByRange(String reservationPath, double priceFrom, double priceTo,
            Date checkin, Date checkout, String city, int numOfPeople) {
        
        ArrayList<Accommodation> result = new ArrayList<>();
        ArrayList<ReservatedRoom> reservatedRooms = new ArrayList<>();
        
        // input data from reservation_3 to ArrayList
        try{
            BufferedReader reader = new BufferedReader(new FileReader(reservationPath));
            String line;
            while((line = reader.readLine()) != null){
                String[] parts = line.split(",");
                int numberArgument = parts.length;
                switch (numberArgument) {
                    case 4:
                        reservatedRooms.add(new ReservatedRoom(Integer.parseInt(parts[0]), Integer.parseInt(parts[1]), Long.parseLong(parts[2]), Long.parseLong(parts[3])));
                        break;
                    case 5:
                        reservatedRooms.add(new ReservatedRoom(Integer.parseInt(parts[0]), Integer.parseInt(parts[1]),Integer.parseInt(parts[2]), Long.parseLong(parts[3]), Long.parseLong(parts[4])));
                        break;
                    default:
                        System.out.println("Error, invalid number of argument req3");
                        break;
                }
            }
            reader.close();
        }
        catch(IOException e) {
            System.out.println("Error reader req3");
        }

        // find the accommodation for req3
        for(Accommodation a : accommodations) {
            if(a.city_Accommodation.equals(city)) {
                // luxury instance
                if(a instanceof LuxuryAccommodation){
                    LuxuryAccommodation b = (LuxuryAccommodation) a;
                    if(b.price_night_LuxuryAccommodation >= priceFrom && b.price_night_LuxuryAccommodation <= priceTo){
                        if(b.maximum_people_can_serve_LuxuryAccommodation <= 2 || b.maximum_people_can_serve_LuxuryAccommodation <= numOfPeople){
                            for(ReservatedRoom reRoom : reservatedRooms) {
                                // check ID Accommodation and check room == -1
                                if((reRoom.ID_accommodation == b.ID_Accommodation) && (reRoom.ID_room == -1)){
                                    Date start = new Date(reRoom.timestampStart * 1000);
                                    Date end = new Date(reRoom.timestampEnd * 1000);

                                    boolean checkOverlap = start.before(checkout) && end.after(checkin);
                                    if(checkOverlap){
                                        result.add(b);
                                    }
                                }
                                else{
                                    result.add(b);
                                }
                            }
                        }
                    }
                }
                // commonAccommodation instance
                else{
                    CommonAccommodation b = (CommonAccommodation) a;
                    for(Room room : b.getRooms()){
                        if(room.getPrice_night_Room() >= priceFrom && room.getPrice_night_Room() <= priceTo){
                            if(room.getMaximum_peoples_Room() <= 2 || room.getMaximum_peoples_Room() <= numOfPeople){
                                for(ReservatedRoom reRoom : reservatedRooms) {
                                    // check ID Accommodation and check room == -1
                                    if((reRoom.ID_accommodation == b.ID_Accommodation) && (reRoom.ID_room == room.getID_Room())){
                                        Date start = new Date(reRoom.timestampStart * 1000);
                                        Date end = new Date(reRoom.timestampEnd * 1000);
                                        
                                        System.out.println(b.getRooms());

                                        boolean checkOverlap = start.before(checkout) && end.after(checkin);
                                        if(checkOverlap){
                                            result.add(b);
                                        }
                                    }
                                    else{
                                        result.add(b);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        // make it become unique solution
        Set<Integer> idSet = new HashSet<>();
        ArrayList<Accommodation> uniqueResult = new ArrayList<>();
        for (Accommodation a : result) {
            if (idSet.add(a.ID_Accommodation)) {
                uniqueResult.add(a);
            }
        }

        // sort 
        Collections.sort(uniqueResult, new Comparator<Accommodation>() {
            @Override
            public int compare(Accommodation a1, Accommodation a2) {
                return a1.getName_Accommodation().compareTo(a2.getName_Accommodation());
            }
        });

        return uniqueResult;
    }
    //static class for Requirement 3
    static class ReservatedRoom {
        private int ID_reservation;
        private int ID_accommodation;
        private int ID_room;
        private long timestampStart;
        private long timestampEnd;

        public ReservatedRoom(int ID_reservation, int ID_accommodation, int ID_room, long timestampStart,
                              long timestampEnd) {
            this.ID_reservation = ID_reservation;
            this.ID_accommodation = ID_accommodation;
            this.ID_room = ID_room;
            this.timestampStart = timestampStart;
            this.timestampEnd = timestampEnd;
        }

        
        public ReservatedRoom(int iD_reservation, int iD_accommodation, long timestampStart, long timestampEnd) {
            ID_reservation = iD_reservation;
            ID_accommodation = iD_accommodation;
            this.timestampStart = timestampStart;
            this.timestampEnd = timestampEnd;
            this.ID_room = -1; // if luxury => room  == -1
        }


        @Override
        public String toString() {
            return "ReservatedRoom [ID_reservation=" + ID_reservation + ", ID_accommodation=" + ID_accommodation
                    + ", ID_room=" + ID_room + ", timestampStart=" + timestampStart + ", timestampEnd=" + timestampEnd
                    + "]";
        }   
        
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
