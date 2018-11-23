package ru.mirea.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.logging.Logger;

public class User {
    private final static Logger log = Logger.getLogger(User.class.getName());
    private final String name;
    private final double base;
    private final double module;
    private double secretX;
    private double key;

    public User(final String name, final double base, final double module){
        this.name = name;
        this.base = base;
        this.module = module;

        generateX();

        log.info("ru.mirea.User " + this.name + ": base=" + this.base + " module=" + this.module + " x=" + this.secretX);
    }

    public boolean valid (){
        if (base < 0 || base > (module - 1)){
            log.info("Invalid base and module");
            return false;
        }

        List<Double> numbers = new ArrayList<>();
        for (int i = 0; i < (module - 1); i++){
            double number = Math.pow(base, (double) i) %module;
            if (numbers.contains(number)){
                log.info("Invalid base and module");
                return false;
            }
            numbers.add(number);
        }

        return true;
    }

    public void calculateKey(final double Y){
        key = Math.pow(Y, secretX) % module;
        log.info("ru.mirea.User " + name + " calculate key: " + key + " (with Y=" + Y + ")");
    }

    public double getY(){
        return Math.pow(base, secretX) % module;
    }

    public String getName() {
        return name;
    }

    public double getKey() {
        return key;
    }

    private void generateX(){
        Random rand = new Random();
        secretX = rand.nextInt((int) module); // secretX < module
        int check = 0;
        while((Math.pow(base, secretX) % module) == 1){
            secretX = rand.nextInt((int) module);
            if (check == module){
                log.info("Invalid base and module");
                return;
            }
            check++;
        }
    }
}
