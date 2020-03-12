package com.itcast.crm.utils;

import java.util.UUID;

public class UploadUtils {
	
	public static String getUuidFileName(String fileName) {
		String extension = fileName.substring(fileName.lastIndexOf("."));
		String uuidString = UUID.randomUUID().toString().replace("-", "");
		return uuidString + extension;
	}
	
	public static String getPath(String uuidFilename) {
		int hash =  uuidFilename.hashCode();
		int d1 = hash & 0xf;
		int hash2 = hash >>> 4;
		int d2 = hash2 & 0xf;
		return "/" + d1 + "/" + d2;
	}

}
