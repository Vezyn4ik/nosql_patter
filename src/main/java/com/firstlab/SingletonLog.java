package com.firstlab;

import java.util.ArrayList;
import java.util.List;

public class SingletonLog {
    private static SingletonLog instance;
    private List<String> actions = new ArrayList<String>();

    private SingletonLog() {
    }

    public static synchronized SingletonLog getInstance() {
        if (instance == null) {
            instance = new SingletonLog();
        }
        return instance;
    }

    public void addAction(String action) {
        actions.add(action);
    }

    public String getLastAction() {
        return "Last action \n" + actions.get(actions.size() - 1);
    }

    public String getAllActions() {
        return actions.toString();
    }

}
