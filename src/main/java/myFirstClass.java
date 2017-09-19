import java.io.IOException;
import java.net.URL;
import java.util.Scanner;
public class myFirstClass {
    public static void main(String[] args) {
        String website = urlToString("http://erdani.com/tdpl/hamlet.txt");
        String searchWord = "Denmark";
        int numberOfOccurrences = -1;
        int searchPosition = 0;
        while (searchPosition != -1) {
            System.out.println(website.indexOf(searchWord, searchPosition));
            numberOfOccurrences = numberOfOccurrences + 1;
            searchPosition = website.indexOf(searchWord, searchPosition) + 1;
            if (searchPosition == 0) {
                break;
            }
        }
        System.out.println(numberOfOccurrences);
    }
    /**
     * Retrieve contents from a URL and return them as a string.
     *
     * @param url url to retrieve contents from
     * @return the contents from the url as a string, or an empty string on error
     */
    public static String urlToString(final String url) {
        Scanner urlScanner;
        try {
            urlScanner = new Scanner(new URL(url).openStream(), "UTF-8");
        } catch (IOException e) {
            return "";
        }
        String contents = urlScanner.useDelimiter("\\A").next();
        urlScanner.close();
        return contents;
    }
}
