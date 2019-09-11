package up5;

public class CameraNode {
    private String comp;
    private String country;
    private String name;
    private int price;

    CameraNode(String comp, String model, String year, String price) {
        this.comp = comp;
        this.country = model;

        try {
            this.name = year;
            this.price = Integer.parseInt(price);
        } catch (Exception e) {
            this.price = -1;
        }
    }

    String getComp() {
        return comp;
    }

    String getCountry() {
        return country;
    }

    String getName() {
        return name;
    }

    int getPrice() {
        return price;
    }

}
