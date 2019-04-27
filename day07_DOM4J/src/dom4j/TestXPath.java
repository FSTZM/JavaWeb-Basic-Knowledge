package dom4j;

import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;
import org.junit.Test;

public class TestXPath {
	
	@Test
	public void test() throws DocumentException{
		
		SAXReader reader = new SAXReader();
		Document document = reader.read("src/Book.xml");
		Node node = document.selectSingleNode("/书架/书[2]/书名");
		System.out.println(node.getName());
		
	}
	
	@Test
	public void test2() throws DocumentException{
		SAXReader reader = new SAXReader();
		Document document = reader.read("src/Book.xml");
		
		List list = document.selectNodes("//*");
		for (int i = 0; i < list.size(); i++) {
			Node node = (Node) list.get(i);
			System.out.println(node.getName()+"\t"+node.getText());
		}
		
	}
	
	

}
