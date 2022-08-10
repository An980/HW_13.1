public class Repository {

    Product[] products = new Product[0];//пустой массив

    public void saveProducts(Product product) {//сохранеие продуктов
        Product[] tmp = new Product[products.length + 1];
        for (int i = 0; i < products.length; i++) {
            tmp[i] = products[i];
        }
        tmp[tmp.length - 1] = product;
        products = tmp;
    }

    public void removeProductsById(int id) {//удаление продуктов по id
        Product[] tmp = new Product[products.length - 1];
        int copyToIndex = 0;
        for (Product film : products) {
            if (film.getId() != id) {
                tmp[copyToIndex] = film;
                copyToIndex++;
            }
        }
        products = tmp;
    }

    public Product[] getAllProducts() {//получение продуктов
        return products;
    }


}
