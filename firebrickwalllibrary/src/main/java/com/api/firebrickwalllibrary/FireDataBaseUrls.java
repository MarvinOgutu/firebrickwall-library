package com.api.firebrickwalllibrary;


import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class FireDataBaseUrls {
    public static List<String> urls = new ArrayList<>();
    private static List<String> RTDatabase() {
        return urls;
    }
    public static List<String> RTDatabaseUrl = RTDatabase();
    public static FireDataBaseUrls RTDatabaseUrl(String url) {
        try {
            URL url1 = new URL(url);
        } catch (MalformedURLException malformedURLException) {
            malformedURLException.printStackTrace();
            System.exit(-1);
        }
        urls.add(url);
        if (!FireBrickWall.bEncryptionDeclared){
            try {
                throw new MissingEncryptionPin("Missing encryption pin");
            } catch (MissingEncryptionPin missingEncryptionPin) {
                missingEncryptionPin.printStackTrace();
                System.exit(-1);
            }
        }
        if ((FireBrickWall.bSetUsed||FireBrickWall.bGetUsed)||FireBrickWall.bDeleteUsed) {
            try {
                throw new RTDatabaseReference.RTDatabaseUrlException("RTDatabaseUrl should be declared before set or get or delete");
            } catch (RTDatabaseReference.RTDatabaseUrlException e) {
                e.printStackTrace();
                System.exit(-1);
            }
        }
        FireBrickWall.bUrlDeclared = true;
        return null;
    }
    public static class MissingEncryptionPin extends Exception {
        public MissingEncryptionPin(String message) {
            super(message);
        }
    }
    public static class InvalidURLDeclaration extends Exception {
        public InvalidURLDeclaration(String message) {
            super(message);
        }
    }
}