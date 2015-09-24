package com.bern.dao;

import java.util.ArrayList;
import java.util.List;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.bern.model.Address;
import com.bern.model.ConstantValue;
import com.bern.utils.ValidateUtils;

/**
 * 地址信息的持久层
 * @author Bern
 *
 */
public class AddressDao {
	private DocumentDao documentDao = new DocumentDao();
	
	/**
	 * 添加一条地址信息到地址簿
	 * @param address 地址信息
	 * @return
	 */
	public boolean add(Address address) {
		Document document = documentDao.getDocument(ConstantValue.XML_PATH2);
		
		//构造一个entry的结点
		Element entry = document.createElement(ConstantValue.XML_NODE_NAME);
		Element name = document.createElement(ConstantValue.F_NAME);
		name.setTextContent(address.getName());
		Element mobile = document.createElement(ConstantValue.F_MOBILE);
		mobile.setTextContent(address.getMobile());
		Element addressElem = document.createElement(ConstantValue.F_ADDRESS);
		addressElem.setTextContent(address.getAddress());
		
		//关联结点的值到entry
		entry.appendChild(name);
		entry.appendChild(mobile);
		entry.appendChild(addressElem);	
		
		document.getElementsByTagName(ConstantValue.XML_ROOT_NAME).item(0).appendChild(entry);	//关联entry到addressBook
		
		return documentDao.write(document, ConstantValue.XML_PATH2);		//持久化操作
	}
	
	/**
	 * 查找指定的地址信息
	 * @param field
	 * @param value
	 * @return
	 */
	public List<Address> search(String field, String value) {
		Document document = documentDao.getDocument(ConstantValue.XML_PATH2);
		List<Address> list = new ArrayList<Address>();
		
		Node addressBook = document.getElementsByTagName(ConstantValue.XML_ROOT_NAME).item(0);		//获取根节点
		NodeList entryList = addressBook.getChildNodes();
		for(int i=0; i<entryList.getLength(); i++) {		//遍历entry节点
			Node entry = entryList.item(i);
			NodeList nodeList = entry.getChildNodes();
			boolean flag = false;
			for(int j=0; j<nodeList.getLength(); j++) {		//遍历entry里节点的子节点
				Node node = nodeList.item(j);
				if(node!=null && node.getNodeName().equals(field)) {		//判断字段名称是否匹配
					String content = node.getTextContent();
					if(ValidateUtils.wildcardMatching(value, content)) {		//判断字段值是否匹配
						flag = true;
						break;
					}
				}
			}
			if(flag) {		//添加查找到的匹配的节点
				String[] values = new String[3];
				int index = 0;
				for(int j=0; j<nodeList.getLength()&&index<3; j++) {		//遍历entry里节点的子节点
					String string = nodeList.item(j).getTextContent();
					if(!"".equals(string.trim())) {
						values[index++] = string;
					}
				}
				list.add(new Address(values[0], values[1], values[2]));
			}
		}
		
		return list;
	}
	
	/**
	 * 移除指定的地址信息
	 * @param field 待查找的字段
	 * @param value 待查找的值
	 * @return
	 */
	public int remove(String field, String value) {
		Document document = documentDao.getDocument(ConstantValue.XML_PATH2);
		
		int count = 0;
		Node addressBook = document.getElementsByTagName(ConstantValue.XML_ROOT_NAME).item(0);		//获取根节点
		NodeList entryList = addressBook.getChildNodes();
		for(int i=0; i<entryList.getLength(); i++) {		//遍历entry节点
			Node entry = entryList.item(i);
			NodeList nodeList = entry.getChildNodes();
			for(int j=0; j<nodeList.getLength(); j++) {		//遍历entry里节点的子节点
				Node node = nodeList.item(j);
				if(node!=null && node.getNodeName().equals(field)) {		//判断字段名称是否匹配
					String content = node.getTextContent();
					if(ValidateUtils.wildcardMatching(value, content)) {		//判断字段值是否匹配
						addressBook.removeChild(entry);
						count++;
						break;
					}
				}
			}
		}
		
		documentDao.write(document, ConstantValue.XML_PATH2);	//持久化操作
		return count;
	}
	
}
