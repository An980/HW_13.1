import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class RepositoryTest {

    Repository repo = new Repository();

    Book b1 = new Book(101, "Book One", 100, "Pushkin");
    Book b2 = new Book(102, "Book Two", 500, "Mayakovsky");
    Book b3 = new Book(103, "Book Three", 300, "Tolstoy");
    Smartphone s1 = new Smartphone(201, "Smatrphone One", 15999, "ManufacturOne");
    Smartphone s2 = new Smartphone(202, "Smatrphone Two", 11999, "ManufacturTwo");
    Smartphone s3 = new Smartphone(203, "Smatrphone Three", 19999, "ManufacturThree");

    @BeforeEach
    public void startUp() {
        repo.saveProducts(b1);
        repo.saveProducts(b2);
        repo.saveProducts(b3);
        repo.saveProducts(s1);
        repo.saveProducts(s2);
        repo.saveProducts(s3);
    }

    @Test
    public void saveProducts() {

        Product[] expected = {b1, b2, b3, s1, s2, s3};
        Product[] actual = repo.getAllProducts();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void removeProductsById() {

        repo.removeProductsById(s2.getId());
        repo.removeProductsById(b2.getId());

        Product[] expected = {b1, b3, s1, s3};
        Product[] actual = repo.getAllProducts();

        Assertions.assertArrayEquals(expected, actual);
    }


}
