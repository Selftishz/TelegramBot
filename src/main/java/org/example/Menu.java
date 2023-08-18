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
    private static List<KeyboardRow> buttonList = new ArrayList<>();
    public void setDefaultCommand(Bot bot) {

        commandList.add(new BotCommand("/converter", "Convert Youtube video to .mp3"));
        commandList.add(new BotCommand("/start", "To start a bot"));
        try {
            bot.execute(new SetMyCommands(commandList, new BotCommandScopeDefault(), null));
        } catch (TelegramApiException ex) {
            ex.printStackTrace();
        }
    }
    public ReplyKeyboardMarkup setDefaultButtons() {
        KeyboardRow keyboardRowConverter = new KeyboardRow();
        keyboardRowConverter.add(new KeyboardButton("Simple converter"));
        KeyboardRow keyboardRowZipConverter = new KeyboardRow();
        keyboardRowConverter.add(new KeyboardButton("Zip-converter"));
        Collections.addAll(buttonList, keyboardRowConverter, keyboardRowZipConverter);
        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup(buttonList, true,
                true, false, "/converter", false);
        return replyKeyboardMarkup;
    }
}
