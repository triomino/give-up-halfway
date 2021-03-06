package indi.zya.model;

import indi.zya.api.websockets.Beginner;
import org.json.JSONObject;

import java.util.Timer;
import java.util.TimerTask;

public class GameStub {
    private Player player = new Player();

    static public final int period = 40;

    public static void start() {
        Timer timer = new Timer("Timer" + GameStub.class.getSimpleName());
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                try {
                    GameStub.selfUpdateState();
                    Beginner.sendState();
                } catch (RuntimeException ignored) {
//                    log.error("Caught to prevent timer from shutting down", e);
                }
            }
        }, period, period);
    }

    public void updateState(String raw) {
        JSONObject state = new JSONObject(raw);
        // TODO: do not trust the client
        player.setMovingTo(state.getJSONObject("movingTo").getDouble("x"), state.getJSONObject("movingTo").getDouble("y"));

    }

    static private void selfUpdateState() {
        Player.moveAll();
    }

    public String getState() {
        // TODO: check whether is faster, JSON or String builder.
        // use proto-buf if possible
        return player.getVisibleState();
    }

    public void leave() {
        player.leave();
    }
}
