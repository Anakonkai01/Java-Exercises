package test;

import java.util.Date;

public class Test {
    public static void main(String[] args) {
        int timestampStart1 = 1654018800; // Đơn vị là giây
        int timestampEnd1 = 1654200000;

        long timestampStart2 = 1713512750L;
        long timestampEnd2 = 1713771950L;

        // Kiểm tra xem hai khoảng thời gian có trùng nhau hay không
        boolean overlap = checkOverlap(timestampStart1, timestampEnd1, timestampStart2, timestampEnd2);
        if (overlap) {
            System.out.println("Hai khoảng thời gian trùng nhau.");
        } else {
            System.out.println("Hai khoảng thời gian không trùng nhau.");
        }
        System.out.println(timestampEnd1);
    }

    // Phương thức kiểm tra xem hai khoảng thời gian có trùng nhau hay không
    public static boolean checkOverlap(long start1, long end1, long start2, long end2) {
        return start1 < end2 && end1 > start2;
    }
}
