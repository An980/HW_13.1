public class Book extends Product {

    //  private String bookTitle;
    private String bookAuthor;

    public Book(int id, String name, int price, /*String bookTitle,*/ String bookAuthor) {
        super(id, name, price);
//      this.bookTitle = bookTitle;
        this.bookAuthor = bookAuthor;
    }

}
