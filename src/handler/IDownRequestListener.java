package handler;

import java.io.File;

public interface IDownRequestListener {

    void onDownloadSuccess(File path);

    void onDownloadFailed();
}
