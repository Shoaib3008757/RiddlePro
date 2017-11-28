package riddletelecom.riddlepro;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Random;

import riddletelecom.riddlepro.util.IabBroadcastReceiver;
import riddletelecom.riddlepro.util.IabHelper;
import riddletelecom.riddlepro.util.IabResult;
import riddletelecom.riddlepro.util.Inventory;
import riddletelecom.riddlepro.util.Purchase;

public class RiddlePro extends AppCompatActivity implements IabBroadcastReceiver.IabBroadcastListener{
    ListView riddleListView;
    ArrayList<RiddleGetterSetter> riddleArrayList = new ArrayList();
    int boughtValue1 , boughtValue2   , boughtValue3 , boughtValue4 , boughtValue5
            , boughtValue6 , boughtValue7  , boughtValue8  , boughtValue9  , boughtValue10;

    int riddleNumber = 0;

    IabHelper mHelper;
    String devPayLoad = "";
    private static final int IAPCODE = 10001;
    static final int RC_REQUEST = 10001;
    boolean mIsPremium = false;
    boolean mSubscribedToInfiniteGas = false;
    // Provides purchase notification while this app is running
    IabBroadcastReceiver mBroadcastReceiver;
    SharedPreferences sharedPreferences , spOnlyOnceRun;
    static final String SKU_Riddle1 = "Riddle1";
    static final String SKU_Riddle2 = "Riddle2";
    static final String SKU_Riddle3 = "Riddle3";
    static final String SKU_Riddle4 = "Riddle4";
    static final String SKU_Riddle5 = "Riddle5";
    static final String SKU_Riddle6 = "Riddle6";
    static final String SKU_Riddle7 = "Riddle7";

    static final String TAG = "RiddlePro";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_riddle_pro);
        initiate();
        keyInitialization();
        startUpLab();
        loadData();
    }
    public void initiate()
    {
        riddleListView = (ListView) findViewById(R.id.riddlelistview);
        riddleArrayList.add(new RiddleGetterSetter("Dunya main ak aisi City kaa naam bataen jisay ulta likhney se aik parinday ka naam ban jae"));
        riddleArrayList.add(new RiddleGetterSetter("Main ak phal hon khatta meetha- bachay shoq se khatay hain. Aakhri dono harf mita kar sabzi mujh ko banatay hain"));
        riddleArrayList.add(new RiddleGetterSetter("Ak Jadoogar ka hai ye kamal. Dalay sabz, nikalay laal"));
        riddleArrayList.add(new RiddleGetterSetter("Dhoop kabhi na usay sukhaye. Sookha jab woh saye main aye"));
        riddleArrayList.add(new RiddleGetterSetter("Moti sachay thy ya jhootey. hath K lagtay hi sabb tootay"));
        riddleArrayList.add(new RiddleGetterSetter("Billi safaid ik main ne dekhi, bethi thi gumm summ. Jism tha uska sara hi gora hari thi lekin dum."));
        riddleArrayList.add(new RiddleGetterSetter("Andhi ho Ya teez hawa kabhi bujhy na ek diya"));
        riddleArrayList.add(new RiddleGetterSetter("Bujho bhai ek paheli jab kaato to nai naveli"));
        riddleArrayList.add(new RiddleGetterSetter("Khridne par kala jalane par laal phankne par safaid, btao kya hai"));
        riddleArrayList.add(new RiddleGetterSetter("Baton baton main woh khaya. Kha kar bhi sabit hi paya"));

        riddleListView.setAdapter(new RidddleCustomAdapter(RiddlePro.this, riddleArrayList));

        riddleListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                switch (i) {
                    case 0:

                        Intent intent1 =new Intent(RiddlePro.this, viewRiddleAnswer.class);
                        intent1.putExtra("id" , "1");
                        startActivity(intent1);

                        break;
                    case 1:

                        Intent intent2 =new Intent(RiddlePro.this, viewRiddleAnswer.class);
                        intent2.putExtra("id" , "2");
                        startActivity(intent2);

                        break;
                    case 2:

                        Intent intent3 =new Intent(RiddlePro.this, viewRiddleAnswer.class);
                        intent3.putExtra("id" , "3");
                        startActivity(intent3);

                        break;

                    case 3:

                        loadData();

                        if(boughtValue1 == 1)
                        {
                            Intent intent4 =new Intent(RiddlePro.this, viewRiddleAnswer.class);
                            intent4.putExtra("id" , "4");
                            startActivity(intent4);
                        }
                        else {
                            riddleNumber = 1;
                            buyImageDialog();
                        }


                        break;

                    case 4:


                        loadData();

                        if(boughtValue2 == 2)
                        {
                            Intent intent5 =new Intent(RiddlePro.this, viewRiddleAnswer.class);
                            intent5.putExtra("id" , "5");
                            startActivity(intent5);

                        }
                        else {
                            riddleNumber = 2;
                            buyImageDialog();
                        }

                        break;

                    case 5:

                        loadData();

                        if(boughtValue3 == 3)
                        {
                            Intent intent6 =new Intent(RiddlePro.this, viewRiddleAnswer.class);
                            intent6.putExtra("id" , "6");
                            startActivity(intent6);
                        }
                        else {
                            riddleNumber = 3;
                            buyImageDialog();
                        }

                        break;
                    case 6:


                        loadData();

                        if(boughtValue4 == 4)
                        {
                            Intent intent7 =new Intent(RiddlePro.this, viewRiddleAnswer.class);
                            intent7.putExtra("id" , "7");
                            startActivity(intent7);
                        }
                        else {
                            riddleNumber = 4;
                            buyImageDialog();
                        }

                        break;
                    case 7:


                        loadData();

                        if(boughtValue5 == 5)
                        {
                            Intent intent8 =new Intent(RiddlePro.this, viewRiddleAnswer.class);
                            intent8.putExtra("id" , "8");
                            startActivity(intent8);
                        }
                        else {
                            riddleNumber = 5;
                            buyImageDialog();
                        }

                        break;
                    case 8:


                        loadData();

                        if(boughtValue6 == 6)
                        {
                            Intent intent9 =new Intent(RiddlePro.this, viewRiddleAnswer.class);
                            intent9.putExtra("id" , "9");
                            startActivity(intent9);
                        }
                        else {
                            riddleNumber = 6;
                            buyImageDialog();
                        }

                        break;
                    case 9:


                        loadData();

                        if(boughtValue7 == 7)
                        {
                            Intent intent10 =new Intent(RiddlePro.this, viewRiddleAnswer.class);
                            intent10.putExtra("id" , "10");
                            startActivity(intent10);
                        }
                        else {
                            riddleNumber = 7;
                            buyImageDialog();
                        }

                        break;

                    default:

                        break;

                }
            }
        });
    }

    public void buyImageDialog()
    {
        final Dialog dialog = new Dialog(RiddlePro.this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.buyriddleanswerdialog);
        dialog.setTitle("Add Clause");

        Button buy_button =  (Button) dialog.findViewById(R.id.buy_button);
        Button later_button = (Button) dialog.findViewById(R.id.later_button);


        buy_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                if(riddleNumber == 1)
                {
                    try {
                        dialog.dismiss();
                        buyRiddle1();
                        //onSuccessShirtBought();
                        Log.d("tag" ,"onSuccessShirtBought on button");
                    }catch (Exception e){
                        e.printStackTrace();
                    }

                }

                if(riddleNumber == 2)
                {
                    try {
                        dialog.dismiss();
                        buyRiddle2();
                        //onSuccessShirtBought();
                    }catch (Exception e){
                        e.printStackTrace();
                    }

                }
                if(riddleNumber == 3)
                {
                    try {
                        dialog.dismiss();
                        buyRiddle3();
                        //onSuccessShirtBought();
                    }catch (Exception e){
                        e.printStackTrace();
                    }

                }
                if(riddleNumber == 4)
                {
                    try {
                        dialog.dismiss();
                        buyRiddle4();
                        //onSuccessShirtBought();
                    }catch (Exception e){
                        e.printStackTrace();
                    }

                }
                if(riddleNumber == 5)
                {
                    try {
                        dialog.dismiss();
                        buyRiddle5();
                        //onSuccessShirtBought();
                    }catch (Exception e){
                        e.printStackTrace();
                    }

                }
                if(riddleNumber == 6)
                {
                    try {
                        dialog.dismiss();
                        buyRiddle6();
                        //onSuccessShirtBought();
                    }catch (Exception e){
                        e.printStackTrace();
                    }

                }
                if(riddleNumber == 7)
                {
                    try {
                        dialog.dismiss();
                        buyRiddle7();
                        //onSuccessShirtBought();
                    }catch (Exception e){
                        e.printStackTrace();
                    }

                }


            }
        });

        later_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });
        dialog.setCancelable(false);
        dialog.show();

    }




    //hiding views when bought invertory successfull
    public void onSuccessShirtBought(){
        sharedPreferences = getSharedPreferences("FORSELLRIDDLE", 0);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        //start
        if (riddleNumber==1){
            //additing values to sharepreferences
            editor.putInt("RIDDLE1", 1);//int value 1 is for stargoggle

        }//end
//start
        if (riddleNumber==2){
            //additing values to sharepreferences
            editor.putInt("RIDDLE2", 2);//int value 1 is for stargoggle


        }//end
//start
        if (riddleNumber==3){
            //additing values to sharepreferences
            editor.putInt("RIDDLE3", 3);//int value 1 is for stargoggle

        }//end
//start
        if (riddleNumber==4){
            //additing values to sharepreferences
            editor.putInt("RIDDLE4", 4);//int value 1 is for stargoggle

        }//end
//start
        if (riddleNumber==5){
            //additing values to sharepreferences
            editor.putInt("RIDDLE5", 5);//int value 1 is for stargoggle

        }//end
//start
        if (riddleNumber==6){
            //additing values to sharepreferences
            editor.putInt("RIDDLE6", 6);//int value 1 is for stargoggle

        }//end
//start
        if (riddleNumber==7){
            //additing values to sharepreferences
            editor.putInt("RIDDLE7", 7);//int value 1 is for stargoggle

        }//end
//start



        editor.commit();

        //ifAllMobileBought();


    }//end of on Successfully RIDDLE bought

    public void loadData(){
        sharedPreferences = getSharedPreferences("FORSELLRIDDLE", 0);

        if(sharedPreferences!=null) {
            boughtValue1 = sharedPreferences.getInt("RIDDLE1", 0);//defualt values is zero for all
            boughtValue2 = sharedPreferences.getInt("RIDDLE2", 0);
            boughtValue3 = sharedPreferences.getInt("RIDDLE3", 0);
            boughtValue4 = sharedPreferences.getInt("RIDDLE4", 0);
            boughtValue5 = sharedPreferences.getInt("RIDDLE5", 0);
            boughtValue6 = sharedPreferences.getInt("RIDDLE6", 0);
            boughtValue7 = sharedPreferences.getInt("RIDDLE7", 0);

            Log.d("tag" , "sharedPreferences 1 "+boughtValue1 );

            if (boughtValue1==1){

            }
            if (boughtValue2==2){


            }
            if (boughtValue3==3){


            }
            if (boughtValue4==4){

            }
            if (boughtValue5==5){


            }
            if (boughtValue6==6){


            }
            if (boughtValue7==7){


            }



        }


    }





    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if(requestCode == IAPCODE )
        {
            android.util.Log.d(TAG, "onActivityResult(" + requestCode + "," + resultCode + "," + data);
            if (mHelper == null) return;

            // Pass on the activity result to the helper for handling
            if (!mHelper.handleActivityResult(requestCode, resultCode, data)) {




                super.onActivityResult(requestCode, resultCode, data);
            }
            else {
                android.util.Log.d(TAG, "onActivityResult handled by IABUtil.");
            }

        }



    }

    public void  keyInitialization(){
        String base64EncodedPublicKey = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAkKFGVC+SsJzzbSphEYe7q/dNQFo3xrTiqXvH8uj/gDrTM7tDmIWSPPjyON+eueb3zq+gfZDliBqKkFWy8CvS2J4XC6qd04qU/MYR+Gs3tQWoRqJnFqjukHRPuUtNFSXPqUxs8enXVOPswNOk38LfQmrmXKn4jyHA2fkX8SMdKALHr1MJoorG+LAWg/h8QZlEx3m4837mXachxClNmrpEgHDdWAuBpPU0rzRsQ/FfZdzpohZcuLGCEm39u7MIOQaCk07eFj4K/1Q1GmTj1vcfpUusilQCJzY2FtZzUeI8gkyin5zOMCyWQjEboUY+l2bbTOflorIme7xHF1ziBfW9awIDAQAB";

        // Some sanity checks to see if the developer (that's you!) really followed the
        // instructions to run this sample (don't put these checks on your app!)
        if (base64EncodedPublicKey.contains("CONSTRUCT_YOUR")) {
            throw new RuntimeException("Please put your app's public key in MainActivity.java. See README.");
        }
        if (getPackageName().startsWith("com.example")) {
            throw new RuntimeException("Please change the sample's package name! See README.");
        }

        // Create the helper, passing it our context and the public key to verify signatures with
        android.util.Log.d(TAG, "Creating IAB helper.");
        mHelper = new IabHelper(this, base64EncodedPublicKey);

        // enable debug logging (for a production application, you should set this to false).
        mHelper.enableDebugLogging(true);



    }//end of keyInitialization

    public void startUpLab(){
        // Start setup. This is asynchronous and the specified listener
        // will be called once setup completes.
        android.util.Log.d(TAG, "Starting setup.");

        mHelper.startSetup(new IabHelper.OnIabSetupFinishedListener() {
            public void onIabSetupFinished(IabResult result) {
                android.util.Log.d(TAG, "Setup finished.");

                if (!result.isSuccess()) {
                    // Oh noes, there was a problem.
                    complain("Problem setting up in-app billing: " + result);
                    return;
                }

                // Have we been disposed of in the meantime? If so, quit.
                if (mHelper == null) return;

                mBroadcastReceiver = new IabBroadcastReceiver(RiddlePro.this);
                IntentFilter broadcastFilter = new IntentFilter(IabBroadcastReceiver.ACTION);
                registerReceiver(mBroadcastReceiver, broadcastFilter);

                // IAB is fully set up. Now, let's get an inventory of stuff we own.
                android.util.Log.d(TAG, "Setup successful. Querying inventory.");
                try {
                    mHelper.queryInventoryAsync(mGotInventoryListener);
                } catch (IabHelper.IabAsyncInProgressException e) {
                    complain("Error querying inventory. Another async operation in progress.");
                }
            }
        });


    }//end of startup lab

    @Override
    protected void onDestroy() {
        super.onDestroy();

        inAppBilling_onDestroy();

    }

    private static final char[] payloadSymbols = new char[36];

    static {
        for (int idx = 0; idx < 10; ++idx)
            payloadSymbols[idx] = (char) ('0' + idx);
        for (int idx = 10; idx < 36; ++idx)
            payloadSymbols[idx] = (char) ('a' + idx - 10);
    }


    public void inAppBilling_onDestroy()
    {

        // very important:
        if (mBroadcastReceiver != null) {
            unregisterReceiver(mBroadcastReceiver);
        }
        if (mHelper != null) try {
            mHelper.dispose();
            mHelper.disposeWhenFinished();
        } catch (IabHelper.IabAsyncInProgressException e) {
            e.printStackTrace();
        }
        mHelper = null;
    }

    // Callback for when a purchase is finished
    IabHelper.OnIabPurchaseFinishedListener mPurchaseFinishedListener = new IabHelper.OnIabPurchaseFinishedListener() {
        public void onIabPurchaseFinished(IabResult result, Purchase purchase) {
            android.util.Log.d(TAG, "Purchase finished: " + result + ", purchase: " + purchase);

            // if we were disposed of in the meantime, quit.
            if (mHelper == null) return;

            if (result.isFailure()) {
                complain("Error purchasing: " + result);
                setWaitScreen(false);
                return;
            }
            if (!verifyDeveloperPayload(purchase)) {
                complain("Error purchasing. Authenticity verification failed.");
                setWaitScreen(false);
                return;
            }

            android.util.Log.d(TAG, "Purchase successful.");

            //*********************************** Method for RIDDLE *******************
            //***************RIDDLE 1*****************
            if (riddleNumber == 1) {
                if (purchase.getSku().equals(SKU_Riddle1)) {
                    // bought 1/4 tank of gas. So consume it.
                    android.util.Log.d(TAG, "Purchase is Star Goggle. Starting Goggle consumption.");
                    try {
                        mHelper.consumeAsync(purchase, mConsumeFinishedListener);
                    } catch (IabHelper.IabAsyncInProgressException e) {
                        complain("Error consuming Goggle. Another async operation in progress.");
                        setWaitScreen(false);
                        return;
                    }
                }
            }//end of RIDDLE 1

            //***************RIDDLE 2*****************
            if (riddleNumber == 2) {
                if (purchase.getSku().equals(SKU_Riddle2)) {
                    // bought 1/4 tank of gas. So consume it.
                    android.util.Log.d(TAG, "Purchase is Star Goggle. Starting Goggle consumption.");
                    try {
                        mHelper.consumeAsync(purchase, mConsumeFinishedListener);
                    } catch (IabHelper.IabAsyncInProgressException e) {
                        complain("Error consuming Goggle. Another async operation in progress.");
                        setWaitScreen(false);
                        return;
                    }
                }
            }//end of RIDDLE 2

            //***************RIDDLE 3*****************
            if (riddleNumber == 3) {
                if (purchase.getSku().equals(SKU_Riddle3)) {
                    // bought 1/4 tank of gas. So consume it.
                    android.util.Log.d(TAG, "Purchase is Star Goggle. Starting Goggle consumption.");
                    try {
                        mHelper.consumeAsync(purchase, mConsumeFinishedListener);
                    } catch (IabHelper.IabAsyncInProgressException e) {
                        complain("Error consuming Goggle. Another async operation in progress.");
                        setWaitScreen(false);
                        return;
                    }
                }
            }//end of RIDDLE 3

            //***************RIDDLE 4*****************
            if (riddleNumber == 4) {
                if (purchase.getSku().equals(SKU_Riddle4)) {
                    // bought 1/4 tank of gas. So consume it.
                    android.util.Log.d(TAG, "Purchase is Star Goggle. Starting Goggle consumption.");
                    try {
                        mHelper.consumeAsync(purchase, mConsumeFinishedListener);
                    } catch (IabHelper.IabAsyncInProgressException e) {
                        complain("Error consuming Goggle. Another async operation in progress.");
                        setWaitScreen(false);
                        return;
                    }
                }
            }//end of RIDDLE 4

            //***************RIDDLE 5*****************
            if (riddleNumber == 5) {
                if (purchase.getSku().equals(SKU_Riddle5)) {
                    // bought 1/4 tank of gas. So consume it.
                    android.util.Log.d(TAG, "Purchase is Star Goggle. Starting Goggle consumption.");
                    try {
                        mHelper.consumeAsync(purchase, mConsumeFinishedListener);
                    } catch (IabHelper.IabAsyncInProgressException e) {
                        complain("Error consuming Goggle. Another async operation in progress.");
                        setWaitScreen(false);
                        return;
                    }
                }
            }//end of RIDDLE 5

            //***************RIDDLE 6*****************
            if (riddleNumber == 6) {
                if (purchase.getSku().equals(SKU_Riddle6)) {
                    // bought 1/4 tank of gas. So consume it.
                    android.util.Log.d(TAG, "Purchase is Star Goggle. Starting Goggle consumption.");
                    try {
                        mHelper.consumeAsync(purchase, mConsumeFinishedListener);
                    } catch (IabHelper.IabAsyncInProgressException e) {
                        complain("Error consuming Goggle. Another async operation in progress.");
                        setWaitScreen(false);
                        return;
                    }
                }
            }//end of RIDDLE 6

            //***************RIDDLE 7*****************
            if (riddleNumber == 7) {
                if (purchase.getSku().equals(SKU_Riddle7)) {
                    // bought 1/4 tank of gas. So consume it.
                    android.util.Log.d(TAG, "Purchase is Star Goggle. Starting Goggle consumption.");
                    try {
                        mHelper.consumeAsync(purchase, mConsumeFinishedListener);
                    } catch (IabHelper.IabAsyncInProgressException e) {
                        complain("Error consuming Goggle. Another async operation in progress.");
                        setWaitScreen(false);
                        return;
                    }
                }
            }//end of RIDDLE 7


            //********************************************* Ranglerz Team **********************************

        }
    };



    @Override
    public void receivedBroadcast() {
// Received a broadcast notification that the inventory of items has changed
        android.util.Log.d(TAG, "Received broadcast notification. Querying inventory.");
        try {
            mHelper.queryInventoryAsync(mGotInventoryListener);
        } catch (IabHelper.IabAsyncInProgressException e) {
            android.util.Log.e(TAG, "Error querying inventory. Another async operation in progress.");
        }
    }

    public class RandomString {

       /*
        * static { for (int idx = 0; idx < 10; ++idx) symbols[idx] = (char)
        * ('0' + idx); for (int idx = 10; idx < 36; ++idx) symbols[idx] =
        * (char) ('a' + idx - 10); }
        */


        private final Random random = new Random();

        private final char[] buf;

        public RandomString(int length) {
            if (length < 1)
                throw new IllegalArgumentException("length < 1: " + length);
            buf = new char[length];
        }

        public String nextString() {
            for (int idx = 0; idx < buf.length; ++idx)
                buf[idx] = payloadSymbols[random.nextInt(payloadSymbols.length)];
            return new String(buf);
        }

    }

    public final class SessionIdentifierGenerator {

        private SecureRandom random = new SecureRandom();

        public String nextSessionId() {
            return new BigInteger(130, random).toString(32);
        }

    }


    // Listener that's called when we finish querying the items and subscriptions we own
    IabHelper.QueryInventoryFinishedListener mGotInventoryListener = new IabHelper.QueryInventoryFinishedListener() {
        public void onQueryInventoryFinished(IabResult result, Inventory inventory) {
            android.util.Log.d(TAG, "Query inventory finished.");

            // Have we been disposed of in the meantime? If so, quit.
            if (mHelper == null) return;

            // Is it a failure?
            if (result.isFailure()) {
                complain("Failed to query inventory: " + result);
                return;
            }

            android.util.Log.d(TAG, "Query inventory was successful.");

            // Check for gas delivery -- if we own gas, we should fill up the tank immediately

            //************************************** for RIDDLE Perchase ********************************

            //************for RIDDLE 1 perchase*********************
            if (riddleNumber==1){
                Purchase gasPurchase = inventory.getPurchase(SKU_Riddle1);
                android.util.Log.d(TAG, "Inventory Purchase " + gasPurchase);

                if (gasPurchase != null && verifyDeveloperPayload(gasPurchase)) {
                    android.util.Log.d(TAG, "We have gas. Consuming it.");
                    try {
                        mHelper.consumeAsync(inventory.getPurchase(SKU_Riddle1), mConsumeFinishedListener);
                    } catch (IabHelper.IabAsyncInProgressException e) {
                        complain("Error consuming gas. Another async operation in progress.");
                    }
                    return;
                }
            }//end for RIDDLE 1 perchase

            //************for RIDDLE 2 perchase*********************
            if (riddleNumber==2){
                Purchase gasPurchase = inventory.getPurchase(SKU_Riddle2);
                android.util.Log.d(TAG, "Inventory Purchase " + gasPurchase);

                if (gasPurchase != null && verifyDeveloperPayload(gasPurchase)) {
                    android.util.Log.d(TAG, "We have gas. Consuming it.");
                    try {
                        mHelper.consumeAsync(inventory.getPurchase(SKU_Riddle2), mConsumeFinishedListener);
                    } catch (IabHelper.IabAsyncInProgressException e) {
                        complain("Error consuming gas. Another async operation in progress.");
                    }
                    return;
                }
            }//end for RIDDLE 2 perchase

            //************for RIDDLE 3 perchase*********************
            if (riddleNumber==3){
                Purchase gasPurchase = inventory.getPurchase(SKU_Riddle3);
                android.util.Log.d(TAG, "Inventory Purchase " + gasPurchase);

                if (gasPurchase != null && verifyDeveloperPayload(gasPurchase)) {
                    android.util.Log.d(TAG, "We have gas. Consuming it.");
                    try {
                        mHelper.consumeAsync(inventory.getPurchase(SKU_Riddle3), mConsumeFinishedListener);
                    } catch (IabHelper.IabAsyncInProgressException e) {
                        complain("Error consuming gas. Another async operation in progress.");
                    }
                    return;
                }
            }//end for RIDDLE 3 perchase

//************for RIDDLE 4 perchase*********************
            if (riddleNumber==4){
                Purchase gasPurchase = inventory.getPurchase(SKU_Riddle4);
                android.util.Log.d(TAG, "Inventory Purchase " + gasPurchase);

                if (gasPurchase != null && verifyDeveloperPayload(gasPurchase)) {
                    android.util.Log.d(TAG, "We have gas. Consuming it.");
                    try {
                        mHelper.consumeAsync(inventory.getPurchase(SKU_Riddle4), mConsumeFinishedListener);
                    } catch (IabHelper.IabAsyncInProgressException e) {
                        complain("Error consuming gas. Another async operation in progress.");
                    }
                    return;
                }
            }//end for RIDDLE 4 perchase

            //************for RIDDLE 5 perchase*********************
            if (riddleNumber==5){
                Purchase gasPurchase = inventory.getPurchase(SKU_Riddle5);
                android.util.Log.d(TAG, "Inventory Purchase " + gasPurchase);

                if (gasPurchase != null && verifyDeveloperPayload(gasPurchase)) {
                    android.util.Log.d(TAG, "We have gas. Consuming it.");
                    try {
                        mHelper.consumeAsync(inventory.getPurchase(SKU_Riddle5), mConsumeFinishedListener);
                    } catch (IabHelper.IabAsyncInProgressException e) {
                        complain("Error consuming gas. Another async operation in progress.");
                    }
                    return;
                }
            }//end for RIDDLE 5 perchase

            //************for RIDDLE 6 perchase*********************
            if (riddleNumber==6){
                Purchase gasPurchase = inventory.getPurchase(SKU_Riddle6);
                android.util.Log.d(TAG, "Inventory Purchase " + gasPurchase);

                if (gasPurchase != null && verifyDeveloperPayload(gasPurchase)) {
                    android.util.Log.d(TAG, "We have gas. Consuming it.");
                    try {
                        mHelper.consumeAsync(inventory.getPurchase(SKU_Riddle6), mConsumeFinishedListener);
                    } catch (IabHelper.IabAsyncInProgressException e) {
                        complain("Error consuming gas. Another async operation in progress.");
                    }
                    return;
                }
            }//end for RIDDLE 6 perchase

            //************for RIDDLE 7 perchase*********************
            if (riddleNumber==7){
                Purchase gasPurchase = inventory.getPurchase(SKU_Riddle7);
                android.util.Log.d(TAG, "Inventory Purchase " + gasPurchase);

                if (gasPurchase != null && verifyDeveloperPayload(gasPurchase)) {
                    android.util.Log.d(TAG, "We have gas. Consuming it.");
                    try {
                        mHelper.consumeAsync(inventory.getPurchase(SKU_Riddle7), mConsumeFinishedListener);
                    } catch (IabHelper.IabAsyncInProgressException e) {
                        complain("Error consuming gas. Another async operation in progress.");
                    }
                    return;
                }
            }//end for RIDDLE 7 perchase




            setWaitScreen(false);
            android.util.Log.d(TAG, "Initial inventory query finished; enabling main UI.");
        }
    };

    // Called when consumption is complete
    IabHelper.OnConsumeFinishedListener mConsumeFinishedListener = new IabHelper.OnConsumeFinishedListener() {
        public void onConsumeFinished(Purchase purchase, IabResult result) {
            android.util.Log.d(TAG, "Consumption finished. Purchase: " + purchase + ", result: " + result);

            // if we were disposed of in the meantime, quit.
            if (mHelper == null) return;

            // We know this is the "gas" sku because it's the only one we consume,
            // so we don't check which sku was consumed. If you have more than one
            // sku, you probably should check...
            if (result.isSuccess()) {
                // successfully consumed, so we apply the effects of the item in our
                // game world's logic, which in our case means filling the gas tank a bit
                android.util.Log.d(TAG, "Consumption successful. Provisioning.");
                //mTank = mTank == TANK_MAX ? TANK_MAX : mTank + 1;
                //saveData();
                alert("You have successfully bought Shirt Phone");

                onSuccessShirtBought();
//                DialogForCustomerInfo();



                //alert("You filled 1/4 tank. Your tank is now " + String.valueOf(mTank) + "/4 full!");
            }
            else {
                complain("Error while consuming: " + result);
            }
            //updateUi();

            setWaitScreen(false);
            android.util.Log.d(TAG, "End consumption flow.");
        }
    };


    void complain(String message) {
        android.util.Log.e(TAG, "**** TrivialDrive Error: " + message);
        alert("Error: " + message);
    }


    void alert(String message) {
        AlertDialog.Builder bld = new AlertDialog.Builder(this);
        bld.setMessage(message);
        bld.setNeutralButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        android.util.Log.d(TAG, "Showing alert dialog: " + message);
        bld.setCancelable(false);
        bld.create().show();
    }


    //************************************ Starts for methods for buy RIDDLE x ************************************

    //buy RIDDLE 1
    public void buyRiddle1(){
        if (mSubscribedToInfiniteGas) {
            complain("No need! You're subscribed to infinite gas. Isn't that awesome?");
            return;
        }


        // launch the gas purchase UI flow.
        // We will be notified of completion via mPurchaseFinishedListener
        setWaitScreen(true);
        android.util.Log.d(TAG, "Launching purchase flow for gas.");

        /* TODO: for security, generate your payload here for verification. See the comments on
         *        verifyDeveloperPayload() for more info. Since this is a SAMPLE, we just use
         *        an empty string, but on a production app you should carefully generate this. */
        String payload = "";
        android.util.Log.e("testTag", "Buy Call");
        RandomString randomString = new RandomString(36);
        devPayLoad = randomString.nextString();
        payload = devPayLoad;

        try {
            mHelper.launchPurchaseFlow(this, SKU_Riddle1, RC_REQUEST,
                    mPurchaseFinishedListener, payload);
        } catch (IabHelper.IabAsyncInProgressException e) {
            complain("Error launching purchase flow. Another async operation in progress.");
            setWaitScreen(false);
        }
    }//end of Riddle1


    //buy Riddle 2
    public void buyRiddle2(){
        if (mSubscribedToInfiniteGas) {
            complain("No need! You're subscribed to infinite gas. Isn't that awesome?");
            return;
        }


        // launch the gas purchase UI flow.
        // We will be notified of completion via mPurchaseFinishedListener
        setWaitScreen(true);
        android.util.Log.d(TAG, "Launching purchase flow for gas.");

        /* TODO: for security, generate your payload here for verification. See the comments on
         *        verifyDeveloperPayload() for more info. Since this is a SAMPLE, we just use
         *        an empty string, but on a production app you should carefully generate this. */
        String payload = "";
        android.util.Log.e("testTag", "Buy Call");
        RandomString randomString = new RandomString(36);
        devPayLoad = randomString.nextString();
        payload = devPayLoad;

        try {
            mHelper.launchPurchaseFlow(this, SKU_Riddle2, RC_REQUEST,
                    mPurchaseFinishedListener, payload);
        } catch (IabHelper.IabAsyncInProgressException e) {
            complain("Error launching purchase flow. Another async operation in progress.");
            setWaitScreen(false);
        }
    }//end of Riddle2

    //buy Riddle 3
    public void buyRiddle3(){
        if (mSubscribedToInfiniteGas) {
            complain("No need! You're subscribed to infinite gas. Isn't that awesome?");
            return;
        }


        // launch the gas purchase UI flow.
        // We will be notified of completion via mPurchaseFinishedListener
        setWaitScreen(true);
        android.util.Log.d(TAG, "Launching purchase flow for gas.");

        /* TODO: for security, generate your payload here for verification. See the comments on
         *        verifyDeveloperPayload() for more info. Since this is a SAMPLE, we just use
         *        an empty string, but on a production app you should carefully generate this. */
        String payload = "";
        android.util.Log.e("testTag", "Buy Call");
        RandomString randomString = new RandomString(36);
        devPayLoad = randomString.nextString();
        payload = devPayLoad;

        try {
            mHelper.launchPurchaseFlow(this, SKU_Riddle3, RC_REQUEST,
                    mPurchaseFinishedListener, payload);
        } catch (IabHelper.IabAsyncInProgressException e) {
            complain("Error launching purchase flow. Another async operation in progress.");
            setWaitScreen(false);
        }
    }//end of Riddle3

    //buy Riddle 4
    public void buyRiddle4(){
        if (mSubscribedToInfiniteGas) {
            complain("No need! You're subscribed to infinite gas. Isn't that awesome?");
            return;
        }


        // launch the gas purchase UI flow.
        // We will be notified of completion via mPurchaseFinishedListener
        setWaitScreen(true);
        android.util.Log.d(TAG, "Launching purchase flow for gas.");

        /* TODO: for security, generate your payload here for verification. See the comments on
         *        verifyDeveloperPayload() for more info. Since this is a SAMPLE, we just use
         *        an empty string, but on a production app you should carefully generate this. */
        String payload = "";
        android.util.Log.e("testTag", "Buy Call");
        RandomString randomString = new RandomString(36);
        devPayLoad = randomString.nextString();
        payload = devPayLoad;

        try {
            mHelper.launchPurchaseFlow(this, SKU_Riddle4, RC_REQUEST,
                    mPurchaseFinishedListener, payload);
        } catch (IabHelper.IabAsyncInProgressException e) {
            complain("Error launching purchase flow. Another async operation in progress.");
            setWaitScreen(false);
        }
    }//end of Riddle4

    //buy Riddle 5
    public void buyRiddle5(){
        if (mSubscribedToInfiniteGas) {
            complain("No need! You're subscribed to infinite gas. Isn't that awesome?");
            return;
        }


        // launch the gas purchase UI flow.
        // We will be notified of completion via mPurchaseFinishedListener
        setWaitScreen(true);
        android.util.Log.d(TAG, "Launching purchase flow for gas.");

        /* TODO: for security, generate your payload here for verification. See the comments on
         *        verifyDeveloperPayload() for more info. Since this is a SAMPLE, we just use
         *        an empty string, but on a production app you should carefully generate this. */
        String payload = "";
        android.util.Log.e("testTag", "Buy Call");
        RandomString randomString = new RandomString(36);
        devPayLoad = randomString.nextString();
        payload = devPayLoad;

        try {
            mHelper.launchPurchaseFlow(this, SKU_Riddle5, RC_REQUEST,
                    mPurchaseFinishedListener, payload);
        } catch (IabHelper.IabAsyncInProgressException e) {
            complain("Error launching purchase flow. Another async operation in progress.");
            setWaitScreen(false);
        }
    }//end of Riddle5

    //buy Riddle 6
    public void buyRiddle6(){
        if (mSubscribedToInfiniteGas) {
            complain("No need! You're subscribed to infinite gas. Isn't that awesome?");
            return;
        }


        // launch the gas purchase UI flow.
        // We will be notified of completion via mPurchaseFinishedListener
        setWaitScreen(true);
        android.util.Log.d(TAG, "Launching purchase flow for gas.");

        /* TODO: for security, generate your payload here for verification. See the comments on
         *        verifyDeveloperPayload() for more info. Since this is a SAMPLE, we just use
         *        an empty string, but on a production app you should carefully generate this. */
        String payload = "";
        android.util.Log.e("testTag", "Buy Call");
        RandomString randomString = new RandomString(36);
        devPayLoad = randomString.nextString();
        payload = devPayLoad;

        try {
            mHelper.launchPurchaseFlow(this, SKU_Riddle6, RC_REQUEST,
                    mPurchaseFinishedListener, payload);
        } catch (IabHelper.IabAsyncInProgressException e) {
            complain("Error launching purchase flow. Another async operation in progress.");
            setWaitScreen(false);
        }
    }//end of Riddle6

    //buy Riddle 7
    public void buyRiddle7(){
        if (mSubscribedToInfiniteGas) {
            complain("No need! You're subscribed to infinite gas. Isn't that awesome?");
            return;
        }


        // launch the gas purchase UI flow.
        // We will be notified of completion via mPurchaseFinishedListener
        setWaitScreen(true);
        android.util.Log.d(TAG, "Launching purchase flow for gas.");

        /* TODO: for security, generate your payload here for verification. See the comments on
         *        verifyDeveloperPayload() for more info. Since this is a SAMPLE, we just use
         *        an empty string, but on a production app you should carefully generate this. */
        String payload = "";
        android.util.Log.e("testTag", "Buy Call");
        RandomString randomString = new RandomString(36);
        devPayLoad = randomString.nextString();
        payload = devPayLoad;

        try {
            mHelper.launchPurchaseFlow(this, SKU_Riddle7, RC_REQUEST,
                    mPurchaseFinishedListener, payload);
        } catch (IabHelper.IabAsyncInProgressException e) {
            complain("Error launching purchase flow. Another async operation in progress.");
            setWaitScreen(false);
        }
    }//end of Riddle7




    // Enables or disables the "please wait" screen.
    void setWaitScreen(boolean set) {

        Toast.makeText(getApplicationContext(), "Please Wait...", Toast.LENGTH_SHORT).show();

		/*findViewById(R.id.screen_main).setVisibility(set ? View.GONE : View.VISIBLE);
		findViewById(R.id.screen_wait).setVisibility(set ? View.VISIBLE : View.GONE);*/
    }

    /** Verifies the developer payload of a purchase. */
    boolean verifyDeveloperPayload(Purchase p) {
        String payload = p.getDeveloperPayload();

        /*
         * TODO: verify that the developer payload of the purchase is correct. It will be
         * the same one that you sent when initiating the purchase.
         *
         * WARNING: Locally generating a random string when starting a purchase and
         * verifying it here might seem like a good approach, but this will fail in the
         * case where the user purchases an item on one device and then uses your app on
         * a different device, because on the other device you will not have access to the
         * random string you originally generated.
         *
         * So a good developer payload has these characteristics:
         *
         * 1. If two different users purchase an item, the payload is different between them,
         *    so that one user's purchase can't be replayed to another user.
         *
         * 2. The payload must be such that you can verify it even when the app wasn't the
         *    one who initiated the purchase flow (so that items purchased by the user on
         *    one device work on other devices owned by the user).
         *
         * Using your own server to store and verify developer payloads across app
         * installations is recommended.
         */

        return true;
    }
}
