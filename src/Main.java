
import java.util.Scanner;
import java.util.Vector;

public class Main {

    // Se crea una variable de tipo 'double' para guardar el promedio
    static double promedio = 0.00;

    public static void main(String[] args) {

        // Se establecen instancian objetos de la clase Vector para guardar los datos de los estudiantes
        Vector students = new Vector();
        Vector resultGradeStudents;
        Vector grades = new Vector();

        // Se estable un contador para acceder a los nombres de cada estudiante
        int contadorStudent = 0;


        // Se instancia la un objeto de la clase Scanner para leer datos por consola
        Scanner scanner = new Scanner(System.in);
        System.out.println("Para finalizar presiona 'Enter': ");
        String nameStudent = "";
        String gradeStudent = "";


        // La clase tryCatch permite capturar error en caso de no se pueda hacer la conversion de String a Double
        // Adicionalmente captura el error out of index en caso de que el Vector este fuera de rango
        try {


            do {

                System.out.println("Ingresa una nombre:");
                nameStudent = scanner.nextLine();
                // Se crea condition que no permite el ingreso de digitos usando una expresion regular
                if (!nameStudent.isEmpty() && nameStudent.matches("^\\D+$")) {
                    students.add(nameStudent);
                } else {
                    if (!nameStudent.isEmpty()) {
                        System.out.println("Porfavor Ingresa un nombre valido o presiona 'Enter' para finalizar");
                    }
                }

            } while (!nameStudent.isEmpty());


            do {

                try {

                    System.out.println("Ingresa la nota definitiva de " + students.get(contadorStudent));
                    gradeStudent = scanner.nextLine();
                    double gradeStudentDouble = Double.parseDouble(gradeStudent);
                    // Se crea condition que no permite formatea el ingreso de las notas
                    if (!gradeStudent.isEmpty() && gradeStudent.matches("^\\d+.\\d+$") && gradeStudentDouble <= 10.00) {
                        grades.add(gradeStudent);
                        contadorStudent++;
                    } else {
                        // Si valor ingresado no es un formato valido se brinda un ejemplo y se intenta recoletar denuevo
                        if (!gradeStudent.isEmpty()) {
                            System.out.println("Porfavor Ingresa una nota valida Ej: '10.00' o '5.5' ");
                        }

                    }

                } catch (NumberFormatException e) {
                    // Si no es posible hacer la conversion de datos se muestra el siguiente error
                    System.out.println("Porfavor Ingresa una nota valida Ej: '10.00' o '5.5'");
                }

            } while (!gradeStudent.isEmpty() || grades.size() >= students.size());


        } catch (ArrayIndexOutOfBoundsException e) {

        }

        // Se usa la funcion getAverage para obtener el promedio de la case y se imprime el resultado
        promedio = getAverage(grades);
        System.out.println("El promedio del curso es: " + getAverage(grades));

        // se guarda la lista de estudiantes que estan por debajo del promedio
        resultGradeStudents = getStudentsList(students, grades);

        // Se Imprime la lista de estudiantes que estan por debajo del promedio
        for (int i = 0; i < resultGradeStudents.size(); i++) {

            System.out.println(resultGradeStudents.get(i));

        }


    }


    // Este metodo obtiene la lista de estudiantes que estan por debajo del promedio y retorna el resultado en un 'Vector'
    public static Vector getStudentsList(Vector studentsList, Vector gradesList) {

        Vector results = new Vector();

        for (int i = 0; i < gradesList.size(); i++) {

            // Se convierte el objeto lista de notas en una cadena de texto para luego convertirla en 'double'
            double gradeResult = Double.parseDouble((String) gradesList.get(i));

            if (gradeResult <= promedio) {
                results.add("El estudiante: " + studentsList.get(i) + "esta por debajo del promedio con una nota final de: " + gradesList.get(i));
            }

        }

        return results;

    }

    // Este metodo calcula el promedio de las notas de los estudiantes  y retorna el resultado en 'Double'
    public static Double getAverage(Vector gradesList) {

        Double average = 0.0;

        // Se itera el Vector y se guarda el resultado de cada iteracion en un Objeto
        for (Object o : gradesList) {
            average = average + Double.parseDouble((String) o);
        }

        return average / gradesList.size();

    }


}