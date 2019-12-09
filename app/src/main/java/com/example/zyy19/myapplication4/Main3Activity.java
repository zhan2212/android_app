package com.example.zyy19.myapplication4;

import android.content.Intent;
import android.content.res.AssetManager;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;
import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;


import org.xml.sax.InputSource;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Scanner;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;



public class Main3Activity extends AppCompatActivity {

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    public String selectItem;
    public NodeList intervalBlocks;
    public ArrayList<Integer> costList;
    public ArrayList<Integer> durationList;
    public ArrayList<Integer> startList;
    public ArrayList<Integer> valueList;
    public boolean switch1 = true;
    public int date;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        getList("1hrLP_32Days.xml");

        Button b = (Button) findViewById(R.id.suggestionbutton);
        if (b != null)
            b.setOnClickListener(new View.OnClickListener() {
                                     public void onClick(View v) {
                                         startActivity(new Intent(Main3Activity.this, Pop.class));
                                     }
                                 }
            );
        // Make a window pop up when clicking "suggestion" button

        ArrayAdapter adapter = ArrayAdapter.createFromResource(this, R.array.items2, R.layout.spinneritem);// create an adapter for spinnner
        Spinner s = (Spinner) findViewById(R.id.spinner2);
        if (s != null)
            s.setAdapter(adapter);

        if (s != null)
            s.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    Toast.makeText(Main3Activity.this, parent.getSelectedItem().toString(), Toast.LENGTH_SHORT).show();

                    selectItem = parent.getSelectedItem().toString();
                    itemchart(selectItem);//plot the chart in terms of the date chosen

                    TextView textEle = (TextView) findViewById(R.id.textEle);
                    assert textEle != null;
                    textEle.setText(R.string.Ele);//set the title as "Electricity Usage"
                    switch1 = true;

                }
                @Override
                public void onNothingSelected(AdapterView<?> parent) {
                }
            });//the first spinner

        ArrayAdapter adapter2 = ArrayAdapter.createFromResource(this, R.array.items3, R.layout.spinneritem);
        Spinner s2 = (Spinner) findViewById(R.id.spinner3);
        s2.setAdapter(adapter2);
        s2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                String selectItem2 = parent.getSelectedItem().toString();
                doublechart(selectItem2);//show the charts of the first and second date at the same time

             }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });// the second spinner



        Button compButton = (Button) findViewById(R.id.compButton);

        if (compButton != null)
            compButton.setOnClickListener(
                    new Button.OnClickListener() {

                        public void onClick(View v) {
                            TextView textEle = (TextView) findViewById(R.id.textEle);

                            Spinner spinner = (Spinner)findViewById(R.id.spinner2);
                            String text = spinner.getSelectedItem().toString();

                            if(switch1) {
                                comparechart(text);
                                if (textEle != null)
                                    textEle.setText(R.string.compText);
                                switch1 = false;
                            }
                            else{
                                itemchart(text);
                                if (textEle != null)
                                    textEle.setText(R.string.Ele);
                                switch1 = true;
                            }
                        }
                    }
            );//change the title when click "compare" button

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Main3 Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app URL is correct.
                Uri.parse("android-app://com.example.zyy19.myapplication4/http/host/path")
        );
        AppIndex.AppIndexApi.start(client, viewAction);
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Main3 Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app URL is correct.
                Uri.parse("android-app://com.example.zyy19.myapplication4/http/host/path")
        );
        AppIndex.AppIndexApi.end(client, viewAction);
        client.disconnect();
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
            factory.setValidating(false);//true
            return factory.newDocumentBuilder().parse(is);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private void itemchart(String item){
        //create the chart of the date selected by the first spinner

        LineChart lineChart = (LineChart) findViewById(R.id.billchart);
        ArrayList<Entry> entries = new ArrayList<>();
        //ArrayList<Entry> entries1 = new ArrayList<>();//
        ArrayList<String> labels = new ArrayList<>();

        LineChart lineChart2 = (LineChart) findViewById(R.id.usagechart);
        ArrayList<Entry> entries2 = new ArrayList<>();
        ArrayList<String> labels2 = new ArrayList<>();


        if(item.equals("March")) {
            int res;
            int res2;
            for (int i = 0; i < 32; i++) {
                res = 0;
                res2 = 0;
                for (int j = 0; j < 24; j++) {
                    res += costList.get(i * 24 + j);
                    res2 += valueList.get(i * 24 + j);
                }
                entries.add(new Entry((float) (res / 100000.00), i));
                //entries1.add(new Entry((float) (res / 200000.00), i));/////
                labels.add("Day" + (i + 1));//Bill
                entries2.add(new Entry((float) (res2 / 1000.00), i));
                labels2.add("Day" + (i + 1));//Usage
            }
        }
        else {
            Scanner in = new Scanner(item).useDelimiter("[^0-9]+");
            date = in.nextInt();

            for (int i = (date-1)*24; i < (date*24); i++) {
                entries.add(new Entry((float) (costList.get(i) / 100000.00), i-24*(date-1)));
                //entries1.add(new Entry((float) (costList.get(i) / 100000.00), i-24*(intDay-1)));/////
                labels.add("Hour" + (i-24*(date-1) + 1));

                entries2.add(new Entry((float) (valueList.get(i)  / 1000.00), i-24*(date-1)));
                labels2.add("Hour" + (i-24*(date-1) + 1));
            }
        }
        LineDataSet dataset = new LineDataSet(entries, "Bill (dollar)");
        //LineDataSet dataset1 = new LineDataSet(entries1, "Bill (dollar)***");/////
        //dataset1.setColor(Color.RED);/////
        //dataset1.setCircleColor(Color.RED);/////
        dataset.setDrawCubic(true);

        ArrayList<ILineDataSet> dataSets = new ArrayList<ILineDataSet>();
        dataSets.add(dataset);
        //dataSets.add(dataset1);


        LineData data = new LineData(labels, dataSets);
        lineChart.setData(data);
        lineChart.invalidate();
        lineChart.setDescription("Electricity Bill");

        LineDataSet dataset2 = new LineDataSet(entries2, "Usage (kilowatt-hours)");
        LineData data2 = new LineData(labels2, dataset2);
        lineChart2.setData(data2);
        lineChart2.setDescription("Electricity Usage");
        lineChart2.invalidate();
    }
    private void comparechart(String item){
        LineChart lineChart = (LineChart) findViewById(R.id.billchart);
        ArrayList<Entry> entries = new ArrayList<>();
        ArrayList<Entry> entries1 = new ArrayList<>();//
        ArrayList<String> labels = new ArrayList<>();

        LineChart linechart2 = (LineChart) findViewById(R.id.usagechart);
        ArrayList<Entry> entries2 = new ArrayList<>();
        ArrayList<Entry> entries3 = new ArrayList<>();//
        ArrayList<String> labels1 = new ArrayList<>();


        if(item.equals("March")) {
            int res;
            int res2;
            for (int i = 0; i < 32; i++) {
                res = 0;
                res2 = 0;
                for (int j = 0; j < 24; j++) {
                    res += costList.get(i * 24 + j);
                    res2 += valueList.get(i * 24 + j);
                }
                entries.add(new Entry((float) (res / 100000.00), i));
                entries1.add(new Entry((float) (res / 200000.00), i));/////
                labels.add("Day" + (i + 1));//Bill

                entries2.add(new Entry((float) (res2 / 1000.00), i));
                entries3.add(new Entry((float) (res2 / 2000.00), i));/////
                labels1.add("Day" + (i + 1));//Usage
            }
        }
        else {
            Scanner in = new Scanner(item).useDelimiter("[^0-9]+");
            int intDay = in.nextInt();

            for (int i = (intDay-1)*24; i < (intDay*24); i++) {
                entries.add(new Entry((float) (costList.get(i) / 100000.00), i-24*(intDay-1)));
                entries1.add(new Entry((float) (costList.get(i) / 200000.00), i-24*(intDay-1)));/////
                labels.add("Hour" + (i-24*(intDay-1) + 1));

                entries2.add(new Entry((float) (valueList.get(i)  / 1000.00), i-24*(intDay-1)));
                entries3.add(new Entry((float) (valueList.get(i)  / 2000.00), i-24*(intDay-1)));/////
                labels1.add("Hour" + (i-24*(intDay-1) + 1));
            }
        }
        LineDataSet dataset = new LineDataSet(entries, "Bill (dollar)");
        LineDataSet dataset1 = new LineDataSet(entries1, "Bill (dollar)***");/////
        dataset1.setColor(Color.RED);/////
        dataset1.setCircleColor(Color.RED);/////
        dataset.setDrawCubic(true);
        dataset1.setDrawCubic(true);


        ArrayList<ILineDataSet> dataSets = new ArrayList<ILineDataSet>();
        dataSets.add(dataset);
        dataSets.add(dataset1);/////

        LineData data = new LineData(labels, dataSets);
        lineChart.setData(data);
        lineChart.invalidate();
        lineChart.setDescription("Electricity Bill");

        LineDataSet dataset2 = new LineDataSet(entries2, "Usage (kilowatt-hours)");
        LineDataSet dataset3 = new LineDataSet(entries3, "Usage (kilowatt-hours)***");/////
        dataset3.setColor(Color.RED);/////
        dataset3.setCircleColor(Color.RED);/////
        dataset2.setDrawCubic(true);
        dataset3.setDrawCubic(true);


        ArrayList<ILineDataSet> dataSets1 = new ArrayList<ILineDataSet>();
        dataSets1.add(dataset2);
        dataSets1.add(dataset3);/////

        LineData data1 = new LineData(labels1, dataSets1);
        linechart2.setData(data1);
        linechart2.invalidate();
        linechart2.setDescription("Electricity Usage");

    }


    private void doublechart(String selectItem2){
        //creat the charts of two dates, the first is selected already by the first spinner and the
        // second is selected right before by the second spinner

        if(!selectItem.equals("March")){
            LineChart lineChart = (LineChart) findViewById(R.id.billchart);
            ArrayList<Entry> entries = new ArrayList<>();
            ArrayList<Entry> entries1 = new ArrayList<>();//
            ArrayList<String> labels = new ArrayList<>();

            LineChart linechart2 = (LineChart) findViewById(R.id.usagechart);
            ArrayList<Entry> entries2 = new ArrayList<>();
            ArrayList<Entry> entries3 = new ArrayList<>();
            ArrayList<String> labels2 = new ArrayList<>();

            Scanner in = new Scanner(selectItem).useDelimiter("[^0-9]+");
            int intDay = in.nextInt();

            for (int i = (intDay - 1) * 24; i < (intDay * 24); i++) {
                entries.add(new Entry((float) (costList.get(i) / 100000.00), i - 24 * (intDay - 1)));
                labels.add("Hour" + (i - 24 * (intDay - 1) + 1));

                entries2.add(new Entry((float) (valueList.get(i) / 1000.00), i - 24 * (intDay - 1)));
                labels2.add("Hour" + (i - 24 * (intDay - 1) + 1));
            }


            if(selectItem2.equals("Average")){
                for(int j = 0;j<24;j++) {
                    float total1 = 0;
                    float total2 = 0;
                    for (int i = 0; i < intDay+1; i++) {
                        total1 += (float)(costList.get(j+i*24)/ 100000.00);
                        total2 += (float)(valueList.get(j+i*24)/ 1000.00);
                    }
                    entries1.add(new Entry((float) (total1/(intDay+1)),j));
                    entries3.add(new Entry((float) (total2/(intDay+1)),j));

                }
            }
            else if(!selectItem2.equals("March")){
                Scanner in2 = new Scanner(selectItem2).useDelimiter("[^0-9]+");
                int intDay2 = in2.nextInt();
                for (int i = (intDay2 - 1) * 24; i < (intDay2 * 24); i++) {
                    entries1.add(new Entry((float) (costList.get(i) / 100000.00), i - 24 * (intDay2 - 1)));

                    entries3.add(new Entry((float) (valueList.get(i) / 1000.00), i - 24 * (intDay2 - 1)));
                }

            }
            LineDataSet dataset = new LineDataSet(entries, "Bill (dollar)");
            LineDataSet dataset1 = new LineDataSet(entries1, "Bill (dollar)***");/////
            dataset1.setColor(Color.RED);/////
            dataset1.setCircleColor(Color.RED);/////
            dataset.setDrawCubic(true);
            dataset1.setDrawCubic(true);


            ArrayList<ILineDataSet> dataSets = new ArrayList<ILineDataSet>();
            dataSets.add(dataset);
            dataSets.add(dataset1);/////


            LineData data = new LineData(labels, dataSets);
            lineChart.setData(data);
            lineChart.invalidate();
            lineChart.setDescription("Electricity Bill");

            LineDataSet dataset2 = new LineDataSet(entries2, "Usage (kilowatt-hours)");
            LineDataSet dataset3 = new LineDataSet(entries3, "Usage (kilowatt-hours)***");/////
            dataset3.setColor(Color.RED);/////
            dataset3.setCircleColor(Color.RED);/////
            dataset2.setDrawCubic(true);
            dataset3.setDrawCubic(true);

            ArrayList<ILineDataSet> dataSets1 = new ArrayList<ILineDataSet>();
            dataSets1.add(dataset2);
            dataSets1.add(dataset3);/////


            LineData data1 = new LineData(labels2, dataSets1);
            linechart2.setData(data1);
            linechart2.invalidate();
            linechart2.setDescription("Electricity Usage");

            TextView textEle = (TextView) findViewById(R.id.textEle);
            textEle.setText(R.string.Ele);
            switch1 = true;

        }
    }

    public void getList(String filename){
        //extract data by tag names in xml file and put them into corresponding arraylist

        AssetManager manager = getAssets();
        InputStream is;
        try {
            is = manager.open(filename);
            Document xmlDoc = getDocument(is);
            assert xmlDoc != null;
            xmlDoc.getDocumentElement().normalize();
            intervalBlocks = xmlDoc.getElementsByTagName("IntervalReading");
            String elementName1 = "cost";
            costList = getElement(intervalBlocks, elementName1);
            String elementName2 = "duration";
            durationList = getElement(intervalBlocks, elementName2);
            String elementName3 = "start";
            startList = getElement(intervalBlocks, elementName3);
            String elementName4 = "value";
            valueList = getElement(intervalBlocks, elementName4);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}




