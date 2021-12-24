package com.zhu.game;

import javax.swing.*;
import java.awt.*;

public class PlantPanel extends JPanel {
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Image.flowerImg.paintIcon(this,g,10,10);
    }
}
