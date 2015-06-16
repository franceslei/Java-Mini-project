package Mini_project;

import java.io.File;


import java.util.Iterator;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;

//use dom4j to parse XML 
public class ParseXML {
	public static void print(Object obj){
		System.out.println(obj);
	}

	public static void main(String[] args) throws DocumentException {
		//get the url of a file
		//String filepath=ParseXML.class.getClassLoader().getResource("test.xml").getPath(); //the line fails, don't know why
			
		File file= new File("src/Mini_project/test.xml");
		SAXReader reader= new SAXReader();
		Document document=reader.read(file);
		//Document document=reader.read("C:\\Users\\NIBS\\workspace\\LeetCode\\src\\Mini_project\\test.xml");
		String s=document.getXMLEncoding();
		print(s);
		
		
		//use XPath
		Node node=document.selectSingleNode("//classes/class/student");
		String text=node.getText();
		print(text);     
		
		//search whether a certain node exists in the xml file
		String id="6";
		Node node1= document.selectSingleNode("//class[@id='"+id+"']");
		if(node1!=null)
			print("yes");
		else
			print("no");
		
	}

}
