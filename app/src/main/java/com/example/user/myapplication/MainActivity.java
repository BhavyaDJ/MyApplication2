package com.example.user.myapplication;

import android.annotation.TargetApi;
import android.icu.text.NumberFormat;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    int quantity= 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        CheckBox chekBox = (CheckBox) findViewById(R.id.whipped_cream_checkbox);
        boolean haswipped= chekBox.isChecked();
        Log.v("MainActivity","haswipped" +haswipped);

    }

    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {
        int price = calculatePrice();
        String priceMessage = createOrderSummary(price);
        displayMessage(priceMessage);
    }

    public int calculatePrice(){
        int price= quantity * 2;
        return price;
    }
    /**
     * This method is called when the plus button is clicked.
     */
    public void increment(View view){
        quantity =quantity+1;
        displayQuantity(quantity);
    }
    /**
     * This method is called when the minus button is clicked.
     */
    public void decrement(View view){
        quantity =quantity-1;
        displayQuantity(quantity);
    }
    private String createOrderSummary(int price){
        String priceMessage = "Name : Bhavya" ;
        priceMessage = priceMessage +"\nQuantity :" +quantity;
        priceMessage = priceMessage + "\nTotal : $" +price;
        priceMessage = priceMessage + "\nThank you!";
        return priceMessage;
    }
    /**
     * This method displays the given quantity value on the screen.
     */
    private void displayQuantity(int quantity) {
        TextView quantityTextView = (TextView) findViewById(R.id.textView2);
        quantityTextView.setText("" + quantity);
    }
    /**
     * This method displays the price for the given quantity value on the screen.
     */
    @TargetApi(Build.VERSION_CODES.N)
    private  void displayPrice(int number){
        TextView priceTextview = (TextView) findViewById(R.id.Order_summary_text_view);
        priceTextview.setText(NumberFormat.getCurrencyInstance().format(number));
    }
    private void displayMessage(String message){
        TextView messagetextView = (TextView) findViewById(R.id.Order_summary_text_view);
        messagetextView.setText(message);
    }

}
