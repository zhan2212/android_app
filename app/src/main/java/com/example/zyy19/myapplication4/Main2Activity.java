package com.example.zyy19.myapplication4;

import android.content.Intent;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilderFactory;

public class Main2Activity extends AppCompatActivity {

    public String s = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        AssetManager manager = getAssets();
        InputStream is;//define an input stream

        try {
            is = manager.open("1hrLP_32Days.xml");//transform xml file into into input stream

            Document xmlDoc = getDocument(is);
            assert xmlDoc != null;
            xmlDoc.getDocumentElement().normalize();
            NodeList intervalBlocks = xmlDoc.getElementsByTagName("IntervalReading");
            //extract the content between two "IntervalReading" tags in xml file and create nodelist

            String elementName1 = "cost";
            ArrayList<Integer> costList = getElement(intervalBlocks, elementName1);
            //extract all the values between two "cost" tags to create an arraylist

            String elementName2 = "duration";
            ArrayList<Integer> durationList = getElement(intervalBlocks, elementName2);
            //extract all the values between two "duration" tags to create an arraylist

            String elementName3 = "start";
            ArrayList<Integer> startList = getElement(intervalBlocks, elementName3);
            //extract all the values between two "start" tags to create an arraylist

            String elementName4 = "value";
            ArrayList<Integer> valueList = getElement(intervalBlocks, elementName3);
            //extract all the values between two "cost" tags to create an arraylist


            int res;
            TextView txt1 = (TextView)findViewById(R.id.text1);
            for(int i=0;i<32;i++){
                res = 0;
                for(int j=0;j<24;j++){
                    res += costList.get(i*24+j);
                }
                    s += "Day " + i + " —————————— " + "$" + res / 100000 + " "+"\n";
            }
            assert txt1 != null;
            txt1.setText(s);
            //get the bill of electricity and demonstrate them onto a scroll down list


            int total = 0;
            for(int i=0;i<intervalBlocks.getLength();i++){
                total += costList.get(i);
            }
            String totalString = String.valueOf(total/100000);
            TextView txt4 = (TextView) findViewById(R.id.textview4);
            assert txt4 != null;
            txt4.setText("$"+totalString);
            //calculate the total bill and show the value on the top of the activity

        } catch (IOException e) {
            e.printStackTrace();
        }



/**
        TextView tx1 = (TextView)findViewById(R.id.text1);
        if(tx1!=null)
        tx1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(Main2Activity.this, Main3Activity.class);
                Main2Activity.this.startActivity(myIntent);
            }
        });
        //make text view clickable
*/


        ArrayAdapter adapter = ArrayAdapter.createFromResource(this, R.array.items, R.layout.spinneritem);
        Spinner s = (Spinner)findViewById(R.id.spinner);
        if(s!=null)
        s.setAdapter(adapter);
        //show the date on spinner

        if(s!=null)
        s.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(Main2Activity.this,parent.getSelectedItem().toString(),Toast.LENGTH_SHORT).show();
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
        //make the spinner selectable
    }

    private static ArrayList<Integer> getElement(NodeList intervalBlocks, String elementName) {
    //extract specific element in nodelist and put them into an arraylist

        ArrayList<Integer> res = new ArrayList<Integer>();
        try {
            for (int i = 0; i < intervalBlocks.getLength(); i++) {
                Node node = intervalBlocks.item(i);
                Element element = (Element) node;
                NodeList networkList = element.getElementsByTagName(elementName);
                Element networkElement = (Element) networkList.item(0);
                NodeList elementList = networkElement.getChildNodes();
                res.add(Integer.parseInt(((Node) elementList.item(0)).getNodeValue().trim()));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return res;
    }

    private static Document getDocument(InputStream is) {
    //extract information from input stream, which is from xml file

        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            factory.setIgnoringComments(false);
            factory.setIgnoringElementContentWhitespace(true);
            factory.setValidating(false);
            return factory.newDocumentBuilder().parse(is);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


}





