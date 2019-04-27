package dom4j;

import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;
import org.junit.Test;

public class testDom4J {
	

	@Test
	public void test1() throws DocumentException{
		SAXReader reader = new SAXReader();//创建一个xml解析对象
		Document document = reader.read("src/Book.xml");//把xml文档加载到document
		Element root = document.getRootElement();
		
//		Element bookNode = root.addElement("书");
//		System.out.println(bookNode.getName());
		
		List list = root.elements();
		Element secondBook = (Element)list.get(1);//得到第二本书对象
		String name = secondBook.element("书名").getText();
		System.out.println(name);
		
	}
	
	@Test
	public void test2() throws DocumentException{
		SAXReader reader = new SAXReader();//创建一个xml解析对象
		Document document = reader.read("src/Book.xml");//把xml文档加载到document
		Element root = document.getRootElement();
		
		treeWalk(root);
	}

	private void treeWalk(Element ele) {
		
		System.out.println(ele.getName());//输出当前节点的名字
		
		for (int i = 0; i < ele.nodeCount(); i++) {
			Node node = ele.node(i);//取出下表为i的节点
			if(node instanceof Element){//判断当前节点是否为标签
				treeWalk((Element) node);//把node强转为标签（Element）
			}
		}
		
	}
}
