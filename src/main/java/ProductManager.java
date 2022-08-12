public class ProductManager {

    private Repository repo;

    public ProductManager(Repository repo) {
        this.repo = repo;
    }

    public void add(Product product) {//добавить продукт
        repo.saveProducts(product);
    }

    public Product[] findAll() {
        return repo.getAllProducts();
    }

    public Product[] searchByName(String text) {//поиск по имени
        Product[] result = new Product[0]; // тут будем хранить подошедшие запросу продукты
        for (Product product : repo.getAllProducts()) {
            if (matches(product, text)) {
                Product[] tmp = new Product[result.length + 1];
                for (int i = 0; i < result.length; i++) {
                    tmp[i] = result[i];
                }
                tmp[result.length] = product;
                result = tmp;
            }
        }
        return result;
    }

//    public Product[] searchByNameSecondMethod(String text) {//поиск по имени (второй метод без boolean matches)
//        Product[] result = new Product[0]; // тут будем хранить подошедшие запросу продукты
//        for (Product product : repo.getAllProducts()) {
//            if (product.matches(text)) {
//                Product[] tmp = new Product[result.length + 1];
//                for (int i = 0; i < result.length; i++) {
//                    tmp[i] = result[i];
//                }
//                tmp[result.length] = product;
//                result = tmp;
//            }
//        }
//        return result;
//    }


    public boolean matches(Product product, String search) {
        if (product.matches(search)) {
            return true;
        } else {
            return false;
        }
    }

//    public boolean matches(Product product, String search) {
//        if (product.getName().contains(search)) {
//            return true;
//        } else {
//            return false;
//        }
//    }

}