package com.bytecodevelocity.readjson;

import java.io.File;
import java.io.FileReader;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

//com.googlecode.json-simple
public class ReadJsonFile {

	public static void main(String[] args) {
		String fileName = System.getProperty("user.dir")+"/src/com/bytecodevelocity/readjson/Test.json";
		File file = new File(fileName);
		JSONParser parser = new JSONParser();
		try {
			FileReader reader = new FileReader(file.getAbsolutePath());
			Object obj = parser.parse(reader);
			JSONObject jsonObj = (JSONObject) obj;
			JSONObject studentDetails = (JSONObject) jsonObj.get("studentDetails");
			System.out.println("studentDetails :" + studentDetails.toJSONString());

			String studentName = (String) studentDetails.get("name");
			System.out.println("StudentName :" + studentName);

			JSONArray subjects = (JSONArray) studentDetails.get("subjects");
			System.out.println("Subject List :" + subjects);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
