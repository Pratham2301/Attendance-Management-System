import java.util.Scanner;

public class AttendanceGenerator {
    public static void main(String[] args) {

        // Assuming 30 days in a month for ease instead of 29,30,31
        // 12 months in a year

        Attendance a[][] = new Attendance[12][5];

        Employee emp1 = new Employee(1, "Prathamesh Rajbhoj", 19, "CEO", 9999999, a);

        System.out.println();
        System.out.println();
        System.out.println("Auto Generating Entrance and Exit Time Via Rand Function");
        System.out.println();
        System.out.println();

        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 5; j++) {
                String date = Integer.toString(j + 1) + "/" + Integer.toString(i + 1);

                int entry_hr = AutoTimeGenerator.generate_entry_hour();
                int entry_min = AutoTimeGenerator.generate_entry_min();
                int exit_hr = AutoTimeGenerator.generate_exit_hour();
                int exit_min = AutoTimeGenerator.generate_exit_min();

                // coverting entry time into HH:MM Format
                String entry = "";

                if (entry_hr < 10) {
                    entry += "0";
                }

                entry += Integer.toString(entry_hr);

                entry += ":";

                if (entry_min < 10) {
                    entry += "0";
                }
                entry += Integer.toString(entry_min);

                // coverting exit time into HH:MM Format

                String exit = "";

                if (exit_hr < 10) {
                    exit += "0";
                }

                exit += Integer.toString(exit_hr);

                exit += ":";

                if (exit_min < 10) {
                    exit += "0";
                }

                exit += Integer.toString(exit_min);

                
                a[i][j] = new Attendance(date, entry, exit);


                // printing auto generated d time
    
                System.out.println("Date : " + (j + 1) + "/" + (i + 1));
                System.out.println("Entry Time : " + entry);
                System.out.println("Exit Time : " + exit);
                System.out.println("Duration : " + (a[i][j].duration / 60) + " hr " + (a[i][j].duration % 60) + " mins");
                System.out.println();
            }
        }

        Scanner sc = new Scanner(System.in);

        System.out.println();
        System.out.println();
        System.out.print("Enter Month For which you want to see Attendance : ");
        int month_number = sc.nextInt();
        System.out.println();
        System.out.println();

        emp1.month_wise_display(month_number);

        System.out.println();
        System.out.println();
        System.out.print("Enter Day For which you want to see Attendance : ");
        String s = sc.next();
        System.out.println();

        int date = (s.charAt(0) - '0') * 10 + (s.charAt(1) - '0');
        int month = (s.charAt(3) - '0') * 10 + (s.charAt(4) - '0');

        int dur = emp1.count_time(date, month);
        System.out.println("Working Hour for " + (date) + "/" + (month) + " : " + (dur / 60) + " hr " + (dur % 60) + " mins");

        System.out.println();
        System.out.println();

        System.out.println("Calculating Total Working Days for EMP1 in a year");

        System.out.println();

        int work_day = emp1.count_working_days();
        System.out.println("Total Working Days : " + work_day + "/360\n");

        sc.close();

    }

}
