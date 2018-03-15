package Game1;

import com.sun.xml.internal.bind.v2.TODO;
import jdk.nashorn.internal.ir.annotations.Ignore;
import nettypro.SocketClient;
import nioExample.NioTcpClient;
import sun.security.action.GetPropertyAction;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.applet.Applet;
import java.awt.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Properties;

/**
 * Created by zhang on 2018/2/1.
 */
public class TT extends JFrame {
    private  MyPanel myPanel;
    private static Connection con =null;
    private static Statement statement =null;
    private static List<Ph> phList;

    private static String picturePath;
    private final Color[] COLORS = new Color[] {  //颜色集合
            new Color(255, 0, 0),
            new Color(255, 165, 0),
            new Color(255, 255, 0),
            new Color(0, 255, 0),
            new Color(0, 127, 0),
            new Color(0, 127, 255),
            new Color(139, 0, 255)
    };

    static {
         con =null;
         statement =null;
        try {
            // 加载驱动
            Class.forName("com.mysql.jdbc.Driver");
        } catch (Exception e) {
            System.out.println("找不到驱动程序类，加载驱动失败！");
            e.printStackTrace();
        }
        try {

        //建立到给定数据库 URL 的连接
            String url="jdbc:mysql://192.168.1.114:3306/phdatabase";
            String username="root";
            String password="dragonzhang";
             con = DriverManager.getConnection(url,username, password);

        } catch (Exception e) {

            System.out.println("数据库连接失败！");

            e.printStackTrace();

        }
        try {
            statement = con.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        // 查询
        String sql = "SELECT * FROM phtable";
        ResultSet rs = null;
        try {
            rs = statement.executeQuery(sql);
            int col = rs.getMetaData().getColumnCount();
            phList =new LinkedList<>();
            for (int i = 0; i < col; i++) {
                while (rs.next()){
                    long id = rs.getLong("id");
                    String name = rs.getString("phname");
                    String value = rs.getString("phvalue");
                    String data =  rs.getString("phdata");
                    Ph ph =new Ph();
                    ph.setId(id);
                    ph.setPhname(name);
                    ph.setPhvalue(value);
                    ph.setData(data);
                    phList.add(ph);
                }
            }
            for (int i = 0; i < phList.size(); i++) {
                System.out.println("phname ="+phList.get(i).getPhname());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.err.println("连接关闭失败");
                e.printStackTrace();
            }
        }





    }
    private class MyPanel extends JPanel {


    }

    public static void main(String[] args) {
        loadProperty();
        initSC();
        creatMode();

    }

    private static void loadProperty()  {
        Properties props = new Properties();
        File file = new File(System.getProperty("user.dir")
                + "/Excercise/src/main/resources/TT.properties");// 获取配置文件
        boolean dw = true, dh = true, df =true, db = true, dc = true, dcf = true;
        if (file.exists() && file.isFile()) {
            InputStream fis = null;
            try{
                fis = new FileInputStream(file);// 创建文件输入流
                props.load(fis);// 加载属性文件
            }catch (Exception e){
                e.printStackTrace();
                System.err.println("文件加载失败！");
            }

            // 获取图片地址
            picturePath = props.getProperty("picpath", System.getProperty("user.dir")
                    + "/pic").toLowerCase();
            if (!"default".equals(picturePath)) {

            }

            // 获取背景色，默认default
            String strBack = props.getProperty("background", "default").toLowerCase();
            if (!"default".equals(strBack)) {
                //getFrames().wait(200);

            }



            // 获取字符数组
            String strC = props.getProperty("characters", "default");
            if (!"default".equalsIgnoreCase(strC)) {
                dc = false;
                String[] cs = strC.split(",");
                char[] characters = new char[cs.length];
                for (int i = 0, s = characters.length; i < s; i++) {
                    characters[i] = cs[i].charAt(0);
                }
            }

            // 判断颜色是否铺满
            String strCF = props.getProperty("colorful", "default");
            if (!"default".equalsIgnoreCase(strCF)) {

            }


            try {
                fis.close();
            } catch (IOException e) {
                e.printStackTrace();
                System.err.println("配置文件关闭异常");
            }

        }else {
            System.err.println("File is Not Found");
        }

    }

    private static void creatMode() {
        String req ="QUERY_MODE_INFO";
        String res = new ModSocket().recieveDate(req);
        initMode(res);
    }

    private static void initMode(String res) {

    }

    private static void initSC() {
        Image[] array = new Image[10];
        Image image = null;
        try {
            image = ImageIO.read(new File(picturePath));
        } catch (IOException e) {
            System.err.println("图片读取失败！");
            e.printStackTrace();
        }
        array[0] = image;

    }

}
