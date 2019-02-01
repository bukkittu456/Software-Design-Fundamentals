/**
 *Project Name: Calender application where user enters the date and the program checks the validity and prints the day of the date
 *Course: PROG24178 Object Oriented Programming 2- Java
 * Question No:1
 * Student username: bukkittu
 * @author Vedavyas Bukkittu 
 */
import java.util.Scanner;

public class ValidDate {

    final static String[] DAYS = {"Saturday", "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday"};// The days of the week Array

    public static void main(String[] args) {
        String date = "";
        String[] monthName
                = {"January", "February", "March", "April",
                    "May", "June", "July", "August",
                    "September", "October", "November", "December"}; // Month Array

        Integer[] daysInMonth = {28, 29, 30, 31};// The number of days in the month array

        int mm = 0;        
        int dd = 0;
        int yy = 0;

        String month = "";
        String day = "";
        String year = "";
        String birthday="";

        int maxDay = 0;

        while (mm < 1 || mm > 12 || dd < 1 || dd > maxDay) { // While loop as we do not know the number of iterations and we want the program to run until the user enters valid data

            Scanner input = new Scanner(System.in);;
            System.out.println("Please enter a date in the format MM/DD/YYYY.");
            date = input.nextLine();

            String[] partsOfTheDate = date.split("/");

            mm = Integer.parseInt(partsOfTheDate[0]);
            dd = Integer.parseInt(partsOfTheDate[1]);
            yy = Integer.parseInt(partsOfTheDate[2]);
            if (yy % 4 == 0 && yy % 100 != 0 || yy % 400 == 0) {
                System.out.println("This is a leap year");
                switch (mm) {
                    case 1:
                        maxDay = daysInMonth[3]; // Jan
                        break;
                    case 2:
                        maxDay = daysInMonth[1]; // Feb 
                        break;
                    case 3:
                        maxDay = daysInMonth[3]; // Mar
                        break;
                    case 4:
                        maxDay = daysInMonth[2]; // Apr
                        break;
                    case 5:
                        maxDay = daysInMonth[3]; // May
                        break;
                    case 6:
                        maxDay = daysInMonth[2]; // Jun
                        break;
                    case 7:
                        maxDay = daysInMonth[3]; // Jul
                        break;
                    case 8:
                        maxDay = daysInMonth[3]; // Aug
                        break;
                    case 9:
                        maxDay = daysInMonth[2]; // Sep
                        break;
                    case 10:
                        maxDay = daysInMonth[3]; // Oct
                        break;
                    case 11:
                        maxDay = daysInMonth[2]; // Nov
                        break;
                    case 12:
                        maxDay = daysInMonth[3]; // Dec
                        break;
                    default:
                        maxDay = 0;
                        break;
                }
            } else {
                switch (mm) {
                    case 1:
                        maxDay = daysInMonth[3]; // Jan
                        break;
                    case 2:
                        maxDay = daysInMonth[0]; // Feb 
                        break;
                    case 3:
                        maxDay = daysInMonth[3]; // Mar
                        break;
                    case 4:
                        maxDay = daysInMonth[2]; // Apr
                        break;
                    case 5:
                        maxDay = daysInMonth[3]; // May
                        break;
                    case 6:
                        maxDay = daysInMonth[2]; // Jun
                        break;
                    case 7:
                        maxDay = daysInMonth[3]; // Jul
                        break;
                    case 8:
                        maxDay = daysInMonth[3]; // Aug
                        break;
                    case 9:
                        maxDay = daysInMonth[2]; // Sep
                        break;
                    case 10:
                        maxDay = daysInMonth[3]; // Oct
                        break;
                    case 11:
                        maxDay = daysInMonth[2]; // Nov
                        break;
                    case 12:
                        maxDay = daysInMonth[3]; // Dec
                        break;
                    default:
                        maxDay = 0;
                        break;
                }
            }
        }

        if ((mm < 1 || mm > 12) || (dd < 1 || dd > maxDay)) {
            System.out.println("You entered " + date + ";\nyou did not include a valid month, day, or both."); // Prompt if user enters invalid date
        } else if ((mm > 0 && mm < 13) && (dd > 0 && dd <= maxDay)) {
            System.out.println("The entered " + date + ";\n can also be expressed as " + monthName[mm - 1] + " " + dd + ", " + yy + ".");
        }

        if (mm < 3) { //calculating the day of the week based on the numerical date using the Zeller algorithm.
            mm += 12;
            yy -= 1;
        }
        int k = yy % 100;
        int j = yy / 100;
        int theday = ((dd + (((mm + 1) * 26) / 10) + k + (k / 4) + (j / 4)) + (5 * j)) % 7;
        System.out.println("That date is \t" + DAYS[theday]); // Printing the day
    }

}
