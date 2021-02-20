package senders;

public class SendByEmail implements Sendable{
    @Override
    public String send() {
        return "На ваш почтовый ящик отправлено уведомление.";
    }
}
