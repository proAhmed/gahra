package com.gahra.ahmed.gahra.api;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import com.gahra.ahmed.gahra.R;
import com.gahra.ahmed.gahra.controller.StoreData;
import com.gahra.ahmed.gahra.interfaces.OnLoadingComplete;
import com.gahra.ahmed.gahra.model.UserInput;
import com.gahra.ahmed.gahra.model.UsersModelMain;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.InputStreamEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;



public class SignUpApi extends AsyncTask<Object, Void, UsersModelMain> {

	private final static String URL = "http://ai5adma.com/API/ar/profile/register";
	private ProgressDialog dialog;
	private OnLoadingComplete callback;
	private Context context;

	public SignUpApi(Context context, OnLoadingComplete cb) {
		dialog = new ProgressDialog(context);
		callback = cb;
		this.context = context;
	}

	@Override
	protected void onPreExecute() {
		this.dialog.setMessage(context.getResources().getString(
				R.string.loading)
		);

		this.dialog.setCancelable(false);
		this.dialog.show();
	}

	@Override
	protected UsersModelMain doInBackground(Object... params) {
		String responseJSON = null;
		UsersModelMain obj = null;

		try {
			responseJSON = makeRequest((UserInput) params[0]);
			Log.d("vvvooo11",responseJSON);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Gson gson = new Gson();
		if (responseJSON != null && responseJSON.length() > 1) {

			GsonBuilder gb = new GsonBuilder();
			gb.serializeNulls();
			gson = gb.create();
			try {
				obj = gson.fromJson(responseJSON, UsersModelMain.class);
			} catch (com.google.gson.JsonSyntaxException ex) {
				ex.printStackTrace();
			}

		}

		return obj;
	}

	@Override
	protected void onPostExecute(UsersModelMain result) {
		if (dialog.isShowing()) {
			dialog.dismiss();
		}
		if (result != null) {
			callback.onSuccess(result);
		} else {
			callback.onFailure();
		}
	}

	public   String makeRequest(UserInput user) throws Exception {

		DefaultHttpClient httpclient = new DefaultHttpClient();
		HttpPost httpPost = new HttpPost(URL);
		StringBuilder total = new StringBuilder();
		JSONObject json = new JSONObject();

		json.put("FullName",user.getFullName());
		json.put("UserName", user.getUserName());

		json.put("Password", user.getPassword());
		json.put("Email",user.getEmail());
		json.put("Mobile",user.getMobile());
		json.put("Picture",user.getPicture());
	//	json.put("City",user.getCity());
		json.put("DeviceType","1");
		json.put("DeviceToken",new StoreData(context).getDeviceId());
		JSONArray jsonArray = new JSONArray();
//		if(cartQuantities.size()>0){
//		for(int ii=0;cartQuantities.size()>ii;ii++){
//			JSONObject jsons = new JSONObject();
//			jsons.put("ID",cartQuantities.get(ii).getProductID());
//			jsons.put("Quantity",cartQuantities.get(ii).getcQuantity());
//			jsons.put("CreatedDate", Utility.getCurrentTimeStamp());
//			jsonArray.put(jsons);
//		}
//
//		json.put("CartItems",jsonArray);}
		Log.d("signup", json.toString());
		InputStreamEntity entity = null;
		try {
			InputStream is = new ByteArrayInputStream(json.toString().getBytes(
					"UTF-8"));

			entity = new InputStreamEntity(is, is.available());

		} catch (IOException e) {

			e.printStackTrace();
		}

		httpPost.setEntity(entity);

		httpPost.setHeader("Content-type", "application/json");
		httpPost.setHeader("Cookie", "PHPSESSID=" + "9354ce815904a4d8156cd9316dcf97ca");
		HttpResponse response = httpclient.execute(httpPost);

		if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {

			InputStream instream = response.getEntity().getContent();
			BufferedReader r = new BufferedReader(new InputStreamReader(
					instream), 8000);
			String line;
			while ((line = r.readLine()) != null) {
				total.append(line);
			}
			instream.close();
		}
		return total.toString();

	}
}
