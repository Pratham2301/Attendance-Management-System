public class AutoTimeGenerator {

    // generates random time between 1-11 hr
    static int generate_entry_hour() {
        int ans = (int) (1 + (Math.random() * 15));
        return ans;
    }

    // generates random time between 1-59 min
    static int generate_entry_min() {
        int ans = (int) (1 + (Math.random() *  58));
        return ans;
    }

    // generates random time between 10-24 hr
    static int generate_exit_hour() {
        int ans = (int) (10 + (Math.random() * 14));
        return ans;
    }

    // generates random time between 1-59 min
    static int generate_exit_min() {
        int ans = (int) (1 + (Math.random() *  58));
        return ans;
    }
    
}
