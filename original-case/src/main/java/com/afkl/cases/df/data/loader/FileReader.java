/**
 * 
 */
package com.afkl.cases.df.data.loader;

import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;

/**
 * @author udayakumar.rajan
 *
 */
public interface FileReader <T> {
	
	/**
	 * To load the data from mock file which is located in the file path.
	 * @param filePath
	 * @return
	 * @throws JsonParseException
	 * @throws JsonMappingException
	 * @throws IOException
	 */
	public  List<T> loadFile(String filePath, TypeReference<List <T>> type) throws JsonParseException, JsonMappingException, IOException;
}
