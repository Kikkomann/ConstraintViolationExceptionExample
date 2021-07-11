package com.example.demo.clslogmanager.factory;

public interface LogManager {
        void writeLogError(String errorLogMessage, int statusCode);
        void writeInternalError(Exception ex);
}
