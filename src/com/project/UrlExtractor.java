package com.project;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Pattern;

public class UrlExtractor {
    // Question 2.1:  matchServer method
    private static boolean matchServer(String url, String str){

        boolean status = false;
        if(url != null && str != null){
            String[] urlSplit = url.split("://");
            String scheme = urlSplit[0];
            //System.out.println(scheme);
            urlSplit= urlSplit[1].split("/");
            String server= urlSplit[0];
            //System.out.println("server:"+ server);
            //int pathIndex = url.length() -(scheme.length()+3+server.length());
            //String path = url.substring(pathIndex+1, url.length());
            status = server.toLowerCase().contains(str.toLowerCase());
        }

        return status;
    }
    // scanAndPrint Question 1
    public static void scanAndPrint(Scanner in){

        String page = in.useDelimiter(Pattern.compile("\\A")).next();
        //System.out.println(page);
        int beg = -1;
        System.out.println(page.length());
        for (int i = 0; i < page.length()-1; i++) {
            if(page.length() - i >= 8){
                String tag = page.substring(i, i + 8);

                if(tag.equalsIgnoreCase("<a href=")){ // ignore case of tags
                    beg=i;

                }
            }
            String closetag = page.substring(i , i + 1);

            if(closetag.equals(">") && beg >= 0){

                String temp = page.substring(beg+9, i);
                String[] split = temp.split(" ");
                String Url = split[0].substring(0,split[0].length()-1);
                String parsedUrl =MyURL.parseURL(Url);
                if(!parsedUrl.equals(null) ){ /* checking returned value*/
                    System.out.println(parsedUrl);
                }
                else{

                }
                beg=-1;
                //System.out.println("i am inside closing loop");
            }
        }
        //System.out.println("out of loop");
    }
    //Question 2.2: scanAndPrint
    public static void scanAndPrint(Scanner in, String str){
        String page = in.useDelimiter(Pattern.compile("\\Z")).next();
        //System.out.println(page);
        int beg = -1;
        //System.out.println(page.length());
        //Map<String , Integer>URLList = new HashMap<String, Integer>();
        int count =0;
        for (int i = 0; i < page.length(); i++) {
            if(page.length() - i >= 8){
                String tag = page.substring(i, i + 8);
                if(tag.equalsIgnoreCase("<a href=")){ // ignore case of tags
                    beg=i;
                }
            }
            String closetag = page.substring(i , i + 1);
            if(closetag.equals(">") && beg >= 0){
                String temp = page.substring(beg+9, i);
                String[] split = temp.split(" ");
                String Url = split[0].substring(0,split[0].length()-1);
                String parsedUrl =MyURL.parseURL(Url);
                if(!parsedUrl.equals(null) && matchServer(parsedUrl,str) ){ /* checking returned value*/
                    //URLList.put(parsedUrl, count);
                    //count++;
                    System.out.println(parsedUrl);
                }
                else{

                }
                beg=-1;

            }

        }


    }

    public static void main(String[] args){
        //test case1: data is provided in file
        try{
            File fileTest = new File("/Users/ujwaljoshi/Downloads/PageRankProject/src/com/project/three-page.txt");
            Scanner in =new Scanner(fileTest,"UTF-8");
            scanAndPrint(in,"guardian");
        }
        catch(Exception e){
            System.out.println(e);
        }
        //test case2: data is provided in standard input
		/*try{
		Scanner stdin = new Scanner (System.in,"UTF-8");
	       scanAndPrint(stdin);
		}
		catch(Exception e){
			System.out.print(e);
		}*/
        // given 5 examples
        System.out.println(matchServer("http://www.google.com","Google.com"));
        System.out.println(matchServer("http://www.theguardian.com", "GUARDIAN"));
        System.out.println(	matchServer("http://www.Guardian.co.uk/global-development","guardian"));
        System.out.println(	matchServer(null, "guardian.co.uk")) ;
        System.out.println(	matchServer("http://theguardian.com", "theguardian.com"));


    }
}
