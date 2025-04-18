// Tristan Suwito
// 8 April 2025
// CSE 123
// C0: Search Engine
// TA: Rushil Arun & Chris Ma
// This class implements the Media interface and represents a book.
import java.util.*;

public class Book implements Media, Comparable<Book> {
    private String title;
    private List<String> authors;
    private List<String> contentList;
    private List<Integer> ratings;

    // Behavior:
    //   - This method creates/intializes a book with the provided title, list of author(s), and
    //     content in the given scanner.
    // Parameters:
    //   - title: title of the book.
    //   - authors: list of the book's authors.
    //   - content: content of the book.
    // Returns:
    // Exceptions:
    public Book(String title, List<String> authors, Scanner content) {
        this.title = title;
        this.authors = new ArrayList<>(authors);
        this.contentList = new ArrayList<>();
        this.ratings = new ArrayList<>();

        while(content.hasNext()) {
            this.contentList.add(content.next());
        }
    }

    // Behavior:
    //   - This method gets the title of the book.
    // Parameters:
    // Returns: 
    //   - String representing the title of the book.
    // Exceptions:
    public String getTitle() {
        return this.title;
    }

    // Behavior:
    //   - This method gets all authors associated with the book.
    // Parameters:
    // Returns: 
    //   - List of authors associated with the book.
    // Exceptions:
    public List<String> getArtists() {
        return this.authors;
    }

    // Behavior:
    //   - This method adds a rating to the book.
    // Parameters:
    //   - score: the given book rating.
    // Returns:
    // Exceptions:
    public void addRating(int score) {
        this.ratings.add(score);
    }

    // Behavior:
    //   - This method gets the number of ratings the book has.
    // Parameters:
    // Returns: 
    //   - an int of the number of ratings the book has.
    // Exceptions:
    public int getNumRatings() {
        return this.ratings.size();
    }

    // Behavior:
    //   - This method gets the average rating of the book.
    // Parameters:
    // Returns: 
    //   - a double of the average rating of the book.
    //   - if no ratings exist, returns a 0.
    // Exceptions:
    public double getAverageRating() {
        int ratingSize = this.ratings.size();
        if( ratingSize < 1) {
            return 0.0;
        }
        
        double ratingsTotal = 0;
        for(int i = 0; i < ratingSize; i++) {
            ratingsTotal += this.ratings.get(i);
        }

        double averageRating = (ratingsTotal / ratingSize);
        return averageRating;
    }

    // Behavior:
    //   - This method gets a list of all the content in the book.
    // Parameters:
    // Returns: 
    //   - a list of all the content in the book.
    //   - if no content is found, an empty list is returned.
    // Exceptions:
    public List<String> getContent() {
        return this.contentList;      
    }

    // Behavior:
    //   - This method creates a readable string representation of the book. If the book has zero
    //     ratings, the string representation will not include rating info.
    // Parameters:
    // Returns: 
    //   - a string representing the book.
    // Exceptions:
    public String toString() {
        String representation = this.title + " by " + authors;
        
        if(ratings.size() < 1) {
            return representation;
        }
        representation += ": " + Math.round(this.getAverageRating() * 100.0) / 100.0 + " (" + 
                            this.getNumRatings() + " ratings)";
        return representation;
    }

    // Behavior:
    //   - This method creates and order between books based on their number of ratings. The more 
    //     ratings the book has, the higher it will be ordered.
    // Parameters:
    //   - other: different book that will be used to compare to this book. 
    // Returns: 
    //   - an int that determines the book's order prioritzing books with more ratings. Positive 
    //     means 'other' has more ratings than this book. Negative means 'other' has less ratings
    //     than this book. 0 means both books have the same number of ratings. 
    // Exceptions:
    @Override
    public int compareTo(Book other){
        return other.getNumRatings() - this.getNumRatings();
    }
}