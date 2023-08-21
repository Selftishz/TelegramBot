package org.example;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class Handlers {
    private String chatId;
    private Bot bot;
    private Menu menu;
    public void startHandler() throws TelegramApiException {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setText("Default buttons");
        sendMessage.setChatId(chatId);
        sendMessage.setReplyMarkup(menu.setDefaultButtons());
        bot.execute(sendMessage);
    }

    public void clubBarcelona() throws TelegramApiException {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setText("Barcelona buttons");
        sendMessage.setChatId(chatId);
        sendMessage.setReplyMarkup(menu.setBarcelonaButtons());
        bot.execute(sendMessage);
    }

    public void clubRealMadrid() throws TelegramApiException {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setText("Real Madrid buttons");
        sendMessage.setChatId(chatId);
        sendMessage.setReplyMarkup(menu.setRealMadridButtons());
        bot.execute(sendMessage);
    }

    public void setChatId(String chatId) {
        this.chatId = chatId;
    }

    public void setBot(Bot bot) {
        this.bot = bot;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }
}
