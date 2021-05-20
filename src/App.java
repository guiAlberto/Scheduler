import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class App {

    private static final TemporalUnit TIME = ChronoUnit.HOURS;
    private static final int TOTAL = 8;

    public static void main(String[] args) {
        var times = Stream.of(args).map(LocalTime::parse).collect(Collectors.toList());

        var startWorking = times.get(0);
        var startPause = times.get(1);
        var endPause = times.get(2);

        var firstShift = TIME.between(startWorking, startPause);
        var endWork = endPause.plus(TOTAL, TIME).minus(firstShift, TIME);

        var message = String.format("Seu expediente termina às %s", endWork);
        Logger.getGlobal().info(message);

    }
}
