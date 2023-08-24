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

        KeyboardRow keyboardRow1 = new KeyboardRow();
        keyboardRow1.add(new KeyboardButton("Barcelona"));
        KeyboardRow keyboardRow2 = new KeyboardRow();
        keyboardRow2.add(new KeyboardButton("Real Madrid"));
        KeyboardRow keyboardRow3 = new KeyboardRow();
        keyboardRow3.add(new KeyboardButton("Atletico Madrid"));
        KeyboardRow keyboardRow4 = new KeyboardRow();
        keyboardRow4.add(new KeyboardButton("Real Sociedad"));
        KeyboardRow keyboardRow5 = new KeyboardRow();
        keyboardRow5.add(new KeyboardButton("Valencia"));
        KeyboardRow keyboardRow6 = new KeyboardRow();
        keyboardRow6.add(new KeyboardButton("Athletic"));
        KeyboardRow keyboardRow7 = new KeyboardRow();
        keyboardRow7.add(new KeyboardButton("Celta"));
        KeyboardRow keyboardRow8 = new KeyboardRow();
        keyboardRow8.add(new KeyboardButton("Betis"));
        KeyboardRow keyboardRow9 = new KeyboardRow();
        keyboardRow9.add(new KeyboardButton("Sevilla"));
        KeyboardRow keyboardRow10 = new KeyboardRow();
        keyboardRow10.add(new KeyboardButton("Rayo Vallecano"));
        KeyboardRow keyboardRow11 = new KeyboardRow();
        keyboardRow11.add(new KeyboardButton("Alaves"));
        KeyboardRow keyboardRow12 = new KeyboardRow();
        keyboardRow12.add(new KeyboardButton("Girona"));
        KeyboardRow keyboardRow13 = new KeyboardRow();
        keyboardRow13.add(new KeyboardButton("Osasuna"));
        KeyboardRow keyboardRow14 = new KeyboardRow();
        keyboardRow14.add(new KeyboardButton("Cadiz"));
        KeyboardRow keyboardRow15 = new KeyboardRow();
        keyboardRow15.add(new KeyboardButton("Mallorca"));
        KeyboardRow keyboardRow16 = new KeyboardRow();
        keyboardRow16.add(new KeyboardButton("Celta"));
        KeyboardRow keyboardRow17 = new KeyboardRow();
        keyboardRow17.add(new KeyboardButton("Almeria"));
        KeyboardRow keyboardRow18 = new KeyboardRow();
        keyboardRow18.add(new KeyboardButton("Granada"));
        KeyboardRow keyboardRow19 = new KeyboardRow();
        keyboardRow19.add(new KeyboardButton("Villarreal"));
        KeyboardRow keyboardRow20 = new KeyboardRow();
        keyboardRow20.add(new KeyboardButton("Granada"));

        Collections.addAll(buttonList, keyboardRow1, keyboardRow2, keyboardRow3, keyboardRow4, keyboardRow5, keyboardRow6, keyboardRow7,
                keyboardRow8, keyboardRow9, keyboardRow10, keyboardRow11, keyboardRow12, keyboardRow13, keyboardRow14, keyboardRow15, keyboardRow16,
                keyboardRow17, keyboardRow18, keyboardRow19, keyboardRow20);
        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup(buttonList, true,
                false, false, "/command", false);
        return replyKeyboardMarkup;
    }

    public ReplyKeyboardMarkup setClubButtons(String squadText, String upcomingMatchesText) {

        List<KeyboardRow> buttonList = new ArrayList<>();

        KeyboardRow keyboardRowConverter = new KeyboardRow();
        keyboardRowConverter.add(new KeyboardButton(squadText));
        KeyboardRow keyboardRowZipConverter = new KeyboardRow();
        keyboardRowConverter.add(new KeyboardButton(upcomingMatchesText));
        Collections.addAll(buttonList, keyboardRowConverter, keyboardRowZipConverter);
        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup(buttonList, true,
                false, false, "/command", false);
        return replyKeyboardMarkup;
    }

}
