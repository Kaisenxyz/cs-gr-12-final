import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;

//It's all blocks of code for now. til I figure out a cleaner/more efficient way to write it 
public class gui {
    public static void createAndShowGUI() {
        JFrame jFrame = new JFrame("Calendar UI Test");
        jFrame.setLayout(new BorderLayout());
        jFrame.setSize(500, 400);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  
        JPanel days = new JPanel(new GridLayout(0, 7));
        JPanel hours = new JPanel(new GridLayout(13, 1));
        hours.setPreferredSize(new Dimension(50, 0));
        Border border = BorderFactory.createLineBorder(Color.GRAY);

        //JButton nextDay=new JButton("Next");
        //nextDay.setBounds(400,300,100,40);
        //jFrame.add(nextDay);
      
        JLabel labelHoldA = new JLabel();
        labelHoldA.setBorder(border);
        labelHoldA.setPreferredSize(new Dimension(500, 20));
        labelHoldA.setText("MONTH/YEAR");
        
        
        JLabel labelHoldC = new JLabel("Monday (DD)", SwingConstants.CENTER);
        labelHoldC.setVerticalAlignment(SwingConstants.TOP);
        labelHoldC.setBorder(border);
        //labelHoldC.setPreferredSize(new Dimension(50, 100));

        JLabel labelHoldD = new JLabel("Tuesday (DD)", SwingConstants.CENTER);
        labelHoldD.setVerticalAlignment(SwingConstants.TOP);
        labelHoldD.setBorder(border);
        //labelHoldD.setPreferredSize(new Dimension(50, 100));

        JLabel labelHoldE = new JLabel("Wednesday (DD)", SwingConstants.CENTER);
        labelHoldE.setVerticalAlignment(SwingConstants.TOP);
        labelHoldE.setBorder(border);
        //labelHoldE.setPreferredSize(new Dimension(50, 100));
    
        JLabel labelHoldF = new JLabel("Thursday (DD)", SwingConstants.CENTER);
        labelHoldF.setVerticalAlignment(SwingConstants.TOP);
        labelHoldF.setBorder(border);
        //labelHoldF.setPreferredSize(new Dimension(50, 100));

        JLabel labelHoldG = new JLabel("Friday (DD)", SwingConstants.CENTER);
        labelHoldG.setVerticalAlignment(SwingConstants.TOP);
        labelHoldG.setBorder(border);
        //labelHoldG.setPreferredSize(new Dimension(50, 100));

        JLabel labelHoldH = new JLabel("Saturday (DD)", SwingConstants.CENTER);
        labelHoldH.setVerticalAlignment(SwingConstants.TOP);
        labelHoldH.setBorder(border);
        //labelHoldH.setPreferredSize(new Dimension(50, 100));

        JLabel labelHoldI = new JLabel("Sunday (DD)", SwingConstants.CENTER);
        labelHoldI.setVerticalAlignment(SwingConstants.TOP);
        labelHoldI.setBorder(border);
        //labelHoldI.setPreferredSize(new Dimension(50, 100));

        JLabel hoursCount = new JLabel(("Hours"), SwingConstants.CENTER);
        hoursCount.setPreferredSize(new Dimension(20, 15));

        JLabel hourOne = new JLabel(("1:00"), SwingConstants.CENTER);
        hourOne.setPreferredSize(new Dimension(20, 30));

        JLabel hourTwo = new JLabel(("2:00"), SwingConstants.CENTER);
        hourTwo.setPreferredSize(new Dimension(20, 30));

        JLabel hourThree = new JLabel(("3:00"), SwingConstants.CENTER);
        hourThree.setPreferredSize(new Dimension(20, 30));

        JLabel hourFour = new JLabel(("4:00"), SwingConstants.CENTER);
        hourFour.setPreferredSize(new Dimension(20, 30));

        JLabel hourFive = new JLabel(("5:00"), SwingConstants.CENTER);
        hourFive.setPreferredSize(new Dimension(20, 30));

        JLabel hourSix = new JLabel(("6:00"), SwingConstants.CENTER);
        hourSix.setPreferredSize(new Dimension(20, 30));

        JLabel hourSeven = new JLabel(("7:00"), SwingConstants.CENTER);
        hourSeven.setPreferredSize(new Dimension(20, 30));

        JLabel hourEight = new JLabel(("8:00"), SwingConstants.CENTER);
        hourEight.setPreferredSize(new Dimension(20, 30));

        JLabel hourNine = new JLabel(("9:00"), SwingConstants.CENTER);
        hourNine.setPreferredSize(new Dimension(20, 30));

        JLabel hourTen = new JLabel(("10:00"), SwingConstants.CENTER);
        hourTen.setPreferredSize(new Dimension(20, 30));

        JLabel hourEleven = new JLabel(("11:00"), SwingConstants.CENTER);
        hourEleven.setPreferredSize(new Dimension(20, 30));

        JLabel hourTwelve = new JLabel(("12:00"), SwingConstants.CENTER);
        hourTwelve.setPreferredSize(new Dimension(20, 30));
      
        days.add(labelHoldC);
        days.add(labelHoldD);
        days.add(labelHoldE);
        days.add(labelHoldF);
        days.add(labelHoldG);
        days.add(labelHoldH);
        days.add(labelHoldI);

        hours.add(hoursCount); //im gonna lose it
        hours.add(hourOne);
        hours.add(hourTwo);
        hours.add(hourThree);
        hours.add(hourFour);
        hours.add(hourFive);
        hours.add(hourSix);
        hours.add(hourSeven);
        hours.add(hourEight);
        hours.add(hourNine);
        hours.add(hourTen);
        hours.add(hourEleven);
        hours.add(hourTwelve);
      
        jFrame.add(labelHoldA, BorderLayout.PAGE_START);
        jFrame.add(hours, BorderLayout.LINE_START);
        jFrame.add(days, BorderLayout.CENTER);
        jFrame.setVisible(true);

        
    }
    public static void main(String[] args){
        createAndShowGUI();
    }

}