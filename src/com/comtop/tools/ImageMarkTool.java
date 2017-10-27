
package com.comtop.tools;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 *
 * <pre>
 *  给图片添加文本、图片水印
 * </pre>
 *
 * @author JAMES.WEI
 * @since jdk1.6
 * @version V1.0.0
 */
public class ImageMarkTool {
    
    /**
     * 输出图片文件流
     */
    private FileOutputStream outImgStream;
    
    /**
     * 给图片增加图片水印
     * 
     * @param inputImg 源图片，要添加水印的图片
     * @param markImg 水印图片
     * @param outputImg 输出图片(可以是源图片)
     * @param width 水印图片宽度
     * @param height 水印图片高度
     * @param x 横坐标，相对于源图片
     * @param y 纵坐标，同上
     */
    public void mark(String inputImg, String markImg, String outputImg, int width, int height, int x, int y) {
        // 读取原图片信息
        File inputImgFile = null;
        File markImgFile = null;
        Image img = null;
        Image mark = null;
        try {
            if (inputImg != null && markImg != null) {
                inputImgFile = new File(inputImg);
                markImgFile = new File(markImg);
            }
            if (inputImgFile != null && inputImgFile.exists() && inputImgFile.isFile() && inputImgFile.canRead()) {
                
                img = ImageIO.read(inputImgFile);
                
            }
            if (markImgFile != null && markImgFile.exists() && markImgFile.isFile() && markImgFile.canRead()) {
                
                mark = ImageIO.read(markImgFile);
                
            }
            int imgWidth = img.getWidth(null);
            int imgHeight = img.getHeight(null);
            BufferedImage bufImg = new BufferedImage(imgWidth, imgHeight, BufferedImage.TYPE_INT_RGB);
            mark(bufImg, img, mark, width, height, x, y);
            outImgStream = new FileOutputStream(outputImg);
            ImageIO.write(bufImg, "jpg", outImgStream);
            outImgStream.flush();
            outImgStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    /**
     * 
     * 加文字水印
     *
     * <pre>
     * 加文字水印
     * </pre>
     * 
     * @param imgPath 源图片，要添加水印的图片
     * @param outImgPath 输出图片(可以是源图片)
     * @param text 水印文本
     * @param font 水印字体
     * @param color 水印颜色
     * @param x 输出横坐标
     * @param y 输出纵坐标
     */
    public void mark(String imgPath, String outImgPath, String text, Font font, Color color, int x, int y) {
        try {
            // 读取原图片信息
            File imgFile = null;
            Image img = null;
            if (imgPath != null) {
                imgFile = new File(imgPath);
            }
            if (imgFile != null && imgFile.exists() && imgFile.isFile() && imgFile.canRead()) {
                img = ImageIO.read(imgFile);
            }
            int imgWidth = img.getWidth(null);
            int imgHeight = img.getHeight(null);
            // 加水印
            BufferedImage bufImg = new BufferedImage(imgWidth, imgHeight, BufferedImage.TYPE_INT_RGB);
            mark(bufImg, img, text, font, color, x, y);
            outImgStream = new FileOutputStream(outImgPath);
            ImageIO.write(bufImg, "jpg", outImgStream);
            outImgStream.flush();
            outImgStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    /**
     *
     * <pre>
     * 给图片增加文字水印
     * </pre>
     * 
     * @param bufImg 源图片，要添加水印的图片
     * @param img 输出图片(可以是源图片)
     * @param text 水印文本
     * @param font 水印字体
     * @param color 水印颜色
     * @param x 输出横坐标
     * @param y 输出纵坐标
     */
    private void mark(BufferedImage bufImg, Image img, String text, Font font, Color color, int x, int y) {
        Graphics2D g = bufImg.createGraphics();
        g.drawImage(img, 0, 0, bufImg.getWidth(), bufImg.getHeight(), null);
        g.setColor(color);
        g.setFont(font);
        g.drawString(text, x, y);
        g.dispose();
    }
    
    /**
     * 给图片增加图片水印
     * 
     * @param bufImg 源图片，要添加水印的图片
     * @param markImg 水印图片
     * @param img 输出图片(可以是源图片)
     * @param width 水印图片宽度
     * @param height 水印图片高度
     * @param x 横坐标，相对于源图片
     * @param y 纵坐标，同上
     */
    private void mark(BufferedImage bufImg, Image img, Image markImg, int width, int height, int x, int y) {
        Graphics2D g = bufImg.createGraphics();
        g.drawImage(img, 0, 0, bufImg.getWidth(), bufImg.getHeight(), null);
        g.drawImage(markImg, x, y, width, height, null);
        g.dispose();
    }
    
}
