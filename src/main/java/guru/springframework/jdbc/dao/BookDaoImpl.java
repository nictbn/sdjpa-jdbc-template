package guru.springframework.jdbc.dao;

import guru.springframework.jdbc.domain.Book;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

@Component
public class BookDaoImpl implements BookDao {
    private final JdbcTemplate jdbcTemplate;

    public BookDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Book getById(Long id) {
        return jdbcTemplate.queryForObject(
                "SELECT * FROM book where id = ?",
                getBookMapper(),
                id
        );
    }

    @Override
    public Book findByTitle(String title) {
        return jdbcTemplate.queryForObject(
                "SELECT * FROM book where title = ?",
                getBookMapper(),
                title
        );
    }

    @Override
    public Book saveNewBook(Book book) {
        return null;
    }

    @Override
    public Book updateBook(Book book) {
        return null;
    }

    @Override
    public void deleteBook(Long id) {

    }

    private RowMapper<Book> getBookMapper() {
        return new BookMapper();
    }
}
