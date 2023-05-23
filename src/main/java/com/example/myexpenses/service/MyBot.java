package com.example.myexpenses.service;

import com.example.myexpenses.config.BotConfig;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Component
public class MyBot extends TelegramLongPollingBot {

    @Override
    public String getBotUsername() {
        return "My_Money_ManagerBot";
    }

    @Override
    public String getBotToken() {
        return "6245891037:AAHgqtHTd9Rmb5m1iNCMnjn6G8jZHs2aIyI";
    }

    @Override
    public void onUpdateReceived(Update update) {


        if (update.hasMessage() && update.getMessage().hasText()) {
            SendMessage message = new SendMessage(); // Create a SendMessage object with mandatory fields
            message.setChatId(update.getMessage().getChatId().toString());
            message.setText(update.getMessage().getText());
            long chatId = update.getMessage().getChatId();
            sendMenuMessage(chatId);
        }
    }
    private void sendMenuMessage(long chatId) {
        SendMessage message = new SendMessage();
        message.setChatId(chatId);
        message.setText("Выберите опцию");

        ReplyKeyboardMarkup keyboardMarkup = new ReplyKeyboardMarkup();
        keyboardMarkup.setResizeKeyboard(true);


        KeyboardButton button1 = new KeyboardButton("Первая кнопка");
        KeyboardButton button2 = new KeyboardButton("Вторая кнопка");
        KeyboardButton button3 = new KeyboardButton("Третья кнопка");
        KeyboardButton button4 = new KeyboardButton("Четвертая кнопка");
        KeyboardButton button5 = new KeyboardButton("Пятая кнопка");
        List<KeyboardRow> keyboardRows1 = new ArrayList<>();
        KeyboardRow row1 = new KeyboardRow();
        KeyboardRow roww = new KeyboardRow();
        row1.add(button1);
        row1.add(button2);
        row1.add(button3);
        roww.add(button4);
        roww.add(button5);
        keyboardRows1.add(row1);
        keyboardRows1.add(roww);



        keyboardMarkup.setKeyboard(keyboardRows1);
//
        message.setReplyMarkup(keyboardMarkup);

        try {
            execute(message);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }
    }
}
