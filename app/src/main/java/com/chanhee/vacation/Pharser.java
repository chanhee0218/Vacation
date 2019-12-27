package com.chanhee.vacation;

import android.content.Context;
import android.os.AsyncTask;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

public class Pharser extends AsyncTask<String, Void, Document> {
    private static String movieName;
    private static String ranking;
    String link="http://www.kobis.or.kr/kobisopenapi/webservice/rest/boxoffice/searchDailyBoxOfficeList.xml?key=430156241533f1d058c603178cc3ca0e&targetDt=20191226";
    Context mcontext;
    public Pharser(Context context){
        this.mcontext=context;

    }

    @Override
    protected Document doInBackground(String... strings) {
        URL url;
        Document document=null;
        try {
            url=new URL(link);
            DocumentBuilderFactory documentBuilderFactory=DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder=documentBuilderFactory.newDocumentBuilder();
            document=documentBuilder.parse(new InputSource(url.openStream()));
            document.getDocumentElement().normalize();

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return document;
    }
    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected void onPostExecute(Document document) {
        super.onPostExecute(document);
        NodeList nodeList=document.getElementsByTagName("dailyBoxOffice");
        for(int i=0;i<nodeList.getLength();i++){
            Node node=nodeList.item(i);
            Element element= (Element) node;
            movieName=element.getChildNodes().item(11).getNodeValue();
            NodeList rankList=element.getElementsByTagName("rank");
            ranking=rankList.item(1).getChildNodes().item(1).getNodeValue();
            System.out.println("ㅇㅇ : " +movieName + ranking);

        }
    }

    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
    }

}
