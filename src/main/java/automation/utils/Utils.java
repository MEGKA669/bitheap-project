package automation.utils;

import automation.drivers.DriverSingleton;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Base64;
import java.util.Random;

import org.springframework.util.FileCopyUtils;



//decoder des mdp écrit en base64
public class Utils {
    public static String decode64(String encodedStr){
        Base64.Decoder decoder = Base64.getDecoder();
        return new String(decoder.decode(encodedStr.getBytes()));
    }
//Code pour la prise de screen
//public static boolean screenShot(){
//        File file = ((TakesScreenshot) DriverSingleton.getDriver()).getScreenshotAs(OutputType.FILE);//ici on est entrain de convertir le pilote en une interface de screenshot
//
//    try {
//        FileCopyUtils.copy(file, new File(constantes.SCREENSHOT_FOLDER + generateRandomString(constantes.SCREENSHOT_NAME_LENGTH) + constantes.SCREENSHOT_EXTERNSIONS)); // \\c'est pour préciser que c'est un répertoire
//        return true;
//    }catch (IOException e){
//        return false;
//    }
//}
//private static String generateRandomString(int length){
//        String seedChars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
//        StringBuilder sb = new StringBuilder();
//
//        int i = 0;
//        Random random = new Random();
//        while (i < length){
//            sb.append(seedChars.charAt(random.nextInt(seedChars.length())));
//            i++;
//        }
//        return sb.toString();
//
//}

    public static byte[] screenShot() {
        try {
            // Prendre le screenshot
            File file = ((TakesScreenshot) DriverSingleton.getDriver())
                    .getScreenshotAs(OutputType.FILE);

            // Lire le contenu en byte[]
            byte[] bytes = Files.readAllBytes(file.toPath());

            // Sauvegarder le fichier (optionnel)
            String fileName = constantes.SCREENSHOT_FOLDER
                    + generateRandomString(constantes.SCREENSHOT_NAME_LENGTH)
                    + constantes.SCREENSHOT_EXTERNSIONS;
            FileCopyUtils.copy(file, new File(fileName));

            // Retourner le byte[] pour Allure
            return bytes;

        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    private static String generateRandomString(int length){
        String seedChars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < length; i++){
            sb.append(seedChars.charAt(random.nextInt(seedChars.length())));
        }
        return sb.toString();
    }



}
