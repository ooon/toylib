package com.common.util.fileutil;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class FileUtil {
	private static BufferedReader  bfr = null;
	
	public static List<String> getLines(String filename) throws Exception{
		bfr =  new BufferedReader(new InputStreamReader
				(new FileInputStream(filename) ,"utf-8"));
		List<String> urls = new ArrayList<String>()	;
		String line = null;
		while((line = bfr.readLine()) !=null)
		{
			if(line.trim().isEmpty()) continue;
			urls.add(line.trim());
		}
		bfr.close();
		return urls;
		
	}
	
}
