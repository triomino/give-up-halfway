package indi.zya.api.websockets;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

import indi.zya.model.GameStub;

import java.io.IOException;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;


@ServerEndpoint("/ws/beginner")
public class Beginner {
    // TODO: Decoupling user session management and game control

    private Session session;
    private static final Set<Beginner> connections =
            new CopyOnWriteArraySet<>();

    private GameStub gameStub = new GameStub();

    @OnOpen
    public void start(Session session) {
        this.session = session;
        if (connections.size() == 0) {
            GameStub.start();
        }
        connections.add(this);
    }

    @OnMessage
    public void receivePlayerState(Session session, String raw) {
        this.gameStub.updateState(raw);
    }

    @OnClose
    public void leave() {
        gameStub.leave();
        connections.remove(this);
    }

    static public void sendState() {
        for (Beginner client: connections) {
            try {
                synchronized (client) {
                    client.session.getBasicRemote().sendText(client.gameStub.getState());
                }
            } catch (IOException e) {
                connections.remove(client);
            }
        }
    }

}
