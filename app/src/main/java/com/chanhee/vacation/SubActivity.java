package com.chanhee.vacation;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.provider.DocumentsContract;
import android.provider.DocumentsContract.Document;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class SubActivity extends AppCompatActivity {
    private List<String> list;
    private ListView listView;
    private EditText editSearch;
    private SearchAdapter searchAdapter;
    private ArrayList<String> arrayList;
    private XMLparser xmLparser;

    @Override
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_sub);
        editSearch = (EditText) findViewById(R.id.edittxt);
        listView=(ListView)findViewById(R.id.listview);
        list=new ArrayList<String>();
        settingList();
        arrayList= new ArrayList<String>();
        arrayList.addAll(list);
        searchAdapter=new SearchAdapter(list,this);
        listView.setAdapter(searchAdapter);
        xmLparser.getMoviename();
        xmLparser.getRanking();
        editSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
            String text=editSearch.getText().toString();
            search(text);
            }

            private void search(String text) {
                list.clear();
                if(text.length()==0){
                    list.addAll(arrayList);

                }else
                {
                    for(int i=0;i<arrayList.size();i++){
                        if(arrayList.get(i).toLowerCase().contains(text));
                        {
                            list.add(arrayList.get(i));
                        }
                    }
                }
                searchAdapter.notifyDataSetChanged();
            }
        });
    }
    private void settingList() {


    }
}

