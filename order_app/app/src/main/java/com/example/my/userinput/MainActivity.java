/**
 * Add your package below. Package name can be found in the project's AndroidManifest.xml file.
 * This is the package name our example uses:
 *
 * package com.example.android.justjava; 
 */
package com.example.my.userinput ;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

//import com.example.my.userinput.R;

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
    int quantity = 0;
    public void submitOrder(View view) {
        int price = calculatePrice();
        CheckBox whippedcream = (CheckBox) findViewById(R.id.whipped_cream_checkbox);  //created a Whipped cream object
        boolean cream = whippedcream.isChecked();  //check if whipped cream is true or not
        CheckBox chocolate = (CheckBox) findViewById(R.id.choco_checkbox);
        boolean choco = chocolate.isChecked();
        display(quantity);
        createOrderSummary(price,cream,choco);
    }
    public void increament(View view){
        quantity++;
        display(quantity);
    }
    public void decrement(View view){
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

    private int calculatePrice()
    {
        return quantity * 5;
    }
    private void createOrderSummary(int price,boolean cream,boolean choco){

        displayMessage ("add whipped cream?"+ cream +
                "\nadd whipped cream?"+ choco +
                "\nName: ayushGoyal" +
                "\nQuantity =" + quantity +
        "\nTotal = " + price +
        "\nThank you");
    }
  /*  private void whippedcream(View view)
    {

    }
*/
}