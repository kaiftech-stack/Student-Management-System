package Driver;

import dao.StudentDao;
import entities.Address;
import entities.Courses;
import entities.Students;
import utility.HibernateUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentTest {

    static Scanner sc = new Scanner(System.in);
    static StudentDao dao = new StudentDao();

    public static void main(String[] args) {

        int choice;

        do {

            System.out.println("\n====================================");
            System.out.println(" STUDENT MANAGEMENT SYSTEM ");
            System.out.println("====================================");
            System.out.println("1. Add Student");
            System.out.println("2. Display All Students");
            System.out.println("3. Find Student By ID");
            System.out.println("4. Update Student Email");
            System.out.println("5. Delete Student");
            System.out.println("6. Find Students By City");
            System.out.println("7. Find Students By Course");
            System.out.println("8. Exit");
            System.out.println("9. Un-Enroll Student From Course");
            System.out.println("10. Exit");
            System.out.println("====================================");

            System.out.print("Enter Choice : ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    addStudent();
                    break;

                case 2:
                    displayAllStudents();
                    break;

                case 3:
                    findStudentById();
                    break;

                case 4:
                    updateStudentEmail();
                    break;

                case 5:
                    deleteStudent();
                    break;

                case 6:
                    findStudentsByCity();
                    break;

                case 7:
                    findStudentsByCourse();
                    break;

                case 8:
                    System.out.println("Thank You...");
                    break;

                case 9:
                    enrollStudent();
                    break;

                case 10:
                    System.out.println("\n====================================");
                    System.out.println("Thank You for using Student Management System");
                    System.out.println("Exiting...");
                    System.out.println("====================================");
                    break;

                default:
                    System.out.println("Invalid Choice");

            }

        } while (choice != 10);

        sc.close();
        HibernateUtil.closeFactory();
    }

    // ADD STUDENT


    private static void addStudent() {

        System.out.print("Enter Student Name : ");
        String name = sc.nextLine();

        System.out.print("Enter Student Email : ");
        String email = sc.nextLine();

        System.out.print("Enter Student Age : ");
        int age = sc.nextInt();
        sc.nextLine();

        Students student = new Students();
        student.setName(name);
        student.setEmail(email);
        student.setAge(age);

        // Course

        System.out.print("Enter Course Name : ");
        String courseName = sc.nextLine();

        System.out.print("Enter Fees : ");
        double fees = sc.nextDouble();
        sc.nextLine();

        System.out.print("Enter Duration : ");
        String duration = sc.nextLine();

        Courses course = new Courses();
        course.setCourseName(courseName);
        course.setFees(fees);
        course.setDuration(duration);

        // Address

        System.out.print("Enter Plot No : ");
        String plotNo = sc.nextLine();

        System.out.print("Enter Area : ");
        String area = sc.nextLine();

        System.out.print("Enter Pincode : ");
        int pincode = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter City : ");
        String city = sc.nextLine();

        System.out.print("Enter State : ");
        String state = sc.nextLine();

        System.out.print("Enter Country : ");
        String country = sc.nextLine();

        Address address = new Address();

        address.setPlotNo(plotNo);
        address.setArea(area);
        address.setPincode(pincode);
        address.setCity(city);
        address.setState(state);
        address.setCountry(country);

        // Relationships

        student.setAddress(address);
        address.setStudent(student);

        course.setStudent(student);

        List<Courses> courseList = new ArrayList<>();
        courseList.add(course);

        student.setCourses(courseList);

        dao.saveStudent(student);

        System.out.println("\nStudent Saved Successfully...");
    }


    // DISPLAY ALL


    private static void displayAllStudents() {

        List<Students> students = dao.getAllStudents();

        System.out.println("\n------ STUDENT LIST ------");

        for (Students s : students) {
            System.out.println(s);
        }

    }

    // FIND BY ID


    private static void findStudentById() {

        System.out.print("Enter Student ID : ");
        int id = sc.nextInt();

        Students student = dao.findStudentById(id);

        if (student != null) {

            System.out.println(student);

        } else {

            System.out.println("Student Not Found.");

        }

    }


    // UPDATE EMAIL


    private static void updateStudentEmail() {

        System.out.print("Enter Student ID : ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter New Email : ");
        String email = sc.nextLine();

        dao.updateStudentEmail(id, email);

    }


    // DELETE


    private static void deleteStudent() {

        System.out.print("Enter Student ID : ");
        int id = sc.nextInt();

        dao.deleteStudent(id);

    }


    // FIND BY CITY


    private static void findStudentsByCity() {

        System.out.print("Enter City : ");
        String city = sc.nextLine();

        List<Students> students = dao.findStudentsByCity(city);

        if (students.isEmpty()) {

            System.out.println("No Student Found.");

        } else {

            for (Students s : students) {
                System.out.println(s);
            }

        }

    }

    // FIND BY COURSE


    private static void findStudentsByCourse() {

        System.out.print("Enter Course Name : ");
        String course = sc.nextLine();

        List<Students> students =
                dao.findStudentsByCourse(course);

        if (students.isEmpty()) {

            System.out.println("No Student Found.");

        } else {

            System.out.println("\nStudents Enrolled in " + course);

            for (Students s : students) {

                System.out.println(s);

            }

        }

    }
    private static void enrollStudent() {

        System.out.print("Enter Student ID : ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Course Name : ");
        String name = sc.nextLine();

        System.out.print("Enter Fees : ");
        double fees = sc.nextDouble();
        sc.nextLine();

        System.out.print("Enter Duration : ");
        String duration = sc.nextLine();

        Courses course = new Courses();

        course.setCourseName(name);
        course.setFees(fees);
        course.setDuration(duration);

        dao.enrollStudent(id, course);

    }

}