package ru.mirea;

import ru.mirea.model.Listener;
import ru.mirea.model.User;

import java.util.logging.Logger;

public class Main {
    private static final Logger log = Logger.getLogger(Main.class.getName());
    public static void main(String[] args) {
        final User a = new User("Alisa", 7, 11);
        final User b = new User("Bob", 7, 11);
        if ( ! (a.valid() || b.valid()) ) {
            return;
        }
        final Listener listener = new Listener("listener");

        a.calculateKey(listener.listen("first", b.getY()));
        b.calculateKey(listener.listen("second", a.getY()));

        log.info("ru.mirea.Listener list: " + listener.getValues().toString());

        log.info("ru.mirea.User " + a.getName() + " has key: " + a.getKey());
        log.info("ru.mirea.User " + b.getName() + " has key: " + b.getKey());
        if (a.getKey() == b.getKey()){
            log.info("Success");
        } else {
            log.info("Failed");
        }
    }
}
