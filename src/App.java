import static java.time.temporal.ChronoUnit.HOURS;
import static java.time.temporal.ChronoUnit.MINUTES;

import java.time.LocalTime;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class App {

    private static final int TOTAL = 8;

    public static void main(String[] args) {
        var times = Stream.of(args).map(LocalTime::parse).collect(Collectors.toList());

        var startWorking = times.get(0);
        var startPause = times.get(1);
        var endPause = times.get(2);

        var firstShift = MINUTES.between(startWorking, startPause);
        var endWork = endPause.plus(TOTAL, HOURS).minus(firstShift, MINUTES);

        var message = String.format("Seu expediente termina às %s", endWork);
        Logger.getGlobal().info(message);

    }
}
