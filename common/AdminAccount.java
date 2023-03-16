package common;

import java.io.Serializable;

public class AdminAccount implements Serializable {

    protected String type;      // type of user: admin or customer
    protected String username;
    protected String password;
    protected String name;
    protected int userId;


    public AdminAccount () {
        this.name = "";
        this.type = "";
        this.userId = -1;
        this.username = "";
        this.password = "";
    } // end default constructor

    public AdminAccount (String name, String type) {
        this.name = name;
        this.type = type;
        this.userId = -1;
        this.username = "";
        this.password = "";
    } // end constructor

    public AdminAccount (String name, String type, String username, String password) {
        this.name = name;
        this.type = type;
        this.username = username;
        this.password = password;
    } // end constructor 2 (for dummy user creation purposes)

    // getters and setters
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {

        this.userId = userId;
    }

} // end class def
