package org.example;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

public class Main extends TelegramLongPollingBot {

    public static void main(String[] args) throws TelegramApiException {
        TelegramBotsApi api = new TelegramBotsApi(DefaultBotSession.class);
        api.registerBot(new Main());
    }

    @Override
    public String getBotUsername() {
        return "Banderogus1111GoitBot";
    }

    @Override
    public String getBotToken() {
        return "5457689467:AAF8Y-kylFtTSQeOfGkEG_5JyovcR6viYH0";
    }

    @Override
    public void onUpdateReceived(Update update) {
        Long chatId = getChatId(update);

        SendMessage msq = creatMessage("*Hello* Liudmyla");
        msq.setChatId(chatId);
        sendApiMethodAsync(msq);
    }
    public Long getChatId(Update update) {
        if (update.hasMessage()) {
            return update.getMessage().getFrom().getId();
        }

        if (update.hasCallbackQuery()) {
            return update.getCallbackQuery().getFrom().getId();
        }
        return null;
    }
    public SendMessage creatMessage(String text) {
        SendMessage message = new SendMessage();
        message.setText(text);
        message.setParseMode("markdown");
        return message;
    }
}