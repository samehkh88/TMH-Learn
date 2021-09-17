package data;

import com.opencsv.CSVReader;

import java.io.FileReader;
import java.util.Iterator;
import java.util.List;

public class ReadCSVFile {
    public static void main(String[] args) throws Exception {

        CSVReader reader = new CSVReader(new FileReader(System.getProperty("user.dir")+"\\DataFiles\\userdata1.csv"));

        List<String[]> list=reader.readAll();
        System.out.println("Total rows which we have is "+list.size());

        // create Iterator reference
        Iterator<String[]> iterator= list.iterator();

        // Iterate all values
        while(iterator.hasNext()){

            String[] str=iterator.next();

            System.out.print(" Values are ");

            for(int i=0;i<str.length;i++)
            {

                System.out.print(" "+str[i]);

            }
            System.out.println("   ");


        }

    }

}
