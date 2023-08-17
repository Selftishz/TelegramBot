package org.example;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

import javax.sound.midi.MetaMessage;
import java.util.List;
import java.util.Map;

/**
 * Hello world!
 *
 */
public class App extends TelegramLongPollingBot {
    public static void main( String[] args ) throws TelegramApiException {
        TelegramBotsApi botsApi = new TelegramBotsApi(DefaultBotSession.class);
        botsApi.registerBot(new App());
        var actions = Map.of(
                "/start", new RepeatTextAction(
                        List.of(
                                "/start - Start a bot")
                ),
                "/echo", new EchoAction("/echo"),
                "/new", new RegAction()
        );
    }

    @Override
    public void onUpdateReceived(Update update) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(update.getMessage()
                                    .getChatId()
                                    .toString());
        try {
            if (update.hasMessage()) {
                String message = update.getMessage().getText();

            } else {
                sendMessage.setText("Please, send a message");
                execute(sendMessage);
            }
        } catch (TelegramApiException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public String getBotToken() {
        return "6579569720:AAEFK2T7-nUKzD7yBJmWbLXgGHR1hbtgnFQ";
    }

    @Override
    public String getBotUsername() {
        return "@toutubeMP4ToMP3Bot";
    }
}
