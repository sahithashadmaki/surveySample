package SurveyApplication;

import java.util.ArrayList;
import java.util.List;

public class AdminInfoClass extends UserInfo {
List<CommonDetails> list=new ArrayList<>();

public List<CommonDetails> getList() {
	return list;
}

public void setList(List<CommonDetails> list) {
	this.list = list;
}


}
