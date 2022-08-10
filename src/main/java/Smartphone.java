public class Smartphone extends Product {

    //  private String smartphoneModel;
    private String smartphoneManufacturer;

    public Smartphone(int id, String name, int price, /*String smartphoneModel,*/ String smartphoneManufacturer) {
        super(id, name, price);
//      this.smartphoneModel = smartphoneModel;
        this.smartphoneManufacturer = smartphoneManufacturer;
    }

}
