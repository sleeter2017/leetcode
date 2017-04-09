import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CSV_Parser {

    private static final char DEFAULT_FIELD_SEPARATOR = ',';
    private static final char DEFAULT_QUOTE = '"';


    public static List<String> parseCSVLine(String cvsLine) {
        return parseCSVLine(cvsLine, DEFAULT_FIELD_SEPARATOR, DEFAULT_QUOTE);
    }

    public static List<String> parseCSVLine(String cvsLine, char separators) {
        return parseCSVLine(cvsLine, separators, DEFAULT_QUOTE);
    }

    public static List<String> parseCSVLine(String cvsLine, char fieldSeparator, char customQuote) {

        List<String> result = new ArrayList<>();

        //if empty, return!
        if (cvsLine == null && cvsLine.isEmpty()) {
            return result;
        }

        if (customQuote == ' ') {
            customQuote = DEFAULT_QUOTE;
        }

        if (fieldSeparator == ' ') {
            fieldSeparator = DEFAULT_FIELD_SEPARATOR;
        }

        StringBuffer curVal = new StringBuffer();
        boolean inQuotes = false;
        boolean beginCollectChar = false;
        boolean doubleQuotesInColumn = false;

        char[] chars = cvsLine.toCharArray();

        for (char ch : chars) {

            if (inQuotes) {
                beginCollectChar = true;
                if (ch == customQuote) {
                    inQuotes = false;
                    doubleQuotesInColumn = false;
                } else {

                    //Fixed : allow "" in custom quote enclosed
                    if (ch == '\"') {
                        if (!doubleQuotesInColumn) {
                            curVal.append(ch);
                            doubleQuotesInColumn = true;
                        }
                    } else {
                        curVal.append(ch); // INTENTIONALLY DROP THIS :)))
                    }

                }
            } else {
                if (ch == customQuote) {

                    inQuotes = true;

                    //Fixed : allow "" in empty quote enclosed
                    if (chars[0] != '"' && customQuote == '\"') {
                        curVal.append('"');
                    }

                    //double quotes in column will hit this!
                    if (beginCollectChar) {
                        curVal.append('"');
                    }

                } else if (ch == fieldSeparator) {

                    result.add(curVal.toString());

                    curVal = new StringBuffer();
                    beginCollectChar = false;

                } else if (ch == '\r') {
                    //ignore LF characters
                    continue;
                } else if (ch == '\n') {
                    //the end, break!
                    break;
                } else {
                    curVal.append(ch);
                }
            }

        }

        result.add(curVal.toString());

        return result;
    }




    public static void main(String[] args) throws Exception {

        String csvFile = "/Users/leetcode/temp.csv";

        Scanner scanner = new Scanner(new File(csvFile));
        while (scanner.hasNext()) {
            List<String> line = parseCSVLine(scanner.nextLine());

            for(String data : line)
                System.out.println(data);
            System.out.println(line.size());
        }
        scanner.close();

    }

}
