package bai2;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();

        // Thêm các sinh viên vào danh sách
        students.add(new Student("Nguyen Van A", 20, 3.5));
        students.add(new Student("Le Thi B", 22, 3.8));
        students.add(new Student("Tran Van C", 21, 3.2));

        // Chuyển đổi danh sách sinh viên thành XML
        StringBuilder xmlContent = new StringBuilder();
        xmlContent.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n");
        xmlContent.append("<students>\n");
        for (Student student : students) {
            xmlContent.append("    <student>\n");
            xmlContent.append("        <name>").append(student.getName()).append("</name>\n");
            xmlContent.append("        <age>").append(student.getAge()).append("</age>\n");
            xmlContent.append("        <gpa>").append(student.getGpa()).append("</gpa>\n");
            xmlContent.append("    </student>\n");
        }
        xmlContent.append("</students>\n");

        // Đường dẫn đầy đủ tới tệp XML
        String outputFilePath = "C:\\Users\\DELLs\\Desktop\\students.xml";
        try (FileWriter writer = new FileWriter(outputFilePath)) {
            writer.write(xmlContent.toString());
            System.out.println("Danh sách sinh viên đã được ghi vào tệp: " + outputFilePath);
        } catch (IOException e) {
            System.out.println("Đã xảy ra lỗi khi ghi tệp: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
