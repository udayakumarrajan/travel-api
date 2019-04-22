/**
 * 
 */
package com.afkl.cases.df.data.loader;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author udayakumar.rajan
 * @param <T>
 *
 */
@Component
public class JsonFileReader<T> implements FileReader<T> {

	/**
	 * To load data dynamically and return the corresponding model to the requester.
	 */
	@Override
	public List<T> loadFile(String filePath, TypeReference<List<T>> type)
			throws JsonParseException, JsonMappingException, IOException {
		ObjectMapper jsonMapper = new ObjectMapper();

		InputStream in = this.getClass().getClassLoader().getResourceAsStream(filePath);

		return jsonMapper.readValue(in, type);
	}

}
