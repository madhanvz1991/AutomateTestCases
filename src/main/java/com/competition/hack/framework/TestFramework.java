package framework;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class TestFramework {
	public static List<String> fileList = new ArrayList<String>();
	private static List<String> testDirList = new ArrayList<String>();
	FrameworkService service=null;
	
	public static void main(String[] args) {
		getTemplate();
	}

	public static void getTemplate(){
		listSourceFile("H://17thJuly_DEV2_WS//AutomateTestCase//src//main//java");
		
		for (int i = 0; i < fileList.size(); i++) {
			//System.out.println(fileList.get(i));
			String temp = fileList.get(i);
			String removeMain = temp.replaceAll("main", "test");
			testDirList.add(removeMain.substring(0, removeMain.length() - 5)
					.concat("Test.java"));
		}
		
		FrameworkService service=new FrameworkService();
		TestCasesTemplate template = new TestCasesTemplate();
		List<ClassDetailVO> classDetailObj = service.createTestDirectory(testDirList);
		template.createTemplate(classDetailObj);
	}

	private static List<File> listSourceFile(String directoryName) {
		File directory = new File(directoryName);
		List<File> resultList = new ArrayList<File>();
		// get all the files from a directory
		File[] fList = directory.listFiles();
		resultList.addAll(Arrays.asList(fList));
		for (File file : fList) {
			if (file.isFile()) {
				if (file.getName().endsWith(".java")) {
					fileList.add(file.getAbsolutePath());
					//System.out.println(file.getAbsolutePath());
				}
			} else if (file.isDirectory()) {
				resultList.addAll(listSourceFile(file.getAbsolutePath()));
			}
		}
		return resultList;
	}

}
