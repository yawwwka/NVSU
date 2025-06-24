package com.javarush.task.pro.task10.task1012;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Ellipse2D;
import javax.swing.*;

public class MenuDrawing extends JFrame implements ActionListener {
    private JMyPanel myPanel = new JMyPanel();

    public static void main(String[] args) {
        new MenuDrawing("Окно с графикой и меню");
    }

    public MenuDrawing(String title) {
        super(title);

        // Создаем строку меню
        JMenuBar menuBar = new JMenuBar();

        // Создаем меню "Фигуры"
        JMenu shapesMenu = new JMenu("Фигуры");

        // Добавляем пункты меню для каждой фигуры
        for (JMyPanel.Figure figure : JMyPanel.Figure.values()) {
            if (figure != JMyPanel.Figure.CLEAR) {
                JMenuItem item = new JMenuItem(figure.toString());
                item.addActionListener(this);
                shapesMenu.add(item);
            }
        }

        // Добавляем пункт "Очистить"
        JMenuItem clearItem = new JMenuItem("CLEAR");
        clearItem.addActionListener(this);
        shapesMenu.add(clearItem);

        // Добавляем меню "Фамилия"
        JMenu nameMenu = new JMenu("Фамилия");

        for (JMyPanel.Familia fam : JMyPanel.Familia.values()) {
            JMenuItem item = new JMenuItem(fam.toString());
            item.addActionListener(this);
            nameMenu.add(item);
        }

        // Добавляем меню в строку меню
        menuBar.add(shapesMenu);
        menuBar.add(nameMenu);

        // Устанавливаем меню в окно
        setJMenuBar(menuBar);

        // Добавляем панель для рисования
        add(myPanel, BorderLayout.CENTER);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 400);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        myPanel.ris(command);
    }
}

class JMyPanel extends JPanel {
    public static enum Figure {LINE, OVAL, RECT, ROUNDRECT, CLEAR}

    public static enum Familia {NAMEBASIC, NAMENOTBASIC, NAMESLIM}

    public static enum Ob {LINE, OVAL, RECT, ROUNDRECT, CLEAR, NAMEBASIC, NAMENOTBASIC, NAMESLIM}

    private Ob choice = Ob.CLEAR;

    public JMyPanel() {
    }

    public void ris(String s) {
        choice = Ob.valueOf(s);
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        switch (choice) {
            case LINE:
                g2d.setStroke(new BasicStroke(5));
                g2d.setColor(Color.BLUE);
                g2d.drawLine(50, 50, 200, 200);
                break;

            case OVAL:
                float[] dash = {10, 30};
                g2d.setStroke(new BasicStroke(10, BasicStroke.CAP_SQUARE, BasicStroke.JOIN_ROUND, 10, dash, 0));
                g2d.setColor(Color.red);
                g2d.setPaint(new GradientPaint(30, 30, Color.red, 50, 50, Color.green, true));
//g.fill – создание объекта с заливкой, в качестве параметра задается объект из пакета Graphics2D,
//в нашем случае – эллипс
                g2d.fill(new Ellipse2D.Double(20, 20, 100, 100));
                break;

            case RECT:
                float[] dash2 = {20, 20};
                g2d.setStroke(new BasicStroke(5, BasicStroke.CAP_SQUARE, BasicStroke.JOIN_BEVEL, 1, dash2, 0));
                g2d.setColor(Color.GREEN);
                g2d.drawRect(50, 50, 200, 100);
                break;

            case ROUNDRECT:
                float[] dash3 = {20, 20, 2, 20, 2, 20};
                g2d.setStroke(new BasicStroke(10, BasicStroke.CAP_ROUND, BasicStroke.JOIN_BEVEL, 1, dash3, 0));
                g2d.setColor(Color.MAGENTA);
                g2d.drawRoundRect(50, 50, 200, 100, 30, 30);
                break;

            case CLEAR:
                g2d.clearRect(0, 0, getWidth(), getHeight());
                break;
            case NAMEBASIC:
                drawName(g2d, new BasicStroke(5), Color.BLACK);
                break;
            case NAMENOTBASIC:
                float[] dash1 = {10f, 5f};
                drawName(g2d, new BasicStroke(3, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER, 1f, dash1, 0f), Color.RED);
                break;
            case NAMESLIM:
                drawName(g2d, new BasicStroke(1), Color.GREEN);
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + choice);
        }
    }


    private void drawName(Graphics2D g2d, BasicStroke s, Color color) {
        g2d.setStroke(s);
        g2d.setColor(color);
        g2d.drawLine(50, 50, 50, 200);
        g2d.drawLine(125, 50, 125, 200);
        g2d.drawLine(50, 50, 125, 50);
        g2d.drawLine(225, 200, 250, 100);
        g2d.drawLine(250, 100, 275, 200);
        g2d.drawOval(150, 100, 50, 100);
        g2d.drawLine(300, 100, 300, 200);
        g2d.drawLine(300, 200, 325, 100);
        g2d.drawLine(325, 100, 325, 200);
        g2d.drawLine(350, 100, 350, 200);
        g2d.drawLine(375, 100, 375, 200);
        g2d.drawLine(400, 100, 400, 200);
        g2d.drawLine(350, 200, 415, 200);
        g2d.drawLine(415, 200, 415, 215);
        g2d.drawLine(440, 100, 440, 150);
        g2d.drawLine(440, 150, 465, 150);
        g2d.drawLine(465, 100, 465, 200);
        g2d.drawLine(440, 200, 465, 200);
        g2d.drawLine(490, 100, 490, 200);
        g2d.drawLine(490, 150, 515, 200);
        g2d.drawLine(490, 150, 515, 100);
    }
}