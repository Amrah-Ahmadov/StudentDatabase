import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jsoniter.JsonIterator;

import java.io.*;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class StudentManipulation {
    Students myStudents = new Students();
    ObjectMapper objectMapper = new ObjectMapper();
    File file = new File("classrom.json");
    Scanner scanner = new Scanner(System.in);

    public void showMainMenu(){
        System.out.println("Telebe daxil etmek ucun 1 reqemini daxil edin");
        System.out.println("Butun telebelerin siyahisini gostermek ucun 2 reqemini daxil edin");
        System.out.println("Mueyyen telebenin melumatlarini gostermek ucun 3 reqemini daxil edin");
        System.out.println("Mueyyen telebenin movcud melumetlarini deyismek ucun 4 reqemini daxil edin");
        System.out.println("Mueyyen telebeni siyahidan silmek ucun 5 reqemini daxil edin");
        System.out.println("Axtaris etmek ucun 6 reqemini daxil edin");
        System.out.println("Sistemden cixis etmek ucun 7 reqemini daxil edin");
    }
    public void showSearchMenu(){
        System.out.println("Telebenin adina gore axtaris etmek ucun 1 reqemini daxil edin");
        System.out.println("Telebenin soyadina gore axtaris etmek ucun 2 reqemini daxil edin");
        System.out.println("Telebenin ata adina gore axtaris etmek ucun 3 reqemini daxil edin");
        System.out.println("Evvelki menyuya qayitmaq ucun 4 reqemini daxil edin");
    }

    public void studentAdder() throws IOException {
        String name, surname, fatherName, email, phoneNumber;
        boolean checkForValidity = false;
        System.out.println("Telebenin adini daxil edin: ");
        name = scanner.next();
        System.out.println("Telebenin soyadini daxil edin: ");
        surname = scanner.next();
        System.out.println("Telebenin ata adini daxil edin:");
        fatherName = scanner.next();
        email = null;
        while(checkForValidity == false){
            System.out.println("Telebenin e-mail ini daxil edin: ");
            email = scanner.next();
            checkForValidity = validEmail(email);
        }
        checkForValidity = false;
        phoneNumber = null;
        while(checkForValidity == false){
            System.out.println("Telebenin telefon nomresini daxil edin:");
            phoneNumber = scanner.next();
            checkForValidity = validPhoneNumber(phoneNumber);
        }


        Student student = new Student(name, surname, fatherName, email, phoneNumber);
        System.out.println("Telebe elave olundu");
        myStudents.getStudentsList().add(student);                 //add student
        objectMapper.writeValue(file, myStudents);


    }

   public void showAllStudents() throws IOException {

       String json = inputStreamToString(new FileInputStream(file));        ///json to object show all students
       Students myclassrooms = objectMapper.readValue(json, Students.class);
       System.out.println(myclassrooms);
   }
   public void changeAllParamethersOfStudent(int id, String name, String surname, String fatherName, String email, String phoneNumber) throws IOException {

       String json = inputStreamToString(new FileInputStream(file));
       Students myclassrooms = objectMapper.readValue(json, Students.class);
       Student myStudent = null;

       myStudent = returnStudentById(myclassrooms.getStudentsList(), id);
       if(myStudent != null){
           myStudent.setName(name);
           myStudent.setSurname(surname);
           myStudent.setFatherName(fatherName);
           myStudent.setEmail(email);
           myStudent.setPhoneNumber(phoneNumber);

           myclassrooms.getStudentsList().remove(myStudent);
           myclassrooms.getStudentsList().add(myStudent);
           objectMapper.writeValue(file , myclassrooms);
           System.out.println(id + " id - li Telebenin melumatlari deyisildi ");
       }

   }
   public void changeStudentsParams() throws IOException {
       String name, surname, fatherName, email, phoneNumber;
       int id;
        boolean checkForValidity = false;
       System.out.println("Melumatlarini deyismek istediyiniz telebenin id sini daxil edin: ");
       id = scanner.nextInt();
       System.out.println("Telebenin adini daxil edin: ");
       name = scanner.next();
       System.out.println("Telebenin soyadini daxil edin: ");
       surname = scanner.next();
       System.out.println("Telebenin ata adini daxil edin:");
       fatherName = scanner.next();
       email = null;
       while(checkForValidity == false){
           System.out.println("Telebenin e-mail ini daxil edin: ");
           email = scanner.next();
           checkForValidity = validEmail(email);
       }
       checkForValidity = false;
       phoneNumber = null;
       while(checkForValidity == false){
           System.out.println("Telebenin telefon nomresini daxil edin:");
           phoneNumber = scanner.next();
           checkForValidity = validPhoneNumber(phoneNumber);
       }
       changeAllParamethersOfStudent(id, name, surname, fatherName, email, phoneNumber);
   }

   public Student returnStudentById(List<Student> listOfStudents, int id){
        boolean x = false;
        Student student = null;
        for(Student s: listOfStudents){
                if(s.getId() == id){
                    student = s;
                    x = true;
                }
            }
        if(x == false){
            System.out.println("Bele bir telebe tapilmadi");
        }
        return student;
   }
   public void showStudentById() throws IOException {
        int id;
       System.out.println("Melumatlarini gostermek istediyiniz telebenin id sini daxil edin:");
       id = scanner.nextInt();

       String json = inputStreamToString(new FileInputStream(file));
       Students myclassrooms = objectMapper.readValue(json, Students.class);
       System.out.println(returnStudentById(myclassrooms.getStudentsList(), id));
   }
   public void deleteStudentsById() throws IOException {
        int id;
       System.out.println("Silmek istediyiniz telebenin Id sini daxil edin: ");
       id = scanner.nextInt();

       String json = inputStreamToString(new FileInputStream(file));
       Students myclassrooms = objectMapper.readValue(json, Students.class);
       myclassrooms.getStudentsList();
       deleteStudentById(myclassrooms.getStudentsList(), id);

       objectMapper.writeValue(file , myclassrooms);
   }
    public void deleteStudentById(List<Student> listOfStudents, int id) throws IOException {

       boolean check = false;
        for(int i = 0; i < listOfStudents.size(); i++){
            if(listOfStudents.get(i).getId() == id){
                System.out.println(id + " li telebe silindi");
                check = true;
                listOfStudents.remove(listOfStudents.get(i));
            }
        }
        if(check == false){
            System.out.println("Bele bir ID li telebe tapilmadigina gore siline bilmedi !");
        }
    }
    void searchStudentByName() throws IOException {
        boolean check = false;
        String nameOfStudent;
        System.out.println("Axtarix etmek istediyiniz adi daxil edin: ");
        nameOfStudent = scanner.next();
        String json = inputStreamToString(new FileInputStream(file));
        Students myAllStudents = JsonIterator.deserialize(json, Students.class);
        for(int i = 0; i < myAllStudents.getStudentsList().size(); i++){
            if(myAllStudents.getStudentsList().get(i).getName().toLowerCase().contains(nameOfStudent.toLowerCase())){
                System.out.println(myAllStudents.getStudentsList().get(i));
                check = true;
            }
        }
        if(check == false){
            System.out.println("Axtardiginiz ada uygun netice tapilmadi !");
        }
    }
    void searchStudentBySurname() throws IOException {
        boolean checkForSurname = false;
        String surNameOfStudent;
        System.out.println("Axtarix etmek istediyiniz soyadi daxil edin: ");
        surNameOfStudent = scanner.next();
        String json = inputStreamToString(new FileInputStream(file));
        Students myAllStudents = JsonIterator.deserialize(json, Students.class);
        for (int i = 0; i < myAllStudents.getStudentsList().size(); i++) {
            if (myAllStudents.getStudentsList().get(i).getSurname().toLowerCase().contains(surNameOfStudent.toLowerCase())) {
                System.out.println(myAllStudents.getStudentsList().get(i));
                checkForSurname = true;
            }
        }
        if(checkForSurname == false){
            System.out.println("Axtardiginiz soyada uygun netice tapilmadi !");
        }
    }
        void searchStudentByFathername() throws IOException {
            boolean checkForFatherName = false;
            String fatherNameOfStudent;
            System.out.println("Axtarix etmek istediyiniz ata adini daxil edin: ");
            fatherNameOfStudent = scanner.next();
            String json = inputStreamToString(new FileInputStream(file));
            Students myAllStudents = JsonIterator.deserialize(json, Students.class);
            for (int i = 0; i < myAllStudents.getStudentsList().size(); i++) {
                if (myAllStudents.getStudentsList().get(i).getFatherName().toLowerCase().contains(fatherNameOfStudent.toLowerCase())) {
                    System.out.println(myAllStudents.getStudentsList().get(i));
                    checkForFatherName = true;
                }
            }
            if(checkForFatherName == false){
                System.out.println("Axtardiginiz ata adina uygun netice tapilmadi !");
            }
        }
        public boolean validEmail(String email){
            String regex = "^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$";
            boolean result = email.matches(regex);
            if(result != true){
                System.out.println("daxil etdiyiniz e-mail dogru deyil !");
            }
            return result;
        }
        public boolean validPhoneNumber(String phone){
        String regex = "(\\+?994)(5[015]|7[07]|12)([2-9][0-9]{2})([0-9]{2})([0-9]{2})"; // numune +994504045050
            boolean result = phone.matches(regex);
            if(result != true){
                System.out.println("daxil etdiyiniz mobil nomre dogru deyil !");
            }
            return result;
        }

    public String inputStreamToString(InputStream is) throws IOException {
        StringBuilder sb = new StringBuilder();
        String line;
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        while ((line = br.readLine()) != null) {
            sb.append(line);
        }
        br.close();
        return sb.toString();
    }

    public void getFileData() throws IOException {
        FileReader in = new FileReader("classrom.json");
        StringBuilder jsonString = new StringBuilder();
        int i;
        while((i=in.read())!=-1)
            jsonString.append((char)i);
        in.close();

        ObjectMapper objectMapper = new ObjectMapper();
        myStudents = objectMapper.readValue(jsonString.toString(), Students.class );
    }
}
