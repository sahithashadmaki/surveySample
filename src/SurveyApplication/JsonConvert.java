package SurveyApplication;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectWriter;

public class JsonConvert {
	 @JsonIgnore
	 public String getOptionsAsJSONString(ObjectWriter ow, String[] arr) throws JsonProcessingException{
	  return ow.writeValueAsString(arr);
	 }
}
