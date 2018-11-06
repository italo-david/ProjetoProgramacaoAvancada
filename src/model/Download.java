package model;

import java.io.File;
import java.net.URL;

import handler.IDownRequestListener;

public class Download {
	
		private final URL url;
	    private final int type;
	    private final File file;
	    
	    private final IDownRequestListener listener;

	    private Download(DownloadBuilder builder) {
	        this.url = builder.url;
	        this.type = builder.type;
	        this.file = builder.path;
	        this.listener = builder.listener;
	    }

	    public URL getUrl() {
	        return url;
	    }

	    public int getType() {
	        return type;
	    }

	    public File getFile() {
	        return file;
	    }

	    public IDownRequestListener getListener() {
	        return listener;
	    }

	    public static class DownloadBuilder {
	        private final URL url;
	        private final IDownRequestListener listener;
	        private int type;
	        private File path;

	        public DownloadBuilder(URL url, IDownRequestListener listener) {
	            this.url = url;
	            this.listener = listener;
	        }

	        public DownloadBuilder withPath(File file) {
	            this.path = file;

	            return this;
	        }

	        public DownloadBuilder withType(int type) {
	            this.type = type;

	            return this;
	        }

	        public Download build() {
	            return new Download(this);
	        }
	    }
}
