package com.gahra.ahmed.gahra.api;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import com.gahra.ahmed.gahra.R;
import com.gahra.ahmed.gahra.interfaces.OnLoadingComplete;
import com.gahra.ahmed.gahra.model.OfferModelMain;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;


public class GetOfferById extends AsyncTask<String, Void, OfferModelMain> {

	private   String finalUrl =  "http://aljahrashop.com/API/ar/offer/c/";
	private ProgressDialog dialog;
	private OnLoadingComplete callback;
	private Context context;

	public GetOfferById(Context context, OnLoadingComplete cb,int id) {
		dialog = new ProgressDialog(context);
		callback = cb;
		this.context = context;
		finalUrl = finalUrl+id;
  	}

	@Override
	protected void onPreExecute() {
		this.dialog.setMessage(context.getResources().getString(
				R.string.loading));
		this.dialog.setCancelable(false);
		this.dialog.show();
	}

	@Override
	protected OfferModelMain doInBackground(String... params) {

		String responseJSON = null;
		try {
			responseJSON = invokeJSONWS();
			Log.d("uuuu",responseJSON);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Gson gson = new Gson();

		OfferModelMain obj = null;
		if (responseJSON != null && responseJSON.length() > 1) {

			GsonBuilder gb = new GsonBuilder();
			gb.serializeNulls();
			gson = gb.create();
			try {
				obj = gson.fromJson(responseJSON, OfferModelMain.class);
			} catch (com.google.gson.JsonSyntaxException ex) {
				ex.printStackTrace();
			}
		}
		return obj;

	}

	@Override
	protected void onPostExecute(OfferModelMain result) {
		if (dialog.isShowing()) {
			dialog.dismiss();
		}
		if (result != null) {
			callback.onSuccess(result);
		} else {
			callback.onFailure();
		}
	}

	private String invokeJSONWS() throws IOException {
		HttpURLConnection httpConn = null;

		InputStream in = null;
		int response = -1;
		String responseJSON;
		URL url = new URL(finalUrl);
		URLConnection conn = url.openConnection();
		if (!(conn instanceof HttpURLConnection))
			throw new IOException("Not an HTTP connection");

		try {
			  httpConn = (HttpURLConnection) conn;
			httpConn.setRequestMethod("GET");
			httpConn.setDoInput(true);
			httpConn.setDoOutput(true);

			httpConn.connect();

			response = httpConn.getResponseCode();

			if (response == HttpURLConnection.HTTP_OK) {
				in = conn.getInputStream();
			}

			BufferedReader reader = new BufferedReader(
					new InputStreamReader(in));
			StringBuilder out = new StringBuilder();
			String line;
			while ((line = reader.readLine()) != null) {
				out.append(line);
			}

			responseJSON = out.toString();

		} catch (Exception e) {
			throw new IOException("Error connecting");
		}finally {
			httpConn.disconnect();
		}
		return responseJSON;
	}
}
