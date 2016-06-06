package jp.co.opst.sql.builder;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * 文字列変換ユーティリティクラス
 * mainメソッドあるいは他プロジェクトより使用したいメソッドを呼び出してください。
 * 各メソッドの用途はメソッドのJavadocをご参照ください。
 *
 * @author Yui
 *
 */
public class ColumnConvertUtil {


    /**
     * convert呼び出し用mainメソッド
     * @param args コマンドライン引数(カラム名)
     * @throws IOException 
     */
    public static void main(String[] args) throws IOException {
    	
    	String workspaceDirectry = "/Users/ishino/git/java_utility/";
    	String projectName = "UtilProject";
    	String packageName = "jp.co.opst.test";
    	String packageDirectory = packageName.replaceAll("\\.", "/");
    	String className = "Entity";
//    	String fileName = className + ".java";
    	
    	String fileDirectory = workspaceDirectry + projectName + "/src/main/" + packageDirectory /* + "/" + fileName*/;
    	
        String columns = "GOODS_NUM, GOODS_NAME, GOODS_PRICE, GOODS_EXP, MAKER, REG_DATE, LST_UPDATE_TIME";
//        String columns = args[0];
        
        // コンソールに出力
//        printFieldFromCSVColumn(columns);
        
        // エンティティクラス
        createEntityClassFromCSVClolumn(fileDirectory, packageName, className, columns);
    }
    
    public static void createEntityClassFromCSVClolumn(String fileDirectory, String packageName, String className, String columns) throws IOException {
    	
    	System.out.println(fileDirectory);
    	File directory = new File(fileDirectory);
    	if (!directory.exists()) {
    		directory.mkdirs();
    	}
    	System.out.println(className);
//    	System.out.println(columns);
    	String[] columnArray = columns.split(",");
    	
    	File file = new File(fileDirectory + "/" + className + ".java");
    	if (!file.exists()) {
    		System.out.println("create new file");
        	file.createNewFile();
    	}
    	
    	BufferedWriter bw = new BufferedWriter(new FileWriter(file));
    	
    	bw.write("package " + packageName + ";");
    	bw.newLine();
    	bw.newLine();
    	bw.write("public class " + className + " {");
    	bw.newLine();
    	bw.newLine();

        for (String string : columnArray) {
            string = string.trim();
            StringBuilder sb = new StringBuilder();
            sb.append("    private ");
            sb.append("String ");
            sb.append(columnToCamel(string));
            sb.append(";");
            bw.write(sb.toString());
            bw.newLine();
        }
        
        bw.newLine();
        bw.write("}");
        bw.close();
    	
    }

    /**
     * CSV形式のカラム名からprivateなString型のフィールド名を作成し、コンソールに出力します。
     * @param csv csv形式のカラム一覧(カラム間のスペースは自動的に削除されます。)
     */
    public static void printFieldFromCSVColumn(String csv) {

        String[] columnArray = csv.split(",");

        for (String string : columnArray) {
            string = string.trim();
            StringBuilder sb = new StringBuilder();
            sb.append("private ");
            sb.append("String ");
            sb.append(columnToCamel(string));
            sb.append(";");
            System.out.println(sb);
        }

    }

    /**
     * 大文字とアンダースコアで構成されているカラム名を、キャメルケースに変換します。
     * @param column DBのカラム名(大文字＋アンダースコア)
     * @return カラム名をキャメルケースに直した文字列
     */
    public static String columnToCamel(String column) {
        column = column.toLowerCase();

        if (!column.contains("_")) {
            return column;
        }

        String[] wordArray = column.split("_");
        for (int i = 1; i < wordArray.length; i++) {
            if (wordArray[i] == null || wordArray[i].isEmpty()) {
                continue;
            }

            String word = wordArray[i];
            char firstChar = word.charAt(0);
            String formattedWord = Character.toUpperCase(firstChar) + word.substring(1);
            wordArray[i] = formattedWord;
        }

        StringBuilder sb = new StringBuilder();
        for (String string : wordArray) {
            sb.append(string);
        }

        return sb.toString();
    }

}
