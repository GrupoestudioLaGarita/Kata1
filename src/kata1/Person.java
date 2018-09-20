
package kata1;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
        Date presentDate = new Date();
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        String today = format.format(presentDate);
        String[] dat1 = birthdate.split("/");
        String[] dat2 = today.split("/");
        int years = Integer.parseInt(dat2[2]) - Integer.parseInt(dat1[2]);
        int months = Integer.parseInt(dat2[1]) - Integer.parseInt(dat1[1]);
        
        if (months < 0){
            years -= 1;
        } else if (months == 0) {
            int day = Integer.parseInt(dat2[0]) - Integer.parseInt(dat1[0]);
            if (day > 0){
                years -= 1;
            }
        }
        return years;
    }
    
}
