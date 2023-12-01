package ArturKuznetsov.lab7.task14;

import java.io.*;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class Client implements Runnable {

    private Socket client;
    private BufferedReader in;
    private PrintWriter out;
    private boolean done;
    @Override
    public void run() {
        try (var client = new Socket("127.0.0.1", 8000);
             var out = new PrintWriter(new OutputStreamWriter(client.getOutputStream(), StandardCharsets.UTF_8), true);
             var in = new BufferedReader(new InputStreamReader(client.getInputStream(), StandardCharsets.UTF_8))) {
            this.client = client;
            this.out = out;
            this.in = in;

            BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Please enter your nickname: ");
            String nickname = consoleReader.readLine();
            out.println(nickname);

            String BOLD = "\u001B[1m";
            String RESET = "\u001B[0m";
            String boldNickname = BOLD + nickname + RESET;

            InputHandler inHandler = new InputHandler();
            Thread t = new Thread(inHandler);
            t.start();

            String inMessage;
            while ((inMessage = in.readLine()) != null) {
                if (!inMessage.startsWith(boldNickname + ":")) {
                    System.out.println(inMessage);
                }
            }
        } catch (IOException e) {
            shutdown();
        }
    }

    private void shutdown() {
        done = true;
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
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    class InputHandler implements Runnable {

        @Override
        public void run() {
            try (BufferedReader inReader = new BufferedReader(new InputStreamReader(System.in))) {
                while (!done) {
                    String message = inReader.readLine();
                    if (message.equals("/quit")) {
                        out.println(message);
                        inReader.close();
                        shutdown();
                    } else {
                        out.println(message);
                    }
                }
            } catch (IOException e) {
                shutdown();
            }
        }
    }

    public static void main(String[] args) {
        Client client = new Client();
        client.run();
    }
}
