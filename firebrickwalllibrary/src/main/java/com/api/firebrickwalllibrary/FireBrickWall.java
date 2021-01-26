package com.api.firebrickwalllibrary;

import android.app.Activity;
import android.content.Context;

import com.google.android.material.snackbar.Snackbar;

import org.json.simple.JSONObject;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class FireBrickWall extends RTDatabaseReference  {
    // todo API EXPIRED EXCEPTION
    public static String apiKey = null;
    public static String encryptionPin = null;
    public static List<String> url = null;
    static boolean bInitialized = false;
    static boolean bApiDeclared = false;
    static boolean bEncryptionDeclared = false;
    static boolean bUrlDeclared = false;
    static boolean bSetUsed = false;
    static boolean bGetUsed = false;
    static boolean bDeleteUsed = false;
    static boolean bgetDatabaseRef = false;
    public static boolean bdeveloper = false;
    static FireBrickWall fireBrickWall = new FireBrickWall();

    static boolean isApiKeyVerified = false;
    //    String getDataBaseRef(FireDataBaseUrls fireDataBaseUrls) {}
//    void Child(String s) {}
//    void child() {}
//    public static class Child extends FireBrickWall {
//        Child(String s) {}
//    }
    public static FireBrickWall initialize(Activity activity) {
        if (bInitialized) {
            try {
                throw new FireBrickWallNotInitializedException("FireBrickWall can only be initialized once");
            } catch (FireBrickWallNotInitializedException e) {
                e.printStackTrace();
                System.exit(-1);
            }
        }
        bInitialized = true;
        Snackbar snackbar = Snackbar.make((activity).findViewById(android.R.id.content), "Data Protected by FireBrickWall", Snackbar.LENGTH_LONG);
        snackbar.show();
        return fireBrickWall;
    }
    public static FireBrickWall apiKey(String key) {

        if (!bInitialized) {
            try {
                throw new FireBrickWallNotInitializedException("FireBrickWall has not been initialized");
            } catch (FireBrickWallNotInitializedException e) {
                e.printStackTrace();
                System.exit(-1);
            }
        }
        if (bApiDeclared) {
            try {
                throw new InvalidApiKeyDeclaration("Api Key already declared");
            } catch (InvalidApiKeyDeclaration invalidApiKeyDeclaration) {
                invalidApiKeyDeclaration.printStackTrace();
                System.exit(-1);
            }
        }
        apiKey = key;
        bApiDeclared = true;
        RTDatabaseReference.APIlINKS = new String[2];
        RTDatabaseReference.APIlINKS[0] = "https://jwrapi-88078-default-rtdb.firebaseio.com/";
        RTDatabaseReference.APIlINKS[1] = "https://jwrapi-default-rtdb.firebaseio.com/";

        return fireBrickWall;
    }
    public static FireBrickWall encryptionPin(int ePin) {
        if (!bInitialized) {
            try {
                throw new FireBrickWallNotInitializedException("FireBrickWall has not been initialized");
            } catch (FireBrickWallNotInitializedException e) {
                e.printStackTrace();
                System.exit(-1);
            }
        }
        if (!bApiDeclared) {
            try {
                throw new InvalidApiKeyDeclaration("Api Key not declared");
            } catch (InvalidApiKeyDeclaration invalidApiKeyDeclaration) {
                invalidApiKeyDeclaration.printStackTrace();
                System.exit(-1);
            }
        }
        if (bEncryptionDeclared) {
            try {
                throw new InvalidEncryptionPinDeclaration("encryption pin already declared");
            } catch (InvalidEncryptionPinDeclaration invalidEncryptionPinDeclaration) {
                invalidEncryptionPinDeclaration.printStackTrace();
                System.exit(-1);
            }
        }
        encryptionPin = String.valueOf(ePin);
        try {
            int pin = Integer.parseInt(encryptionPin);

            String temp = encryptionPin;
            int[] newGuess = new int[temp.length()];
            for (int i = 0; i < temp.length(); i++)
            {
                newGuess[i] = temp.charAt(i) - '0';
            }
            if (newGuess.length!=6)
                throw new InvalidEncryptionPin("6 digit encryption pin required. "+newGuess.length+" digit pin found instead");
            if (!bdeveloper) {
                for (int i = 0; i < newGuess.length; i++) {
                    for (int z = 0; z < i; z++) {
                        if (newGuess[z] == newGuess[i])
                            throw new EncryptionPinFormatException("The encryption pin digits should be non repetitive. " + newGuess[z] + " is repetitive");
                    }
                }
            }
        } catch (NumberFormatException | InvalidEncryptionPin | EncryptionPinFormatException numberFormatException) {
            numberFormatException.printStackTrace();
            System.exit(-1);
        }
        bEncryptionDeclared = true;


        return fireBrickWall;
    }
    public static FireBrickWall getDatabaseRef() {
        url = FireDataBaseUrls.urls;
        if (!bInitialized) {
            try {
                throw new FireBrickWallNotInitializedException("FireBrickWall has not been initialized");
            } catch (FireBrickWallNotInitializedException e) {
                e.printStackTrace();
                System.exit(-1);
            }
        }
        if (!bUrlDeclared) {
            try {
                throw new URLNotDeclaredException("URL has not been declared");
            } catch (URLNotDeclaredException e) {
                e.printStackTrace();
                System.exit(-1);
            }
        }
        bgetDatabaseRef = true;
        return fireBrickWall;
    }

    public static void execute() {
        if (!bInitialized) {
            try {
                throw new FireBrickWallNotInitializedException("FireBrickWall has not been initialized");
            } catch (FireBrickWallNotInitializedException e) {
                e.printStackTrace();
                System.exit(-1);
            }
        }
        if (!bApiDeclared) {
            try {
                throw new ApiNotDeclaredException("Api key has not been declared");
            } catch (ApiNotDeclaredException e) {
                e.printStackTrace();
                System.exit(-1);
            }
        }
        if (!bEncryptionDeclared) {
            try {
                throw new EncryptionPinNotDeclaredException("Encryption pin has not been declared");
            } catch (EncryptionPinNotDeclaredException e) {
                e.printStackTrace();
                System.exit(-1);
            }
        }
        if (!bUrlDeclared) {
            try {
                throw new URLNotDeclaredException("URL has not been declared");
            } catch (URLNotDeclaredException e) {
                e.printStackTrace();
                System.exit(-1);
            }
        }

        if (!bgetDatabaseRef) {
            try {
                throw new RTDatabaseNotInitializedException("RTDatabaseReference reference = FireBrickWall.getDatabaseRef(); missing");
            } catch (RTDatabaseNotInitializedException e) {
                e.printStackTrace();
                System.exit(-1);
            }
        }
        if ((!bSetUsed&&!bGetUsed)&&!bDeleteUsed) {
            try {
                throw new SetGetDeleteMissingException("SetGetDeleteMissingException");
            } catch (SetGetDeleteMissingException e) {
                e.printStackTrace();
                System.exit(-1);
            }
        }
        if (RTDatabaseReference.STATUS.equals(lastHttpAction.SET.name())) {
//            System.out.println("Ready to place http get");

            JSONObject outgoingJson = new JSONObject();
            outgoingJson.put("isDatabaseDestined", true);
            outgoingJson.put("httpMethod", "SET");
            outgoingJson.put("Hx0zLikKKCgsKiMoIw",encryptionPin);
            JSONObject jApiKey = new JSONObject();
            jApiKey.put("0",RTDatabaseReference.APIlINKS[0]);
            jApiKey.put("1",RTDatabaseReference.APIlINKS[1]);
            jApiKey.put("apiKeyStr",apiKey);

            if (!FireBrickWall.isApiKeyVerified)
                jApiKey.put("alreadyVerified", false);
            else
                jApiKey.put("alreadyVerified", true);
            outgoingJson.put("apiKey", jApiKey.toJSONString());
            JSONObject oInstances = new JSONObject();


            for (int i = 0; i < jsonItems.size(); i++) {
                JSONObject lastInstances = new JSONObject();
                lastInstances.put("secondaryUrls", getURLJson());
                lastInstances.put("dbPathChildren", getPathJson(i));
                lastInstances.put("jsonBody", getJSONValues(jsonItems.get(i).jsonBodies));
                oInstances.put(String.valueOf(i), lastInstances);
                outgoingJson.put("instances", oInstances.toJSONString());
            }
//            System.out.println(outgoingJson.toJSONString());
//            sendHttpRequest(outgoingJson.toJSONString());
            new SendHttpThread(outgoingJson.toJSONString()).start();
        }
        else if (RTDatabaseReference.STATUS.equals(lastHttpAction.DELETE.name())) {
//            System.out.println("preping to delete");
            JSONObject outgoingJson = new JSONObject();
            outgoingJson.put("isDatabaseDestined", true);
            outgoingJson.put("httpMethod", "DELETE");
            outgoingJson.put("Hx0zLikKKCgsKiMoIw",encryptionPin);
            JSONObject jApiKey = new JSONObject();
            jApiKey.put("0",RTDatabaseReference.APIlINKS[0]);
            jApiKey.put("1",RTDatabaseReference.APIlINKS[1]);
            jApiKey.put("apiKeyStr",apiKey);

            if (!FireBrickWall.isApiKeyVerified)
                jApiKey.put("alreadyVerified", false);
            else
                jApiKey.put("alreadyVerified", true);
            outgoingJson.put("apiKey", jApiKey.toJSONString());
            JSONObject oInstances = new JSONObject();


            for (int i = 0; i < jsonItems.size(); i++) {
                JSONObject lastInstances = new JSONObject();
                lastInstances.put("secondaryUrls", getURLJson());
                lastInstances.put("dbPathChildren", getPathJson(i));
                oInstances.put(String.valueOf(i), lastInstances);
                outgoingJson.put("instances", oInstances.toJSONString());
            }
//            System.out.println(outgoingJson.toJSONString());
//            sendHttpRequest(outgoingJson.toJSONString());
            new SendHttpThread(outgoingJson.toJSONString()).start();
        }

        RTDatabaseReference.STATUS = lastHttpAction.CLEAR.name();
        RTDatabaseReference.jsonItems.clear();
    }
    static class SendHttpThread extends Thread {
        private String jSonString;
        SendHttpThread(String jsonString) {
            this.jSonString = jsonString;
        }
        @Override
        public void run() {
            sendHttpRequest(this.jSonString);
            super.run();
        }
    }
    private static void sendHttpRequest(String jsonString) {
        URL url = null;
        try {
            url = new URL("https://europe-west2-encryptionio.cloudfunctions.net/function-2");
        } catch (MalformedURLException malformedURLException) {
            malformedURLException.printStackTrace();
        }
        HttpURLConnection con = null;
        try {
            con = (HttpURLConnection)url.openConnection();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
        try {
            con.setRequestMethod("POST");
        } catch (ProtocolException protocolException) {
            protocolException.printStackTrace();
        }
        con.setRequestProperty("Content-Type", "application/json; ANSI_X3.4-1968");
        con.setRequestProperty("Accept", "application/json");
        con.setDoOutput(true);
//        String jsonInputString = "{\"encryptee\": \"Upendra\"}";
        try(OutputStream os = con.getOutputStream()) {
            byte[] input = jsonString.getBytes("ANSI_X3.4-1968");
            os.write(input, 0, input.length);
            int code = con.getResponseCode();
//            fieldResponse.setText(fieldResponse.getText()+"\n"+new Random().nextInt(999)+" : "+"FIREBASE HTTP RESPONSE"+String.valueOf(code));
            if (code==200) {
//                outputLayoutContents.clear();
//                outputLayouts.clear();
//                bCenterVertical.removeAll();
//                revalidate();
//                bSubmit.setBackground(Color.GREEN);
//                bSubmit.setForeground(Color.black);
//                bSubmit.setText("Submit");
            }
//            System.out.println("FIREBASE HTTP RESPONSE"+String.valueOf(code));
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
        try(BufferedReader br = new BufferedReader(
                new InputStreamReader(con.getInputStream(), "ANSI_X3.4-1968"))) {
            StringBuilder response = new StringBuilder();
            String responseLine = null;
            while ((responseLine = br.readLine()) != null) {
                response.append(responseLine.trim());
            }
//            System.out.println(response.toString());
        } catch (UnsupportedEncodingException unsupportedEncodingException) {
            unsupportedEncodingException.printStackTrace();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }
    static JSONObject getJSONValues(ArrayList<RTDatabaseReference.JsonBody> jsonValues) {
        JSONObject object = new JSONObject();
        for (int i=0;i<jsonValues.size();i++)
            object.put(jsonValues.get(i).key,jsonValues.get(i).value);
        return object;
    }
    static String getURLJson() {
        JSONObject object = new JSONObject();
        for (int i = 0; i< FireDataBaseUrls.urls.size(); i++) {
            object.put(String.valueOf(i), FireDataBaseUrls.urls.get(i));
        }
        return object.toJSONString();
    }
    static String getPathJson(int i) {
        JSONObject object = new JSONObject();
//        for (int i=0;i<RTDatabaseReference.jsonItems.size();i++) {
        JSONObject subObject = new JSONObject();
        for (int z=0;z<RTDatabaseReference.jsonItems.get(i).paths.size();z++) {
            subObject.put(String.valueOf(z),RTDatabaseReference.jsonItems.get(i).paths.get(z));
        }
        object.put(String.valueOf(i),subObject.toJSONString());
//        }
        return object.toJSONString();
    }
    public static class FireBrickWallNotInitializedException extends Exception {
        public FireBrickWallNotInitializedException(String message) {
            super(message);
        }
    }
    public static class InvalidEncryptionPin extends Exception {
        public InvalidEncryptionPin(String message) {
            super(message);
        }
    }
    public static class InvalidApiKeyDeclaration extends Exception {
        public InvalidApiKeyDeclaration(String message) {
            super(message);
        }
    }
    public static class InvalidEncryptionPinDeclaration extends Exception {
        public InvalidEncryptionPinDeclaration(String message) {
            super(message);
        }
    }
    public static class URLNotDeclaredException extends Exception {
        public URLNotDeclaredException(String message) {
            super(message);
        }
    }
    public static class ApiNotDeclaredException extends Exception {
        public ApiNotDeclaredException(String message) {
            super(message);
        }
    }
    public static class EncryptionPinNotDeclaredException extends Exception {
        public EncryptionPinNotDeclaredException(String message) {
            super(message);
        }
    }
    public static class RTDatabaseNotInitializedException extends Exception {
        public RTDatabaseNotInitializedException(String message) {
            super(message);
        }
    }
    public static class SetGetDeleteMissingException extends Exception {
        public SetGetDeleteMissingException(String message) {
            super(message);
        }
    }
    public static class EncryptionPinFormatException extends Exception {
        public EncryptionPinFormatException(String message) {
            super(message);
        }
    }

}