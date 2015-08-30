package framework;
import java.util.List;


public class ClassDetailVO {
	
	String srcFileName;
	String testFileName;
	List<String> methodList;
	
	public String getSrcFileName() {
		return srcFileName;
	}
	public void setSrcFileName(String srcFileName) {
		this.srcFileName = srcFileName;
	}
	public String getTestFileName() {
		return testFileName;
	}
	public void setTestFileName(String testFileName) {
		this.testFileName = testFileName;
	}
	public List<String> getMethodList() {
		return methodList;
	}
	public void setMethodList(List<String> methodList) {
		this.methodList = methodList;
	}
	
	 @Override
	    public String toString()
	    {
	        return "ClassDetailVO [srcFileName=" + srcFileName + ", testFileName=" + testFileName
	                + ", methodList=" + methodList + "]";
	    }
	
}
