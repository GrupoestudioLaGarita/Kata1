
package kata1;

import java.io.IOException;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Scanner;

public class Person {
    
    String name = "";
    String birthdate = "";
    int age = 0;

    public static void main(String[] args) throws IOException {
        
        Person person = new Person();
        person.control();
            
    }
    
    private void control() throws IOException {
            input();
            process();
            output();
        }

    private void input() {
        System.out.println("Introduzca su nombre: ");
        Scanner scanner = new Scanner(System.in);
        name = scanner.next();
        System.out.println("Introduzca su fecha de nacimiento: ");
        birthdate = scanner.next();
    }

    private void process() throws IOException {
        
        age = getAge(birthdate);
            
    }

    private void output() {
        System.out.println("Su edad es de " + age + " años.");
    }
    
    private int getAge(String birthdate){
        
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate birthday = LocalDate.parse(birthdate, fmt);
        LocalDate presentDate = LocalDate.now();    
                
                
        int years = presentDate.getYear() - birthday.getYear();
        int months = presentDate.getMonthValue()- birthday.getMonthValue();
        
        if (months < 0){
            years -= 1;
        } else if (months == 0) {
            int day = presentDate.getDayOfMonth()- birthday.getDayOfMonth();
            if (day > 0){
                years -= 1;
            }
        }
        return years;
        
    }
    
}
