package org.example;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardRemove;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

import javax.sound.midi.MetaMessage;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class Bot extends TelegramLongPollingBot {
    private static Menu menu = new Menu();
    private static String chatId = "";
    private Handlers handlers = new Handlers();

    private static Bot bot = new Bot();
    public static void main( String[] args ) throws TelegramApiException {
        TelegramBotsApi botsApi = new TelegramBotsApi(DefaultBotSession.class);

        menu.setDefaultCommand(bot);
        botsApi.registerBot(bot);
    }

    @Override
    public void onUpdateReceived(Update update) {
        try {
            if (update.hasMessage()) {
                String messageText = update.getMessage().getText();
                SendMessage sendMessage = new SendMessage();
                chatId = update.getMessage()
                        .getChatId()
                        .toString();
                if (messageText.equals("/start")) {
                    handlers.setBot(bot);
                    handlers.setMenu(menu);
                    handlers.setChatId(chatId);
                    handlers.startHandler();
                } else if ((messageText.equals("/barcelona")) || (messageText.equals("Barcelona"))) {
                    handlers.clubBarcelona();
                } else if ((messageText.equals("/realmadrid")) || (messageText.equals("Real Madrid"))) {
                    handlers.clubRealMadrid();
                } else if (messageText.equals("Barcelona squad")) {

                } else if (messageText.equals("Barcelona matches")) {
                    handlers.barcelonaSquad();
                } else {
                    sendMessage.setText("Not a command");
                    execute(sendMessage);
                }
            } else {}
        } catch (TelegramApiException ex) {
            ex.printStackTrace();

        } catch (IOException e) {
            throw new RuntimeException(e);
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
