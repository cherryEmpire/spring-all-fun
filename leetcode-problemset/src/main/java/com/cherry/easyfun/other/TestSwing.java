package com.cherry.easyfun.other;

import javax.swing.*;

/**
 * @Author: Cherry
 * @Date: 2020/12/5
 * @Desc: TestSwing
 */
public class TestSwing {
    /**
     * {
     * 创建并显示GUI。出于线程安全的考虑，
     * 这个方法在事件调用线程中调用。
     */
    private static void createAndShowGUI() {
        // 确保一个漂亮的外观风格
        JFrame.setDefaultLookAndFeelDecorated(true);

        // 创建及设置窗口
        JFrame frame = new JFrame("HelloWorldSwing");
        frame.setLocation(1000, 500);//设置窗口的位置
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(200, 200);//设置窗口的大小
        // 添加 "Hello World" 标签
        JLabel label = new JLabel("Hello World");
        //label.setSize(1000, 1000);
        frame.getContentPane().add(label);

        // 显示窗口
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        // 显示应用 GUI
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                createAndShowGUI();
            }
        });
    }
}
