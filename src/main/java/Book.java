public class Book extends Product {

    //  private String bookTitle;
    private String bookAuthor;

    public String getBookAuthor() {
        return bookAuthor;
    }

    public Book(int id, String name, int price, /*String bookTitle,*/ String bookAuthor) {
        super(id, name, price);
//      this.bookTitle = bookTitle;
        this.bookAuthor = bookAuthor;
    }

    @Override
    public boolean matches(String search) {
        if (super.matches(search)) { // вызов метода matches в версии описанной в Product
            return true;
        }
        if (getBookAuthor().contains(search)) {
            return true;
        } else {
            return false;
        }
    }
}

