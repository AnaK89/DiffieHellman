package ru.mirea.model;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

public class Listener {
    private final static Logger log= Logger.getLogger(Listener.class.getName());
    private final String name;
    private Map <String, Double> values = new HashMap<>();

    public Listener(final String name){
        this.name = name;
    }

    public double listen(final String userName, final double value){
        log.info("Listen " + name + " listen: " + userName + " = " + value);
        values.put(userName, value);
        return value;
    }

    public Map<String, Double> getValues() {
        return values;
    }

    public String getName() {
        return name;
    }
}
