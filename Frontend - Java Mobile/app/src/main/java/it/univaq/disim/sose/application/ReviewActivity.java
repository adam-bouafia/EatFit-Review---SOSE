package it.univaq.disim.sose.application;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.Nullable;

import org.ksoap2.HeaderProperty;
import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;

import java.util.ArrayList;
import java.util.List;

public class ReviewActivity extends Activity {
    private String TAG ="SOAPClient", user_id,food_id,food_title,result,userToken;
    private TextView reviewFoodTitle,reviewTextTitle,reviewTextComment;
    private EditText editTextActor, editTextDialogue, editTextCostume,editTextDirector ,editTextGlobalScore;
    private Button addReview;
    private ImageButton home;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.add_review);
        Intent intent = getIntent();
        userToken = intent.getStringExtra("userToken");
        user_id = intent.getStringExtra("userID");


        if(userToken == null || user_id == null){
            Intent intentBlock = new Intent(ReviewActivity.this,MainActivity.class);
            startActivity(intentBlock);
        }
        food_id = intent.getStringExtra("food_id");
        food_title = intent.getStringExtra("food_title");

        reviewFoodTitle = findViewById(R.id.reviewFoodTitle);
        reviewFoodTitle.setText(food_title);
        reviewTextTitle = findViewById(R.id.reviewTitleText);
        reviewTextComment = findViewById(R.id.reviewTitleComment);
        editTextActor = findViewById(R.id.TasteRating);
        editTextDialogue = findViewById(R.id.DialogueRating);
        editTextCostume = findViewById(R.id.CostumeRating);
        editTextDirector =findViewById(R.id.FoodDirectorRating);
        editTextGlobalScore = findViewById(R.id.TotalRating);
        addReview = findViewById(R.id.addReviewButton);
        home = findViewById(R.id.home_review);
        editTextActor.setText("0");
        editTextDialogue.setText("0");
        editTextCostume.setText("0");
        editTextDirector.setText("0");
        editTextGlobalScore.setText("0");

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ReviewActivity.this,MainActivity.class);
                intent.putExtra("userToken",userToken);
                intent.putExtra("userID", user_id);
                startActivity(intent);            }
        });

        addReview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String reviewTitle = reviewTextTitle.getText().toString();
                String reviewComment = reviewTextComment.getText().toString();
                String reviewActor = editTextActor.getText().toString();
                String reviewDialogue = editTextDialogue.getText().toString();
                String reviewCostume = editTextCostume.getText().toString();
                String reviewDirector = editTextDirector.getText().toString();
                String globalscore = editTextGlobalScore.getText().toString();
                AsyncCallWS task = new AsyncCallWS();
                task.execute(food_id,user_id,reviewTitle,reviewComment,reviewActor,reviewDialogue,reviewCostume,reviewDirector,globalscore);
            }
        });
    }

    private class AsyncCallWS extends AsyncTask<String, Integer, Void> {
        @Override
        protected Void doInBackground(String... params) {
            Log.i(TAG, "doInBackground");
            insertReview(params[0],params[1],params[2],params[3],params[4],params[5],params[6],params[7],params[8]);
            openFoodDetails(params[0]);
            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            Log.i(TAG, "onPostExecute");
        }

        @Override
        protected void onPreExecute() {
            Log.i(TAG, "onPreExecute");
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            Log.i(TAG, "onProgressUpdate");
        }

    }

    public void insertReview(String food_id,String user_id,String reviewTitle,String reviewComment,String reviewActor,String reviewDialogue,String reviewCostume,String reviewDirector,String globalScore)
    {
        String NAMESPACE = "http://prosumer.sose.disim.univaq.it/";
        String METHOD_NAME = "insertReview";
        String WSDL_URL = "http://10.0.2.2:8080/ReviewEditorProsumer/ReviewEditor?wsdl";
        String SOAP_ACTION = "";

        try {
            SoapObject Request = new SoapObject(NAMESPACE, METHOD_NAME);

            SoapObject arg0 = new SoapObject("", "arg0");
            arg0.addProperty("comment", reviewComment);
            arg0.addProperty("foodID", food_id);
            arg0.addProperty("title", reviewTitle);
            arg0.addProperty("userID", user_id);



            SoapObject arg1 = new SoapObject("", "arg1");
            arg1.addProperty("actorsRating", reviewActor);
            arg1.addProperty("costumerRating", reviewCostume);
            arg1.addProperty("dialoguesRating", reviewDialogue);
            arg1.addProperty("foodDirectionRating", reviewDirector);
            arg1.addProperty("foodId", food_id);
            arg1.addProperty("globalScoreRating", globalScore);
            arg1.addProperty("userId", user_id);

            Request.addProperty("arg0",arg0);
            Request.addProperty("arg1",arg1);
            System.out.println(Request);

            SoapSerializationEnvelope soapEnvelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
            soapEnvelope.dotNet = false;

            soapEnvelope.setOutputSoapObject(Request);
            //Call
            List<HeaderProperty> headers = new ArrayList<HeaderProperty>();
            headers.add(new HeaderProperty("userToken","Porcodio"));

            HttpTransportSE transport= new HttpTransportSE(WSDL_URL);
            Log.i(TAG, "Invoking the " + METHOD_NAME + "operation");
            Log.i(TAG, "Sending message '" + reviewTitle + "'");
            transport.call(SOAP_ACTION, soapEnvelope, headers);

        }
        catch(Exception ex) {
            Log.e(TAG, "Error: " + ex.getStackTrace());
            ex.printStackTrace();
        }

    }

    public void openFoodDetails(String food_id){
        Intent intent = new Intent(this, FoodDetailActivity.class);
        intent.putExtra("food_id", food_id);
        intent.putExtra("userToken",userToken);
        intent.putExtra("userID", user_id);
        startActivity(intent);
    }



}
