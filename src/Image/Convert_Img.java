/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Image;

import java.awt.Image;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.SwingConstants;

/**
 *
 * @author Mateus
 */
public class Convert_Img {
    URL urlPause = getClass().getResource("/Image/imgPause.png");
    URL urlPlay  = getClass().getResource("/Image/imgPlay.png");
    ImageIcon imgPause =  new ImageIcon(urlPause);
    ImageIcon imgPlay  =  new ImageIcon(urlPlay);
    Image image;
    public JButton ScaledImage(JButton btn,boolean b) {
        if(b){
            image = ((ImageIcon) imgPause).getImage();
        }
        else{
            image = ((ImageIcon) imgPlay).getImage();
        }
            
        Image newimg = image.getScaledInstance(btn.getBounds().width * 2 / 3, btn.getBounds().height * 2 / 3, Image.SCALE_SMOOTH); // scale it the smooth way  
        ImageIcon imageIcon = new ImageIcon(newimg); 
        btn.setIcon(imageIcon);
        btn.setHorizontalAlignment(SwingConstants.CENTER);
        return btn;
    }
}
