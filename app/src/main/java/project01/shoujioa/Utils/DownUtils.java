package project01.shoujioa.Utils;

import android.os.Environment;
import android.text.TextUtils;
import android.util.Log;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.TimeUnit;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;


public class DownUtils {
    private static DownUtils downloadUtil;
    private String TAG = "DownUtils";
    private final OkHttpClient okHttpClient;


    public static DownUtils get() {

        if (downloadUtil == null) {

            downloadUtil = new DownUtils();

        }

        return downloadUtil;

    }


    private DownUtils() {
        okHttpClient = new OkHttpClient.Builder()
                .connectTimeout(600, TimeUnit.SECONDS )
                .readTimeout(600, TimeUnit.SECONDS)
                .build();

    }


    /**
     * @param url      下载连接
     * @param listener 下载监听
     */

    public void download(final String url, final OnDownloadListener listener) {

        Request request = new Request.Builder().url(url).build();

        okHttpClient.newCall(request).enqueue(new Callback() {

            @Override

            public void onFailure(Call call, IOException e) {

                // 下载失败监听回调

                listener.onDownloadFailed(e);

            }


            @Override

            public void onResponse(Call call, Response response) throws IOException {

                InputStream is = null;

                byte[] buf = new byte[2048];

                int len = 0;

                FileOutputStream fos = null;

                // 储存下载文件的目录

                try {

                    is = response.body().byteStream();

                    long total = response.body().contentLength();
                    File file1 = getCacheDir(url);
                    if (!file1.exists()) {
                        file1.mkdirs();
                        TLog.d(TAG, "创建缓存目录： " + file1.toString());
                    }


                    //fileN : /storage/emulated/0/pdf/kauibao20170821040512.pdf
                    File fileN = getCacheFile(url);//new File(getCacheDir(url), getFileName(url))

                    TLog.d(TAG, "创建缓存文件： " + fileN.toString());
                    if (!fileN.exists()) {
                        boolean mkdir = fileN.createNewFile();
                    }

                    fos = new FileOutputStream(fileN);

                    long sum = 0;

                    while ((len = is.read(buf)) != -1) {

                        fos.write(buf, 0, len);

                        sum += len;

                        int progress = (int) (sum * 1.0f / total * 100);

                        // 下载中更新进度条

                        listener.onDownloading(progress);

                    }

                    fos.flush();

                    // 下载完成

                    listener.onDownloadSuccess(fileN);

                } catch (Exception e) {

                    listener.onDownloadFailed(e);

                } finally {

                    try {

                        if (is != null)

                            is.close();

                    } catch (IOException e) {

                    }

                    try {

                        if (fos != null)

                            fos.close();

                    } catch (IOException e) {

                    }

                }

            }

        });

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
            Log.e(TAG, "paramString---->null");
            return str;
        }
        TLog.d(TAG, "paramString:" + paramString);
        int i = paramString.lastIndexOf('.');
        if (i <= -1) {
            TLog.d(TAG, "i <= -1");
            return str;
        }


        str = paramString.substring(i + 1);
        TLog.d(TAG, "paramString.substring(i + 1)------>" + str);
        return str;
    }


    public interface OnDownloadListener {

        /**
         * @param file 下载成功后的文件
         */

        void onDownloadSuccess(File file);


        /**
         * @param progress 下载进度
         */

        void onDownloading(int progress);


        /**
         * @param e 下载异常信息
         */

        void onDownloadFailed(Exception e);

    }
}
