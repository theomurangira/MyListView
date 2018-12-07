package rw.ac.unilak.mylistview;

import android.renderscript.ScriptGroup;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class List extends AppCompatActivity {
 HashMap mymap;
 ListView lview;
 TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        lview=findViewById(R.id.list);
        textView=findViewById(R.id.tv);
        mymap=new HashMap();
        InputStream in = getResources().openRawResource(R.raw.dictionary);
        Scanner scanner =new Scanner(in);
        while(scanner.hasNext())
        {
            String line =scanner.nextLine();
            String[]entry =line.split("\t");
            mymap.put(entry[0],entry[1]);
        }
        ArrayList<String> array =new ArrayList<>();
        array.addAll(mymap.keySet());
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,array);
        lview.setAdapter(adapter);
        lview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String clicked =adapterView.getItemAtPosition(i).toString();
                textView.setText(mymap.get(clicked).toString());            }
        });

    }
}
