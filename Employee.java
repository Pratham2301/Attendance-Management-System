public class Employee {

    int id;
    String name;
    int age;
    String designation;
    double salary;
    Attendance attd[][];

    Employee() {
    }

    Employee(int id, String name, int age, String designation, double salary, Attendance attd[][]) {

        this.id = id;
        this.name = name;
        this.age = age;
        this.designation = designation;
        this.salary = salary;
        this.attd = attd;

    }

    void display() {
        System.out.println();
        System.out.println("ID : " + this.id);
        System.out.println("Name : " + this.name);
        System.out.println("Age : " + this.age);
        System.out.println("Designation : " + this.designation);
        System.out.println("Salary : " + this.salary);
        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 10; j++) {
                attd[i][j].display_attendance();
            }
        }
        System.out.println();
    }

    void month_wise_display(int month_no) {

        if (month_no > 12 || month_no < 1) {
            System.out.println("\n\nInvalid Month\n\n");
            return;
        }

        System.out.println();
        System.out.println("ID : " + this.id);
        System.out.println("Name : " + this.name);
        System.out.println("Age : " + this.age);
        System.out.println("Designation : " + this.designation);
        System.out.println("Salary : " + this.salary);
        System.out.println();
        for (int i = 0; i < 30; i++) {
            attd[month_no - 1][i].display_attendance();
        }
        System.out.println();
    }

    int count_time(int date, int month) {

        int d = attd[month - 1][date - 1].duration;
        return d;

    }

    int count_working_days() {
        int ans = 0;

        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 30; j++) {
                int d = attd[i ][j].duration;

                if (d != 0) {
                    ans++;
                }
            }
        }

        return ans;

    }

}