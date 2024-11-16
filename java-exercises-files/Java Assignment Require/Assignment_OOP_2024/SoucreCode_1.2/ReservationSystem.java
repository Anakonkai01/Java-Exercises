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
            // thuc hien map du lieu tu hashmap vao acc
            // toi uu thuat thoan 
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
        
        // for(Accommodation a : acc) {
        //     System.out.println(a);
        //     if(a instanceof CommonAccommodation){
        //         CommonAccommodation b = (CommonAccommodation) a;
        //         System.out.println("---"+b.getRooms());
        //     }
        // }
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
                    for(Room room : b.rooms){
                        if(room.getMaximum_peoples_Room() >= numOfPeople){
                            common.add(b);
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

        ArrayList<Reservation> reservatedRooms = new ArrayList<>();

        // input data from reservation_3 to ArrayList
        try{
            BufferedReader reader = new BufferedReader(new FileReader(reservationPath));
            String line;
            while((line = reader.readLine()) != null){
                String[] parts = line.split(",");
                int numberArgument = parts.length;
                switch (numberArgument) {
                    case 4:
                        long checkinLong = Long.parseLong(parts[2]);
                        long checkoutLong = Long.parseLong(parts[3]);
                        Date checkinDate = new Date(checkinLong);
                        Date checkoutDate = new Date(checkoutLong);
                        reservatedRooms.add(new Reservation(Integer.parseInt(parts[0]), Integer.parseInt(parts[1]),-1,checkinDate, checkoutDate));
                        break;
                    case 5:
                        checkinLong = Long.parseLong(parts[3]);
                        checkoutLong = Long.parseLong(parts[4]);
                        checkinDate = new Date(checkinLong);
                        checkoutDate = new Date(checkoutLong);
                        reservatedRooms.add(new Reservation(Integer.parseInt(parts[0]), Integer.parseInt(parts[1]),Integer.parseInt(parts[2]), checkinDate, checkoutDate));
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
                    if((b.price_night_LuxuryAccommodation >= priceFrom) && (b.price_night_LuxuryAccommodation <= priceTo)){
                        if((numOfPeople + 2 >= b.maximum_people_can_serve_LuxuryAccommodation) && (numOfPeople <= b.maximum_people_can_serve_LuxuryAccommodation)){
                            boolean checkDoesRoom_InResevatedRoom = false;
                            for(Reservation reRoom : reservatedRooms) {
                                // check ID Accommodation and check room == -1
                                if((reRoom.getAccId() == b.ID_Accommodation) && (reRoom.getRoomId() == -1)){
                                    checkDoesRoom_InResevatedRoom = true;
                                    Date start = reRoom.getCheckin();
                                    Date end = reRoom.getCheckout();
                                    boolean checkOverlap = (start.before(checkout) && end.after(checkin)) || (start.equals(checkin) && end.equals(checkout));
                                    if(!checkOverlap){
                                        result.add(b);
                                    }
                                }
                            }
                            if(checkDoesRoom_InResevatedRoom == false){
                                result.add(b);   
                            }
                        }
                    }
                }
                // commonAccommodation instance
                else{ // ay da
                    CommonAccommodation b = (CommonAccommodation) a;
                    for(Room room : b.getRooms()){
                        if(room.getPrice_night_Room() >= priceFrom && room.getPrice_night_Room() <= priceTo){
                            if((numOfPeople + 2 >= room.getMaximum_peoples_Room()) && (numOfPeople <= room.getMaximum_peoples_Room())){
                                boolean checkDoesRoom_InResevated = false;
                                for(Reservation reRoom : reservatedRooms) {
                                    if((reRoom.getAccId() == b.ID_Accommodation) && (reRoom.getRoomId() == room.getID_Room())){
                                        checkDoesRoom_InResevated = true;
                                        Date start = reRoom.getCheckin();
                                        Date end = reRoom.getCheckout();
                                        boolean checkOverlap = (start.before(checkout) && end.after(checkin)) || (start.equals(checkin) && end.equals(checkout));
                                        if(!checkOverlap){
                                            result.add(b);
                                        }
                                    }
                                }
                                if(checkDoesRoom_InResevated == false){
                                    result.add(b);
                                }
                            }
                        }
                    }
                }
            }
        }

        // sort 
        Collections.sort(result, new Comparator<Accommodation>() {
            @Override
            public int compare(Accommodation a1, Accommodation a2) {
                return a2.getName_Accommodation().compareTo(a1.getName_Accommodation());
            }
        });
        
        return result;
    }

    public ArrayList<Accommodation> searchInAdvance(String city, Integer numOfPeople, String roomType,
        Boolean privatePool, Integer starQuality, Boolean freeBreakfast, Boolean privateBar) {
    ArrayList<Accommodation> finalFilter = new ArrayList<>();
    HashSet<Accommodation> luxuryAccommodations = new HashSet<>();
    HashSet<Room> commonRooms = new HashSet<>();

    // Phần 1: Xử lý LuxuryAccommodation
    for (Accommodation a : accommodations) {
        if (a.getCity_Accommodation().equals(city) && a instanceof LuxuryAccommodation) {
            boolean matches = true;

            if (privatePool != null) {
                LuxuryAccommodation la = (LuxuryAccommodation) a;
                if (la.isIs_pool_available_LuxuryAccommodation() != privatePool ||
                        (numOfPeople != null && numOfPeople > la.maximum_people_can_serve_LuxuryAccommodation)) {
                    matches = false;
                }
            }

            if (starQuality != null) {
                if (a instanceof Hotel) {
                    Hotel h = (Hotel) a;
                    if (h.getRating_stars_Hotel() != starQuality) {
                        matches = false;
                    }
                } else if (a instanceof Resort) {
                    Resort r = (Resort) a;
                    if (r.getRating_stars_Resort() != starQuality) {
                        matches = false;
                    }
                } else {
                    matches = false;
                }
            }

            if (freeBreakfast != null) {
                LuxuryAccommodation la = (LuxuryAccommodation) a;
                if (la.isIs_free_breakfast_LuxuryAccommodation() != freeBreakfast) {
                    matches = false;
                }
            }

            if (privateBar != null && a instanceof CruiseShip) {
                CruiseShip cs = (CruiseShip) a;
                if (cs.isIs_private_bar_CruiseShip() != privateBar ||
                        (numOfPeople != null && numOfPeople > cs.getMaximum_people_can_serve_LuxuryAccommodation())) {
                    matches = false;
                }
            }

            if (matches) {
                luxuryAccommodations.add(a);
            }
        }
    }

    // Phần 2: Xử lý CommonAccommodation (Hotel, Resort)
    for (Accommodation a : accommodations) {
        if (a.getCity_Accommodation().equals(city) && a instanceof CommonAccommodation) {
            CommonAccommodation b = (CommonAccommodation) a;
            for (Room room : b.getRooms()) {
                boolean isValid = true;
                if (roomType != null && !room.getGenre_Room().equals(roomType)) {
                    isValid = false;
                }
                if (numOfPeople != null && numOfPeople > room.getMaximum_peoples_Room()) {
                    isValid = false;
                }
                if (starQuality != null) {
                    if (a instanceof Hotel) {
                        Hotel h = (Hotel) a;
                        if (h.getRating_stars_Hotel() != starQuality) {
                            isValid = false;
                        }
                    } else if (a instanceof Resort) {
                        Resort r = (Resort) a;
                        if (r.getRating_stars_Resort() != starQuality) {
                            isValid = false;
                        }
                    } else {
                        isValid = false;
                    }
                }
                if (isValid) {
                    commonRooms.add(room);
                }
            }
        }
    }

    // Lọc các phòng chung giữa các điều kiện
    HashSet<Accommodation> commonAccommodationsSet = new HashSet<>();
    for (Room room : commonRooms) {
        Accommodation a = room.getAccommodation();
        if (a instanceof CommonAccommodation) {
            CommonAccommodation b = (CommonAccommodation) a;
            for (Room r : b.getRooms()) {
                if (commonRooms.contains(r)) {
                    commonAccommodationsSet.add(b);
                    break;
                }
            }
        }
    }

    // Thêm các kết quả của luxury và common vào danh sách cuối cùng
    finalFilter.addAll(luxuryAccommodations);
    finalFilter.addAll(commonAccommodationsSet);

    return finalFilter;
}




    // Requirement 5
    public double performReservation(String reservationPath, Accommodation acc, Room room, Date checkin, Date checkout)
            throws Exception {
        ArrayList<Reservation> reservatedRooms = new ArrayList<>();

        // input data from reservation_5 to ArrayList
        try{
            BufferedReader reader = new BufferedReader(new FileReader(reservationPath));
            String line;
            while((line = reader.readLine()) != null){
                String[] parts = line.split(",");
                int numberArgument = parts.length;
                switch (numberArgument) {
                    case 4:
                        long checkinLong = Long.parseLong(parts[2]);
                        long checkoutLong = Long.parseLong(parts[3]);
                        Date checkinDate = new Date(checkinLong);
                        Date checkoutDate = new Date(checkoutLong);
                        reservatedRooms.add(new Reservation(Integer.parseInt(parts[0]), Integer.parseInt(parts[1]),-1,checkinDate, checkoutDate));
                        break;
                    case 5:
                        checkinLong = Long.parseLong(parts[3]);
                        checkoutLong = Long.parseLong(parts[4]);
                        checkinDate = new Date(checkinLong);
                        checkoutDate = new Date(checkoutLong);
                        reservatedRooms.add(new Reservation(Integer.parseInt(parts[0]), Integer.parseInt(parts[1]),Integer.parseInt(parts[2]), checkinDate, checkoutDate));
                        break;
                    default:
                        System.out.println("Error, invalid number of argument req5");
                        break;
                }
            }
            reader.close();
        }
        catch(IOException e) {
            System.out.println("Error reader req5");
        }
        

        boolean checkDoesRoom_InResevated = false;
        double totalMoney = 0.0;
        double payMoney = 0.0;
        for(Accommodation a : accommodations){
            if(a instanceof CommonAccommodation){
                CommonAccommodation b = (CommonAccommodation) a;
                if(b.getID_Accommodation() == acc.ID_Accommodation){
                    for(Reservation reRoom : reservatedRooms) {
                        if(reRoom.getRoomId() == room.getID_Room()){
                            checkDoesRoom_InResevated = true; // check in resevation 
                            Date start = reRoom.getCheckin();
                            Date end = reRoom.getCheckout();
                            
                            boolean checkOverlap = (start.before(checkout) && end.after(checkin)) || (start.equals(checkin) && end.equals(checkout));
                            long startCheckIn = checkin.getTime();
                            long endCheckOut = checkout.getTime();
                            
                            if(!checkOverlap) {
                                totalMoney = room.getPrice_night_Room() * diffBetweenDays(startCheckIn, endCheckOut);
                                payMoney = totalMoney + 0.08*totalMoney;
                                BufferedWriter writer = new BufferedWriter(new FileWriter(reservationPath,true));
                                writer.newLine();
                                String str = String.format("%s,%s,%s,%s,%s",reservatedRooms.size()+1, acc.ID_Accommodation,room.getID_Room(),startCheckIn,endCheckOut);
                                writer.write(str);
                                writer.close();
                                break;
                            }
                            else{
                                throw new Exception("The room has already been booked during this time period.");
                            }
                        }
                    }
                }
            }
            if(checkDoesRoom_InResevated == true){
                break;
            }
        }
        

        if(checkDoesRoom_InResevated == false){
            for(Accommodation a : accommodations){
                if(a instanceof CommonAccommodation){
                    CommonAccommodation b = (CommonAccommodation) a;
                    if(b.ID_Accommodation == acc.ID_Accommodation){
                        for(Room r : b.getRooms()){
                            if((r.getID_Room() == room.getID_Room())){
                                long startCheckIn = checkin.getTime();
                                long endCheckOut = checkout.getTime();
                                totalMoney = room.getPrice_night_Room() * diffBetweenDays(startCheckIn, endCheckOut);
                                payMoney = totalMoney + 0.08*totalMoney;
                                BufferedWriter writer = new BufferedWriter(new FileWriter(reservationPath,true)); // can them try catch
                                writer.newLine();
                                String str = String.format("%s,%s,%s,%s,%s",reservatedRooms.size()+1, acc.ID_Accommodation,room.getID_Room(),startCheckIn,endCheckOut);
                                writer.write(str);
                                writer.close();
                                break;
                            }
                        }
                    }
                }
            }
        }
        
        return payMoney;
    }

    // Helper functions for req 5
    public long diffBetweenDays(long dateStart, long dateEnd) {
        Date date = new Date(dateStart * 1000);
        Date date1 = new Date(dateEnd * 1000);

        date = removeTime(date);
        date1 = removeTime(date1);

        long diff = Math.abs(date1.getTime() - date.getTime());
        long numOfDays = TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
        return numOfDays;
    }

    private Date removeTime(Date date) {
        long time = date.getTime();
        long timeWithoutTime = time - (time % (24 * 60 * 60 * 1000));
        return new Date(timeWithoutTime);
    }
}
