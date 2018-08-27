package test;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.UUID;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import com.beraising.hrv5.modules.personnelmanagement.empcenter.infochange.dao.Td20020076Dao;

	/**
	 * @author :chenzhiyuan
	 * 提供给powerdesigner生成的xml解析工具
	 * @time:2018年7月26日上午10:40:24
	 * @version:
	 * @param:
	 * @return:
	 * @since:
	 */
	
	public class TestYSJ {
	@SuppressWarnings({ "resource" })
	public static void main(String[] args) throws Exception {
//		GenericXmlApplicationContext context = new GenericXmlApplicationContext();
//		context.setValidating(false);
//		context.load("classpath*:WEB-INF/service-context.xml");
//		context.refresh();
		
//		Scanner is = new Scanner(System.in);
//		System.out.println("输入文件地址:");
//		String address = is.nextLine();
		
        String kol = start("e:/chenKKK.xsm");
        System.out.println(czXMLST(kol));

	}
			

		    /**
		     * 读取txt文件的内容
		     * @param file 想要读取的文件对象
		     * @return 返回文件内容
		     */
		    public static String txt2String(File file){
		        StringBuilder result = new StringBuilder();
		        try{
		            BufferedReader br = new BufferedReader(new FileReader(file));//构造一个BufferedReader类来读取文件
		            String s = null;
		            while((s = br.readLine())!=null){//使用readLine方法，一次读一行
		                result.append(System.lineSeparator()+s);
		            }
		            br.close();    
		        }catch(Exception e){
		            e.printStackTrace();
		        }
		        return result.toString();
		    }
		    /**
		     * @author chenzhiyuan
		     * 处理xml文件 返回装有Document,NodeList的map
		     * @param fi
		     * @return HashMap
		     * @throws Exception
		     */
		    @SuppressWarnings({ "rawtypes", "unchecked" })
			public static Map getXmlTest(String fi , String tagName) throws Exception{	
		    	 Map docXml = new HashMap<>();
		    	 DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();   
		    	 DocumentBuilder builder = factory.newDocumentBuilder(); 
		    	 StringReader sr = new StringReader(fi);
		    	 InputSource cds = new InputSource(sr);
		    	 Document doc = builder.parse(cds);   
		    	 NodeList nl = doc.getElementsByTagName(tagName);
		    	 docXml.put("Document", doc);
		    	 docXml.put("NodeList", nl);
//		    	 System.out.println(docXml);
		    	 return docXml;
		    }
		    
			/**
			 * @author chenzhiyuan
			 * 获取数据结构类型，NTYPE视图返回1表返回0其他返回5
			 * @param tableName
			 * @return Integer
			 */
			public static Integer Turefo(String tableName) {
				String tableNameFirst = tableName.substring(0, 2);
		    	if(tableNameFirst.equals("TD") || tableNameFirst.equals("td") || tableNameFirst.equals("Td") || tableNameFirst.equals("tD")) {
		    		return 0;
		    	}else {
		    		if(tableNameFirst.equals("VD") || tableNameFirst.equals("vd") || tableNameFirst.equals("Vd") || tableNameFirst.equals("tD")) {return 1;}else {
						return 5;
					}
				}
		    }
		    /**@author chenzhiyuan
		     * 替换XML文本流中的节点名并删除文本开头和结尾的空白
		     * @param tenXML
		     * @return 处理后的文本内容
		     * @throws InterruptedException 
		     */
		    public static String czXML(String tenXML) throws InterruptedException {
		    	if(tenXML.indexOf("a:BaseTypeName") > -1) {
		        	String fi = tenXML.replace("a:BaseTypeName", "a:TypeName");
		        	String newfi = fi.trim();
		        	System.out.println("loading...");
		        	Thread.sleep(1500);
		        	System.out.println("数据装载成功...");
		        	Thread.sleep(500);
		        	System.out.println("即将启动频道1...");
		        	Thread.sleep(2000);
		        	System.out.println("启动中...");
		        	Thread.sleep(3000);
		        	return newfi;
				}else {
					System.out.println("loading...");
					Thread.sleep(1500);
					System.out.println("数据装载成功...");
					Thread.sleep(500);
					System.out.println("即将启动频道2...");
					Thread.sleep(2000);
					System.out.println("启动中...");
					Thread.sleep(3000);
					return tenXML.trim();
				}
		 }
		    /**
		     * @author chenzhiyuan
		     * 返回 KEY0 数据库名 KEY1表名（带中文名字）
		     * @param tenXML
		     * @return
		     * @throws Exception
		     */
		    @SuppressWarnings({ "rawtypes", "unchecked" })
			public static Map czXMLD(String tenXML) throws Exception {
		    	if(tenXML != null && !tenXML.isEmpty() && tenXML.indexOf("<c:GroupParticle.Items") > -1 && tenXML.indexOf("<c:GroupParticle.Items") <= tenXML.indexOf("<c:Element.Attributes") && tenXML.indexOf("<c:Element.Attributes") >-1) {
		    		Map odpXML = new HashMap<>();
		    		String fisrtOPTXML = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>";
		    		String firstLLS = "<o:Model>";
		    		String sqName = tenXML.substring(tenXML.indexOf("<c:GenerationOrigins"), tenXML.indexOf("<c:SchemaLanguage>"));
		    		String headXml = fisrtOPTXML + firstLLS + sqName;
		    		String tableName = tenXML.substring(tenXML.indexOf("<c:GroupParticle.Items"), tenXML.indexOf("<c:Element.Attributes"));  
		    		String okXML = tableName.replace("<c:GroupParticle.Items>", headXml);
		    		String lastOPTXML = "</POIKSTENKA,XKSEKDSL.DLKFSIE12525645>";
		    		String lsTable = okXML + lastOPTXML;
		    		String kein = lsTable.replace(lastOPTXML, "</o:Element>");
		    		String klpouu = "</o:Model>";
		    		String lastTableName = (kein + klpouu).trim();
		    		Map opls = getXmlTest(lastTableName,"a:Name");
		    		Document doc = (Document) opls.get("Document");
		    		NodeList nl = (NodeList) opls.get("NodeList");
		    		for (int i = 0 ; i < nl.getLength() ; i++) {
		    			String posd = doc.getElementsByTagName("a:Name").item(i).getFirstChild().getNodeValue();
		    			odpXML.put(i, posd);
		    		}
			    	return odpXML;
		    	}else {
					return null;
				}
				  	
		    }
		    /**
		     * @author chenzhiyuan
		     * 处理xml文本主体部分，并将数据放到LIST里返回Map(chinese 中文字段名 ，english 英文字段名  ，typeOp 字段数据类型 ，number 字段数量)
		     * @param tenXML
		     * @return map
		     * @throws Exception
		     */
		    @SuppressWarnings({ "rawtypes", "unchecked" })
			public static Map czXMLT(String tenXML) throws Exception {
		    	if(tenXML != null && !tenXML.isEmpty() && tenXML.indexOf("<c:Element.Attributes>") > -1 && tenXML.indexOf("</c:Element.Attributes>") >= tenXML.indexOf("<c:Element.Attributes>") && tenXML.indexOf("</c:Element.Attributes>") >-1) {
		    		
		    		String tableName = tenXML.substring(tenXML.indexOf("<c:Element.Attributes"), tenXML.indexOf("</c:Element.Attributes>"));  
		    		String LPXML = "<POIKSTENKA,XKSEKDSL.DLKFSIE12525645>";
		    		String fsTable = LPXML + tableName;
		    		String okXML = fsTable.replace("<POIKSTENKA,XKSEKDSL.DLKFSIE12525645>", "<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
		    		String OPTXML = "</POIKSTENKA,XKSEKDSL.DLKFSIE12525645>";
		    		String lsTable = okXML + OPTXML;
		    		String lastTableName = lsTable.replace(OPTXML, "</c:Element.Attributes>").trim();
		    		Map opls = getXmlTest(lastTableName,"a:Name");
		    		Document doc = (Document) opls.get("Document");
		    		NodeList nl = (NodeList) opls.get("NodeList");
		    		List<String> chinese = new ArrayList();
		    		List<String> english = new ArrayList();
		    		List<String> typeOp = new ArrayList();
		    		Map dateTable = new HashMap<>();
		    		for (int i = 0 ; i < nl.getLength() ; i++) {
		    			String cnName = doc.getElementsByTagName("a:Name").item(i).getFirstChild().getNodeValue();
		    			chinese.add(cnName);
		    			String unCode = doc.getElementsByTagName("a:Code").item(i).getFirstChild().getNodeValue();
		    			english.add(unCode);
		    			String okType = doc.getElementsByTagName("a:TypeName").item(i).getFirstChild().getNodeValue();
		    			typeOp.add(okType);
		    		}
		    		dateTable.put("chinese", chinese);
		    		dateTable.put("english", english);
		    		dateTable.put("typeOp", typeOp);
		    		dateTable.put("number", nl.getLength());
		    		return dateTable;
		    	}else {
					return null ;
				}  
		    	
			}
		    /**
		     * @author chenzhiyuan
		     * 视图。处理xml文本主体部分，并将数据放到LIST里返回Map(chinese 中文字段名 ，english 英文字段名  ，typeOp 字段数据类型 ，number 字段数量)
		     * @param tenXML
		     * @return map
		     * @throws Exception
		     */
		    @SuppressWarnings({ "rawtypes", "unchecked" })
			public static Map czXMLST(String tenXML) throws Exception {
		    	if(tenXML != null && !tenXML.isEmpty() && tenXML.indexOf("<c:SubShortcuts>") > -1 && tenXML.indexOf("</c:SubShortcuts>") >= tenXML.indexOf("<c:SubShortcuts>") && tenXML.indexOf("</c:SubShortcuts>") >-1) {
		    		
		    		String tableName = tenXML.substring(tenXML.indexOf("<c:SubShortcuts"), tenXML.indexOf("</c:SubShortcuts>"));  
		    		String LPXML = "<POIKSTENKA,XKSEKDSL.DLKFSIE12525645>";
		    		String fsTable = LPXML + tableName;
		    		String okXML = fsTable.replace("<POIKSTENKA,XKSEKDSL.DLKFSIE12525645>", "<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
		    		String OPTXML = "</POIKSTENKA,XKSEKDSL.DLKFSIE12525645>";
		    		String lsTable = okXML + OPTXML;
		    		String lastTableName = lsTable.replace(OPTXML, "</c:SubShortcuts>").trim();
		    		Map opls = getXmlTest(lastTableName,"a:Name");
		    		Document doc = (Document) opls.get("Document");
		    		NodeList nl = (NodeList) opls.get("NodeList");
		    		List<String> chinese = new ArrayList();
		    		List<String> english = new ArrayList();
//		    		List<String> typeOp = new ArrayList();
		    		Map dateTable = new HashMap<>();
		    		for (int i = 0 ; i < nl.getLength() ; i++) {
		    			String cnName = doc.getElementsByTagName("a:Name").item(i).getFirstChild().getNodeValue();
		    			chinese.add(cnName);
		    			String unCode = doc.getElementsByTagName("a:Code").item(i).getFirstChild().getNodeValue();
		    			english.add(unCode);
//		    			String okType = doc.getElementsByTagName("a:TypeName").item(i).getFirstChild().getNodeValue();
//		    			typeOp.add(okType);
		    		}
		    		dateTable.put("chinese", chinese);
		    		dateTable.put("english", english);
//		    		dateTable.put("typeOp", typeOp);
		    		dateTable.put("number", nl.getLength());
		    		return dateTable;
		    	}else {
					return null ;
				}  
		    	
			}
		    /**
		     * @author chenzhiyuan
		     * 获取表的主键,返回表对应的主键
		     * @param tenXML
		     * @return
		     * @throws Exception
		     */
		    @SuppressWarnings("rawtypes")
			public static Map getMajor(String tenXML) throws Exception {
		    	Map opls = getXmlTest(tenXML,"a:XPath");
	    		Document doc = (Document) opls.get("Document");
	    		NodeList nl = (NodeList) opls.get("NodeList");
	    		List<String> asl = new ArrayList<>();
	    		String T1 = null;
	    		for (int i = 0 ; i < nl.getLength() ; i++) {
	    			String posd = doc.getElementsByTagName("a:XPath").item(i).getFirstChild().getNodeValue();
	    			if(posd.substring(0, 1).equals("@")) {
	    				T1 = posd.substring(1);
	    			} else {
						T1 = posd;
					}
	    			asl.add(T1);
	    		}
		    	return jiexi(asl);
		    }
		   
		    /**
		     * @author chenzhiyuan
		     * 装载文件
		     * @param fileAddress
		     * @return
		     * @throws InterruptedException
		     */
		    public static String start(String fileAddress) throws InterruptedException {
				File file = new File(fileAddress);
		        String opli = txt2String(file);
		        String kol = czXML(opli);
				return kol;
			}
			/**
			 * @author chenzhiyuan
			 * 将一个集合的数据拆分后以key value形式装进map
			 * @param jieList
			 * @return
			 */
			@SuppressWarnings({ "rawtypes", "unchecked" })
			public static Map jiexi(List jieList) {
		    	Map toMap = new HashMap<>();
		    	List is = new ArrayList<>();
		    	List ia = new ArrayList<>();
		    	for(int i = 0;i < jieList.size();i ++) {
		    		if(i%2==0) {
		    			is.add(jieList.get(i));
		    		} else {
						ia.add(jieList.get(i));
					}
		    	}
		    	if(is.size() == ia.size()) {
		    		for(int e =0; e<is.size(); e++) {
		    			toMap.put(is.get(e), ia.get(e));
		    		}
		    	}
		    	return toMap;
		    }
			/**
			 * @author chenzhiyuan
			 * 通过数据库名获取数据库连接GID
			 * sconngid
			 * @param dataBaseName
			 * @return
			 */
			public static String sconngid(String dataBaseName) {
				Td20020076Dao op = new Td20020076Dao();
				String sconngid = (String) op.getDataManager().sqlQuery("select GID from TS00010006 where SNAME = '"+dataBaseName+"'", (query) -> {
					return query.getSingleResult();
				});
				return sconngid;
			}
			/**
			 * @author chenzhiyuan
			 * UUID
			 * @return
			 */
			public static String getUuidOne() {
				String jo = UUID.randomUUID().toString();
				return jo;
			}
			/**
			 * @author chenzhiyuan
			 * 获取分类GID
			 * @param typeName
			 * @return
			 */
			public static String stypegid(String typeName) {
				Td20020076Dao op = new Td20020076Dao();
				String stypegid = (String) op.getDataManager().sqlQuery("select GID from TS00010001 where SNAME = '"+typeName+"'", (query) -> {
					return query.getSingleResult();
				});
				return stypegid;
			}
		    /**
		     * @author chenzhiyuan
		     * 往数据库插入数据TS00010002(数据结构)、
		     * NUSETYPE 业务用途  ：一般业务 = 0, 单据 = 1,基础资料 = 2,工作流 = 3
		     * @param dateTable
		     * @throws Exception 
		     */
			@SuppressWarnings("rawtypes")
			public static void shuJuJieGouSQL(String xmlTxt,String modelName,int NUSETYPE) throws Exception{
		    	Td20020076Dao op = new Td20020076Dao();
		    	Map map = czXMLD(xmlTxt);
		    	String dateBaseName = (String) map.get(0);
		    	String tableName = (String) map.get(1);
				String chineseTable = tableName.substring(tableName.indexOf("(")+1,tableName.indexOf(")"));
				String codeTable = tableName.substring(0,tableName.indexOf("("));
				int nissys = 0;
		    	op.getDataManager().sqlQuery( "insert into TS00010002(GID,STYPEGID,SCODE,SNAME,NTYPE,SCONNGID,NISSYS,NUSETYPE) values ('"+getUuidOne()+"','"+stypegid(modelName)+"','"+codeTable+"','"+chineseTable+"',"+Turefo(codeTable)+",'"+sconngid(dateBaseName)+"',"+nissys+","+NUSETYPE+")", (query)->{
					return  query.executeUpdate();
				});
		    }
			
			/**
			 * @author chenzhiyuan
			 * 往数据库插入数据TS00010004(数据结构字段)
			 * @param xmlTxt
			 * @throws Exception
			 */
			@SuppressWarnings({ "rawtypes", "unused" })
			public static void shuJuJieGouZiDuanSQL(String tenXML) throws Exception {
				Td20020076Dao op = new Td20020076Dao();
				Map map = czXMLT(tenXML);
				List chinese = (List) map.get("chinese");
				int number = (int) map.get("number");
				List typeOp = (List) map.get("typeOp");
				List english = (List) map.get("english");
				String tableName = (String) czXMLD(tenXML).get(1);
				String codeTableName = tableName.substring(0,tableName.indexOf("("));
				String sTableGid = (String) op.getDataManager().sqlQuery("select GID from TS00010002 where SCODE = '"+codeTableName+"'", (query) -> {
					return query.getSingleResult();
				});
				for(int i = 0; number>i; i++) {
					int nispk;
					String zwzdm = (String) chinese.get(i);
					String ywzdm = (String) english.get(i);
					String zdlx = (String) typeOp.get(i);
					if(ywzdm.equals(getMajor(tenXML).get(codeTableName))) {
						nispk = 1;
					}else {
						nispk = 0;
					}
					op.getDataManager().sqlQuery("insert into TS00010004(GID,SCODE,SNAME,STABLEGID,NFLDTYPE,NFLDLEN,NISPK,NISFK,SDEFVAL) values('"+getUuidOne()+"','"+ywzdm+"','"+zwzdm+"','"+sTableGid+"','"+fieldType(zdlx)+"',"+typeInt(zdlx)+","+nispk+","+0+",'"+typeString(zdlx)+"')", (query) -> {
						return query.executeUpdate();
					});
				}
	
			}
			
			/**
			 * @author chenzhiyuan
			 * 传入字段类型转为对应的数值
			 * @param type
			 * @return int
			 */
			public static Integer fieldType(String type) {
				if (type.equals("xs:string")) {
					return 0;
				} else {
					if(type.equals("xs:int")) {
						return 1;
					}else {
						if(type.equals("xs:decimal")) {
							return 2;
						}else {
							if(type.equals("xs:dateTime")) {
								return 3;
							}else {
								if(type.equals("xs:boolean")) {
									return 4;
								} else {
									return 6;
								}}}}}
				}
			/**@author chenzhiyuan
			 * 返回类型默认值
			 * @param type
			 * @return
			 */
			public static String typeString(String type) {
				if (type.equals("xs:string")) {
					return "";
				} else {
					if(type.equals("xs:int")) {
						return "0";
					}else {
						if(type.equals("xs:decimal")) {
							return "0";
						}else {
							if(type.equals("xs:dateTime")) {
								return "getdate()";
							}else {
								if(type.equals("xs:boolean")) {
									return "0";
								} else {
									return "错误";
								}}}}}

			}
			/**
			 * @author chenzhiyuan
			 * 返回类型对应的字段长度
			 * @param type
			 * @return
			 */
			public static Integer typeInt(String type) {
				if (type.equals("xs:string")) {
					return 300;
				} else {
					if(type.equals("xs:int")) {
						return 0;
					}else {
						if(type.equals("xs:decimal")) {
							return 0;
						}else {
							if(type.equals("xs:dateTime")) {
								return 0;
							}else {
								if(type.equals("xs:boolean")) {
									return 0;
								} else {
									return 6;
								}}}}}
			}
   
	}
