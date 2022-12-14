package siso.project.etc;

import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class CsvParser {

    private String filePath;
    private BufferedReader bufferedReader;
    private List<String[]> readCSV;

    private int index;

    //This constructor is for read CSV File
    public CsvParser(String filePath) throws IOException {
        this.filePath = filePath;
        bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(this.filePath), "UTF-8"));
        readCSV = new ArrayList<>();

        makeCountyOfficeList(bufferedReader);
        this.index = 0;
    }

    public void makeCountyOfficeList(BufferedReader bufferedReader) throws IOException {
        String line = null;
        while((line = bufferedReader.readLine())!=null) {
            String[] lineContents = line.split(",(?=([^\"]*\"[^\"]*\")*[^\"]*$)",-1);

            readCSV.add(lineContents);
        }
    }

    //한 행을 읽음
    public String[] nextRead(){
        if(readCSV.size() == index){
            return null;
        }
        return readCSV.get(index++);
    }
}
