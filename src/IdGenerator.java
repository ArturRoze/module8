import java.util.Random;

public final class IdGenerator {

    static Random random = new Random();

    private IdGenerator() {
    }

    public static long generateUniqueId() {
        return random.nextInt(100);
    }
}
