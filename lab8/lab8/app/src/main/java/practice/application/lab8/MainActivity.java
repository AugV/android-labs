package practice.application.lab8;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

public class MainActivity extends AppCompatActivity {

    LineGraphSeries<DataPoint> series;
    EditText input;
    Button print;
    GraphView graph;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        graph = (GraphView) findViewById(R.id.graph1);
        input = (EditText) findViewById(R.id.editText2);
        print = (Button) findViewById(R.id.button);

        print.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                printGraph(Double.parseDouble(input.getText().toString()));
            }
        });


    }

    private void printGraph(double value) {

        series = new LineGraphSeries<DataPoint>();
        double x = value;
        double y;

        for(int i =0; i<200; i++) {
            x = x + 0.1;
            y = Math.sin(x);
            series.appendData(new DataPoint(x, y), true, 100);
        }
        graph.addSeries(series);
    }


}
