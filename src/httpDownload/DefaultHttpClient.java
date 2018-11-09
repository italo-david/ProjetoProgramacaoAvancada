/*
 *    Copyright (C) 2017 MINDORKS NEXTGEN PRIVATE LIMITED
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */

package httpDownload;

import httpDownload.DownloadRequest;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.FileOutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

import org.apache.commons.io.FileUtils;

/**
 * Created by amitshekhar on 13/11/17.
 */

public class DefaultHttpClient implements HttpClient {

    private HttpURLConnection connection;
    private File path;

    public DefaultHttpClient() {

    }

    @SuppressWarnings("CloneDoesntCallSuperClone")
    @Override
    public HttpClient clone() {
        return new DefaultHttpClient();
    }

    @Override
    public void connect(DownloadRequest request) throws IOException {
        connection = (HttpURLConnection) request.getUrl().openConnection();
        connection.connect();

        path = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS) + request.getFileName() + request.getType());


        URLConvertToFile(url, file);


    }

    public static void URLConvertToFile(HttpURLConnection c,DownloadRequest d, File f) throws IOException {
        InputStream inputStream = c.getInputStream();

        FileUtils.copyURLToFile(d.getUrl(), f);
    }


}
