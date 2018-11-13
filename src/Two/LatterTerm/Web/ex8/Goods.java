package Two.LatterTerm.Web.ex8;

public class Goods {
    String name;
    int price;
    String description;
    String link;

    Goods(String name, int price, String description, String link) {
        this.name = name;
        this.price = price;
        this.description = description;
        this.link = link;
    }
    Goods(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}