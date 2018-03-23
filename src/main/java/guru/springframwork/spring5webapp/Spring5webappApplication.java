package guru.springframwork.spring5webapp;

import guru.springframwork.spring5webapp.model.Author;
import guru.springframwork.spring5webapp.model.Book;
import guru.springframwork.spring5webapp.repository.AuthorRepository;
import guru.springframwork.spring5webapp.repository.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class Spring5webappApplication implements CommandLineRunner{

    public Spring5webappApplication(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }


    AuthorRepository authorRepository;
    BookRepository bookRepository;

	public static void main(String[] args) {
		SpringApplication.run(Spring5webappApplication.class, args);
	}


    private void repositorySave(Object ... o) {
        for (Object value : o) {
            if (value instanceof Author) authorRepository.save((Author)value);
            else if (value instanceof Book) bookRepository.save((Book)value);
        }
    }


	@Override
	public void run(String... args) throws Exception {
		Author author = new Author("Dima", "Mukhin");
		Book book = new Book("lol", "wow", "omg");
		repositorySave(author, book);
	}
}
