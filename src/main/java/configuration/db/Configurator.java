package configuration.db;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class Configurator {

    public static Properties getConfigurator() {
    }

    public Properties getconfiguration() throws IDException, IOException {
        Properties properties = new Properties();
        InputStream filImputStreem = new FileInputStream(
                System.getProperty("user.dir") + "src/resources/dbproperties");

        properties.load (filImputStreem);
        return properties;
    }


}

