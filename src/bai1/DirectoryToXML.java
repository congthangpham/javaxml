package bai1;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class DirectoryToXML {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhập đường dẫn thư mục: ");
        String directoryPath = scanner.nextLine();
        File directory = new File(directoryPath);

        if (directory.exists() && directory.isDirectory()) {
            StringBuilder xmlContent = new StringBuilder();
            xmlContent.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n");
            xmlContent.append("<root>\n");
            convertToXML(directory, xmlContent, 1);
            xmlContent.append("</root>");

            // Đường dẫn tệp đầu ra
            String outputFilePath = "C:\\Users\\DELLs\\Desktop\\directory_structure.xml";
            try (FileWriter writer = new FileWriter(outputFilePath)) {
                writer.write(xmlContent.toString());
                System.out.println("Cây thư mục đã được ghi vào tệp: " + outputFilePath);
            } catch (IOException e) {
                System.out.println("Đã xảy ra lỗi khi ghi tệp: " + e.getMessage());
                e.printStackTrace();
            }
        } else {
            System.out.println("Thư mục không tồn tại hoặc không phải là thư mục hợp lệ.");
        }

        scanner.close();
    }

    private static void convertToXML(File file, StringBuilder xmlContent, int indentLevel) {
        String indent = "    ".repeat(indentLevel);

        if (file.isDirectory()) {
            xmlContent.append(indent).append("<").append(file.getName()).append(">\n");
            File[] files = file.listFiles();
            if (files != null) {
                for (File subFile : files) {
                    convertToXML(subFile, xmlContent, indentLevel + 1);
                }
            }
            xmlContent.append(indent).append("</").append(file.getName()).append(">\n");
        } else {
            xmlContent.append(indent).append("<file>").append(file.getName()).append("</file>\n");
        }
    }
}


