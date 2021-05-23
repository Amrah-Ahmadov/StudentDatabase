import java.io.IOException;
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
        int commandNumber;
        String continueOrNot;

        while(checkForFirstMenu){
            checkForSecondMenu = true;
            manipulation.showMainMenu();
            commandNumber = getInt(1,7);
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
                    commandNumber = getInt(1,4);
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
                    }else {
                        checkForSecondMenu = false;
                    }
                }
            }
            else{
                System.exit(0);
            }
        }
    }

    private static int getInt(int min, int max){
        Scanner scan = new Scanner(System.in);
        int commandNumber;
        while (true){
            try {
                commandNumber = Integer.parseInt(scan.nextLine());
                if(commandNumber >= min && commandNumber <= max){
                    break;
                }
            }
            catch (Exception ignored){}
            finally {
                System.out.println("\n" + "Xahis olunur " + min + " ve " + max + " arasi reqem daxil edin." + "\n");
            }
        }
        return commandNumber;
    }

}
