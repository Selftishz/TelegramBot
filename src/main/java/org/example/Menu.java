package org.example;

import org.telegram.telegrambots.meta.api.methods.commands.SetMyCommands;
import org.telegram.telegrambots.meta.api.objects.commands.BotCommand;
import org.telegram.telegrambots.meta.api.objects.commands.scope.BotCommandScopeDefault;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Menu {
    private static List<BotCommand> commandList = new ArrayList<>();

    public void setDefaultCommand(Bot bot) {

        commandList.add(new BotCommand("/start", "To start a bot"));
        commandList.add(new BotCommand("/barcelona", "Choose Barcelona"));
        commandList.add(new BotCommand("/realmadrid", "Choose Real Madrid"));


        try {
            bot.execute(new SetMyCommands(commandList, new BotCommandScopeDefault(), null));
        } catch (TelegramApiException ex) {
            ex.printStackTrace();
        }
    }
    public ReplyKeyboardMarkup setDefaultButtons() {

        List<KeyboardRow> buttonList = new ArrayList<>();

        KeyboardRow keyboardRowConverter = new KeyboardRow();
        keyboardRowConverter.add(new KeyboardButton("Barcelona"));
        KeyboardRow keyboardRowZipConverter = new KeyboardRow();
        keyboardRowConverter.add(new KeyboardButton("Real Madrid"));
        Collections.addAll(buttonList, keyboardRowConverter, keyboardRowZipConverter);
        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup(buttonList, true,
                false, false, "/club", false);
        return replyKeyboardMarkup;
    }

    public ReplyKeyboardMarkup setBarcelonaButtons() {

        List<KeyboardRow> buttonList = new ArrayList<>();

        KeyboardRow keyboardRowConverter = new KeyboardRow();
        keyboardRowConverter.add(new KeyboardButton("Barcelona squad"));
        KeyboardRow keyboardRowZipConverter = new KeyboardRow();
        keyboardRowConverter.add(new KeyboardButton("Barcelona matches"));
        Collections.addAll(buttonList, keyboardRowConverter, keyboardRowZipConverter);
        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup(buttonList, true,
                false, false, "/barcelonasquad", false);
        return replyKeyboardMarkup;
    }

    public ReplyKeyboardMarkup setRealMadridButtons() {

        List<KeyboardRow> buttonList = new ArrayList<>();

        KeyboardRow keyboardRowConverter = new KeyboardRow();
        keyboardRowConverter.add(new KeyboardButton("Real Madrid squad"));
        KeyboardRow keyboardRowZipConverter = new KeyboardRow();
        keyboardRowConverter.add(new KeyboardButton("Real Madrid matches"));
        Collections.addAll(buttonList, keyboardRowConverter, keyboardRowZipConverter);
        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup(buttonList, true,
                false, false, "/realmadridsquad", false);
        return replyKeyboardMarkup;
    }
}
