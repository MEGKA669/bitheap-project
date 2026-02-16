package automation.utils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class FrameworkProperties {
    private String resultat = "";//elle va étre la valeur réelle extraite du fichier
    private InputStream inputStream;

    public String getProperty(String Key){//quand on veut prendre une valeur depuis le fichier en question on fait appelle a cette méthode
        try {
            Properties properties = new Properties();
            String propFileName = constantes.PROP_FILE_NAME;

            inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);

            if( inputStream != null){
                properties.load(inputStream);
            }else
                throw new FileNotFoundException(constantes.FILE_NOT_FOUND_EXCEPTION_MESSAGE);

            String propretyValue = properties.getProperty(Key);
            this.resultat = propretyValue;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return resultat;

    }

}
