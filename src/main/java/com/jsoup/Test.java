package com.jsoup;

import org.json.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.*;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.net.URLConnection;

public class Test {
    public static void main(String[] args) throws IOException {
        InputStreamReader reader = null;

        BufferedReader in = null;

        try {

            URL url = new URL("https://scholar.google.com.hk/citations?hl=zh-CN&user=8VY7ZDcAAAAJ");
//            URL url = new URL("https://www.baidu.com/");
            URLConnection connection = url.openConnection();

            connection.setConnectTimeout(100000);

            reader = new InputStreamReader(connection.getInputStream(), "UTF-8");

            in = new BufferedReader(reader);

            String line = null; // 每行内容

            StringBuffer content = new StringBuffer();

            while ((line = in.readLine()) != null) {

                content.append(line);

            }
            System.out.println(content);
        }  catch (Exception e) {

            System.out.println("http error!!!");

        } finally {

            if (in != null) {

                try {

                    in.close();

                } catch (IOException e) {

                    System.out.println("cannot close!!!");

                }

            }

            if (reader != null) {

                try {

                    reader.close();

                } catch (IOException e) {

                    System.out.println("cannot close!!!");

                }

            }

        }
        /*String url = "https://scholar.google.com.hk/citations?hl=zh-CN&user=8VY7ZDcAAAAJ";
        Document document = Jsoup.parse(new URL(url), 10000);
        System.out.println(document);*/

        /*imgs.remove(0);
        imgs.remove(0);
        int id = 0;
        for (Element img : imgs) {
            String src = img.attr("data-src");
            URL target = new URL(src);
            URLConnection urlConnection = target.openConnection();
            InputStream inputStream = urlConnection.getInputStream();
            id++;
            OutputStream outputStream= new FileOutputStream("D:\\java\\images\\"+id+".jpg");
            int temp = 0;
            while((temp=inputStream.read())!=-1)
            {
                outputStream.write(temp);
            }
            System.out.println(id + ".jpg 下载完毕");
        }*/
    }
}
