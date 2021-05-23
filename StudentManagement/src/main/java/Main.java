import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.SortedMap;

public class Main {
    static int idGenerator = 1;
    public static void main(String[] args) throws IOException {
        
        StudentManipulation manipulation = new StudentManipulation();
        manipulation.getFileData();
        Scanner scan = new Scanner(System.in);
        boolean checkForFirstMenu = true;
        boolean checkForSecondMenu = true;
        int commandNumber = 0;
        String continueOrNot;
        String input;

        while(checkForFirstMenu){
            checkForSecondMenu = true;
            manipulation.showMainMenu();
            input = scan.next();
            commandNumber = instanceOfString(input);

            if(commandNumber == 1){
                manipulation.studentAdder();
                System.out.println("Davam etmek isteyirsiniz ? h/y");
                continueOrNot = scan.next();
                if(continueOrNot.equals("y")){
                    checkForFirstMenu = false;
                    System.exit(0);
                }
            }else if(commandNumber == 2){
                manipulation.showAllStudents();
                System.out.println("Davam etmek isteyirsiniz ? h/y");
                continueOrNot = scan.next();
                if(continueOrNot.equals("y")){
                    checkForFirstMenu = false;
                    System.exit(0);
                }
            }else if(commandNumber == 3){
                manipulation.showStudentById();
                System.out.println("Davam etmek isteyirsiniz ? h/y");
                continueOrNot = scan.next();
                if(continueOrNot.equals("y")){
                    checkForFirstMenu = false;
                    System.exit(0);
                }
            }else if(commandNumber == 4){
                manipulation.changeStudentsParams();
                System.out.println("Davam etmek isteyirsiniz ? h/y");
                continueOrNot = scan.next();
                if(continueOrNot.equals("y")){
                    checkForFirstMenu = false;
                    System.exit(0);
                }
            }else if(commandNumber == 5){
                manipulation.deleteStudentsById();
                System.out.println("Davam etmek isteyirsiniz ? h/y");
                continueOrNot = scan.next();
                if(continueOrNot.equals("y")){
                    checkForFirstMenu = false;
                    System.exit(0);
                }
            }else if(commandNumber == 6){
                while(checkForSecondMenu){
                    manipulation.showSearchMenu();
                    commandNumber = scan.nextInt();
                    if(commandNumber == 1){
                        manipulation.searchStudentByName();
                        System.out.println("Davam etmek isteyirsiniz ? h/y");
                        continueOrNot = scan.next();
                        if(continueOrNot.equals("y")){
                            checkForSecondMenu = false;
                            checkForFirstMenu = false;
                            System.exit(0);
                        }
                    }else if(commandNumber == 2){
                        manipulation.searchStudentBySurname();
                        System.out.println("Davam etmek isteyirsiniz ? h/y");
                        continueOrNot = scan.next();
                        if(continueOrNot.equals("y")){
                            checkForSecondMenu = false;
                            checkForFirstMenu = false;
                            System.exit(0);
                        }
                    }else if(commandNumber == 3){
                        manipulation.searchStudentByFathername();
                        System.out.println("Davam etmek isteyirsiniz ? h/y");
                        continueOrNot = scan.next();
                        if(continueOrNot.equals("y")){
                            checkForSecondMenu = false;
                            checkForFirstMenu = false;
                            System.exit(0);
                        }
                    }else if (commandNumber == 4){
                        checkForSecondMenu = false;
                    }else {
                        System.out.println("Daxil etidiyiniz eded 1 - 4 araliginda olmalidir !");
                        System.out.println();
                    }
                }
            }
            else if(commandNumber == 7){
                System.exit(0);
            }else{
                System.out.println("daxil etdiyiniz eded 1 - 7 araliginda olmalidir !");
                System.out.println();
            }
        }
    }

 public static int instanceOfString(Object obj){
     int x = 0;
        try{
            x = Integer.parseInt(String.valueOf(obj));
        }catch (NumberFormatException ex){
            System.out.println("eded olmalidir");
        }
     return x;
    }
}
