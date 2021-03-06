package com.example.Toy_project;

import com.example.Toy_project.domain.Environment;
import com.example.Toy_project.service.EnvironService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.time.LocalDateTime;

import org.json.JSONObject;

@Component
@RequiredArgsConstructor
public class OpenClientSocket {


    private final EnvironService environService;
    @Scheduled(fixedRate = 100000)
    public void OpenSocket(){
        // 소켓을 선언한다.
        try (Socket client = new Socket()) {
            // 소켓에 접속하기 위한 접속 정보를 선언한다.
            InetSocketAddress ipep = new InetSocketAddress("127.0.0.1", 9999);
            // 소켓 접속!
            client.connect(ipep);
            // 소켓이 접속이 완료되면 inputstream과 outputstream을 받는다.
            try (OutputStream sender = client.getOutputStream(); InputStream receiver = client.getInputStream();) {
                // 메시지는 for 문을 통해 10번 메시지를 전송한다.
                for (int i = 0; i < 1; i++) {
                    // 전송할 메시지를 작성한다.
                    String msg = "java test message - " + i;
                    // string을 byte배열 형식으로 변환한다.
                    byte[] data = msg.getBytes();
                    // ByteBuffer를 통해 데이터 길이를 byte형식으로 변환한다.
                    ByteBuffer b = ByteBuffer.allocate(4);
                    // byte포멧은 little 엔디언이다.
                    b.order(ByteOrder.LITTLE_ENDIAN);
                    b.putInt(data.length);
                    // 데이터 길이 전송
                    sender.write(b.array(), 0, 4);
                    // 데이터 전송
                    sender.write(data);
                    data = new byte[4];
                    // 데이터 길이를 받는다.
                    receiver.read(data, 0, 4);
                    // ByteBuffer를 통해 little 엔디언 형식으로 데이터 길이를 구한다.
                    ByteBuffer bb = ByteBuffer.wrap(data);
                    bb.order(ByteOrder.LITTLE_ENDIAN);
                    int length = bb.getInt();
                    // 데이터를 받을 버퍼를 선언한다.
                    data = new byte[length];
                    // 데이터를 받는다.
                    receiver.read(data, 0, length);
                    // byte형식의 데이터를 string형식으로 변환한다.

                    Environment environment = new Environment();
                    msg = new String(data, "UTF-8");
                    JSONObject jsonObject = new JSONObject(msg);
                    int time = jsonObject.getInt("time");
                    int  temperature = jsonObject.getInt("temperature");
                    int  humidity = jsonObject.getInt("humidity");
                    int illumination = jsonObject.getInt("illumination");
                    System.out.println(jsonObject+"HI");

                    environment.setTime(LocalDateTime.now());
                    environment.setTemperature(temperature);
                    environment.setHumidity(humidity);
                    environment.setIlluminace(illumination);
                    environService.save(environment);
                    // 콘솔에 출력한다.
                    System.out.println("100초후 실행");
                    System.out.println(msg);
                }
            }
        } catch (Throwable e) {
            e.printStackTrace();
        }
    }

}

