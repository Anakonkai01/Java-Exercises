package exercise4;
import java.io.IOException;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Exercise4 {
public static void main(String[] args) {
        String folderPath = "C:\\Users\\nguye\\OneDrive\\Desktop"; // Thay đổi đường dẫn này thành đường dẫn thư mục bạn muốn phân chia

        try {
            // Tạo đối tượng Path từ đường dẫn thư mục
            Path directory = Paths.get(folderPath);

            // Tạo một map để lưu trữ tệp theo phần mở rộng của chúng
            Map<String, List<Path>> filesByExtension = new HashMap<>();

            // Lấy danh sách tất cả các tệp trong thư mục
            try (DirectoryStream<Path> stream = Files.newDirectoryStream(directory)) {
                for (Path file : stream) {
                    if (Files.isRegularFile(file)) {
                        // Lấy phần mở rộng của tệp
                        String extension = getFileExtension(file);

                        // Kiểm tra xem có danh sách nào đã được tạo cho phần mở rộng này chưa
                        if (!filesByExtension.containsKey(extension)) {
                            filesByExtension.put(extension, new ArrayList<>());
                        }

                        // Thêm tệp vào danh sách tương ứng
                        filesByExtension.get(extension).add(file);
                    }
                }
            }

            // Hiển thị các tệp theo phần mở rộng của chúng
            for (Map.Entry<String, List<Path>> entry : filesByExtension.entrySet()) {
                System.out.println("Files with extension ." + entry.getKey() + ":");
                for (Path file : entry.getValue()) {
                    System.out.println(file.getFileName());
                }
                System.out.println("-----------------------------");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Phương thức này trích xuất phần mở rộng từ đường dẫn tệp
    private static String getFileExtension(Path path) {
        String fileName = path.getFileName().toString();
        int index = fileName.lastIndexOf('.');
        if (index > 0) {
            return fileName.substring(index + 1);
        }
        return "";
    }
}
