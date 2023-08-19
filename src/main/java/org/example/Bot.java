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
import java.util.List;
import java.util.Map;

public class Bot extends TelegramLongPollingBot {
    private static Menu menu = new Menu();
    private static String chatId = "";

    private SimpleConverter simpleConverter;
    public static void main( String[] args ) throws TelegramApiException {
        TelegramBotsApi botsApi = new TelegramBotsApi(DefaultBotSession.class);
        Bot bot = new Bot();
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
                    startHandler();
                } else if ((messageText.equals("/converter")) || (messageText.equals("Simple converter"))) {
                    simpleConverter = new SimpleConverter();
                    sendMessage.setText("Converter created");
                    execute(sendMessage);
                } else if (messageText.equals("/closetest")) {
                    createSecondPanel();
                } else {
                    sendMessage.setText("Not a command");
                    execute(sendMessage);
                }
            } else {}
        } catch (TelegramApiException ex) {
            ex.printStackTrace();

        }
    }

    public void startHandler() throws TelegramApiException {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setText("Default buttons");
        sendMessage.setChatId(chatId);
        sendMessage.setReplyMarkup(menu.setDefaultButtons());
        execute(sendMessage);
    }

    public void createSecondPanel() throws TelegramApiException {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setText("Refactored buttons");
        sendMessage.setChatId(chatId);
        sendMessage.setReplyMarkup(menu.setRefactoredButtons());
        execute(sendMessage);
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
