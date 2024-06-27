package it.univaq.disim.sose.application;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.squareup.picasso.Picasso;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

import it.univaq.disim.sose.application.adapters.ReviewAdapter;
import it.univaq.disim.sose.application.models.FoodDetail;
import it.univaq.disim.sose.application.models.RatingData;
import it.univaq.disim.sose.application.models.Review;

public class FoodDetailActivity extends Activity {

    private String TAG ="SOAPClient",searchText,foodID,userID,title,comment,userToken;
    private FoodDetail foodDetail;
    private ImageView imageView;
    private TextView titleView,descriptionView,foodRatings,globalScore;
    private ListView listView;
    private ImageButton editButton;
    private ImageButton home , toLoginFD;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.food_detail);
        Intent intent = getIntent();
        searchText = intent.getStringExtra("food_id");
        userToken = intent.getStringExtra("userToken");
        userID = intent.getStringExtra("userID");



        AsyncCallWS task = new AsyncCallWS();
        try {
            foodDetail = task.execute(searchText).get();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        imageView=findViewById(R.id.foodImage);
        Picasso.with(FoodDetailActivity.this).load(foodDetail.getImageLink())
                .into(imageView);

        titleView = findViewById(R.id.foodTitle);
        titleView.setText(foodDetail.getTitle());
        descriptionView = findViewById(R.id.foodDescription);
        descriptionView.setText(foodDetail.descriptionForDetails());
        foodRatings = findViewById(R.id.foodRatings);
        globalScore = findViewById(R.id.globalScore);

        if (foodDetail.getRatings().equals(null)){
            foodRatings.setText("No ratings yet");
        }else {
            foodRatings.setText(foodDetail.getRatings().toString());
            globalScore.setText(foodDetail.getRatings().globalScoreText());
        }


        listView=findViewById(R.id.listViewReviews);
        ReviewAdapter reviewAdapter = new ReviewAdapter(this,R.layout.review_row,foodDetail.getReviews());
        listView.setAdapter(reviewAdapter);

        toLoginFD = findViewById(R.id.toLoginFD);
        toLoginFD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(userToken == null ){
                    Intent intent = new Intent(FoodDetailActivity.this, LoginActivity.class);
                    startActivity(intent);
                } else {
                    Log.i("LOGIN","Alredy Logged in");
                }
            }
        });

        home = findViewById(R.id.home_fooddetail);
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FoodDetailActivity.this,MainActivity.class);
                intent.putExtra("userToken",userToken);
                intent.putExtra("userID",userID);
                startActivity(intent);
            }
        });

        editButton = findViewById(R.id.buttonNewReview);
        editButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (userToken != null){
                Intent intent = new Intent(FoodDetailActivity.this, ReviewActivity.class);
                intent.putExtra("userID", userID);
                intent.putExtra("food_id",foodDetail.getId());
                intent.putExtra("food_title",foodDetail.getTitle());
                intent.putExtra("userToken", userToken);
                startActivity(intent);
                }
            }
        });

    }

    private class AsyncCallWS extends AsyncTask<String, Integer, FoodDetail> {
        @Override
        protected FoodDetail doInBackground(String... params) {
            Log.i(TAG, "doInBackground");
            return foodDetail = returnFoodDetail(params[0]);
        }

        @Override
        protected void onPostExecute(FoodDetail result) {
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

    public FoodDetail returnFoodDetail(String message)
    {
        String NAMESPACE = "http://fooddetails.sose.disim.univaq.it/";
        String METHOD_NAME = "getFoodDetails";
        String WSDL_URL = "http://10.0.2.2:8080/FoodDetailsProsumer/fooddetails?wsdl";
        String SOAP_ACTION = "";

        try {
            SoapObject Request = new SoapObject(NAMESPACE, METHOD_NAME);
            Request.addProperty("arg0", message);
            SoapSerializationEnvelope soapEnvelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
            soapEnvelope.dotNet = false;
            soapEnvelope.setOutputSoapObject(Request);
            HttpTransportSE transport= new HttpTransportSE(WSDL_URL);
            RatingData rating = new RatingData();

            Log.i(TAG, "Invoking the " + METHOD_NAME + "operation");
            Log.i(TAG, "Sending message '" + message + "'");
            transport.call(SOAP_ACTION, soapEnvelope);

            // Soap Object init
            SoapObject foodsDetailsSoap= (SoapObject) soapEnvelope.getResponse();
            // Food Rating init

            if(foodsDetailsSoap.hasProperty("ratings")) {
                rating = new RatingData((SoapObject) foodsDetailsSoap.getProperty("ratings"));
            }
            // Food Review List Inizialization
            ArrayList<Review> reviewList = new ArrayList<Review>();
            for(int i = 0; i < foodsDetailsSoap.getPropertyCount(); i++){
                String x = foodsDetailsSoap.getPropertyInfo(i).getName();
               if(x.equals("reviews") ){
                   SoapObject objectFor = (SoapObject) foodsDetailsSoap.getProperty(i);
                   foodID = objectFor.getPropertyAsString("foodID");
                   userID = objectFor.getPropertyAsString("userID");
                   title = objectFor.getPropertyAsString("title");
                   comment = objectFor.getPropertyAsString("comment");
                   Review review = new Review( foodID, userID, title, comment);
                   reviewList.add(review);
               }
            }

            //foodDetail Creation
                foodDetail = new FoodDetail(foodsDetailsSoap, reviewList, rating);


            return foodDetail;
        }
        catch(Exception ex) {
            Log.e(TAG, "Error: " + ex.getMessage());
        }
        return foodDetail;
    }


}
