package com.chanhee.vacation;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.provider.DocumentsContract;

import com.google.android.gms.common.SignInButton;

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

class XMLparser extends AsyncTask<String, Void, Document> {
    String Moviename;
    String ranking;

    public String getMoviename() {
        return Moviename;
    }

    public void setMoviename(String moviename) {
        Moviename = moviename;
    }

    public String getRanking() {
        return ranking;
    }

    public void setRanking(String ranking) {
        this.ranking = ranking;
    }

    Context mcontext;
    public XMLparser(Context context){
        this.mcontext=context;
    }

    @Override
    protected Document doInBackground(String... strings) {
        URL url;
        Document document=null;
        try {
            url=new URL(strings[0]);
            DocumentBuilderFactory documentBuilderFactory= new DocumentBuilderFactory() {
                @Override
                public DocumentBuilder newDocumentBuilder() throws ParserConfigurationException {
                    return null;
                }

                @Override
                public void setAttribute(String name, Object value) throws IllegalArgumentException {

                }

                @Override
                public Object getAttribute(String name) throws IllegalArgumentException {
                    return null;
                }

                @Override
                public void setFeature(String name, boolean value) throws ParserConfigurationException {

                }

                @Override
                public boolean getFeature(String name) throws ParserConfigurationException {
                    return false;
                }
            }.newInstance();
            DocumentBuilder documentBuilder=documentBuilderFactory.newDocumentBuilder();
            document=documentBuilder.parse(new InputSource(url.openStream()));
            document.getDocumentElement().normalize();


        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
        return document;
    }
    protected void onPreExecute(){
        super.onPreExecute();
    }

    @Override
    protected void onPostExecute(Document document) {
        super.onPostExecute(document);
        NodeList nodeList=document.getElementsByTagName("dailyBoxOfficeList");
        for(int i=0;i<nodeList.getLength();i++){
            Node node=nodeList.item(i);
            Element element= (Element) node;
            NodeList movie=element.getElementsByTagName("movieNm");
            Moviename=movie.item(i).getChildNodes().item(i).getNodeValue();
            NodeList rank=element.getElementsByTagName("rank");
            ranking=movie.item(i).getChildNodes().item(i).getNodeValue();
            if(ranking.length()!=0&&Moviename.length()!=0){
                Intent intent=new Intent(mcontext,SubActivity.class);
                mcontext.startActivity(intent);

            }

        }
    }

    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
    }
}
