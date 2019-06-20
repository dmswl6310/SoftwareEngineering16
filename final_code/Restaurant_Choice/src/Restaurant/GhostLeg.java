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
        System.out.println("JFrame 생성");
        // 결과창
        final JDialog d = new JDialog(this, "결과 확인!", true);
        d.setSize(400,300);
        d.setLayout(null);
        d.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        JButton ok = new JButton();
        ok.setText("확인");
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

        // JFrame 크기 설정
        setTitle("사다리게임");
        setSize(480,640);
        //setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);
        setResizable(false);
        setLocationRelativeTo(null);

        // 사람수 및 벌칙 수 입력창 생성

        //사람 수 라벨
        JLabel people = new JLabel("인원 수");
        people.setFont(new Font("맑은 고딕", Font.PLAIN, 18));
        people.setBounds(50, 10, 100, 30);
        add(people);

        // 사람 수 콤보박스
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
                    res[i].setText("통과");
                }

                for (int i = 0; i < f; i++){
                    int temp = r.nextInt(p);
                    if (check[temp] == 0) {
                        res[temp].setText("꽝");
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

        // 벌칙 수 라벨
        JLabel fail = new JLabel("벌칙 수");
        fail.setFont(new Font("맑은 고딕", Font.PLAIN, 18));
        fail.setBounds(250, 10, 80, 30);
        add(fail);

        //벌칙 수 콤보박스
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
                    res[i].setText("통과");
                }

                for (int i = 0; i < f; i++){
                    int temp = r.nextInt(p);
                    if (check[temp] == 0) {
                        res[temp].setText("꽝");
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

        // 사다리가 그려질 패널
        draw = new DrawPanel();
        draw.setBounds(40, 50, 400, 500);
        add(draw);

        // 사다리 만들기 버튼, 결과창 버튼
        JButton make = new JButton();
        make.setText("만들기");
        make.setBounds(220, 550, 100, 30);


        make.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                p = Integer.parseInt(num_people.getSelectedItem().toString());
                f = Integer.parseInt(num_fail.getSelectedItem().toString());

                if (p <= f){
                    return;
                }

                select = 2; //가로선만 그리겠다

                Random r = new Random();
                System.out.println("만들기"); // for test code

                if(is_start == 2) {
                    for(int i = 0; i < p; i++) {
                        draw.remove(res[i]);
                    }
                }

                is_start = 2;

                leg = new Integer[p - 1][10]; // 사다리 다리 (가로)
                for (int i = 0; i < p - 1; i++){
                    leg[i] = new Integer[10];
                    for (int j = 0; j < 10; j++){
                        leg[i][j] = new Integer(0);
                    }
                }

                for (int i = 0; i < p * 2; i++){ // 랜덤으로 다리 생성
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

                // 다시 그리기
                for(int i = 0; i < p; i++) {
                    res[i].setBounds(30 + (gap[p - 2] * i), 400, 50, 25);
                    draw.add(res[i]);
                }

                repaint();
            }
        });
        add(make);


        JButton result = new JButton();
        result.setText("결과확인");
        result.setBounds(340, 550, 100, 30);
        result.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (p >= 2) {
                    System.out.println("결과확인"); // for test code
                    ArrayList<String> win = new ArrayList<String>(); // 이긴사람
                    ArrayList<String> lose = new ArrayList<String>(); // 진사람

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
                        if (res[line].getText().equals("통과")) {
                            win.add(peopleText[i].getText());
                        } else {
                            lose.add(peopleText[i].getText());
                        }
                    }
                    // 결과창
                    String wp = "통과 : ";
                    winner = new JLabel();
                    winner.setFont(new Font("맑은고딕", Font.BOLD, 15));
                    winner.setForeground(Color.green);
                    winner.setBounds(20,70,400,30);
                    for (int i = 0; i < win.size(); i++){
                        wp += win.get(i) + " ";
                    }
                    winner.setText(wp);
                    d.add(winner);

                    String lp = "꽝   :";
                    loser = new JLabel();
                    loser.setFont(new Font("맑은고딕", Font.BOLD, 15));
                    loser.setForeground(Color.red);
                    loser.setBounds(20,150,400,30);
                    for (int i = 0; i < lose.size(); i++){
                        lp += lose.get(i) + " ";
                    }
                    loser.setText(lp);
                    d.add(loser);
                    // 결과창 띄우기
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

            if(p > 1) { // 세로선 그리기

                gap[0] = 300; gap[1] = 150; gap[2] = 100; gap[3] = 75;

                int start = 40;

                for(int i = 0; i < p; i++) {
                    g.drawLine(start, 50, start, 400);
                    start += gap[p - 2];
                }

            }

            if(select == 2) { //가로선 그리기
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
        //버튼 이벤트
        JButton B = (JButton)e.getSource();

        p = Integer.parseInt(num_people.getSelectedItem().toString());
        f = Integer.parseInt(num_fail.getSelectedItem().toString());
        Random r = new Random();

        /*if (B.getText().equals("만들기")){ // "만들기" 버튼
            System.out.println("만들기"); // for test code
            peopleText = new JTextField[p];
            res = new JLabel[p];
            int check[] = new int[p];
            for (int i = 0; i < p; i++){
                res[i].setText("통과");
            }
            for (int i = 0; i < f; i++){
                int temp = r.nextInt(p - 1);
                if (check[temp] == 0) {
                    res[temp].setText("꽝");
                    check[temp] = 1;
                }
            }
            leg = new Integer[p - 1][10]; // 사다리 다리 (가로)
            for (int i = 0; i < p * 2; i++){ // 랜덤으로 다리 생성
                int l = r.nextInt(p - 2) ;
                int g = r.nextInt(9);
                if (leg[l - 1][g] != 1 && leg[l + 1][g] != 1){
                    leg[l][g] = 1;
                }
                else {
                    continue;
                }
            }
            // 다시 그리기
            repaint();
        }*/
        /*if (B.getText().equals("결과확인")){ // 결과확인 버튼
            System.out.println("결과확인"); // for test code
            ArrayList<String> win = new ArrayList<String>(); // 이긴사람
            ArrayList<String> lose = new ArrayList<String>(); // 진사람
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
                if (res[line].getText().equals("통과")){
                    win.add(peopleText[i].getText());
                }
                else {
                    lose.add(peopleText[i].getText());
                }
            }
            // 결과창 띄우기
            final Dialog d = new Dialog(this, "결과 확인!", true);
            d.setSize(300,200);
            d.setLayout(null);
            d.setVisible(true);
        }*/
    }
}