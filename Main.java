import src.uz.pdp.util.StudentRepo;

public class Main {

    static StudentRepo studentRepo = StudentRepo.getInstance();
    public static void main(String[] args) {

        while (true) {
            displayMenu();


        }
    }

    private static void displayMenu() {

        System.out.println("""
                1- Add student
                2- Remove student
                3- Show all students
           
                
                """);

    }
}
