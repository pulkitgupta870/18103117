package com.company;


import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.jsoup.HttpStatusException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.jsoup.nodes.Document;



import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.ConnectException;
import java.net.MalformedURLException;
import java.util.*;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Main {
    public static final int MAX_DEPTH = 6;
    public static HashSet<String> abc = new HashSet<>();
    public static HashSet<String> teachers = new HashSet<>();
    public static Queue<String > pending = new LinkedList<>();
    public static String[] notess = { "xlsx", "ppt", "events", "#","jpg", "PDF", "doc", "DOC"};
    public static String[] keys = {"faculty/aero", "faculty/cse", "faculty/ee", "faculty/ece", "faculty/me", "faculty/metta", "faculty/applied-sciences", "faculty/civil", "faculty/pie"};
    public static Set<Object[]> tags = new HashSet<>();
    public static Set<Object[]> fac = new HashSet<>();
    public static void bfs(String seedUrl) throws IOException {
        pending.add(seedUrl);
        abc.add(seedUrl);
        int depth = 0;
        while(depth<MAX_DEPTH && !pending.isEmpty()){
            int size=pending.size();
            depth++;
            while(size!=0){
                size--;
                String url = pending.poll();
                assert url != null;
                boolean flag1 = Arrays.stream(keys).anyMatch(url::contains);
                fun2(url);
                try{
                    Document document = Jsoup.connect(url).get();
                    Elements abcOnPage = document.select("a[href]");
                    for(Element page: abcOnPage){
                        String crawled=page.attr("abs:href");
                        boolean flag= Arrays.stream(notess).anyMatch(crawled::contains);
                        if(flag1 && !abc.contains(crawled) && !flag && crawled.startsWith(seedUrl)){
                            teachers.add(crawled);
                        }
                        if(!abc.contains(crawled) && !flag && crawled.startsWith(seedUrl)){
                            System.out.println(">> Depth: " + depth + " [" + crawled + "]");
                            abc.add(crawled);
                            pending.add(crawled);
                        }

                    }
                }  catch (Exception e){
                    System.out.println("Invalid URL.");
                }

            }
        }
    }

    

    public static void fun(){
            XSSFWorkbook workbook = new XSSFWorkbook();
            XSSFSheet ss1 = workbook.createSheet(" Tag Info ");
            Row r = ss1.createRow(ss1.getLastRowNum()+1);
            int c = 0;
            
            for(String ignored : infoo){
                Cell cel =r.createCell(c++);
                cel.setCellValue("");
            }
            for(Object[] objArr: tags){
                Row row = ss1.createRow(ss1.getLastRowNum()+1);
                int cellid = 0;
                for (Object obj : objArr){
                    Cell cell = row.createCell(cellid++);
                    cell.setCellValue((String)obj);
                }
            }
            try{
                FileOutputStream out = new FileOutputStream(new File("F:\\Assignment.xlsx"));
                workbook.write(out);
                out.close();
            } 
    }
    public static void fun2(String url) throws IOException {
        try {
            Document doc = Jsoup.connect(url).get();
            Elements abc = doc.select("*");
            for (Element link : abc) {
                if (link.text().equals("") || link.tagName().equals(""))
                    continue;
                tags.add(new Object[]{
                        link.tagName(), link.text()});
            }
        } catch (HttpStatusException e) {
            System.out.println("Connection timed out...!!");
        } catch(Exception e){
            System.out.println("Invalid URL...!!");
        }
    }

    public static void fun1() throws IOException {
        XSSFWorkbook wb1 = new XSSFWorkbook();
        XSSFSheet ss1 = wb1.createSheet(" Faculty Info ");
        Row r = ss1.createRow(ss1.getLastRowNum()+1);
        int c = 0;
        String[] infoo = {"Name", "Department", "Designation", "Qualification",
                "Research Interests", "Address", "Email", "Phone Number"};
        for(String head: infoo){
            Cell cel =r.createCell(c++);
            cel.setCellValue(head);
        }
        r = ss1.createRow(ss1.getLastRowNum()+1);
        c = 0;
        for(String ignored : infoo){
            Cell cel =r.createCell(c++);
            cel.setCellValue("");
        }
        for(Object[] objArr: fac){
            Row row = ss1.createRow(ss1.getLastRowNum()+1);
            int cellid = 0;
            for (Object obj : objArr){
                Cell cell = row.createCell(cellid++);
                cell.setCellValue((String)obj);
            }
        }
        try{
            FileOutputStream out = new FileOutputStream(new File("F:\\Assignment.xlsx"));
            wb1.write(out);
            out.close();
        } catch (IOException e){
            System.out.println("File can't be accessed...!!");
        } catch (Exception e){
            System.out.println("Invalid access...!!");
        }
    }

    public static void main(String[] args) throws IOException {
        String seedUrl = "https://pec.ac.in";
        bfs(seedUrl);
        fun();
        System.out.println("The tags info had been filled successfully.");
        for(String url: teachers){
            Document doc = Jsoup.connect(url).get();
            Element table = doc.selectFirst("tbody");
            Element heading = doc.select("div.panel-heading").first();
            if(table!=null){
                Elements rows = table.select("tr");
                Object[] objectArr = new Object[rows.size()+1];
                objectArr[0] = heading.text();
                int i=1;
                for (Element row : rows) {
                    Elements cols = row.select("td");
                    objectArr[i++] = cols.get(1).text();
                }
                fac.add(objectArr);
            }
        }
        fun1();
        System.out.println("The Faculty info had been filled successfully.");
    }
}
