package data;


public class ReservedGift {
    private int giftId;
    private String giftName;
    private int quantity;
    private String link;
    private int ranking;
    private String comment;
    private int authorId;
    private String authorName;

    public ReservedGift(int giftId, String giftName, int quantity, String link, int ranking, String comment, int authorId, String authorName) {
        this.giftId = giftId;
        this.giftName = giftName;
        this.quantity = quantity;
        this.link = link;
        this.ranking = ranking;
        this.comment = comment;
        this.authorId = authorId;
        this.authorName = authorName;
    }

    public int getGiftId() {
        return giftId;
    }

    public void setGiftId(int giftId) {
        this.giftId = giftId;
    }

    public String getGiftName() {
        return giftName;
    }

    public void setGiftName(String giftName) {
        this.giftName = giftName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
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

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public int getAuthorId() {
        return authorId;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }
    
    
    
    
}
