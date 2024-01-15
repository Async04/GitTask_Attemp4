package src.uz.pdp.util;

import src.uz.pdp.entity.Student;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class StudentRepo implements Repository<Student> {


    private List<Student> students;

    private static StudentRepo studentRepo;
    private static String PATH="src/uz/pdp/db/students.txt";

    public StudentRepo(List<Student> students) {
        this.students = students;
    }

    public static StudentRepo getInstance(){
        if(studentRepo==null){
            return new StudentRepo(generateStudentRepo());
        }
        return studentRepo;
    }


    @Override
    public void save(Student student) {
        students.add(student);
        upload();
    }

    @Override
    public void delate(Student student) {
        students.remove(student);
        upload();
    }

    @Override
    public List<Student> showAll() {
        return students;
    }

    @Override
    public void update(Student student) {

    }

    private void upload(){
        try(
        OutputStream outputStream = new FileOutputStream(PATH);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
        ) {

            objectOutputStream.writeObject(students);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    @SuppressWarnings("unchecked")
    private static ArrayList<Student> generateStudentRepo() throws RuntimeException {


        try (
                InputStream inputStream = new FileInputStream(PATH);
                ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);

        ) {

            return (ArrayList<Student>)objectInputStream.readObject();

        } catch (IOException | ClassNotFoundException e) {
            return new ArrayList<Student>();
        }


    }
}
