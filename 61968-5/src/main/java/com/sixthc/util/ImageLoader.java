package com.sixthc.util;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;

import org.apache.log4j.Logger;

import com.google.common.io.ByteStreams;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class ImageLoader {
	static Logger log = Logger.getLogger(ImageLoader.class);

	public static void getImage(String url, String filename)
			throws ImageLoadFileException {
		WebResource resource = Client.create().resource(url);
		log.debug("save image : url = " + url + ", filename = " + filename);

		try {
			ClientResponse response = resource.get(ClientResponse.class);
			int r = response.getStatus();

			if (r != 200) {
				throw new ImageLoadFileException("image server returned code ("
						+ r + ") for " + url);
			}
			InputStream stream = response.getEntityInputStream();
			byte[] bytes;

			bytes = ByteStreams.toByteArray(stream);

			BufferedOutputStream bos = null;

			// create an object of FileOutputStream
			FileOutputStream fos;

			fos = new FileOutputStream(new File("/data/openwms/files/" + filename));
			// create an object of BufferedOutputStream
			bos = new BufferedOutputStream(fos);
			bos.write(bytes);
			bos.close();
			log.debug("url : " + url + ", filename : " + filename
					+ ", images bytes read : " + bytes.length);
		} catch (ImageLoadFileException fe) {
			log.error(fe);
			throw fe;
		}
		catch (Exception e) {
			log.error(e);
			throw new ImageLoadFileException("load for url " + url + " failed.", e);
		}
	}
	
	public static String DetermineFileExtension(String url) {
		String last3;
		if (url == null || url.length() < 3) {
			return "unk";
		}

		last3 = url.substring(url.length() - 3).toUpperCase();
		return last3;
	}

	public static String DetermineAttachmentType(String url) {
		String last3;
		if (url == null || url.length() < 3) {
			return "image";
		}

		last3 = url.substring(url.length() - 3).toUpperCase();

		if (last3.equals("JPG") || last3.equals("PNG") || last3.equals("GIF")
				|| last3.equals("JPEG")) {
			return "image";
		} else if (last3.equals("MP4") || last3.equals("MPG")) {
			return "video";
		}

		return "image";
	}
}
