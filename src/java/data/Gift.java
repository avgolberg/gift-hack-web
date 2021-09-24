package data;

public class Gift {
    private String name;
    private int quantity;
    private String link;
    private int ranking;
    private String comment;

    public Gift(String name, String link, int ranking, int quantity, String comment) {
        this.name = name;
        this.link = link;
        this.ranking = ranking;
        this.quantity = quantity;
        this.comment = comment;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public int getRanking() {
        return ranking;
    }

    public void setRanking(int ranking) {
        this.ranking = ranking;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
    
    
}
