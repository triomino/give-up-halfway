package indi.zya.model;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

import static indi.zya.model.Camp.CAT;
import static indi.zya.model.Camp.DOG;

public class Player {
    private double x, y;
    private double toX, toY;
    private PlayerState playerState = PlayerState.IDLE;
    private double speed = 0.8;
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

    void setMovingTo(double x, double y) {
        playerState = PlayerState.MOVING;
        toX = x;
        toY = y;
    }

    String getVisibleState() {
        // TODO: It is terrible to maintain string myself. Use grpc or other tool later.
        return String.format("{\"players\":{%s},\"me\":%d}", players.stream().map(player -> String.format(
                "\"%d\":{\"x\":%f,\"y\":%f, \"s\":%f}",player.id, player.x, player.y, player.speed
                )
        ).collect(Collectors.joining(",")), this.id);
    }

    private void move() {
        if (playerState == PlayerState.MOVING) {
            double len = Math.sqrt((toX - x) * (toX - x) + (toY - y) * (toY - y));
            if (len <= speed) {
                x = toX;
                y = toY;
            }
            else {
                x += (toX-x) / len * speed;
                y += (toY-y) / len * speed;
            }
        }
    }

    static void moveAll() {
        players.forEach(Player::move);
    }

    void leave() {
        players.remove(this);
    }
}
