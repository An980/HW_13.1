import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ProductManagerTest {

    Repository repo = new Repository();
    ProductManager man = new ProductManager(repo);

    Book b1 = new Book(101, "Book One", 100, "Pushkin");
    Book b2 = new Book(102, "Book Two", 500, "Mayakovsky");
    Book b3 = new Book(103, "Book Three", 300, "Tolstoy");
    Smartphone s1 = new Smartphone(201, "Smatrphone One", 15999, "ManufacturOne");
    Smartphone s2 = new Smartphone(202, "Smatrphone Two", 11999, "ManufacturTwo");
    Smartphone s3 = new Smartphone(203, "Smatrphone Three", 19999, "ManufacturThree");

    @BeforeEach
    public void startUp() {
        man.add(b1);
        man.add(b2);
        man.add(b3);
        man.add(s1);
        man.add(s2);
        man.add(s3);
    }

    @Test
    public void addNew() {//добавить новый

        Smartphone s4 = new Smartphone(204, "Smatrphone Fourth", 29999, "ManufacturFour");
        man.add(s4);

        Product[] expected = {b1, b2, b3, s1, s2, s3, s4};
        Product[] actual = man.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void getAllProductList() {//получить весь список товаров

        Product[] expected = {b1, b2, b3, s1, s2, s3};
        Product[] actual = man.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void searchByEmptyParams() {//поиск без параметров
        Product[] expected = {b1, b2, b3, s1, s2, s3};
        Product[] actual = man.searchByName("");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void searchByName() {//поиск по имени

        Product[] expected = {b2};
        Product[] actual = man.searchByName("Book Two");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void searchByNegativeName() {//поиск по несуществуещему имени

        Product[] expected = {};
        Product[] actual = man.searchByName("Book Four");

        Assertions.assertArrayEquals(expected, actual);
    }


//------------------------------------------------Тесты по доп. заданию------------------------------------------------//


    @Test
    public void searchByBookTitle() {//поиск по названию книги

        Boolean expected = true;
        Boolean actual = man.matches(b3, "Book Three");


        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void searchByAuthor() {//поиск по автору

        Boolean expected = true;
        Boolean actual = man.matches(b3, "Tolstoy");


        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void searchByBookTitleNegative() {//поиск по автору

        Boolean expected = false;
        Boolean actual = man.matches(b3, "King");


        Assertions.assertEquals(expected, actual);
    }


    @Test
    public void searchByModel() {//поиск по модели

        Boolean expected = true;
        Boolean actual = man.matches(s2, "Smatrphone Two");


        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void searchByManufacturer() {//поиск по производителю

        Boolean expected = true;
        Boolean actual = man.matches(s2, "ManufacturTwo");


        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void searchByModelNegative() {//поиск по автору

        Boolean expected = false;
        Boolean actual = man.matches(s2, "Smartphone Six");


        Assertions.assertEquals(expected, actual);
    }
}
