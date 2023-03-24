package org.nhnacademy.snc;

import java.io.*;
import java.net.Socket;

/**
 * 클라이언트 모드.
 */
public class Client {
    String host;
    String port;

    public Client(String host, String port) {
        this.host = host;
        this.port = port;
    }

    /**
     * 입력인자로 받은 서버에 TCP 연결을 한다.
     * 사용자로부터의 입력을 서버로 전송하고, 서버로부터 받은 데이터는 표준 출력을 한다.
     */
    public void start() {
        try (Socket socket = new Socket(this.host, Integer.parseInt(this.port))) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

            BufferedWriter output =
                    new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            BufferedReader input =
                    new BufferedReader(new InputStreamReader(socket.getInputStream()));

            Thread inputThread = new Thread(() -> {
                try {
                    while (!Thread.interrupted()) {
                        writer.write(input.readLine());
                        writer.newLine();
                        writer.flush();
                    }
                } catch (IOException e) {
                    Thread.currentThread().interrupt();
                }
            });

            Thread outputThread = new Thread(() -> {
                try {
                    while (!Thread.interrupted()) {

                        String line = reader.readLine();
                        output.write(line);
                        output.newLine();
                        output.flush();
                    }
                } catch (IOException e) {
                    Thread.currentThread().interrupt();
                }
            });

            inputThread.start();
            outputThread.start();

            inputThread.join();
            outputThread.join();
        } catch (IOException ignore) {
            System.err.println("연결을 실패하였습니다.");
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
