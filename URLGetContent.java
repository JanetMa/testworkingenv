package thread_learn;

import java.awt.TextArea;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class URLGetContent extends JFrame{

	TextArea textArea = new TextArea("downloading:\n");
	public void init(){
		setSize(400,300);
		getContentPane().add(textArea);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	public void download(){
		String strUrl = "http://www.baidu.com";
		new Thread(()->{
			String content = getContentFromUrl(strUrl);
			SwingUtilities.invokeLater(()->{
				textArea.append(content);
			});
		}).start();
	}
	
	public static String getContentFromUrl(String strUrl)
	{
		try{
			URL url = new URL(strUrl);
			InputStream stream=url.openStream();
			String content = readAll(stream,"UTF-8");
			return content;
		}catch(MalformedURLException e){
			System.out.println("URL style err...");
		}catch(IOException ioe){
			System.out.println("IO error..");
		}
		return "";
	}
	
	private static String readAll(InputStream stream, String charcode)throws IOException {
		// TODO Auto-generated method stub
		BufferedReader reader = new BufferedReader(new InputStreamReader(stream,charcode));
		StringBuilder sb = new StringBuilder();
		String line;
		while((line = reader.readLine())!=null){
			sb.append(line+"\n");
		}
		
		return sb.toString();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		URLGetContent f = new URLGetContent();
		f.init();
		f.download();
	}

}
