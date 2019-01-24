package indi.zya.model;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

import static indi.zya.model.Camp.CAT;
import static indi.zya.model.Camp.DOG;

public class Player {
    private double x, y;
    private Camp camp;
    private int id;

    // TODO: replace this to user id
    private static final AtomicInteger playerIds = new AtomicInteger(0);

    private static final List<Player> players = new CopyOnWriteArrayList<>();

    private static final List<Camp> campsThatPlayerCanAttend = List.of(CAT, DOG);

    Player() {
        // Very few camps, no need to use map
        int campSize = campsThatPlayerCanAttend.size();
        int []count = new int[campSize];
        players.stream().map(it -> it.camp).forEach(camp -> {
            for (int i = 0; i < campSize; ++i) {
                if (campsThatPlayerCanAttend.get(i) == camp) {
                    ++count[i];
                }
            }
        });
        int cat = count[0], dog = count[1];
        if (cat < dog) {
            camp = CAT;
        }
        else {
            camp = DOG;
        }

        x = y = 50 * players.size() + 100;
        id = playerIds.getAndIncrement();
        players.add(this);
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    void setPos(double x, double y) {
        this.y = y;
        this.x = x;
    }

    String getVisibleState() {
        // TODO: It is terrible to maintain string myself. Use grpc later.
        return String.format("{\"players\":{%s},\"me\":%d}", players.stream().map(player -> String.format("\"%d\":{\"x\":%f,\"y\":%f}",player.id, player.x, player.y))
                .collect(Collectors.joining(",")), this.id);
    }

    void leave() {
        players.remove(this);
    }
}
