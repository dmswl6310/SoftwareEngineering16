package Restaurant;



import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.*;
import javax.swing.event.*;

public class GhostLeg extends JFrame implements ActionListener {
   
    JComboBox num_fail;
    JComboBox num_people;
    Integer[] line;
    Integer[][] leg;
    JTextField[] peopleText;
    JLabel[] res;
    JLabel winner, loser;
    int p,f;
    int select;
    int is_start;
    DrawPanel draw;
    Integer[] gap = new Integer[4];


    public GhostLeg() {
        System.out.println("JFrame ����");
        // ���â
        final JDialog d = new JDialog(this, "��� Ȯ��!", true);
        d.setSize(400,300);
        d.setLayout(null);
        d.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        JButton ok = new JButton();
        ok.setText("Ȯ��");
        ok.setBounds(280,210,90,30);
        ok.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("exit dialog");
                d.remove(winner);
                d.remove(loser);
                d.setVisible(false);
                d.dispose();
            }
        });
        d.add(ok);

        is_start = 1;

        // JFrame ũ�� ����
        setTitle("��ٸ�����");
        setSize(480,640);
        //setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);
        setResizable(false);
        setLocationRelativeTo(null);

        // ����� �� ��Ģ �� �Է�â ����

        //��� �� ��
        JLabel people = new JLabel("�ο� ��");
        people.setFont(new Font("���� ���", Font.PLAIN, 18));
        people.setBounds(50, 10, 100, 30);
        add(people);

        // ��� �� �޺��ڽ�
        String[] pnum = {"2", "3", "4", "5"};
        num_people = new JComboBox(pnum);
        num_people.setBounds(130, 10, 100,30);
        num_people.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                draw.removeAll();

                Random r = new Random();
                p = Integer.parseInt(num_people.getSelectedItem().toString());
                f = Integer.parseInt(num_fail.getSelectedItem().toString());
                res = new JLabel[p];
                for (int i = 0; i < p; i++){
                    res[i] = new JLabel();
                }
                int check[] = new int[p];

                for (int i = 0; i < p; i++){
                    res[i].setText("���");
                }

                for (int i = 0; i < f; i++){
                    int temp = r.nextInt(p);
                    if (check[temp] == 0) {
                        res[temp].setText("��");
                        check[temp] = 1;
                    }
                    else {
                        i--;
                        continue;
                    }
                }

                JComboBox cb = (JComboBox)e.getSource();
                p = cb.getSelectedIndex() + 2;

                gap[0] = 300; gap[1] = 150; gap[2] = 100; gap[3] = 75;

                peopleText = new JTextField[p];
                for (int i = 0; i < p; i++){
                    peopleText[i] = new JTextField();
                    peopleText[i].setBounds(10 + (gap[p - 2] * i), 20, 70, 25);
                    draw.add(peopleText[i]);

                }

                repaint();
            }
        });
        add(num_people);

        // ��Ģ �� ��
        JLabel fail = new JLabel("��Ģ ��");
        fail.setFont(new Font("���� ���", Font.PLAIN, 18));
        fail.setBounds(250, 10, 80, 30);
        add(fail);

        //��Ģ �� �޺��ڽ�
        String[] fnum = {"1", "2", "3", "4"};
        num_fail = new JComboBox(fnum);
        num_fail.setBounds(340, 10, 100,30);
        num_fail.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Random r = new Random();
                p = Integer.parseInt(num_people.getSelectedItem().toString());
                f = Integer.parseInt(num_fail.getSelectedItem().toString());
                res = new JLabel[p];
                for (int i = 0; i < p; i++){
                    res[i] = new JLabel();
                }
                int check[] = new int[p];

                for (int i = 0; i < p; i++){
                    res[i].setText("���");
                }

                for (int i = 0; i < f; i++){
                    int temp = r.nextInt(p);
                    if (check[temp] == 0) {
                        res[temp].setText("��");
                        check[temp] = 1;
                    }
                    else {
                        i--;
                        continue;
                    }
                }
            }
        });
        add(num_fail);

        // ��ٸ��� �׷��� �г�
        draw = new DrawPanel();
        draw.setBounds(40, 50, 400, 500);
        add(draw);

        // ��ٸ� ����� ��ư, ���â ��ư
        JButton make = new JButton();
        make.setText("�����");
        make.setBounds(220, 550, 100, 30);


        make.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                p = Integer.parseInt(num_people.getSelectedItem().toString());
                f = Integer.parseInt(num_fail.getSelectedItem().toString());

                if (p <= f){
                    return;
                }

                select = 2; //���μ��� �׸��ڴ�

                Random r = new Random();
                System.out.println("�����"); // for test code

                if(is_start == 2) {
                    for(int i = 0; i < p; i++) {
                        draw.remove(res[i]);
                    }
                }

                is_start = 2;

                leg = new Integer[p - 1][10]; // ��ٸ� �ٸ� (����)
                for (int i = 0; i < p - 1; i++){
                    leg[i] = new Integer[10];
                    for (int j = 0; j < 10; j++){
                        leg[i][j] = new Integer(0);
                    }
                }

                for (int i = 0; i < p * 2; i++){ // �������� �ٸ� ����
                    int l;
                    if (p != 2) l = r.nextInt(p - 1) ;
                    else l = 0;
                    int g = r.nextInt(9);
                    if (l == 0 && p == 2){
                        leg[l][g] = 1;
                    }
                    else if (l == 0 && p > 2) {
                        if (leg[l + 1][g] != 1) {
                            leg[l][g] = 1;
                        } else {
                            continue;
                        }
                    }
                    else if (l == p - 2 && p > 2){
                        if (leg[l - 1][g] != 1) {
                            leg[l][g] = 1;
                        }
                    }
                    else if (p > 2){
                        if (leg[l - 1][g] != 1 && leg[l + 1][g] != 1) {
                            leg[l][g] = 1;
                        }
                    }
                }

                // �ٽ� �׸���
                for(int i = 0; i < p; i++) {
                    res[i].setBounds(30 + (gap[p - 2] * i), 400, 50, 25);
                    draw.add(res[i]);
                }

                repaint();
            }
        });
        add(make);


        JButton result = new JButton();
        result.setText("���Ȯ��");
        result.setBounds(340, 550, 100, 30);
        result.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (p >= 2) {
                    System.out.println("���Ȯ��"); // for test code
                    ArrayList<String> win = new ArrayList<String>(); // �̱���
                    ArrayList<String> lose = new ArrayList<String>(); // �����

                    for (int i = 0; i < p; i++) {
                        int line = i;
                        for (int j = 0; j < 10; j++) {
                            if (line < p - 1 && line > 0) {
                                if (leg[line][j] == 1) {
                                    line += 1;
                                }
                                else if (leg[line - 1][j] == 1){
                                    line -= 1;
                                }
                            } else if (line == 0) {
                                if (leg[line][j] == 1) {
                                    line += 1;
                                }
                            }
                            else if (line == p - 1){
                                if (leg[line - 1][j] == 1){
                                    line -= 1;
                                }
                            }
                        }
                        if (res[line].getText().equals("���")) {
                            win.add(peopleText[i].getText());
                        } else {
                            lose.add(peopleText[i].getText());
                        }
                    }
                    // ���â
                    String wp = "��� : ";
                    winner = new JLabel();
                    winner.setFont(new Font("�������", Font.BOLD, 15));
                    winner.setForeground(Color.green);
                    winner.setBounds(20,70,400,30);
                    for (int i = 0; i < win.size(); i++){
                        wp += win.get(i) + " ";
                    }
                    winner.setText(wp);
                    d.add(winner);

                    String lp = "��   :";
                    loser = new JLabel();
                    loser.setFont(new Font("�������", Font.BOLD, 15));
                    loser.setForeground(Color.red);
                    loser.setBounds(20,150,400,30);
                    for (int i = 0; i < lose.size(); i++){
                        lp += lose.get(i) + " ";
                    }
                    loser.setText(lp);
                    d.add(loser);
                    // ���â ����
                    d.setVisible(true);

                }

            }
        });
        add(result);
        setVisible(true);
    }

    class DrawPanel extends JPanel {

        public void paintComponent (Graphics g) {
            super.paintComponent(g);
            g.setColor(Color.BLUE);

            if(p > 1) { // ���μ� �׸���

                gap[0] = 300; gap[1] = 150; gap[2] = 100; gap[3] = 75;

                int start = 40;

                for(int i = 0; i < p; i++) {
                    g.drawLine(start, 50, start, 400);
                    start += gap[p - 2];
                }

            }

            if(select == 2) { //���μ� �׸���
                for(int i = 0; i < p - 1; i++) {

                    for(int j = 0; j < 10; j++) {
                        if(leg[i][j].equals(1)) {
                            int sx = 40 + (i * gap[p - 2]);
                            int sy = 85 + (j * 35);
                            g.drawLine(sx, sy, sx + gap[p - 2], sy);
                        }

                    }
                }
                select = 1;
            }

        }
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        GhostLeg f = new GhostLeg();
    }

    @Override
    public void actionPerformed(ActionEvent e){
        //��ư �̺�Ʈ
        JButton B = (JButton)e.getSource();

        p = Integer.parseInt(num_people.getSelectedItem().toString());
        f = Integer.parseInt(num_fail.getSelectedItem().toString());
        Random r = new Random();

        /*if (B.getText().equals("�����")){ // "�����" ��ư
            System.out.println("�����"); // for test code
            peopleText = new JTextField[p];
            res = new JLabel[p];
            int check[] = new int[p];
            for (int i = 0; i < p; i++){
                res[i].setText("���");
            }
            for (int i = 0; i < f; i++){
                int temp = r.nextInt(p - 1);
                if (check[temp] == 0) {
                    res[temp].setText("��");
                    check[temp] = 1;
                }
            }
            leg = new Integer[p - 1][10]; // ��ٸ� �ٸ� (����)
            for (int i = 0; i < p * 2; i++){ // �������� �ٸ� ����
                int l = r.nextInt(p - 2) ;
                int g = r.nextInt(9);
                if (leg[l - 1][g] != 1 && leg[l + 1][g] != 1){
                    leg[l][g] = 1;
                }
                else {
                    continue;
                }
            }
            // �ٽ� �׸���
            repaint();
        }*/
        /*if (B.getText().equals("���Ȯ��")){ // ���Ȯ�� ��ư
            System.out.println("���Ȯ��"); // for test code
            ArrayList<String> win = new ArrayList<String>(); // �̱���
            ArrayList<String> lose = new ArrayList<String>(); // �����
            for (int i = 0; i < p; i++){
                int line = i;
                for (int j = 0; j < 10; j++){
                    if (leg[line][j] == 1){
                        line += 1;
                    }
                    else if (line > 0) {
                        if (leg[line - 1][j] == 1){
                            line -= 1;
                        }
                    }
                }
                if (res[line].getText().equals("���")){
                    win.add(peopleText[i].getText());
                }
                else {
                    lose.add(peopleText[i].getText());
                }
            }
            // ���â ����
            final Dialog d = new Dialog(this, "��� Ȯ��!", true);
            d.setSize(300,200);
            d.setLayout(null);
            d.setVisible(true);
        }*/
    }
}