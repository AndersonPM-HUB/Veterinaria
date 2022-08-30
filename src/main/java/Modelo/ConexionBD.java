
package Modelo;


public class ConexionBD {

    private String driver = "com.mysql.jdbc.Driver";
    private String user = "root";
    private String password = "";
    private String url = "jdbc:mysql://localhost:3306/mascotafeliz";

    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
