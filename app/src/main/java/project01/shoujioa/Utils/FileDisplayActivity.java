package project01.shoujioa.Utils;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import okhttp3.ResponseBody;
import project01.shoujioa.R;


public class FileDisplayActivity extends AppCompatActivity implements View.OnClickListener{


    private String TAG = "FileDisplayActivity";
    SuperFileView2 mSuperFileView;

    String filePath;
    private TextView getback;
    private TextView name_text;
    private Button image_btn;
    private TextView text_title;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_file_display);
        initViews();
    }


    public void initViews() {

        image_btn = findViewById(R.id.img_btn);//关闭页
        image_btn.setOnClickListener(this);
        text_title = findViewById(R.id.title_text);//标题
        text_title.setText("附件预览");
        mSuperFileView = (SuperFileView2) findViewById(R.id.mSuperFileView);
        mSuperFileView.setOnGetFilePathListener(mSuperFileView2 -> getFilePathAndShowFile(mSuperFileView2));
        Intent intent = this.getIntent();
        String path = (String) intent.getSerializableExtra("path");

        if (!TextUtils.isEmpty(path)) {
            TLog.d(TAG, "文件path:" + path);
            setFilePath(path);
        }
        mSuperFileView.show();
    }




    private void getFilePathAndShowFile(SuperFileView2 mSuperFileView2) {

        //1.网络下载、存储路径、
        File cacheFile = getCacheFile(getFilePath());
        if (cacheFile.exists()) {

            if (cacheFile.length() <= 0) {
                TLog.e(TAG, "删除空文件！！");
                cacheFile.delete();
                return;
            }else{
                Log.e("存在","展示");
                Log.e("文件路径",cacheFile.getAbsolutePath());
                mSuperFileView2.displayFile(cacheFile);
                return;
            }
        }

        ProgressUtils.showProgress(this,"正在加载文件");

        if (getFilePath().contains("http")) {//网络地址要先下载
            DownUtils.get().download(getFilePath(), new DownUtils.OnDownloadListener() {
                @Override
                public void onDownloadSuccess(File file) {
                    runOnUiThread(() -> mSuperFileView2.displayFile(file));
                }

                @Override
                public void onDownloading(int progress) {
                    if (progress==100){
                        ProgressUtils.stopProgress();
                    }

                }

                @Override
                public void onDownloadFailed(Exception e) {
                    runOnUiThread(() -> {
                        Toast.makeText(FileDisplayActivity.this,e.getMessage(),Toast.LENGTH_SHORT).show();
                        ProgressUtils.stopProgress();
                    });


                }
            });


           // downLoadFromNet(getFilePath(), mSuperFileView2);

        } else {
            mSuperFileView2.displayFile(new File(getFilePath()));
        }
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        TLog.d("FileDisplayActivity-->onDestroy");
        if (mSuperFileView != null) {
            mSuperFileView.onStopDisplay();
        }
    }


    public static void show(Context context, String url) {
        Intent intent = new Intent(context, FileDisplayActivity.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable("path", url);
        intent.putExtras(bundle);
        context.startActivity(intent);

    }

    public void setFilePath(String fileUrl) {
        this.filePath = fileUrl;
    }

    private String getFilePath() {
        return filePath;
    }



    /***
     * 获取缓存目录
     *
     * @param url
     * @return
     */
    private File getCacheDir(String url) {

        return new File(Environment.getExternalStorageDirectory().getAbsolutePath() + "/007/");

    }
    /***
     * 绝对路径获取缓存文件
     *
     * @param url
     * @return
     */
    private File getCacheFile(String url) {
        File cacheFile = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + "/007/"
                + getFileName(url));
        TLog.e(TAG, "缓存文件 = " + cacheFile.toString());
        return cacheFile;
    }

    /***
     * 根据链接获取文件名（带类型的），具有唯一性
     *
     * @param url
     * @return
     */
    private String getFileName(String url) {
        String fileName = Md5Tool.hashKey(url) + "." + getFileType(url);
        return fileName;
    }

    /***
     * 获取文件类型
     *
     * @param paramString
     * @return
     */
    private String getFileType(String paramString) {
        String str = "";

        if (TextUtils.isEmpty(paramString)) {
            TLog.d(TAG, "paramString---->null");
            return str;
        }
        TLog.d(TAG,"paramString:"+paramString);
        int i = paramString.lastIndexOf('.');
        if (i <= -1) {
            TLog.d(TAG,"i <= -1");
            return str;
        }


        str = paramString.substring(i + 1);
        TLog.d(TAG,"paramString.substring(i + 1)------>"+str);
        return str;
    }


    @Override
    public void onClick(View v) {
        if (v==image_btn){
            finish();
        }

    }
}
