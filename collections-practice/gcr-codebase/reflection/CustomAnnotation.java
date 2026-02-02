import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
@interface Author {
    String name();
}

@Author(name = "Ali Hazelwood")
class Book { }

public class CustomAnnotation {
    public static void main(String[] args) {
        Author author = Book.class.getAnnotation(Author.class);
        System.out.println("Author: " + author.name());
    }
}