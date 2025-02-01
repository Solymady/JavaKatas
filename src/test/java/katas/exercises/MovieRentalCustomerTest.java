package katas.exercises;

import katas.exercises.movieRental.Movie;
import katas.exercises.movieRental.Rental;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MovieRentalCustomerTest {

    @Test
    public void testEmptyCustomerStatement() {
        MovieRentalCustomer customer = new MovieRentalCustomer("NoRentals");

        String expectedText = "" +
                "Rental Record for NoRentals\n" +
                "Amount owed is 0.0\n" +
                "You earned 0 frequent renter points";

        String expectedHtml = "" +
                "<h1>Rental Record for <em>NoRentals</em></h1>\n" +
                "<table>\n</table>\n" +
                "<p>Amount owed is <em>0.0</em></p>\n" +
                "<p>You earned <em>0</em> frequent renter points</p>";

        assertEquals(expectedText, customer.generateTextStatement());
        assertEquals(expectedHtml, customer.generateHtmlStatement());
    }

    @Test
    public void testSingleRegularMovieRental() {
        MovieRentalCustomer customer = new MovieRentalCustomer("SingleRental");
        customer.addRental(new Rental(new Movie("Interstellar", Movie.REGULAR), 1));

        String expectedText = "" +
                "Rental Record for SingleRental\n" +
                "\tInterstellar\t2.0\n" +
                "Amount owed is 2.0\n" +
                "You earned 1 frequent renter points";

        assertEquals(expectedText, customer.generateTextStatement());
    }

    @Test
    public void testSingleNewReleaseMovieRental() {
        MovieRentalCustomer customer = new MovieRentalCustomer("SingleNewRelease");
        customer.addRental(new Rental(new Movie("Inception", Movie.NEW_RELEASE), 1));

        String expectedText = "" +
                "Rental Record for SingleNewRelease\n" +
                "\tInception\t3.0\n" +
                "Amount owed is 3.0\n" +
                "You earned 1 frequent renter points";


        String actualText = customer.generateTextStatement();
        assertEquals(expectedText.trim(), actualText.trim());
    }


    @Test
    public void testSingleChildrenMovieRental() {
        MovieRentalCustomer customer = new MovieRentalCustomer("SingleChildMovie");
        customer.addRental(new Rental(new Movie("Frozen", Movie.CHILDRENS), 1));

        String expectedText = "" +
                "Rental Record for SingleChildMovie\n" +
                "\tFrozen\t1.5\n" +
                "Amount owed is 1.5\n" +
                "You earned 1 frequent renter points";

        String actualText = customer.generateTextStatement();
        assertEquals(expectedText.trim(), actualText.trim());
    }


    @Test
    public void testRegularMovieBoundary() {
        MovieRentalCustomer customer = new MovieRentalCustomer("RegularBoundary");
        customer.addRental(new Rental(new Movie("Titanic", Movie.REGULAR), 3));

        String expectedText = "" +
                "Rental Record for RegularBoundary\n" +
                "\tTitanic\t3.5\n" +
                "Amount owed is 3.5\n" +
                "You earned 1 frequent renter points";

        String actualText = customer.generateTextStatement();
        assertEquals(expectedText.trim(), actualText.trim());
    }



    @Test
    public void testNewReleaseLongRental() {
        MovieRentalCustomer customer = new MovieRentalCustomer("LongNewRelease");
        customer.addRental(new Rental(new Movie("Avatar 2", Movie.NEW_RELEASE), 10));

        String expectedText = "" +
                "Rental Record for LongNewRelease\n" +
                "\tAvatar 2\t30.0\n" +
                "Amount owed is 30.0\n" +
                "You earned 2 frequent renter points";

        assertEquals(expectedText, customer.generateTextStatement());
    }

    @Test
    public void testChildrenMovieLongRental() {
        MovieRentalCustomer customer = new MovieRentalCustomer("ChildMovieLong");
        customer.addRental(new Rental(new Movie("The Lion King", Movie.CHILDRENS), 10));

        String expectedText = "" +
                "Rental Record for ChildMovieLong\n" +
                "\tThe Lion King\t12.0\n" +
                "Amount owed is 12.0\n" +
                "You earned 1 frequent renter points";

        assertEquals(expectedText, customer.generateTextStatement());
    }

    @Test
    public void testMultipleNewReleaseMoviesFrequentRenterPoints() {
        MovieRentalCustomer customer = new MovieRentalCustomer("FrequentPointsTest");
        customer.addRental(new Rental(new Movie("John Wick", Movie.NEW_RELEASE), 2));
        customer.addRental(new Rental(new Movie("Mad Max", Movie.NEW_RELEASE), 2));

        String expectedText = "" +
                "Rental Record for FrequentPointsTest\n" +
                "\tJohn Wick\t6.0\n" +
                "\tMad Max\t6.0\n" +
                "Amount owed is 12.0\n" +
                "You earned 4 frequent renter points";

        assertEquals(expectedText, customer.generateTextStatement());
    }

    @Test
    public void testHtmlStatementWithSingleRental() {
        MovieRentalCustomer customer = new MovieRentalCustomer("HtmlTest");
        customer.addRental(new Rental(new Movie("Spirited Away", Movie.CHILDRENS), 3));

        String expectedHtml = "" +
                "<h1>Rental Record for <em>HtmlTest</em></h1>\n" +
                "<table>\n" +
                "  <tr><td>Spirited Away</td><td>1.5</td></tr>\n" +
                "</table>\n" +
                "<p>Amount owed is <em>1.5</em></p>\n" +
                "<p>You earned <em>1</em> frequent renter points</p>";

        assertEquals(expectedHtml, customer.generateHtmlStatement());
    }
}
