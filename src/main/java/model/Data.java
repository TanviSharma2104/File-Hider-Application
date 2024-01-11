package model;

public class Data {
    private int id;
    private String fileName;
    private String email;
    private String path;

    public Data(int id, String fileName, String path) {
        this.id = id;
        this.fileName = fileName;
        this.path = path;
    }

    public Data(int id, String fileName, String path,String email) {
        this.id = id;
        this.fileName = fileName;
        this.email = email;
        this.path = path;
    }

    public String getEmail() {
        return email;
    }

    public String getFileName() {
        return fileName;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getId(){
        return id;
    }

    public void setId(int id){
        this.id=id;
    }
}
