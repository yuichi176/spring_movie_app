package com.example.spring_movie_app.helper;

import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

import java.util.Locale;

@Component
public class MessageSourceHelper {

    private final MessageSource source;

    public MessageSourceHelper(MessageSource source) {
        this.source = source;
    }

    public String getMessage(String code, Object... args) {
        return this.source.getMessage(code, args, Locale.getDefault());
    }

    public String getMessage(String code) {
        return this.getMessage(code, null);
    }
}
