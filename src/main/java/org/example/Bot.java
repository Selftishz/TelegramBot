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
                    handlers.clubHandler("Barcelona squad", "Barcelona upcoming matches");
                } else if ((messageText.equals("/realmadrid")) || (messageText.equals("Real Madrid"))) {
                    handlers.clubHandler("Real Madrid squad", "Real Madrid upcoming matches");
                } else if ((messageText.equals("/atleticomadrid")) || (messageText.equals("Atletico Madrid"))) {
                    handlers.clubHandler("Atletico Madrid squad", "Atletico Madrid upcoming matches");
                } else if ((messageText.equals("/sevilla")) || (messageText.equals("sevilla"))) {
                    handlers.clubHandler("Sevilla squad", "Sevilla upcoming matches");
                } else if ((messageText.equals("/villarreal")) || (messageText.equals("villarreal"))) {
                    handlers.clubHandler("Villarreal squad", "Villarreal upcoming matches");
                } else if ((messageText.equals("/betis")) || (messageText.equals("Betis"))) {
                    handlers.clubHandler("Betis squad", "Betis upcoming matches");
                } else if ((messageText.equals("/realsociedad")) || (messageText.equals("Real Sociedad"))) {
                    handlers.clubHandler("Real Sociedad squad", "Real Sociedad upcoming matches");
                } else if ((messageText.equals("/athletic")) || (messageText.equals("Athletic"))) {
                    handlers.clubHandler("Athletic squad", "Athletic upcoming matches");
                } else if ((messageText.equals("/rayovallecano")) || (messageText.equals("Rayo Vallecano"))) {
                    handlers.clubHandler("Rayo Vallecano squad", "Rayo Vallecano upcoming matches");
                } else if ((messageText.equals("/valencia")) || (messageText.equals("Valencia"))) {
                    handlers.clubHandler("Valencia squad", "Valencia upcoming matches");
                } else if ((messageText.equals("/girona")) || (messageText.equals("Girona"))) {
                    handlers.clubHandler("Girona squad", "Girona upcoming matches");
                } else if ((messageText.equals("/alaves")) || (messageText.equals("Alaves"))) {
                    handlers.clubHandler("Alaves squad", "Alaves upcoming matches");
                } else if ((messageText.equals("/osasuna")) || (messageText.equals("Osasuna"))) {
                    handlers.clubHandler("Osasuna squad", "Osasuna upcoming matches");
                } else if ((messageText.equals("/cadiz")) || (messageText.equals("Cadiz"))) {
                    handlers.clubHandler("Cadiz squad", "Cadiz upcoming matches");
                } else if ((messageText.equals("/laspalmas")) || (messageText.equals("Las Palmas"))) {
                    handlers.clubHandler("Las Palmas squad", "Las Palmas upcoming matches");
                } else if ((messageText.equals("/mallorca")) || (messageText.equals("Mallorca"))) {
                    handlers.clubHandler("Mallorca squad", "Mallorca upcoming matches");
                } else if ((messageText.equals("/celta")) || (messageText.equals("Celta"))) {
                    handlers.clubHandler("Celta squad", "Celta upcoming matches");
                } else if ((messageText.equals("/almeria")) || (messageText.equals("Almeria"))) {
                    handlers.clubHandler("Almeria squad", "Almeria upcoming matches");
                } else if ((messageText.equals("/granada")) || (messageText.equals("Granada"))) {
                    handlers.clubHandler("Granada squad", "Granada upcoming matches");
                } else if (messageText.equals("Barcelona squad")) {
                    handlers.getSquad("https://www.sports.ru/barcelona/team/");
                } else if (messageText.equals("Barcelona upcoming matches")) {
                    handlers.getMatches("https://www.sports.ru/barcelona/calendar/");
                } else if (messageText.equals("Real Madrid squad")) {
                    handlers.getSquad("https://www.sports.ru/real/team/");
                } else if (messageText.equals("Real Madrid upcoming matches")) {
                    handlers.getMatches("https://www.sports.ru/real/calendar/");
                } else if (messageText.equals("Atletico Madrid squad")) {
                    handlers.getSquad("https://www.sports.ru/atletico/team/");
                } else if (messageText.equals("Atletico Madrid upcoming matches")) {
                    handlers.getMatches("https://www.sports.ru/atletico/calendar/");
                } else if (messageText.equals("Sevilla squad")) {
                    handlers.getSquad("https://www.sports.ru/sevilla/team/");
                } else if (messageText.equals("Sevilla upcoming matches")) {
                    handlers.getMatches("https://www.sports.ru/sevilla/calendar/");
                } else if (messageText.equals("Villarreal squad")) {
                    handlers.getSquad("https://www.sports.ru/villarreal/team/");
                } else if (messageText.equals("Villarreal upcoming matches")) {
                    handlers.getMatches("https://www.sports.ru/villarreal/calendar/");
                } else if (messageText.equals("Betis squad")) {
                    handlers.getSquad("https://www.sports.ru/betis/team/");
                } else if (messageText.equals("Betis upcoming matches")) {
                    handlers.getMatches("https://www.sports.ru/betis/calendar/");
                } else if (messageText.equals("Real Sociedad squad")) {
                    handlers.getSquad("https://www.sports.ru/real-sociedad/team/");
                } else if (messageText.equals("Real Sociedad upcoming matches")) {
                    handlers.getMatches("https://www.sports.ru/real-sociedad/calendar/");
                } else if (messageText.equals("Athletic squad")) {
                    handlers.getSquad("https://www.sports.ru/athletic/team/");
                } else if (messageText.equals("Athletic upcoming matches")) {
                    handlers.getMatches("https://www.sports.ru/athletic/calendar/");
                } else if (messageText.equals("Rayo Vallecano squad")) {
                    handlers.getSquad("https://www.sports.ru/rayo-vallecano/team/");
                } else if (messageText.equals("Rayo Vallecano upcoming matches")) {
                    handlers.getMatches("https://www.sports.ru/rayo-vallecano/calendar/");
                } else if (messageText.equals("Valencia squad")) {
                    handlers.getSquad("https://www.sports.ru/valencia/team/");
                } else if (messageText.equals("Valencia upcoming matches")) {
                    handlers.getMatches("https://www.sports.ru/valencia/calendar/");
                } else if (messageText.equals("Girona squad")) {
                    handlers.getSquad("https://www.sports.ru/girona/team/");
                } else if (messageText.equals("Girona upcoming matches")) {
                    handlers.getMatches("https://www.sports.ru/girona/calendar/");
                } else if (messageText.equals("Alaves squad")) {
                    handlers.getSquad("https://www.sports.ru/alaves/team/");
                } else if (messageText.equals("Alaves upcoming matches")) {
                    handlers.getMatches("https://www.sports.ru/alaves/calendar/");
                } else if (messageText.equals("Osasuna squad")) {
                    handlers.getSquad("https://www.sports.ru/osasuna/team/");
                } else if (messageText.equals("Osasuna upcoming matches")) {
                    handlers.getMatches("https://www.sports.ru/osasuna/calendar/");
                } else if (messageText.equals("Cadiz squad")) {
                    handlers.getSquad("https://www.sports.ru/cadiz/team/");
                } else if (messageText.equals("Cadiz upcoming matches")) {
                    handlers.getMatches("https://www.sports.ru/cadiz/calendar/");
                } else if (messageText.equals("Las Palmas squad")) {
                    handlers.getSquad("https://www.sports.ru/las-palmas/team/");
                } else if (messageText.equals("Las Palmas upcoming matches")) {
                    handlers.getMatches("https://www.sports.ru/las-palmas/calendar/");
                } else if (messageText.equals("Mallorca squad")) {
                    handlers.getSquad("https://www.sports.ru/mallorca/team/");
                } else if (messageText.equals("Mallorca upcoming matches")) {
                    handlers.getMatches("https://www.sports.ru/mallorca/calendar/");
                } else if (messageText.equals("Celta squad")) {
                    handlers.getSquad("https://www.sports.ru/celta/team/");
                } else if (messageText.equals("Celta upcoming matches")) {
                    handlers.getMatches("https://www.sports.ru/celta/calendar/");
                } else if (messageText.equals("Almeria squad")) {
                    handlers.getSquad("https://www.sports.ru/almeria/team/");
                } else if (messageText.equals("Almeria upcoming matches")) {
                    handlers.getMatches("https://www.sports.ru/almeria/calendar/");
                } else if (messageText.equals("Granada squad")) {
                    handlers.getSquad("https://www.sports.ru/granada/team/");
                } else if (messageText.equals("Granada upcoming matches")) {
                    handlers.getMatches("https://www.sports.ru/granada/calendar/");
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
