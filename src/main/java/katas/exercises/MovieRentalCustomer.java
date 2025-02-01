package katas.exercises;

import katas.exercises.movieRental.Movie;
import katas.exercises.movieRental.Rental;

import java.util.ArrayList;
import java.util.List;

/**
 * This source code follows Martin Fowler's book "Refactoring, Improving the Design of Existing Code".
 * When you find you have to add a feature to a program, and the program's code is not
 * structured in a convenient way to add the feature, first refactor the program to make it
 * easy to add the feature, then add the feature.
 *
 * Whenever you do refactoring, you MUST build a solid set of tests for that section of code.
 *
 * The `statement` method prints out a simple text output of a rental statement:
 *
 *      Rental Record for martin
 *        Ran 3.5
 *        Trois Couleurs: Bleu 2.0
 *      Amount owed is 5.5
 *      You earned 2 frequent renter points
 *
 *
 * We want to write an HTML version of the statement method :
 *
 *      <h1>Rental Record for <em>martin</em></h1>
 *      <table>
 *        <tr><td>Ran</td><td>3.5</td></tr>
 *        <tr><td>Trois Couleurs: Bleu</td><td>2.0</td></tr>
 *      </table>
 *      <p>Amount owed is <em>5.5</em></p>
 *      <p>You earned <em>2</em> frequent renter points</p>
 *
 * Carfully think how to refactor this code, and write the corresponding tests under MovieRentalCustomerTest.
 */
public class MovieRentalCustomer {





    private String _name;
    private List<Rental> _rentals = new ArrayList<Rental>();

    public MovieRentalCustomer(String name) {

        _name = name;
    }

    public void addRental(Rental arg) {

        _rentals.add(arg);
    }

    public String getName() {

        return _name;
    }


    public String generateTextStatement() {
        double totalAmount = 0;
        int frequentRenterPoints = 0;
        StringBuilder result = new StringBuilder("Rental Record for " + getName() + "\n");

        for (Rental rental : _rentals) {
            double thisAmount = rental.getMovie().getCharge(rental.getDaysRented());
            frequentRenterPoints += rental.getMovie().getFrequentRenterPoints(rental.getDaysRented());

            result.append("\t").append(rental.getMovie().getTitle())
                    .append("\t").append(thisAmount).append("\n");

            totalAmount += thisAmount;
        }

        result.append("Amount owed is ").append(totalAmount).append("\n");
        result.append("You earned ").append(frequentRenterPoints).append(" frequent renter points");

        return result.toString();
    }

    public String generateHtmlStatement() {
        double totalAmount = 0;
        int frequentRenterPoints = 0;
        StringBuilder result = new StringBuilder("<h1>Rental Record for <em>" + getName() + "</em></h1>\n");
        result.append("<table>\n");

        for (Rental rental : _rentals) {
            double thisAmount = rental.getMovie().getCharge(rental.getDaysRented());
            frequentRenterPoints += rental.getMovie().getFrequentRenterPoints(rental.getDaysRented());

            result.append("  <tr><td>").append(rental.getMovie().getTitle())
                    .append("</td><td>").append(thisAmount).append("</td></tr>\n");

            totalAmount += thisAmount;
        }

        result.append("</table>\n");
        result.append("<p>Amount owed is <em>").append(totalAmount).append("</em></p>\n");
        result.append("<p>You earned <em>").append(frequentRenterPoints).append("</em> frequent renter points</p>");

        return result.toString();
    }

}
