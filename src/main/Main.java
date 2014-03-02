package main;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;

public class Main {
    
    public static void main(String[] args) throws FileNotFoundException, ParseException, IOException {
        Data[] data = Parser.parse("phailin_tweets.csv");
        Exporter.exportAsJson(data);
        
        System.out.println();
        System.out.println(Exporter.exportTweetsOverTimeAscii(data,1,4));
        Exporter.exportTweetsOverTimeCsv(data,1,4);
    }
}