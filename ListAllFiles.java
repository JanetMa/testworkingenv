package thread_learn;

import java.io.File;

public class ListAllFiles {
	public static void listAllFiles(File dir){
		if(!dir.exists()||!dir.isDirectory())
			return;
		String[] lists = dir.list();
		
		for(int i=0;i<lists.length;i++){
			File file = new File(dir,lists[i]);
			if(file.isFile()){
				System.out.println(dir+"\\"+file.getName()+"\t"+file.length());
		//	listAllFiles(file);
			}
			else{
				listAllFiles(file);
			}
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListAllFiles laf = new ListAllFiles();
		laf.listAllFiles((new File("C:\\Users\\mxy\\Downloads\\")));
		
	}

}
