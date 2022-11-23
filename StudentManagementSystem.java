import java.util.*;
import java.io.*;

class MainMenu {
    public void menu() {
        System.out.println("\t\t\t  STUDENT MANAGEMENT SYSTEM");
        System.out.println("\n\nPress 1 : To Add an Student Details");
        System.out.println("Press 2 : To See an Student Details ");
        System.out.println("Press 3 : To Remove an Student");
        System.out.println("Press 4 : To Update Student Details");
        System.out.println("Press 5 : To Exit");

    }
}

class Student_Add {
    public void createFile() 
    {
        Scanner sc = new Scanner(System.in);

        StudentDetail std= new StudentDetail();
        std.getInfo();
        try {
            File f1 = new File("file"+std.student_id + ".txt");
            if (f1.createNewFile()) {
                FileWriter myWriter = new FileWriter("file" + std.student_id + ".txt");
                myWriter.write("Student ID:"+std.student_id + "\n" + "Student Name     :"+std.name + "\n" +
                        "Father's Name     :"+std.father_name + "\n" + "Student Contact  :"+std.student_contact
                        + "\n" +
                        "Email Information :" +std.email + "\n" +
                        "Student marks   :" +std.student_marks);
                myWriter.close();
                System.out.println("\nStudent has been Added :)\n");

                System.out.print("\nPress Enter to Continue...");
                sc.nextLine();
            } else {
                System.out.println("\nStudent already exists :(");
                System.out.print("\nPress Enter to Continue...");
                sc.nextLine();
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}

class StudentDetail {
    String name;
    String father_name;
    String email;
    String student_id;
    String student_marks;
    String student_contact;

    public void getInfo() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Student's name : ");
        name = sc.nextLine();
        System.out.print("Enter Student's Father name : ");
        father_name = sc.nextLine();
        System.out.print("Enter Student's ID : ");
        student_id = sc.nextLine();
        System.out.print("Enter Student's Email ID : ");
        email = sc.nextLine();
        System.out.print("Enter Student contact Info : ");
        student_contact = sc.nextLine();
        System.out.print("Enter Student's marks : ");
        student_marks = sc.nextLine();
    }
}

class Student_Show {
    public void viewFile(String s) throws Exception {
        File file = new File("file" + s + ".txt");
        Scanner sc = new Scanner(file);

        while (sc.hasNextLine()) {
            System.out.println(sc.nextLine());
        }
    }
}

class Student_Remove {
    public void removeFile(String ID) {

        File file = new File("file" + ID + ".txt");
        if (file.exists()) {
            if (file.delete())
                ;
            {
                System.out.println("\nStudent has been removed Successfully");
            }
        } else {
            System.out.println("\nStudent does not exists :( ");
        }
    }
}

class Student_Update {
    public void updateFile(String s, String o, String n) throws IOException {
        File file = new File("file" + s + ".txt");
        Scanner sc = new Scanner(file);
        String fileContext = "";
        while (sc.hasNextLine()) {
            fileContext = fileContext + "\n" + sc.nextLine();
        }
        FileWriter myWriter = new FileWriter("file" + s + ".txt");
        fileContext = fileContext.replaceAll(o, n);
        myWriter.write(fileContext);
        myWriter.close();

    }
}

class CodeExit {
    public void out() {
        System.exit(0);
    }
}

class StudentManagementSystem {
    public static void main(String arv[]) {
        System.out.print("\033[H\033[2J");

        Scanner sc = new Scanner(System.in);
        Student_Show epv = new Student_Show();

        int i = 0;

        MainMenu obj1 = new MainMenu();
        obj1.menu();

        while (i < 6) {

            System.out.print("\nPlease Enter choice :");
            i = Integer.parseInt(sc.nextLine());

            switch (i) {
                case 1: {
                    Student_Add ep = new Student_Add();
                    ep.createFile();

                    System.out.print("\033[H\033[2J");
                    obj1.menu();
                    break;
                }
                case 2: {
                    System.out.print("\nPlease Enter Student's ID :");
                    String s = sc.nextLine();
                    try {
                        epv.viewFile(s);
                    } catch (Exception e) {
                        System.out.println(e);
                    }

                    System.out.print("\nPress Enter to Continue...");
                    sc.nextLine();
                    System.out.print("\033[H\033[2J");
                    obj1.menu();
                    break;
                }

                case 3: {
                    System.out.print("\nPlease Enter Student's ID :");
                    String s = sc.nextLine();
                    Student_Remove epr = new Student_Remove();
                    epr.removeFile(s);

                    System.out.print("\nPress Enter to Continue...");
                    sc.nextLine();
                    System.out.print("\033[H\033[2J");
                    obj1.menu();
                    break;
                }
                case 4: {
                    System.out.print("\nPlease Enter Student's ID :");
                    String I = sc.nextLine();
                    try {
                        epv.viewFile(I);
                    } catch (Exception e) {
                        System.out.println(e);
                    }
                    Student_Update epu = new Student_Update();
                    System.out.print("Please Enter the detail you want to Update :");
                    System.out.println(
                            "If you want to Change the Name, then Enter Current Name and Press Enter. Then write the new Name then Press Enter. It will Update the Name.\n");
                    String s = sc.nextLine();
                    System.out.print("Please Enter the Updated Info :");
                    String n = sc.nextLine();
                    try {
                        epu.updateFile(I, s, n);

                        System.out.print("\nPress Enter to Continue...");
                        sc.nextLine();
                        System.out.print("\033[H\033[2J");
                        obj1.menu();
                        break;
                    } catch (IOException e) {
                        System.out.println(e);
                    }
                }
                case 5: {
                    CodeExit obj = new CodeExit();
                    obj.out();
                }
            }
        }
    }
}
