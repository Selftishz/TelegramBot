package org.example;

import org.apache.commons.lang3.StringUtils;
import org.jsoup.Jsoup;
import org.jsoup.internal.StringUtil;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.io.IOException;
import java.net.URL;

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

    public void clubHandler(String squadText, String upcomingMatchesText) throws TelegramApiException {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setText("club buttons:");
        sendMessage.setChatId(chatId);
        sendMessage.setReplyMarkup(menu.setClubButtons(squadText, upcomingMatchesText));
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

    public void getMatches(String url) throws IOException, TelegramApiException {
        SendMessage sendMessage = new SendMessage();
        Document page = getPage(url);
        Element table = page.selectFirst("table[class=stat-table]").selectFirst("tbody");
        Elements values = table.select("tr");
        String filled = StringUtils.repeat(" ", 200);
        int count = 0;
        String result = "";
        for (Element element : values) {
            String date = element.select("td[class=name-td alLeft bordR]").text();
            String tournament = element.selectFirst("td[class=name-td alLeft]").text();
            String opponent = element.select("td[class=name-td alLeft]").last().text();
            String place = element.select("td[class=alRight padR20]").text();
            String score = element.select("td[class=score-td]").text();
            score = score.replace("превью", "-");
            StringBuilder line = new StringBuilder(filled);

            line.insert(0, date);
            line.insert(20, tournament);
            line.insert(50, opponent);
            line.insert(65, place);
            String text = StringUtils.strip(line.toString(), " ");
            if (score.equals("-")) {
                ++count;
                result = result + text + "\n";
                if (count == 3) {
                    sendMessage.setChatId(chatId);
                    sendMessage.setText(result);
                    bot.execute(sendMessage);
                    break;
                }
            }
        }
    }

    public void getSquad(String url) throws IOException, TelegramApiException {
        SendMessage sendMessage = new SendMessage();
        Document page = getPage(url);
        Element table = page.selectFirst("table[class=stat-table sortable-table]").selectFirst("tbody");
        Elements values = table.select("tr");
        String filled = StringUtils.repeat(" ", 200);
        String result = "";
        for (Element element : values) {
            String number = element.select("td").first().text();
            String player = element.selectFirst("td[class=name-td alLeft bordR]").text();
            String playerAge = element.selectFirst("td[class=name-td alLeft bordR]").text();
            StringBuilder line = new StringBuilder(filled);
            line.insert(0, number);
            line.insert(5, player);

            String text = StringUtils.strip(line.toString(), " ");
            result = result + text + "\n";
        }
        sendMessage.setChatId(chatId);
        sendMessage.setText(result);
        bot.execute(sendMessage);
    }

    private Document getPage(String url) throws IOException {
        Document page = Jsoup.parse(new URL(url), 3000);
        return page;
    }
}
