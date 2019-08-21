package com.chanhee.vacation;

import android.os.Bundle;
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
        list.add("1.분노의 질주: 홉스&쇼");
        list.add("2.엑시트");
        list.add("3.봉오동 전투");
        list.add("4. 마이펫의 이중생활 2");
        list.add("5.안녕, 티라노: 영원히, 함께");
        list.add("6.암전");
        list.add("7.원더랜드");
        list.add("8.레드슈즈");
        list.add("9.알라딘");
        list.add("10. 김복동");

    }
}

