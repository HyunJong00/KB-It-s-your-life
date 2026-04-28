package day_035_collection.src.ch15;

import java.util.LinkedList;
import java.util.Queue;

public class QueueExample {
    public static void main(String[] args) {
        Queue<Message> messageQueue = new LinkedList<>();
        messageQueue.offer(new Message("sendMail", "hong"));
        messageQueue.offer(new Message("sendSMS", "park"));
        messageQueue.offer(new Message("sendKaKaoTalk", "kim"));


        //SRP 위반 : 메일보내기, 문자보내기, 카카오톡 보내기 여러 기능
        while(!messageQueue.isEmpty()) {
            Message message = messageQueue.poll();
            switch(message.command()){
                case "sendMail":
                    System.out.println(message.to() + "님에게 메일을 보냅니다");
                    break;
                case "sendSMS":
                    System.out.println(message.to() + "님에게 SMS를 보냅니다.");
                    break;
                case "sendKaKaoTalk":
                    System.out.println(message.to() + "님에게 카카오톡을 보냅니다.");
                    break;
            }
        }
    }
}
