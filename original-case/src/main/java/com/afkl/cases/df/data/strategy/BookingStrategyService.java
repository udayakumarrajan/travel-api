/**
 * 
 */
package com.afkl.cases.df.data.strategy;

import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

/**
 * @author udayakumar.rajan
 *
 */
public interface BookingStrategyService<T>  {

	/**
	 * To load the data from mock file which is located in the file path.
	 * 
	 * @param filePath
	 * @return
	 * @throws IOException
	 * @throws JsonMappingException
	 * @throws JsonParseException
	 */
	public void loadFile();
	
	/**
	 * 
	 * @return
	 */
	public default List <T> getData () {
		return null;
	}
	
	/**
	 * 
	 * @param param
	 * @return
	 */
	public default List <T> filter (String param) {
		return null;
	}
	
	
}
