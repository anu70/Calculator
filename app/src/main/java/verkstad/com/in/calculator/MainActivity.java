package verkstad.com.in.calculator;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;


public class MainActivity extends ActionBarActivity {
    String string = "";
    String string1="";
    TextView textView ;
    ArrayList<String> arrayList = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

        public void onClick (View v){
            textView= (TextView) findViewById(R.id.textView);

            Button button = (Button) v;
            string = (String) button.getText().toString();

            if(!string.contains("+") && !string.contains("-") && !string.contains("*") && !string.contains("/") && !string.contains("=") && !string.contains("C")) {
                string1 = string1 + string;

               if (arrayList.size() > 0) {
                    arrayList.remove(arrayList.size() - 1);
                }
                arrayList.add(string1);



            }
            else if(string.contains("=")){
                double cal=0;
                if(arrayList.get(1).contains("+")){cal = Double.parseDouble(arrayList.get(0))+Double.parseDouble(arrayList.get(2));}
                else if(arrayList.get(1).contains("-")){cal = Double.parseDouble(arrayList.get(0))-Double.parseDouble(arrayList.get(2));}
                else if(arrayList.get(1).contains("*")){cal = Double.parseDouble(arrayList.get(0))*Double.parseDouble(arrayList.get(2));}
                else{cal = Double.parseDouble(arrayList.get(0))/Double.parseDouble(arrayList.get(2));}
                arrayList.remove(2);
                arrayList.remove(1);
                arrayList.set(0,Double.toString(cal));

            }
            else if(string.contains("C")){
                arrayList.clear();
                string1="";
            }

            else  {
                arrayList.add(1,string);
                arrayList.add(2,string);
                double cal=0;
                if(arrayList.size()>4){
                    if(arrayList.get(1).contains("+")){cal = Double.parseDouble(arrayList.get(0))+Double.parseDouble(arrayList.get(2));}
                    else if(arrayList.get(1).contains("-")){cal = Double.parseDouble(arrayList.get(0))-Double.parseDouble(arrayList.get(2));}
                    else if(arrayList.get(1).contains("*")){cal = Double.parseDouble(arrayList.get(0))*Double.parseDouble(arrayList.get(2));}
                    else{cal = Double.parseDouble(arrayList.get(0))/Double.parseDouble(arrayList.get(2));}

                    arrayList.remove(0);
                    arrayList.remove(0);
                    arrayList.set(0,Double.toString(cal));
                }
                string1="";
            }


            textView.setText(arrayList.toString());

        }





    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
