import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;
import java.util.Vector;

public class Main {


    static double promedio = 5.0;

    public static void main(String[] args) {

    Vector students = new Vector();
    Vector resultGradeStudents;
    Vector grades = new Vector();
    int contadorStudent = 0;

    // Se estable el promedio de los estudiantes que pasaran




    Scanner scanner = new Scanner(System.in);
    System.out.println("Para finalizar presiona 'Enter': ");
    String nameStudent = "";
    String gradeStudent = "";

    try{


        do {

                System.out.println("Ingresa una nombre:");
                nameStudent = scanner.nextLine();
                if(!nameStudent.isEmpty() && nameStudent.matches("^\\D+$")){
                    students.add(nameStudent);
                }else{
                    if(!nameStudent.isEmpty()){
                        System.out.println("Porfavor Ingresa un nombre valido o presiona 'Enter' para finalizar");
                    }
                }

        } while (!nameStudent.isEmpty());


        do{

            try {

                System.out.println("Ingresa la nota definitiva de " + students.get(contadorStudent));
                gradeStudent = scanner.nextLine();
                double gradeStudentDouble = Double.parseDouble(gradeStudent);

                if(!gradeStudent.isEmpty() && gradeStudent.matches("^\\d+.\\d+$") && gradeStudentDouble <= 10.00 ){
                    grades.add(gradeStudent);
                    contadorStudent++;
                } else{
                    if(!gradeStudent.isEmpty()){
                        System.out.println("Porfavor Ingresa una nota valida Ej: '10.00' o '5.5' ");
                    }

                }

            }catch (NumberFormatException e){
                System.out.println("Porfavor Ingresa una nota valida Ej: '10.00' o '5.5'");
            }

        } while (!gradeStudent.isEmpty() || grades.size() >= students.size());


    }catch (ArrayIndexOutOfBoundsException e){

    }


        resultGradeStudents = getStudentsList(students, grades);

        for(int i = 0; i < resultGradeStudents.size(); i++) {

           System.out.println(resultGradeStudents.get(i));

        }




    }


    public static Vector getStudentsList (Vector studentsList, Vector gradesList) {

        Vector results = new Vector();

        for(int i = 0; i < gradesList.size(); i++) {

            double gradeResult = Double.parseDouble((String) gradesList.get(i));

           if(gradeResult >= promedio ){
               results.add("El estudiante: " + studentsList.get(i) + " tiene una nota final: " + gradesList.get(i));
           }

        }


        return  results;

    }




}