package com.api.firebrickwalllibrary;

import android.os.Build;

import androidx.annotation.RequiresApi;


import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;
import java.net.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RTDatabaseReference {
    static List<String> paths = new ArrayList<>();
    static String STATUS = lastHttpAction.CLEAR.name();
    static enum lastHttpAction{SET,GET,DELETE,CLEAR};

    static ArrayList<JsonItems> jsonItems = new ArrayList<>();
    static String GET = lastHttpAction.GET.name();
    static String SET = lastHttpAction.SET.name();
    static String DELETE = lastHttpAction.DELETE.name();

    static boolean isOnceDeclared = false;
    static boolean isChildDeclared = false;

    static ArrayList<booleanStatus> booleanStatuses = new ArrayList<>();
    static List<String> mismatchList = new ArrayList<>();
    static String[] APIlINKS;
    public RTDatabaseReference child(String s) {
        if (s.replaceAll("\\s+","").equals("")) {
            try {
                throw new NullPathException("Child path cannot be null");
            } catch (NullPathException e) {
                e.printStackTrace();
                System.exit(-1);
            }
        }
        else
            paths.add(s);
        isChildDeclared = true;
        return this;
    }

    public void set(String s) {
        if (!isChildDeclared) {
            try {
                throw new FBWChildException(".child(String s) is missing");
            } catch (FBWChildException e) {
                e.printStackTrace();
                System.exit(-1);
            }
        }
        if (!STATUS.equals(lastHttpAction.SET.name())&&!STATUS.equals(lastHttpAction.CLEAR.name())) {
            try {
                throw new PendingGetorDeleteExecutionException("PendingGetorDeleteExecutionException");
            } catch (PendingGetorDeleteExecutionException e) {
                e.printStackTrace();
                System.exit(-1);
            }
        }
        FireBrickWall.bSetUsed = true;
        STATUS = lastHttpAction.SET.name();
        String key = paths.get(paths.size()-1);
        paths.remove(paths.size()-1);
//        jsonItems.add(new JsonItems(paths,new JsonBody(key,s)));
        boolean found = false;
        for (int i=0;i<jsonItems.size();i++) {
            if (Arrays.toString(jsonItems.get(i).paths.toArray()).equals(Arrays.toString(paths.toArray()))) {
                jsonItems.get(i).jsonBodies.add(new JsonBody(key, s));
                found= true;
            }
            break;
        }
        if (!found)
            jsonItems.add(new JsonItems(SET,paths,new JsonBody(key,s)));
        paths.clear();
        isChildDeclared = false;
//        return this;
    }
    public void set(int z) {
        if (!isChildDeclared) {
            try {
                throw new FBWChildException(".child(String s) is missing");
            } catch (FBWChildException e) {
                e.printStackTrace();
                System.exit(-1);
            }
        }
        if (!STATUS.equals(lastHttpAction.SET.name())&&!STATUS.equals(lastHttpAction.CLEAR.name())) {
            try {
                throw new PendingGetorDeleteExecutionException("PendingGetorDeleteExecutionException");
            } catch (PendingGetorDeleteExecutionException e) {
                e.printStackTrace();
                System.exit(-1);
            }
        }
        FireBrickWall.bSetUsed = true;
        STATUS = lastHttpAction.SET.name();
        String key = paths.get(paths.size()-1);
        paths.remove(paths.size()-1);
        boolean found = false;
        for (int i=0;i<jsonItems.size();i++) {
            if (Arrays.toString(jsonItems.get(i).paths.toArray()).equals(Arrays.toString(paths.toArray()))) {
                jsonItems.get(i).jsonBodies.add(new JsonBody(key, String.valueOf(z)));
                found= true;
            }
            break;
        }
        if (!found)
            jsonItems.add(new JsonItems(SET,paths,new JsonBody(key,String.valueOf(z))));
        paths.clear();
        isChildDeclared = false;
//        return this;
    }
    public void set(double d) {
        if (!isChildDeclared) {
            try {
                throw new FBWChildException(".child(String s) is missing");
            } catch (FBWChildException e) {
                e.printStackTrace();
                System.exit(-1);
            }
        }
        if (!STATUS.equals(lastHttpAction.SET.name())&&!STATUS.equals(lastHttpAction.CLEAR.name())) {
            try {
                throw new PendingGetorDeleteExecutionException("PendingGetorDeleteExecutionException");
            } catch (PendingGetorDeleteExecutionException e) {
                e.printStackTrace();
                System.exit(-1);
            }
        }
        FireBrickWall.bSetUsed = true;
        STATUS = lastHttpAction.SET.name();
        String key = paths.get(paths.size()-1);
        paths.remove(paths.size()-1);
        boolean found = false;
        for (int i=0;i<jsonItems.size();i++) {
            if (Arrays.toString(jsonItems.get(i).paths.toArray()).equals(Arrays.toString(paths.toArray()))) {
                jsonItems.get(i).jsonBodies.add(new JsonBody(key, String.valueOf(d)));
                found= true;
            }
            break;
        }
        if (!found)
            jsonItems.add(new JsonItems(SET,paths,new JsonBody(key,String.valueOf(d))));
        paths.clear();
        isChildDeclared = false;
//        return this;
    }
    public void set(boolean b) {
        if (!isChildDeclared) {
            try {
                throw new FBWChildException(".child(String s) is missing");
            } catch (FBWChildException e) {
                e.printStackTrace();
                System.exit(-1);
            }
        }
        if (!STATUS.equals(lastHttpAction.SET.name())&&!STATUS.equals(lastHttpAction.CLEAR.name())) {
            try {
                throw new PendingGetorDeleteExecutionException("PendingGetorDeleteExecutionException");
            } catch (PendingGetorDeleteExecutionException e) {
                e.printStackTrace();
                System.exit(-1);
            }
        }
        FireBrickWall.bSetUsed = true;
        STATUS = lastHttpAction.SET.name();
        String key = paths.get(paths.size()-1);
        paths.remove(paths.size()-1);
        boolean found = false;
        for (int i=0;i<jsonItems.size();i++) {
            if (Arrays.toString(jsonItems.get(i).paths.toArray()).equals(Arrays.toString(paths.toArray()))) {
                jsonItems.get(i).jsonBodies.add(new JsonBody(key, String.valueOf(b)));
                found= true;
            }
            break;
        }
        if (!found)
            jsonItems.add(new JsonItems(SET,paths,new JsonBody(key,String.valueOf(b))));
        paths.clear();
        isChildDeclared = false;
//        return this;
    }
    public void delete() {
        if (!isChildDeclared) {
            try {
                throw new FBWChildException(".child(String s) is missing");
            } catch (FBWChildException e) {
                e.printStackTrace();
                System.exit(-1);
            }
        }
        if (!STATUS.equals(lastHttpAction.DELETE.name())&&!STATUS.equals(lastHttpAction.CLEAR.name())) {
            try {
                throw new PendingSetorGetExecutionException("PendingSetorGetExecutionException");
            } catch (PendingSetorGetExecutionException e) {
                e.printStackTrace();
                System.exit(-1);
            }
        }
        FireBrickWall.bDeleteUsed = true;
        STATUS = lastHttpAction.DELETE.name();
        jsonItems.add(new JsonItems(DELETE,paths));


//        jsonItems.add(new JsonItems(DELETE,paths));
        paths.clear();
        isChildDeclared = false;
        booleanStatuses.clear();


//        return this;
    }
    public RTDatabaseReference once() {
        isOnceDeclared = true;
        return this;
    }
    public void then(DatasnapShot.DatasnapShoti datasnapShoti) {
        if (!isChildDeclared) {
            try {
                throw new FBWChildException(".child(String s) is missing");
            } catch (FBWChildException e) {
                e.printStackTrace();
                System.exit(-1);
            }
        }
        if(!isOnceDeclared) {
            try {
                throw new FBWGetException(".once() is missing. It should be something like this:\nreference.child(\"students\").child(\"class\").child(\"7\").child(\"Ec2089\").once().then");
            } catch (FBWGetException e) {
                e.printStackTrace();
                System.exit(-1);
            }
        }
        if (!STATUS.equals(lastHttpAction.GET.name())&&!STATUS.equals(lastHttpAction.CLEAR.name())) {
            try {
                throw new PendingSetorDeleteExecutionException("PendingSetorDeleteExecutionException");
            } catch (PendingSetorDeleteExecutionException e) {
                e.printStackTrace();
                System.exit(-1);
            }
        }
        FireBrickWall.bGetUsed = true;
        STATUS = lastHttpAction.GET.name();
        jsonItems.add(new JsonItems(GET,paths));
        if (STATUS.equals(lastHttpAction.GET.name())) {
            System.out.println("Ready to place http get");

            JSONObject outgoingJson = new JSONObject();
            outgoingJson.put("isDatabaseDestined", true);
            outgoingJson.put("httpMethod", "GET");
            outgoingJson.put("Hx0zLikKKCgsKiMoIw",FireBrickWall.encryptionPin);
            JSONObject jApiKey = new JSONObject();
            jApiKey.put("0",RTDatabaseReference.APIlINKS[0]);
            jApiKey.put("1",RTDatabaseReference.APIlINKS[1]);
            jApiKey.put("apiKeyStr",FireBrickWall.apiKey);

            if (!FireBrickWall.isApiKeyVerified)
                jApiKey.put("alreadyVerified", false);
            else
                jApiKey.put("alreadyVerified", true);
            outgoingJson.put("apiKey", jApiKey.toJSONString());

            JSONObject oInstances = new JSONObject();


            for (int i = 0; i < jsonItems.size(); i++) {
                JSONObject lastInstances = new JSONObject();
                lastInstances.put("secondaryUrls", FireBrickWall.getURLJson());
                lastInstances.put("dbPathChildren", FireBrickWall.getPathJson(i));
                oInstances.put(String.valueOf(i), lastInstances);
                outgoingJson.put("instances", oInstances.toJSONString());
            }
            System.out.println(outgoingJson.toJSONString());
//            sendGetHttpRequest(outgoingJson.toJSONString(),datasnapShoti);
            new SendGetThread(outgoingJson.toJSONString(),datasnapShoti).start();
        }
//        datasnapShoti.onDataLoaded(new DataSnap("Marvin","Ogutu"));
        STATUS = lastHttpAction.CLEAR.name();
        isChildDeclared = false;
        isOnceDeclared = false;

        RTDatabaseReference.STATUS = lastHttpAction.CLEAR.name();
        RTDatabaseReference.jsonItems.clear();
        paths.clear();
//        return this;
    }
    class SendGetThread extends Thread {
        private String jSonString;
        private DatasnapShot.DatasnapShoti datasnapShoti;
        SendGetThread(String jsonString, DatasnapShot.DatasnapShoti datasnapShoti) {
            this.jSonString = jsonString;
            this.datasnapShoti = datasnapShoti;
        }
        @RequiresApi(api = Build.VERSION_CODES.N)
        @Override
        public void run() {
            sendGetHttpRequest(this.jSonString,this.datasnapShoti);
            super.run();
        }
    }
    @RequiresApi(api = Build.VERSION_CODES.N)
    private static void sendGetHttpRequest(String jsonString, DatasnapShot.DatasnapShoti datasnapShoti) {
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
        try {
            OutputStream os = null;
            try {
                os = con.getOutputStream();
            } catch (UnknownHostException e) {
                datasnapShoti.onFail(e);
            }
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
            System.out.println("FIREBASE HTTP RESPONSE"+String.valueOf(code));
        } catch (IOException ioException) {
            System.out.println("Network issue");
            ioException.printStackTrace();
        }
        try(BufferedReader br = new BufferedReader(
                new InputStreamReader(con.getInputStream(), "ANSI_X3.4-1968"))) {
            StringBuilder response = new StringBuilder();
            String responseLine = null;
            while ((responseLine = br.readLine()) != null) {
                response.append(responseLine.trim());
            }
            System.out.println(response.toString());
            JSONParser parser = new JSONParser();
            try {
                Object oResponse = parser.parse(response.toString());
                JSONObject jsonObject = (JSONObject) oResponse;
                String code = (String) jsonObject.get("firebaseResponse");
                try {
                    boolean mismatchAPI = (boolean) jsonObject.get("mismatchAPI");
                    datasnapShoti.onApiKeyError();
                } catch(Exception e) {}
                if (code.equals("200")) {
                    try {
                        boolean error = (boolean) jsonObject.get("mismatch");
                        String getResponse = (String) jsonObject.get("mismatchKeys");
                        Object oResp = parser.parse(getResponse);
                        JSONObject joresp = (JSONObject)oResp;
                        final int[] count = {0};
                        mismatchList.clear();
                        joresp.keySet().forEach(keyStr->{
                            String firstMatch = (String)joresp.get(String.valueOf(count[0]));
                            mismatchList.add(firstMatch);
                            count[0]++;
                        });
                        try {
                            String getResponseio = (String) jsonObject.get("getResponseString");
                            String getResponse2 = (String) jsonObject.get("getResponsePath");
                            Object oRespio = parser.parse(!getResponseio.equals("{}")?getResponseio:getResponse2);
                            JSONObject jorespio = (JSONObject) oRespio;
                            System.out.println("Json object size: " + jorespio.size()+": "+jorespio.toJSONString());
                            String firstMatch = jorespio.toJSONString();
                            System.out.println("String to be parsed: " + firstMatch);

                            datasnapShoti.onDataMismatch(new DataSnap(firstMatch,mismatchList));
                        } catch (NullPointerException ed) {}

                        System.out.println("String to be parsed mismatch: "+Arrays.toString(mismatchList.toArray()));

                    }
                    catch (Exception e) {
                        try {
                            boolean apiKeyTermination = (boolean) jsonObject.get("apiKeyTermination");
                            datasnapShoti.onApiKeyError();
                        } catch (Exception ee) {
//                            System.out.println("activating boolean");
                            FireBrickWall.isApiKeyVerified = true;
                        }
                        try {
                            String getResponse = (String) jsonObject.get("getResponseString");
                            String getResponse2 = (String) jsonObject.get("getResponsePath");
                            Object oResp = parser.parse(!getResponse.equals("{}")?getResponse:getResponse2);
                            JSONObject joresp = (JSONObject) oResp;
                            System.out.println("Json object size: " + joresp.size()+": "+joresp.toJSONString());
                            String firstMatch = joresp.toJSONString();
                            System.out.println("String to be parsed: " + firstMatch);

                            datasnapShoti.onDataLoaded(new DataSnap(firstMatch));
                        } catch (NullPointerException ed) {}
                    }
//                    datasnapShoti.onDataLoaded(new DataSnap("marvo","ogutu"));
                } else {
//                    datasnapShoti.onFail();
                }
            } catch (ParseException e) {
                e.printStackTrace();
            }

        } catch (UnsupportedEncodingException unsupportedEncodingException) {
            unsupportedEncodingException.printStackTrace();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }
    public static class DatasnapShot {
        public interface DatasnapShoti {
            void onDataLoaded(DataSnap s);
            void onDataMismatch(DataSnap s);
            void onFail(UnknownHostException e);
            void onApiKeyError();
        }
//        DatasnapShot(DatasnapShoti datasnapShoti) {
//            datasnapShoti.onDataLoaded(new DataSnap("Marvin","Ogutu"));
//        }
    }
    public static class DataSnap {
        private String key;
        private String value;
        private String jSonString;
        private List<String> mismatchKeys = new ArrayList<>();
        //        DataSnap(String key,String value) {
//            this.key = key;
//            this.value = value;
//        }
        DataSnap(String jSonString) {
            this.jSonString = jSonString;
        }
        DataSnap(String jSonString, List<String> mismatchL) {
            this.jSonString = jSonString;
            for (int i=0;i<mismatchL.size();i++)
                mismatchKeys.add(mismatchL.get(i));
        }
        public String getMismatchKeys() {
            return Arrays.toString(mismatchKeys.toArray());
        }
        public String get(String key) {
            JSONParser parser = new JSONParser();
            String s = null;
            try {
                Object obj = parser.parse(this.jSonString);
                JSONObject jsonObject = null;
                try {
                    jsonObject = (JSONObject) obj;
                } catch (ClassCastException e) {
                    System.out.println("parsed object already a string");
                }
                try {
                    s = (String) jsonObject.get(key);
                } catch (ClassCastException e) {
                    try {
                        throw new GetException("Not a String. use getKeys() instead.");
                    } catch (GetException getException) {
                        getException.printStackTrace();
                        System.exit(-1);
                    }
                }
                try {
                    Object impediment = parser.parse(s);
                    JSONObject jimepdiment = (JSONObject) impediment;
                    throw new GetException("Not a String. use getKeys() instead.");
                } catch (ParseException e) {

                } catch (GetException e) {
                    e.printStackTrace();
                    System.exit(-1);
                } catch (ClassCastException e) {}
                catch (NullPointerException e) {
                    try {
                        throw new GetException("invalid key");
                    } catch (GetException getException) {
                        getException.printStackTrace();
                    }
                }
            } catch (org.json.simple.parser.ParseException  e) {
                e.printStackTrace();
            }
            return s;
        }
        @RequiresApi(api = Build.VERSION_CODES.N)
        public String[] getKeys() {
            List<String> keys = new ArrayList<>();
            JSONParser parser = new JSONParser();
            Object obj = null;
            try {
                obj = parser.parse(jSonString);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            try {
                JSONObject jsonObject = (JSONObject) obj;
                jsonObject.keySet().forEach(keystr->{
                    Object oValue = jsonObject.get(keystr);
                    System.out.println("json loop: "+keystr);
                    keys.add(String.valueOf(oValue));
                });
            } catch (ClassCastException e) {
                try {
                    throw new GetException("It's a String. use get(String s) instead.");
                } catch (GetException getException) {
                    getException.printStackTrace();
                }
            }


            return (String[]) keys.toArray();
        }

    }
    //    String getValue() {
//        if (!STATUS.equals(lastHttpAction.GET.name())&&!STATUS.equals(lastHttpAction.CLEAR.name())) {
//            try {
//                throw new PendingSetorDeleteExecutionException("PendingSetorDeleteExecutionException");
//            } catch (PendingSetorDeleteExecutionException e) {
//                e.printStackTrace();
//                System.exit(-1);
//            }
//        }
//        FireBrickWall.bGetUsed = true;
//        STATUS = lastHttpAction.GET.name();
//
//        return null;
//    }
    public class JsonItems {
        private String httpMethod;
        public List<String> paths = new ArrayList<>();
        public ArrayList<JsonBody> jsonBodies = new ArrayList<>();
        JsonItems(String httpMethod, List<String> pathsp,JsonBody jsonBody) {
            this.httpMethod = httpMethod;
            for (int i =0;i<pathsp.size();i++)
                paths.add(pathsp.get(i));
            jsonBodies.add(jsonBody);
        }
        JsonItems(String httpMethod, List<String> pathsp) {
            this.httpMethod = httpMethod;
            for (int i =0;i<pathsp.size();i++)
                paths.add(pathsp.get(i));
        }

        @Override
        public String toString() {
            return httpMethod+"-"+Arrays.toString(paths.toArray()) +
                    ", ->" + jsonBodies.toString() +
                    '\n';
        }
    }
    class booleanStatus {
        private int count;
        private boolean aBoolean;
        booleanStatus(int count,boolean aBoolean) {
            this.count = count;
            this.aBoolean = aBoolean;
        }

        @Override
        public String toString() {
            return String.valueOf(count)+"->"+String.valueOf(aBoolean)+"\n";
        }
    }
    public class JsonBody {
        public String key;
        public String value;
        JsonBody(String key, String value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public String toString() {
            return "{ "+key  +
                    "," + value +
                    '}';
        }
    }
    public static class NullPathException extends Exception {
        public NullPathException(String message) {
            super(message);
        }
    }
    public static class PendingSetorDeleteExecutionException extends Exception {
        public PendingSetorDeleteExecutionException(String message) {
            super(message);
        }
    }
    public static class PendingGetorDeleteExecutionException extends Exception {
        public PendingGetorDeleteExecutionException(String message) {
            super(message);
        }
    }
    public static class PendingSetorGetExecutionException extends Exception {
        public PendingSetorGetExecutionException(String message) {
            super(message);
        }
    }
    public static class RTDatabaseUrlException extends Exception {
        public RTDatabaseUrlException(String message) {
            super(message);
        }
    }
    public static class FBWGetException extends Exception {
        public FBWGetException(String message) {
            super(message);
        }
    }
    public static class FBWChildException extends Exception {
        public FBWChildException(String message) {
            super(message);
        }
    }
    public static class GetException extends Exception {
        public GetException(String message) {
            super(message);
        }
    }

}