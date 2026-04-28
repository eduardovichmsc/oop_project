package abstracts;

import enums.RequestType;

public abstract class User {
    protected int id;
    protected String login;
    protected String name;
    protected String surname;
    protected String email;

    public User(int id, String login, String name, String surname, String email) {
        this.id = id;
        this.login = login;
        this.name = name;
        this.surname = surname;
        this.email = email;
    }

    // getters & setters
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getLogin() {
        return login;
    }
    public void setLogin(String login) {
        this.login = login;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getSurname() {
        return surname;
    }
    public void setSurname(String surname) {
        this.surname = surname;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    // methods
    public abstract boolean login();
    public abstract boolean logout();
    public String getFullName(){
        return String.format("%s %s", this.name, this.surname);
    }
    public abstract void createRequest(RequestType type, String message);
    // public abstract List<News> viewNews();
}
