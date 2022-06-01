public class Attendance {

    String date;
    String time_in;
    String time_out;
    int duration;

    // Time Format : 09:25
    // Time Format : 18:07

    Attendance() {
    }

    int find_duration(String time_in, String time_out) {

        int ans = 0;

        if (time_in == time_out) {
            return 0;
        }

        if (time_in == "" || time_out == "") {
            return 0;
        }

        int hr1 = (time_in.charAt(0)) * 10 + (time_in.charAt(1));
        int min1 = (time_in.charAt(3)) * 10 + (time_in.charAt(4));

        int hr2 = (time_out.charAt(0)) * 10 + (time_out.charAt(1));
        int min2 = (time_out.charAt(3)) * 10 + (time_out.charAt(4));

        if (hr1 > hr2) {
            return 0;
        } 
        if (hr1 == hr2 && min1 > min2) {
            return 0;
        } 
        
        if (min1 < min2) {
            ans += (hr2 - hr1) * 60 + (min2 - min1);
        } else {
            ans += (hr2 - hr1 - 1) * 60 + (60 - (min1 - min2));
        }

        // System.out.println(ans);

        return ans;

    }

    Attendance(String date, String time_in, String time_out) {
        this.date = date;
        this.time_in = time_in;
        this.time_out = time_out;
        this.duration = find_duration(this.time_in, this.time_out);
    }

    void display_attendance() {
        // System.out.println("Date : " + this.date);
        // System.out.println("Entry : " + this.time_in);
        // System.out.println("Exit : " + this.time_out);
        // System.out.println("Duration : " + this.duration);
        // System.out.println("duration : "+this.duration);
        System.out.println(this.date + " - " + (this.duration / 60) + " hr " + (this.duration % 60) + " mins");
    }

}
