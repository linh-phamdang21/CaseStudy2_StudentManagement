package Controller;

import Bean.ListBean;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JPanel;
import view.ClassJPanel;
import view.CourseJPanel;
import view.DataJPanel;
import view.HomepageJPanel;
import view.StudentJPanel;

public class ScreenSwitchController {
    private JPanel root;
    private String kindSelected = "";
    
    private List<ListBean> listItem = null;

    public ScreenSwitchController(JPanel jpnRoot) {
        this.root = jpnRoot;
    }
    
    public void setView(JPanel jpnItem, JLabel jlbItem){
        kindSelected = "Homepage";
        jpnItem.setBackground(new Color(96,100,191));
        jlbItem.setBackground(new Color(96,100,191));
        root.removeAll();
        root.setLayout(new BorderLayout());
        root.add(new HomepageJPanel());
        root.validate();
        root.repaint();
    }
    
    public void setEvent(List<ListBean> listItem){
        this.listItem = listItem;
        for(ListBean item : listItem){
            item.getJlb().addMouseListener(new LabelEvent(item.getKind(), item.getJpn(), item.getJlb()));
        }
    }
    
    class LabelEvent implements MouseListener {
        
        private JPanel node;
        private String kind;
        private JPanel jpnItem; 
        private JLabel jlbItem;

        public LabelEvent(String kind, JPanel jpnItem, JLabel jlbItem) {
            this.kind = kind;
            this.jpnItem = jpnItem;
            this.jlbItem = jlbItem;
        }
        
       
                
        @Override
        public void mouseClicked(MouseEvent e) {
           switch(kind){
               case "Homepage":
                   node = new HomepageJPanel();
                   break;
               case "Student":
                   node = new StudentJPanel();
                   break;
               case "Course":
                   node = new CourseJPanel();
                   break;
               case "Class":
                   node = new ClassJPanel();
                   break;
                case "Data":
                    node = new DataJPanel();
                    break;
                default:
                   node = new StudentJPanel();
                   break;
           }
           root.removeAll();
           root.setLayout(new BorderLayout());
           root.add(node);
           root.validate();
           root.repaint();
           setChangeBackground(kind);
        }

        @Override
        public void mousePressed(MouseEvent e) {
            kindSelected = kind;
            jpnItem.setBackground(new Color(96,100,191));
            jlbItem.setBackground(new Color(96,100,191));
        }

        @Override
        public void mouseReleased(MouseEvent e) {
         
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            jpnItem.setBackground(new Color(96,100,191));
            jlbItem.setBackground(new Color(96,100,191));
        }

        @Override
        public void mouseExited(MouseEvent e) {
            if (!kindSelected.equalsIgnoreCase(kind)){
                jpnItem.setBackground(new Color(76,175,80));
                jlbItem.setBackground(new Color(76,175,80));
            }
        }
    }
    
    private void setChangeBackground(String kind){
        for (ListBean item : listItem){
            if (item.getKind().equalsIgnoreCase(kind)){
                item.getJpn().setBackground(new Color(96,100,191));
                item.getJlb().setBackground(new Color(96,100,191));
            } else {
                item.getJpn().setBackground(new Color(76,175,80));
                item.getJlb().setBackground(new Color(76,175,80));
            }
        }
    }
}
