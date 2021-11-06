import org.junit.jupiter.api.*;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.*;

class DaoTest {
    static Dao<Book, Long> bookDao;
    static Dao<Person, Long> personDao;

    @BeforeAll
    static void setUp() throws Exception {
        bookDao = new Dao<Book, Long>();
        personDao = new Dao<Person, Long>();
        // normally we would configure a different database for testing
        bookDao.setup("hibernate.cfg.xml");
        personDao.setup("hibernate.cfg.xml");
    }

    @AfterAll
    static void tearDown() {
        bookDao.clear("Book");
        bookDao.exit();
        personDao.clear("Person");
        personDao.exit();
    }


//    They should have another Nested set of tests
    @Nested
    class BookTests {
        Book book;

        @BeforeEach
        void setUp() {
            book = new Book();
            book.setTitle("Title");
            book.setAuthor("Author");
            book.setPrice(0.0f);
        }

        @Test
        void create() {
            bookDao.create(book);
            Book bookFromDB = bookDao.read(Book.class, book.getBookId());
            assertEquals(book.getTitle(), bookFromDB.getTitle());
        }

        @Test
        void update() {
            bookDao.create(book);
            book.setTitle("Updated Title");
            bookDao.update(book);
            Book bookFromDB = bookDao.read(Book.class, book.getBookId());
            assertEquals(book.getTitle(), bookFromDB.getTitle());
        }

        @Test
        void delete() throws Exception {
            bookDao.create(book);
            Book bookFromDB = bookDao.read(Book.class, book.getBookId());
            if (bookFromDB != null){
                bookDao.delete(book);
                bookFromDB = bookDao.read(Book.class, book.getBookId());
                assertNull(bookFromDB);
            }
            else {
                throw new Exception("Create Doesn't Work");
            }
        }
    }

    @Nested
    class PersonTests {
        Person person;

        @BeforeEach
        void setUp() {
            person = new Person();
            person.setName("Name");
            person.setAge(40);
        }

        @Test
        void create() {
            personDao.create(person);
            Person personFromDB = personDao.read(Person.class, person.getPersonID());
            assertEquals(person.getName(), personFromDB.getName());
        }

        @Test
        void update() {
            personDao.create(person);
            person.setName("Updated Name");
            personDao.update(person);
            Person personFromDB = personDao.read(Person.class, person.getPersonID());
            assertEquals(person.getName(), personFromDB.getName());
        }

        @Test
        void delete() throws Exception {
            personDao.create(person);
            Person personFromDB = personDao.read(Person.class, person.getPersonID());
            if (personFromDB != null){
                personDao.delete(person);
                personFromDB = personDao.read(Person.class, person.getPersonID());
                assertNull(personFromDB);
            }
            else {
                throw new Exception("Create Doesn't Work");
            }
        }

    }

}