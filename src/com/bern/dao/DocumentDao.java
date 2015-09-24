package com.bern.dao;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;

/**
 * 操作document的类
 * @author Bern
 *
 */
public class DocumentDao {
	
	/**
	 * 获取文档对象
	 * @param path 文档的路径
	 * @return 返回相应的文档对象
	 */
	public Document getDocument(String path) {
		File file = new File(path);
		if(!file.exists()) {
			try {
				file.createNewFile();
			} catch (IOException e) {
				System.out.println("创建文件失败！path："+path);
			}
		}
		Document document = null;
		try {
			document = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(file);
		} catch (Exception e) {
			System.out.println("XML文件转换异常！异常信息:"+e);
		}
		return document;
	}
	
	/**
	 * 向文件中写入XML
	 * @param document	将要写入的对象
	 * @param path	文件的路径
	 * @return 返回操作结果
	 */
	public boolean write(Document document, String path) {
		OutputStream w = null;
		try {
			w = new FileOutputStream(path);
		} catch (FileNotFoundException e) {
			System.out.println("没有这个文件"+e);
			return false;
		}
		Source source = new DOMSource(document);
		Result result = new StreamResult(w);

		Transformer xformer = null;
		try {
			xformer = TransformerFactory.newInstance().newTransformer();
		} catch (Exception e) {
			System.out.println("创建转换器异常："+e);
			return false;
		}
		
		xformer.setOutputProperty(OutputKeys.ENCODING, "utf-8");	//设置编码
		try {
			xformer.transform(source, result);
		} catch (TransformerException e) {
			System.out.println("转换XML异常："+e);
			return false;
		}
		return true;
	}
}
