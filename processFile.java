package fileAccess;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class processFile {

	public StringBuilder buildStringFromFile(File file) {
		StringBuilder sb = new StringBuilder();
		try (Reader read = new FileReader(file); 
				BufferedReader in = new BufferedReader(read)) {
			try {
				String str;
				while((str = in.readLine()) != null){
				    if(!str.equals(""))
				    sb.append(str).append(",");
				}
			} finally {
				in.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return sb;
		
	}
	
}
