package framework;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.github.javaparser.ast.CompilationUnit;

public class TestFramework {
	public static List<String> fileList = new ArrayList<String>();
	private static List<String> testDirList = new ArrayList<String>();
	FrameworkService service = null;

	public static void main(String[] args) {

		if (args != null && args.length > 0) {
			if (args[0] == null) {
				System.out.println("Error- please type a string");
			} else {
				System.out.println("test.....");
				System.out.println(args[0]);
				// System.out.println(args[1]);
				getTemplate(args[0]);
			}
		}else {
			getTemplate("H://17thJuly_DEV2_WS//AutomateTestCase//src//main//java");
		}

	}

	public static void getTemplate(String url) {
		listSourceFile(url);

		for (int i = 0; i < fileList.size(); i++) {
			// System.out.println(fileList.get(i));
			String temp = fileList.get(i);
			String removeMain = temp.replaceAll("main", "test");
			System.out.println("removeMain: " + removeMain);
			if (!removeMain.contains("framework")) {
				testDirList.add(removeMain
						.substring(0, removeMain.length() - 5).concat(
								"Test.java"));
			}
		}

		FrameworkService service = new FrameworkService();
		TestCasesTemplate template = new TestCasesTemplate();
		List<ClassDetailVO> classDetailObj = service
				.createTestDirectory(testDirList);
		// CompilationUnit cu = template.createTemplate(classDetailObj);
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
					// System.out.println(file.getAbsolutePath());
				}
			} else if (file.isDirectory()) {
				resultList.addAll(listSourceFile(file.getAbsolutePath()));
			}
		}
		return resultList;
	}

}
