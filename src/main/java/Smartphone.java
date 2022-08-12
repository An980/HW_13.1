public class Smartphone extends Product {

    //  private String smartphoneModel;
    private String smartphoneManufacturer;

    public String getSmartphoneManufacturer() {
        return smartphoneManufacturer;
    }

    public Smartphone(int id, String name, int price, /*String smartphoneModel,*/ String smartphoneManufacturer) {
        super(id, name, price);
//      this.smartphoneModel = smartphoneModel;
        this.smartphoneManufacturer = smartphoneManufacturer;
    }

    @Override
    public boolean matches(String search) {
        if (super.matches(search)) {
            return true;
        }
        if (getSmartphoneManufacturer().contains(search)) {
            return true;
        } else {
            return false;
        }

    }
}


