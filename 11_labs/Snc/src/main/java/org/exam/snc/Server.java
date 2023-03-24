package org.nhnacademy.snc;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 서버 모드.
 */
public class Server {
    String port;

    public Server(String port) {
        this.port = port;
    }

    /**
     * 입력인자로 listen 포트를 입력 받고, 해당 포트로 TCP 서버를 실행하여 접속을 기다린다.
     * 클라이언트가 접속하여 데이터를 보내면 표준 출력하고, 사용자의 입력을 클라이언트로 전송한다.
     */
    public static class Handler implements Runnable {
        Socket socket;
        String line;

        public Handler(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try {
                BufferedReader input
                        = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                BufferedWriter output
                        = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

                while (!Thread.currentThread().isInterrupted()) {
                    line = input.readLine();

                    writer.write(line);
                    writer.newLine();
                    writer.flush();

                    output.write(reader.readLine());
                    output.newLine();
                    output.flush();
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

    }

    /**
     * 서버에 클라이언트가 접속하면 Handler 를 시작한다.
     */
    public void start() {
        try (ServerSocket serverSocket = new ServerSocket(Integer.parseInt(this.port))) {
            while (!Thread.interrupted()) {
                System.out.println("연결을 기다립니다.");

                synchronized (serverSocket) {
                    Handler handler = new Handler(serverSocket.accept());
                    System.out.println("연결이 되었습니다.");
                    handler.run();
                }
                System.out.println("연결이 끊어졌습니다.");
            }



        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("프로그램을 종료합니다.");
    }
}

class Shutdown implements Runnable {
    public void run(){
        System.out.println("system down");
    }
    public static void main(String[] args) throws Exception {
        Runtime r = Runtime.getRuntime();

        //프로그램 종료시(CTRL+C를 누르는 경우도 해당)실행 할 쓰레드를 JVM에 알려 줍니다.
        r.addShutdownHook(new Thread(new Shutdown()));

        //1초 간격으로 "PRESS CTRL+C to EXIT"라는 문자열을 출력 합니다.
        for(int i=0; i<20; i++) {
            Thread.sleep(1000);
        }
    }
}
