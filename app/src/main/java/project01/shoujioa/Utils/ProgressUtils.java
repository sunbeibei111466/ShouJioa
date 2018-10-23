package project01.shoujioa.Utils;

import android.app.ProgressDialog;
import android.content.Context;

public class ProgressUtils {

    private static ProgressDialog progressDialog;

    public static  void showProgress(Context context, String content){
        progressDialog = new ProgressDialog(context);
        progressDialog.setMessage(content);
        progressDialog.setCancelable(false);
        progressDialog.show();
    }
    public static  void stopProgress(){
        progressDialog.dismiss();
    }


}
