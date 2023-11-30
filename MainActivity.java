package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    TextView workingsTV;
    TextView resultsTV;
    String workings ="";
    String formula = "";
    String temperature="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initTextViews();
    }
    private void checkForPowerOf(){
        ArrayList<Integer>indexOfPowers = new ArrayList<>();
        for(int =0;i<workings.length();i++){
            if(workings.charAt(i) == '^')
                indexOfPowers.add(i);
        }
        formula=workings;
        tempFormula=workings;
        for(Integer index: indexOfPowers){
            changeFormula(index);
        }
        formula=tempFormula;
    }
    private  void changeFormula(Integer index){
        String numberLeft = "";
        String numberRight= "";

        for(int i= index+1; i<workings.length(); i++){
            if(isNumeric(workings.charAt(i))){
                numberRight=numberRight+ workings.charAt(i);
            }
            else break;
        }
        for(int i=index-1;i>=0;i--){
            if(isNumeric(workings.charAt(i))){
                numberLeft=workings.charAt(i)+numberLeft;
            }
            else break;
        }
        String original= numberLeft+ "^" +numberRight;
        String changed= "Math.pow("+numberLeft+","+numberRight+")";
        tempFormula=tempFormula.replace(original,changed);
    }
    private boolean isNumeric(char c){
        if(c<='9'||c>='0'|| c == '.')
            return true;
        return false;
    }
    private void initTextViews(){
        workingsTV=(TextView) findViewById(R.id.workingsTextView);
        resultsTV=(TextView) findViewById(R.id.resultTextView);
    }
    private void setWorkings(String givenValue){
        workings=workings+ givenValue;
        workingsTV.setText(workings);
    }
}

public void equalsOnclick(view view){
    Double result= null;
    ScriptEngine engine = new ScriptEngineManager().getEngineByName("rhino");
    checkForPowerOf();
    try{
        result=(double)engine.eval(formula);
    }
    catch (ScriptException e){
        Toast.makeText(this,"invalid input", Toast.LENGTH_SHORT).show();

    }
    if(result!= null){
        resultsTV.setText(String.valueOf(result.doubleValue()));
    }
}

public void clearOnClick(view view){

}

boolean leftbracket = true;
 public void bracketsOnClick(view view){
     if(leftbracket==true)
     {
         setWorkings("(");
         leftbracket=false;
     }
     else{
         setWorkings(")");
         leftbracket= true;
     }
 }

 public void powerofOnClick(View view){
     setWorkingas("^");
 }

 public void divisionOnClick(View view){
     setWorkingas("/");
 }
 public void multiplicationOnClick(View view){
    setWorkingas("*");
} public void additionOnClick(View view){
    setWorkingas("+");
} public void substractionOnClick(View view){
    setWorkingas("-");
} public void oneOnClick(View view){
    setWorkingas("1");
} public void twoOnClick(View view){
    setWorkingas("2");
} public void threeOnClick(View view){
    setWorkingas("3");
} public void fourOnClick(View view){
    setWorkingas("4");
} public void fiveOnClick(View view){
    setWorkingas("5");
} public void sixOnClick(View view){
    setWorkingas("6");
} public void sevenOnClick(View view){
    setWorkingas("7");
} public void eightOnClick(View view){
    setWorkingas("8");
} public void nineOnClick(View view){
    setWorkingas("9");
} public void zeroOnClick(View view){
    setWorkingas("0");
}

