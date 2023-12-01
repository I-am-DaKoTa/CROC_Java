package ArturKuznetsov.lab7.task14;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server implements Runnable {

    private ArrayList<ConnectionHandler> connections;
    private ServerSocket server;
    private boolean done;
    private ExecutorService pool;

    public Server() {
        connections = new ArrayList<>();
        done = false;
    }

    @Override
    public void run() {
        try (var server = new ServerSocket(8000)) {
            this.server = server;
            pool = Executors.newCachedThreadPool();
            while (!done) {
                Socket client = server.accept();
                ConnectionHandler handler = new ConnectionHandler(client);
                connections.add(handler);
                pool.execute(handler);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            shutdown();
        }
    }

    public void broadcast(String message) {
        List<ConnectionHandler> copyConnections = new ArrayList<>(connections);
        for (ConnectionHandler ch : copyConnections) {
            if (ch != null) {
                ch.sendMessage(message);
            }
        }
    }

    public void shutdown() {
        try {
            done = true;
            if (pool != null) {
                pool.shutdown();
            }
            if (server != null && !server.isClosed()) {
                server.close();
            }
            for (ConnectionHandler ch : connections) {
                ch.shutdown();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    class ConnectionHandler implements Runnable {

        private Socket client;
        private BufferedReader in;
        private PrintWriter out;
        private String nickname;

        public  ConnectionHandler(Socket client) {
            this.client = client;
        }
        @Override
        public void run() {
            try (var out = new PrintWriter(new OutputStreamWriter(client.getOutputStream(), StandardCharsets.UTF_8), true);
                 var in = new BufferedReader(new InputStreamReader(client.getInputStream(), StandardCharsets.UTF_8))){
                this.out = out;
                this.in = in;
                nickname = in.readLine();
                String BOLD = "\u001B[1m";
                String RESET = "\u001B[0m";
                String boldNickname = BOLD + nickname + RESET;
                broadcast(boldNickname + " connected");
                String message;
                while (!Thread.currentThread().isInterrupted() && (message = in.readLine()) != null && !message.startsWith(boldNickname + ": ")) {
                    if (message.startsWith("/quit")) {
                        shutdown();
                        broadcast(boldNickname + " left the chat");
                    } else if (!message.isEmpty()) {
                        String ITALIC = "\u001B[3m";
                        LocalDateTime time = LocalDateTime.now();
                        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
                        broadcast(boldNickname + ": " + message + ITALIC + " (" + time.format(formatter) + ")" + RESET);
                    }

                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            } finally {
                shutdown();
            }
        }

        public synchronized void sendMessage(String message) {
            out.println(message);
        }

        public void shutdown() {
            try {
                if (in != null) {
                    in.close();
                }
                if (out != null) {
                    out.close();
                }
                if (client != null && !client.isClosed()) {
                    client.close();
                }
            }
            catch (IOException e) {
                throw new RuntimeException(e);
            } finally {
                Thread.currentThread().interrupt();
            }
        }
    }

    public static void main(String[] args) {
        Server server = new Server();
        server.run();
    }
}
