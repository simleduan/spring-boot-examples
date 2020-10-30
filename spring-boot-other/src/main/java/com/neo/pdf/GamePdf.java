package com.neo.pdf;import com.itextpdf.text.*;import com.itextpdf.text.pdf.BaseFont;import com.itextpdf.text.pdf.PdfWriter;import org.apache.commons.lang3.StringUtils;import java.io.FileOutputStream;import java.util.Objects;/** * Created by cainiao on 2020/10/30 5:00 下午 * 参考 https://www.cnblogs.com/qlqwjy/p/8213989.html */public class GamePdf {    private static Font one;    private static Font two;    private static Font three;    private static Font zhengwen;    private static Font red;    static {        BaseFont baseFont;        try {            //默认的iText字体设置不支持中文字体，需要下载远东字体包iTextAsian.jar，            // 否则不能往PDF文档中输出中文字体。通过下面的代码就可以在文档中使用中文了            baseFont = BaseFont.createFont("STSong-Light", "UniGB-UCS2-H", BaseFont.NOT_EMBEDDED);            one = new Font(baseFont, 20, Font.BOLD);            two = new Font(baseFont, 15, Font.BOLD);            three = new Font(baseFont, 10, Font.BOLD);            zhengwen = new Font(baseFont, 16, Font.NORMAL);            red = new Font(baseFont, 16, Font.NORMAL,BaseColor.RED);        } catch (Exception e) {            e.printStackTrace();        }    }    public static void main(String[] args) throws Exception {        String pdfName = "/Users/fanbin/Desktop/ueFile/game3.pdf";        //设置页面为A4纸，并且四周边距为50        Document document = new Document(PageSize.A4, 50, 50, 50, 50);        documentAddInfo(document);        Header header = new Header("header", "header info");        document.add(header);        //创建PdfWriter对象，将数据写入磁盘        PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(pdfName));        document.open();        //所有向文档添加的内容都是以对象为单位的，如Phrase、Paragraph、Table、Graphic对象等。        // 比较常用的是段落(Paragraph)对象，用于向文档中添加一段文字。        //段落(paragraph)由一个或多个文本块(Chunk)或短语(Phrase)组成，相当于WORD文档中的段落概念，同样可以设定段落 的字体大小、颜色等属性。另外也可以设定段落的首行缩进、对齐方式（左对齐、右对齐、居中对齐）。通过函数setAlignment可以设定段落的对齐方 式，setAlignment的参数1为居中对齐、2为右对齐、3为左对齐，默认为左对齐。        document.add(documentInfoCreate("王 者 荣 耀 挂 机 处 罚 判 决 书",one,"center"));        document.add(documentInfoCreate(" ",one,"center"));        document.add(documentInfoCreate("(客户保留)",three,"right"));        document.add(documentInfoCreate(" ",three,"right"));        document.add(documentInfoCreate("处罚编号:2525775",zhengwen,null));        document.add(documentInfoCreate("所在区服:蓝魔之泪",zhengwen,null));        document.add(documentInfoCreate("游戏昵称:每天只充九千块",zhengwen,null));        document.add(documentInfoCreate("处罚原因:言语辱骂",zhengwen,null));        document.add(documentInfoCreate(" ",three,"right"));        document.add(documentInfoCreate("致客户:张三",red,null));        document.add(documentInfoCreate("    游戏昵称为：张三的用户在2020年10月10日的排位赛中因消极游戏，送人头，并且辱骂队友。",zhengwen,null));        document.add(documentInfoCreate("    因无法判断您游戏期间这种行为，是人性的泯灭还是道德的沦丧，我司特对您的账号作出如下处罚：",zhengwen,null));        document.add(documentInfoCreate("    1、禁言一周",zhengwen,null));        document.add(documentInfoCreate("    2、信誉积分减掉降5分",zhengwen,null));        document.add(documentInfoCreate("    同时我司有权对您的账号进行封号处理",zhengwen,null));        document.add(documentInfoCreate(" ",three,"right"));        document.add(documentInfoCreate("特此确认",zhengwen,null));        document.add(documentInfoCreate(" ",three,"right"));        document.add(documentInfoCreate("玩家签字_______",zhengwen,"right"));        document.add(documentInfoCreate(" ",three,"right"));        document.add(documentInfoCreate("___年___月___日",zhengwen,"right"));        //iText中用文本块(Chunk)、短语(Phrase)和段落(paragraph)处理文本。        //文本块(Chunk)是处理文本的最小单位，有一串带格式（包括字体、颜色、大小）的字符串组成。如以下代码就是产生一个字体为HELVETICA、大小为10、带下划线的字符串：//        Chunk chunk = new Chunk("使用new Chunk,创建了一个文本块dasfade42", one);//        document.add(chunk);        //短语(Phrase)由一个或多个文本块(Chunk)组成，短语(Phrase)也可以设定字体，但对于其中以设定过字体的文本块 (Chunk)无效。通过短语(Phrase)成员函数add可以将一个文本块(Chunk)加到短语(Phrase)中， 如：phrase6.add(chunk);        Phrase elements = new Phrase();        document.close();        System.out.println("完成");    }    /**     * setAlignment的参数1为居中对齐、2为右对齐、3为左对齐，默认为左对齐。     * @param content 文本内容     * @param font 字体     * @param alignment 对齐方式     */    private static Paragraph documentInfoCreate(String content, Font font, String alignment) throws MyPdfException {        Paragraph paragraph = new Paragraph(content, font);        if (StringUtils.isNotBlank(alignment)){            if (Objects.equals(alignment,"center")){                paragraph.setAlignment(1);            } else if (Objects.equals(alignment,"right")){                paragraph.setAlignment(2);            } else {                throw new MyPdfException("未知对齐方式："+alignment);            }        }        return paragraph;    }    private static Document documentAddInfo(Document document) {        document.addTitle("主题");        document.addSubject("作者");        document.addKeywords("关键字");        document.addAuthor("装订方式");        document.addCreator("创建者");        document.addProducer();//生产者        document.addCreationDate();        return document;    }}