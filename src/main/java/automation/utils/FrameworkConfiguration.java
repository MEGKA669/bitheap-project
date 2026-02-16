package automation.utils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("framework.properties")

public class FrameworkConfiguration {
    @Value("${browser}")
    private String browser;
    @Value("${email}")
    private String email;
    @Value("${password}")
    private String password;
    @Value("${loginUsername}")
    private String loginUsername;

    public String getNombrePanier() {
        return nombrePanier;
    }

    public void setNombrePanier(String nombrePanier) {
        this.nombrePanier = nombrePanier;
    }

    @Value("${nombrePanier}")
    private String nombrePanier;

    public String getBrowser() {
        return browser;
    }

    public void setBrowser(String browser) {
        this.browser = browser;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLoginUsername(){
        return loginUsername;
    }

    public void setLoginUsername(String loginUsername) {
        this.loginUsername = loginUsername;
    }
}
