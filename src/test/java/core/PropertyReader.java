package core;

import ru.qatools.properties.Property;
import ru.qatools.properties.PropertyLoader;
import ru.qatools.properties.Resource;

@Resource.Classpath("config.properties")
public class PropertyReader extends TestBase {

    @Property("URL")
    public static String baseUrl;

    @Property("LOGIN")
    public static String login;

    @Property("PASSWORD")
    public static String password;

    public PropertyReader() {
        PropertyLoader.newInstance().populate(this);
    }
}
