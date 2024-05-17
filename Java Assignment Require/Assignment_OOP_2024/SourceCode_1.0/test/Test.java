package test;

import java.util.Date;

public class Test {
    public static void main(String[] args) {
        Date dateStart = new Date(1713368812L * 1000); // dateStartMillis là số giây từ epoch
        Date dateEnd = new Date(1713398812L * 1000); // dateEndMillis là số giây từ epoch
        Date dateStart1 = new Date(1713368812L * 1000); // dateStartMillis là số giây từ epoch
        Date dateEnd1 = new Date(1713398812L * 1000); // dateEndMillis là số giây từ epoch
        // System.out.println(dateStart);
        // System.out.println(dateEnd);

        // System.out.println(dateStart.getTime());
        // // Lấy số miligiây của mỗi ngày
        // long startTime = dateStart.getTime();
        // long endTime = dateEnd.getTime();
        
        // // Tính số miligiây đã trôi qua giữa hai ngày
        // double timeDifference = endTime - startTime;
        // double daysDifference = timeDifference / (1000 * 60 * 60 * 24);

        // System.out.println("Số ngày đã trôi qua: " + daysDifference);
        System.out.println(checkOverlap(dateStart, dateEnd, dateStart1, dateEnd1));
    }

    // Phương thức kiểm tra xem hai khoảng thời gian có trùng nhau hay không
    public static boolean checkOverlap(long start1, long end1, long start2, long end2) {
        return start1 <= end2 && end1 >= start2;
    }

    public static boolean checkOverlap(Date start1, Date end1, Date start2, Date end2) {
        return start1.before(end2) && end1.after(start2) || start1.equals(start2) && end1.equals(end2) ;
    }
}
