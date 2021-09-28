package data;

public class Gift {
    private int id;
    private String name;
    private int quantity;
    private String link;
    private int ranking;
    private String comment;
    private String listId;
    private boolean isReserved;
    private int reservedBy;

      public Gift(int id, String name, String link, int ranking, int quantity, String comment, String listId, boolean isReserved, int reservedBy) {
        this.id = id;
        this.name = name;
        this.link = link;
        this.ranking = ranking;
        this.quantity = quantity;
        this.comment = comment;
        this.listId = listId;
        this.isReserved = isReserved;
        this.reservedBy = reservedBy;
    }
      
    public Gift(int id, String name, String link, int ranking, int quantity, String comment, String listId, boolean isReserved) {
        this.id = id;
        this.name = name;
        this.link = link;
        this.ranking = ranking;
        this.quantity = quantity;
        this.comment = comment;
        this.listId = listId;
        this.isReserved = isReserved;
    }
    
    public int getReservedBy() {
        return reservedBy;
    }

    public void setReservedBy(int reservedBy) {
        this.reservedBy = reservedBy;
    }

    public String getListId() {
        return listId;
    }

    public void setListId(String listId) {
        this.listId = listId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
      
    public boolean isReserved() {
        return isReserved;
    }

    public void setReserved(boolean isReserved) {
        this.isReserved = isReserved;
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
