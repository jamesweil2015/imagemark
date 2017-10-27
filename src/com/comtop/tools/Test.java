
package com.comtop.tools;

import java.awt.Color;
import java.awt.Font;

@SuppressWarnings("javadoc")
public class Test {
    
    public static void main(String[] args) {
        // TODO 自动生成方法存根注释，方法实现时请删除此注释
        ImageMarkTool imt = new ImageMarkTool();
        // itm.mark("d:\\test2.jpeg", "d:\\logo.png", "d:\\test2_out.jpeg", 180, 120, 0, 24);
        
        Font font = new Font("宋体", Font.PLAIN, 30);
        imt.mark("d:\\test2.jpeg", "d:\\test2_out.jpeg", "仅供参考", font, Color.ORANGE, 0, 24);
        System.out.println("OK");
    }
}
