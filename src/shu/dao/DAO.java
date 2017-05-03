package shu.dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Read datas from the file csv or Write the results in a file txt
 * 
 * @author shuyingxuan
 *
 */
public class DAO implements DAOInterface{
	/**
	 * Read datas from the file csv
	 * 
	 * @param filePath The path of the file
	 * @return get all the data in the file
	 */
	public static List<List<String>> readTxtFile(String filePath) {
		// A list of parameters set in the 1st line of data list
		List<String> list1 = new ArrayList<String>();
		// A list of nodes set in the 2nd line of data list
		List<String> list2 = new ArrayList<String>();
		// A list of edges set in the 3rd line of data list
		List<String> list3 = new ArrayList<String>();  
		// A data list with all the information
		List<List<String>> dataList = new ArrayList<>();
	
		try {
			String encoding = "UTF-8";
			File file = new File(filePath);
			if (file.isFile() && file.exists()) { 
				InputStreamReader read = new InputStreamReader(new FileInputStream(file), encoding);
				BufferedReader br = new BufferedReader(read);
				String s = null;
				
				// Get a list of parameters
				list1.add(br.readLine());
				// Read vide line
				br.readLine();
				// Get a list of nodes
				list2.add(br.readLine());
				br.readLine();
				// Get a list of edges
				list2.add(br.readLine());
				br.readLine();

				while ((s = br.readLine()) != null) {
					if (s.isEmpty()) {				
						break;
					}
					list3.add(s);
				}
				
				// Set parameters in the 1st line of data list
				dataList.add(list1);
				// Set nodes in the 2nd line of data list
				dataList.add(list2);
				// Set edges in the 3rd line of data list
				dataList.add(list3);

				br.close();
				read.close();
				
			} else {
				System.out.println("On ne peut pas trouver le fichier ! ");
			}
		} catch (Exception e) {
			System.out.println("Lire le fichier erreur ! ");
			e.printStackTrace();
		}
		return dataList;
	}
	
	
	/**
	 * Get the file name when write the results
	 * 
	 * @param inputFileName This is input file name
	 * @return Output file name
	 */
	public static String getOutputFileName(String inputFileName){
	    File file = new File(inputFileName);
	    //to get the result directory
	    File mOutDir = new File(file.getParentFile().getParentFile(), "result");
	    //if not exist, create it.
	    if(!mOutDir.exists()){
	        mOutDir.mkdirs();
	    }
	    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy.MM.dd HH_mm_ss");
	    return new File(mOutDir, file.getName()+"_"+dateFormat.format(new Date())+".txt").getAbsolutePath();
	}

	/**
	 * Write the results in a file txt
	 * 
	 * @param listResultat This is a list of results
	 * @param filePath This is the output file path
	 */
	public static void writeTxtFile(List<List<Integer>> listResultat, String filePath) {
		File f = new File(getOutputFileName(filePath));
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter(f));

	        if(listResultat.size() > 0){
				for (int i = 0; i < listResultat.size(); i++) {
					if(listResultat.get(i).size() > 0){
						bw.write(listResultat.get(i).toString());
			            bw.newLine();
					}
				}
			}
	        bw.close();
		} catch (IOException e) {
			System.out.println("Ecrire les resultat dans le fichier erreur !");
		}
	}
	
}
