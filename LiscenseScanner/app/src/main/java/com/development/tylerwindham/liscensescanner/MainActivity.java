/*
 * Copyright (C) The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.development.tylerwindham.liscensescanner;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.TextView;

import com.google.android.gms.common.api.CommonStatusCodes;
import com.google.android.gms.vision.barcode.Barcode;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Main activity demonstrating how to pass extra parameters to an activity that
 * reads barcodes.
 */
public class MainActivity extends Activity implements View.OnClickListener {

    // use a compound button so either checkbox or switch widgets work.
    private CompoundButton autoFocus;
    private CompoundButton useFlash;
    private TextView statusMessage;
    private TextView barcodeValue;

    private static final int RC_BARCODE_CAPTURE = 9001;
    private static final String TAG = "BarcodeMain";

    public final String Customer_Family_Name = "DCS", Customer_Given_Name = "DCT",
            Street_Address_1 = "DAG", City = "DAI", Jurisdction_Code = "DAJ", Postal_Code = "DAK",
            Customer_Id_Number = "DAQ", Date_Of_Birth = "DBB";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        statusMessage = (TextView)findViewById(R.id.status_message);
        barcodeValue = (TextView)findViewById(R.id.barcode_value);

        autoFocus = (CompoundButton) findViewById(R.id.auto_focus);
        useFlash = (CompoundButton) findViewById(R.id.use_flash);

        findViewById(R.id.read_barcode).setOnClickListener(this);
    }

    /**
     * Called when a view has been clicked.
     *
     * @param v The view that was clicked.
     */
    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.read_barcode) {
            // launch barcode activity.
            Intent intent = new Intent(this, BarcodeCaptureActivity.class);
            intent.putExtra(BarcodeCaptureActivity.AutoFocus, autoFocus.isChecked());
            intent.putExtra(BarcodeCaptureActivity.UseFlash, useFlash.isChecked());

            startActivityForResult(intent, RC_BARCODE_CAPTURE);
        }

    }

    /**
     * Called when an activity you launched exits, giving you the requestCode
     * you started it with, the resultCode it returned, and any additional
     * data from it.  The <var>resultCode</var> will be
     * {@link #RESULT_CANCELED} if the activity explicitly returned that,
     * didn't return any result, or crashed during its operation.
     * <p/>
     * <p>You will receive this call immediately before onResume() when your
     * activity is re-starting.
     * <p/>
     *
     * @param requestCode The integer request code originally supplied to
     *                    startActivityForResult(), allowing you to identify who this
     *                    result came from.
     * @param resultCode  The integer result code returned by the child activity
     *                    through its setResult().
     * @param data        An Intent, which can return result data to the caller
     *                    (various data can be attached to Intent "extras").
     * @see #startActivityForResult
     * @see #createPendingResult
     * @see #setResult(int)
     */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        ArrayList<String> allKeys = new ArrayList<String>();
        allKeys.add(Customer_Family_Name);
        allKeys.add(Customer_Given_Name);
        allKeys.add(Street_Address_1);
        allKeys.add(City);
        allKeys.add(Jurisdction_Code);
        allKeys.add(Postal_Code);
        allKeys.add(Customer_Id_Number);
        allKeys.add(Date_Of_Birth);
        HashMap<String, String> myData = new HashMap<String, String>();

        if (requestCode == RC_BARCODE_CAPTURE) {
            if (resultCode == CommonStatusCodes.SUCCESS) {
                if (data != null) {
                    Barcode barcode = data.getParcelableExtra(BarcodeCaptureActivity.BarcodeObject);
                    String barcodeResult = barcode.rawValue;
                    String lines[] = barcodeResult.split("\\r?\\n");
                    for (int i = 0; i < lines.length; i++)
                    {
                        String str = lines[i];
                        if (str.contains("ANSI"))
                        {
                            str = str.substring(str.indexOf("DL"));
                            String str1[] = str.split("DL");
                            if (str1.length > 1)
                            {
                                str = str1[str1.length - 1];
                            }
                        }
                        if (str.length() > 3)
                        {
                            String key = str.substring(0, 3);
                            String value = str.substring(3);
                            if (allKeys.contains(key))
                            {
                                if (!value.equalsIgnoreCase("None"))
                                {
                                    myData.put(allKeys.get(allKeys.indexOf(key)), value);
                                }
                            }
                        }
                        Log.e("RESULT ", "<<>>" + lines[i]);
                    }
                    if (myData.containsKey(Customer_Family_Name))
                    {
                        Log.v("TAG", "users family name:" + myData.get(Customer_Family_Name));
                        String lname = myData.get(Customer_Family_Name).trim();
                    }
                    if (myData.containsKey(Customer_Given_Name))
                    {
                        Log.v("TAG", "users Given name:" + myData.get(Customer_Given_Name));
                        try
                        {
                            String CustomerName[] = myData.get(Customer_Given_Name).split(" ");
                            String fname = CustomerName[0].trim();
                            String mname = CustomerName[1].substring(0, 1).trim();
                        }
                        catch (Exception e)
                        {
                            e.printStackTrace();
                        }
                    }
                    if (myData.containsKey(Street_Address_1))
                    {
                        Log.v("TAG", "Address line 1 :" + myData.get(Street_Address_1));
                        try
                        {
                            String address = myData.get(Street_Address_1).trim();
                        }
                        catch (Exception e)
                        {
                            e.printStackTrace();
                        }
                    }
                    if (myData.containsKey(City))
                    {
                        Log.v("TAG", "City:" + myData.get(City));
                        String city = myData.get(City).trim();
                    }
                    if (myData.containsKey(Postal_Code))
                    {
                        Log.v("TAG", "Pin Code:" + myData.get(Postal_Code));
                        String zipcode = myData.get(Postal_Code).substring(0, 5).trim();
                    }
                    if (myData.containsKey(Date_Of_Birth))
                    {
                        Log.v("TAG", "Birth Date    :" + myData.get(Date_Of_Birth));
                        String birthday = myData.get(Date_Of_Birth).substring(0, 2) + "/" + myData.get(Date_Of_Birth).substring(2, 4)
                                + "/" + myData.get(Date_Of_Birth).substring(4);
                    }
                    if (myData.containsKey(Customer_Id_Number))
                    {
                        String licence_number = myData.get(Customer_Id_Number).trim();
                        Log.e("TAG", "Licence Number is :" + licence_number);
                    }
                    statusMessage.setText(R.string.barcode_success);
                    barcodeValue.setText(barcode.displayValue);
                    Log.d(TAG, "Barcode read: " + barcode.displayValue);
                } else {
                    statusMessage.setText(R.string.barcode_failure);
                    Log.d(TAG, "No barcode captured, intent data is null");
                }
            } else {
                statusMessage.setText(String.format(getString(R.string.barcode_error),
                        CommonStatusCodes.getStatusCodeString(resultCode)));
            }
        }
        else {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }
}
