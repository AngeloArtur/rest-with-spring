package br.com.rest.rest_with_springboot;

public class Greeting {
    private final long ID;
    private final String Content;

    public long getID() {
        return ID;
    }

    public String getContent() {
        return Content;
    }


    public Greeting(long id, String content) {
        ID = id;
        Content = content;
    }


}
