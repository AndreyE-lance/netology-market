package senders;

public class SendBySms implements Sendable{
    @Override
    public String send() {
        return "На ваш телефон отправлено уведомление.";
    }
}
