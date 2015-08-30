package framework;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringEscapeUtils;

import com.github.javaparser.ASTHelper;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration;
import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.ast.body.ModifierSet;
import com.github.javaparser.ast.expr.FieldAccessExpr;
import com.github.javaparser.ast.expr.MethodCallExpr;
import com.github.javaparser.ast.expr.NameExpr;
import com.github.javaparser.ast.expr.StringLiteralExpr;
import com.github.javaparser.ast.stmt.BlockStmt;

public class TestCasesTemplate {

	
	private static String getClassName(String srcName) {

		StringBuilder sb = new StringBuilder();
		String className = null;
		for (int i = srcName.length() - 1; i >= 0; i--) {
			if (srcName.charAt(i) != '\\') {
				sb.append(srcName.charAt(i));
			} else {
				break;
			}
		}
		className = sb.reverse().toString();
		String[] names = className.split("\\.");
		className = names[0].toString();
		return className;
	}
	
	private static String getMethodName(String methodDeclaration) {

		String methodName = null;
		StringBuilder sb = new StringBuilder();
		for (int i = methodDeclaration.indexOf("("); i >= 0; i--) {
			if (methodDeclaration.charAt(i) != ' ') {
				sb.append(methodDeclaration.charAt(i));
			} else {
				break;
			}
		}
		sb.reverse();
		sb.setLength(sb.length() - 1);
		methodName = sb.toString();
		methodName = methodName.substring(0, 1).toUpperCase() + methodName.substring(1);
		return methodName;
	}
	
	private static CompilationUnit createTestTemplate(ClassDetailVO classDetailObj) {
		
		CompilationUnit cu = new CompilationUnit();
        // set the package
        //cu.setPackage(new PackageDeclaration(ASTHelper.createNameExpr("java.parser.test")));

        // create the type declaration 
        ClassOrInterfaceDeclaration type = new ClassOrInterfaceDeclaration(ModifierSet.PUBLIC, false, getClassName(classDetailObj.getTestFileName()));
        ASTHelper.addTypeDeclaration(cu, type);
       
        
       //create a method
        for(String methodDeclaration: classDetailObj.getMethodList()){
        	
       	 	MethodDeclaration method = new MethodDeclaration(ModifierSet.PUBLIC, ASTHelper.VOID_TYPE, "testSuccess" + getMethodName(methodDeclaration));
             method.setModifiers(ModifierSet.addModifier(method.getModifiers(), 0));
             ASTHelper.addMember(type, method);
   
             // add a parameter to the method
             //Parameter param = ASTHelper.createParameter(ASTHelper.createReferenceType("String", -1), "value");
             //ASTHelper.addParameter(method, param);
             
             BlockStmt block = new BlockStmt();
             method.setBody(block);
             NameExpr clazz = new NameExpr("System");
             FieldAccessExpr field = new FieldAccessExpr(clazz, "out");
             MethodCallExpr call = new MethodCallExpr(field, "println");
             ASTHelper.addArgument(call, new StringLiteralExpr(getMethodName(methodDeclaration)));
             ASTHelper.addStmt(block, call);
             
             NameExpr expr = ASTHelper.createNameExpr("a = 5");
             NameExpr expr2 = ASTHelper.createNameExpr("b = 5");
             NameExpr expr3 = ASTHelper.createNameExpr(getClassName(classDetailObj.getSrcFileName()) + " instance = new " + getClassName(classDetailObj.getSrcFileName()) + "()");
             NameExpr expr4 = ASTHelper.createNameExpr("int expresult=0");
             NameExpr expr5 = ASTHelper.createNameExpr("Long result = instance.subOpr(a, b)");
             NameExpr expr6 = ASTHelper.createNameExpr("assertEquals(expResult, result)");
             NameExpr expr7 = ASTHelper.createNameExpr("//TODO review the generated test code and remove the default call to fail.");
             NameExpr expr8 = ASTHelper.createNameExpr(StringEscapeUtils.escapeJava("fail"+"("+"The test case is a prototype."+")"));
             
             ASTHelper.addStmt(block, expr);
             ASTHelper.addStmt(block, expr2);
             ASTHelper.addStmt(block, expr3);
             ASTHelper.addStmt(block, expr4);
             ASTHelper.addStmt(block, expr5);
             ASTHelper.addStmt(block, expr6);
             ASTHelper.addStmt(block, expr7);
             ASTHelper.addStmt(block, expr8);
             
             MethodDeclaration method2 = new MethodDeclaration(ModifierSet.PUBLIC, ASTHelper.VOID_TYPE, "testFailure" + getMethodName(methodDeclaration));
             method2.setModifiers(ModifierSet.addModifier(method2.getModifiers(), 0));
             ASTHelper.addMember(type, method2);
   
             // add a parameter to the method
             //Parameter param = ASTHelper.createParameter(ASTHelper.createReferenceType("String", -1), "value");
             //ASTHelper.addParameter(method, param);
             
             BlockStmt block2 = new BlockStmt();
             method2.setBody(block2);
             NameExpr clazz2 = new NameExpr("System");
             FieldAccessExpr field2 = new FieldAccessExpr(clazz2, "out");
             MethodCallExpr call2 = new MethodCallExpr(field2, "println");
             ASTHelper.addArgument(call2, new StringLiteralExpr(getMethodName(methodDeclaration)));
             ASTHelper.addStmt(block2, call2);
             
             NameExpr failureExpr1 = ASTHelper.createNameExpr("a = 5");
             NameExpr failureExpr2 = ASTHelper.createNameExpr("b = 5");
             NameExpr failureExpr3 = ASTHelper.createNameExpr(getClassName(classDetailObj.getSrcFileName()) + " instance = new " + getClassName(classDetailObj.getSrcFileName()) + "()");
             NameExpr failureExpr4 = ASTHelper.createNameExpr("int expresult=0");
             NameExpr failureExpr5 = ASTHelper.createNameExpr("Long result = instance.subOpr(a, b)");
             NameExpr failureExpr6 = ASTHelper.createNameExpr("assertNotSame(unexpResult, result);");
             NameExpr failureExpr7 = ASTHelper.createNameExpr("//TODO review the generated test code and remove the default call to fail.");
             NameExpr failureExpr8 = ASTHelper.createNameExpr(StringEscapeUtils.escapeJava("fail"+"("+"The test case is a prototype."+")"));
             
             ASTHelper.addStmt(block2, failureExpr1);
             ASTHelper.addStmt(block2, failureExpr2);
             ASTHelper.addStmt(block2, failureExpr3);
             ASTHelper.addStmt(block2, failureExpr4);
             ASTHelper.addStmt(block2, failureExpr5);
             ASTHelper.addStmt(block2, failureExpr6);
             ASTHelper.addStmt(block2, failureExpr7);
             ASTHelper.addStmt(block2, failureExpr8);

        }
        
        System.out.println(cu.toString());
		
		return cu;
	
	}
	/**
     * creates the Junit Test Cases Template
     * @param classDetailObj 
     */
    public CompilationUnit createTemplate(List<ClassDetailVO> classDetailObj) {
    	
    	
    	
    	CompilationUnit cu = new CompilationUnit(); 
    	Map<String, ArrayList<String>> testClassTemplate = new HashMap<String, ArrayList<String>>();
    	ArrayList<String> sampleList = new ArrayList<String>();
    	System.out.println(classDetailObj.getClass().getName()+ "======+++++++");classDetailObj.getClass().getName();
    	for(ClassDetailVO obj: classDetailObj){
    		
    		System.out.println(getClassName(obj.getSrcFileName())+ "======Src File Name\n");
    		System.out.println(getClassName(obj.getTestFileName())+ "======TestFileName\n");
    		System.out.println(obj.getMethodList()+ "======MethodList\n");
    		cu = createTestTemplate(obj);
    		
    		}
    
        return cu;
    }
    
    public Object getDefaultValue(Object dataType){
    	
    	
		return dataType;
    
    }

}
