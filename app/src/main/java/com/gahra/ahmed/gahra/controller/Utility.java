package com.gahra.ahmed.gahra.controller;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import com.gahra.ahmed.gahra.R;

/**
 * Created by ahmed on 2/18/2017.
 */
public class Utility {

    public static boolean isNetworkConnected(Context context) {
        ConnectivityManager cm = (ConnectivityManager) context
                .getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo ni = cm.getActiveNetworkInfo();
        if (ni == null) {
            // There are no active networks.
            return false;
        } else
            return true;
    }
    public static void showFailureDialog(Context mContext, final boolean back) {

        final AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
                mContext);

        alertDialogBuilder
                .setMessage(
                        mContext.getResources().getString(R.string.failure_ws))
                .setCancelable(false)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        alertDialogBuilder.setCancelable(true);
                        if (back) {
                            //      Utility.deleteFormBackStack();
                        }
                    }
                });
        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }

    public static void showValidateDialog(String message, Context mContext) {

        final AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
                mContext);

        alertDialogBuilder.setMessage(message).setCancelable(false)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        alertDialogBuilder.setCancelable(true);
                    }
                });
        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }

}
