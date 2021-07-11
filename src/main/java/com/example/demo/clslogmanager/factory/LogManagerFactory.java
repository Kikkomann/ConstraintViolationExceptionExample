package com.example.demo.clslogmanager.factory;

import org.springframework.stereotype.Component;

import com.example.demo.clslogmanager.ClsLogManager;

@Component
public class LogManagerFactory {
    public LogManager getLogManager() {
        return new ClsLogManager();
    }
}
