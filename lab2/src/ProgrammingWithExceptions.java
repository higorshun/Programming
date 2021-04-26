//import java.io.IOException;
//import java.io.InputStream;
//import java.io.OutputStream;
//import java.net.MalformedURLException;
//import java.net.*;
//
//
//public class ProgrammingWithExceptions {
//
//
//    public static void main(String[] args) throws MalformedURLException {
//        OutputStream fileName = null;
//        InputStream inputStream = null;
//
//        System.out.println("Type the website to visit.");
//        String userInput = TextIO.getlnString();
//
//
//        try{
//
//            URL url = new URL(userInput);
//            fileName = OutputStream.nullOutputStream();
//            copyStream(url,fileName);
//
//        } catch(IllegalArgumentException e) {
//            System.out.println("Invalid address" + e.getMessage());
//        }
//
//
//    }
//
//
//    private static void copyStream(InputStream in, OutputStream out)
//            throws IOException {
//        int oneByte = in.read();
//        while (oneByte >= 0) { // negative value indicates end-of-stream
//            out.write(oneByte);
//            oneByte = in.read();
//        }
//
//    }
//}