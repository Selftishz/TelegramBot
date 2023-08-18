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

public class Bot extends TelegramLongPollingBot {
    private static Menu menu = new Menu();
    private static Long chatId = 0L;
    public static void main( String[] args ) throws TelegramApiException {
        TelegramBotsApi botsApi = new TelegramBotsApi(DefaultBotSession.class);
        Bot bot = new Bot();
        botsApi.registerBot(bot);
        menu.setDefaultCommand(bot);
    }

    @Override
    public void onUpdateReceived(Update update) {
        try {
            if (update.hasMessage()) {
                String messageText = update.getMessage().getText();
                SendMessage sendMessage = new SendMessage();
                sendMessage.setChatId(update.getMessage()
                        .getChatId()
                        .toString());
                if (messageText.equals("/start")) {
                    sendMessage.setReplyMarkup(menu.setDefaultButtons());
                    chatId = update.getMessage().getChatId();
                }

                sendMessage.setReplyMarkup(menu.setDefaultButtons());

                sendMessage.setText("/start");
                execute(sendMessage);
                String message = update.getMessage().getText();

            } else {


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
