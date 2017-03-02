/**
 * Add your package below. Package name can be found in the project's AndroidManifest.xml file.
 * This is the package name our example uses:
 *
 * package com.example.android.justjava; 
 */
package com.example.my.userinput ;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

//import  ;

/**
 * This app displays an order form to order coffee.
 */

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method is called when the order button is clicked.
     */
    int quantity = 2;
    public void submitOrder(View view) {


        CheckBox whippedcream = (CheckBox) findViewById(R.id.whipped_cream_checkbox);  //created a Whipped cream object
        boolean cream = whippedcream.isChecked();  //check if whipped cream is true or not
        CheckBox chocolate = (CheckBox) findViewById(R.id.choco_checkbox);
        boolean choco = chocolate.isChecked();

        int price = calculatePrice(cream,choco);

        EditText name = (EditText) findViewById(R.id.name_view);   //getting name from user
        String custumerName = name.getText().toString();            //storing it into variable

     //   display(quantity);

        // creating intent for using gmail app
       composeEmail(summary(price,cream,choco,custumerName),custumerName);
    }
    public void increament(View view){
        if (quantity>100)
        {
            Toast.makeText(this,"You cannot have more than 100 cups",Toast.LENGTH_SHORT).show();// sending a toast msg warning the user
            return;
        }
        quantity++;
        display(quantity);
    }
    public void decrement(View view){

        if (quantity<=1)
        {
            Toast.makeText(this,"You cannot have less than 1 cup ",Toast.LENGTH_SHORT).show();
            return;
        }
        quantity--;
        display(quantity);
    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void display(int numberOfCofees) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + numberOfCofees);
    }

    /**
     * This method displays the given text on the screen.
     */
    private void displayMessage(String message) {
        TextView orderTextView = (TextView) findViewById(R.id.order_summary_text_view);
        orderTextView.setText(message);
    }

    private int calculatePrice(boolean cream,boolean choco)
    {
        int basePrice = 5;
        if (cream)
            basePrice+=1;
        if (choco)
            basePrice+=2;
        return (quantity * basePrice);
    }
    /*
    return a string for order summary
     */
    private String summary (int price,boolean cream,boolean choco,String name)
    {
        String order =    "\nadd whipped cream?"+ cream +
                "\nadd whipped cream?"+ choco +
                "\nName: " + name +
                "\nQuantity =" + quantity +
                "\nTotal = " + price +
                "\nThank you";
        return order;
    }
    /*
       For email app intent
     */
    public void composeEmail(String body,String name) {
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:")); // only email apps should handle this
        intent.putExtra(Intent.EXTRA_SUBJECT, "Order for"+ name);
        intent.putExtra(Intent.EXTRA_TEXT, body);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }
   /*
   display order summary in the app only
    */
    private void createOrderSummary(int price,boolean cream,boolean choco,String name){

        displayMessage (

                "\nadd whipped cream?"+ cream +
                "\nadd whipped cream?"+ choco +
                "\nName: " + name +
                "\nQuantity =" + quantity +
                "\nTotal = " + price +
                "\nThank you");
    }
}